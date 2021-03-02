package com.wisea.transac.operation.utils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.sys.entity.Menu;
import com.wisea.cloud.common.sys.entity.Role;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.security.utils.UserUtils;

/**
 * 微信模拟登录相关Utils
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月13日
 * @version 1.0
 */
public class JwtCreateUtils {

	/**
	 * 获取权限数组
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月13日
	 * @version 1.0
	 */
	public static  String[] getAuthor(User user){
		// 权限数组
        String[] permissionArray = new String[0];
        // 权限列表
        List<String> permissionList = Lists.newArrayList();
        // 权限map避免相同权限,使用map做过滤
        Map<String, String> permissionMap = Maps.newHashMap();
        // 标志位权限
        // 是否激活
        if ("1".equals(user.getActiveFlag())) {
            permissionMap.put("actived", "actived");
        }
        // 是否审核通过
        if ("1".equals(user.getAuthFlag())) {
            permissionMap.put("authed", "authed");
        }
        // 查询用户角色
        List<Role> roleList = UserUtils.getRoleList(user);
        if (ConverterUtil.isNotEmpty(roleList)) {
            permissionMap.putAll(roleList.stream().collect(Collectors.toMap(Role::getCode, Role::getCode)));
        }
        // 查询菜单权限
        List<Menu> menuList = UserUtils.getPermissionList(user);
        if (ConverterUtil.isNotEmpty(menuList)) {
            for (Menu menu : menuList) {
                String tempPer = menu.getPermission();
                if (ConverterUtil.isNotEmpty(tempPer)) {
                    // 如果包含逗号就是多个权限，需要拆分
                    if (tempPer.contains(",")) {
                        // 拆分成数组
                        String[] tempPerArray = tempPer.split(",");
                        for (String per : tempPerArray) {
                            permissionMap.put(per, per);
                        }
                    } else {
                        permissionMap.put(tempPer, tempPer);
                    }
                }
            }
        }
        // map转换成list
        if (permissionMap.size() > 0) {
            permissionMap.forEach((k, v) -> permissionList.add(k));
        }
        // 将角色和菜单权限都转成数组
        if (ConverterUtil.isNotEmpty(permissionList)) {
            permissionArray = permissionList.stream().toArray(String[]::new);
        }
		return permissionArray;
	}
}
