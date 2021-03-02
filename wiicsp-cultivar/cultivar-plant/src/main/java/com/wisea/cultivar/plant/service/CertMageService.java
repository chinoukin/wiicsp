package com.wisea.cultivar.plant.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.CertMage;
import com.wisea.cultivar.plant.entity.CertPicture;
import com.wisea.cultivar.plant.mapper.CertMageMapper;
import com.wisea.cultivar.plant.mapper.CertPictureMapper;
import com.wisea.cultivar.plant.po.CertMagePageListPo;
import com.wisea.cultivar.plant.po.CertMagePo;
import com.wisea.cultivar.plant.vo.CertMageInfoVo;
import com.wisea.cultivar.plant.vo.CertMagePageListVo;
import com.wisea.cultivar.plant.vo.CertPictureInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CertMageService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class CertMageService extends BaseService {
    @Autowired
    private CertMageMapper mapper;
    @Autowired
	private CertPictureMapper certPictureMapper;

	/**
	 * 查询店铺证书列表
	 * @param po
	 * @return
	 */
	public ResultPoJo<List<CertMageInfoVo>> findShopCerts(CertMagePageListPo po) {
		LoggerUtil.infoWithContext("【findShopCerts】查询店铺证书列表：", po);
		ResultPoJo<List<CertMageInfoVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		CertMage certMage = new CertMage();
		certMage.setShopInfoId(po.getShopInfoId());
		List<CertMageInfoVo> vo = mapper.findByConditions(certMage);
		if(ConverterUtil.isNotEmpty(vo)){
			// 图片信息
			for (CertMageInfoVo certMageInfoVo : vo) {
				CertPicture certPicture = new CertPicture();
				certPicture.setCertMageId(certMageInfoVo.getId());
				List<CertPictureInfoVo> picVo = certPictureMapper.findByConditions(certPicture);
				certMageInfoVo.setCertPictureInfoVoList(picVo);
			}
		}else{
			vo = Lists.newArrayList();
		}
		resultPoJo.setResult(vo);
		return resultPoJo;
	}

	/**
	 * 添加证书信息
	 * @param po
	 * @return
	 */
	@Transactional
	public ResultPoJo addInfo(CertMagePo po) {
		LoggerUtil.infoWithContext("【addInfo】添加证书信息：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		//校验证书
		checkCert(po);
		//新增或修改
		CertMage certMage = saveOrUpdate(po);
		//先删除图片
		certPictureMapper.deleteLogicByCertMageId(certMage.getId());
		// 添加证书图片信息
		List<CertPicture> certPictureList = Optional.ofNullable(po.getCertPictureList()).orElse(Lists.newArrayList());
		for (CertPicture certPicture : certPictureList) {
			certPicture.setCertMageId(certMage.getId());
			certPicture.preInsert();
			certPictureMapper.insert(certPicture);
		}

		return resultPoJo;
	}

	/**
	 * 校验证书
	 */
	private void checkCert(CertMagePo po) {
		//检查证书名称是否重复
		String certName = po.getCertName();
		if (ConverterUtil.isEmpty(certName)) {
			return;
		}
		CertMageInfoVo certMageInfoVo = mapper.findByCertName(certName, po.getShopInfoId());
		if (Objects.isNull(certMageInfoVo)) {
			return;
		}
		if (Objects.isNull(po.getId()) || !certMageInfoVo.getId().equals(po.getId())) {
			//证书名称重复
			throw new VerifyException("70031", "证书名称重复");
		}
	}

	/**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CertMage
     */
    public ResultPoJo<Page<CertMagePageListVo>> findPageList(CertMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<CertMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<CertMagePageListVo> page = po.getPage();
		List<CertMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除CertMage
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CertMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(CertMage.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 新增或修改CertMage
     */
    @Transactional
    public CertMage saveOrUpdate(CertMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		if(ConverterUtil.isEmpty(po.getId())){
			//新增
			CertMage entity = new CertMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
			return entity;
		}
		CertMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isEmpty(entity)){
			throw new VerifyException(ConstantError.ERR_004, ConstantError.MSG_004);
		}
		//修改
		BeanUtils.copyProperties(po, entity);
		entity.preUpdate();
		mapper.updateByPrimaryKeySelective(entity);
		return entity;
    }

	public ResultPoJo<CertMageInfoVo> findInfo(LongIdPo po) {
		ResultPoJo<CertMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//查询证书信息
		CertMage certMage = new CertMage();
		certMage.setShopInfoId(po.getId());
		CertMageInfoVo certMageInfoVo = mapper.findInfo(po);
		if (Objects.isNull(certMageInfoVo)) {
			throw new VerifyException(ConstantError.ERR_004, ConstantError.MSG_004);
		}
		//查询证书图片
		CertPicture certPicture = new CertPicture();
		certPicture.setCertMageId(po.getId());
		List<CertPictureInfoVo> picVo = certPictureMapper.findByConditions(certPicture);
		certMageInfoVo.setCertPictureInfoVoList(picVo);
		resultPoJo.setResult(certMageInfoVo);
		return resultPoJo;
	}

	/**
	 * 查询证书图片
	 */
    public ResultPoJo<List<String>> findCertPicture(LongIdPo po) {
		//查询证书图片
		CertPicture certPicture = new CertPicture();
		certPicture.setCertMageId(po.getId());
		List<CertPictureInfoVo> picVo = certPictureMapper.findByConditions(certPicture);
		ResultPoJo<List<String>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if (Objects.isNull(picVo)) {
			resultPoJo.setResult(Lists.newArrayList());
			return resultPoJo;
		}
		List<String> vo = picVo.stream().map(CertPictureInfoVo::getUrl).collect(Collectors.toList());
		resultPoJo.setResult(vo);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CertMage
     */
//    public ResultPoJo<CertMageInfoVo> findInfo(LongIdPo po) {
//        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
//		ResultPoJo<CertMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
//		CertMageInfoVo vo = mapper.findInfo(po);
//		if(ConverterUtil.isNotEmpty(vo)){
//			resultPoJo.setResult(vo);
//		}else{
//			resultPoJo.setCode(ConstantError.ERR_004);
//			resultPoJo.setMsg(ConstantError.MSG_004);
//		}
//		return resultPoJo;
//    }
}
