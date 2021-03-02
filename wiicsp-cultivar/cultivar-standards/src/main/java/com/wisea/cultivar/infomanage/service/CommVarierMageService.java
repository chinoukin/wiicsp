package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.CommMageMapper;
import com.wisea.cultivar.common.dao.CommVarietMageMapper;
import com.wisea.cultivar.common.entity.CommMage;
import com.wisea.cultivar.common.entity.CommVarietMage;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.po.product.CommVarietMageInsertPo;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import com.wisea.cultivar.common.po.product.CommVarietMagePagePo;
import com.wisea.cultivar.common.utils.CommUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 商品品种业务层
 * @author: wangs
 * @date :2019/4/15
 */
@Service
@Transactional(readOnly = true)
public class CommVarierMageService {

    @Autowired
    CommVarietMageMapper commVarietMageMapper;
    @Autowired
    CommMageMapper commMageMapper;

    /**
     * 查询所有品种信息
     *
     * @param commVarietMagePagePo
     * @return
     */
    public ResultPoJo<Page<CommVarietMageListVo>> findCommVarierMageList(CommVarietMagePagePo commVarietMagePagePo) {

        ResultPoJo<Page<CommVarietMageListVo>> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<CommVarietMageListVo> page = commVarietMagePagePo.getPage();
        List<CommVarietMageListVo> list = new ArrayList<>();
        List<Long> ids = new ArrayList<>();
        if(ConverterUtil.isNotEmpty(commVarietMagePagePo.getCommId()) && ConverterUtil.isNotEmpty(commVarietMagePagePo.getPid())){
            if (commVarietMagePagePo.getPid() == 0) {
                CommMage one = new CommMage();
                one.setId(commVarietMagePagePo.getCommId());
                List<CommMage> mageList = getMageList(one, new ArrayList<CommMage>());
                for (CommMage commMage : mageList) {
                    ids.add(commMage.getId());
                }
                ids.add(commVarietMagePagePo.getCommId());
                commVarietMagePagePo.setCommIds(ids);
                list=commVarietMageMapper.findTwoLevelList(commVarietMagePagePo);
                //list = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
            }else if(commMageMapper.selectByPrimaryKey(commVarietMagePagePo.getPid()).getPid() == 0){
                //根据pid去查主键，如果查到的数据为0说明是二级分类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(commVarietMagePagePo.getCommId());

                for (int i = 0; i < mageByParentId.size(); i++) {
                    ids.add(mageByParentId.get(i).getId());
                }
                ids.add(commVarietMagePagePo.getCommId());
                commVarietMagePagePo.setCommIds(ids);
                list=commVarietMageMapper.findTwoLevelList(commVarietMagePagePo);
            }else {
                List<CommVarietMageListVo> commVarierMageList = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
                list.addAll(commVarierMageList);
            }
        } else {
            // 查询全部
            list = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
        }

       /* // 传入的commId为第二级id
        if (ConverterUtil.isNotEmpty(commVarietMagePagePo.getCommId()) && ConverterUtil.isNotEmpty(commVarietMagePagePo.getPid())) {
            CommMage commMage = commMageMapper.selectByPrimaryKey(commVarietMagePagePo.getCommId());
            if (commVarietMagePagePo.getPid().equals(commMage.getPid()) && commVarietMagePagePo.getPid() != 0) {
                // 根据pid 查询对应的第三级品类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(commVarietMagePagePo.getCommId());
                CommVarietMagePagePo commVar = new CommVarietMagePagePo();
                for (CommMage commMa : mageByParentId) {
                    commVar.setCommId(commMa.getId());
                    List<CommVarietMageListVo> commVarierMageList = commVarietMageMapper.findCommVarierMageList(commVar);
                    list.addAll(commVarierMageList);
                }
            } else if (commVarietMagePagePo.getPid() == 0) {
                // 说明是第一级分类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(commVarietMagePagePo.getCommId());
                CommVarietMagePagePo commVar = new CommVarietMagePagePo();
                for (CommMage comm : mageByParentId) {
                    List<CommMage> mageBy = commMageMapper.findMageByParentId(comm.getId());
                    for (CommMage mage : mageBy) {
                        commVar.setCommId(mage.getId());
                        List<CommVarietMageListVo> commVarierMageList = commVarietMageMapper.findCommVarierMageList(commVar);
                        list.addAll(commVarierMageList);
                    }
                }
                List<CommVarietMageListVo> commVarierMageList = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
                list.addAll(commVarierMageList);
            }
        } else {
            // 查询全部
            list = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
        }*/
        page.setList(list);

        poJo.setResult(page);

        return poJo;
    }

