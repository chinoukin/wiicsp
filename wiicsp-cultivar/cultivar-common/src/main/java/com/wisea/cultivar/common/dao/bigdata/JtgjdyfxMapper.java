package com.wisea.cultivar.common.dao.bigdata;


/**
 * jtgjdyfx 表DAO
 * 交通工具调用分析
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.Jtgjdyfx;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxListPo;
import com.wisea.cultivar.common.po.bigdata.JtgjdyfxPagePo;
import com.wisea.cultivar.common.vo.bigdata.JtgjdyfxListVo;

import java.util.List;

/**
 * 列表查询
 */
public interface JtgjdyfxMapper extends CrudDao<Jtgjdyfx> {
    List<JtgjdyfxListVo> findPage(JtgjdyfxPagePo jtgjdyfxPagePo);

    List<JtgjdyfxListVo> findList(JtgjdyfxListPo jtgjdyfxListPo);
}
