package com.wisea.cultivar.explorer.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.entity.AreaTree;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.util.ConverterUtil;

/**
 * @author jirg
 * @version 1.0
 * @className AreaUtils
 * @date 2020/9/2 16:52
 * @Description
 */
public class AreaUtils {

    private static SystemCacheService cacheService = SpringBootContext.getBean(SystemCacheService.class);

    /**
     * @author jirg
     * @date 2020/9/2 16:53
     * @Description 获取父级省市区名称  省-市-区
     */
    public static String getParentName(String code){
        AreaTree areaTree = cacheService.getAreaTree(code);
        if(ConverterUtil.isNotEmpty(areaTree)){
            AreaTree parent = areaTree.getParent();
            if(ConverterUtil.isNotEmpty(parent) && parent.getLevel() != 0){
                AreaTree parent1 = parent.getParent();
                if(ConverterUtil.isNotEmpty(parent1) && parent1.getLevel() != 0){
                    return parent1.getName().concat("-").concat(parent.getName()).concat("-").concat(areaTree.getName());
                }else{
                    return parent.getName().concat("-").concat(areaTree.getName());
                }
            }else{
                return areaTree.getName();
            }
        }
        return "";
    }
}
