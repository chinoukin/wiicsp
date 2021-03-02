package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.ZhfwLevelSpecQuote;
import com.wisea.cultivar.plant.po.ZhfwLevelSpecQuotePageListPo;
import com.wisea.cultivar.plant.vo.ZhfwLevelSpecQuoteInfoVo;
import com.wisea.cultivar.plant.vo.ZhfwLevelSpecQuotePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ZhfwLevelSpecQuoteMapper extends CrudDao<ZhfwLevelSpecQuote> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:27:46
     * @Description 分页查询ZhfwLevelSpecQuote
     */
    List<ZhfwLevelSpecQuotePageListVo> findPageList(ZhfwLevelSpecQuotePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/08/07 17:27:46
     * @Description 查询详细信息ZhfwLevelSpecQuote
     */
    ZhfwLevelSpecQuoteInfoVo findInfo(LongIdPo po);
}
