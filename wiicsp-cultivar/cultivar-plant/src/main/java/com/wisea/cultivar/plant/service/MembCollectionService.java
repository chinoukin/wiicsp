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
import com.wisea.cultivar.plant.entity.MembCollection;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.mapper.CommGyPubPictureMapper;
import com.wisea.cultivar.plant.mapper.MembCollectionMapper;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.po.MembCollectionPageListPo;
import com.wisea.cultivar.plant.po.MembCollectionPo;
import com.wisea.cultivar.plant.vo.*;
import com.wisea.cultivar.plant.vo.oritrapla.PadMageListVo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MembCollectionService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class MembCollectionService extends BaseService {
    @Autowired
    private MembCollectionMapper mapper;
	@Autowired
	private CommGyPubPictureMapper commGyPubPictureMapper;
	@Autowired
	private ZhfwMembInfoMapper zhfwMembInfoMapper;
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembCollection
     */
    public ResultPoJo<Page> findPageList(MembCollectionPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//获取当前登录的用户信息
		User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = zhfwMembInfoMapper.selectByPrimaryKey(user.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			resultPoJo.setCode(ConstantCodeMsg.ERR_505);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_505);
			return resultPoJo;
		}
		po.setMembId(user.getId());
		Page page = po.getPage();
	/*	0	政策信息
		1	标准信息
		2	农技信息
		3	病虫害信息
		4	茶果茶籽求购信息
		5	茶果茶籽供应信息
		6	种植服务供应信息
*/
		switch (po.getCollectionType().intValue()) {
			case 0:
				List<KnowledgeBaseMageInfoVo>  knowledgeBaseMageInfoVoList=	mapper.knowledgeBaseMageList(po);
				page.setList(knowledgeBaseMageInfoVoList);
				break;
			case 1:
				List<StandardRuleMageInfoVo>  standardRuleMageInfoVoList=	mapper.findStandardRuleMageInfoVoList(po);
				page.setList(standardRuleMageInfoVoList);
				break;
			case 2:
				List<KnowledgeBaseMageInfoVo>  knowledgeBaseMageInfoVoList1=mapper.knowledgeBaseMageList(po);
				page.setList(knowledgeBaseMageInfoVoList1);
				break;
			case 3:
			    List<PadMageListVo>  padMageInfoVoList  =	mapper.findPadMageList(po);
				page.setList(padMageInfoVoList);
				break;
			case 4:
				List<CommQgPubInfoInfoVo>  commQgPubInfoInfoVoList=mapper.findQGList(po);
				page.setList(commQgPubInfoInfoVoList);
				break;
			case 5:
				List<CommGyPubInfoPageListVo>  commGyPubInfoInfoVoList=mapper.findGYList(po);
				commGyPubInfoInfoVoList.stream().forEach(e->{
					CommGyPubPictureInfoVo one = commGyPubPictureMapper.getOneByCommGyPubId(e.getId());
					Optional.ofNullable(one).ifPresent(x->e.setCommGyPubPicture(x.getUrl()));
				});
				page.setList(commGyPubInfoInfoVoList);
				break;
			case 6:
                List<ZhfwCommPubInfoPageListVo>  commPubInfoPageListVoList=	mapper.findCommPubInfoList(po);
                page.setList(commPubInfoPageListVoList);
				break;
		}
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除MembCollection
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembCollection entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(MembCollection.DEL_FLAG_DELETE);
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
     * @Description 新增或修改MembCollection
     */
	@Transactional(rollbackFor = Exception.class)
    public ResultPoJo<MembCollectionPo> saveOrUpdate(MembCollectionPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo<MembCollectionPo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembCollectionPo membCollectionPo = new MembCollectionPo();
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			MembCollection entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
				BeanUtils.copyProperties(entity, membCollectionPo);
				resultPoJo.setResult(membCollectionPo);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{

			List<MembCollectionInfoVo> listByMemberIdAndCollectionId = mapper.findListByMemberIdAndCollectionId(po);
			if (ConverterUtil.isNotEmpty(listByMemberIdAndCollectionId)){
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
				return resultPoJo;
			}

			//新增
			MembCollection entity = new MembCollection();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
			BeanUtils.copyProperties(entity, membCollectionPo);
			membCollectionPo.setId(entity.getId());
			resultPoJo.setResult(membCollectionPo);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembCollection
     */
    public ResultPoJo<MembCollectionInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<MembCollectionInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		MembCollectionInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }


}
