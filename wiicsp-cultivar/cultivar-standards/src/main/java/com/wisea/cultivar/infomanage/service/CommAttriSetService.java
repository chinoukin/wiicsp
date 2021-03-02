package com.wisea.cultivar.infomanage.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.product.CommAttriSetGetPo;
import com.wisea.cultivar.common.po.product.CommAttriSetPagePo;
import com.wisea.cultivar.common.po.product.CommMageGetPo;
import com.wisea.cultivar.common.po.product.CommTree;
import com.wisea.cultivar.common.vo.product.*;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.CommAttriMageMapper;
import com.wisea.cultivar.common.dao.CommAttriSetMapper;
import com.wisea.cultivar.common.dao.CommMageMapper;
import com.wisea.cultivar.common.entity.ZhfwCommAttriSet;
import com.wisea.cultivar.common.entity.CommMage;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.utils.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 基础品类 - 属性设置
 * @author: wangs
 * @date :2020/4/28
 */
@Service
@Transactional(readOnly = true)
public class CommAttriSetService {

    @Autowired
    CommAttriMageMapper commAttriMageMapper;
    @Autowired
    CommAttriSetMapper commAttriSetMapper;
    @Autowired
    CommMageMapper commMageMapper;

    /**
     * 查询商品和属性关联的列表
     */
    public Page<CommAttriSetListVo> commAttriSetList(CommAttriSetPagePo po) {


        ResultPoJo<Page<CommVarietMageListVo>> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<CommAttriSetListVo> page = po.getPage();
        List<CommAttriSetListVo> list = new ArrayList<>();
        if(ConverterUtil.isNotEmpty(po.getClassifyId()) && ConverterUtil.isNotEmpty(po.getPid())){
            if (po.getPid() == 0) {
                //pid为0时说明是父分类，查询全部数据
                po.setClassifyId(null);
                po.setPid(null);
                // 查询全部
                list = commAttriSetMapper.commAttriSetList(po);
            }else if(commMageMapper.selectByPrimaryKey(po.getPid()).getPid() == 0){
                //根据pid去查主键，如果查到的数据为0说明是二级分类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(po.getClassifyId());
                List<Long> ids = new ArrayList<>();
                for (int i = 0; i < mageByParentId.size(); i++) {
                    ids.add(mageByParentId.get(i).getId());
                }
                ids.add(po.getClassifyId());
                po.setCommIds(ids);
                list=commAttriSetMapper.findTwoLevelList(po);
            }else {
                list= commAttriSetMapper.commAttriSetList(po);
            }
        } else {
            // 查询全部
            list = commAttriSetMapper.commAttriSetList(po);
        }
        /*// 是品类的第二级
        if (ConverterUtil.isNotEmpty(po.getClassifyId()) && ConverterUtil.isNotEmpty(po.getPid())) {
            CommMage commMage = commMageMapper.selectByPrimaryKey(po.getClassifyId());
            if (po.getPid().equals(commMage.getPid()) && po.getPid() != 0) {
                // 根据pid 查询对应的第三级品类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(po.getClassifyId());
                CommAttriSetPagePo commVar = new CommAttriSetPagePo();
                selectByCommId(po, list, commVar, mageByParentId);
            } else if (po.getPid() == 0) {
                // 说明是第一级分类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(po.getClassifyId());
                // 点击第一级的时候添加点击的本身
                mageByParentId.add(commMage);
                CommAttriSetPagePo commVar = new CommAttriSetPagePo();
                for (CommMage comm : mageByParentId) {
                    List<CommMage> mageBy = commMageMapper.findMageByParentId(comm.getId());
                    selectByCommId(po, list, commVar, mageBy);
                }
            }
        } else {
            // 查询全部
            list = commAttriSetMapper.commAttriSetList(po);
        }*/
        for (CommAttriSetListVo commAttri : list) {
            if (ConverterUtil.isEmpty(commAttri.getSort())) {
                //将时间转化为毫秒
                OffsetDateTime createDate = commAttri.getCreateDate();
                long aLong = createDate.getLong(ChronoField.INSTANT_SECONDS);
                commAttri.setSortLong(aLong);
            } else {
                commAttri.setSortLong(Long.parseLong(commAttri.getSort().toString()));
            }
        }
        List<CommAttriSetListVo> commAttriMageListVos = list.stream().
                sorted(Comparator.comparing(CommAttriSetListVo::getSortLong)).collect(Collectors.toList());

        page.setList(commAttriMageListVos);
        return page;
    }

    /**
     * 循环查询对应的属性设置
     *
     * @param po
     * @param list
     * @param commVar
     * @param mageBy
     */
    private void selectByCommId(CommAttriSetPagePo po, List<CommAttriSetListVo> list, CommAttriSetPagePo commVar, List<CommMage> mageBy) {
        for (CommMage mage : mageBy) {
            commVar.setClassifyId(mage.getId());
            // 增加条件是否必填
            if (ConverterUtil.isNotEmpty(po.getIfRequ())) {
                commVar.setIfRequ(po.getIfRequ());
            }
            List<CommAttriSetListVo> commAttriSetListVos = commAttriSetMapper.commAttriSetList(commVar);
            list.addAll(commAttriSetListVos);
        }
    }

