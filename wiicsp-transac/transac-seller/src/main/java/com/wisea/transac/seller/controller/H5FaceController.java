package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.common.po.seller.H5FacePo;
import com.wisea.transac.common.po.seller.RespondPo;
import com.wisea.transac.common.vo.seller.H5FaceVo;
import com.wisea.transac.common.vo.seller.RealPersonAuthIdVo;
import com.wisea.transac.seller.service.H5FaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "人脸核身")
@RestController
@RequestMapping("/w/H5Face")
public class H5FaceController {

    @Autowired
    private H5FaceService h5FaceService;

    /**
     * 获取人脸核身参数
     *
     * @param po
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/getParameters", method = RequestMethod.POST)
    @ApiOperation(nickname = "获取人脸核身参数", value = "获取人脸核身参数", notes = "获取人脸核身参数", httpMethod = "POST")
    public ResultPoJo<H5FaceVo> getParameters(@RequestBody H5FacePo po) throws Exception {
        return h5FaceService.getParameters(po);
    }

//    /**
//     * 添加信息
//     * @return
//     */
//    @DataCheck
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    @ApiOperation(nickname = "通过后新增认证信息", value = "通过后新增认证信息", notes = "通过后新增认证信息", httpMethod = "POST")
//    public ResultPoJo save(@RequestBody AddH5FacePo po) {
//        return h5FaceService.save(po);
//    }
//    /**
//     * 人脸采集图片
//     * @return
//     */
//    @DataCheck
//    @RequestMapping(value = "/saveFaceCollection", method = RequestMethod.POST)
//    @ApiOperation(nickname = "添加人脸采集图片", value = "添加人脸采集图片", notes = "添加人脸采集图片", httpMethod = "POST")
//    public ResultPoJo saveFaceCollection(@RequestBody AddH5FacePo po) {
//        return h5FaceService.saveFaceCollection(po);
//    }
//
//    /**
//     * 查询验证是否通过
//     * @param po
//     * @return
//     * @throws Exception
//     */
//    @DataCheck
//    @RequestMapping(value = "/getCheack", method = RequestMethod.POST)
//    @ApiOperation(nickname = "查询验证是否通过", value = "查询验证是否通过", notes = "查询验证是否通过", httpMethod = "POST")
//    public ResultPoJo<H5FaceVo> getCheack(@RequestBody AddH5FacePo po) throws Exception {
//        return h5FaceService.getCheack(po);
//    }

    /**
     * 人脸核身执行回调接口
     * @return
     */
    @DataCheck
    @RequestMapping(value = "/receiveCallback", method = RequestMethod.POST)
    @ApiOperation(nickname = "人脸核身执行回调接口", value = "人脸核身执行回调接口", notes = "人脸核身执行回调接口", httpMethod = "POST")
    public ResultPoJo<RealPersonAuthIdVo> receiveCallback(@RequestBody RespondPo po) throws Exception {
        return h5FaceService.receiveCallback(po);
    }

}
