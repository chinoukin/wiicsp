package com.wisea.cultivar.common.constants;

import com.wisea.cloud.common.constants.ConstantError;

/**
 * 错误码返回值
 */
public class ConstantCodeMsg extends ConstantError {
    /**
     * 追溯错误信息 start
     */
    public static final String ERR_110 = "110";
    public static final String MSG_110 = "文件下载出现异常";

    /***********************【商品】服务错误信息【300开始】**********************/
    /**
     * 错误代码:300 品牌信息展示完成
     */
    public static final String ERR_300 = "300";

    public static final String MSG_300 = "列表数据加载成功";

    public static final String ERR_310 = "310";

    public static final String MSG_310 = "列表数据加载失败";

    public static final String ERR_000 = "000";

    public static final String MSG_000 = "操作成功";

    public static final String ERR_311 = "311";

    public static final String MSG_311 = "操作失败";

    public static final String ERR_312 = "312";

    public static final String MSG_312 = "已经与其他商品建立关系，不可以进行操作。";

    public static final String ERR_313 = "313";

    public static final String MSG_313 = "编号和名称不能重复哦！";

    public static final String ERR_314 = "314";

    public static final String MSG_314 = "属性名称已经存在";

    public static final String ERR_315 = "315";

    public static final String MSG_315 = "属性字段已经存在";

    public static final String ERR_316 = "316";

    public static final String MSG_316 = "此属性已添加";

    public static final String ERR_317 = "317";

    public static final String MSG_317 = "有未完成的退货申请，为避免大量红票的产生请务必完成所有退货申请后再开具发票";

    public static final String ERR_318 = "318";

    public static final String MSG_318 = "格式不正确";

    public static final String ERR_319 = "319";

    public static final String MSG_319 = "品牌名称已经存在";

    public static final String ERR_320 = "320";

    public static final String MSG_320 = "生产厂家已经存在";

    public static final String ERR_321 = "321";

    public static final String MSG_321 = "计量单位已经存在";

    public static final String ERR_322 = "322";

    public static final String MSG_322 = "此属性已配置给商品分类，不能删除。可在商品属性设置中删除关联关系后再进行删除";

    public static final String MSG_323 = "修改对应等级规格版本信息";

    public static final String MSG_324 = "修改商品表对应的版本信息";

    public static final String ERR_325 = "325";

    public static final String ERR_326 = "326";

