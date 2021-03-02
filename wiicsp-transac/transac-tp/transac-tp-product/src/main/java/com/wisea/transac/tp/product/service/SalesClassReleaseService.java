package com.wisea.transac.tp.product.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.CommSaleCatgMapper;
import com.wisea.transac.common.dao.CommSaleSetMapper;
import com.wisea.transac.common.dao.TradAreaCommRelaMageMapper;
import com.wisea.transac.common.entity.CommSaleSet;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.po.product.CommSalesReleasUpdPo;
import com.wisea.transac.common.po.product.CommSalesReleaseInsertPo;
import com.wisea.transac.common.po.product.CommSalesReleasePagePo;
import com.wisea.transac.common.vo.product.CammSalesReleaseMageListVo;
import com.wisea.transac.common.vo.product.CommSalesSetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 销售分类配置
 * @author: wangs
 * @date :2020/4/30
 */
@Service
@Transactional(readOnly = true)
public class SalesClassReleaseService {

    @Autowired
    CommSaleSetMapper commSaleSetMapper;
    @Autowired
    CommSaleCatgMapper commSaleCatgMapper;
    @Autowired
    TradAreaCommRelaMageMapper tradAreaCommRelaMageMapper;

    /**
     * 查询销售品类配置列表
     *
     * @param commSalesReleasePagePo
     * @return
     */
    public ResultPoJo<Page<CammSalesReleaseMageListVo>> findSalesClassReleaseList(CommSalesReleasePagePo commSalesReleasePagePo) {

        ResultPoJo<Page<CammSalesReleaseMageListVo>> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        Page<CammSalesReleaseMageListVo> page = commSalesReleasePagePo.getPage();

        List<CammSalesReleaseMageListVo> list = commSaleSetMapper.findSalesClassReleaseList(commSalesReleasePagePo);

        page.setList(list);

        poJo.setResult(page);

        return poJo;

    }

    /**
     * 关联基础分类- 添加操作
     *
     * @param commSalesReleaseInsertPo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<?> saveOrUpdate(CommSalesReleaseInsertPo commSalesReleaseInsertPo) {

        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if (ConverterUtil.isEmpty(commSalesReleaseInsertPo.getCommMagePoList())) {
            poJo.setCode(ConstantCodeMsg.ERR_362);
            poJo.setMsg(ConstantCodeMsg.MSG_362);
        } else {

            List<CommSaleSet> commSaleSetPoList = Lists.newArrayList();
            commSalesReleaseInsertPo.getCommMagePoList().forEach(e -> {
                CommSaleSet commSaleSet = new CommSaleSet();
                commSaleSet.setCommSaleCatgId(commSalesReleaseInsertPo.getCommSalesCatgId());
                commSaleSet.setCommId(e.getId());
                commSaleSet.setCommName(e.getCommCatgName());
                commSaleSet.setSort(e.getSort());
                commSaleSet.preInsert();
                commSaleSetPoList.add(commSaleSet);
            });
            // 批量插入数据
            commSaleSetMapper.batchInsert(commSaleSetPoList);
        }
        return poJo;

    }

    /**
     * 修改销售分类顺序
     *
     * @param commSalesReleasUpdPo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<?> updateSort(CommSalesReleasUpdPo commSalesReleasUpdPo) {

        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        CommSaleSet commSaleSet = new CommSaleSet();
        commSaleSet.setId(commSalesReleasUpdPo.getId());
        commSaleSet.setSort(commSalesReleasUpdPo.getSort());
        commSaleSetMapper.updateByPrimaryKeySelective(commSaleSet);
        return poJo;
    }

    /**
     * 删除销售分类配置
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<?> del(LongIdPo po) {

        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        // 根据销售分类配置的id 查询是否关联的了商品发布（已关联商品发布，不能删除）
        Integer count = commSaleSetMapper.selectCommPubCount(po.getId());
        if (count > 0) {
            // 该商品分类下存在状态为【已上架】、【未上架】的商品，不能删除
            poJo.setMsg(ConstantCodeMsg.MSG_365);
            poJo.setCode(ConstantCodeMsg.ERR_365);
        }
        // 交易区中是否关联了销售分类设置,如果有关联删除对应关联关系
        Integer areaCommCount = tradAreaCommRelaMageMapper.selectAreaCommRelaCount(po.getId());
        if (areaCommCount > 0) {
            tradAreaCommRelaMageMapper.delBySalesClassRelaId(po.getId());
        }
        // 此处物理删除了.
       // commSaleSetMapper.deleteByPrimaryKey(po.getId());
        CommSaleSet commSaleSet = new CommSaleSet();
        commSaleSet.setId(po.getId());
        commSaleSet.setDelFlag(DictConstants.DEL_FLAG_1);
        commSaleSetMapper.updateByPrimaryKeySelective(commSaleSet);
        return poJo;
    }

    /**
     * 查询销售分类和销售分类配置
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<CommSalesSetVo>> findClassReleaseMage(CommMageTreePo po) {
        ResultPoJo<List<CommSalesSetVo>> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<CommSalesSetVo> commSalesSetVos = commSaleSetMapper.likeQuerySalesSet(po);
        poJo.setResult(commSalesSetVos);
        return poJo;
    }
}




