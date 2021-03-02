package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.EntpCertMage;
import com.wisea.cultivar.common.po.tp.EntpCertMageListPo;
import com.wisea.cultivar.common.po.tp.EntpCertMagePagePo;
import com.wisea.cultivar.common.vo.tp.EntpCertMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * entp_cert_mage 表DAO
 * 商家证书管理
 * 2018/09/18 14:36:47
 */
public interface EntpCertMageMapper extends CrudDao<EntpCertMage> {

    /**
     * 分页查询
     */
    List<EntpCertMageListVo> findPage(EntpCertMagePagePo entpCertMagePagePo);

    /**
     * 列表查询
     */
    List<EntpCertMageListVo> findList(EntpCertMageListPo entpCertMageListPo);

    /**
     * 查询有无此证书
     * @param certMage
     * @return
     */
    List<EntpCertMage> selByTypeAndMembId(EntpCertMage certMage);
    /**
     * 查询商家证书管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月9日
     * @version 1.0
     */
    public List<EntpCertMageListVo> findListByMembId(Long membId);

}
