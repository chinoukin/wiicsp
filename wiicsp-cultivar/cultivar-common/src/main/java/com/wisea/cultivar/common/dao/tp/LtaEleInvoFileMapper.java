package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.LtaEleInvoFile;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

public interface LtaEleInvoFileMapper extends CrudDao<LtaEleInvoFile> {
    /**
     * @Author jirg
     * @Date 2019/5/9 11:17
     * @Description 根据订单ID删除订单发票附件信息
     **/
    void delByOrdId(@Param("ltaOrdId") Long ltaOrdId);
}