    public static final String MSG_326 = "该状态下不可取消";
    /**
     * err code:399 price message not faultiness
     */
    public static final String ERR_399 = "399";
    /**
     * err message:399 price message not faultiness
     */
    public static final String MSG_399 = "价格信息不完善";
    /**
     * err code:398 commPitures message not faultiness
     */
    public static final String ERR_398 = "398";
    /**
     * err message:398 commPitures message not faultiness
     */
    public static final String MSG_398 = "商品图片最少一张最多4张";
    /**
     * err code:397 membId not faultiness
     */
    public static final String ERR_397 = "397";
    /**
     * err message:397 membId not faultiness
     */
    public static final String MSG_397 = "会员信息不完善";
    /**
     * err code:396 product details not faultiness
     */
    public static final String ERR_396 = "396";
    /**
     * err message:396 product details  not faultiness
     */
    public static final String MSG_396 = "商品详细信息不存在";
    /**
     * err code:395 product price not faultiness
     */
    public static final String ERR_395 = "395";
    /**
     * err message:396 product price not faultiness
     */
    public static final String MSG_395 = "商品价格信息不完善";
    /**
     * err code:394 product state not faultiness
     */
    public static final String ERR_394 = "394";
    /**
     * err message:394 product state not faultiness
     */
    public static final String MSG_394 = "商品状态或id不存在";
    /**
     * err code:393 product entpCertMage not faultiness
     */
    public static final String ERR_393 = "393";
    /**
     * err message:393 product entpCertMage not faultiness
     */
    public static final String MSG_393 = "商家证书信息不完善,请上传";
    /**
     * err code:392 freight formwork not faultiness
     */
    public static final String ERR_392 = "392";
    /**
     * err message:392  freight formwork not faultiness
     */
    public static final String MSG_392 = "运费模板信息不完善";
    /**
     * err code:391 freight formwork not faultiness
     */
    public static final String ERR_391 = "391";
    /**
     * err message:392  freight formwork not faultiness
     */
    public static final String MSG_391 = "商家运费模板设置中不支持配送该地区";
    /**
     * err code:390 freight formwork not faultiness
     */
    public static final String ERR_390 = "390";
    /**
     * err message:390  freight formwork not faultiness
     */
    public static final String MSG_390 = "很抱歉，该商品已下架";
    /**
     * err code:389 membInfo commpId not faultiness
     */
    public static final String ERR_389 = "389";
    /**
     * err message:389  membInfo commpId not faultiness
     */
    public static final String MSG_389 = "商家信息commpId不完善";
    /**
     * err code:387 area code not faultiness
     */
    public static final String ERR_387 = "387";
    /**
     * err message:387  area code not faultiness
     */
    public static final String MSG_387 = "area code 地区码不完善";
    /**
     * err code:386 area code not faultiness
     */
    public static final String ERR_386 = "386";
    /**
     * err message:386  area code not faultiness
     */
    public static final String MSG_386 = "很抱歉，该商品不存在！";
    /**
     * err code:385 commPubInfo key not faultiness
     */
    public static final String ERR_385 = "385";
    /**
     * err message:385 commPubInfo key not faultiness
     */
    public static final String MSG_385 = "发布商品key不存在！";
    /**
     * err code:384 commPubInfo key not faultiness
     */
    public static final String ERR_384 = "384";
    /**
     * err message:384 commPubInfo key not faultiness
     */
    public static final String MSG_384 = "不得购买自己发布的商品！";
    /**
     * err code:383 commPubInfo key not faultiness
     */
    public static final String ERR_383 = "383";
    /**
     * err message:383 commPubInfo key not faultiness
     */
    public static final String MSG_383 = "购买商品数量不得低于起批量";
    /**
     * err code:382 login not faultiness
     */
    public static final String ERR_382 = "382";
    /**
     * err message:382 login not faultiness
     */
    public static final String MSG_382 = "登录信息异常";
    /**
     * err code:381 membLabelType not faultiness
     */
    public static final String ERR_381 = "381";
    /**
     * err message:381 membLabelType not faultiness
     */
    public static final String MSG_381 = "检测报告或者品鉴报告类型不正确";
    /**
     * err code:380 membLabelType not faultiness
     */
    public static final String ERR_380 = "380";
    /**
     * err code:380 membLabelType not faultiness
     */
    public static final String MSG_380 = "订单提交失败(商品存在已下架或者库存不足)";
    /**
     * err code:379 membLabelType not faultiness
     */
    public static final String ERR_379 = "379";
    /**
     * err message:379 membLabelType not faultiness
     */
    public static final String MSG_379 = "检测或品鉴信息不全";
    /**
     * err code:378 membLabelType not faultiness
     */
    public static final String MSG_378 = "请先解除关联,在添加关联信息";
    /**
     * err code:377 commPubInfo not faultiness
     */
    public static final String ERR_377 = "377";
    /**
     * err message:377 commPubInfo not faultiness
     */
    public static final String MSG_377 = "商品信息不完善,请重试";
    /**
     * err code:376 product state not faultiness
     */
    public static final String ERR_376 = "376";
    /**
     * err message:376 product state not faultiness
     */
    public static final String MSG_376 = "商品id不存在";
    /**
     * err code:375 product agentPrice not faultiness
     */
    public static final String ERR_375 = "375";
    /**
     * err message:375 product agentPrice not faultiness
     */
    public static final String MSG_375 = "商品代理价信息有误";
    /**
     * err message:374 product agentPrice sessucces
     */
    public static final String MSG_374 = "设置商品代理价成功";
    /**
     * err code:373 redis product not faultiness
     */
    public static final String ERR_373 = "373";
    /**
     * err message:373 redis product not faultiness
     */
    public static final String MSG_373 = "请重新编辑上一步信息";
    /**
     * err code:372 cost system not faultiness
     */
    public static final String ERR_372 = "372";
    /**
     * err message:372 cost system not faultiness
     */
    public static final String MSG_372 = "获取服务费信息错误";
    /**
     * err code:371 product details agentStateType not faultiness
     */
    public static final String ERR_371 = "371";
    /**
     * err message:371 product details agentStateType not faultiness
     */
    public static final String MSG_371 = "商品代理价状态不完善";
    /**
     * err code:370 product details agentStateType not faultiness
     */
    public static final String ERR_370 = "370";
    /**
     * err message:370 product details agentStateType not faultiness
     */
    public static final String MSG_370 = "订单提交失败(商品库存不足)";
    /**
     * err code:369 product details agentStateType not faultiness
     */
    public static final String ERR_369 = "369";
    /**
     * err message: 369 product details agentStateType not faultiness
     */
    public static final String MSG_369 = "订单提交失败(商品已下架)";
    /**
     * err code:368 product details agentStateType not faultiness
     */
    public static final String ERR_368 = "368";
    /**
     * err message:368 product details agentStateType not faultiness
     */
    public static final String MSG_368 = "订单提交失败(商品已删除)";
    /**
     * err code:367 product details agentStateType not faultiness
     */
    public static final String ERR_367 = "367";
    /**
     * err message:367 product details agentStateType not faultiness
     */
    public static final String MSG_367 = "检疫合格证图片不能为空";
    /*** 商品分类存在子集，不能删除 */
    public static final String ERR_366 = "366";
    /*** 商品分类存在子集，不能删除 */
    public static final String MSG_366 = "商品分类存在子集，不能删除";
    /*** 该商品分类已关联商品，不能删除 */
    public static final String ERR_365 = "365";
    /*** 该商品分类已关联商品，不能删除 */
    public static final String MSG_365 = "该商品分类已关联商品，不能删除";
    /*** 分类名称【{0}】已存在 */
    public static final String ERR_364 = "364";
    /*** 分类名称【{0}】已存在 */
    public static final String MSG_364 = "分类名称【{0}】已存在";
    /**
     * err code:363 Variety name cannot be repeated
     */
    public static final String ERR_363 = "363";
    /**
     * err message:363 Variety name cannot be repeated
     */
    public static final String MSG_363 = "品种名称不能重复";
    /**
     * err code:362 Check at least one record
     */
    public static final String ERR_362 = "362";
    /**
     * err message:362 Check at least one record
     */
    public static final String MSG_362 = "至少勾选一条记录";
    /**
     * err code:361 The status of the information is all off the shelf
     */
    public static final String ERR_361 = "361";
    /**
     * err message:361 The status of the information is all off the shelf
     */
    public static final String MSG_361 = "信息状态都是已下架";
    /**
     * err code:360 The status of the information is all start the shelf
     */
    public static final String ERR_360 = "360";
    /**
     * err message:360 The status of the information is all start the shelf
     */
    public static final String MSG_360 = "信息状态都是待审核";
    /**
     * err code:359 Validity cannot be less than the current date
     */
    public static final String ERR_359 = "359";
    /**
     * err message:359 Validity cannot be less than the current date
     */
    public static final String MSG_359 = "销售截止日期不能小于当前日期";

