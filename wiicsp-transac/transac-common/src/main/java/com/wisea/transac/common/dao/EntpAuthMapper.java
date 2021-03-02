package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.EntpAuth;
import com.wisea.transac.common.po.EntpAuthPageListPo;
import com.wisea.transac.common.po.memb.CheckEntpNamePo;
import com.wisea.transac.common.po.memb.EntpAuthUpInfoPo;
import com.wisea.transac.common.po.memb.MembBuyerAuthExportPo;
import com.wisea.transac.common.po.memb.MembBuyerExportPo;
import com.wisea.transac.common.po.memb.MembForBuyerAuthPageListPo;
import com.wisea.transac.common.po.memb.MembForBuyerPageListPo;
import com.wisea.transac.common.po.memb.MembForMangerPageListPo;
import com.wisea.transac.common.po.memb.MembForSellerPageListPo;
import com.wisea.transac.common.po.memb.MembSellerAuthExportPo;
import com.wisea.transac.common.po.memb.MembSellerExportPo;
import com.wisea.transac.common.po.memb.RpStateUpdPo;
import com.wisea.transac.common.po.seller.QueryEntpAuthPo;
import com.wisea.transac.common.vo.EntpAuthInfoVo;
import com.wisea.transac.common.vo.EntpAuthPageListVo;
import com.wisea.transac.common.vo.memb.EntpAuthInfoInitVo;
import com.wisea.transac.common.vo.memb.MembEntpDetailBackVo;
import com.wisea.transac.common.vo.memb.MembEntpInfoListVo;
import com.wisea.transac.common.vo.memb.MembEntpRpExportVo;
import com.wisea.transac.common.vo.memb.MembForBuyerAuthInfoVo;
import com.wisea.transac.common.vo.memb.MembForManagerAuthInfoVo;
import com.wisea.transac.common.vo.memb.MembForManagerInfoVo;
import com.wisea.transac.common.vo.memb.MembForManagerListVo;
import com.wisea.transac.common.vo.memb.MembForSellerInfoVo;
import com.wisea.transac.common.vo.memb.MembInfoExportListExcelVo;
import com.wisea.transac.common.vo.memb.UserRegisterInfoVo;
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
    List<EntpAuthPageListVo> findPageList(EntpAuthPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息EntpAuth
     */
    EntpAuthInfoVo findInfo(EntpAuth po);

    /**
     * 根据会员ID查询企业认证信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月22日
     * @version 1.0
     */
    public EntpAuthInfoInitVo getUpEntpInfoByMembId(EntpAuthUpInfoPo po);
    /**
     * 根据会员ID或者最新的商户认证信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月22日
     * @version 1.0
     */
    public EntpAuth selUpdEntpInfoByMembId(EntpAuthUpInfoPo po);
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
    public List<MembForManagerListVo> findSupplierAuthList(MembForMangerPageListPo po);
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
     * 供应商管理-会员管理列表统计查询
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月21日
     * @version 1.0
     */
    public MembForSellerInfoVo membSupperlierStatistical(MembForSellerPageListPo po);
    /**
     * 供应商管理-认证管理列表统计查询
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月21日
     * @version 1.0
     */
    public MembForManagerAuthInfoVo membAuthSupperlierStatistical(MembForMangerPageListPo po);
    /**
     * 根据企业ID查询会员的详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月22日
     * @version 1.0
     */
    public MembEntpDetailBackVo getEntpMembDetail(Long relId);

    /**
     * 根据会员ID查询会员注册基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public UserRegisterInfoVo getMemRegInfoByMembId(Long membId);
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
     * 查询认证信息
     * @param queryEntpAuthPo
     * @return
     */
    EntpAuthInfoVo findAuthInfo(QueryEntpAuthPo queryEntpAuthPo);

    /**
     * 查询采购员列表管理统计的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月28日
     * @version 1.0
     */
    public MembForManagerInfoVo membForSellerStatistical();

    /**
     * 查询采购商会员管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月28日
     * @version 1.0
     */
    public List<MembForManagerListVo> findSellerMembList(MembForBuyerPageListPo po);

    /**
     * 查询采购认证列表统计信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月29日
     * @version 1.0
     */
    public MembForBuyerAuthInfoVo findSellerAuthStatistical();

    /**
     * 查询采购商认证管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public List<MembForManagerListVo> findSellerAuthList(MembForBuyerAuthPageListPo po);


    /**
     * 验证企业名称是否重复的查询处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月3日
     * @version 1.0
     */
    public int checkEntpNameExist(CheckEntpNamePo po);

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
     * 根据市场ID查询所有店铺所有人
     * @param marketId
     * @return
     */
    List<EntpAuthInfoVo> findInfoByMarketId(Long marketId);
    /**
     * 批量修改报备状态
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public void batchUpdRpStateType(RpStateUpdPo po);
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
    public List<MembInfoExportListExcelVo> findSupplierAuthListImport(MembSellerAuthExportPo po);
    /**
     * 导出供应商会员管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public List<MembInfoExportListExcelVo> findSellerMembListImport(MembBuyerExportPo po);
    /**
     * 导出采购商认证管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月19日
     * @version 1.0
     */
    public List<MembInfoExportListExcelVo> findSellerAuthListImport(MembBuyerAuthExportPo po);
    /**
     * 导出认证会员的报备信息列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月30日
     * @version 1.0
     */
    public List<MembEntpRpExportVo> membAuthRpListExport(MembSellerAuthExportPo po);
    /**
     * 查询企业信息列表（设置手续费）
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月17日
     * @version 1.0
     */
    public List<MembEntpInfoListVo> findEntpListForSer();
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

    /**
     * 查询认证信息存在根据会员ID
     * @param membId
     * @return
     */
    int checkInfoExistByMembId(Long membId);
}
