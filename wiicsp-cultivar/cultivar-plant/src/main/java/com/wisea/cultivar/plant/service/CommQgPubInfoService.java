package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
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
import com.wisea.cultivar.common.dao.MeasUnitMageMapper;
import com.wisea.cultivar.common.vo.product.MeasUnitMageListVo;
import com.wisea.cultivar.plant.entity.CommQgPubInfo;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.CommQgPubInfoMapper;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.CommQgPubInfoPageListPo;
import com.wisea.cultivar.plant.po.CommQgPubInfoPo;
import com.wisea.cultivar.plant.vo.CommQgPubInfoInfoVo;
import com.wisea.cultivar.plant.vo.CommQgPubInfoPageListVo;
import com.wisea.cultivar.plant.vo.CommVo;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommQgPubInfoService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class CommQgPubInfoService extends BaseService {
    @Autowired
    private CommQgPubInfoMapper mapper;


	@Autowired
	private MeasUnitMageMapper measUnitMageMapper;
	@Autowired
	private ZhfwMembInfoMapper zhfwMembInfoMapper;
	@Autowired
	private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
	/**
	 * 根据id ++ 联系数
	 * @param po
	 */
	@Transactional(rollbackFor = Exception.class)
	public ResultPoJo addCommQgPubInfoContactsNum(LongIdPo po) {

		LoggerUtil.infoWithContext("【logicDel】联系数++：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//修改
		//获取当前登录的用户信息
		User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			resultPoJo.setCode(ConstantCodeMsg.ERR_505);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
			return resultPoJo;
		}
		//修改
		CommQgPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			String s = "collection:" + user.getId() + "" + entity.getId();
				// 如果不存在这个key
			if (!jedisdao.exists(s)) {
				mapper.addCommQgPubInfoContactsNum(po.getId());

				jedisdao.setStrExpire(s,s,60*60*12);	// 默认存储43200秒   12小时
			}

		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}
	/**
	 * 根据id ++ 浏览数
	 * @param po
	 */
	@Transactional(rollbackFor = Exception.class)
	public ResultPoJo addCommQgPubInfoViews(LongIdPo po) {

		LoggerUtil.infoWithContext("【logicDel】浏览数++：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//修改
		CommQgPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			mapper.addCommQgPubInfoViews(po.getId());
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;

	}


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CommQgPubInfo
     */
    public ResultPoJo<Page<CommQgPubInfoPageListVo>> findPageList(CommQgPubInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<CommQgPubInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<CommQgPubInfoPageListVo> page = po.getPage();
		List<CommQgPubInfoPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除CommQgPubInfo
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommQgPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(CommQgPubInfo.DEL_FLAG_DELETE);
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
     * @Description 新增或修改CommQgPubInfo
     */
    public ResultPoJo saveOrUpdate(CommQgPubInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			CommQgPubInfo entity = mapper.selectByPrimaryKey(po.getId());
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
			CommQgPubInfo entity = new CommQgPubInfo();
			BeanUtils.copyProperties(po, entity);
			if(ConverterUtil.isEmpty(po.getQgStateType())){
				//默认上架
				entity.setQgStateType("0");
			}
			entity.setPubDate(OffsetDateTime.now());
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CommQgPubInfo
     */
	@Transactional(rollbackFor = Exception.class)
    public ResultPoJo<CommQgPubInfoInfoVo> findInfo(CommVo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<CommQgPubInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommQgPubInfoInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * 上下架操作
	 * @param po
	 * @return
	 */
	public ResultPoJo operation(CommQgPubInfoPo po){
		ResultPoJo resultPoJo = new ResultPoJo<>();
		//求购id
		Long id = po.getId();
		CommQgPubInfo commQgPubInfo = mapper.selectByPrimaryKey(id);
		if(ConverterUtil.isNotEmpty(commQgPubInfo)){
			//0 上架，1下架
			commQgPubInfo.setQgStateType(po.getQgStateType());
			commQgPubInfo.preUpdate();
			mapper.updateByPrimaryKeySelective(commQgPubInfo);
			resultPoJo.setCode(ConstantCodeMsg.ERR_000);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
			return resultPoJo;
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
			return resultPoJo;
		}

	}

	/**
	 * 新增获取计量单位列表
	 * @return
	 */
	public ResultPoJo<List<MeasUnitMageListVo>> getMeasUnit() {
		ResultPoJo<List<MeasUnitMageListVo>> resultPoJo = new ResultPoJo<>();
		//0表示重量单位
		List<MeasUnitMageListVo> measUnitMageListVos = measUnitMageMapper.measUnitList("0");
		resultPoJo.setCode(ConstantCodeMsg.ERR_000);
		resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
		resultPoJo.setResult(measUnitMageListVos);
		return resultPoJo;
	}
}
