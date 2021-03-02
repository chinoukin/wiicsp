package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.ZhfwCommPubInfo;
import com.wisea.cultivar.plant.mapper.CertMageMapper;
import com.wisea.cultivar.plant.mapper.ZhfwCommPictureMapper;
import com.wisea.cultivar.plant.mapper.ZhfwCommPubInfoMapper;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.ZhfwCommPubInfoPageListPo;
import com.wisea.cultivar.plant.po.ZhfwCommPubInfoPo;
import com.wisea.cultivar.plant.vo.*;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ZhfwCommPubInfoService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class ZhfwCommPubInfoService extends BaseService {
    @Autowired
    private ZhfwCommPubInfoMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ZhfwCommPubInfo
     */
    public ResultPoJo<Page<ZhfwCommPubInfoPageListVo>> findPageList(ZhfwCommPubInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<ZhfwCommPubInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<ZhfwCommPubInfoPageListVo> page = po.getPage();
		List<ZhfwCommPubInfoPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除ZhfwCommPubInfo
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ZhfwCommPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(ZhfwCommPubInfo.DEL_FLAG_DELETE);
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
     * @Description 新增或修改ZhfwCommPubInfo
     */
    public ResultPoJo saveOrUpdate(ZhfwCommPubInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			ZhfwCommPubInfo entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			ZhfwCommPubInfo entity = new ZhfwCommPubInfo();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

	@Autowired
	private CertMageMapper certMageMapper;
	@Autowired
	private ZhfwMembInfoMapper zhfwMembInfoMapper;
	@Autowired
	private ZhfwCommPictureMapper zhfwCommPictureMapper;
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息ZhfwCommPubInfo
     */
    public ResultPoJo<ZhfwCommPubInfoInfoVo> findInfo(CommVo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<ZhfwCommPubInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ZhfwCommPubInfoInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			// 查询证书 和证书图片
			List<CertMageInfoVo> certMageList=certMageMapper.findListCertMage(vo.getShopId());
			vo.setCertMageInfoVoList(certMageList);
			// 新增细节图片
			List<ZhfwCommPictureInfoVo> asd=zhfwCommPictureMapper.findByCommPubIdDetailsPicture(vo.getId());
			vo.setZhfwCommPictureInfoVoList2(asd);
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }
}
