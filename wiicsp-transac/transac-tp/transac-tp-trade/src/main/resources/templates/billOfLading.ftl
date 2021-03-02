<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <title>提货/发货单</title>
    <style>
      *{
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-size:14px;
        font-family: Arial Unicode MS;
      }
      @page{
        size: a4;
        margin: 20px 60px;
      }
      @page rotated {size: landscape;}
      body {
        page: rotated; //引用旋转
        line-height: 1;
      }
      .fl{float: left;}
      .fr{float: right;}
      .clearfix{
        display: block;
      }
      .clearfix:after{
        display: block;
        content: "";
        height: 0;
        line-height: 0;
        clear: both;
        vertical:hidden;
      }
      .table-main{width: 1000px;margin:10px auto;border:1px solid #000}
      .title{width: 1000px;font-size:28px;font-weight:bold;text-align:center}
      .table-main .t-title{padding:10px;}
      .table-main .t1{border:1px solid #000;width: 100%;border-left: none;border-right: none;}
      .table-main table{border-collapse:collapse; }
      .table-main table tr td{padding:9px;height: 38px;}
      .table-main .border-top{border-top: 1px solid #000;}
      .table-main .border-left{border-left: 1px solid #000;}
      .table-main .border-bottom{border-left: 1px solid #000;}
      .table-main .list-title{padding:10px;text-align: center;font-size: 18px;}
      .table-main .text-a-c{text-align: center;}
      .table-main .ml50{margin-left: 50px;}
      .table-main .t-bottom{padding:20px 10px;}
      .table-main .pt10{padding-top:10px;}
      .table-main .t-bottom .w35{width: 35%;}
    </style>
  </head>
  <body>
    <div class="title">
      提货/发货单
    </div>
    <div class="table-main">
      <div class="clearfix t-title">
        <div class="fl">订单编号：${billOfLad.ordNum}</div>
        <div class="fr">下单时间：${billOfLad.referOrdDateStr}</div>
      </div>
      <table class="t1" cellpadding="0">
        <tr>
          <td colspan="2">提货/收货方</td>
          <td colspan="2" class="border-left">备货方</td>
        </tr>
        <tr class="border-top">
          <td class="border-top">企业名称</td>
          <td class="border-left border-top">${billOfLad.authZtName!""}</td>
          <td class="border-left border-top">商家名称</td>
          <td class="border-left border-top">${billOfLad.sellerName!""}</td>
        </tr>
        <tr class="border-top">
          <td class="border-top">提货人</td>
          <td class="border-left border-top">${billOfLad.consigneeName!""}</td>
          <td class="border-left border-top">联系方式</td>
          <td class="border-left border-top">${billOfLad.ztTel!""}</td>
        </tr>
        <tr class="border-top">
          <td class="border-top">手机号码</td>
          <td class="border-left border-top">${billOfLad.consigneeTel!""}</td>
          <td class="border-left border-top">提货地址</td>
          <td class="border-left border-top">${billOfLad.thAddressInfo!""}</td>
        </tr>
      </table>

      <div class="list-title">货物清单</div>
      <table class="t1 t2" cellpadding="0">
        <tr class="border-top">
          <td>产品名称</td>
          <td class="border-left">规格</td>
          <td class="border-left">数量</td>
          <td class="border-left">单价（元）</td>
          <td class="border-left">包装说明</td>
          <td class="border-left">小计（元）</td>
        </tr>
        <#list billOfLad.ordCommRelas as ordCommRela>
          <tr class="border-top">
            <td class="border-top">${ordCommRela.commName}</td>
            <td class="border-left border-top">${ordCommRela.commSpec}</td>
            <td class="border-left border-top">${ordCommRela.commTotalWeight}斤</td>
            <td class="border-left border-top">${ordCommRela.unitWeightPrice}</td>
            <td class="border-left border-top">${ordCommRela.count}${ordCommRela.measUnitName}，每${ordCommRela.measUnitName}${ordCommRela.netWeight}斤</td>
            <td class="border-left border-top">${ordCommRela.priceCount}</td>
          </tr>
        </#list>
        <#if billOfLad.payMethodType = '1'>
          <tr class="border-top">
            <td colspan="5" class="text-a-c border-top">账期服务费（元）</td>
            <td class="border-left border-top">${billOfLad.zqSerCost}</td>
          </tr>
        </#if>
        <tr class="border-top">
          <td colspan="5" class="text-a-c border-top">合计（元）</td>
          <td class="border-left border-top">${billOfLad.payableAmount}</td>
        </tr>
      </table>

      <div class="t-bottom">
        <div class="clearfix">
          <div class="fl w35">支付方式：${billOfLad.payMethodTypeStr}</div>
          <div class="fl ml50">支付时间：${billOfLad.payOrdDateStr}</div>
        </div>
        <div class="clearfix pt10">
            <div class="fl w35">提货人签字：</div>
            <div class="fl ml50">销售员签字：</div>
          </div>
      </div>
    </div>

  </body>
</html>
