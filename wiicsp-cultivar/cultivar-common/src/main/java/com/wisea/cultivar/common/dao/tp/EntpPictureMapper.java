package com.wisea.cultivar.common.dao.tp;

import java.util.List;
import java.util.Map;

import com.wisea.cultivar.common.entity.tp.EntpPicture;
import com.wisea.cultivar.common.po.tp.EntpPictureListPo;
import com.wisea.cultivar.common.po.tp.EntpPicturePagePo;
import com.wisea.cultivar.common.vo.tp.EntpPictureListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * entp_picture 表DAO
 * 商家图片
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface EntpPictureMapper extends CrudDao<EntpPicture> {
    List<EntpPictureListVo> findPage(EntpPicturePagePo entpPicturePagePo);

    List<EntpPictureListVo> findList(EntpPictureListPo entpPictureListPo);
    /**
     * 根据商家信息id删除企业图片信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月8日
     * @version 1.0
     */
    public void delPicByEntpDataId(Long id);
    /**
     * 批量插入企业图片
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月8日
     * @version 1.0
     */
    public void insertBatchEntpPic(List<EntpPicture> list);
    /**
     * 根据企业id查询图片信息
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月16日
     * @version 1.0
     */
    public List<EntpPicture> findListByentpId(Long id);
    /**
     * 批量更新数据
     *
     * @author wangh(wisea)
     *
     * @date 2018年10月16日
     * @version 1.0
     */
    public void batchUpdEntpDataId(Map<String,Object> map);
}
