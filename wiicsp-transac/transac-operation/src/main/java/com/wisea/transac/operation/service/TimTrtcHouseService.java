package com.wisea.transac.operation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.wisea.transac.operation.entity.TimTrtcHouse;
import com.wisea.transac.operation.entity.TimTrtcHouseAccount;
import com.wisea.transac.operation.mapper.TimTrtcHouseAccountMapper;
import com.wisea.transac.operation.mapper.TimTrtcHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.cloud.tencentim.event.TIMUserLogoutEventInfo;
import com.wisea.transac.operation.po.TimTrtcHouseBatDeletePo;
import com.wisea.transac.operation.po.TimTrtcHouseGetPo;
import com.wisea.transac.operation.po.TimTrtcHouseInsertPo;
import com.wisea.transac.operation.po.TimTrtcHouseListPo;
import com.wisea.transac.operation.po.TimTrtcHousePagePo;
import com.wisea.transac.operation.po.TimTrtcHouseUpdatePo;
import com.wisea.transac.operation.vo.TimTrtcHouseGetVo;
import com.wisea.transac.operation.vo.TimTrtcHouseListVo;

/**
 * TimTrtcHouseService 实时音视频房间表 Service 2020/08/07 17:16:38
 */
@Service
public class TimTrtcHouseService extends BaseService {
    @Autowired
    protected TimTrtcHouseMapper timTrtcHouseMapper;
    @Autowired
    protected TimTrtcHouseAccountMapper timTrtcHouseAccountMapper;

    private static final String maxHouseNumLock = "maxHouseNumLock";

