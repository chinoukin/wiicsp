package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.EleInvoFile;
import com.wisea.transac.common.po.EleInvoFilePageListPo;
import com.wisea.transac.common.vo.EleInvoFileInfoVo;
import com.wisea.transac.common.vo.EleInvoFilePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EleInvoFileMapper extends CrudDao<EleInvoFile> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询EleInvoFile
     */
    List<EleInvoFilePageListVo> findPageList(EleInvoFilePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息EleInvoFile
     */
    EleInvoFileInfoVo findInfo(LongIdPo po);

    /**
     * @Description 根据发票ID删除电子发票文件
     **/
    void delByInvoId(@Param("invoId") Long id);

    /**
     * 根据订单ID查询发票文件
     * @param id
     * @return
     */
    List<EleInvoFileInfoVo> ordInvoFiles(Long id);
}
