package com.wisea.cultivar.common.utils.tp;

import com.wisea.cultivar.common.dao.tp.CommMageMapper;
import com.wisea.cultivar.common.po.tp.CommMageTreePo;
import com.wisea.cultivar.common.vo.tp.CommMageTreeVo;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cultivar.common.vo.tp.product.CommMageTreeModelVo;

import java.util.List;

/**
 * @Author jirg
 * @Date 2019/1/15 11:11
 * @Description 缓存工具类
 **/
public class CacheUtil {
    /** 商品分类信息key */
    public final static String COMM_MAGE = "COMM_MAGE";

    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
    // 商品信息
    private static CommMageMapper commMageMapper = SpringBootContext.getBean(CommMageMapper.class);

    /**
     * 更新商品分类树缓存
     *
     * @return
     */
    public static void updateCommMageTree() {
        // 删除
        jedisdao.delStr(COMM_MAGE);
        // 查询所有商品信息
        List<CommMageTreeVo> commMages = TreeUtils.listToTree(commMageMapper.findList(new CommMageTreePo()), CommMageTreeModelVo.class);
        jedisdao.setSerialize(COMM_MAGE, commMages);
    }

    /**
     * 从redis中获取商品分类树信息
     *
     * @return
     */
    public static List<CommMageTreeVo> getCommMageTree() {
        List<CommMageTreeVo> list = jedisdao.getSerialize(COMM_MAGE, List.class);
        if(ConverterUtil.isEmpty(list)){
            list = TreeUtils.listToTree(commMageMapper.findList(new CommMageTreePo()), CommMageTreeModelVo.class);
            jedisdao.setSerialize(COMM_MAGE, list);
        }
        return list;
    }
}
