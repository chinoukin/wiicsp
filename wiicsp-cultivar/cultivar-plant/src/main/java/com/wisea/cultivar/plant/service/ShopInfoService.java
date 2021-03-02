package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.ShopInfo;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.CertMageMapper;
import com.wisea.cultivar.plant.mapper.ShopInfoMapper;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.ShopInfoPageListPo;
import com.wisea.cultivar.plant.po.ShopInfoPo;
import com.wisea.cultivar.plant.vo.CertMageInfoVo;
import com.wisea.cultivar.plant.vo.ShopInfoInfoVo;
import com.wisea.cultivar.plant.vo.ShopInfoPageListVo;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ShopInfoService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class ShopInfoService extends BaseService {
    @Autowired
    private ShopInfoMapper mapper;

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ShopInfo
     */
    public ResultPoJo<Page<ShopInfoPageListVo>> findPageList(ShopInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<ShopInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<ShopInfoPageListVo> page = po.getPage();
		List<ShopInfoPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除ShopInfo
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ShopInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(ShopInfo.DEL_FLAG_DELETE);
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
     * @Description 新增或修改ShopInfo
     */
    public ResultPoJo saveOrUpdate(ShopInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			ShopInfo entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
				resultPoJo.setResult(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			ShopInfo entity = new ShopInfo();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
			resultPoJo.setResult(entity);
		}
		return resultPoJo;
    }


	@Autowired
	private CertMageMapper certMageMapper;
	@Autowired
	private ZhfwMembInfoMapper zhfwMembInfoMapper;
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息ShopInfo
     */
    public ResultPoJo<ShopInfoInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<ShopInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//获取当前登录的用户信息
		User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			resultPoJo.setCode(ConstantCodeMsg.ERR_505);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
			return resultPoJo;
		}
		ShopInfoInfoVo vo = mapper.findInfo(po.getId(),user.getId());
		if(ConverterUtil.isNotEmpty(vo)){
			// 查询证书 和证书图片
		List<CertMageInfoVo> certMageList=certMageMapper.findListCertMage(vo.getId());
		vo.setCertMageInfoVoList(certMageList);
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

}
