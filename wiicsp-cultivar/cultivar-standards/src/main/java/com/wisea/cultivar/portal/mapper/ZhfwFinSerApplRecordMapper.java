package com.wisea.cultivar.portal.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.portal.entity.ZhfwFinSerApplRecord;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordListPo;
import com.wisea.cultivar.portal.po.ZhfwFinSerApplRecordPagePo;
import com.wisea.cultivar.portal.vo.ZhfwFinSerApplRecordListVo;
import java.util.List;

/**
 * zhfw_fin_ser_appl_record 表DAO
 * 种植服务金融服务申请记录
 * 2020/08/24 20:28:13
 */
public interface ZhfwFinSerApplRecordMapper extends CrudDao<ZhfwFinSerApplRecord> {
    /**
     * 分页查询
     */
    List<ZhfwFinSerApplRecordListVo> findPage(ZhfwFinSerApplRecordPagePo zhfwFinSerApplRecordPagePo);

    /**
     * 列表查询
     */
    List<ZhfwFinSerApplRecordListVo> findList(ZhfwFinSerApplRecordListPo zhfwFinSerApplRecordListPo);
}