    /**
     * err code:358 Commodity status can only be deleted when it is off the shelf
     */
    public static final String ERR_358 = "358";
    /**
     * err message:358 Commodity status can only be deleted when it is off the shelf
     */
    public static final String MSG_358 = "商品状态是已下架时才能删除";
    /**
     * err code:357 Imperfect packing Information of Commodity Specification
     */
    public static final String ERR_357 = "357";
    /**
     * err message:357 Imperfect packing Information of Commodity Specification
     */
    public static final String MSG_357 = "商品规格包装信息不完善";
    /**
     * err code:356 There can be no repetition of goods in the same trading mode
     */
    public static final String ERR_356 = "356";
    /**
     * err message:356 There can be no repetition of goods in the same trading mode
     */
    public static final String MSG_356 = "同一种交易模式下不能有重复的商品";
    /**
     * err code:355 You cannot add multiple preferential messages to the same item
     */
    public static final String ERR_355 = "355";
    /**
     * err message:355 You cannot add multiple preferential messages to the same item
     */
    public static final String MSG_355 = "不能给同一个商品添加多条优惠信息";
    /**
     * err code:354
     */
    public static final String ERR_354 = "354";
    /**
     * err message:354
     */
    public static final String MSG_354 = "同一种分类只能有一种映射关系";

    /**
     * err message:353 product state not faultiness
     */
    public static final String MSG_353 = "评价结果id不存在";
    /**
     * err code:353 product entpCertMage not faultiness
     */
    public static final String ERR_353 = "353";

    /**
     * err message:352 The evaluation results are repeated.
     */
    public static final String MSG_352 = "评价结果设置品种重复";
    /**
     * err code:352 The evaluation results are repeated.
     */
    public static final String ERR_352 = "352";

    /*** 该品种已关联商品，不能删除 */
    public static final String ERR_351 = "351";
    /*** 该品种已关联商品，不能删除 */
    public static final String MSG_351 = "该商品品种已关联商品，不能删除";
    /*** 标准品类已经关联了销售分类，不能修改 */
    public static final String ERR_350 = "350";
    /*** 标准品类已经关联了销售分类，不能修改 */
    public static final String MSG_350 = "标准品类已经关联了销售分类，不能修改";
    /**
     * err code:349 The status of the information is all off the shelf
     */
    public static final String ERR_349 = "349";
    /**
     * err message:349 The status of the information is all off the shelf
     */
    public static final String MSG_349 = "信息状态都是被驳回";
    /**
     * err code:348 The baseId is not null
     */
    public static final String ERR_348 = "348";
    /**
     * err message:348 The baseId is not null
     */
    public static final String MSG_348 = "基地信息不完善";

    /***********************【交易】服务错误信息【400开始】**********************/
    /*** 错误代码:400 请选择需要发货的订单，或选择的发货订单有待处理的退款申请*/
    public static final String ERR_400 = "400";
    /*** 错误消息:400 请选择需要发货的订单，或选择的发货订单有待处理的退款申请*/
    public static final String MSG_400 = "请选择需要发货的订单，或选择的发货订单有待处理的退款申请";

    /*** 错误代码:401 用户类型不正确*/
    public static final String ERR_401 = "401";
    /*** 错误消息:401 用户类型不正确*/
    public static final String MSG_401 = "用户类型不正确";

    /*** 错误代码:402 请选中一条未付款或待发货的订单数据*/
    public static final String ERR_402 = "402";
    /*** 错误消息:402 请选中一条未付款或待发货的订单数据*/
    public static final String MSG_402 = "请选中一条未付款或待发货的订单数据";

    /*** 错误代码:403 该状态下不允许本次操作*/
    public static final String ERR_403 = "403";
    /*** 错误消息:403 该状态下不允许本次操作*/
    public static final String MSG_403 = "该状态下不允许本次操作";
    /**
     * 错误代码:404 该商品的实时库存不足,请重新选择商品数量
     */
    public static final String ERR_404 = "404";
    /**
     * 错误消息:404 该商品的实时库存不足,请重新选择商品数量
     */
    public static final String MSG_404 = "该商品的实时库存不足,请重新选择商品数量";
    /*** 错误代码:405 申请数量大于剩余数量*/
    public static final String ERR_405 = "405";
    /*** 错误消息:405 申请数量大于剩余数量*/
    public static final String MSG_405 = "申请数量大于剩余数量";
    /*** 错误代码:406 已过操作日期禁止操作*/
    public static final String ERR_406 = "406";
    /*** 错误消息:406 已过操作日期禁止操作*/
    public static final String MSG_406 = "已过操作日期禁止操作";
    /*** 错误代码:407 已经申请过开票*/
    public static final String ERR_407 = "407";
    /*** 错误消息:407 已经申请过开票*/
    public static final String MSG_407 = "已经申请过开票";
    /*** 错误代码:408 很抱歉，该邮寄地址不在配送范围内 请重新选择邮寄地址！*/
    public static final String ERR_408 = "408";
    /*** 错误消息:408 很抱歉，该邮寄地址不在配送范围内 请重新选择邮寄地址！*/
    public static final String MSG_408 = "很抱歉，该邮寄地址不在配送范围内 请重新选择邮寄地址！";
    /*** 错误代码:409 调用支付服务出错，错误信息{0}*/
    public static final String ERR_409 = "409";
    /*** 错误消息:409 调用支付服务出错，错误信息{0}*/
    public static final String MSG_409 = "调用支付服务出错，错误信息{0}";
    /*** 错误代码:410 生成提货单出现异常*/
    public static final String ERR_410 = "410";
    /*** 错误消息:410 生成提货单出现异常*/
    public static final String MSG_410 = "生成提货单出现异常";

