package com.wisea.cultivar.plant.mapper.oritrapla;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.oritrapla.PadYjInfo;
import com.wisea.cultivar.plant.po.oritrapla.PadYjInfoListPo;
import com.wisea.cultivar.plant.po.oritrapla.PadYjInfoPagePo;
import com.wisea.cultivar.plant.vo.oritrapla.PadYjInfoListVo;

import java.util.List;

/**
 * pad_yj_info 表DAO
 * 病虫害预警信息
 * 2019/08/23 11:17:19
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface PadYjInfoMapper extends CrudDao<PadYjInfo> {
    /**
     * 2020-06-04 14:41:29 李国然要求修改查询结果档案编号为基地名称
     * @param padYjInfoPagePo
     * @return
     */
    List<PadYjInfoListVo> findPage(PadYjInfoPagePo padYjInfoPagePo);

    List<PadYjInfoListVo> findList(PadYjInfoListPo padYjInfoListPo);

    /**
     * @author jirg
     * @date 2020/9/3 14:07
     * @Description 查询病虫害列表（前20条）
     */
    List<PadYjInfoListVo> findPestWarning();

    List<PadYjInfoListVo> find2ByArchId(Long id);
}
