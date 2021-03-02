package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.CertMage;
import com.wisea.cultivar.plant.po.CertMagePageListPo;
import com.wisea.cultivar.plant.vo.CertMageInfoVo;
import com.wisea.cultivar.plant.vo.CertMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CertMageMapper extends CrudDao<CertMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询CertMage
     */
    List<CertMagePageListVo> findPageList(CertMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息CertMage
     */
    CertMageInfoVo findInfo(LongIdPo po);

    /**
     * 根据店铺id 查看这个店铺下的证书
     * @param shopId
     * @return
     */
    List<CertMageInfoVo> findListCertMage(Long shopId);

    // 条件查询
    List<CertMageInfoVo> findByConditions(CertMage certMage);

    /**
     * 通过店铺id和证书名称查询
     * @param certName 证书名称
     * @param shopId 用户id
     */
    CertMageInfoVo findByCertName(@Param("certName") String certName, @Param("shopId") Long shopId);
}