    /**
     * 为商品设置属性之前需要查询出商品分类列表和属性列表
     */
    public ResultPoJo<InsertCommAttriSetVo> beforeInsert(Long pid) {
        ResultPoJo<InsertCommAttriSetVo> poJo = new ResultPoJo<>();
        InsertCommAttriSetVo vo = new InsertCommAttriSetVo();
        //转化为树
        List<CommTree> commMageGetVoTree = TreeUtils.listToTree(commAttriMageMapper.beforeInsertGetCatgList());
        List<CommTree> commMageGetVos = new ArrayList<>();
        for (CommTree commMageGetVo : commMageGetVoTree) {
            if(commMageGetVo.getId()==pid){
                commMageGetVos.add(commMageGetVo);
            }
        }
        List<CommAttriMageGetVo> commAttriMageGetVos = commAttriMageMapper.beforeInsertAttriList();
        vo.setCommAttriMageListVoList(commAttriMageGetVos);
        vo.setCommMageListVoList(commMageGetVos);
        poJo.setResult(vo);
        return poJo;
    }

    /**
     * 为商品设置属性
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo commAttriSetAdd(ZhfwCommAttriSet po) {
        ResultPoJo poJo = decideCommWhetherAttri(po);
        if (poJo.getCode().equals("316")) {
            return poJo;
        }
        po.preInsert();
        commAttriSetMapper.insertSelective(po);
        return poJo;
    }

    /**
     * 编辑商品分类属性设置
     */
    public ResultPoJo<CommAttriSetGetVo> editCommAttriSet(CommAttriSetGetPo po) {
        ResultPoJo<CommAttriSetGetVo> poJo = new ResultPoJo<>();
        StringBuffer buffer = new StringBuffer();

        CommAttriSetGetVo commAttriSetGetVo = commAttriSetMapper.editCommAttriSet(po);

        // 得到商品集合
        List<CommTree> commMageGetVos = commAttriMageMapper.beforeInsertGetCatgList();
        // 转化为树结构
        List<CommTree> commMageGetVoTree = TreeUtils.listToTree(commMageGetVos);
        // 处理商品树传给前端一个字符串
        for (CommTree tree : commMageGetVoTree) {
            if (tree.getId().equals(commAttriSetGetVo.getCommId())) {
                buffer.append(tree.getId() + ",");
                commAttriSetGetVo.setCommodity(buffer.toString());
                poJo.setResult(commAttriSetGetVo);
                return poJo;
            }
            for (CommTree tree2 : tree.getChildren()) {
                if (tree2.getId().equals(commAttriSetGetVo.getCommId())) {
                    buffer.append(tree.getId() + "," + tree2.getId() + ",");
                }
                for (CommTree tree3 : tree2.getChildren()) {
                    if (tree3.getId().equals(commAttriSetGetVo.getCommId())) {
                        buffer.append(tree.getId() + "," + tree3.getParentId() + "," + tree3.getId() + ",");
                    }
                }
            }
        }
        commAttriSetGetVo.setCommodity(buffer.toString());
        poJo.setResult(commAttriSetGetVo);
        return poJo;
    }

    /**
     * 修改商品属性设置
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo modifyCommAttriSet(ZhfwCommAttriSet po) {
        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        po.preUpdate();
        commAttriSetMapper.updateByPrimaryKeySelective(po);
        return poJo;
    }

    /**
     * 删除商品分类已经建立的属性
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo delCommAttriSet(ZhfwCommAttriSet po) {
        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        po.preUpdate();
        commAttriSetMapper.deleteLogic(po);
        return poJo;
    }

    /**
     * 根据商品分类id查询商品属性设置列表
     */
    public ResultPoJo<List<CommAttriMageListVo>> findCommAttSetListByMageId(CommMageGetPo po) {
        ResultPoJo<List<CommAttriMageListVo>> poJo = new ResultPoJo<>();
        List<Long> list = CommUtils.getCommMageNamesId(po.getId());
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("list", list);
        //通过带过来的商品分类ID去查询对象的属性
        List<CommAttriMageListVo> attriIdList = commAttriSetMapper.findAttSetListByCommId(paramMap);
        poJo.setResult(attriIdList);
        return poJo;
    }

    /**
     * 用来判断属性是否已经被商品分类关联
     *
     * @param po
     * @return String
     */
    public ResultPoJo decideCommWhetherAttri(ZhfwCommAttriSet po) {
        ResultPoJo<Object> poJo = new ResultPoJo<>();

        List<ZhfwCommAttriSet> decideByCommId;

        //通过传入的po中的商品分类ID和属性ID去查询是否已经建立关联

        //先要查询商品分类ID的所有父类ID
        List<Long> parentIds = CommUtils.getCommMageNamesId(po.getCommId());
        if (parentIds != null) {
            decideByCommId = commAttriSetMapper.findAttriByCommId(parentIds);
        } else {
            //如果等于NULL的话直接用当前商品分类ID去查询
            decideByCommId = commAttriSetMapper.findDecideByCommId(po.getCommId());
        }
        //遍历集合看是否存在属性ID
        for (ZhfwCommAttriSet decide : decideByCommId) {
            if (decide.getAttriId().equals(po.getAttriId())) {
                poJo.setCode(ConstantCodeMsg.ERR_316);
                poJo.setMsg(ConstantCodeMsg.MSG_316);
                return poJo;
            }
        }

        return poJo;
    }
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo delAll(DelAllPo po) {
        try{
            for (Long id : po.getIds()) {
                ZhfwCommAttriSet zhfwCommAttriSet = new ZhfwCommAttriSet();
                zhfwCommAttriSet.setId(id);
                delCommAttriSet(zhfwCommAttriSet);

            }
        }catch (Exception e){
            ResultPoJo resultPoJo = new ResultPoJo();
            resultPoJo.setCode("500");
            return resultPoJo;
        }
        return new ResultPoJo<>(ConstantError.NOMAL);
    }
}
