package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.StallsStaffRelaMageMapper;
import com.wisea.transac.common.entity.StallsStaffRelaMage;
import com.wisea.transac.common.mss.RemoteCustomerMss;
import com.wisea.transac.common.po.SaleStaffInfoMagePageListPo;
import com.wisea.transac.common.po.SaleStaffInfoMagePo;
import com.wisea.transac.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerListInsertPo;
import com.wisea.transac.common.po.seller.StallsStaffRelaMagePo;
import com.wisea.transac.common.vo.seller.SaleStaffInfoMagePageListVo;
import com.wisea.transac.common.vo.seller.StallsStaffRelaMageInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className StallsStaffRelaMageService
 * @date 2020/04/27 17:01:28
 * @Description
 */
@Service
public class StallsStaffRelaMageService extends BaseService {
    @Autowired
    private StallsStaffRelaMageMapper mapper;
    @Autowired
    private MembInfoMapper membInfoMapper;
    @Autowired
    private RemoteCustomerMss remoteCustomerMss;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询StallsStaffRelaMage
     */
    public ResultPoJo<Page<SaleStaffInfoMagePageListVo>> findPageList(SaleStaffInfoMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<SaleStaffInfoMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<SaleStaffInfoMagePageListVo> page = po.getPage();
        List<SaleStaffInfoMagePageListVo> list = mapper.findPageList(po);
        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 根据档口id查询所有员工
     *
     * @param ids
     *
     * @return
     */
    public ResultPoJo<List<SaleStaffInfoMagePageListVo>> findAll(List<Long> ids) {
        ResultPoJo<List<SaleStaffInfoMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        List<SaleStaffInfoMagePageListVo> list = ids.stream().flatMap(i -> {
            SaleStaffInfoMagePo po = new SaleStaffInfoMagePo();
            po.setStallsMageId(i);
            //不是管理员的
            po.setSfAdminFlag(DictConstants.SF_ADMIN_FLAG_1);
            return mapper.findAll(po).stream();
        }).distinct().collect(Collectors.toList());
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改StallsStaffRelaMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(StallsStaffRelaMagePo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        StallsStaffRelaMage mage = new StallsStaffRelaMage();
        mage.setStaffInfoMageId(po.getStaffInfoMageId());
        mage.setStallsMageId(po.getStallsMageId());
        StallsStaffRelaMageInfoVo info = mapper.findInfoByStaffIdAndStallId(mage);

        if (ConverterUtil.isNotEmpty(po.getId())) {
            //修改
            if (info == null) {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
            } else {
                StallsStaffRelaMage entity = mapper.selectByPrimaryKey(info.getId());
                entity.setRelaStateType(po.getRelaStateType());
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            }

        } else {

            if (ConverterUtil.isNotEmpty(info)) {
                StallsStaffRelaMage entity = mapper.selectByPrimaryKey(info.getId());
                entity.setRelaStateType(po.getRelaStateType());
                entity.preUpdate();
                mapper.updateByPrimaryKeySelective(entity);
            } else {
                //新增
                StallsStaffRelaMage entity = new StallsStaffRelaMage();
                BeanUtils.copyProperties(po, entity);
                entity.preInsert();
                mapper.insert(entity);

//                MembInfo membInfo = membInfoMapper.selectByPrimaryKey(po.getStaffInfoMageId());

                CustomerConfigUserInsertPo CCUPo = new CustomerConfigUserInsertPo();
//                CCUPo.setUserId(membInfo.getId());
                CCUPo.setUserId(po.getStaffInfoMageId());
                CCUPo.setAdmin("0");

                SysImCustomerListInsertPo siccipo = new SysImCustomerListInsertPo();
                siccipo.getUserList().add(CCUPo);
                siccipo.setGroupId(po.getStallsMageId().toString());

                ResultPoJo<Object> result = remoteCustomerMss.customerListInsert(siccipo);
                if (!result.getCode().equals(ConstantError.NOMAL)) {
                    throw new BusinessException(result.getCode(), result.getMsg());
                }

            }
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息StallsStaffRelaMage
     */
    public ResultPoJo<StallsStaffRelaMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<StallsStaffRelaMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        StallsStaffRelaMageInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }
}
