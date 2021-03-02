package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.dao.StallsVideoMageMapper;
import com.wisea.transac.common.entity.StallsVideoMage;
import com.wisea.transac.common.po.seller.StallsVideoMagePageListPo;
import com.wisea.transac.common.po.seller.StallsVideoMagePo;
import com.wisea.transac.common.vo.seller.StallsVideoMageInfoVo;
import com.wisea.transac.common.vo.seller.StallsVideoMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className StallsVideoMageService
 * @date 2020/04/27 17:01:28
 * @Description
 */
@Service
public class StallsVideoMageService extends BaseService {
    @Autowired
    private StallsVideoMageMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsVideoMage
     */
    public ResultPoJo<Page<StallsVideoMagePageListVo>> findPageList(StallsVideoMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<StallsVideoMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if (po.getStallsMageId() == null) {
			resultPoJo.setCode("999");
			resultPoJo.setMsg("档口id不能为空");
			return resultPoJo;
		}
		Page<StallsVideoMagePageListVo> page = po.getPage();
		List<StallsVideoMagePageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 逻辑删除StallsVideoMage
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		StallsVideoMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(StallsVideoMage.DEL_FLAG_DELETE);
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
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改StallsVideoMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(StallsVideoMagePo po) {
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			StallsVideoMage entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				//当新值为0，旧值不等于新值
				if (po.getSetAsCoverFlag().equals("0")
						&& !po.getSetAsCoverFlag().equals(entity.getSetAsCoverFlag())) {
					updateAllCoverFlagToFalse(entity.getStallsMageId());
				}
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增

			if (po.getSetAsCoverFlag().equals("0")) {
				updateAllCoverFlagToFalse(po.getStallsMageId());
			}
			StallsVideoMagePageListPo pageListPo = new StallsVideoMagePageListPo();
			pageListPo.setStallsMageId(po.getStallsMageId());
			List<StallsVideoMagePageListVo> pageList = mapper.findPageList(pageListPo);
			String remarks = "0";//0打开，1未打开
			if (pageList.size() > 0) {
				if (!pageList.get(0).getRemarks().equals(remarks)) {
					remarks = "1";
				}
			}

			StallsVideoMage entity = new StallsVideoMage();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			entity.setRemarks(remarks);
			mapper.insert(entity);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsVideoMage
     */
    public ResultPoJo<StallsVideoMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<StallsVideoMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		StallsVideoMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    @Transactional(rollbackFor = Exception.class)
	public ResultPoJo setCoverFlag(LongIdPo idPo) {
		StallsVideoMage videoMage = mapper.selectByPrimaryKey(idPo.getId());
		ResultPoJo resultPoJo = new ResultPoJo();
		if (videoMage == null) {
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
			return resultPoJo;
		}
		if (!videoMage.getSetAsCoverFlag().equals("0")) {
			updateAllCoverFlagToFalse(videoMage.getStallsMageId());
			videoMage.setSetAsCoverFlag("0");
			videoMage.preUpdate();
			mapper.updateByPrimaryKeySelective(videoMage);
		}
		return resultPoJo;
	}

	/**
	 * 根据档口ID更新它下面的所有视频记录的是否为封面图片为 1 （否）
	 * @param stallId
	 */
	private void updateAllCoverFlagToFalse(Long stallId) {
		StallsVideoMagePageListPo po = new StallsVideoMagePageListPo();
		po.setStallsMageId(stallId);
		List<StallsVideoMagePageListVo> list = mapper.findPageList(po);
		list.forEach(i->{
			StallsVideoMage mage = new StallsVideoMage();
			ConverterUtil.copyProperties(i,mage);
			mage.preUpdate();
			mage.setSetAsCoverFlag("1");
			mapper.updateByPrimaryKeySelective(mage);
		});
	}

	@Transactional(rollbackFor = Exception.class)
	public ResultPoJo setVideo(Long id) {
		List<StallsVideoMageInfoVo> video = mapper.findShopVideoByStallsId(id);
		if (video.size() == 0) {
			return new ResultPoJo();
		}
		String remarks = "0";//0打开，1未打开
		if (video.get(0).getRemarks().equals(remarks)) {
			remarks = "1";
		}
		for (StallsVideoMageInfoVo i : video) {
			StallsVideoMage videoMage = new StallsVideoMage();
			ConverterUtil.copyProperties(i, videoMage);
			videoMage.setRemarks(remarks);
			videoMage.preUpdate();
			mapper.updateByPrimaryKeySelective(videoMage);
		}
		return new ResultPoJo();
	}

}
