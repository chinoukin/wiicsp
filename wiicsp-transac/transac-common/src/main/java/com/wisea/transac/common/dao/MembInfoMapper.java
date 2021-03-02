package com.wisea.transac.common.dao;

import java.util.List;

import com.wisea.transac.common.po.trade.StaticOrderPo;
import com.wisea.transac.common.vo.trade.ChartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.MembLoginCityOrLocInfo;
import com.wisea.transac.common.po.MembInfoPageListPo;
import com.wisea.transac.common.po.memb.CheckOldMobilePo;
import com.wisea.transac.common.po.memb.EntpInfoForAllListPo;
import com.wisea.transac.common.po.memb.LoginNameOrMobilePo;
import com.wisea.transac.common.po.memb.MembCheckLoginNamePo;
import com.wisea.transac.common.po.memb.MembCheckMobilePo;
import com.wisea.transac.common.po.memb.MembListForMsgPo;
import com.wisea.transac.common.vo.MembInfoInfoVo;
import com.wisea.transac.common.vo.MembInfoPageListVo;
import com.wisea.transac.common.vo.memb.ChcekMobileIsEntpVo;
import com.wisea.transac.common.vo.memb.EntpInfoForAllListVo;
import com.wisea.transac.common.vo.memb.MembInfoForSetVo;
import com.wisea.transac.common.vo.memb.MembInfoListForMsgVo;
import com.wisea.transac.common.vo.memb.MembProveBaseInfoVo;

@Mapper
@Repository
public interface MembInfoMapper extends CrudDao<MembInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询MembInfo
     */
    List<MembInfoPageListVo> findPageList(MembInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息MembInfo
     */
    MembInfoInfoVo findInfo(LongIdPo po);
    /**
     * 查询会员的基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年4月28日
     * @version 1.0
     */
public MembBaseInfo getMembBaseInfo(Long id);
    /**
     * 验证用户名称是否已经存在
     *
     * @author wangh(wisea)
     *
     * @date 2020年4月28日
     * @version 1.0
     */
    public int checkLoginNameExist(MembCheckLoginNamePo membCheckLoginNamePo);
    /**
     * 验证手机号是否已经存在
     *
     * @author wangh(wisea)
     *
     * @date 2020年4月28日
     * @version 1.0
     */
    public int checkMobileExist(MembCheckMobilePo membCheckMobilePo);
    /**
     * 通过手机号获取用户基本信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年4月28日
     * @version 1.0
     */
    public MembBaseInfo getMembInfoByMobile(String regMobile);
    /**
     *  根据手机号或者登陆名称查询用户名
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月6日
     * @version 1.0
     */
    public MembInfo getLoginNameByUserNameOrMobile(String paremeter);
    /**
     * 同过注册手机号查询用信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月11日
     * @version 1.0
     */
    public MembInfo getMembInfoByRegTel(String regTel);
    /**
     * 通过手机号查询是否能够登录到小程序端的用户
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月9日
     * @version 1.0
     */
    public String findCanLoginWechat(String regTel);
    /**
     * 小程序我的设置中会员基本信息初期化查询
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月9日
     * @version 1.0
     */
    public MembInfoForSetVo getMembInfoForSet(Long id);
    /**
     * 验证输入的旧手机号是否正确
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月9日
     * @version 1.0
     */
    public int checkOldMobile(CheckOldMobilePo po);
    /**
     * 商户App登录的验证处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月12日
     * @version 1.0
     */
    public MembLoginCityOrLocInfo sellerAppLoginCheck(LoginNameOrMobilePo po);
    /**
     * 查询总运营平台或者某个市场的管理员账户ID
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月20日
     * @version 1.0
     */
    public Long getAdminId(Long id);
    /**
     * 发送消息查询全部会员列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月26日
     * @version 1.0
     */
    public List<String> findAllMembList();
    /**
     * 发送消息按条件查询会员信息列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月26日
     * @version 1.0
     */
    public List<String> findMembListForMsg(List<String> list);
    /**
     * 冻结/修改手机号/重置密码时获取会员验证信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月28日
     * @version 1.0
     */
    public MembProveBaseInfoVo getMembProveInit(Long membId);
    /**
     * 查询会员下面采购员和销售员ID列表
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月4日
     * @version 1.0
     */
    public List<Long> getPruAndSaleList(Long membId);
    /**
     * 批量修改会员状态的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年6月5日
     * @version 1.0
     */
    public void batchUpdAcctStateByKey(List<MembInfo> list);

    /**
     * 根据条件模糊查询会员列表
     *
     * @param entpInfoForAllListPo
     * @return
     */
    public List<EntpInfoForAllListVo> findMembInfoAll(EntpInfoForAllListPo entpInfoForAllListPo);
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
     * 根据手机号获取普通会员的信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年7月23日
     * @version 1.0
     */
    public ChcekMobileIsEntpVo getPtMembByMobile(String mobile);
    /**
     * 清空微信绑定字段
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月24日
     * @version 1.0
     */
    public void updBindWechat(MembInfo po);

    /**
     * 查询用户数量
     * @return
     */
    List<ChartVo> findUser(StaticOrderPo moth);
}
