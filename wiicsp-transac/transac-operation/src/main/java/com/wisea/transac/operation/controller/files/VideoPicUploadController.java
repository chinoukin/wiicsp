package com.wisea.transac.operation.controller.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.vo.UploadVo;
import com.wisea.transac.operation.service.files.VideoPicUploadService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 文件上传的处理
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月16日
 * @version 1.0
 */
@Api(tags = "文件相关接口的扩展控制类")
@RestController
@Lazy
public class VideoPicUploadController {
	@Autowired
	private VideoPicUploadService videoPicUploadService;
	/**
	 * 上传视频并且获取第一帧的图片
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月16日
	 * @version 1.0
	 */
	@ApiOperation(value = "上传视频并且获取第一帧的图片(文件名称必须是[name])", notes = "上传文件,需要声明 Content-Type=multipart/form-data")
	@PostMapping(value = "/w/video/upload")
	@ApiImplicitParam(name = "viewName", value = "是否显示源文件名", dataType = "boolean", allowableValues = "0:否 1:是 false:否 true:是 ")
	public ResultPoJo<UploadVo> vedioUpload(MultipartFile upfile, MultipartHttpServletRequest request, boolean viewName)
			throws Exception {
		// 上传并且返回的处理
		return videoPicUploadService.videoUpload(upfile, request, viewName);
	}
}
