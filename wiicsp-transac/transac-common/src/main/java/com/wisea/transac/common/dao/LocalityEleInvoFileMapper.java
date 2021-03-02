package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.LocalityEleInvoFile;
import com.wisea.transac.common.vo.EleInvoFileInfoVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LocalityEleInvoFileMapper extends CrudDao<LocalityEleInvoFile> {

    /**
     * 根据订单ID查询发票文件
     * @param id
     * @return
     */
    List<EleInvoFileInfoVo> ordInvoFiles(Long id);
}