    /*** 错误代码:411 订单存在待处理的退款申请，不能发货。*/
    public static final String ERR_411 = "411";
    /*** 错误消息:411 订单存在待处理的退款申请，不能发货。*/
    public static final String MSG_411 = "订单存在待处理的退款申请，不能发货。";

    /*** 错误代码:412 存在已经删除的商品,请重新进行选择！*/
    public static final String ERR_412 = "412";
    /*** 错误消息:411 存在已经删除的商品,请重新进行选择！*/
    public static final String MSG_412 = "结算失败，存在已经删除的商品,请重新进行选择！";

    /*** 错误代码:413 结算失败，存在已经下架的商品,请重新进行选择！*/
    public static final String ERR_413 = "413";
    /*** 错误消息:413 结算失败，存在已经下架的商品,请重新进行选择！*/
    public static final String MSG_413 = "结算失败，存在已经下架的商品,请重新进行选择！";

    /*** 错误代码:414 结算失败，存在库存不足的商品,请重新进行选择！*/
    public static final String ERR_414 = "414";
    /*** 错误消息:414 结算失败，存在库存不足的商品,请重新进行选择！*/
    public static final String MSG_414 = "结算失败，存在库存不足的商品,请重新进行选择！";
    /*** 错误代码:415 时间已经超过系统对账日，无法取消提前出帐*/
    public static final String ERR_415 = "415";
    /*** 错误消息:415 时间已经超过系统对账日，无法取消提前出帐*/
    public static final String MSG_415 = "时间已经超过系统对账日，无法取消提前出帐";

    /*** 错误代码:416 订单有商品未提货*/
    public static final String ERR_416 = "416";
    /*** 错误消息:416 订单有商品未提货*/
    public static final String MSG_416 = "订单有商品未提货";

    /*** 错误代码:417 订单账期支付错误*/
    public static final String ERR_417 = "417";
    /*** 错误消息:417 订单有商品未提货*/
    public static final String MSG_417 = "订单账期支付错误";
    /*** 错误代码:418 滞纳金比例不能超过*/
    public static final String ERR_418 = "418";
    /*** 错误消息:418 滞纳金比例不能超过*/
    public static final String MSG_418 = "滞纳金比例不能超过：{0}%";
    /*** 错误代码:419 采购商已添加过账期支付设置，不能重复添加*/
    public static final String ERR_419 = "419";
    /*** 错误消息:419 采购商已添加过账期支付设置，不能重复添加*/
    public static final String MSG_419 = "采购商已添加过账期支付设置，不能重复添加";
    /*** 错误代码:420 采购商有未完成的结算单*/
    public static final String ERR_420 = "420";
    /*** 错误消息:420 采购商有未完成的结算单*/
    public static final String MSG_420 = "采购商有未完成的结算单";
    /*** 错误代码:421 采购商有未生成结算单的订单*/
    public static final String ERR_421 = "421";
    /*** 错误消息:421 采购商有未生成结算单的订单*/
    public static final String MSG_421 = "采购商有未生成结算单的订单";
    /*** 错误代码:422 当前账户不是企业类型或企业认证未通过，不能开通账期支付功能*/
    public static final String ERR_422 = "422";
    /*** 错误消息:422 当前账户不是企业类型或企业认证未通过，不能开通账期支付功能*/
    public static final String MSG_422 = "当前账户不是企业类型或企业认证未通过，不能开通账期支付功能";
    /*** 错误代码:423 您已经提醒采购商还款，请等待采购商还款*/
    public static final String ERR_423 = "423";
    /*** 错误消息:423 您已经提醒采购商还款，请等待采购商还款*/
    public static final String MSG_423 = "您已经提醒采购商还款，请等待采购商还款";
    /*** 错误代码:424 当前合同不允许下单*/
    public static final String ERR_424 = "424";
    /*** 错误消息:424 当前合同不允许下单*/
    public static final String MSG_424 = "当前合同不允许下单";
    /*** 错误代码:425 输入的自提码不存在*/
    public static final String ERR_425 = "425";
    /*** 错误消息:425 输入的自提码不存在*/
    public static final String MSG_425 = "输入的自提码不存在";
    /*** 错误代码:426 商品提货重量大于下单重量*/
    public static final String ERR_426 = "426";
    /*** 错误消息:426 商品提货重量大于下单重量*/
    public static final String MSG_426 = "商品提货重量大于下单重量";
    /*** 错误代码:427 批次不存在*/
    public static final String ERR_427 = "427";
    /*** 错误消息:427 批次不存在*/
    public static final String MSG_427 = "批次不存在";
    /*** 错误代码:455 当前请求数据权限有误*/
    public static final String ERR_455 = "455";
    /*** 错误消息:455 当前请求数据权限有误*/
    public static final String MSG_455 = "当前请求数据权限有误";
    /*** 错误代码:413 商品价格发生变动！*/
    public static final String ERR_456 = "456";
    /*** 错误消息:456 商品价格发生变动！*/
    public static final String MSG_456 = "商品价格发生变动！";
    /*** 错误代码:457 数据不属于当前用户所在档口，没有权限操作*/
    public static final String ERR_457 = "457";
    /*** 错误消息:457 数据不属于当前用户所在档口，没有权限操作*/
    public static final String MSG_457 = "数据不属于当前用户所在档口，没有权限操作";
    /*** 错误代码:458 当前状态下不能修改或申请发票*/
    public static final String ERR_458 = "458";
    /*** 错误消息:458 当前状态下不能修改或申请发票*/
    public static final String MSG_458 = "当前状态下不能修改或申请发票！";
    /*** 错误代码:459 当前状态下结算单不能进行该操作*/
    public static final String ERR_459 = "459";
    /*** 错误消息:459 当前状态下结算单不能进行该操作*/
    public static final String MSG_459 = "当前状态下结算单不能进行该操作！";

