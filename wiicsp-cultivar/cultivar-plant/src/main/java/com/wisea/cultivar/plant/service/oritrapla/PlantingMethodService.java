package com.wisea.cultivar.plant.service.oritrapla;


/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2019-05-27 14:07
 * @Description:种植方法Service
 */
/*
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PlantingMethodService {

    @Autowired
    private PlantingMethodMapper plantingMethodMapper;
    @Autowired
    private FarmingCycleMapper farmingCycleMapper;
    @Autowired
    private FarmingStageMapper farmingStageMapper;
    @Autowired
    private StagePictureMapper stagePictureMapper;
    @Autowired
    private ArchBasicInfoMapper archBasicInfoMapper;
    @Autowired
    private FarmWorkTypeDictMapper farmWorkTypeDictMapper;

    */
/**
     * 种植方法列表管理
     *
     * @param po
     *//*

    public ResultPoJo<Page<PlantingMethodListVo>> plantMethodList(PlantingMethodPagePo po) {
        ResultPoJo<Page<PlantingMethodListVo>> poJo = new ResultPoJo<>();

        //请求数据
        List<PlantingMethodListVo> plantingMethodListVos =
                plantingMethodMapper.plantMethodList(po);

        //处理数据
        plantingMethodListVos.stream()
                .forEach(x -> {
                    x.setCommCatgName(commMageHandle(x.getCommId()).toString());
                    StringBuffer commName = new StringBuffer();
                    String[] split = x.getCommCatgName().split("-");
                    commName.append(split[split.length - 1]);
                    switch (x.getPlantType()) {
                        case "0":
                            x.setPlantTypeValue("无公害");
                            break;
                        case "1":
                            x.setPlantTypeValue("有机");
                            break;
                        case "2":
                            x.setPlantTypeValue("绿色");
                            break;
                        case "3":
                            x.setPlantTypeValue("其它");
                            break;
                        default:
                    }
                    x.setPlantingMethod(x.getPlantTypeValue() + commName + x.getMassifType() + "种植");
                });

        Page<PlantingMethodListVo> page = po.getPage();
        page.setList(plantingMethodListVos);
        poJo.setResult(page);
        return poJo;
    }

    */
/**
     * 删除种植方法数据
     *
     * @param po
     *//*

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo<ConstantCodeMsg> delPlantMethod(PlantingMethodGetPo po) {

        //查询该种植方法下的所有种植周期
        List<FarmingCycle> allCycle =
                farmingCycleMapper.getAllCycle(po.getId());

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
            farmingCycleMapper.deleteAllCycle(po.getId());
        }
        //删除所有的种植方法
        int flag = plantingMethodMapper.deleteAllPlatMethod(po.getId());
        return ErrCodeMsgUtil.resultCodeMsg(flag);
    }

    */
