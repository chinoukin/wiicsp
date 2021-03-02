package com.wisea.cultivar.seedlings.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.po.trade.EntpInfoMagePo;
import com.wisea.cultivar.common.vo.trade.EntpAuthInfoVo;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.explorer.entity.OilTeaVarietMage;
import com.wisea.cultivar.explorer.mapper.OilTeaVarietMageMapper;
import com.wisea.cultivar.explorer.vo.EntpInfoMageGetVo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageGetVo;
import com.wisea.cultivar.seedlings.entity.SproutCatalogMage;
import com.wisea.cultivar.seedlings.entity.SproutEntp;
import com.wisea.cultivar.seedlings.entity.SproutEntpInfoMage;
import com.wisea.cultivar.seedlings.mapper.SproutCatalogMageInfoMapper;
import com.wisea.cultivar.seedlings.mapper.SproutCatalogMageMapper;
import com.wisea.cultivar.seedlings.mapper.SproutEntpMapper;
import com.wisea.cultivar.seedlings.po.*;
import com.wisea.cultivar.seedlings.vo.BuySproutIndividualInfoListVo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageGetVo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageListVo;
import com.wisea.cultivar.seedlings.vo.SproutMageGetVo;
import com.wisea.cultivar.supply.util.CustomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * SproutCatalogMageService
 * 种苗目录管理 Service
 * 2020/08/06 14:19:24
 */
