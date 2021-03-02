package com.wisea.transac.tp.system.controller;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.Dict;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.po.product.CommDataListPo;
import com.wisea.transac.common.po.system.DictUpdatePo;
import com.wisea.transac.tp.system.mss.DictServiceMss;
import com.wisea.transac.tp.system.mss.ProductMss;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo:字典值未确定
 *
 * @author wangjiahao
 * @since 2020/5/29 2:07 下午
 */
@RestController
@RequestMapping("/w/commCheckSetting")
@Api(tags = "商品审核设置")
public class CommCheckSettingController {

    @Autowired
    private DictServiceMss dictServiceMss;
    @Autowired
    private ProductMss productMss;

    @PostMapping("/get")
    @ApiOperation("查询")
    public ResultPoJo<Dict> getSetting() {
        LongIdPo po = new LongIdPo();
        po.setId(1950L);
        return dictServiceMss.get(po);
    }

    @PostMapping("/set")
    @ApiOperation("设置")
    public ResultPoJo setSetting() {
        ResultPoJo<Dict> dict = getSetting();
        if (dict.getResult() != null) {
            Dict result = dict.getResult();
            if (result.getValue().equals(DictConstants.ENTP_COMM_PUB_EXAM_TYPE_0)) {
                result.setValue(DictConstants.ENTP_COMM_PUB_EXAM_TYPE_1);
                result.setLabel("否");
            } else {
                result.setValue(DictConstants.ENTP_COMM_PUB_EXAM_TYPE_0);
                result.setLabel("是");

                ResultPoJo resultPoJo = productMss.updateCommPubState(new CommDataListPo());
                if (!resultPoJo.getCode().equals(ConstantCodeMsg.NOMAL)) {
                    return resultPoJo;
                }
            }
            DictUpdatePo po = new DictUpdatePo();
            ConverterUtil.copyProperties(result, po);
            dictServiceMss.set(po);
        }
        return new ResultPoJo();
    }

}
