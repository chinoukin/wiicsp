package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.dao.SellerSpeSerCostMageMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.SellerSpeSerCostMage;
import com.wisea.transac.common.po.system.*;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.system.SellerSpeSerCostMageGetVo;
import com.wisea.transac.common.vo.system.SellerSpeSerCostMageListVo;
import com.wisea.transac.tp.system.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static com.wisea.transac.tp.system.utils.ResultUtil.build;
import static com.wisea.transac.tp.system.utils.ResultUtil.ok;

/**
 * 商家特殊服务费设置
 *
 * @author wangjiahao
 * @version 1.0
 * @className SellerSpeSerCostMageService
 * @since 2019-01-14 13:40
 */
@Service
public class SellerSpeSerCostMageService extends BaseService {

    private static final Logger log = LoggerFactory.getLogger(SellerSpeSerCostMageService.class);

    @Autowired
    private SellerSpeSerCostMageMapper speSerCostMageMapper;

    /**
     * 分页查询
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ResultPoJo<Page<SellerSpeSerCostMageListVo>> findForPage(SellerSpeSerCostMagePagePo po) {
        List<SellerSpeSerCostMageListVo> list = speSerCostMageMapper.findForPage(po);
        Page<SellerSpeSerCostMageListVo> page = po.getPage();
        page.setList(list);
        return ok(page);
    }

    /**
     * 根据ID查询
     *
     * @param po
     * @return
     */
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public ResultPoJo<SellerSpeSerCostMageListVo> findById(SellerSpeSerCostMageGetPo po) {
        SellerSpeSerCostMageListVo vo = speSerCostMageMapper.findById(po.getId());
        return ok(vo);
    }

    /**
     * 插入一条记录
     *
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo addOne(SellerSpeSerCostMageInsertPo po) {
        if (existMembId(po.getSellerId()) && existMembId(po.getBuyerId())) {
            return build(StatusCode.ADD_FAIL);
        }
        SellerSpeSerCostMageGetVo vo = speSerCostMageMapper
                .findBySellerIdAndBuyerId(po.getSellerId(), po.getBuyerId());
        if (Objects.nonNull(vo)) {
            return build(StatusCode.REPEAT_SET);
        }
        SellerSpeSerCostMage mage = new SellerSpeSerCostMage();
        ConverterUtil.copyProperties(po, mage);
        mage.preInsert();
        speSerCostMageMapper.insertSelective(mage);
        return ok();
    }

    /**
     * 批量插入多条
     *
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo batchAdd(SellerSpeSerCostMageBatchInsertPo po) {
        if (po.getList() != null) {
            long sellerCheck = po.getList().stream()
                    .map(SellerSpeSerCostMageInsertPo::getSellerId)
                    .distinct().count();
            long buyerCheck = po.getList().stream()
                    .map(SellerSpeSerCostMageInsertPo::getBuyerId)
                    .distinct().count();
            if (sellerCheck > 1) {
                return build(StatusCode.NOT_ONLY_ENPTID);
            }
            if (buyerCheck != po.getList().size()) {
                return build(StatusCode.REPEAT_SET);
            }
            po.getList().forEach(this::addOne);
        }
        return ok();
    }

    /**
     * 检查会员ID是否存在
     *
     * @param id
     * @return
     */
    private boolean existMembId(Long id) {
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(id);
        return ConverterUtil.isEmpty(membInfo);
    }

    /**
     * 按ID修改一条记录
     *
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo updateOne(SellerSpeSerCostMageUpdatePo po) {
        if (existMembId(po.getSellerId()) && existMembId(po.getBuyerId())) {
            return build(StatusCode.UPDATE_FAIL);
        }
        SellerSpeSerCostMage mage = new SellerSpeSerCostMage();
        ConverterUtil.copyProperties(po, mage);
        mage.preUpdate();
        speSerCostMageMapper.updateByPrimaryKeySelective(mage);
        return ok();
    }

    /**
     * 根据ID list逻辑删除数据
     *
     * @param po
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo delete(SellerSpeSerCostMageBatDeletePo po) {
        if(ConverterUtil.isNotEmpty(po.getDelList())){
            speSerCostMageMapper.deleteByIds(po.getDelList());
        }
        return ok();
    }
}
