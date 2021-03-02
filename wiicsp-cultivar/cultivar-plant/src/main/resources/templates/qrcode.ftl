<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <style type="text/css">
        *{
            margin: 0;
            padding: 0;
            font-size:14px;
            font-family: Arial Unicode MS;
        }
        ul,li{list-style: none;}
        .main{padding:0 px; 15px;}
        .section-ul li::after{
            display: block;
            content: "";
            height: 0;
            line-height: 0;
            clear: both;
        }
        .section-ul li{
            width: 600px;
            height: 145px;
            border:1px solid #888;
            padding:30px 5px;
            margin:0 auto;
            margin-bottom: 60px;
        }
        .section-ul li .section-ul-div1{
            float: left;
            margin:0 10px 0 5px;
        }
        .section-ul li .section-ul-div1 p{text-align: center;}
        .section-ul li .section-ul-div2{margin-left: 115px;}
        .section-ul li .section-ul-div2 dd{
            line-height: 30px;
            border-bottom: 1px solid #888;
        }
        @page {
            size:A4;
        }
        .pageNext{page-break-after: always;}
    </style>
</head>
<body>
<div class="main">
    <section>
        <ul class="section-ul">
            <#list qrCodeList as qrCode>
                <li>
                    <div class="section-ul-div1">
                        <img src="data:image/png;base64,${qrCode.qrCodeImgBase64}" width="100" height="100"/>
                        <p>扫一扫</p>
                    </div>
                    <div class="section-ul-div2">
                        <dl>
                            <dd>
                                <label>名称：</label>
                                <span>${qrCode.commName}<#if qrCode.commVarietName??>-${qrCode.commVarietName}</#if></span>
                            </dd>
                            <dd>
                                <label>地块：</label>
                                <span><#if qrCode.massifName??>${qrCode.massifName}</#if></span>
                            </dd>
                            <dd>
                                <label>企业：</label>
                                <span><#if qrCode.orgName??>${qrCode.orgName}</#if></span>
                            </dd>
                            <dd>
                                <label>编号：</label>
                                <span>${qrCode.rtspCode}</span>
                            </dd>
                        </dl>
                    </div>
                </li>
                <#if qrCode_index != 0 && (qrCode_index + 1) % 4 == 0 && (qrCode_index + 1) != qrCodeList?size >
                    <div class='pageNext'></div>
                </#if>
            </#list>
        </ul>
    </section>
</div>
</body>
</html>
