package com.wisea.cultivar.seedlings.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.seedlings.entity.CheckFile;
import com.wisea.cultivar.seedlings.po.CheckFileListPo;
import com.wisea.cultivar.seedlings.po.CheckFilePagePo;
import com.wisea.cultivar.seedlings.vo.CheckFileListVo;
import java.util.List;

/**
 * check_file 表DAO
 * 验收材料
 * 2020/08/06 14:19:24
 */
public interface CheckFileMapper extends CrudDao<CheckFile> {
    /**
     * 分页查询
     */
    List<CheckFileListVo> findPage(CheckFilePagePo checkFilePagePo);

    /**
     * 列表查询
     */
    List<CheckFileListVo> findList(CheckFileListPo checkFileListPo);
}