/**
     * 编辑种植方法
     *//*

    public ResultPoJo<PlantingMethodEditVo> editPlantMethod(PlantingMethodGetPo po) {
        ResultPoJo<PlantingMethodEditVo> poJo = new ResultPoJo<>();

        //数据装载模型
        PlantingMethodEditVo editVo = new PlantingMethodEditVo();
        //处理表格数据
        List<PlantingMethodTableVo> tables = new ArrayList();

        //请求数据_种植方法
        PlantingMethod plantingMethod = plantingMethodMapper.selectByPrimaryKey(po.getId());
        //获取商品树中的当前级
        CommMageTreeVo node = TreeUtils.findNode(CacheUtil.getCommMageTree(), true, (e) -> {
            if (plantingMethod.getCommId().equals(e.getId())) {
                return e;
            } else {
                return null;
            }
        });
        plantingMethod.setCommLevel2Id(node.getParent().getId());
        plantingMethod.setCommLevel1Id(node.getParent().getParent().getId());
        //请求数据_农事周期
        List<FarmingCycle> allCycle =
                farmingCycleMapper.getAllCycle(po.getId());
        if (ConverterUtil.isNotEmpty(allCycle)) {
            List<FarmingCycle> collectCycle = allCycle.stream()
                    .sorted(Comparator.comparing(FarmingCycle::getStartDays)).collect(Collectors.toList());
            editVo.setFarmingCycle(collectCycle);
            collectCycle.stream().forEach(x -> {
                //根据农事周期id去查询农事阶段
                List<FarmingStage> stageByCycleId =
                        farmingStageMapper.getStageByCycleId(x.getId());
                if (ConverterUtil.isNotEmpty(stageByCycleId)) {
                    List<FarmingStage> collectStage = stageByCycleId.stream()
                            .sorted(Comparator.comparing(FarmingStage::getStartDays)).collect(Collectors.toList());
                    for (FarmingStage vo : collectStage) {
                        //根据农事阶段id去查询农事阶段图片资源
                        List<StagePicture> pictByStageId =
                                stagePictureMapper.getPictByStageId(vo.getId());
                        if (ConverterUtil.isNotEmpty(pictByStageId)) {
                            vo.setStagePicture(pictByStageId);
                        }
                        if (ConverterUtil.isNotEmpty(vo.getFarmWorkTypeId())) {
                            //处理农事类型
                            FarmWorkTypeDict farmWorkTypeDict =
                                    farmWorkTypeDictMapper.selectByPrimaryKey(vo.getFarmWorkTypeId());
                            //如果上级id不为空
                            if (ConverterUtil.isNotEmpty(farmWorkTypeDict.getParentId())) {
                                Long[] longs = new Long[]{farmWorkTypeDict.getParentId(), vo.getFarmWorkTypeId()};
                                vo.setFarmWorkTypeIds(longs);
                            } else {
                                //如果上级id为空
                                Long[] longs = new Long[]{null, vo.getFarmWorkTypeId()};
                                vo.setFarmWorkTypeIds(longs);
                            }
                            vo.setFarmWorkTypeName(farmWorkTypeDict.getName());
                        }
                    }
                    x.setFarmingStage(collectStage);
                    //处理表格
                    PlantingMethodTableVo plantingMethodTableVo = new PlantingMethodTableVo();
                    plantingMethodTableVo.setTime(x.getEndDays() - x.getStartDays() + 1);
                    plantingMethodTableVo.setCycleName(x.getCycleName());
                    tables.add(plantingMethodTableVo);
                    editVo.setTables(tables);
                } else {
                    x.setFarmingStage(new ArrayList<>());
                }
            });
        }
        //装载数据
        editVo.setPlantingMethod(plantingMethod);

        poJo.setResult(editVo);
        return poJo;
    }

    */
