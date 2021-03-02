package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.EntpAuth;
import com.wisea.cultivar.common.vo.memb.*;
import com.wisea.cultivar.common.po.memb.MembForMangerPageListPo;
import com.wisea.cultivar.common.po.memb.MembForSellerPageListPo;
import com.wisea.cultivar.common.po.memb.MembSellerAuthExportPo;
import com.wisea.cultivar.common.po.memb.MembSellerExportPo;
import com.wisea.cultivar.common.vo.trade.EntpAuthInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EntpAuthMapper extends CrudDao<EntpAuth> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询EntpAuth
     */
    List<MembForManagerListVo> findPageList(MembForSellerPageListPo po);

    /**
     * 逻辑删除企业信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月12日
     * @version 1.0
     */
    public void updDelById(EntpAuth entpAuth);

    /**
     * 供应商管理 审核列表查询处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月21日
     * @version 1.0
     */
    public List<MembForServiceListVo> findSupplierAuthList(MembForMangerPageListPo po);
    /**
     * 供应商管理 会员列表的查询处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月21日
     * @version 1.0
     */
    public List<MembForManagerListVo> findSupplierMembList(MembForSellerPageListPo po);

    /**
     * 根据企业ID查询会员的详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月22日
     * @version 1.0
     */
    public MembEntpDetailBackVo getEntp(Long relId);

    /**
     * 根据会员ID查询会员注册基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public MembEntpDetailBackVo getEntpMembDetail(Long id);
    /**
     * 通过企业ID查询企业详细信息包含银行卡信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月25日
     * @version 1.0
     */
    public EntpAuthInfoInitVo getEntpDetailById(Long id);

    /**
     * 通过企业ID查询企业详细信息包含银行卡信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月25日
     * @version 1.0
     */
    public MembEntpDetailBackVo getEntpDetail(Long id);


    /**
     * 查询信息
     * @param auth
     * @return
     */
    EntpAuthInfoVo findminiInfo(EntpAuth auth);

    /**
     * 根据会员id查询信息
     * @param po
     * @return
     */
    List<EntpAuthInfoVo> findInfoByMembId(LongIdPo po);

    /**
     * 批量查询企业列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public List<EntpAuth> batchSelRpstateType(List<Long> list);

    /**
     * 导出供应商会员管理列表查询处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public List<MembInfoExportListExcelVo> findSupplierMembListImport(MembSellerExportPo po);
    /**
     * 导出供应商认证管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public List<MembForServiceExcelVo> findSupplierAuthListImport(MembSellerAuthExportPo po);


    /**
     * 根据会员ID查询企业已经审核的信息(商家)
     *
     * @author wangh(wisea)
     *
     * @date 2020年7月18日
     * @version 1.0
     */
    public EntpAuth getEntpAuthPassByMembId(Long membId);

    /**
     * 根据会员ID查询企业已经认证的信息(个人)
     *
     * @author wangh(wisea)
     *
     * @date 2020年7月18日
     * @version 1.0
     */
    public EntpAuth getEntpRzPassByMembId(Long membId);

    EntpAuthInfoInitVo findResAuth(Long id);

    EntpAuthInfoInitVo findEntpAuth(Long id);

    EntpAuthInfoInitVo findResTypeAuth(Long membId);

    EntpAuthInfoInitVo findEntpTypeAuth(Long id);

    EntpAuthInfoInitVo getRealPersonDetailById(Long id);

    void updateByRealPerson(EntpAuth newEntpAuth);
}
