package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.CertPicture;
import com.wisea.cultivar.plant.po.CertPicturePageListPo;
import com.wisea.cultivar.plant.vo.CertPictureInfoVo;
import com.wisea.cultivar.plant.vo.CertPicturePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CertPictureMapper extends CrudDao<CertPicture> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CertPicture
     */
    List<CertPicturePageListVo> findPageList(CertPicturePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CertPicture
     */
    CertPictureInfoVo findInfo(LongIdPo po);

    // 条件查询
    List<CertPictureInfoVo> findByConditions(CertPicture certPicture);


    /**
     * 通过证书id删除
     * @param certMageId 证书id
     */
    void deleteLogicByCertMageId(Long certMageId);
}