/**
     * 增加和修改种植方法
     *//*

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo addAndMondify(InsertPlantingMethodPo po) {
        ResultPoJo<ConstantCodeMsg> poJo = new ResultPoJo();
        //判断请求的方式
        try {
            //如果是修改状态的话
            if (("1").equals(po.getRequestType())) {
                //查询种植方法关联的所有农事周期
                List<FarmingCycle> allCycle =
                        farmingCycleMapper.getAllCycle(po.getPlantingMethod().getId());
                if (ConverterUtil.isNotEmpty(allCycle)) {
                    //根据农事周期查询到所有农事阶段的id
                    List<FarmingStage> allStage =
                            farmingStageMapper.getAllStage(allCycle);
                    if (ConverterUtil.isNotEmpty(allStage)) {
                        //查询所有农事阶段关联的照片资源
                        List<StagePicture> allPicture
                                = stagePictureMapper.getAllPicture(allStage);
                        if (ConverterUtil.isNotEmpty(allPicture)) {
                            //删除所有农事阶段关联的照片资源
                            stagePictureMapper.deleteAllStage(allStage);
                        }
                        //删除原有所有农事阶段数据
                        farmingStageMapper.deleteAll(allCycle);
                    }
                    //删除所有的农事周期
                    farmingCycleMapper.deleteAllCycle(po.getPlantingMethod().getId());
                }
                //修改种植方法
                po.getPlantingMethod().preUpdate();
                plantingMethodMapper.updateById(po.getPlantingMethod());
            } else if (("0").equals(po.getRequestType())) {
                //首先添加种植方法
                po.getPlantingMethod().preInsert();
                po.getPlantingMethod().setSourceType("0");
                plantingMethodMapper.insertSelective(po.getPlantingMethod());
            }
            //其次循环添加农事周期
            if (ConverterUtil.isNotEmpty(po.getFarmingCycle())) {
                for (FarmingCycle vo : po.getFarmingCycle()) {
                    vo.preInsert();
                    vo.setPlantingMethodId(po.getPlantingMethod().getId());
                    farmingCycleMapper.insertSelective(vo);
                    if (ConverterUtil.isNotEmpty(vo.getFarmingStage())) {
                        //批量插入农事周期ID
                        vo.getFarmingStage().stream().forEach(x -> {
                            x.setFarmingCycleId(vo.getId());
                            x.preInsert();
                        });
                        //将农事阶段循环添加到表中并且处理农事类型
                        for (FarmingStage typeIds : vo.getFarmingStage()) {
                            if (ConverterUtil.isNotEmpty(typeIds.getFarmWorkTypeIds())) {
                            	if (typeIds.getCycleInterval() != null && !Pattern.compile("^-?[1-9]\\d*$").matcher(typeIds.getCycleInterval()).find()) {
                            		poJo.setCode(ConstantCodeMsg.ERR_005);
                            		poJo.setMsg("周期必须为正整数！");
                            		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动回滚
                            		return poJo;
                            	}
                                typeIds.setFarmWorkTypeId(typeIds.getFarmWorkTypeIds()[1]);
                            }
                        }
                        farmingStageMapper.batchInsert(vo.getFarmingStage());
                        for (FarmingStage picture : vo.getFarmingStage()) {
                            if (ConverterUtil.isNotEmpty(picture.getStagePicture())) {
                                picture.getStagePicture().stream().forEach(x -> {
                                    x.setFarmingStageId(picture.getId());
                                    x.preInsert();
                                });
                                //批量添加图片资源
                                stagePictureMapper.batchInsert(picture.getStagePicture());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_999);
            poJo.setMsg(ConstantCodeMsg.MSG_999);
            return poJo;
        }
        poJo.setCode(ConstantCodeMsg.ERR_000);
        poJo.setMsg(ConstantCodeMsg.MSG_000);
        return poJo;
    }

    */
/**
     * 关联种植档案
     *//*

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResultPoJo relevanceArch(ArchBasicInfo po) {
        po.preUpdate();
        int i = archBasicInfoMapper.updateByPrimaryKey(po);
        return ErrCodeMsgUtil.resultCodeMsg(i);
    }

    */
/**
     * 处理商品品类拼接
     *
     * @param commId 当前的商品id
     *//*

    public StringBuffer commMageHandle(Long commId) {

        //创建数据模型
        StringBuffer buffer = new StringBuffer();

        //获取商品树中的当前级
        CommMageTreeVo node = TreeUtils.findNode(CacheUtil.getCommMageTree(), true, (e) -> {
            if (commId.equals(e.getId())) {
                return e;
            } else {
                return null;
            }
        });

        //如果当前级别没有上级
        if (ConverterUtil.isEmpty(node.getPid())) {
            return buffer.append(node.getName());
        }

        //如果存在上级就去递归的调用
        buffer.append("-" + node.getName());
        CommMageTreeVo parent;
        while (true) {
            parent = node.getParent();
            if (ConverterUtil.isNotEmpty(parent)) {
                buffer.insert(0, "-" + parent.getName());
                node = parent;
            } else {
                break;
            }
        }
        buffer.deleteCharAt(0);
        return buffer;
    }
}*/
