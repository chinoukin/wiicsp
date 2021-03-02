package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.EntpBankInfo;
import com.wisea.cultivar.common.po.tp.EmtpBankInfoUpdPo;
import com.wisea.cultivar.common.po.tp.EntpBankInfoListPo;
import com.wisea.cultivar.common.vo.tp.EntpBankInfoListVo;
import com.wisea.cultivar.common.vo.tp.EntpBankInfoVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * 企业银行卡信息Mapper
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月29日
 * @version 1.0
 */
public interface EntpBankInfoMapper extends CrudDao<EntpBankInfo> {

	/**
	 * 查询企业的银行卡信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月30日
	 * @version 1.0
	 */
	public EntpBankInfo getBankInfoByEntpId(EntpBankInfoListPo po);
	/**
	 * 根据id查询银行卡信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月30日
	 * @version 1.0
	 */
	public EntpBankInfoVo getEntpBankInfo(Long id);
	/**
	 * 修改EntpdataId
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月30日
	 * @version 1.0
	 */
	public int updByEntpDataId(EmtpBankInfoUpdPo po);
	/**
	 * 查询所有银行卡信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月30日
	 * @version 1.0
	 */
	public List<EntpBankInfoListVo> findListForEntpAuth(EntpBankInfoListPo po);
	/**
	 * 批量插入数据
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月30日
	 * @version 1.0
	 */
	public int insertBatchEntpBank(List<EntpBankInfo> list);
	/**
	 * 批量删除
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月30日
	 * @version 1.0
	 */
	public int bachtDelByEntpDataId(Long entpDataId);
	/**
	 *  验证企业银行卡号是否重复的操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年12月5日
	 * @version 1.0
	 */
	public int checkBankNum(EntpBankInfo entpBankInfo);
	/**
	 *  根据企业id删除银行信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年1月17日
	 * @version 1.0
	 */
	public void deleteLogicByEntpId(Long entpId);
}
