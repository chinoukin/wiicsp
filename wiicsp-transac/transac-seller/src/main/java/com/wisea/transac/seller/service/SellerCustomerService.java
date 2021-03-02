package com.wisea.transac.seller.service;

import java.util.List;

import com.wisea.transac.seller.dao.SellerCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.mss.RemoteCustomerMss;
import com.wisea.transac.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.transac.common.po.customer.SaleStaffInfoMageCustomerInfoVo;
import com.wisea.transac.common.po.customer.SellerCustomerSavePo;
import com.wisea.transac.common.po.customer.SellerStallCustomerListVo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigGetPo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigGetVo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigUpdatePo;
import com.wisea.transac.common.po.customer.SysImCustomerListDeletePo;
import com.wisea.transac.common.po.customer.SysImCustomerListInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerListUpdatePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.utils.SellerMembUtils;
import com.wisea.transac.common.utils.ShopUtils;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;

/**
 * 店铺客服Service
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月22日 上午11:33:06
 */
@Service
public class SellerCustomerService extends BaseService {
    @Autowired
    private RemoteCustomerMss remoteCustomerMss;
    @Autowired
    private SellerCustomerMapper sellerCustomerMapper;

    /**
     * 查询店铺的客服配置信息
     *
     * @return
     */
    public ResultPoJo<SysImCustomerConfigGetVo> getConfig() {
        // // 判断是否有客服配置的权限
        // if (!SystemUtils.hasAuthor("sel:cust")) {
        // throw new VerifyException(ConstantError.ERR_901, ConstantError.MSG_901);
        // }
        // 从远程查询结果
        SysImCustomerConfigGetPo po = new SysImCustomerConfigGetPo();
        // 查询店铺id 店铺员工 档口员工 都返回店铺
        ShopInfoInfoVo shopInfo = getShopInfoWithCheck();
        // 不为空说明是店铺人员
        if (null != shopInfo) {
            po.setGroupId(ConverterUtil.toString(shopInfo.getId()));
            ResultPoJo<SysImCustomerConfigGetVo> res = remoteCustomerMss.get(po);
            checkRemoteResult(res);
            // 如果配置为空就新建一个
            if (null == res.getResult()) {
                // 查询店铺和档口的人员列表 并将所有人员添加到客服
                List<SellerStallCustomerListVo> allMembList = getCustomerList().getResult();
                if (ConverterUtil.isNotEmpty(allMembList)) {
                    // 等于1说明只有店铺数据
                    if (allMembList.size() == 1) {
                        insertShopCustomerConfigAndList(allMembList.get(0).getGroupId(), allMembList.get(0));
                    } else if (allMembList.size() > 1) {
                        // 大于1 说明有店铺和档口数据
                        insertShopCustomerConfigAndList(allMembList.get(0).getGroupId(), allMembList.get(0));
                        // 循环写入档口客服数据 档口客服 只有人员列表 没有对应配置 客服配置使用其对应店铺的配置 在分配客服时会逐层及查询
                        for (int i = 1; i < allMembList.size(); i++) {
                            insertStallCustomerConfigAndList(allMembList.get(i).getGroupId(), allMembList.get(i).getCustomerList());
                        }
                    }
                }
                res = remoteCustomerMss.get(po);
            }
            return res;
        } else {
            // 如果没有取得店铺 说明不是店铺的人员
            throw new VerifyException(ConstantCodeMsg.ERR_719, ConstantCodeMsg.MSG_719);
        }
    }

