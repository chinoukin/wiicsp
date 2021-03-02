package com.wisea.cultivar.common.dao.tp;

import java.util.List;
import java.util.Map;

import com.wisea.cultivar.common.entity.tp.MembBaseInfo;
import com.wisea.cultivar.common.entity.tp.MembInfo;
import com.wisea.cultivar.common.po.memb.MembListForMsgPo;
import com.wisea.cultivar.common.po.tp.EntpInfoForAllListPo;
import com.wisea.cultivar.common.po.tp.MemPageForMsgPo;
import com.wisea.cultivar.common.po.tp.MemSendForMsgPo;
import com.wisea.cultivar.common.po.tp.MembInfoListPo;
import com.wisea.cultivar.common.po.tp.memb.MembCheckLoginNamePo;
import com.wisea.cultivar.common.po.tp.memb.MembCheckMobilePo;
import com.wisea.cultivar.common.po.tp.memb.MembInfoPagePo;
import com.wisea.cultivar.common.po.tp.memb.MembInvoSetPo;
import com.wisea.cultivar.common.po.tp.memb.SampUserListPo;
import com.wisea.cultivar.common.po.tp.statistics.BuyerAndSellerConsumePo;
import com.wisea.cultivar.common.po.tp.statistics.MembStaticsPo;
import com.wisea.cultivar.common.po.tp.statistics.PlatfCostListPo;
import com.wisea.cultivar.common.vo.memb.MembInfoListForMsgVo;
import com.wisea.cultivar.common.vo.tp.MembBaseDetailVo;
import com.wisea.cultivar.common.vo.tp.MembInfoBackListVo;
import com.wisea.cultivar.common.vo.tp.MembInfoExportVo;
import com.wisea.cultivar.common.vo.tp.MembInfoGetVo;
import com.wisea.cultivar.common.vo.tp.MembInfoListVo;
import com.wisea.cultivar.common.vo.tp.memb.MembCompInfoVo;
import com.wisea.cultivar.common.vo.tp.memb.MembIndBaseInfoVo;
import com.wisea.cultivar.common.vo.tp.memb.MembInvoSetInfoVo;
import com.wisea.cultivar.common.vo.tp.memb.MembSampUserVo;
import com.wisea.cultivar.common.vo.tp.memb.ShopEntpInfoVo;
import com.wisea.cultivar.common.vo.tp.statistics.BuyerAndSellerConsumeVo;
import com.wisea.cultivar.common.vo.tp.statistics.PlatfCostListVo;
import com.wisea.cultivar.common.vo.tp.statistics.PlatfCostVo;
import com.wisea.cultivar.common.vo.tp.statistics.RegistStaticsVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import feign.Param;

