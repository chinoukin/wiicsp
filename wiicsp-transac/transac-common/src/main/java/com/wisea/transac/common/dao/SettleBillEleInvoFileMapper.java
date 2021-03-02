package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.SettleBillEleInvoFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SettleBillEleInvoFileMapper extends CrudDao<SettleBillEleInvoFile> {

    /**
     * @Author jirg
     * @Date 2020/5/18 9:56
     * @Description 根据发票ID删除电子发票文件
     **/
    void delByInvoId(@Param("invoId") Long id);
}
