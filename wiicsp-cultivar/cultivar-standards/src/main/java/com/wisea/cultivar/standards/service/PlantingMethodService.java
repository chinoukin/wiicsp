package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.mss.RemoteCommMageMss;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.vo.product.ZhfwCommMageTreeVo;
import com.wisea.cultivar.standards.entity.*;
import com.wisea.cultivar.standards.mapper.*;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PlantingMethodService
 * 种植方法 Service
 * 2020/07/24 11:21:45
 */
@Service
public class PlantingMethodService extends BaseService {
    @Autowired
    protected PlantingMethodMapper plantingMethodMapper;

    @Autowired
    protected FarmingStageMapper farmingStageMapper;

    @Autowired
    protected FarmingCycleMapper farmingCycleMapper;

    @Autowired
    protected FarmingCycleService farmingCycleService;

    @Autowired
    protected StagePictureMapper stagePictureMapper;

    @Autowired
    protected StandardMageMapper standardMageMapper;

    @Autowired
    FarmWorkTypeDictMapper  farmWorkTypeDictMapper;

    @Autowired
    protected StagePictureService stagePictureService;

    @Autowired
    RemoteCommMageMss commMageMss;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<PlantingMethodListVo>> findPage(PlantingMethodPagePo plantingMethodPagePo) {
        ResultPoJo<Page<PlantingMethodListVo>> result = new ResultPoJo<>();
        Page<PlantingMethodListVo> page = plantingMethodPagePo.getPage();
        List<PlantingMethodListVo> list = plantingMethodMapper.findPage(plantingMethodPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<PlantingMethodListVo>> findList(PlantingMethodListPo plantingMethodListPo) {
        ResultPoJo<List<PlantingMethodListVo>> result = new ResultPoJo<>();
        result.setResult(plantingMethodMapper.findList(plantingMethodListPo));
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<PlantingMethodGetVo> get(PlantingMethodGetPo plantingMethodGetPo) {
        ResultPoJo<PlantingMethodGetVo> result = new ResultPoJo<>();
        PlantingMethod entity = plantingMethodMapper.selectByPrimaryKey(plantingMethodGetPo.getId());
        PlantingMethodGetVo vo = new PlantingMethodGetVo();
        ConverterUtil.copyProperties(entity, vo);

        /**
         *农事周期
         */
        FarmingCycleListPo farmingCycleListPo = new FarmingCycleListPo();
        farmingCycleListPo.setPlantingMethodId(plantingMethodGetPo.getId());
        List<FarmingCycleListVo> farmingCycleList = farmingCycleMapper.findByPlantingMethodIdList(farmingCycleListPo);
        for (FarmingCycleListVo farmingCycleListVo : farmingCycleList) {
            /**
             * 农事信息
             */
            FarmingStageListPo farmingStageListPo = new FarmingStageListPo();
            farmingStageListPo.setFarmingCycleId(farmingCycleListVo.getId());
            List<FarmingStageListVo> farmingStageList = farmingStageMapper.findFarmingCycleIdList(farmingStageListPo);

            for (FarmingStageListVo farmingStageListVo : farmingStageList) {
                /**
                 * 图片
                 */
                StagePictureListPo stagePictureListPo = new StagePictureListPo();
                stagePictureListPo.setFarmingStageId(farmingStageListVo.getId());
                List<StagePictureListVo> stagePictureList = stagePictureMapper.findFarmingStageIdList(stagePictureListPo);
                farmingStageListVo.setStagePictureListVo(stagePictureList);
            }
            farmingCycleListVo.setFarmingStageListVo(farmingStageList);
        }
        vo.setFarmingCycleListVo(farmingCycleList);
        /**
         * 农事信息
         */
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(PlantingMethodInsertPo plantingMethodInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        PlantingMethod plantingMethod = new PlantingMethod();
        //种植标准管理id:plantStandardMageId
        //保存关联标准
        ConverterUtil.copyProperties(plantingMethodInsertPo, plantingMethod);
        plantingMethod.preInsert();
        plantingMethodMapper.insert(plantingMethod);

        //插入标准详情
        if (plantingMethodInsertPo.getFarmingCycleInsertPo()!=null){
            insertPlantingMethodDetails(plantingMethod, plantingMethodInsertPo.getFarmingCycleInsertPo());
        }

        //插入农事信息
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(PlantingMethodUpdatePo plantingMethodUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        PlantingMethod plantingMethod = new PlantingMethod();
        ConverterUtil.copyProperties(plantingMethodUpdatePo, plantingMethod);
        plantingMethod.preUpdate();
        plantingMethodMapper.updateByPrimaryKeySelective(plantingMethod);

        //查询该种植方法下的所有种植周期
        List<FarmingCycle> allCycle =
                farmingCycleMapper.getAllCycle(plantingMethodUpdatePo.getId());
        if (ConverterUtil.isNotEmpty(allCycle)) {
            //根据农事周期查询到所有农事阶段
            List<FarmingStage> allStage =
                    farmingStageMapper.getAllStage(allCycle);
            if (ConverterUtil.isNotEmpty(allStage)) {
                //根据农事阶段查询是否有照片资源
                List<StagePicture> allPicture
                        = stagePictureMapper.getAllPicture(allStage);
                if (ConverterUtil.isNotEmpty(allPicture)) {
                    //删除所有的农事阶段照片资源
                    stagePictureMapper.deleteAllStage(allStage);
                }
                //删除原有所有农事阶段数据
                farmingStageMapper.deleteAll(allCycle);
            }
            //删除所有的农事周期
            farmingCycleMapper.deleteAllCycle(plantingMethodUpdatePo.getId());
        }

        //逻辑删除所有原来的详情记录
//        FarmingCycle farmingCycle = new FarmingCycle();
//        farmingCycle.setId(plantingMethodUpdatePo.getId());
//        farmingCycle.preInsert();
//        List<FarmingCycle> farmingCycleList = farmingCycleMapper.findList(farmingCycle);
        //删除子表中的数据
//       farmingCycleList.forEach(b->{
//            FarmingStage farmingStage = new FarmingStage();
//            farmingStage.setFarmingCycleId(b.getId());
//            farmingStage.preInsert();
//            List<FarmingStage> farmingStageList = farmingStageMapper.findList(farmingStage);
//            farmingStageList.forEach(f->{
//                StagePicture stagePicture = new StagePicture();
//                stagePicture.setFarmingStageId(f.getId());
//                stagePicture.preInsert();
//                List<StagePicture> stagePictureList = stagePictureMapper.findList(stagePicture);
//                stagePictureMapper.batchDelete(stagePictureList);
//            });
//            farmingStageMapper.batchDelete(farmingStageList);
//
//        });
//        FarmingCycleBatDeletePo farmingCycleBatDeletePo = new FarmingCycleBatDeletePo();
//        ConverterUtil.copyProperties(farmingCycleList, farmingCycleBatDeletePo);
//        farmingCycleService.batDelete(farmingCycleBatDeletePo);

        //插入标准详情
        //其次循环添加农事周期
        if (ConverterUtil.isNotEmpty(plantingMethodUpdatePo.getFarmingCycleInsertPo())){
            insertPlantingMethodDetails(plantingMethod, plantingMethodUpdatePo.getFarmingCycleInsertPo());
        }
        return result;
    }

    /**
     * 插入StandardInfo
     *
     * @param plantingMethod
     */
    private void insertPlantingMethodDetails(PlantingMethod plantingMethod, List<FarmingCycleInsertPo> farmingCycleInsertPo) {
        List<FarmingCycleInsertPo> details = farmingCycleInsertPo;
        details.forEach(d -> {
            FarmingCycle farmingCycle = new FarmingCycle();
            ConverterUtil.copyProperties(d, farmingCycle);
            farmingCycle.setPlantingMethodId(plantingMethod.getId());
            farmingCycle.preInsert();
            farmingCycleMapper.insert(farmingCycle);

            /**
             * 农事信息
             */
            List<FarmingStageInsertPo> farmingStageInsertPoList = new ArrayList();
            farmingStageInsertPoList = d.getFarmingStageInsertPo();
            if (ConverterUtil.isNotEmpty(farmingStageInsertPoList)){
                farmingStageInsertPoList.forEach(f -> {
                    FarmingStage farmingStage = new FarmingStage();
                    ConverterUtil.copyProperties(f, farmingStage);
                    farmingStage.setFarmingCycleId(farmingCycle.getId());
                    farmingStage.setRemarks(f.getRemarks());
                    farmingStage.preInsert();
                    farmingStageMapper.insert(farmingStage);

                    /**
                     * 图片信息
                     */
                    List<StagePictureInsertPo> stagePictureInsertPoList = new ArrayList();
                    stagePictureInsertPoList = f.getStagePictureInsertPo();
                    if (ConverterUtil.isNotEmpty(stagePictureInsertPoList)){
                        stagePictureInsertPoList.forEach(s -> {
                            StagePicture stagePicture = new StagePicture();
                            ConverterUtil.copyProperties(s, stagePicture);
                            stagePicture.setFarmingStageId(farmingStage.getId());
                            stagePicture.preInsert();
                            stagePictureMapper.insert(stagePicture);
                        });
                    }
                });
            }
        });
    }



    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(PlantingMethodBatDeletePo plantingMethodBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for (Long delId : plantingMethodBatDeletePo.getDelList()) {
            PlantingMethod plantingMethod = new PlantingMethod();
            plantingMethod.setId(delId);
            plantingMethod.preUpdate();
            plantingMethodMapper.deleteLogic(plantingMethod);
        }
        return result;
    }

    /**
     * 获取分类
     * @param commMageTreePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> getCommId(CommMageTreePo commMageTreePo) {
        ResultPoJo<Object> list = new ResultPoJo<>();
        CommMageTreePo commMage = new CommMageTreePo();
        commMage.setPid(commMageTreePo.getPid());
        ResultPoJo<List<ZhfwCommMageTreeVo>> commMageTree = commMageMss.findCommMageTree(commMage);
        list.setResult(commMageTree);
        return list;
    }

    /**
     * 获取关联标准
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> getPlantStandardMageFindList(StandardMageListPo standardMageListPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        StandardMageListPo standardMageList = new StandardMageListPo();
        standardMageList.setPlantRecoProcessType(standardMageListPo.getPlantRecoProcessType());
        List<StandardMageListVo> list = standardMageMapper.findList(standardMageList);
        result.setResult(list);
        return result;
    }

    /**
     * 删除
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> oneDelete(PlantingMethodOneDeletePo plantingMethodOneDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
//        PlantingMethod plantingMethod = new PlantingMethod();
//        plantingMethod.setId(plantingMethodOneDeletePo.getId());
//        plantingMethod.preUpdate();
//        plantingMethodMapper.deleteLogic(plantingMethod);
        //查询该种植方法下的所有种植周期
        List<FarmingCycle> allCycle =
                farmingCycleMapper.getAllCycle(plantingMethodOneDeletePo.getId());
        if (ConverterUtil.isNotEmpty(allCycle)) {
            //根据农事周期查询到所有农事阶段
            List<FarmingStage> allStage =
                    farmingStageMapper.getAllStage(allCycle);
            if (ConverterUtil.isNotEmpty(allStage)) {
                //根据农事阶段查询是否有照片资源
                List<StagePicture> allPicture
                        = stagePictureMapper.getAllPicture(allStage);
                if (ConverterUtil.isNotEmpty(allPicture)) {
                    //删除所有的农事阶段照片资源
                    stagePictureMapper.deleteAllStage(allStage);
                }
                //删除原有所有农事阶段数据
                farmingStageMapper.deleteAll(allCycle);
            }
            //删除所有的农事周期
            farmingCycleMapper.deleteAllCycle(plantingMethodOneDeletePo.getId());
        }
        //删除所有的种植方法
        int flag = plantingMethodMapper.deleteAllPlatMethod(plantingMethodOneDeletePo.getId());
        result.setResult(flag);
        return result;

    }

    /**
     * 查询是否有关联标准的种植方法
     */
    public List<PlantingMethodListVo> findPlantStandardMageId(PlantingMethodListPo plantingMethodListPo) {
        List<PlantingMethodListVo> plantStandardMageIdList = plantingMethodMapper.findPlantStandardMageId(plantingMethodListPo);
        return plantStandardMageIdList;
    }
}