/**
 * memb_info 表DAO
 * 会员信息
 * 2018/09/18 14:36:47
 * <p>
 * 分页查询
 * <p>
 * 分页查询
 * <p>
 * 分页查询
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface MembInfoMapper extends CrudDao<MembInfo> {
	/**
	 *
	 *后台查询会员管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年4月17日
	 * @version 1.0
	 */
    List<MembInfoListVo> findPage(MembInfoPagePo membInfoPagePo);

    List<MembInfoListVo> findList(MembInfoListPo membInfoListPo);

    /**
     * 验证手机号是否已经存在
     *
     * @author wangh(wisea)
     *
     * @date 2018年9月25日
     * @version 1.0
     */
    public int checkMobileExist(MembCheckMobilePo MembCheckMobilePo);

    /**
     * 验证用户名称是否已经存在
     *
     * @author wangh(wisea)
     *
     * @date 2018年9月25日
     * @version 1.0
     */
    public int checkLoginNameExist(MembCheckLoginNamePo membCheckLoginNamePo);

    /**
     * 查询会员的基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月10日
     * @version 1.0
     */
    public MembBaseInfo getMembBaseInfo(Long id);

    /**
     *  查询要发送消息的会员列表（带分页信息）
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月20日
     * @version 1.0
     */
    public List<MembInfoListVo> findPageForMsg(MemPageForMsgPo po);

    /**
     *  查询要发送消息的会员列表（查询所有）
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月20日
     * @version 1.0
     */
    public List<String> findAllForMsg(MemSendForMsgPo po);

    /**
     * 通过用户名查询会员的基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月10日
     * @version 1.0
     */
    public MembBaseInfo getMembInfoByUserName(String userName);

    /**
     * 根据id获取会员的基本详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月13日
     * @version 1.0
     */
    public MembBaseDetailVo getMembBaseDetail(Long id);

    /**
     * 会员导出列表信息的查询
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月13日
     * @version 1.0
     */
    public List<MembInfoExportVo> selMembInfoForExportByIds(@Param(value = "list") List<String> idList);

    /**
     * 后台会员列表页面会员数据的统计的查询
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月15日
     * @version 1.0
     */
    public MembInfoBackListVo getMembStatisticalDate();

    /**
     * 查询用户是否为代理用户
     * */
    MembInfo findUserAreAgent(Long id);

    /**
     * 根据id查询子账户或者会员的基础信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月31日
     * @version 1.0
     */
    public MembInfoGetVo getMembInfoById(Long id);

    /**
     * 验证昵称是否重复
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月1日
     * @version 1.0
     */
    public int checkPetNameExist(Map<String, Object> map);

    /**
     * 根据openid查询会员基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月12日
     * @version 1.0
     */
    public MembInfoGetVo getMembInfoByOpenid(String openId);

    /**
     * 根据用户名称查询没有绑定的会员基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月13日
     * @version 1.0
     */
    public MembInfoGetVo getMembByUserNameForWeChat(String userName);

    /**
     * 微信解除绑定
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月15日
     * @version 1.0
     */
    public void updUnbind(MembInfo membInfo);

    /**
     *  查询详细会员信息包含企业名称
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月26日
     * @version 1.0
     */
    public MembInfoGetVo selectInfoByKey(Long id);

    /**
     * 根据用户名称在会员表中查询会员的详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年11月26日
     * @version 1.0
     */
    public MembInfoGetVo selectInfoByLoginName(String userName);

    /**
     * 查询买卖家消费排行榜
     * @param buyerAndSellerConsumePo
     * @return
     */
    List<BuyerAndSellerConsumeVo> selectBuyerAndSeller(BuyerAndSellerConsumePo buyerAndSellerConsumePo);

    /**
     * 查询服务费统计
     * @param platfCostListPo
     * @return
     */
    List<PlatfCostListVo> platfCostList(PlatfCostListPo platfCostListPo);

    Integer platfCostSum(PlatfCostListPo platfCostListPo);

    /**
     * 会员按月统计
     * @param membStaticsPo
     * @return
     */
    List<RegistStaticsVo> registMouthStatics (MembStaticsPo membStaticsPo);

    /**
     * 会员按年统计
     * @param membStaticsPo
     * @return
     */
    List<RegistStaticsVo> registYearStatics (MembStaticsPo membStaticsPo);

    PlatfCostVo platfCostMax(PlatfCostListPo platfCostListPo);
    /**
     * 根据条件模糊查询会员列表
     *
     * @param entpInfoForAllListPo
     * @return
     */
    public List<MembInfoGetVo> findMembInfoAll(EntpInfoForAllListPo entpInfoForAllListPo);
    /**
     *  保存个人信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月16日
     * @version 1.0
     */
    public void saveMembIndInfo(MembInfo membInfo);
    /**
     * 保存会员公司信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月16日
     * @version 1.0
     */
    public void saveMembCompInfo(MembInfo membInfo);
    /**
     * 根据ID查询采购人员详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月22日
     * @version 1.0
     */
    public MembSampUserVo getMembSampUserById(Long id);
    /**
     * 查询采购人员列表信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月22日
     * @version 1.0
     */
    public List<MembSampUserVo> findMembSampUserList(SampUserListPo sampUserListPo);
    /**
     * 根据用户Id查询用户基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月23日
     * @version 1.0
     */
    public MembIndBaseInfoVo getIndBaseInfoByMembId(Long id);
    /**
     *  根据会员ID查询公司基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月23日
     * @version 1.0
     */
    public MembCompInfoVo getCompBaseInfoByMembId(Long id);
    /**
     * 通过手机号回去用户信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月25日
     * @version 1.0
     */
    public MembBaseInfo getMembInfoByMobile(String regMobile);
    /**
     * 会员保存发票设置信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月26日
     * @version 1.0
     */
    public void saveMembInvoInfo(MembInvoSetPo membInvoSetPo);
    /**
     * 查询会员发票设置信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年4月26日
     * @version 1.0
     */
    public MembInvoSetInfoVo getMembInvoInfo(Long membId);
    /**
     *  根据手机号或者登陆名称查询用户名
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月6日
     * @version 1.0
     */
    public String getLoginNameByUserNameOrMobile(String paremeter);
    /**
     * 注册的时候验证企业名称不能重复
     *
     * @author wangh(wisea)
     *
     * @date 2019年9月20日
     * @version 1.0
     */
    public int checkCompNameForReg(String compName);
    /**
     * 根据会员ID查询店铺用的企业信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年12月16日
     * @version 1.0
     */
    public ShopEntpInfoVo getMembAllInfoByMembId(Long id);
    /**
     * 指定的时候查询所有的会员接口
     *
     * @author wangh(wisea)
     *
     * @date 2020年7月16日
     * @version 1.0
     */
    public List<MembInfoListForMsgVo> membListForMsg(MembListForMsgPo po);
    /**
     * 发送消息查询全部会员列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月26日
     * @version 1.0
     */
    public List<String> findAllMembList();

}
