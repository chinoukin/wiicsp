package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.model.po.LongIdsPo;
import com.wisea.cultivar.common.dao.EntpAppVersionMageMapper;
import com.wisea.cultivar.common.entity.EntpAppVersionMage;
import com.wisea.cultivar.common.po.AppVersionPo;
import com.wisea.cultivar.common.po.EntpAppVersionMagePageListPo;
import com.wisea.cultivar.common.po.EntpAppVersionMagePo;
import com.wisea.cultivar.common.vo.EntpAppVersionMageInfoVo;
import com.wisea.cultivar.common.vo.EntpAppVersionMagePageListVo;
import com.wisea.cultivar.portal.mapper.UserMageMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className EntpAppVersionMageService
 * @date 2020/05/11 13:38:11
 * @Description
 */
@Service
public class EntpAppVersionMageService extends BaseService {
    @Autowired
    private EntpAppVersionMageMapper mapper;
    @Autowired
    protected UserMageMapper userMageMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 分页查询EntpAppVersionMage
     */
    public ResultPoJo<Page<EntpAppVersionMagePageListVo>> findPageList(EntpAppVersionMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<EntpAppVersionMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<EntpAppVersionMagePageListVo> page = po.getPage();
        String appVersionType = po.getAppVersionType();
        if (appVersionType.equals("2"))  //2代表全部
            po.setAppVersionType(null);
      //  List<EntpAppVersionMagePageListVo> list = mapper.findPageList(po);
        List<EntpAppVersionMagePageListVo> list = mapper.findPageListSelect(po);
       /* list.forEach(i -> {
           // MembBaseInfo baseInfo = MembUtils.getMembInfoByUserId(Long.parseLong(i.getUpdateBy()));
          //  i.setUpdateBy(baseInfo.getLoginName());
            Long uid = ConverterUtil.toLong(i.getUpdateBy());
            String userName = "";
            UserMage entity = userMageMapper.selectByPrimaryKey(uid);
            if (ConverterUtil.isEmpty(entity)) {
                boolean isOperAdmin = SystemUtils.hasAllAuthor(uid, "ROLE_operation_admin");
                if (isOperAdmin) {
                    User adminUser = SystemUtils.getById(uid);
                    userName = adminUser.getLoginName();
                }
            } else {
                userName = entity.getUserName();
            }
            i.setUpdateBy(userName);
        });*/
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 逻辑删除EntpAppVersionMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EntpAppVersionMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(EntpAppVersionMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 新增或修改EntpAppVersionMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(EntpAppVersionMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            EntpAppVersionMage entity = mapper.selectByPrimaryKey(po.getId());
            if (ConverterUtil.isNotEmpty(entity)) {
                BeanUtils.copyProperties(po, entity);
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            } else {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            }
        } else {
            //新增
            EntpAppVersionMage entity = new EntpAppVersionMage();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            entity.preUpdate();
            mapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/05/11 13:38:11
     * @Description 查询详细信息EntpAppVersionMage
     */
    public ResultPoJo<EntpAppVersionMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<EntpAppVersionMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EntpAppVersionMageInfoVo vo = mapper.findInfo(po);
       /* if (ConverterUtil.isNotEmpty(vo)) {
            Long uid = ConverterUtil.toLong(vo.getUpdateBy());
            String userName = "";
            UserMage entity = userMageMapper.selectByPrimaryKey(uid);
            if (ConverterUtil.isEmpty(entity)) {
                boolean isOperAdmin = SystemUtils.hasAllAuthor(uid, "ROLE_operation_admin");
                if (isOperAdmin) {
                    User adminUser = SystemUtils.getById(uid);
                    userName = adminUser.getLoginName();
                }
            } else {
                userName = entity.getUserName();
            }
            vo.setUpdateBy(userName);

        }*/
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    public ResultPoJo<EntpAppVersionMageInfoVo> findLatest(AppVersionPo po) {
        ResultPoJo<EntpAppVersionMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        EntpAppVersionMageInfoVo vo = mapper.findLatest(po);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    public ResultPoJo batDelete(LongIdsPo po) {
        LoggerUtil.infoWithContext("【logicDel】批量删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<Long> ids = po.getIds();
        for (Long id : ids) {
            mapper.batDelete(id);
        }

        return resultPoJo;
    }
}
