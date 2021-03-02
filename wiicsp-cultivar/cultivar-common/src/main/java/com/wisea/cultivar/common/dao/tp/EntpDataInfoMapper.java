package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.EntpCertMage;
import com.wisea.cultivar.common.entity.tp.EntpDataInfo;
import com.wisea.cultivar.common.entity.tp.ExamRecd;
import com.wisea.cultivar.common.po.tp.EntpDataInfoListPo;
import com.wisea.cultivar.common.po.tp.EntpInfoForAllListPo;
import com.wisea.cultivar.common.po.tp.memb.EntpDataInfoPagePo;
import com.wisea.cultivar.common.vo.tp.EntpCertInitVo;
import com.wisea.cultivar.common.vo.tp.EntpDataInfoBackListVo;
import com.wisea.cultivar.common.vo.tp.EntpDataInfoListVo;
import com.wisea.cultivar.common.vo.tp.EntpDataPageListVo;
import com.wisea.cultivar.common.vo.tp.EntpDateExportListVo;
import com.wisea.cultivar.common.vo.tp.EntpTimeAxisVo;
import com.wisea.cultivar.common.vo.tp.memb.EntpDataInfoGetVo;
import com.wisea.cultivar.common.vo.tp.memb.EntpInfoForGlVo;
import com.wisea.cultivar.common.vo.tp.memb.MembEntpDetailVo;
import com.wisea.cultivar.common.vo.tp.memb.MembEntpInfoListVo;
import com.wisea.cultivar.common.vo.tp.memb.MembInfoForNzVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import feign.Param;

/**
 * entp_data_info 表DAO
 * 商家资料信息
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface EntpDataInfoMapper extends CrudDao<EntpDataInfo> {

	/**
	 * 分页查询个人企业认证信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月17日
	 * @version 1.0
	 */
    List<EntpDataPageListVo> findPage(EntpDataInfoPagePo entpDataInfoPagePo);

    List<EntpDataInfoListVo> findList(EntpDataInfoListPo entpDataInfoListPo);
    /**
     * 跟新不审核部分的数据
     *
     * @author wangh(wisea)
     *
     * @date 2018年12月7日
     * @version 1.0
     */
    public void updatePartDateById(EntpDataInfo po);
    /**
     * 获取已经认证的商家详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月8日
     * @version 1.0
     */
    public EntpDataInfoGetVo getEnptSuceeDetailByMembId(Long membId);
    /**
     * 通过ID获取已经审核的信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月24日
     * @version 1.0
     */
    public EntpDataInfoGetVo getEnptSuceeDetailById(Long id);
    /**
     * 查询最新的商家详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月8日
     * @version 1.0
     */
    public EntpDataInfoGetVo getEnptDetailByMembId(Long membId);
    /**
     * 查询认证管理统计结果
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月9日
     * @version 1.0
     */
    public EntpDataInfoBackListVo getEntpDateCount();
    /**
     * 后台查询企业详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月9日
     * @version 1.0
     */
    public EntpDataInfoGetVo getEnptInfoDetailByCopy(Long id);
    /**
     * 新增商家资料审核信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月9日
     * @version 1.0
     */
    public void insertExamRecd(ExamRecd examRecd);
    /**
     * 查询商家认证的初期话处理
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月9日
     * @version 1.0
     */
    public List<EntpCertInitVo> getEntpCerInfoInit(Long membId);
    /**
     * 根据会员id删除商家认证信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月9日
     * @version 1.0
     */
    public void delEntpCertByMembId(Long membId);
    /**
     * 批量添加商家认证信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月9日
     * @version 1.0
     */
    public void insertBatchEntpCertMage(List<EntpCertMage> list);
    /**
     * 根据会员id查询已经审核通过的商家资料信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月10日
     * @version 1.0
     */
    public EntpDataInfo getAuthSuccEntpInfoByMembId(Long membId);
    /**
     * 获取商户时间轴信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月10日
     * @version 1.0
     */
    public EntpTimeAxisVo getTimeAxis(Long membId);
    /**
     * 导出会员认证列表
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月17日
     * @version 1.0
     */
    public List<EntpDateExportListVo> selEntpInfoForExportByIds(@Param(value = "list") List<String> idList);

    /**
     * 根据企业名称模糊查询企业信息列表
     *
     * @author wangh(wisea)
     *
     * @date 2018年12月5日
     * @version 1.0
     */
    public List<EntpDataInfoListVo> findEntpAll(EntpInfoForAllListPo po);

    /**
     * 根据会员id查询商家编号
     * @param membId
     * @return
     */
    public String getMerchantNoByMembid (Long membId);

    public MembEntpDetailVo getBackMembEnptInfoDetail(Long id);
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
     * 通过注册手机号查询企业信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年6月13日
     * @version 1.0
     */
    public EntpInfoForGlVo getEntpDetalByRegitMobile(String registMobile);

    /**
     * 根据技术服务标识查询
     * @param sfjsfwsFlag
     * @return
     */
    public String selectBySfjsfus(@Param(value = "sfjsfwsFlag") String sfjsfwsFlag);
    /**
     * 根据用户名查询企业基本信息（农资）
     *
     * @author wangh(wisea)
     *
     * @date 2019年9月6日
     * @version 1.0
     */
    public MembInfoForNzVo findMembBaseInfoForNz(String userName);
    /**
     * 店铺信息中认证列表的查询
     *
     * @author wangh(wisea)
     *
     * @date 2019年12月12日
     * @version 1.0
     */
    public List<EntpCertInitVo> getEntpCerInfoForIndex(Long membId);
}