    /**
     * 增加店铺客服配置和客服人员列表
     *
     * @param shopInfo
     * @param allMembList
     */
    private void insertShopCustomerConfigAndList(String groupId, SellerStallCustomerListVo vo) {
        if (ConverterUtil.isNotEmpty(groupId, vo, vo.getCustomerList())) {
            List<CustomerConfigUserInsertPo> custInstList = Lists.newArrayList();
            // 新增店铺的客服配置和客服人员
            SysImCustomerConfigInsertPo insPo = new SysImCustomerConfigInsertPo();
            insPo.setGroupId(groupId);
            insPo.setType(Constants.YES);
            insPo.setSerMaxCount(50);
            insPo.setRetContact(Constants.NO);
            insPo.setDepNoAdmin(Constants.NO);
            for (SaleStaffInfoMageCustomerInfoVo cst : vo.getCustomerList()) {
                CustomerConfigUserInsertPo ccuip = new CustomerConfigUserInsertPo();
                ccuip.setUserId(cst.getSaleStaffId());
                String isAdmin = Constants.NO;
                // 数据字典设计成反的了要正过来传递
                if (Constants.NO.equals(cst.getSfAdminFlag())) {
                    isAdmin = Constants.YES;
                }
                ccuip.setAdmin(isAdmin);
                custInstList.add(ccuip);
            }
            insPo.setUserList(custInstList);
            // 添加店铺的客服配置
            remoteCustomerMss.customerConfigInsert(insPo);
        }
    }

    /**
     * 新增档口客服人员列表
     *
     * @param groupId
     * @param stallList
     */
    private void insertStallCustomerConfigAndList(String groupId, List<SaleStaffInfoMageCustomerInfoVo> stallList) {
        if (ConverterUtil.isNotEmpty(groupId, stallList)) {
            SysImCustomerListInsertPo po = new SysImCustomerListInsertPo();
            po.setGroupId(groupId);
            for (SaleStaffInfoMageCustomerInfoVo vo : stallList) {
                String isAdmin = Constants.NO;
                // 数据字典设计成反的了要正过来传递
                if (Constants.NO.equals(vo.getSfAdminFlag())) {
                    isAdmin = Constants.YES;
                }
                po.addUser(vo.getSaleStaffId(), isAdmin);
            }
            remoteCustomerMss.customerListInsert(po);
        }
    }

    /**
     * 查询当前登录用户的客服列表 店铺和档口均会返回店铺全部的配置
     *
     * @return
     */
    public ResultPoJo<List<SellerStallCustomerListVo>> getCustomerList() {
        ResultPoJo<List<SellerStallCustomerListVo>> result = new ResultPoJo<List<SellerStallCustomerListVo>>();
        List<SellerStallCustomerListVo> customerList = Lists.newArrayList();
        ShopInfoInfoVo shopInfo = getShopInfoWithCheck();

        // 设置店铺客服列表
        SellerStallCustomerListVo shopCustInfo = new SellerStallCustomerListVo();
        shopCustInfo.setGroupId(ConverterUtil.toString(shopInfo.getId()));
        shopCustInfo.setGroupName("店铺");

        // 手动添加店铺主账户到客服列表
        MembBaseInfo shopAdminMembInfo = MembUtils.getMembInfoByUserId(shopInfo.getMerchantId());
        SaleStaffInfoMageCustomerInfoVo shopAdminVo = new SaleStaffInfoMageCustomerInfoVo();
        // 会员id
        shopAdminVo.setSaleStaffId(shopAdminMembInfo.getId());
        // 姓名
        shopAdminVo.setStaffName(shopAdminMembInfo.getContName());
        // 注册手机号
        shopAdminVo.setRegistTel(shopAdminMembInfo.getRegistTel());
        // 是否是管理员
        shopAdminVo.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_0);
        // 是否为客服人员 NO 第一次需要新增到客服列表
        shopAdminVo.setIsCustomer(Constants.NO);