@Service
public class SproutCatalogMageService extends BaseService {
    @Autowired
    protected SproutCatalogMageMapper sproutCatalogMageMapper;
    @Autowired
    protected SproutEntpMapper sproutEntpMapper;
    @Autowired
    private SproutCatalogMageInfoMapper sproutCatalogMageInfoMapper;
    @Resource
    private OilTeaVarietMageMapper oilTeaVarietMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<SproutCatalogMageListVo>> findPage(SproutCatalogMagePagePo sproutCatalogMagePagePo) {
        ResultPoJo<Page<SproutCatalogMageListVo>> result = new ResultPoJo<>();
        Page<SproutCatalogMageListVo> page = sproutCatalogMagePagePo.getPage();
        List<SproutCatalogMageListVo> list = sproutCatalogMageMapper.findPage(sproutCatalogMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<SproutCatalogMageListVo>> findList(SproutCatalogMageListPo sproutCatalogMageListPo) {
        ResultPoJo<List<SproutCatalogMageListVo>> result = new ResultPoJo<>();
        result.setResult(sproutCatalogMageMapper.findList(sproutCatalogMageListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<SproutCatalogMageGetVo> get(SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        ResultPoJo<SproutCatalogMageGetVo> result = new ResultPoJo<>();
        SproutCatalogMageGetVo vo = sproutCatalogMageMapper.detalis(sproutCatalogMageGetPo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(SproutCatalogMageInsertPo sproutCatalogMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SproutCatalogMage sprout = sproutCatalogMageMapper.findBySproutYear(sproutCatalogMageInsertPo.getSproutYear());
        if (sprout !=null){
            result.setMsg(QdcyStandardsError.MSG_50002);
            result.setCode(QdcyStandardsError.ERR_50002);
            return result;
        }
        SproutCatalogMage sproutCatalogMage = new SproutCatalogMage();
        ConverterUtil.copyProperties(sproutCatalogMageInsertPo, sproutCatalogMage);
        sproutCatalogMage.setMainThrustNum(sproutCatalogMageInsertPo.getOilTeaVarietId().size());
        sproutCatalogMage.preInsert();
        sproutCatalogMageMapper.insert(sproutCatalogMage);
        //企业与定点种苗企业进行关联
        for (Long membId: sproutCatalogMageInsertPo.getMembId()) {
            SproutEntp sproutEntp = new SproutEntp();
            sproutEntp.setSproutCatalogMageId(sproutCatalogMage.getId());
            sproutEntp.setMembId(membId);
            sproutEntp.preInsert();
            sproutEntpMapper.insert(sproutEntp);
        }
        //中间表与油茶品种进行关联
        for (Long oilTeaVarietId: sproutCatalogMageInsertPo.getOilTeaVarietId()) {
            SproutEntpInfoMage infoMage = new SproutEntpInfoMage();
            infoMage.setSproutCatalogMageId(sproutCatalogMage.getId());
            infoMage.setOilTeaVarietId(oilTeaVarietId);
            infoMage.preInsert();
            sproutCatalogMageInfoMapper.insert(infoMage);

        }
        result.setResult(sproutCatalogMage.getId());
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(SproutCatalogMageUpdatePo sproutCatalogMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        //获取库中所对应的年份
        SproutCatalogMage sprout = sproutCatalogMageMapper.findBySproutYear(sproutCatalogMageUpdatePo.getSproutYear());
        if (sprout !=null){
            //获取该目录所对应的年份
            SproutCatalogMage sproutCatalogMage1 = sproutCatalogMageMapper.selectByPrimaryKey(sproutCatalogMageUpdatePo.getId());
            //如果查询出来的年份相同并且年份对应的id相同可以进行年份修改
            if(sprout.getSproutYear().equals(sproutCatalogMage1.getSproutYear())){
                if(sproutCatalogMageUpdatePo.getId().equals(sprout.getId()) && sprout.getId().equals(sproutCatalogMage1.getId())){
                    SproutCatalogMage sproutCatalogMage = new SproutCatalogMage();
                    sproutCatalogMage.setMainThrustNum(sproutCatalogMageUpdatePo.getOilTeaVarietId().size());   //主推品种数累加
                    ConverterUtil.copyProperties(sproutCatalogMageUpdatePo, sproutCatalogMage);
                    sproutCatalogMage.preUpdate();
                    sproutCatalogMageMapper.updateByPrimaryKeySelective(sproutCatalogMage);
                    //企业与定点种苗企业进行关联
                    sproutEntpMapper.deleteByPrimaryKey(sproutCatalogMageUpdatePo.getId());
                    for (Long membId: sproutCatalogMageUpdatePo.getMembId()) {
                        SproutEntp sproutEntp = new SproutEntp();
                        sproutEntp.setSproutCatalogMageId(sproutCatalogMage.getId());
                        sproutEntp.setMembId(membId);
                        sproutEntp.preInsert();
                        sproutEntpMapper.insert(sproutEntp);
                    }
                    //中间表与油茶品种进行关联
                    sproutCatalogMageInfoMapper.deleteByPrimaryKey(sproutCatalogMageUpdatePo.getId());
                    for (Long oilTeaVarietId: sproutCatalogMageUpdatePo.getOilTeaVarietId()) {
                        SproutEntpInfoMage infoMage = new SproutEntpInfoMage();
                        infoMage.setSproutCatalogMageId(sproutCatalogMage.getId());
                        infoMage.setOilTeaVarietId(oilTeaVarietId);
                        infoMage.preInsert();
                        sproutCatalogMageInfoMapper.insert(infoMage);

                    }
                    result.setResult(sproutCatalogMage.getId());
                    return result;
                }
            }
            else {
                result.setMsg(QdcyStandardsError.MSG_50002);
                result.setCode(QdcyStandardsError.ERR_50002);
                return result;
            }
        }
        SproutCatalogMage sproutCatalogMage = new SproutCatalogMage();
        ConverterUtil.copyProperties(sproutCatalogMageUpdatePo, sproutCatalogMage);
        sproutCatalogMage.preUpdate();
        int id = sproutCatalogMageMapper.updateByPrimaryKeySelective(sproutCatalogMage);
        //企业与定点种苗企业进行关联
        sproutEntpMapper.deleteByPrimaryKey(sproutCatalogMageUpdatePo.getId());
        for (Long membId: sproutCatalogMageUpdatePo.getMembId()) {
            SproutEntp sproutEntp = new SproutEntp();
            sproutEntp.setSproutCatalogMageId(sproutCatalogMage.getId());
            sproutEntp.setMembId(membId);
            sproutEntp.preInsert();
            sproutEntpMapper.insert(sproutEntp);
        }
        //中间表与油茶品种进行关联
        sproutCatalogMageInfoMapper.deleteByPrimaryKey(sproutCatalogMageUpdatePo.getId());
        for (Long oilTeaVarietId: sproutCatalogMageUpdatePo.getOilTeaVarietId()) {
            SproutEntpInfoMage infoMage = new SproutEntpInfoMage();
            infoMage.setSproutCatalogMageId(sproutCatalogMage.getId());
            infoMage.setOilTeaVarietId(oilTeaVarietId);
            infoMage.preInsert();
            sproutCatalogMageInfoMapper.insert(infoMage);

        }
        result.setResult(id);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(SproutCatalogMageBatDeletePo sproutCatalogMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : sproutCatalogMageBatDeletePo.getDelList()) {
            SproutCatalogMage sproutCatalogMage = new SproutCatalogMage();
            sproutCatalogMage.setId(delId);
            sproutCatalogMage.preUpdate();
            sproutCatalogMageMapper.deleteLogic(sproutCatalogMage);
        }
        return result;
    }

    public ResultPoJo<List<EntpInfoMageGetVo>> findEntpInfoList(EntpInfoMagePo entpInfoMagePo) {
        ResultPoJo<List<EntpInfoMageGetVo>> result = new ResultPoJo<>();
        List<EntpInfoMageGetVo> entpInfoMageGetList = sproutCatalogMageMapper.findEntpInfoList(entpInfoMagePo);
        result.setResult(entpInfoMageGetList);
        return result;
    }

    /**
     * 发布种苗信息
     * @param sproutCatalogMageGetPo
     * @return
     */
    public ResultPoJo<Object> releaseSeedlings(SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        SproutCatalogMage sproutCatalogMageDetil = sproutCatalogMageMapper.selectByPrimaryKey(sproutCatalogMageGetPo.getId());
        //草稿的情况下
        if(sproutCatalogMageDetil.getSproutCatalogStateType().equals(DictConstants.SPROUT_CATALOG_STATE_TYPE_0)
            && sproutCatalogMageGetPo.getSproutCatalogStateType().equals(DictConstants.SPROUT_CATALOG_STATE_TYPE_1)){
                //进行发布
                SproutCatalogMage sproutCatalogMage = new SproutCatalogMage();
                ConverterUtil.copyProperties(sproutCatalogMageGetPo, sproutCatalogMage);
                sproutCatalogMage.setUpdateDate(OffsetDateTime.now());
                sproutCatalogMage.preUpdate();
                sproutCatalogMageMapper.updateByPrimaryKeySelective(sproutCatalogMage);
        }
        return result;
    }

    /**
     * 查询历年种苗目录信息
     * @param sproutCatalogMageGetPo
     * @return
     */
    public ResultPoJo<SproutCatalogMageGetVo> sproutCataLogDetails(SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        ResultPoJo<SproutCatalogMageGetVo> result = new ResultPoJo<>();
        List<OilTeaVarietMageGetVo> oilTeaVarietMageGetVos = sproutCatalogMageMapper.sproutCataLogDetails(sproutCatalogMageGetPo);
        List<EntpAuthInfoVo> entpAuthInfoVos = sproutCatalogMageMapper.selectEntpDetails(sproutCatalogMageGetPo);
        SproutCatalogMageGetVo sproutCatalogMageGetVo = new SproutCatalogMageGetVo();
        sproutCatalogMageGetVo.setOilTeaVarietMageGetVos(oilTeaVarietMageGetVos);
        sproutCatalogMageGetVo.setEntpAuthInfoVos(entpAuthInfoVos);
        result.setResult(sproutCatalogMageGetVo);
        return result;
    }

    /**
     * 查询历年种苗详情信息
     */
    public ResultPoJo<SproutMageGetVo> sproutDetails(SproutCatalogMageGetPo sproutCatalogMageGetPo) {
        OilTeaVarietMage oilTeaVarietMage = oilTeaVarietMageMapper.selectByPrimaryKey(sproutCatalogMageGetPo.getId());
        SproutMageGetVo sproutMageGetVo = new SproutMageGetVo();
        OilTeaVarietMageGetVo oilTeaVarietMageGetVo = new OilTeaVarietMageGetVo();
        ConverterUtil.copyProperties(oilTeaVarietMage, oilTeaVarietMageGetVo);
        sproutMageGetVo.setOilTeaVarietMageGetVos(oilTeaVarietMageGetVo);
        //定点企业
        sproutMageGetVo.setEntpAuthInfoVos(sproutCatalogMageMapper.selectPlantEntp(sproutCatalogMageGetPo.getId()));
        //种植户坐标
        sproutMageGetVo.setIndividuals(sproutCatalogMageMapper.selectBuyCoordinates(sproutCatalogMageGetPo.getId()));
        return CustomUtils.result(sproutMageGetVo);
    }

    /**
     * 查询种植户种植详情
     */
    public ResultPoJo<List<BuySproutIndividualInfoListVo>> buyDetails(SproutBuyGetPo sproutBuyGetPo) {
        return CustomUtils.result(sproutCatalogMageMapper.selectBuyDetails(sproutBuyGetPo));
    }
}