    /*** 错误代码:501 该手机号已经注册*/
    public static final String ERR_501 = "501";
    /*** 错误消息:501 该手机号已经注册*/
    public static final String MSG_501 = "该手机号已经注册";
    /*** 错误代码:502 该用户名已经存在*/
    public static final String ERR_502 = "502";
    /*** 错误消息:502 该用户名已经存在*/
    public static final String MSG_502 = "该用户名已经存在";
    /*** 错误代码:503 手机验证码不正确*/
    public static final String ERR_503 = "503";
    /*** 错误消息:503 手机验证码不正确*/
    public static final String MSG_503 = "手机验证码不正确";
    /*** 错误代码:504 密码和确认密码不一致，请重新输入。*/
    public static final String ERR_504 = "504";
    /*** 错误消息:504 密码和确认密码不一致，请重新输入。*/
    public static final String MSG_504 = "密码和确认密码不一致，请重新输入。";
    /*** 错误代码:505 用户名不存在。*/
    public static final String ERR_505 = "505";
    /*** 错误消息:505 用户名不存在。*/
    public static final String MSG_505 = "用户名不存在。";
    /*** 错误代码:506 验证码发送失败。*/
    public static final String ERR_506 = "506";
    /*** 错误消息:506 验证码发送失败。*/
    public static final String MSG_506 = "验证码发送失败。";
    /*** 错误代码:507 密码修改失败,请重试。*/
    public static final String ERR_507 = "507";
    /*** 错误消息:507 密码修改失败,请重试。*/
    public static final String MSG_507 = "密码修改失败,请重试。";
    /*** 错误代码:508 验证信息不正确或已过期,请重试。*/
    public static final String ERR_508 = "508";
    /*** 错误消息:508 验证信息不正确或已过期,请重试。*/
    public static final String MSG_508 = "验证信息不正确或已过期,请重试。";
    /*** 错误代码:509 验证信息不正确或已过期,请重试。*/
    public static final String ERR_509 = "509";
    /*** 错误消息:509 验证信息不正确或已过期,请重试。*/
    public static final String MSG_509 = "企业图片最多能上传5张。";
    /*** 错误代码:510 商家不存在,请重试。*/
    public static final String ERR_510 = "510";
    /*** 错误消息:510 商家不存在,请重试。*/
    public static final String MSG_510 = "商家不存在,请重试。";
    /*** 错误代码:511 商家资料信息审核中,不能修改。*/
    public static final String ERR_511 = "511";
    /*** 错误消息:511 商家资料信息审核中,不能修改。*/
    public static final String MSG_511 = "商家资料信息审核中,不能修改。";
    /*** 错误代码:512 新密码和确认密码不一致。*/
    public static final String ERR_512 = "512";
    /*** 错误消息:512 新密码和确认密码不一致。*/
    public static final String MSG_512 = "新密码和确认密码不一致。";
    /*** 错误代码:513 会员不存在。*/
    public static final String ERR_513 = "513";
    /*** 错误消息:513 会员不存在。*/
    public static final String MSG_513 = "会员不存在。";
    /*** 错误代码:514 商家ID不存在。*/
    public static final String ERR_514 = "514";
    /*** 错误消息:514 会员不存在。*/
    public static final String MSG_514 = "商家ID不存在。";
    /*** 错误代码:515 已经存在20个子账户，不能在新增。*/
    public static final String ERR_515 = "515";
    /*** 错误消息:515 已经存在20个子账户，不能在新增。*/
    public static final String MSG_515 = "已经存在20个子账户,不能在新增.";
    /*** 错误代码:516 用户昵称已经存在。*/
    public static final String ERR_516 = "516";
    /*** 错误消息:516 用户昵称已经存在*/
    public static final String MSG_516 = "用户昵称已经存在.";
    /*** 错误代码:517 用户没有进行绑定。*/
    public static final String ERR_517 = "517";
    /*** 错误消息:517 用户没有进行绑定*/
    public static final String MSG_517 = "用户没有进行绑定。";
    /*** 错误代码:40163 CODE已经被使用。*/
    public static final String ERR_40163 = "40163";
    /*** 错误消息:40163 CODE已经被使用*/
    public static final String MSG_40163 = "CODE已经被使用";
    /*** 错误代码:518 openid已经存在。*/
    public static final String ERR_518 = "518";
    /*** 错误消息:518 openid已经存在*/
    public static final String MSG_518 = "该账户已经绑定其他微信账号";
    /*** 错误代码:519 该银行卡号已经添加,不能重复添加。*/
    public static final String ERR_519 = "519";
    /*** 错误消息:519 该银行卡号已经添加,不能重复添加*/
    public static final String MSG_519 = "该银行卡号已经添加,不能重复添加";
    /*** 错误代码:520 只能上传jpg/png文件！*/
    public static final String ERR_520 = "520";
    /*** 错误消息:520 只能上传jpg/png文件！*/
    public static final String MSG_520 = "只能上传jpg/png文件！";
    /*** 错误代码:521 图片上传失败！*/
    public static final String ERR_521 = "521";
    /*** 错误消息:521 图片上传失败！*/
    public static final String MSG_521 = "图片上传失败！";
    /*** 错误代码:522 图片超过限定大小，最大5M*/
    public static final String ERR_522 = "522";
    /*** 错误消息:522 图片超过限定大小，最大5M*/
    public static final String MSG_522 = "图片超过限定大小，最大5M";
    /*** 错误代码:523 第三方审核操作异常*/
    public static final String ERR_523 = "523";
    /*** 错误消息:523 第三方审核操作异常*/
    public static final String MSG_523 = "第三方审核操作异常";
    /*** 错误代码:524 用户信息解密异常*/
    public static final String ERR_524 = "524";
    /*** 错误消息:524 用户信息解密异常*/
    public static final String MSG_524 = "用户信息解密异常。";
    /*** 错误代码:525 邮箱验证码不能为空*/
    public static final String ERR_525 = "525";
    /*** 错误消息:525 邮箱验证码不能为空*/
    public static final String MSG_525 = "邮箱验证码不能为空。";
    /*** 错误代码:526 邮箱验证码不正确*/
    public static final String ERR_526 = "526";
    /*** 错误消息:526 邮箱验证码不正确*/
    public static final String MSG_526 = "邮箱验证码不正确。";
    /*** 错误代码:527 会员类型不存在*/
    public static final String ERR_527 = "527";
    /*** 错误消息:527 会员类型不存在*/
    public static final String MSG_527 = "会员类型不存在。";
    /*** 错误代码:528 手机号码不存在*/
    public static final String ERR_528 = "528";
    /*** 错误消息:528 手机号码不存在*/
    public static final String MSG_528 = "手机号码不存在。";
    /*** 错误代码:529 企业名称已经存在*/
    public static final String ERR_529 = "529";
    /*** 错误消息:529 企业名称已经存在*/
    public static final String MSG_529 = "企业名称已经存在。";
    /*** 错误代码:530 该企业名称已经注册过*/
    public static final String ERR_530 = "530";
    /*** 错误消息:530 该企业名称已经注册过*/
    public static final String MSG_530 = "该企业名称已经注册过。";
    /*** 错误代码:531 邮箱验证码发送失败*/
    public static final String ERR_531 = "531";
    /*** 错误消息:531 邮箱验证码发送失败*/
    public static final String MSG_531 = "邮箱验证码发送失败。";
    /*** 错误代码:532 UnionId不正确*/
    public static final String ERR_532 = "532";
    /*** 错误消息:532 邮箱验证码发送失败*/
    public static final String MSG_532 = "UnionId不正确。";
    /*** 错误代码:533 该企业还没有商户编号,不能直接签约通过。*/
    public static final String ERR_533 = "533";
    /*** 错误消息:533 该企业还没有商户编号,不能直接签约通过。*/
    public static final String MSG_533 = "该企业还没有商户编号,不能直接签约通过。";
    /*** 错误代码:534 数据不属于当前用户，没有权限操作。*/
    public static final String ERR_534 = "534";
    /*** 错误消息:534 数据不属于当前用户，没有权限操作*/
    public static final String MSG_534 = "数据不属于当前用户，没有权限操作";
    /*** 错误代码:535 基地名称不能修改*/
    public static final String ERR_535 = "535";
    /*** 错误消息:535 基地名称不能修改*/
    public static final String MSG_535 = "基地名称不能修改";
    /*** 错误代码:536 名称重复*/
    public static final String ERR_536 = "536";
    /*** 错误消息:536 名称重复*/
    public static final String MSG_536 = "名称重复";
    /*** 错误代码:537 数据存在关联在售商品，不能删除*/
    public static final String ERR_537 = "537";
    /*** 错误消息:537 数据存在关联在售商品，不能删除*/
    public static final String MSG_537 = "数据存在关联在售商品，不能删除";
    /*** 错误代码:9821 该微信用户需要授权用户信息。*/
    public static final String ERR_9821 = "9821";
    /*** 错误消息:9821 该微信用户需要授权用户信息*/
    public static final String MSG_9821 = "该微信用户需要授权用户信息。";


