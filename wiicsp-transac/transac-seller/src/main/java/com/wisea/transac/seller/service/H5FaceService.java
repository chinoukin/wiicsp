package com.wisea.transac.seller.service;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.JsonMapper;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.RealPersonAuthMapper;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.RealPersonAuth;
import com.wisea.transac.common.mss.RemoteTIMAccountMss;
import com.wisea.transac.common.po.seller.AddH5FacePo;
import com.wisea.transac.common.po.seller.H5FacePo;
import com.wisea.transac.common.po.seller.RespondPo;
import com.wisea.transac.common.service.TIMNoticeService;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.RealPersonAuthInfoVo;
import com.wisea.transac.common.vo.seller.H5FaceVo;
import com.wisea.transac.common.vo.seller.RealPersonAuthIdVo;
import com.wisea.transac.seller.utils.*;
import io.seata.spring.annotation.GlobalTransactional;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class H5FaceService extends BaseService {

    @Autowired
    private RealPersonAuthMapper realPersonAuthMapper;

    @Autowired
    private MembInfoMapper membInfoMapper;
    @Autowired
    private TIMNoticeService timNoticeService;
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RemoteTIMAccountMss remoteTIMAccountMss;
    @Value("${H5-Face.appid}")
    private String appid;
    @Value("${H5-Face.secret}")
    private String secret;
    private String version = "1.0.0";
    private String license = "oLNLUB+90fSRJwoXYXXealI6yPqbEfLY64uWdYy/I+9XEXIPJupWiLJBPPaMSjtpCxbWHhkX5oD8XBxNwOJC0uqBZ6Y2A6kZedh5eyM4BmDCHyDvFAYF7Rj0sDSwsncr4jtE3wDwkTaUU0ll+FfKwXM03UqvGAIRonEzyKqKOYw7/yUCauaPdTWQSrM109a0+wzH0xJQDPV0pqnt5IwBb9yzvwVI/aOxsS+fbO3feDGDkvXa9FPK8N5EdLCm4uiqIAteqXOUa2ycDf9tgzSfVlFYm1NFB21E7hJdaa2P3qwh556eUxPJw9UlDHORGZrskeKSykgMa6rmHEw257ROiw==";
   // private String license = "EcAtWNBXUR6DIh9jFgDjbZEbnBd3e7pipSIdVToSZ0H7BtJQUUDDHoT9nEquepILr5/ZUgGig40HM4IPszYJdIizVHclV1E3nnb1Szy5DJn9oGQOlDcn5i497v1j5klNyYG2VSvA5tR1gXc1vkg61ZxL+oTPHp7SVsBVNDqMS3kiw+deUKF8edb0BsZF6oGSP3xd2mDMd+0djBP4EBGkmonbldG0LfFVbw7U4j4wCKl/NHY58gKMEl5GwF11s5fdyyDNmROTqC+TqRfJ8Px8clZha0+k63PTKCQ9GAIkT5AW1g2MuLhhAx1h70sBf30ITRN364jW2y767+O59ShfLw==";
    //private String license = "fS/SXtT1iRrZigciDEnMJnYUK0IR0ubYBR23+8hQmlTHUMDSVo5UAR5gJTQBiJMHv26bzeTHm+jguwlsOw8Wg3/qaLbmO09XvsICyLi4m7k+p+gC3Vs1f4EWTlnrhYd73Tz4t3rgs5C6M+brO2aAtSFwo+i6q55dJ8KiALDmDjeWoVywA/wn7g2G4Z0K14nH+U5jb1oVOppQ/vZSVa1DMFVfXOzQ7u5q3uZ2mwqt3Cq+hqktSD8Tzx0m5YZNxPOoo8vtGPeOZUw1nBBKgxks9IIXB5LWnM4pnlv6PM0E/URvkLfpMP4OZhqNWYBD8w/kXcpABW35su7RSXwwujWGxg==";
   //private String license = "FhSs2UeZ/kftBUvsrfHc7fgerpPOttyKFuMwjnroXUc8aVMfi7/wd4pfGDLkVcASNPqfCZG09irZox7SmSsYRa2evuV8QT0BSRM8Hdruv5u0eWspTNmq7aaXVIH+HUCNVNk0bfjI4gMN2qwPhAca8j9Z7CsKuGZ09DBlWdJxBI1ZNYU+b9Y6v13tWzO+L2mGCMB9XeNlskjQMgle8ZnbbX//yXvp0X9vo5dO2xyjiKXvGy5Ryc7m7Pfp3f8hZJ6kmpSvpwQ32XJQlmLzAvdtYODnd3Dd+IBxfuc4eXT2fNCY8xMbSfKozePLRd/sL35jzgYzSnetcBKndrOClutwSw==";
    private String orderNo;

    //private String url = "www.baidu.com" ;
    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
    public final static String ORDER_NO = "ORDER_NO";
    final static 	String resultType = "2";
    /**
     * 获取人脸核身参数
     *
     * @param po
     * @return
     */
    public ResultPoJo<H5FaceVo> getParameters(H5FacePo po) throws Exception {
        LoggerUtil.infoWithContext("【getParameters】获取人脸核身参数：", po);
        ResultPoJo<H5FaceVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        H5FaceVo vo = new H5FaceVo();
        //生成订单号，本次人脸核身合作伙伴上送的订单号，唯一标识
        orderNo = OrderNoUtil.generateOrderCode();
        //设置签名所需要的参数
        List<String> codes = InvertCodeGeneratorUitls.genCodes(32, 2);
        String nonceStr = codes.get(0);
        String userId = codes.get(1);
        //获取 Access Token
        String token = access_token.getToken(appid, secret);
        vo.setToken(token);
        //获取  SIGN ticket  前置条件：请合作方确保 Access Token 已经正常获取，
        String signticket = GetSIGNTicketTest.getSignticket(appid, token);

        //获取  nonce  Ticket  请合作方确保 Access Token 已经正常获取
        String nonceTicket = GetNONCETicket.getNONCETicket(token, userId, appid);

        //生成签名sign
        ArrayList<String> signlist = new ArrayList<String>();
        signlist.add(appid);
        signlist.add(userId);
        signlist.add(version);
        signlist.add(nonceStr);
        String sign = QianMingUitls.getqianming(signlist, nonceTicket);

        Map<String,Object> map  = GetFaceId.getFaceIdStr(userId, sign, appid, orderNo, po.getName(), po.getIdNo(), version);

        if (!map.get("code").equals("0")){
            resultPoJo.setCode(map.get("code").toString());
            resultPoJo.setMsg(map.get("msg").toString());
            return resultPoJo;
        }

        Object object=map.get("result");
        String json = JsonUtil.toJson(object);
        Map fromJson = JsonUtil.fromJson(json,  Map.class);
        String h5FaceIdStr= fromJson.get("faceId").toString();

        //返回参数
        vo.setWebankAppld(appid);
        vo.setVersion(version);
        vo.setNonce(nonceStr);
        vo.setOrderNo(orderNo);
        vo.setH5faceld(h5FaceIdStr);
        //vo.setUrl(URLEncoder.encode(url));
        vo.setUserld(userId);
        vo.setSign(sign);
        vo.setName(po.getName());
        vo.setIdNo(po.getIdNo());
        vo.setByType("3");
        vo.setToken(token);
        vo.setTicket(nonceTicket);
        vo.setLicense(license);
        vo.setSignTicket(signticket);
        jedisdao.setSerializeExpire(ORDER_NO + orderNo, vo, 3600);

        resultPoJo.setResult(vo);
        return resultPoJo;

    }

    /**
     * 新增认证信息
     * @return
     * @param
     */
    public ResultPoJo save(AddH5FacePo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        H5FaceVo vo = jedisdao.getSerialize(ORDER_NO + po.getOrderNo(), H5FaceVo.class);
        if (ConverterUtil.isEmpty(vo)){
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        User user = SystemUtils.getUser();
        //新增
        RealPersonAuth entity = new RealPersonAuth();
        //BeanUtils.copyProperties(po, entity);
        entity.preInsert();
        entity.setRealName(vo.getName());
        entity.setIdCardNum(vo.getIdNo());
        entity.setMembId(user.getId());
        entity.setAuthDate(OffsetDateTime.now());
        entity.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
        realPersonAuthMapper.insert(entity);
        //更新用户姓名
        MembInfo info = membInfoMapper.selectByPrimaryKey(user.getId());
        if (ConverterUtil.isEmpty(info.getContName())) {
            info.preUpdate();
            info.setContName(vo.getName());
            membInfoMapper.updateByPrimaryKey(info);
        }
        return resultPoJo;
    }

    /**
     * 人脸采集图片
     * @param po
     * @return
     */
    public ResultPoJo saveFaceCollection(AddH5FacePo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        H5FaceVo vo = jedisdao.getSerialize(ORDER_NO + po.getOrderNo(), H5FaceVo.class);
        if (ConverterUtil.isEmpty(vo)){
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        vo.setFaceCollection(po.getFaceCollection());
        jedisdao.setSerializeExpire(ORDER_NO + po.getOrderNo(), vo, 3600);
        return resultPoJo;
    }

    /**
     * 查询验证是否通过
     * @param po
     * @return
     */
    public ResultPoJo<H5FaceVo> getCheack(AddH5FacePo po) {
        ResultPoJo<H5FaceVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        H5FaceVo vo = jedisdao.getSerialize(ORDER_NO + po.getOrderNo(), H5FaceVo.class);
        if (ConverterUtil.isEmpty(vo)){
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
            return resultPoJo;
        }
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 人脸核身执行回调接口
     * @param po
     */
    //@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
    @GlobalTransactional
    @Transactional(readOnly = false)
    public ResultPoJo<RealPersonAuthIdVo> receiveCallback(RespondPo po) throws Exception {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        if (!po.getCode().equals("0")){
            resultPoJo.setCode(ConstantError.ERR_005);
            resultPoJo.setMsg(ConstantError.MSG_005);
            return resultPoJo;
        }
        H5FaceVo vo = jedisdao.getSerialize(ORDER_NO + po.getOrderNo(), H5FaceVo.class);
        if (ConverterUtil.isNotEmpty(vo)){
            RealPersonAuthIdVo realPersonAuthIdVo = new RealPersonAuthIdVo();
            //生成签名sign
            ArrayList<String> signlist = new ArrayList<String>();
            signlist.add(appid);
            signlist.add(vo.getOrderNo());
            signlist.add(vo.getVersion());
            signlist.add(vo.getSignTicket());
            String sign = QianMingUitls.getqianming(signlist, vo.getNonce());

            //服端验证结果
                //设置签名所需要的参数
                String Url="https://idasc.webank.com/api/server/sync?app_id="+appid+"&nonce="+vo.getNonce()+"&order_no="+vo.getOrderNo()+"&version=1.0.0&sign="+sign;
                //建立连接
                StringBuffer stringBuffer = getUtils.get(Url);
                JSONObject jsonObject = (JSONObject) JsonMapper.fromJsonString(String.valueOf(stringBuffer),JSONObject.class);
                if (jsonObject.get("code").equals("0")){
                    User user = SystemUtils.getUser();
                    //新增
                    RealPersonAuth entity = new RealPersonAuth();
                    //BeanUtils.copyProperties(po, entity);
                    entity.preInsert();
                    entity.setRealName(vo.getName());
                    entity.setIdCardNum(vo.getIdNo());
                    entity.setMembId(user.getId());
                    entity.setAuthDate(OffsetDateTime.now());
                    entity.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
                    entity.setFaceCollection(po.getFaceCollection());
                    RealPersonAuthInfoVo infovo =  realPersonAuthMapper.queryInfo(entity);
                    if (ConverterUtil.isEmpty(infovo)){
                        realPersonAuthMapper.insert(entity);
                    //更新用户姓名
                    MembInfo info = membInfoMapper.selectByPrimaryKey(user.getId());
                    //判断通过才更改
                    if(!info.getEntpAuthStateType().equals(DictConstants.ENTP_AUTH_STATE_TYPE_0)){
                        info.preUpdate();
                        info.setEntpName(vo.getName());
                        if (ConverterUtil.isEmpty(info.getContName())) {
                            info.setContName(vo.getName());
                        }
                        info.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
                        membInfoMapper.updateByPrimaryKeySelective(info);

                        MembUtils.delMembUser(info.getId());

                    }
                    // 发送系统消息的处理
                    Map<String, Object> dataModel = Maps.newHashMap();
                    // TIMNoticeConstants为模板消息常量类 默认按照dataModel下发穿透数据
                    timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_PER_AUTH_SUC, dataModel, Lists.newArrayList(ConverterUtil.toString(user.getId())));
                    }
                    realPersonAuthIdVo.setRealPersonAuthId(entity.getId());
                    resultPoJo.setResult(realPersonAuthIdVo);
                }else{
                    resultPoJo.setCode(jsonObject.get("code").toString());
                    resultPoJo.setMsg(jsonObject.get("msg").toString());
                }

        }else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }


        return resultPoJo;
    }
}
