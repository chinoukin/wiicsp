package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.InformationMage;
import com.wisea.cultivar.common.po.tp.portal.InfomaMagNotAuthPagePo;
import com.wisea.cultivar.common.po.tp.portal.InfomaMagNotAuthPo;
import com.wisea.cultivar.common.po.tp.portal.InfomationMageNotAuthPo;
import com.wisea.cultivar.common.po.tp.portal.InformationMagePageListPo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.portal.InformationMageDetailVo;
import com.wisea.cultivar.common.vo.tp.portal.InformationMagePageListVo;

/**
 * information_mage 表DAO
 * 资讯信息管理
 * 2019/05/28 16:20:20
 */
public interface InformationMageMapper extends CrudDao<InformationMage> {
	/**
	 * 分页查询资讯信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月29日
	 * @version 1.0
	 */
    public List<InformationMagePageListVo> findPage(InformationMagePageListPo po);
    /**
     * 批量删除处理
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月29日
     * @version 1.0
     */
    public void batchDelLogic(@Param("list") List<Long> ids);
    /**
     * 首页查询资讯列表的处理
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月29日
     * @version 1.0
     */
    public List<InformationMagePageListVo> findListNotAuth(InfomaMagNotAuthPo po);
    /**
     * 首页分页查询资讯信息列表
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月29日
     * @version 1.0
     */
    public List<InformationMagePageListVo> findPageListNotAuth(InfomaMagNotAuthPagePo po);

    /**
     * 首页查询资讯详细信息
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月30日
     * @version 1.0
     */
    public InformationMageDetailVo getDetail(InfomationMageNotAuthPo po);
    public List<InformationMageDetailVo> getDetailPreAndNext(InfomationMageNotAuthPo po);

}
