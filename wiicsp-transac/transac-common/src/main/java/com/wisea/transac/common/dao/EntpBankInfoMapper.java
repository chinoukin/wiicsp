package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.EntpAuth;
import com.wisea.transac.common.entity.EntpBankInfo;
import com.wisea.transac.common.po.EntpBankInfoPageListPo;
import com.wisea.transac.common.vo.EntpBankInfoPageListVo;
import com.wisea.transac.common.vo.memb.EntpBankInfoInitVo;

@Mapper
@Repository
public interface EntpBankInfoMapper extends CrudDao<EntpBankInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询EntpBankInfo
     */
    List<EntpBankInfoPageListVo> findPageList(EntpBankInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息EntpBankInfo
     */
    EntpBankInfoInitVo findInfo(LongIdPo po);
    /**
     * 根据企业信息删除银行卡信息
     *
     * @author wangh(wisea)
     *
     * @date 2020年5月12日
     * @version 1.0
     */
    public void updDelByEntpId(EntpAuth entpAuth);
}
