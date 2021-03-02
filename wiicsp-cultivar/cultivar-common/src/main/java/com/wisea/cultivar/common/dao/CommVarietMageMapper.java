package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.CommVarietMage;
import com.wisea.cultivar.common.po.CommVarietMagePageListPo;
import com.wisea.cultivar.common.po.product.CommVarietMagePagePo;
import com.wisea.cultivar.common.vo.CommVarietMageInfoVo;
import com.wisea.cultivar.common.vo.CommVarietMagePageListVo;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("NbCommVarietMageMapper")
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

    List<CommVarietMageListVo> findTwoLevelList(CommVarietMagePagePo commVarietMagePagePo);


}
