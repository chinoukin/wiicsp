package com.wisea.transac.tp.product.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.CommMageMapper;
import com.wisea.transac.common.dao.CommSaleSetMapper;
import com.wisea.transac.common.entity.CommMage;
import com.wisea.transac.common.entity.CommSaleSet;
import com.wisea.transac.common.po.product.CommMageInsertPo;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.utils.CacheUtil;
import com.wisea.transac.common.vo.product.CommMageTreeModelVo;
import com.wisea.transac.common.vo.product.CommMageTreeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础品类信息
 */
@Service
public class CommMageService extends BaseService {

    @Autowired
    CommMageMapper commMageMapper;
    @Autowired
    CommSaleSetMapper commSaleSetMapper;

    /**
     * 查询基础品类信息
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<CommMageTreeVo>> findCommMageTree(CommMageTreePo po) {
        ResultPoJo<List<CommMageTreeVo>> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<CommMageTreeVo> commMageTree = CacheUtil.getCommMageTree();
        if (ConverterUtil.isEmpty(po.getQuery()) && ConverterUtil.isEmpty(po.getEffeInvalState())) {
            poJo.setResult(commMageTree);
        } else {
            List<CommMageTreeVo> list = TreeUtils.treeToList(commMageTree, CommMageTreeModelVo.class);
            List<CommMageTreeVo> newList = Lists.newArrayList();
            if (ConverterUtil.isNotEmpty(po.getQuery()) && ConverterUtil.isNotEmpty(po.getEffeInvalState())) {
                newList = list.stream().filter(e -> e.getCommCatgName().indexOf(po.getQuery()) >= 0 && e.getEffeInvalState().equals(po.getEffeInvalState())).collect(Collectors.toList());
            } else if (ConverterUtil.isNotEmpty(po.getQuery())) {
                newList = list.stream().filter(e -> e.getCommCatgName().indexOf(po.getQuery()) >= 0).collect(Collectors.toList());
            } else if (ConverterUtil.isNotEmpty(po.getEffeInvalState())) {
                newList = list.stream().filter(e -> e.getEffeInvalState().equals(po.getEffeInvalState())).collect(Collectors.toList());
            }
            poJo.setResult(newList);
        }
        return poJo;
    }

    /**
     * 添加或修改基础品类
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> saveOrUpdate(CommMageInsertPo po) {
        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        CommMage commMage = new CommMage();
        BeanUtils.copyProperties(po, commMage);

        CommMageTreeVo node = TreeUtils.findNode(CacheUtil.getCommMageTree(), CommMageTreeModelVo.class, true, (e) -> {
            if (po.getCommCatgName().equals(e.getCommCatgName())) {
                return e;
            } else {
                return null;
            }
        });

        if (ConverterUtil.isEmpty(commMage.getId())) {
            if (ConverterUtil.isNotEmpty(node)) {
                // 分类名称重复
                poJo.setCode(ConstantCodeMsg.ERR_364);
                poJo.setMsg(MessageFormat.format(ConstantCodeMsg.MSG_364, po.getCommCatgName()));
                return poJo;
            }
            // 新增操作
            commMage.preInsert();
            commMageMapper.insert(commMage);
        } else {
            // 查询是否关联了销售分类配置,根据标准品类id
            LongIdPo longIdPo = new LongIdPo();
            longIdPo.setId(commMage.getId());
            List<CommSaleSet> list = commSaleSetMapper.findSalesClassReleaseByCommId(longIdPo);
            if (ConverterUtil.isNotEmpty(node) && !node.getId().equals(po.getId())) {
                // 分类名称重复
                poJo.setCode(ConstantCodeMsg.ERR_364);
                poJo.setMsg(MessageFormat.format(ConstantCodeMsg.MSG_364, po.getCommCatgName()));
                return poJo;
            }
            if (ConverterUtil.isNotEmpty(list)) {
                poJo.setCode(ConstantCodeMsg.ERR_350);
                poJo.setMsg(ConstantCodeMsg.MSG_350);
                return poJo;
            }
            // 修改操作
            commMage.preUpdate();
            commMageMapper.updateByPrimaryKeySelective(commMage);
        }
        // 更新缓存
        CacheUtil.updateCommMageTree();
        return poJo;
    }

    /**
     * 查询基础品类详情
     *
     * @param po
     * @return
     */
    public ResultPoJo<CommMage> findCommMageInfo(LongIdPo po) {
        ResultPoJo<CommMage> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        poJo.setResult(commMageMapper.selectByPrimaryKey(po.getId()));
        return poJo;
    }

    /**
     * 删除商品分类（父节点不可删除，存在【已上架】、【未上架】的商品，不能删除）
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> del(LongIdPo po) {
        ResultPoJo<CommMage> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<CommMageTreeVo> commMageTree = CacheUtil.getCommMageTree();
        CommMageTreeVo node = TreeUtils.findNode(commMageTree, CommMageTreeModelVo.class, false, (e) -> {
            if (po.getId().equals(e.getId())) {
                return e;
            } else {
                return null;
            }
        });
        if (ConverterUtil.isNotEmpty(node)) {
            // 查询是否关联了销售分类配置,根据标准品类id
            List<CommSaleSet> list = commSaleSetMapper.findSalesClassReleaseByCommId(po);
            if (ConverterUtil.isNotEmpty(node.getChildren()) || ConverterUtil.isNotEmpty(list)) {
                // 存在子节点不能删除
                poJo.setMsg(ConstantCodeMsg.MSG_366);
                poJo.setCode(ConstantCodeMsg.ERR_366);
            } else {
                // 查询商品分类关联的商品（该商品分类已关联商品，不能删除）
                Integer count = commMageMapper.selectCommPubCount(po.getId());
                if (count > 0) {
                    // 该商品分类下存在状态为【已上架】、【未上架】的商品，不能删除
                    poJo.setMsg(ConstantCodeMsg.MSG_365);
                    poJo.setCode(ConstantCodeMsg.ERR_365);
                } else {
                    CommMage commMage = new CommMage();
                    commMage.setId(po.getId());
                    commMage.preUpdate();
                    commMage.setDelFlag("1");
                    commMageMapper.updateByPrimaryKeySelective(commMage);
                    // 更新缓存
                    CacheUtil.updateCommMageTree();
                }
            }
        } else {
            poJo.setMsg(ConstantCodeMsg.MSG_004);
            poJo.setCode(ConstantCodeMsg.ERR_004);
        }
        return poJo;
    }

}
