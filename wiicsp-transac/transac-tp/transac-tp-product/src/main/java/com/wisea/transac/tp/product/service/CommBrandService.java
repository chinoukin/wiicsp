package com.wisea.transac.tp.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.BrandMageMapper;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.entity.BrandMage;
import com.wisea.transac.common.entity.CommPubInfo;
import com.wisea.transac.common.po.product.BrandMageGetPo;
import com.wisea.transac.common.po.product.BrandMagePagePo;
import com.wisea.transac.common.vo.product.BrandMageGetVo;
import com.wisea.transac.common.vo.product.BrandMageListVo;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/18 下午4:34
 * @Description:品牌管理相关接口业务类
 */
@Service
@Transactional(readOnly = true)
public class CommBrandService {

    @Autowired
    private BrandMageMapper brandMageMapper;
    @Autowired
    CommPubInfoMapper commPubInfoMapper;

    /**
     * 查询品牌的列表
     */
    public ResultPoJo<Page<BrandMageListVo>> selectBrandList(BrandMagePagePo po) {
        ResultPoJo<Page<BrandMageListVo>> poJo = new ResultPoJo<>();
        Page<BrandMageListVo> page = po.getPage();
        //查询品牌顺序是否存在
        List<BrandMage> brandMages = brandMageMapper.selectSortIsNotNull(po);
        long count = brandMages.stream().filter(brand -> ConverterUtil.isNotEmpty(brand.getSort())).count();
        if (count > 0) {
            po.setRemarks("1");
        }
        List<BrandMageListVo> brandMageList = brandMageMapper.selectBrandList(po);
        page.setList(brandMageList);
        poJo.setResult(page);
        return poJo;
    }

    /**
     * 添加品牌
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo addBrand(BrandMage insert) {
        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantCodeMsg.ERR_000);
        //添加之前查询名称是否重复
        BrandMageListVo brandMageListVo = brandMageMapper.selectbyName(insert);
        if (brandMageListVo != null) {
            poJo.setCode(ConstantCodeMsg.ERR_319);
            poJo.setMsg(ConstantCodeMsg.MSG_319);
            return poJo;
        }
        if (ConverterUtil.isEmpty(insert.getSort())) {
            insert.setSort(null);
        }
        insert.preInsert();
        brandMageMapper.insertSelective(insert);
        return poJo;
    }

    /**
     * 编辑品牌
     */
    public ResultPoJo<BrandMageGetVo> editBrand(BrandMageGetPo po) {
        ResultPoJo pojo = new ResultPoJo<>();
        try {
            BrandMage brandMage = brandMageMapper.selectByPrimaryKey(po.getId());
            pojo.setResult(brandMage);
            pojo.setCode(ConstantCodeMsg.NOMAL);
        } catch (Exception e) {
            pojo.setCode(ConstantCodeMsg.ERR_311);
            pojo.setMsg(ConstantCodeMsg.MSG_311);
        }
        return pojo;
    }

    /**
     * 修改品牌
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo modifyBrand(BrandMage po) {
        ResultPoJo<Object> poJo = new ResultPoJo<>();
        //需要判断是否与商品有关联
        if (checkBrandRelation(po, poJo)) {
            return poJo;
        }
        //修改之前查询名称是否重复
        BrandMageListVo brandMageListVo = brandMageMapper.selectbyNameAndId(po);
        if (brandMageListVo != null) {
            poJo.setCode(ConstantCodeMsg.ERR_319);
            poJo.setMsg(ConstantCodeMsg.MSG_319);
            return poJo;
        }
        if (ConverterUtil.isEmpty(po.getSort())) {
            po.setSort(null);
        }
        po.preUpdate();
        brandMageMapper.updateByPrimaryKeySelective(po);
        return poJo;
    }

    /**
     * 删除品牌
     */
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo deleteBrand(BrandMage po) {
        ResultPoJo<Object> poJo = new ResultPoJo<>();
        if (checkBrandRelation(po, poJo)) {
            return poJo;
        }
        brandMageMapper.deleteLogic(po);
        return poJo;
    }

    /**
     * 判断品牌是否与商品关联
     *
     * @param po
     * @param poJo
     * @return
     */
    private boolean checkBrandRelation(BrandMage po, ResultPoJo<Object> poJo) {
        //需要判断是否与商品有关联
        List<CommPubInfo> commPubInfo = brandMageMapper.selectCommByBrandId(po.getId());
        if (commPubInfo.size() > 0) {
            poJo.setCode(ConstantCodeMsg.ERR_312);
            poJo.setMsg(ConstantCodeMsg.MSG_312);
            return true;
        }
        return false;
    }

    /**
     * 品牌列表业务接口
     */
    public ResultPoJo<List<BrandMageListVo>> brandInterface() {
        ResultPoJo<List<BrandMageListVo>> poJo = new ResultPoJo<>();
        List<BrandMageListVo> brandMageListVos = brandMageMapper.brandInterface();
        poJo.setResult(brandMageListVos);
        return poJo;
    }

    /**
     * 无权限无分页的商品品牌接口
     */
    public ResultPoJo<List<BrandMageListVo>> noAuthNoPageBrandList() {
        ResultPoJo<List<BrandMageListVo>> poJo = new ResultPoJo<>();
        BrandMagePagePo po = new BrandMagePagePo();

        //查询品牌顺序是否存在
        List<BrandMage> brandMages = brandMageMapper.selectSortIsNotNull(po);
        long count = brandMages.stream().filter(brand -> ConverterUtil.isNotEmpty(brand.getSort())).count();
        if (count > 0) {
            po.setRemarks("1");
        }
        List<BrandMageListVo> brandMageListVos = brandMageMapper.noAuthNoPageBrandList(po);
        poJo.setResult(brandMageListVos);
        return poJo;
    }

    /**
     * 根据品类id 查询品牌信息
     *
     * @param longIdPo
     * @return
     */
    public ResultPoJo<List<BrandMage>> findBrandListByCommMageId(LongIdPo longIdPo) {

        ResultPoJo<List<BrandMage>> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        List<BrandMage> brandMageList = new ArrayList<>();
        List<CommPubInfo> commPubInfoList = commPubInfoMapper.findBrandListByCommMageId(longIdPo);
        if (ConverterUtil.isNotEmpty(commPubInfoList)) {
            commPubInfoList.forEach(e -> {
                BrandMage brandMage = brandMageMapper.selectByPrimaryKey(e.getBrandMageId());
                brandMageList.add(brandMage);
            });
        }
        poJo.setResult(brandMageList);
        return poJo;
    }
}