    /*** 错误代码:601 批次名称已存在*/
    public static final String ERR_601 = "601";
    /*** 错误消息:601 批次名称已存在*/
    public static final String MSG_601 = "批次名称已存在";
    /*** 错误代码:602 牛源牧场名称已存在*/
    public static final String ERR_602 = "602";
    /*** 错误消息:602 牛源牧场名称已存在*/
    public static final String MSG_602 = "牛源牧场名称已存在";

    /*** 错误代码:650 请上传10张以内的照片*/
    public static final String ERR_650 = "650";
    /*** 错误消息:650 请上传10张以内的照片*/
    public static final String MSG_650 = "请上传10张以内的照片";
    /*** 错误代码:651 养殖栏名称已存在*/
    public static final String ERR_651 = "651";
    /*** 错误消息:651 养殖栏名称已存在*/
    public static final String MSG_651 = "养殖栏名称已存在";
    /*** 错误代码:652 养殖栋名称已存在*/
    public static final String ERR_652 = "652";
    /*** 错误消息:652 养殖栋名称已存在*/
    public static final String MSG_652 = "养殖栋名称已存在";
    /*** 错误代码:653 养殖场名称已存在*/
    public static final String ERR_653 = "653";
    /*** 错误消息:653 养殖场名称已存在*/
    public static final String MSG_653 = "养殖场名称已存在";

