package com.wisea.transac.operation.service.files;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.wisea.transac.operation.utils.VideoToImgUtils;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.vo.FileVo;
import com.wisea.cloud.common.vo.UploadVo;
import com.wisea.cloud.files.po.Base64ImgPo;
import com.wisea.cloud.files.service.FastDFSClientService;

/**
 * 文件相关接口的扩展
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月16日
 * @version 1.0
 */
@Service
@Lazy
public class VideoPicUploadService {

	@Autowired
	private FastDFSClientService fastDFSClientService;

	/**
	 * 上传视频并且获取第一帧的图片
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月16日
	 * @version 1.0
	 * @throws IOException
	 */
	public ResultPoJo<UploadVo> videoUpload(MultipartFile upfile, MultipartHttpServletRequest request, boolean viewName) throws IOException{
		// 返回值初期化处理
		ResultPoJo<UploadVo> result = new ResultPoJo<UploadVo>();
		UploadVo entityVo = new UploadVo();
		Map<String, List<FileVo>> filesMap = Maps.newHashMap();
		// 获取用户信息
		User user = SystemUtils.getUser();
	    String createBy = ConverterUtil.toString(user.getId());
	    // 上传视频的处理
	    ResultPoJo<UploadVo> videoResult = fastDFSClientService.uploadFile(request, FastDFSClientService.TYPE_VIDEO, viewName, null, createBy);
		if(!ConstantError.NOMAL.equals(videoResult.getCode())){
			return videoResult;
		}
		// 视频上传后的结果
		List<FileVo> videoFile = videoResult.getResult().getFilesMap().get("name");
		filesMap.put("video",videoFile);
		// 第一帧图片的处理
		Iterator<String> itr = request.getFileNames();
        // 只传递一个文件
		ResultPoJo<UploadVo> imgResult = new ResultPoJo<UploadVo>();
		String name = IdGen.uuid()+".png";
		while (itr.hasNext()) {
        	String paramName = itr.next();
            // 获取需要上传的文件
            List<MultipartFile> mfList = request.getFiles(paramName);
            for (MultipartFile mf : mfList) {
            	InputStream inputStream = VideoToImgUtils.getVideoPic(mf.getInputStream());
            	byte[] bytes = IOUtils.toByteArray(inputStream);
            	String encoded = Base64.getEncoder().encodeToString(bytes);
            	Base64ImgPo base64ImgPo = new Base64ImgPo();
            	base64ImgPo.setImgBase64(encoded);
            	base64ImgPo.setImgName(name);
            	imgResult = fastDFSClientService.uplodImgBase64(base64ImgPo);
            }
        }
		if(!ConstantError.NOMAL.equals(imgResult.getCode())){
			return imgResult;
		}
		filesMap.put("img", imgResult.getResult().getFilesMap().get(name));
		entityVo.setFilesMap(filesMap);
		result.setResult(entityVo);
		return result;
	}
}
