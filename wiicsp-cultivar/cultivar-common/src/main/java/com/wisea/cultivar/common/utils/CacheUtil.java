package com.wisea.cultivar.common.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cultivar.common.dao.CommMageMapper;
import com.wisea.cultivar.common.dao.CommSaleCatgMapper;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.vo.product.CommMageTreeModelVo;
import com.wisea.cultivar.common.vo.product.ZhfwCommMageTreeVo;
import com.wisea.cultivar.common.vo.product.SalesClassificationListVo;

import java.util.List;

/**
 * 基础分类缓存信息
 */
public class CacheUtil {



    /**
     * 基础分类信息key
     */
    public final static String COMM_MAGE = "ZHFWCOMM_MAGE";
    /**
     * 销售分类信息key
     */
    public final static String SALES_CLASSIFICATION = "SALES_CLASSIFICATION";

    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);

    /**
     * 基础分类信息
     */
    private static CommMageMapper commMageMapper = SpringBootContext.getBean(CommMageMapper.class);
    /**
     * 销售分类信息
     */
    private static CommSaleCatgMapper commSaleCatgMapper = SpringBootContext.getBean(CommSaleCatgMapper.class);

    /**
     * 更新基础分类树缓存
     *
     * @return
     */
    public static void updateCommMageTree() {
        // 删除
        jedisdao.delStr(COMM_MAGE);
        // 查询所有商品信息
        List<ZhfwCommMageTreeVo> commMages = TreeUtils.listToTree(commMageMapper.findList(new CommMageTreePo()), CommMageTreeModelVo.class);
        jedisdao.setSerialize(COMM_MAGE, commMages);
    }

    /**
     * 从redis中获取基础分类树信息
     *
     * @return
     */
    public static List<ZhfwCommMageTreeVo> getCommMageTree() {
        List<ZhfwCommMageTreeVo> list = jedisdao.getSerialize(COMM_MAGE, List.class);
        if (ConverterUtil.isEmpty(list)) {
            list = TreeUtils.listToTree(commMageMapper.findList(new CommMageTreePo()), CommMageTreeModelVo.class);
            jedisdao.setSerialize(COMM_MAGE, list);
        }
        return list;
    }

    /**
     * 更新销售分类树缓存
     *
     * @return
     */
    public static void updateSalesClassificationTree() {
        // 删除
        jedisdao.delStr(SALES_CLASSIFICATION);
        // 查询所有商品信息
        List<SalesClassificationListVo> commMages = TreeUtils.listToTree(commSaleCatgMapper.findList(new CommMageTreePo()), SalesClassificationListVo.class);
        jedisdao.setSerialize(SALES_CLASSIFICATION, commMages);
    }

    /**
     * 从redis中获取销售分类树信息
     *
     * @return
     */
    public static List<SalesClassificationListVo> getSalesClassificationTree() {
        List<SalesClassificationListVo> list = jedisdao.getSerialize(SALES_CLASSIFICATION, List.class);
        if (ConverterUtil.isEmpty(list)) {
            list = TreeUtils.listToTree(commSaleCatgMapper.findList(new CommMageTreePo()), SalesClassificationListVo.class);
            jedisdao.setSerialize(SALES_CLASSIFICATION, list);
        }
        return list;
    }
}
