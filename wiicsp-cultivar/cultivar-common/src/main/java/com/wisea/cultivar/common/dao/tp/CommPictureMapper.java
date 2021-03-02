package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommPicture;
import com.wisea.cultivar.common.po.tp.CommPictureListPo;
import com.wisea.cultivar.common.po.tp.CommPicturePagePo;
import com.wisea.cultivar.common.vo.tp.CommPictureListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;


/**
 * comm_picture 表DAO
 * 商品图片信息
 * 2018/09/20 14:29:08
 * <p>
 * 分页查询
 */

public interface CommPictureMapper extends CrudDao<CommPicture> {
    /**
     * 分页查询
     */
    List<CommPictureListVo> findPage(CommPicturePagePo commPicturePagePo);
    /**
     * 列表查询
     */
    List<CommPictureListVo> findList(CommPictureListPo commPictureListPo);

    /**
     * 根据商品id删除照片
     * @param id
     */
    void delByCommPubInfoId(Long id);

    /**
     * 查询商品主图信息
     * @param id
     * @return
     */
    CommPicture selCommPictureUrl(Long id);

    /**
     * 根据商品的发布ID查询最新的一张商品图片
     * @param id
     * @return
     */
    CommPicture selectMinPictureByCommId(Long commId);
}
