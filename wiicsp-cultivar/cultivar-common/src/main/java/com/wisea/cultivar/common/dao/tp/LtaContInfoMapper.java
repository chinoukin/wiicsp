package com.wisea.cultivar.common.dao.tp;

import java.util.List;
import java.util.Map;

import com.wisea.cultivar.common.entity.tp.LtaContInfo;
import com.wisea.cultivar.common.po.tp.lta.LtaContEndDateTaskPo;
import com.wisea.cultivar.common.po.tp.lta.LtaContExportPo;
import com.wisea.cultivar.common.po.tp.lta.LtaContInfoPagePo;
import com.wisea.cultivar.common.po.tp.lta.LtaContPlatPagePo;
import com.wisea.cultivar.common.vo.tp.lta.LtaBuyerContInfoVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaContInfoDetailVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaContInfoExportVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaContInfoInitVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaContInfoListVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaContInfoPageVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaContPlatListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * 长期合同Mapper
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月7日
 * @version 1.0
 */
public interface LtaContInfoMapper extends CrudDao<LtaContInfo> {


	/**
	 * 分页查询长协合同列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月7日
	 * @version 1.0
	 */
	public List<LtaContInfoListVo> findLtaContPage(LtaContInfoPagePo po);
	/**
	 * 查询某个买家的长协合同状态数量
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月7日
	 * @version 1.0
	 */
	public LtaContInfoPageVo getLtaContStateCount(Map<String,Object> map);
	/**
	 * 通过企业名称查询会员ID
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月7日
	 * @version 1.0
	 */
	public String getMembIdByCompName(String compName);
	/**
	 * 根据ID查询长协合同基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月8日
	 * @version 1.0
	 */
	public LtaContInfoInitVo getLtaContInfoById(Long id);
	/**
	 * 保存合同信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月8日
	 * @version 1.0
	 */
	public void updateLtaContInfo(LtaContInfo ltaContInfo);
	/**
	 * 根据Id查询长协合同详细信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月8日
	 * @version 1.0
	 */
	public LtaContInfoDetailVo getLtaContDetailById(Long id);
	/**
	 * 验证长协合同编号是否重复
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月9日
	 * @version 1.0
	 */
	public List<String> checkLtaContNum(String appNum);

	/**
	 * 买家查询合同信息，带商家信息
	 * @param id
	 */
	public LtaBuyerContInfoVo buyerContAndName(Long id);
	/**
	 * 	取消申请解除更新长协合同信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月9日
	 * @version 1.0
	 */
	public void updLtaContCancelClear(LtaContInfo ltaContInfo);

	/**
	 * 长协合同导出列表的查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月10日
	 * @version 1.0
	 */
	public List<LtaContInfoExportVo> findListForExport(LtaContExportPo ltaContExportPo);
	/**
	 * 根据合同Id验证合同是否可以申请解除
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月10日
	 * @version 1.0
	 */
	public int checkLtaContStop(Long ltaContId);
	/**
	 * 定时任务查询要到期的合同
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月10日
	 * @version 1.0
	 */
	public List<LtaContInfo> findLatContListForTask(LtaContEndDateTaskPo po);
	/**
	 *  更新合同状态到合同到期
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月10日
	 * @version 1.0
	 */
	public void batchUpdLtaEndDate(List<Long> ids);
	/**
	 *
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年5月23日
	 * @version 1.0
	 */
	public List<LtaContPlatListVo> findContPageForPlat(LtaContPlatPagePo po);
}
