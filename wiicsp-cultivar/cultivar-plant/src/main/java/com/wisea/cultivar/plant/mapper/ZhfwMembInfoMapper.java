package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.po.ZhfwMembInfoFindListPo;
import com.wisea.cultivar.plant.po.ZhfwMembInfoPageListPo;
import com.wisea.cultivar.plant.po.oritrapla.MembLatLngSetPo;
import com.wisea.cultivar.plant.po.oritrapla.SelSubMembPo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoFindListVo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoPageListVo;
import com.wisea.cultivar.plant.vo.oritrapla.*;
import com.wisea.cultivar.plant.po.oritrapla.WebMembListPo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ZhfwMembInfoMapper extends CrudDao<ZhfwMembInfo> {
    /**
     * 基本信息的查询(登录成功后调用)
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月5日
     * @version 1.0
     */
    public LoginBaseInfoVo getBaseInfoById(Long id);
    /**
     * 注册时用户名的不重复的验证
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月5日
     * @version 1.0
     */
    public int checkUsername(String loginName);
    /**
     * 注册时手机号的不重复的验证
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月5日
     * @version 1.0
     */
    public int checkMobile(String mobile);
    /**
     * 注册时验证公司名称是否已经存在
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月5日
     * @version 1.0
     */
    public int checkOrgName(String orgName);
    /**
     * 根据用户名称查询用户是否存在
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月5日
     * @version 1.0
     */
    public ZhfwMembInfo getMembInfoByUserName(String LoginName);
    /**
     * 主体信息的查询
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月6日
     * @version 1.0
     */
    public MembMainInfoVo getMainMembInfo(Long id);
    /**
     * 分页查询人员管理列表
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月6日
     * @version 1.0
     */
    public List<SubMembInfoVo> findMembInfoList(SelSubMembPo po);


    /**
     * 根据父级ID查询子账户IDs
     * @param id
     * @return
     */
    List<Long> findIdsByParentId(Long id);

    /**
     * 分页查询会员列表信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月19日
     * @version 1.0
     */
    public List<MembListInfoVo> getMembInfoList(WebMembListPo po);

    /**
     * 会员列表后台账号管理
     * @param po
     * @return
     */
    List<MembListInfoVo> getMembInfoBackManList(WebMembListPo po);
    /**
     * 批量冻结、解冻会员信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月19日
     * @version 1.0
     */
    public void batchMembLoginFlag(Map<String, Object> map);
    /**
     * 根据id查询会员详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月19日
     * @version 1.0
     */
    public MembDetailInfoVo getDetaiInfo(Long id);
    /**
     * 根据id查询会员基础信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月19日
     * @version 1.0
     */
    public MembBaseInfoVo getMembBaseInfoById(Long id);
    /**
     *
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月20日
     * @version 1.0
     */
    public ManUserVo getManInfoById(Long id);

    /**
     * 根据当前登录用户查询 主账号下所有子账号和主账号所有信息
     *
     */
    List<String> findAccountAll(Long id);

    /**
     * 模糊查询主体名称
     * @return
     */
    public List<ZhfwMembInfo> searchOrgName();

    /**
     * 根据手机号精确查询
     * @param contTel
     * @return
     */
    public List<MembMainInfoVo> selByMembTel(String contTel);
    /**
     * 修改会员经纬度的操作
     *
     * @author wangh(wisea)
     *
     * @date 2018年6月20日
     * @version 1.0
     */
    public void updMembLatLng(MembLatLngSetPo po);
    /**
     * 查询会员经纬度信息
     * @param id
     */
    public MembLatLngInfoVo getMembLatLng(Long id);



    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ZhfwMembInfo
     */
    List<ZhfwMembInfoPageListVo> findPageList(ZhfwMembInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息ZhfwMembInfo
     */
    ZhfwMembInfoInfoVo findInfo(LongIdPo po);

    /**
     * 查找手机号是否存在被绑定了
     * @param mobile
     * @return
     */
    List<ZhfwMembInfo> findByMobile(String mobile);

    // cyq 种植会员管理列表
    List<ZhfwMembInfoFindListVo> findZhfwMembList(ZhfwMembInfoFindListPo po);

    // cyq 服务商列表
    List<ZhfwMembInfoFindListVo> findZhfwMembFwsList(ZhfwMembInfoFindListPo po);

}
