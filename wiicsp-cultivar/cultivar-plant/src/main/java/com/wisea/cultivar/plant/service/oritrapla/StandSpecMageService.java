package com.wisea.cultivar.plant.service.oritrapla;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019-05-27 14:18
 */
/*@Service
public class StandSpecMageService extends BaseService {

    private final static Logger log = LoggerFactory.getLogger(StandSpecMageService.class);

    @Autowired
    private StandardSpecificationMapper ssMapper;
    @Autowired
    private StandardInfoMapper siMapper;
    @Autowired
    CommMageMapper commMageMapper;


    *//**
     * 按条件查询所有标准
     * @param po
     * @return
     *//*
    public ResultPoJo<List<StandardSpecificationListVo>> findForOptions(StandardSpecificationOptionPo po) {
        List<StandardSpecificationListVo> options = ssMapper.findForOptions(po);
        ResultPoJo<List<StandardSpecificationListVo>> poJo = new ResultPoJo<>();
        if (options.size() > 0) {
            poJo.setResult(options);
        }
        return poJo;

    }

    *//**
     * 按ID查询标准记录
     *
     * @param id
     * @return
     *//*
    public ResultPoJo<StandardSpecificationListVo> findById(Long id) {
        ResultPoJo<StandardSpecificationListVo> poJo = new ResultPoJo<>();
        StandardSpecification entity = ssMapper.selectByPrimaryKey(id);
        if (entity == null) {
            poJo.setCode("999");
            poJo.setMsg("无此数据");
            return poJo;
        }
        StandardSpecificationListVo vo = new StandardSpecificationListVo();
        ConverterUtil.copyProperties(entity, vo);

        CommMage commMage = commMageMapper.selectByPrimaryKey(entity.getCommId());
        CommMage level2Comm = commMageMapper.selectByPrimaryKey(commMage.getPid());
        vo.setCommLevel2Id(level2Comm.getId());
        vo.setCommLevel1Id(level2Comm.getPid());
        //查询标准详情
        List<StandardInfoListVo> list = siMapper.findListBySSId(id);
        vo.setDetails(list);


        poJo.setResult(vo);
        return poJo;

    }

    *//**
     * 分页查询
     *
     * @param po
     * @return
     *//*
    public ResultPoJo<Page<StandardSpecificationListVo>> findForPages(StandardSpecificationPagePo po) {
        if (po.getStartDate() != null && po.getEndDate() != null) {
            if (po.getStartDate().isAfter(po.getEndDate())) {
                OffsetDateTime endDate = po.getStartDate();
                po.setStartDate(po.getEndDate());
                po.setEndDate(endDate);
            }
        }
        ResultPoJo<Page<StandardSpecificationListVo>> poJo = new ResultPoJo<>();
        List<StandardSpecificationListVo> list = ssMapper.findForPages(po);
        list.forEach(ss->{
            String names = CommUtils.getCommMageNames(ss.getCommId());
            ss.setCommName(names);
        });
        Page<StandardSpecificationListVo> page = po.getPage();
        page.setList(list);
        poJo.setResult(page);
        return poJo;

    }

    *//**
     * 插入一条标准
     *
     * @param po
     * @return
     *//*
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo addOne(StandardSpecificationInsertPo po) {

        StandardSpecification entity = new StandardSpecification();
        ConverterUtil.copyProperties(po, entity);
        entity.preInsert();

        ssMapper.insertSelective(entity);
        //插入标准详情
        insertStandardDetails(entity, po.getStandardDetails());

        return new ResultPoJo();
    }

    *//**
     * 修改一条标准
     *
     * @param po
     * @return
     *//*
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo updateOne(StandardSpecificationUpdatePo po) {

        StandardSpecification entity = new StandardSpecification();
        ConverterUtil.copyProperties(po, entity);
        entity.preUpdate();

        ssMapper.updateByPrimaryKeySelective(entity);

        //逻辑删除所有原来的详情记录
        StandardInfo deleteRecords = new StandardInfo();
        deleteRecords.setStandardSpecificationId(po.getId());
        deleteRecords.preUpdate();
        siMapper.deleteBySSId(deleteRecords);
        //插入标准详情
        insertStandardDetails(entity, po.getStandardDetails());

        return new ResultPoJo();
    }

    *//**
     * 插入StandardInfo
     *
     * @param entity
     * @param standardDetails
     *//*
    private void insertStandardDetails(StandardSpecification entity, List<StandardInfoInsertPo> standardDetails) {
        List<StandardInfoInsertPo> details = standardDetails;
        details.forEach(d -> {
            StandardInfo info = new StandardInfo();
            ConverterUtil.copyProperties(d, info);
            info.setStandardSpecificationId(entity.getId());
            info.preInsert();
            siMapper.insertSelective(info);
        });
    }

    *//**
     * 删除
     *
     * @param po
     * @return
     *//*
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo deleteByIds(StandardSpecificationBatDeletePo po) {
        po.getDelList().forEach(o -> {
            StandardSpecification ss = new StandardSpecification();
            ss.setId(o);
            ss.preUpdate();
            ssMapper.deleteLogic(ss);
        });

        //逻辑删除所有原来的详情记录
        po.getDelList().forEach(o -> {
            StandardInfo deleteRecords = new StandardInfo();
            deleteRecords.setStandardSpecificationId(o);
            deleteRecords.preUpdate();
            siMapper.deleteBySSId(deleteRecords);
        });
        return new ResultPoJo();
    }
}*/
