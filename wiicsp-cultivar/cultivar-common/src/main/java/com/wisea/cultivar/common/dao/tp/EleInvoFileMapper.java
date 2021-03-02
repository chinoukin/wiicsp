package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.EleInvoFile;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

/**
 * ele_invo_file 表DAO
 * 电子发票文件
 * 2018/10/10 16:17:18
 */
public interface EleInvoFileMapper extends CrudDao<EleInvoFile> {
    /**
     * @Author jirg
     * @Date 2019/4/25 11:36
     * @Description 根据订单发票ID删除
     **/
    public void delByOrdId(@Param("ordId") Long ordId);
}
