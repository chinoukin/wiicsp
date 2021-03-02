package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.RefundCommPicture;
import com.wisea.cultivar.common.po.tp.RefundCommPictureListPo;
import com.wisea.cultivar.common.po.tp.RefundCommPicturePagePo;
import com.wisea.cultivar.common.vo.tp.RefundCommPictureListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * refund_comm_picture 表DAO
 * 退货申请图片
 * 2018/09/30 09:46:17
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface RefundCommPictureMapper extends CrudDao<RefundCommPicture> {
    List<RefundCommPictureListVo> findPage(RefundCommPicturePagePo refundCommPicturePagePo);

    List<RefundCommPictureListVo> findList(RefundCommPictureListPo refundCommPictureListPo);
}
