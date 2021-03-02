package com.wisea.cultivar.explorer.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cultivar.explorer.entity.RelationIotInfo;
import com.wisea.cultivar.explorer.mapper.RelationIotInfoMapper;
import com.wisea.cultivar.explorer.po.DemonsBaseMassifGetPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * explain:
 * </p>
 *
 * @author wangjunming
 * @since 2020/8/14 17:08
 */
@Service
public class RelationIotInfoService extends BaseService {

    @Autowired
    private RelationIotInfoMapper relationIotInfoMapper;

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(RelationIotInfo relationIotInfo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        relationIotInfo.preInsert();
        relationIotInfoMapper.insert(relationIotInfo);
        return result;
    }


    /**
     * 根据示范基地地块ID删除关联的物联网设备ID
     * @param id 示范基地地块ID
     */
    public void delete(Long id) {
        relationIotInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 通过地块ID查询所关联的物联网ID列表
     * @param demonsBaseMassifGetPo  地块ID
     * @return List<Long>
     */
    public List<Long> equipmentIds(DemonsBaseMassifGetPo demonsBaseMassifGetPo) {
        return relationIotInfoMapper.equipmentIds(demonsBaseMassifGetPo);
    }
}
