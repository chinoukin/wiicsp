package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.SubEntpVideoInfoMage;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpVideoInfoMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpVideoInfoMageListVo;

import java.util.List;

/**
 * sub_entp_video_info_mage 表DAO
 * 分公司视频信息维护
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface SubEntpVideoInfoMageMapper extends CrudDao<SubEntpVideoInfoMage> {
    List<SubEntpVideoInfoMageListVo> findPage(SubEntpVideoInfoMagePagePo subEntpVideoInfoMagePagePo);

    List<SubEntpVideoInfoMageListVo> findList(SubEntpVideoInfoMageListPo subEntpVideoInfoMageListPo);
}
