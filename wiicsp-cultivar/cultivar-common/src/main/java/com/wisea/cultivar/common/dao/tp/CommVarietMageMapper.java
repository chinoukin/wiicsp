package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.CommVarietMage;
import com.wisea.cultivar.common.po.tp.CommVarietMageListPo;
import com.wisea.cultivar.common.po.tp.CommVarietMagePagePo;
import com.wisea.cultivar.common.vo.tp.CommVarietMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * comm_variet_mage 表DAO
 * 商品品种管理
 * 2019/04/15 09:49:09
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Repository
public interface CommVarietMageMapper extends CrudDao<CommVarietMage> {
    List<CommVarietMageListVo> findPage(CommVarietMagePagePo commVarietMagePagePo);

    List<CommVarietMageListVo> findList(CommVarietMageListPo commVarietMageListPo);

    /**
     * 查询所有品种信息
     * @param commVarietMagePagePo
     * @return
     */
    List<CommVarietMageListVo> findCommVarierMageList(CommVarietMagePagePo commVarietMagePagePo);

    /**
     * 验证品种名称是否重复
     * @param commVarietMage
     * @return
     */
    CommVarietMage insertCheckCommVarierMage(CommVarietMage commVarietMage);

    /**
     * @Author jirg
     * @Date 2019/5/27 14:07
     * @Description 查询所有品种列表
     **/
    List<CommVarietMage> listCommVariet(CommVarietMage commVarietMage);

    /**
     * 查询所有品种产地货源使用
     * @param commVariet
     * @return
     */
    List<CommVarietMage> findCommVarierList(CommVarietMage commVariet);
}
