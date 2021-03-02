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
import com.wisea.cultivar.plant.entity.CommGyPubInfo;
import com.wisea.cultivar.plant.entity.CommGyPubPicture;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.CommGyPubInfoMapper;
import com.wisea.cultivar.plant.mapper.CommGyPubPictureMapper;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.CommGyPubInfoPageListPo;
import com.wisea.cultivar.plant.po.CommGyPubInfoPo;
import com.wisea.cultivar.plant.vo.CommGyPubInfoInfoVo;
import com.wisea.cultivar.plant.vo.CommGyPubInfoPageListVo;
import com.wisea.cultivar.plant.vo.CommGyPubPictureInfoVo;
import com.wisea.cultivar.plant.vo.CommVo;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CommGyPubInfoService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class CommGyPubInfoService extends BaseService {
    @Autowired
    private CommGyPubInfoMapper mapper;
	@Autowired
	private CommGyPubPictureMapper commGyPubPictureMapper;
	@Autowired
	private ZhfwMembInfoMapper zhfwMembInfoMapper;
	@Autowired
	private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
	/**
	 * 根据id ++ 联系数
	 * @param po
	 */
	@Transactional(rollbackFor = Exception.class)
	public ResultPoJo addCommGyPubInfoContactsNum(LongIdPo po) {
		LoggerUtil.infoWithContext("【logicDel】联系数+1：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
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
		CommGyPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			String s = "collection:" + user.getId() + "" + entity.getId();
			// 如果不存在这个key
			if (!jedisdao.exists(s)) {
				mapper.addCommGyPubInfoContactsNum(po.getId());
				jedisdao.setStrExpire(s,s,60*60*12);	// 默认存储43200秒   12小时

			}
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}
	/**
	 * 根据id ++  浏览数
	 * @param po
	 */
	@Transactional(rollbackFor = Exception.class)
	public ResultPoJo addCommGyPubInfoViews(LongIdPo po) {
		LoggerUtil.infoWithContext("【logicDel】浏览数+1：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//修改
		CommGyPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			mapper.addCommGyPubInfoViews(po.getId());
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * 新增供应图片
	 * @param commGyPubPictureList
	 * @param commGyPubId
	 */
	public void insertGyPubPictrue(List<CommGyPubPicture> commGyPubPictureList, Long commGyPubId){
		Optional.ofNullable(commGyPubPictureList).ifPresent(c->{
			c.stream().forEach(e->{
				e.setCommGyPubId(commGyPubId);
				e.preInsert();
				commGyPubPictureMapper.insert(e);
			});
		});
	}
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CommGyPubInfo
     */
    public ResultPoJo<Page<CommGyPubInfoPageListVo>> findPageList(CommGyPubInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<CommGyPubInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<CommGyPubInfoPageListVo> page = po.getPage();
		List<CommGyPubInfoPageListVo> list = mapper.findPageList(po);
		list.stream().forEach(e->{
			CommGyPubPictureInfoVo one = commGyPubPictureMapper.getOneByCommGyPubId(e.getId());
			Optional.ofNullable(one).ifPresent(x->e.setCommGyPubPicture(x.getUrl()));
		});
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除CommGyPubInfo
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommGyPubInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(CommGyPubInfo.DEL_FLAG_DELETE);
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
     * @Description 新增或修改CommGyPubInfo
     */
    public ResultPoJo saveOrUpdate(CommGyPubInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			CommGyPubInfo entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
				//修改供应图片->先删除在添加
				commGyPubPictureMapper.deleteByCommGyPubId(po.getId());
				this.insertGyPubPictrue(po.getCommGyPubPictureList(),po.getId());
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			CommGyPubInfo entity = new CommGyPubInfo();
			BeanUtils.copyProperties(po, entity);
			entity.setPubDate(OffsetDateTime.now());
			//默认上架
			entity.setQgStateType("0");
			entity.preInsert();
			mapper.insert(entity);
			//新增供应图片最多4张
			this.insertGyPubPictrue(po.getCommGyPubPictureList(),entity.getId());
		}
		return resultPoJo;
    }
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CommGyPubInfo
     */
    public ResultPoJo<CommGyPubInfoInfoVo> findInfo(CommVo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<CommGyPubInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		CommGyPubInfoInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			// 添加供应图片
			List<CommGyPubPicture> list = commGyPubPictureMapper.findListByCommGyPubId(vo.getId());
			Optional.ofNullable(list).ifPresent(e->vo.setCommGyPubPictureList(list));
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
	public ResultPoJo operation(CommGyPubInfoPo po){
		ResultPoJo resultPoJo = new ResultPoJo<>();
		//供应id
		Long id = po.getId();
		CommGyPubInfo commGyPubInfo = mapper.selectByPrimaryKey(id);
		if(ConverterUtil.isEmpty(commGyPubInfo)){
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
			return resultPoJo;
		}
		//0 上架，1下架
		commGyPubInfo.setQgStateType(po.getQgStateType());
		commGyPubInfo.preUpdate();
		mapper.updateByPrimaryKeySelective(commGyPubInfo);
		resultPoJo.setCode(ConstantCodeMsg.ERR_000);
		resultPoJo.setMsg(ConstantCodeMsg.MSG_000);
		return resultPoJo;
	}
}