    /**
     * TODO:获取所有子集分类
     * Author: xiehy
     * Date: 2020/8/25 16:40
     */
    public List<CommMage> getMageList(CommMage one, List<CommMage> listout){
        List<CommMage> list = commMageMapper.findMageByParentId(one.getId());
        if(list.size()>0){
            listout.addAll(list);
            for (CommMage commMage : list) {
                getMageList(commMage,listout);
            }
        }
        return listout;
    }
    /**
     * 查询所有品种信息不显示分页信息
     *
     * @param commVarietMagePagePo
     * @return
     */
    public ResultPoJo<List<CommVarietMageListVo>> findCommVarierMageListNoPage(CommVarietMagePagePo commVarietMagePagePo) {

        ResultPoJo<List<CommVarietMageListVo>> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        List<CommVarietMageListVo> list = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);

        poJo.setResult(list);

        return poJo;
    }

    /**
     * 新增和修改商品品种
     *
     * @param commVarietMageInsertPo
     * @return
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<?> saveOrUpdate(CommVarietMageInsertPo commVarietMageInsertPo) {

        ResultPoJo<?> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        CommVarietMage commVarietMage = new CommVarietMage();
        // 复制商品品种属性
        ConverterUtil.copyProperties(commVarietMageInsertPo, commVarietMage);

        // 验证商品品种名称是否重复
        CommVarietMage checkEntity = commVarietMageMapper.insertCheckCommVarierMage(commVarietMage);

        if (ConverterUtil.isEmpty(checkEntity)) {
            // 修改操作
            if (ConverterUtil.isNotEmpty(commVarietMage.getId())) {

                commVarietMage.preUpdate();
                // 更新商品信息
                commVarietMageMapper.updateByPrimaryKeySelective(commVarietMage);
            } else {
                commVarietMage.preInsert();
                commVarietMageMapper.insertSelective(commVarietMage);
            }

        } else {

            poJo.setCode(ConstantCodeMsg.ERR_363);
            poJo.setMsg(ConstantCodeMsg.MSG_363);
        }
        return poJo;
    }

    /**
     * 查询品种详情
     *
     * @param po
     * @return
     */
    public ResultPoJo<CommVarietMage> findCommMageInfo(LongIdPo po) {

        ResultPoJo<CommVarietMage> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        CommVarietMage commVarietMage = commVarietMageMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(commVarietMage)) {
            // 组装分类等级id方便前端使用
            String commMageNames = CommUtils.getCommMageNames(commVarietMage.getCommId());
            String[] a = commMageNames.split("-");
            commVarietMage.setCommCatgId(a[1]);
        }
        poJo.setResult(commVarietMage);
        return poJo;
    }

    /**
     * 删除品种信息
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<?> delete(LongIdPo po) {
        ResultPoJo<CommVarietMage> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        // 查询品种分类关联的商品（该品种 已关联商品，不能删除）
        Integer count = commMageMapper.selectCommVaritPubCount(po.getId());
        System.err.println(count);
        if (count > 0) {
            // 该品种 已关联商品，不能删除
            poJo.setMsg(ConstantCodeMsg.MSG_351);
            poJo.setCode(ConstantCodeMsg.ERR_351);
        } else {
            CommVarietMage commVarietMage = new CommVarietMage();
            commVarietMage.setId(po.getId());
            commVarietMage.preUpdate();
            commVarietMage.setDelFlag("1");
            commVarietMageMapper.updateByPrimaryKeySelective(commVarietMage);
        }
        return poJo;
    }

    @Transactional(readOnly = false)
    public ResultPoJo<?> delAll(DelAllPo po) {

            for (Long id : po.getIds()) {
                LongIdPo longIdPo = new LongIdPo();
                longIdPo.setId(id);
                this.delete(longIdPo);
            }

        return new ResultPoJo<>(ConstantError.NOMAL);
    }
}
