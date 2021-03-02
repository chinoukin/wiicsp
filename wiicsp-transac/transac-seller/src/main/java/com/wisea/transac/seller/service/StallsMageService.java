package com.wisea.transac.seller.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BaseException;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.StallsMageMapper;
import com.wisea.transac.common.dao.StallsStaffRelaMageMapper;
import com.wisea.transac.common.dao.StallsVideoMageMapper;
import com.wisea.transac.common.entity.StallsMage;
import com.wisea.transac.common.mss.RemoteCustomerMss;
import com.wisea.transac.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.transac.common.po.product.CommPubInfoPagePo;
import com.wisea.transac.common.po.seller.StallsMagePageListPo;
import com.wisea.transac.common.po.seller.StallsMagePo;
import com.wisea.transac.common.utils.SellerMembUtils;
import com.wisea.transac.seller.mss.ProductMss;
import com.wisea.transac.common.vo.seller.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className StallsMageService
 * @date 2020/04/27 17:01:28
 * @Description
 */
@Service
public class StallsMageService extends BaseService {
    @Autowired
    private StallsMageMapper mapper;
    @Autowired
    private StallsVideoMageMapper stallsVideoMageMapper;
    @Autowired
    private RemoteCustomerMss remoteCustomerMss;
    @Autowired
    private StallsStaffRelaMageMapper stallsStaffRelaMageMapper;
    @Autowired
    private ProductMss productMss;
    @Autowired
    private ShopInfoService shopInfoService;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsMage
     */
    public ResultPoJo<Page<StallsMagePageListVo>> findPageList(StallsMagePageListPo po) {
        ResultPoJo<Page<StallsMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getCommId()) && ConverterUtil.isEmpty(po.getTradAreaId())) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("交易区ID不能为空");
            return resultPoJo;
        }
        Page<StallsMagePageListVo> page = po.getPage();
        List<StallsMagePageListVo> list = mapper.findPageList(po);

        list.forEach(i -> {
            if (i.getVideos() != null && i.getVideos().size() > 0) {
                i.setVideoContrl(i.getVideos().get(0).getRemarks());
                Optional<StallsVideoMagePageListVo> opt = i.getVideos().stream()
                        .filter(j -> "0".equals(j.getSetAsCoverFlag()))
                        .findFirst();
                StallsVideoMagePageListVo vo = opt.orElse(i.getVideos().get(0));
                i.setVideoUrl(vo.getAccUrl());
            } else {
                //没有视频当做关闭状态
                i.setVideoContrl("1");
            }

        });

        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 修改后的档口列表信息
     * 店铺的关注数进行排序;  档口下所有商品销量总和 排序;
     */
    public ResultPoJo<Page<StallsMagePageListVo>> findPageStallsList(StallsMagePageListPo po) {
        ResultPoJo<Page<StallsMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getCommId()) && ConverterUtil.isEmpty(po.getTradAreaId())) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("交易区ID不能为空");
            return resultPoJo;
        }
        Page<StallsMagePageListVo> page = po.getPage();
        List<StallsMagePageListVo> list = mapper.findPageList(po);

        list.forEach(i -> {
            LongIdPo idPo = new LongIdPo();
            idPo.setId(i.getShopId());
            //商店基本信息
            ResultPoJo<ShopInfoInfoVo> info = shopInfoService.findInfo(idPo);
            if (info.getResult() == null) {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
                return;
            }
            //统计 关注数
            ResultPoJo<Map<String, Object>> stat = shopInfoService.findShopsStat(info.getResult().getMerchantId());
            Map<String, Object> statResult = stat.getResult();
            Long followCount = (Long) statResult.get("followCount");
            i.setFollowCount(followCount);
            // 统计销售数量
            StallsMageSelesVo stallsMageSelesVo = mapper.salesVolumSumByStallsId(i.getId());
            if (ConverterUtil.isNotEmpty(stallsMageSelesVo)) {
                i.setSalesVolume(stallsMageSelesVo.getSalesVolume());
            }
            if (i.getVideos() != null && i.getVideos().size() > 0) {
                i.setVideoContrl(i.getVideos().get(0).getRemarks());
                Optional<StallsVideoMagePageListVo> opt = i.getVideos().stream()
                        .filter(j -> "0".equals(j.getSetAsCoverFlag()))
                        .findFirst();
                StallsVideoMagePageListVo vo = opt.orElse(i.getVideos().get(0));
                i.setVideoUrl(vo.getAccUrl());
            } else {
                //没有视频当做关闭状态
                i.setVideoContrl("1");
            }

        });
        // 对结果排序
        if (ConverterUtil.isNotEmpty(po.getFollowCount()) && ConverterUtil.isNotEmpty(po.getOrderBy())) {
            if (po.getOrderBy().equals(DictConstants.ASC)) {
                Collections.sort(list, Comparator.comparing(StallsMagePageListVo::getFollowCount));
            } else {
                Collections.sort(list, Comparator.comparing(StallsMagePageListVo::getFollowCount, Comparator.reverseOrder()));
            }
        }
        if (ConverterUtil.isNotEmpty(po.getSalesVolume()) && ConverterUtil.isNotEmpty(po.getOrderBy())) {
            if (po.getOrderBy().equals(DictConstants.ASC)) {
                Collections.sort(list, Comparator.comparing(StallsMagePageListVo::getSalesVolume));
            } else {
                Collections.sort(list, Comparator.comparing(StallsMagePageListVo::getSalesVolume, Comparator.reverseOrder()));
            }
        }
        if (ConverterUtil.isNotEmpty(po.getQuery())) {
            List<StallsMagePageListVo> newList = Lists.newArrayList();
            newList = list.stream().filter(e -> e.getStallsName().indexOf(po.getQuery()) >= 0).collect(Collectors.toList());
            page.setList(newList);
        } else {
            page.setList(list);
        }
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 逻辑删除StallsMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        StallsMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(StallsMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);

            CommPubInfoPagePo commPubInfoPagePo = new CommPubInfoPagePo();
            commPubInfoPagePo.setStallsMageIds(Arrays.asList(entity.getId()));
            ResultPoJo poJo = productMss.updateCommPubSearch(commPubInfoPagePo);
            if (!poJo.getCode().equals(ConstantError.NOMAL)) {
                throw new BaseException("999", "删除档口失败");
            }

        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改StallsMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(StallsMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            StallsMage entity = mapper.selectByPrimaryKey(po.getId());
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
            StallsMage entity = new StallsMage();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);

            SysImCustomerConfigInsertPo configInsertPo = new SysImCustomerConfigInsertPo();

            configInsertPo.setGroupId(entity.getId().toString());
            configInsertPo.setType("0");

            configInsertPo.setUserList(new ArrayList<>());

            ResultPoJo<Object> poJo = remoteCustomerMss.customerConfigInsert(configInsertPo);
            if (!poJo.getCode().equals(ConstantError.NOMAL)) {
                throw new BusinessException(poJo.getCode(), poJo.getMsg());
            }

        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsMage
     */
    public ResultPoJo<StallsMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<StallsMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        StallsMageInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/7 17:16
     * @Description 查询当前登录用户所有档口列表
     **/
    public ResultPoJo<List<StallsMageListVo>> findByUser() {
        LoggerUtil.infoWithContext("【findByUser】查询当前登录用户所有档口列表：", null);
        ResultPoJo<List<StallsMageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        User user = SystemUtils.getUser();

        List<StallsMageListVo> stallsList = SellerMembUtils.getStallsList(user.getId());
        resultPoJo.setResult(stallsList);
        return resultPoJo;
    }

    /**
     * 上传并修改档口背景图片
     *
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo uploadBackPic(StallsMagePo po) {
        ResultPoJo resultPoJo = new ResultPoJo(ConstantError.NOMAL);
        StallsMage stallsMage = mapper.selectByPrimaryKey(po.getId());
        if (stallsMage == null) {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        if (ConverterUtil.isEmpty(po.getBackGroundUrl())) {
            resultPoJo.setCode("999");
            resultPoJo.setMsg("背景图片不能为空");
            return resultPoJo;
        }
        stallsMage.setBackGroundUrl(po.getBackGroundUrl());
        stallsMage.preUpdate();
        mapper.updateByPrimaryKey(stallsMage);
        return resultPoJo;
    }
}
