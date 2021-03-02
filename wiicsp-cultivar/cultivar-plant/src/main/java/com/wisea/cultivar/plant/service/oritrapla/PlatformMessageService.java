package com.wisea.cultivar.plant.service.oritrapla;

/**
 * @Description: 平台消息业务层
 * @author: wangs
 * @date :2018/6/5
 */
/*@Service
@Transactional(readOnly = true)
public class PlatformMessageService {

    @Autowired
    InformationMapper informationMapper;
    @Autowired
    ArchManageService archManageService;

    *//**
     * 平台消息列表
     *
     * @param information
     * @return
     *//*
    public ResultPoJo<List<Information>> platformMessageList(Information information) {

        ResultPoJo<List<Information>> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        User user = SystemUtils.getUser();
        information.setMembId(user.getId());

        // 查询消息列表
        List<Information> list = null;
        try {
            list = informationMapper.findList(information);
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_310);
            poJo.setMsg(ConstantCodeMsg.MSG_310);
        }

        poJo.setResult(list);
        return poJo;
    }

    *//**
     * 根据会员id查询未读消息的总数
     *
     * @param
     * @return
     *//*
    public ResultPoJo<Object> platformMessageSum(Information information) {

        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        User user = SystemUtils.getUser();
        information.setMembId(user.getId());

        int count = informationMapper.platformMessageSum(information.getMembId());

        poJo.setResult(count);

        return poJo;
    }

    *//**
     * 将平台消息设置为已读
     *
     * @param information
     * @return
     *//*
    @Transactional(readOnly = false)
    public ResultPoJo<Object> platformMessageChangeRead(Information information) {

        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        User user = SystemUtils.getUser();
        information.setMembId(user.getId());

        // 设置为未读标志
        information.setReadFlag(DictConstants.READ_FLAG_0);
        // 查询所有未读消息
        List<Information> list = informationMapper.findList(information);

        if (ConverterUtil.isNotEmpty(list)) {
            List<Information> guidaList = Lists.newArrayList();
            list.forEach(e -> {
                Information guidaInfoMage = new Information();
                guidaInfoMage.setId(e.getId());
                guidaInfoMage.setReadFlag(DictConstants.READ_FLAG_1);
                guidaList.add(guidaInfoMage);
            });
            informationMapper.batchUpdate(guidaList);
        }
        return poJo;
    }

    *//**
     * 查看消息详情
     *
     * @param informationPo
     * @return
     *//*
    @Transactional(readOnly = false)
    public ResultPoJo<Object> platformMessageDeatail(InformationPo informationPo) {

        ResultPoJo<Object> poJo = new ResultPoJo<>(ConstantError.NOMAL);
        // 根据消息id将本条消息设置为已读
        Information information = informationMapper.selectByPrimaryKey(informationPo.getInformationId());
        if (information.getReadFlag().equals(DictConstants.READ_FLAG_0)) {

            information.setReadFlag(DictConstants.READ_FLAG_1);
            informationMapper.updateByPrimaryKey(information);
        }
        MineArchInfoVo mineArchInfoVo = null;
        try {
            mineArchInfoVo = archManageService.mineArckInfo(informationPo.getMineArchId());

        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_314);
            poJo.setMsg(ConstantCodeMsg.MSG_314);
        }

        poJo.setResult(mineArchInfoVo);

        return poJo;
    }
}*/
