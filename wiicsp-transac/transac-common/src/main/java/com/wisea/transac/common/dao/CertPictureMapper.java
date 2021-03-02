package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CertPicture;
import com.wisea.transac.common.po.seller.CertPicturePageListPo;
import com.wisea.transac.common.vo.seller.CertPictureInfoVo;
import com.wisea.transac.common.vo.seller.CertPicturePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CertPictureMapper extends CrudDao<CertPicture> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CertPicture
     */
    List<CertPicturePageListVo> findPageList(CertPicturePageListPo po);

    /**
     * 根据shopId查询所有图片
     * @param shopId
     * @return
     */
    List<CertPicturePageListVo> findAll(Long shopId);

    /**
     * 根据证书ID查询所有的数据
     * @param certMageId
     * @return
     */
    List<CertPicturePageListVo> findAllByCertMageId(Long certMageId);
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息CertPicture
     */
    CertPictureInfoVo findInfo(LongIdPo po);
}
