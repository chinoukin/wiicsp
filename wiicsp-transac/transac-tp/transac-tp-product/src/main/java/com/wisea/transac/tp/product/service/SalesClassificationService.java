package com.wisea.transac.tp.product.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.CommSaleCatgMapper;
import com.wisea.transac.common.dao.CommSaleSetMapper;
import com.wisea.transac.common.entity.CommSaleCatg;
import com.wisea.transac.common.entity.CommSaleSet;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.po.product.CommSaleMageInsertPo;
import com.wisea.transac.common.utils.CacheUtil;
import com.wisea.transac.common.vo.product.SalesClassificationListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 销售品类信息
 * @author: wangs
 * @date :2020/4/30
 */
@Service
@Transactional(readOnly = true)
public class SalesClassificationService {

    @Autowired
    CommSaleCatgMapper commSaleCatgMapper;
    @Autowired
    CommSaleSetMapper commSaleSetMapper;

    /**
     * 查询销售品类信息
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<SalesClassificationListVo>> findCommMageTree(CommMageTreePo po) {
        ResultPoJo<List<SalesClassificationListVo>> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<SalesClassificationListVo> commMageTree = CacheUtil.getSalesClassificationTree();
        if (ConverterUtil.isEmpty(po.getQuery()) && ConverterUtil.isEmpty(po.getEffeInvalState())) {
            poJo.setResult(commMageTree);
        } else {
            List<SalesClassificationListVo> list = TreeUtils.treeToList(commMageTree, SalesClassificationListVo.class);
            List<SalesClassificationListVo> newList = Lists.newArrayList();
            if (ConverterUtil.isNotEmpty(po.getQuery()) && ConverterUtil.isNotEmpty(po.getEffeInvalState())) {
                newList = list.stream().filter(e -> e.getCatgName().indexOf(po.getQuery()) >= 0 && e.getEffeInvalState().equals(po.getEffeInvalState())).collect(Collectors.toList());
            } else if (ConverterUtil.isNotEmpty(po.getQuery())) {
                newList = list.stream().filter(e -> e.getCatgName().indexOf(po.getQuery()) >= 0).collect(Collectors.toList());
            } else if (ConverterUtil.isNotEmpty(po.getEffeInvalState())) {
                newList = list.stream().filter(e -> e.getEffeInvalState().equals(po.getEffeInvalState())).collect(Collectors.toList());
            }
            poJo.setResult(newList);
        }
        return poJo;
    }

    /**
     * 添加或修改销售品类
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(CommSaleMageInsertPo po) {
        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        CommSaleCatg commMage = new CommSaleCatg();
        BeanUtils.copyProperties(po, commMage);

        SalesClassificationListVo node = TreeUtils.findNode(CacheUtil.getSalesClassificationTree(), SalesClassificationListVo.class, true, (e) -> {
            if (po.getCatgName().equals(e.getCatgName())) {
                return e;
            } else {
                return null;
            }
        });

        if (ConverterUtil.isEmpty(po.getId())) {
            if (ConverterUtil.isNotEmpty(node)) {
                // 分类名称重复
                poJo.setCode(ConstantCodeMsg.ERR_364);
                poJo.setMsg(MessageFormat.format(ConstantCodeMsg.MSG_364, po.getCatgName()));
                return poJo;
            }
            // 新增操作
            commMage.preInsert();
            commSaleCatgMapper.insert(commMage);
        } else {
            if (ConverterUtil.isNotEmpty(node) && !node.getId().equals(po.getId())) {
                // 分类名称重复
                poJo.setCode(ConstantCodeMsg.ERR_364);
                poJo.setMsg(MessageFormat.format(ConstantCodeMsg.MSG_364, po.getCatgName()));
                return poJo;
            }
            // 修改操作
            commMage.preUpdate();
            commSaleCatgMapper.updateByPrimaryKeySelective(commMage);
        }
        // 更新缓存
        CacheUtil.updateSalesClassificationTree();
        return poJo;
    }

    /**
     * 查询销售品类详情
     *
     * @param po
     * @return
     */
    public ResultPoJo<CommSaleCatg> findCommMageInfo(LongIdPo po) {
        ResultPoJo<CommSaleCatg> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        poJo.setResult(commSaleCatgMapper.selectByPrimaryKey(po.getId()));
        return poJo;
    }

    /**
     * 删除销售分类（父节点不可删除）
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> del(LongIdPo po) {
        ResultPoJo<CommSaleCatg> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<SalesClassificationListVo> commMageTree = CacheUtil.getSalesClassificationTree();
        SalesClassificationListVo node = TreeUtils.findNode(commMageTree, SalesClassificationListVo.class, false, (e) -> {
            if (po.getId().equals(e.getId())) {
                return e;
            } else {
                return null;
            }
        });
        // 查询是否关联了销售分类配置 如果有,不能直接删除
        List<CommSaleSet> commSaleSetList = commSaleSetMapper.findSalesClassReleaseById(po);
        if (ConverterUtil.isNotEmpty(node)) {
            if (ConverterUtil.isNotEmpty(commSaleSetList)) {
                // 存在子节点不能删除
                poJo.setMsg(ConstantCodeMsg.MSG_366);
                poJo.setCode(ConstantCodeMsg.ERR_366);
            } else {
                // 可以删除
                CommSaleCatg commMage = new CommSaleCatg();
                commMage.setId(po.getId());
                commMage.preUpdate();
                commMage.setDelFlag("1");
                commSaleCatgMapper.updateByPrimaryKeySelective(commMage);
                // 更新缓存
                CacheUtil.updateSalesClassificationTree();
            }
        } else {
            poJo.setMsg(ConstantCodeMsg.MSG_004);
            poJo.setCode(ConstantCodeMsg.ERR_004);
        }
        return poJo;
    }
}