    private static final Map<Long, TimTrtcHouse> houseMap = Maps.newConcurrentMap();

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<TimTrtcHouseListVo>> findPage(TimTrtcHousePagePo timTrtcHousePagePo) {
        ResultPoJo<Page<TimTrtcHouseListVo>> result = new ResultPoJo<>();
        Page<TimTrtcHouseListVo> page = timTrtcHousePagePo.getPage();
        List<TimTrtcHouseListVo> list = timTrtcHouseMapper.findPage(timTrtcHousePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<TimTrtcHouseListVo>> findList(TimTrtcHouseListPo timTrtcHouseListPo) {
        ResultPoJo<List<TimTrtcHouseListVo>> result = new ResultPoJo<>();
        result.setResult(timTrtcHouseMapper.findList(timTrtcHouseListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<TimTrtcHouseGetVo> get(TimTrtcHouseGetPo timTrtcHouseGetPo) {
        ResultPoJo<TimTrtcHouseGetVo> result = new ResultPoJo<>();
        TimTrtcHouse entity = timTrtcHouseMapper.selectByPrimaryKey(timTrtcHouseGetPo.getId());
        TimTrtcHouseGetVo vo = new TimTrtcHouseGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(TimTrtcHouseInsertPo timTrtcHouseInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        TimTrtcHouse timTrtcHouse = new TimTrtcHouse();
        ConverterUtil.copyProperties(timTrtcHouseInsertPo, timTrtcHouse);
        timTrtcHouse.preInsert();
        timTrtcHouseMapper.insert(timTrtcHouse);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(TimTrtcHouseUpdatePo timTrtcHouseUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        TimTrtcHouse timTrtcHouse = new TimTrtcHouse();
        ConverterUtil.copyProperties(timTrtcHouseUpdatePo, timTrtcHouse);
        timTrtcHouse.preUpdate();
        timTrtcHouseMapper.updateByPrimaryKeySelective(timTrtcHouse);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(TimTrtcHouseBatDeletePo timTrtcHouseBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : timTrtcHouseBatDeletePo.getDelList()) {
            TimTrtcHouse timTrtcHouse = new TimTrtcHouse();
            timTrtcHouse.setId(delId);
            timTrtcHouse.preUpdate();
            timTrtcHouseMapper.deleteLogic(timTrtcHouse);
        }
        return result;
    }

    /**
     * 为当前的用户分配一个房间
     *
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<TimTrtcHouseGetVo> dispath() {
        ResultPoJo<TimTrtcHouseGetVo> result = new ResultPoJo<>();
        synchronized (maxHouseNumLock) {
            User loginUser = UserUtils.getUser();
            TimTrtcHouse house = timTrtcHouseMapper.findNotUseHouse();
            // new house
            if (null == house) {
                house = new TimTrtcHouse();
                // get max house num
                int maxHouseNum = timTrtcHouseMapper.findMaxHouseNum();
                int tempHomNum = maxHouseNum + 1;
                if (ConverterUtil.toString(tempHomNum).length() > 9) {
                    throw new VerifyException(ConstantError.ERR_004, "房间号已耗尽，请联系相关人员");
                }
                house.setHouseNum(tempHomNum);
                house.setOnUse(Constants.YES);
                house.preInsert();
                timTrtcHouseMapper.insert(house);
            } else {
                house.setOnUse(Constants.YES);
                house.preUpdate();
                timTrtcHouseMapper.updateByPrimaryKey(house);
            }

            // insert house account
            Long accountId = loginUser.getId();
            TimTrtcHouseAccount account = new TimTrtcHouseAccount();
            account.setHouseId(house.getId());
            account.setAccountId(accountId);
            account.preInsert();
            timTrtcHouseAccountMapper.insert(account);

            TimTrtcHouseGetVo vo = new TimTrtcHouseGetVo();
            ConverterUtil.copyProperties(house, vo);
            result.setResult(vo);
        }
        return result;
    }

    /**
     * 加入音视频房间
     *
     * @param timTrtcHouseUpdatePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> join(TimTrtcHouseUpdatePo timTrtcHouseUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        User loginUser = UserUtils.getUser();
        int houseNum = timTrtcHouseUpdatePo.getHouseNum();
        TimTrtcHouse house = timTrtcHouseMapper.findHouseByNum(houseNum);
        // 房间不存在或已关闭
        if (null == house || Constants.NO.equals(house.getOnUse())) {
            throw new VerifyException(ConstantError.ERR_004, "房间不存在或已关闭");
        }

        // 新增房间成员
        Long accountId = loginUser.getId();
        TimTrtcHouseAccount account = new TimTrtcHouseAccount();
        account.setHouseId(house.getId());
        account.setAccountId(accountId);

        // 判断是否已经在房间中 避免重复数据
        TimTrtcHouseAccount exAccount = timTrtcHouseAccountMapper.getByHouseIdAccountId(account);

        // 如果已经在改房间中 就不用再新增了
        if (null == exAccount) {
            account.preInsert();
            timTrtcHouseAccountMapper.insert(account);
        }

        return result;
    }

    /**
     * 离开实时音视频房间
     *
     * @param timTrtcHouseUpdatePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> leave(TimTrtcHouseUpdatePo timTrtcHouseUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        User loginUser = UserUtils.getUser();
        int houseNum = timTrtcHouseUpdatePo.getHouseNum();
        TimTrtcHouse house = timTrtcHouseMapper.findHouseByNum(houseNum);
        // 房间不存在或已关闭
        if (null == house || Constants.NO.equals(house.getOnUse())) {
            throw new VerifyException(ConstantError.ERR_004, "房间不存在或已关闭");
        }
        houseMap.put(house.getId(), house);

        // 退出房间
        leaveHouse(loginUser.getId(), house.getId());

        return result;
    }

    /**
     * 退出房间
     *
     * @param loginUser
     * @param house
     */
    protected void leaveHouse(Long accountId, Long houseId) {
        TimTrtcHouse house = houseMap.get(houseId);
        // 为每个房间单独加锁
        synchronized (house) {
            // 查询房间号已经入的账户列表
            TimTrtcHouseAccount account = new TimTrtcHouseAccount();
            account.setHouseId(house.getId());
            List<TimTrtcHouseAccount> accList = timTrtcHouseAccountMapper.findListByHouseId(account);
            // 过滤当前用户
            Optional<TimTrtcHouseAccount> delAcc = accList.stream().filter(p -> {
                return p.getAccountId().equals(accountId);
            }).findFirst();

            if (delAcc.isPresent()) {
                // 直接删除关系表数据
                TimTrtcHouseAccount delAccount = delAcc.get();
                timTrtcHouseAccountMapper.deleteByPrimaryKey(delAccount.getId());

                // 如果离开房间后 没有任何人在已进入的列表中 就关闭房间
                accList.remove(delAccount);
                if (accList.size() <= 0) {
                    house.setOnUse(Constants.NO);
                    house.preUpdate();
                    timTrtcHouseMapper.updateByPrimaryKey(house);
                }
            }
            houseMap.remove(houseId);
        }
    }

    /**
     * 用户离线时退出所有已进入的房间
     *
     * @param info
     */
    public void offine(TIMUserLogoutEventInfo info) {
        // 查询退出用户已进入的全部房间信息
        Long accountId = ConverterUtil.toLong(info.getLogoutUserID());
        List<TimTrtcHouse> houseList = timTrtcHouseMapper.findHouseByJoinAccount(accountId);
        if (ConverterUtil.isEmpty(houseList)) {
            return;
        }
        // 退出房间
        for (TimTrtcHouse house : houseList) {
            houseMap.put(house.getId(), house);
            leaveHouse(accountId, house.getId());
        }
    }
}
