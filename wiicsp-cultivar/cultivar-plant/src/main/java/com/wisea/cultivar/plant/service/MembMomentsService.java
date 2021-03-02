package com.wisea.cultivar.plant.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.MembMoments;
import com.wisea.cultivar.plant.entity.MembMomentsPicture;
import com.wisea.cultivar.plant.mapper.MembMomentsMapper;
import com.wisea.cultivar.plant.mapper.MembMomentsPictureMapper;
import com.wisea.cultivar.plant.po.MembMomentsPageListPo;
import com.wisea.cultivar.plant.po.MembMomentsPo;
import com.wisea.cultivar.plant.vo.MembMomentsInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className MembMomentsService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class MembMomentsService extends BaseService {
    @Autowired
    private MembMomentsMapper mapper;
    @Autowired
    private MembMomentsPictureMapper membMomentsPictureMapper;

    /**
     * 油茶圈列表
     * 展示自己和关注会员发布的圈子
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<MembMomentsInfoVo>> findAllMembMoments(MembMomentsPageListPo po) {
        LoggerUtil.infoWithContext("【findAllMembMoments】油茶圈列表：", po);
        ResultPoJo<List<MembMomentsInfoVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        po.setPage(null);
        List<MembMomentsInfoVo> list = mapper.findAllMembMoments(po);
        resultPoJo.setResult(list);
        return resultPoJo;

    }

    /**
     * 新增我的圈子
     *
     * @param po
     * @return
     */
    public ResultPoJo addMembMoment(MembMomentsPo po) {
        LoggerUtil.infoWithContext("【addMembMoment】新增我的圈子：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        // check:本页信息提交时，文字、图片（视频）必须一项有值才能发布成功
        if (ConverterUtil.isEmpty(po.getContent()) && ConverterUtil.isEmpty(po.getMembMomentsPictureList())) {
            resultPoJo.setCode("70021");
            resultPoJo.setMsg("文字、图片（视频）必须一项有值");
            return resultPoJo;
        }
        //新增
        MembMoments entity = new MembMoments();
        BeanUtils.copyProperties(po, entity);
        entity.setPubDate(OffsetDateTime.now());
        entity.preInsert();
        mapper.insert(entity);

        // 图片/视频信息
        for (MembMomentsPicture membMomentsPicture : po.getMembMomentsPictureList()) {
            membMomentsPicture.setMembMomentsId(entity.getId());
            membMomentsPicture.preInsert();
            membMomentsPictureMapper.insert(membMomentsPicture);
        }

        return resultPoJo;
    }

    /**
     * 圈子个人主页(不分页)
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<MembMomentsInfoVo>> findOwnPage(MembMomentsPageListPo po) {
        LoggerUtil.infoWithContext("【findOwnPage】圈子个人/客户主页(不分页)：", po);
        ResultPoJo<List<MembMomentsInfoVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        po.setPage(null);
        List<MembMomentsInfoVo> list = mapper.findOwnPageInfo(po);
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    /**
     * 油茶圈搜索
     * 展示自己和关注会员发布的圈子
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<MembMomentsInfoVo>> search(MembMomentsPageListPo po) {
        LoggerUtil.infoWithContext("【search】油茶圈搜索：", po);
        ResultPoJo<List<MembMomentsInfoVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        // check:内容关键字必须
        if (ConverterUtil.isEmpty(po.getContent())) {
            resultPoJo.setCode("70022");
            resultPoJo.setMsg("搜索关键字[content]必须");
            return resultPoJo;
        }
        po.setPage(null);
        List<MembMomentsInfoVo> list = mapper.searchMembMoments(po);
        resultPoJo.setResult(list);
        return resultPoJo;

    }


    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembMoments
     */
//    public ResultPoJo<Page<MembMomentsPageListVo>> findPageList(MembMomentsPageListPo po) {
//        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
//        ResultPoJo<Page<MembMomentsPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
//        Page<MembMomentsPageListVo> page = po.getPage();
//        List<MembMomentsPageListVo> list = mapper.findPageList(po);
//        page.setList(list);
//        resultPoJo.setResult(page);
//        return resultPoJo;
//    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除MembMoments
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        MembMoments entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(MembMoments.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 新增或修改MembMoments
     */
//    public ResultPoJo saveOrUpdate(MembMomentsPo po) {
//        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
//        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
//        if (ConverterUtil.isNotEmpty(po.getId())) {
//            //修改
//            MembMoments entity = mapper.selectByPrimaryKey(po.getId());
//            if (ConverterUtil.isNotEmpty(entity)) {
//                BeanUtils.copyProperties(po, entity);
//                entity.preUpdate();
//                mapper.updateByPrimaryKeySelective(entity);
//            } else {
//                resultPoJo.setCode(ConstantError.ERR_004);
//                resultPoJo.setMsg(ConstantError.MSG_004);
//            }
//        } else {
//            //新增
//            MembMoments entity = new MembMoments();
//            BeanUtils.copyProperties(po, entity);
//            entity.preInsert();
//            mapper.insert(entity);
//        }
//        return resultPoJo;
//    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 查询详细信息MembMoments
     */
//    public ResultPoJo<MembMomentsInfoVo> findInfo(LongIdPo po) {
//        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
//        ResultPoJo<MembMomentsInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
//        MembMomentsInfoVo vo = mapper.findInfo(po);
//        if (ConverterUtil.isNotEmpty(vo)) {
//            resultPoJo.setResult(vo);
//        } else {
//            resultPoJo.setCode(ConstantError.ERR_004);
//            resultPoJo.setMsg(ConstantError.MSG_004);
//        }
//        return resultPoJo;
//    }
}
