package com.wisea.transac.common.constants;

/**
 *
 * redis缓存key和分布式锁key
 * @author yangtao
 *
 */
public class RedisKeyConstants {

	/********************缓存key**********************/
	public static final String HP_CATG_TREE_LIST_KEY_FOR_INDEX = "HP_CATG_TREE_LIST_KEY_FOR_INDEX";// 首页显示的商品分类信息
	public static final String FRUITS_INDEX_NEAR_FOR_INDEX = "FRUITS_INDEX_NEAR_FOR_INDEX_";// 首页显示的水果指数最近的信息
	public static final String FRUITS_PRICE_NEAR_FOR_INDEX = "FRUITS_PRICE_NEAR_FOR_INDEX_";// 首页显示的水果价格最近的信息
	public static final String ADVER_MAGER_LIST_KEY = "ADVER_MAGER_LIST_KEY_";// 广告位广告列表信息的key
	public static final String INFORMATION_MAGE_TOP_PORTALS_KEY = "INFORMATION_MAGE_TOP_PORTALS_KEY";// 资讯门户列表Key
	public static final String INFORMATION_MAGE_TOP_INDEX_KEY = "INFORMATION_MAGE_TOP_INDEX_KEY";// 资讯交易系统首页Key
	public static final String BTA_FOR_INDEX = "BTA_FOR_INDEX";// 首页显示大宗交易列表
	public static final String REFUND_CODE_FIX = "REFUND_CODE_FIX"; //退货、退货退款编号key前缀（规则为前缀加12位随机数，没有过期时间）
	public static final String ORDER_CODE_FIX = "ORDER_CODE_FIX"; //订单编号key前缀（规则为前缀加12位随机数，没有过期时间）
	public static final String SETTLE_BILL_CODE_FIX = "SETTLE_BILL_CODE_FIX"; //结算单编号key前缀（规则为前缀加12位随机数，没有过期时间）
    // 商品单号key前缀
    public static final String COMM_PUB_INFO_FIX = "COMM_PUB_INFO_FIX";
    // 长协商品单号key前缀
    public static final String ORDER_INVO_APPL_FIX = "ORDER_INVO_APPL_FIX";//订单发票申请开票服务单号key前缀
    public static final String SETTLE_ORDER_INVO_APPL_FIX = "SETTLE_ORDER_INVO_APPL_FIX";//订单发票申请开票服务单号锁key
    public static final String WECHAT_MINI_PRO_OPENID = "WECHAT_MINI_PRO_OPENID_";//微信小程序openID的保存
    public static final String WECHAT_MINI_PRO_KEY = "WECHAT_MINI_PRO_KEY_";//微信小程序session_key的保存
    public static final String APP_LABEL_TAB_LIST = "APP_LABEL_TAB_LIST";//手机端产地列表TAB列表
    public static final String ZT_NUM_LIST_FIX = "ZT_NUM_LIST_FIX_";//自提码列表前缀
    public static final String JSZL_CATG_MAGE_LIST_FOR_JSZLLIST = "JSZL_CATG_MAGE_LIST_FOR_JSZLLIST";//	技术资料新增分类列表
    public static final String BYZ_INTROD_INFO_KEY = "BYZ_INTROD_INFO_KEY";//布依族介绍
    public static final String WCBY_XC_VIDEO_LIST_KEY = "WCBY_XC_VIDEO_LIST_KEY"; // 布依族推荐列表
    public static final String WCBY_ZXTJ_LIST_KEY = "WCBY_ZXTJ_LIST_KEY"; // 布依族推荐列表
    public static final String JSXT_JLTJ_LIST_KEY = "JSXT_JLTJ_LIST_KEY";// 技术学堂资料推荐列表
    public static final String JSXT_TJ_LIST_KEY = "JSXT_TJ_LIST_KEY";//技术学堂通知列表
    public static final String JSXT_HOST_LIST_KEY = "JSXT_HOST_LIST_KEY";// 技术学堂-热门推荐
    public static final String WACHAT_UNIONID_KEY = "WACHAT_UNIONID_";//微信小程序绑定ID
    public static final String WACHAT_SESSION_KEY = "WACHAT_SESSIONKEY_";//微信小程序sessionkey
    public static final String TRACE_BATCH_CACHE_KEY = "TRACE_BATCH_CACHE_KEY";//追溯批次编号缓存Key
    public static final String ENTP_AUTH_INFO_KEY = "ENTP_AUTH_INFO_KEY_";//企业信息编辑的缓存
    public static final String MOBILE_LOGIN_REFRESH_KEY = "MOBILE_LOGIN_REFRESH_KEY_";//手机端登陆后刷新token的key


	/************************分布式锁***********************/
	public static final String REFUND_CODE_LOCK = "REFUND_CODE_LOCK"; //退货、退货退款编号锁key
	public static final String ORDER_CODE_LOCK = "ORDER_CODE_LOCK"; //订单编号锁key
	public static final String SETTLE_BILL_CODE_LOCK = "SETTLE_BILL_CODE_LOCK"; //结算单编号锁key
    public static final String COMM_PUB_INFO_LOCK = "COMM_PUB_INFO_LOCK"; //商品单号key前缀
    public static final String ORDER_INVO_APPL_LOCK = "ORDER_INVO_APPL_LOCK";//订单发票申请开票服务单号锁key
    public static final String SETTLE_ORDER_INVO_APPL_LOCK = "SETTLE_ORDER_INVO_APPL_LOCK";//结算单发票申请开票服务单号锁key
    public static final String ZT_NUM_LOCK = "ZT_NUM_LOCK";//自提码锁key
    public static final String TRACE_BATCH_LOCK = "TRACE_BATCH_LOCK";//追溯批次编号锁Key
    public static final String SEL_MARKET_KEY = "SEL_MARKET_KEY_";// 小程序用户选择市场的缓存KEY
}
