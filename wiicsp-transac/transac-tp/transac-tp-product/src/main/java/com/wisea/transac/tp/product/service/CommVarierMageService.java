package com.wisea.transac.tp.product.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.CommMageMapper;
import com.wisea.transac.common.dao.CommVarietMageMapper;
import com.wisea.transac.common.entity.CommMage;
import com.wisea.transac.common.entity.CommVarietMage;
import com.wisea.transac.common.po.product.CommVarietMageInsertPo;
import com.wisea.transac.common.po.product.CommVarietMagePagePo;
import com.wisea.transac.common.utils.CommUtils;
import com.wisea.transac.common.vo.product.CommVarietMageListVo;
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
        // 传入的commId为第二级id
        if (ConverterUtil.isNotEmpty(commVarietMagePagePo.getCommId()) && ConverterUtil.isNotEmpty(commVarietMagePagePo.getPid())) {
            CommMage commMage = commMageMapper.selectByPrimaryKey(commVarietMagePagePo.getCommId());
            if (commVarietMagePagePo.getPid().equals(commMage.getPid()) && commVarietMagePagePo.getPid() != 0) {
                // 根据pid 查询对应的第三级品类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(commVarietMagePagePo.getCommId());
                CommVarietMagePagePo commVar = new CommVarietMagePagePo();
                selCommAndVarierMage(commVarietMagePagePo, list, mageByParentId, commVar);
            } else if (commVarietMagePagePo.getPid() == 0) {
                // 说明是第一级分类
                List<CommMage> mageByParentId = commMageMapper.findMageByParentId(commVarietMagePagePo.getCommId());
                CommVarietMagePagePo commVar = new CommVarietMagePagePo();
                for (CommMage comm : mageByParentId) {
                    List<CommMage> mageBy = commMageMapper.findMageByParentId(comm.getId());
                    selCommAndVarierMage(commVarietMagePagePo, list, mageBy, commVar);
                }
                List<CommVarietMageListVo> commVarierMageList = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
                list.addAll(commVarierMageList);
            }
        } else {
            // 查询全部
            list = commVarietMageMapper.findCommVarierMageList(commVarietMagePagePo);
        }
        page.setList(list);

        poJo.setResult(page);

        return poJo;
    }

    /**
     * 查询品种及品类
     *
     * @param commVarietMagePagePo
     * @param list
     * @param mageByParentId
     * @param commVar
     */
    private void selCommAndVarierMage(CommVarietMagePagePo commVarietMagePagePo, List<CommVarietMageListVo> list, List<CommMage> mageByParentId, CommVarietMagePagePo commVar) {
        for (CommMage commMa : mageByParentId) {
            commVar.setCommId(commMa.getId());
            if (ConverterUtil.isNotEmpty(commVarietMagePagePo.getCommVarietName())) {
                commVar.setCommVarietName(commVarietMagePagePo.getCommVarietName());
            }
            List<CommVarietMageListVo> commVarierMageList = commVarietMageMapper.findCommVarierMageList(commVar);
            list.addAll(commVarierMageList);
        }
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
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<?> delete(LongIdPo po) {

        ResultPoJo<CommVarietMage> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        // 查询品种分类关联的商品（该品种 已关联商品，不能删除）
        Integer count = commMageMapper.selectCommVaritPubCount(po.getId());
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
}