    /*** 错误代码:700 消息模版不存在。*/
    public static final String ERR_700 = "700";
    /*** 错误消息:700 消息模版不存在。*/
    public static final String MSG_700 = "消息模版不存在。";
    /*** 错误代码:701 采购商名称不存在*/
    public static final String ERR_701 = "701";
    /*** 错误消息:701 采购商名称不存在*/
    public static final String MSG_701 = "采购商名称不存在。";
    /*** 错误代码:702 合同信息不存在*/
    public static final String ERR_702 = "702";
    /*** 错误消息:702 合同信息不存在*/
    public static final String MSG_702 = "合同信息不存在。";
    /*** 错误代码:703 您没有该操作的权限*/
    public static final String ERR_703 = "703";
    /*** 错误消息:703 您没有该操作的权限*/
    public static final String MSG_703 = "您没有该操作的权限。";
    /*** 错误代码:704 数据有更改,请刷新后操作*/
    public static final String ERR_704 = "704";
    /*** 错误消息:704 数据有更改,请刷新后操作*/
    public static final String MSG_704 = "数据有更改,请刷新后操作";
    /*** 错误代码:705 合同下有未完成的订单,不能够解除长协合同。*/
    public static final String ERR_705 = "705";
    /*** 错误消息:705 合同下有未完成的订单,不能够解除长协合同。*/
    public static final String MSG_705 = "合同下有未完成的订单,不能够解除长协合同。";
    /*** 错误代码:706 消息发送异常。*/
    public static final String ERR_706 = "706";
    /*** 错误消息:706 消息发送异常。*/
    public static final String MSG_706 = "消息发送异常。";
    /*** 错误代码:707 消息不存在。*/
    public static final String ERR_707 = "707";
    /*** 错误消息:707 消息不存在。*/
    public static final String MSG_707 = "消息不存在。";
    /*** 错误代码:708 长协合同状态不是申请解除,不能够强制解除。*/
    public static final String ERR_708 = "708";
    /*** 错误消息:708 长协合同状态不是申请解除,不能够强制解除。*/
    public static final String MSG_708 = "长协合同状态不是申请解除,不能够强制解除。";
    /*** 错误代码:709 合同模版信息不存在。*/
    public static final String ERR_709 = "709";
    /*** 错误消息:709 合同模版信息不存在。*/
    public static final String MSG_709 = "合同模版信息不存在。";
    /*** 错误代码:710 长协合同编码不正确。*/
    public static final String ERR_710 = "710";
    /*** 错误消息:710 长协合同编码不正确。*/
    public static final String MSG_710 = "长协合同编码不正确。";
    /*** 错误代码:711 数据不存在。*/
    public static final String ERR_711 = "711";
    /*** 错误消息:711数据不存在。*/
    public static final String MSG_711 = "数据不存在。";
    /*** 错误代码:712 后台水果指数验证错误。*/
    public static final String ERR_712 = "712";
    /*** 错误代码:713 广告位名称已经存在。*/
    public static final String ERR_713 = "713";
    /*** 错误消息:713 广告位名称已经存在。*/
    public static final String MSG_713 = "广告位名称已经存在。";
    /*** 错误代码:714 后台水果价格验证错误。*/
    public static final String ERR_714 = "714";
    /*** 错误代码:715 采购商不能是商家本身。*/
    public static final String ERR_715 = "715";
    /*** 错误消息:715 采购商不能是商家本身。*/
    public static final String MSG_715 = "采购商不能是商家本身。";
    /*** 错误消息:716 该会员没有商铺信息。*/
    public static final String ERR_716 = "716";
    /*** 错误消息:716 该会员没有商铺信息。*/
    public static final String MSG_716 = "该会员没有商铺信息。";
    /*** 错误消息:717 父ID不存在。*/
    public static final String ERR_717 = "717";
    /*** 错误消息:717 父ID不存在。*/
    public static final String MSG_717 = "父ID不存在。";
    /*** 错误消息:718 分类只支持两级节点。*/
    public static final String ERR_718 = "718";
    /*** 错误消息:718 分类只支持两级节点。*/
    public static final String MSG_718 = "分类只支持两级节点。";
    /*** 错误消息:719 店铺不存在 */
    public static final String ERR_719 = "719";
    /*** 错误消息:719 店铺不存在*/
    public static final String MSG_719 = "店铺不存在";

    /*** 错误代码:801 分类名称不能重复。*/
    public static final String ERR_801 = "801";
    /*** 错误消息:801 分类名称不能重复。*/
    public static final String MSG_801 = "分类名称不能重复。";
    /*** 错误代码:802 技术资料分类不存在。*/
    public static final String ERR_802 = "802";
    /*** 错误消息:802 技术资料分类不存在。*/
    public static final String MSG_802 = "技术资料分类不存在。";
    /*** 错误代码:803 技术资料信息不存在。*/
    public static final String ERR_803 = "803";
    /*** 错误消息:803 技术资料信息不存在。*/
    public static final String MSG_803 = "技术资料信息不存在。";
    /*** 错误代码:804 推荐中已经存在该技术资料信息。*/
    public static final String ERR_804 = "804";
    /*** 错误消息:804 推荐中已经存在该技术资料信息。*/
    public static final String MSG_804 = "推荐中已经存在该技术资料信息。";
    /*** 错误代码:805 显示顺序已经存在。*/
    public static final String ERR_805 = "805";
    /*** 错误消息:805 显示顺序已经存在。*/
    public static final String MSG_805 = "显示顺序已经存在。";
    /*** 错误代码:806 资讯列表已经存在。*/
    public static final String ERR_806 = "806";
    /*** 错误消息:806 资讯列表已经存在。*/
    public static final String MSG_806 = "资讯列表已经存在。";
    /*** 错误代码:807 资讯列表不存在。*/
    public static final String ERR_807 = "807";
    /*** 错误消息:807 资讯列表不存在。*/
    public static final String MSG_807 = "资讯列表不存在。";
    /*** 错误代码:808 请选择商品信息。*/
    public static final String ERR_808 = "808";
    /*** 错误消息:808 请选择商品信息。*/
    public static final String MSG_808 = "请选择商品信息。";
    /*** 错误代码:809 解析错误。*/
    public static final String ERR_809 = "809";
    /*** 错误消息:809  解析错误。*/
    public static final String MSG_809 = "解析错误。";
    /*** 错误代码:810  绑定失败,请重试。*/
    public static final String ERR_810 = "810";
    /*** 错误消息:810  绑定失败,请重试。*/
    public static final String MSG_810 = "绑定失败,请重试。";
    /*** 错误代码:811 该手机号没有权限登录到小程序端。*/
    public static final String ERR_811 = "811";
    /*** 错误消息:811  该手机号没有权限登录到小程序端。*/
    public static final String MSG_811 = "该手机号没有权限登录到小程序端。";
    /*** 错误代码:812 旧手机号不正确。*/
    public static final String ERR_812 = "812";
    /*** 错误消息:812 旧手机号不正确。*/
    public static final String MSG_812 = "旧手机号不正确.";
    /*** 错误代码:813 该手机号已经绑定其他账号。*/
    public static final String ERR_813 = "813";
    /*** 错误消息:813 该手机号已经绑定其他账号。*/
    public static final String MSG_813 = "该手机号已经绑定其他账号.";


