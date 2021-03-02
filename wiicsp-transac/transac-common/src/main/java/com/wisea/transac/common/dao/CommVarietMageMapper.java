package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.CommVarietMage;
import com.wisea.transac.common.po.CommVarietMagePageListPo;
import com.wisea.transac.common.vo.product.CommVarietMageListVo;
import com.wisea.transac.common.po.product.CommVarietMagePagePo;
import com.wisea.transac.common.vo.CommVarietMageInfoVo;
import com.wisea.transac.common.vo.CommVarietMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommVarietMageMapper extends CrudDao<CommVarietMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询CommVarietMage
     */
    List<CommVarietMagePageListVo> findPageList(CommVarietMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息CommVarietMage
     */
    CommVarietMageInfoVo findInfo(LongIdPo po);

    /**
     * 获取所有品种列表
     * @param commVarietMage
     * @return
     */
    List<CommVarietMage> listCommVariet(CommVarietMage commVarietMage);


    /**
     * 验证品种名称是否重复
     * @param commVarietMage
     * @return
     */
    CommVarietMage insertCheckCommVarierMage(CommVarietMage commVarietMage);

    /**
     * 查询所有品种信息
     * @param commVarietMagePagePo
     * @return
     */
    List<CommVarietMageListVo> findCommVarierMageList(CommVarietMagePagePo commVarietMagePagePo);
}