        // 获取未关联档口的店铺账户列表
        List<SaleStaffInfoMageCustomerInfoVo> shopCustList = sellerCustomerMapper.getShopCustomerList(shopCustInfo.getGroupId());
        shopCustList.add(0, shopAdminVo);
        shopCustInfo.setCustomerList(shopCustList);
        customerList.add(shopCustInfo);
        // 查询所有档口
        List<StallsMagePageListVo> allList = SellerMembUtils.getAllStallsMage(shopInfo.getId());
        // 循环查询档口对应的客服列表
        for (StallsMagePageListVo stallsMageListVo : allList) {
            // 设置档口客服列表
            SellerStallCustomerListVo stallCustInfo = new SellerStallCustomerListVo();
            stallCustInfo.setGroupId(ConverterUtil.toString(stallsMageListVo.getId()));
            stallCustInfo.setGroupName(stallsMageListVo.getStallsName());
            List<SaleStaffInfoMageCustomerInfoVo> stallCustList = sellerCustomerMapper.getStallCustomerList(stallCustInfo.getGroupId());
            stallCustInfo.setCustomerList(stallCustList);
            customerList.add(stallCustInfo);
        }
        result.setResult(customerList);
        return result;
    }

    private ShopInfoInfoVo getShopInfoWithCheck() {
        User loginUser = SystemUtils.getUserOnlyId();
        // 查询店铺id 店铺员工 档口员工 都返回店铺
        ShopInfoInfoVo shopInfo = ShopUtils.getShopInfo(loginUser.getId());

        // 如果没有取得店铺 说明不是店铺的人员
        if (null == shopInfo) {
            throw new VerifyException(ConstantCodeMsg.ERR_719, ConstantCodeMsg.MSG_719);
        }
        return shopInfo;
    }

    /**
     * 编辑店铺客服
     *
     * @param updatePo
     * @return
     */
    public ResultPoJo<Object> update(SellerCustomerSavePo updatePo) {
        ResultPoJo<Object> result = new ResultPoJo<Object>();
        // 校验是否为有店铺信息
        getShopInfoWithCheck();
        // 获取店铺对应的客服配置 获取的时候新建过了 此处不会为空
        SysImCustomerConfigGetVo vo = getConfig().getResult();
        if (ConverterUtil.isNotEmpty(vo)) {
            SysImCustomerConfigUpdatePo po = new SysImCustomerConfigUpdatePo();
            ConverterUtil.copyProperties(vo, po);
            ConverterUtil.copyProperties(updatePo, po);
            // 修改店铺配置项
            result = remoteCustomerMss.customerConfigUpdate(po);
            // 档口没有配置项
        }
        return result;
    }

    /**
     * 新增客服列表
     *
     * @param userList
     * @return
     */
    public ResultPoJo<Object> customerListInsert(List<CustomerConfigUserInsertPo> userList) {
        ResultPoJo<Object> result = new ResultPoJo<Object>();
        // 查询店铺id 店铺员工 档口员工 都返回店铺
        ShopInfoInfoVo shopInfo = getShopInfoWithCheck();
        SysImCustomerListInsertPo po = new SysImCustomerListInsertPo();
        po.setGroupId(ConverterUtil.toString(shopInfo.getId()));
        po.setUserList(userList);
        remoteCustomerMss.customerListInsert(po);
        return result;
    }

    /**
     * 修改列表列表
     *
     * @param userList
     * @return
     */
    public ResultPoJo<Object> customerListUpdate(List<CustomerConfigUserInsertPo> userList) {
        ResultPoJo<Object> result = new ResultPoJo<Object>();
        // 查询店铺id 店铺员工 档口员工 都返回店铺
        ShopInfoInfoVo shopInfo = getShopInfoWithCheck();
        SysImCustomerListUpdatePo po = new SysImCustomerListUpdatePo();
        po.setGroupId(ConverterUtil.toString(shopInfo.getId()));
        po.setUserList(userList);
        remoteCustomerMss.customerListUpdate(po);
        return result;
    }

    /**
     * 删除列表列表
     *
     * @param userList
     * @return
     */
    public ResultPoJo<Object> customerListDelete(List<Long> userList) {
        ResultPoJo<Object> result = new ResultPoJo<Object>();
        // 查询店铺id 店铺员工 档口员工 都返回店铺
        ShopInfoInfoVo shopInfo = getShopInfoWithCheck();
        SysImCustomerListDeletePo po = new SysImCustomerListDeletePo();
        po.setGroupId(ConverterUtil.toString(shopInfo.getId()));
        po.setUserList(userList);
        remoteCustomerMss.customerListDelete(po);
        return result;
    }
}
