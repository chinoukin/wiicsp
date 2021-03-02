package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.FollowCommMapper;
import com.wisea.transac.common.dao.FollowMerchantMapper;
import com.wisea.transac.common.entity.FollowComm;
import com.wisea.transac.common.po.FollowCommPo;
import com.wisea.transac.common.po.seller.FocusPo;
import com.wisea.transac.common.po.seller.FollowCommAllPo;
import com.wisea.transac.common.po.seller.FollowCommMiniPageListPo;
import com.wisea.transac.common.utils.AssemblyPriceUtil;
import com.wisea.transac.common.vo.FollowCommInfoVo;
import com.wisea.transac.common.vo.product.AssembyPriceVo;
import com.wisea.transac.common.vo.seller.FocusVo;
import com.wisea.transac.common.vo.seller.FollowCommMiniPageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className FollowCommService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class FollowCommService extends BaseService {
    @Autowired
    private FollowCommMapper followCommMapper;

    @Autowired
    private FollowMerchantMapper followMerchantMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowComm
     */
    public ResultPoJo<Page<FollowCommMiniPageListVo>> findPageList(FollowCommMiniPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<FollowCommMiniPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<FollowCommMiniPageListVo> page = po.getPage();
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        List<FollowCommMiniPageListVo> list = followCommMapper.findMiniPageList(po);
        for (FollowCommMiniPageListVo vo : list) {
            AssembyPriceVo assembyPriceVo =  AssemblyPriceUtil.getProductPrice(vo.getCommPubId());
            vo.setPriceRang(assembyPriceVo.getPriceRang());
        }
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 产地交易商品
     * @param po
     * @return
     */
    public ResultPoJo<Page<FollowCommMiniPageListVo>> findLocalityPageList(FollowCommMiniPageListPo po) {
        LoggerUtil.infoWithContext("【findLocalityPageList】产地交易商品：", po);
        ResultPoJo<Page<FollowCommMiniPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<FollowCommMiniPageListVo> page = po.getPage();
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        po.setFlag("产地");
        List<FollowCommMiniPageListVo> list = followCommMapper.findMiniPageList(po);
        for (FollowCommMiniPageListVo vo : list) {
            AssembyPriceVo assembyPriceVo =  AssemblyPriceUtil.getProductPrice(vo.getCommPubId());
            vo.setPriceRang(assembyPriceVo.getPriceRang());
        }
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 逻辑删除FollowComm
     */
    @Transactional(readOnly = false)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        FollowComm entity = followCommMapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(FollowComm.DEL_FLAG_DELETE);
            entity.preUpdate();
            followCommMapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 新增或修改FollowComm
     */
    @Transactional(readOnly = false)
    public ResultPoJo saveOrUpdate(FollowCommPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        po.setMembId(user.getId());
        po.setFlag("1");
        FollowComm entity  = followCommMapper.findExist(po);

        if (ConverterUtil.isNotEmpty(entity)) {
            if (entity.getDelFlag().equals(FollowComm.DEL_FLAG_DELETE)){
                entity.setDelFlag(FollowComm.DEL_FLAG_NORMAL);
                entity.preUpdate();
                followCommMapper.updateByPrimaryKeySelective(entity);
            }else {
                entity.setDelFlag(FollowComm.DEL_FLAG_DELETE);
                entity.preUpdate();
                followCommMapper.updateByPrimaryKeySelective(entity);
            }
        } else {
            entity = new FollowComm();
            //新增
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            followCommMapper.insert(entity);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FollowComm
     */
    public ResultPoJo<FollowCommInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<FollowCommInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        FollowCommInfoVo vo = followCommMapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 关注数量
     *
     * @param po
     * @return
     */
    public ResultPoJo<FocusVo> queryGZSum(FocusPo po) {
        ResultPoJo<FocusVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();
        po.setId(user.getId());
        FocusVo vo = new FocusVo();
        vo.setFwCommSum(followCommMapper.findSumByUserId(po));
        vo.setFwMerchantSum(followMerchantMapper.findSumByUserId(po));
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 批量关注商品
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo saveAll(FollowCommAllPo po) {
        LoggerUtil.infoWithContext("【saveAll】批量关注商品：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        User user = SystemUtils.getUser();

        for (int i = 0; i < po.getIds().size(); i++) {

            FollowCommPo followCommPo =new FollowCommPo();
            followCommPo.setMembId(user.getId());
            followCommPo.setFlag("1");
            followCommPo.setCommPubId(po.getIds().get(i));
            FollowComm entity  = followCommMapper.findExist(followCommPo);

            if (ConverterUtil.isNotEmpty(entity)) {
                if (entity.getDelFlag().equals(FollowComm.DEL_FLAG_DELETE)){
                    entity.setDelFlag(FollowComm.DEL_FLAG_NORMAL);
                    entity.preUpdate();
                    followCommMapper.updateByPrimaryKeySelective(entity);
                }
            } else {
                entity = new FollowComm();
                //新增
                entity.preInsert();
                entity.setMembId(user.getId());
                entity.setCommPubId(po.getIds().get(i));
                followCommMapper.insert(entity);
            }

        }
        return resultPoJo;
    }
}
