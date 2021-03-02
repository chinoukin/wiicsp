package com.wisea.transac.operation.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cloud.security.dao.MenuDao;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.cloud.security.vo.PermissionOptionVo;
import com.wisea.cloud.security.vo.PermissionVo;
import com.wisea.cloud.security.vo.ViewMenuVo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.operation.user.po.MenuExtendsPo;
import com.wisea.transac.operation.user.po.MenuExtendsUserInitPo;
import com.wisea.transac.operation.user.vo.UpdUserMenuInitVo;
import com.wisea.transac.operation.user.vo.ViewMenuExtendsVo;

/**
 * 菜单扩展类Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月24日
 * @version 1.0
 */
@Service
public class MenuExtendsService extends BaseService{

	@Autowired
	private MenuDao menuDao;
	/**
	 * 首页菜单的查询操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月24日
	 * @version 1.0
	 */
	public ResultPoJo<List<ViewMenuExtendsVo>> findMeunListForIndex(MenuExtendsPo po){
		// 返回值初期化处理
		ResultPoJo<List<ViewMenuExtendsVo>> result = new ResultPoJo<List<ViewMenuExtendsVo>>();
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 获取会员信息
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(membInfo == null || ConverterUtil.isEmpty(membInfo.getId(),membInfo.getMembId())){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 查询当前用户的权限的 菜单ID
//		String rtype = "";
//        // 如果当前用户是子账户，需要按用户自定义角色rtype=1查询
//        if (Constants.USER_TYPE_SUBUSER.equals(user.getUserType()) || UserUtils.hasAnyRole(user, Constants.USER_ROLE_CUSTOMIZE)) {
//            rtype = "1";
//        } else {
//            // 按照系统角色rtype=0查询 其实这个方法最终和findByUserId是相同的 只是名称有区分
//            rtype = "0";
//        }
        List<PermissionVo> selMenuList = menuDao.findUserPermissionIds(user.getId(), "0");
		List<ViewMenuVo> meunList = Lists.newArrayList();
		// 查询服务菜单的情况
		if(po.getIsService().equals("1")){
			List<ViewMenuExtendsVo> list = Lists.newArrayList();
			// 查询服务的全部菜单
			meunList = UserUtils.getMenuService(po.getType());
			for(ViewMenuVo entity : meunList){
				ViewMenuExtendsVo vo = new ViewMenuExtendsVo();
				ConverterUtil.copyProperties(entity, vo);
				for(PermissionVo selId : selMenuList){
					if(selId.getId().equals(entity.getId())){
						vo.setIsActivate("1");
						break;
					}
				}
				list.add(vo);
			}
			result.setResult(list);
		}else{
			// 为空时查询全部菜单
			User parentUser = new User();
			parentUser = UserUtils.getById(membInfo.getMembId());
			if (ConverterUtil.isNotEmpty(po, po.getType())) {
	            // type不为空按type查询
				meunList = UserUtils.getUserViewMenuListByType(parentUser.getOpenId(),po.getType());
			} else {
				//获取某用户非type菜单
				meunList = UserUtils.getViewMenuListNoType(parentUser);
		    }
			// 树结构返回
			result.setResult(TreeUtils.listToTree(this.recurrenceParentMenu(meunList, selMenuList)));
		}
		return result;
	}
	// 遍历父节点的菜单处理
	private List<ViewMenuExtendsVo> recurrenceParentMenu(List<ViewMenuVo> meunList,List<PermissionVo> ids){
		List<ViewMenuExtendsVo> list = Lists.newArrayList();
		if(meunList != null && meunList.size() > 0){
			for(ViewMenuVo entity : meunList){
				ViewMenuExtendsVo vo = new ViewMenuExtendsVo();
				ConverterUtil.copyProperties(entity, vo);
				vo.setIsActivate("0");
				for(PermissionVo id : ids){
					if(id.getId().equals(entity.getId())){
						vo.setIsActivate("1");
						break;
					}
				}
				list.add(vo);
				if(entity.getChildren() != null && entity.getChildren().size() > 0){
					recurrenceParentMenu(entity.getChildren(),ids);
				}
			}
		}
		return list;
	}
	/**
	 * 新增修改用户菜单的初期化处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月28日
	 * @version 1.0
	 */
	public ResultPoJo<List<UpdUserMenuInitVo>> updUserMenuInit(MenuExtendsUserInitPo po){
		// 返回值初期化处理
		ResultPoJo<List<UpdUserMenuInitVo>> result = new ResultPoJo<List<UpdUserMenuInitVo>>();
		List<UpdUserMenuInitVo> initList = Lists.newArrayList();
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		Long id = null;
		// 新增的情况
		if(po == null || ConverterUtil.isEmpty(po.getId())){
			id = user.getId();
		}else{
			id = po.getId();
		}
		// 获取会员信息
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(id);
		if(membInfo == null || ConverterUtil.isEmpty(membInfo.getId(),membInfo.getMembId())){
			result.setCode(ConstantCodeMsg.ERR_001);
			result.setMsg(ConstantCodeMsg.MSG_001);
			return result;
		}
		User parentUser = UserUtils.getById(id);
        if (ConverterUtil.isNotEmpty(parentUser)) {
            List<PermissionOptionVo> list = Lists.newArrayList();
            Long queryId = null;
            if (Constants.USER_TYPE_SUBUSER.equals(user.getUserType())) {
                // 子账户的权限选项实际上就是是父账户的权限，只是在勾选了之后，
                // 会在role中增加一个自定义rtype=1的角色，role_menu中使用这个单独的角色进行菜单的设置
                queryId = user.getParentId();
            } else {
                // 如果是正常用户，那么权限选项和拥有的权限相同
                queryId = user.getId();
            }
            list = menuDao.findUserPermissionOption(queryId);
            // 如果是新增直接返回

            if(po == null || ConverterUtil.isEmpty(po.getId())){
            	for(PermissionOptionVo entity : list){
            		UpdUserMenuInitVo vo = new UpdUserMenuInitVo();
            		ConverterUtil.copyProperties(entity, vo);
            		vo.setIsActivate("0");
            		initList.add(vo);
            	}
            }else{
            	// 查询当前用户的权限的 菜单ID需要按用户自定义角色rtype=1查询
                List<PermissionVo> selMenuList = menuDao.findUserPermissionIds(id, "1");
                for(PermissionOptionVo entity : list){
            		UpdUserMenuInitVo vo = new UpdUserMenuInitVo();
            		ConverterUtil.copyProperties(entity, vo);
            		vo.setIsActivate("0");
            		for(PermissionVo selId : selMenuList){
            			if(selId.getId().equals(entity.getId())){
            				vo.setIsActivate("1");
            				break;
            			}
            		}
            		initList.add(vo);
            	}
            }
            result.setResult(TreeUtils.listToTree(initList));
        }
		return result;
	}
}