    /*** 错误代码:850 当前账号暂无使用权限，请联系管理员配置！*/
    public static final String ERR_850 = "850";
    /*** 错误消息:850 当前账号暂无使用权限，请联系管理员配置！*/
    public static final String MSG_850 = "当前账号暂无使用权限，请联系管理员配置!";
    /*** 错误代码:851 当前企业未通过认证，无权登录权限!*/
    public static final String ERR_851 = "851";
    /*** 错误消息:851 当前企业未通过认证，无权登录权限!*/
    public static final String MSG_851 = "当前您所在的企业未通过认证，您无权限登录!";
    /*** 错误代码:852 企业信息审核状态审核中的情况不能够修改数据.*/
    public static final String ERR_852 = "852";
    /*** 错误消息:852 企业信息审核状态审核中的情况不能够修改数据.*/
    public static final String MSG_852 = "企业信息审核状态审核中的情况不能够修改数据.";
    /*** 错误代码:853 该会员已经存在，不能重复添加.*/
    public static final String ERR_853 = "853";
    /*** 错误消息:853该会员已经存在，不能重复添加*/
    public static final String MSG_853 = "该会员已经存在，不能重复添加";
    /*** 错误代码:854 采购主体下的采购业务员账号不能添加为会员。*/
    public static final String ERR_854 = "854";
    /*** 错误消息:854 采购主体下的采购业务员账号不能添加为会员。*/
    public static final String MSG_854 = "采购主体下的采购业务员账号不能添加为会员。";
    /*** 错误代码:855 员工不能注册为商家会员,请解绑后再进行操作。*/
    public static final String ERR_855 = "855";
    /*** 错误消息:855 员工不能注册为商家会员,请解绑后再进行操作。*/
    public static final String MSG_855 = "员工不能注册为商家会员,请解绑后再进行操作。";
    /*** 错误代码:856 当前所属市场暂未添加交易区,请添加后操作。*/
    public static final String ERR_856 = "856";
    /*** 错误消息:856 当前所属市场暂未添加交易区,请添加后操作。*/
    public static final String MSG_856 = "当前所属市场暂未添加交易区,请添加后操作。";

    /*** 错误代码:912 当前登录信息异常。*/
    public static final String ERR_912 = "912";
    /*** 错误消息:912 当前登录信息异常。*/
    public static final String MSG_912 = "当前登录信息异常。";
    /*** 错误代码:913 管理员权限。*/
    public static final String ERR_913 = "913";
    /*** 错误消息:913 管理员权限。*/
    public static final String MSG_913 = "管理员权限。";
    /*** 错误代码:914 角色名称已经存在。*/
    public static final String ERR_914 = "914";
    /*** 错误消息:914 角色名称已经存在。*/
    public static final String MSG_914 = "角色名称已经存在。";
    /*** 错误代码:915 该角色正在被使用,不能够删除。*/
    public static final String ERR_915 = "915";
    /*** 错误消息:915 该角色正在被使用,不能够删除。*/
    public static final String MSG_915 = "该角色正在被使用,不能够删除。";
    /*** 错误代码:916 该角色不存在。*/
    public static final String ERR_916 = "916";
    /*** 错误消息:916 该角色不存在。*/
    public static final String MSG_916 = "该角色不存在。";
    /*** 错误消息:917 消息发送失败 */
    public static final String ERR_917 = "917";
    /*** 错误代码:917 消息发送失败 */
    public static final String MSG_917 = "消息发送失败:";
    /*** 错误消息:918 消息部分发送失败 */
    public static final String ERR_918 = "918";
    /*** 错误代码:918 消息部分发送失败 */
    public static final String MSG_918 = "消息部分发送失败:";
    /*** 日期常量:系统上线年份，用于前端日期下拉选(测试用2014)。*/
    public static final String ONLINE_YEAR = "2014";
    /*** 错误代码:950 有待审核中的个体工商户请审核通过在提交。*/
    public static final String ERR_950 = "950";
    /*** 错误消息:950 添加认证信息校验。*/
    public static final String MSG_950 = "有待审核中的个体工商户请审核通过在提交。";
    /*** 错误代码:951 有待审核中的企业请审核通过在提交。*/
    public static final String ERR_951 = "951";
    /*** 错误消息:951 添加认证信息校验。*/
    public static final String MSG_951 = "有待审核中的企业请审核通过在提交。";
    /*** 错误代码:952 由于长时间未使用,请重新登录。*/
    public static final String ERR_952 = "952";
    /*** 错误消息:952 由于长时间未使用,请重新登录。*/
    public static final String MSG_952 = "由于长时间未使用,请重新登录。";
    /*** 错误代码:953 用户信息有变更,请重新登录。*/
    public static final String ERR_953 = "953";
    /*** 错误消息:953 用户信息有变更,请重新登录。*/
    public static final String MSG_953 = "用户信息有变动,请重新登录。";
}
