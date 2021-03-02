package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNotice;
import com.wisea.cultivar.plant.entity.oritrapla.PlatfNoticeVo;
import com.wisea.cultivar.plant.mapper.oritrapla.PlatfNoticeMapper;
import com.wisea.cultivar.plant.po.oritrapla.AddPlatfNotiPo;
import com.wisea.cultivar.plant.po.oritrapla.PlatfNoticPo;
import com.wisea.cultivar.plant.po.oritrapla.PlatfNoticePo;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 平台公告业务层
 * @author: wangs
 * @date :2018/6/5
 * TODO 保留
 */
@Service
@Transactional(readOnly = true)
public class SystemBulletinService {


    @Autowired
    PlatfNoticeMapper platfNoticeMapper;

    /**
     * 公告列表信息
     *
     * @param platfNotice
     * @return
     */
    public ResultPoJo<List<PlatfNotice>> systemBulletinList(PlatfNotice platfNotice) {

        ResultPoJo<List<PlatfNotice>> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        // 查询公告列表
        List<PlatfNotice> list = null;
            list = platfNoticeMapper.findList(platfNotice);
        try {
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_210);
            poJo.setMsg(ConstantCodeMsg.MSG_210);
        }

        poJo.setResult(list);
        return poJo;
    }

    /**
     * 查询平台公告详情
     *
     * @param platfNoticePo
     * @return
     */
    public ResultPoJo<PlatfNotice> systemBulletinDeatail(PlatfNoticePo platfNoticePo) {

        ResultPoJo<PlatfNotice> poJo = new ResultPoJo<>(ConstantError.NOMAL);

        PlatfNotice platfnotice = null;
        try {
            platfnotice = platfNoticeMapper.selectByPrimaryKey(platfNoticePo.getId());
        } catch (Exception e) {
            poJo.setMsg(ConstantCodeMsg.MSG_211);
            poJo.setCode(ConstantCodeMsg.ERR_211);
        }

        poJo.setResult(platfnotice);

        return poJo;
    }

    /**
     * 分页查询平台公告列表
     *
     * @param platfNoticPo
     * @return
     */
    public ResultPoJo<Page<PlatfNoticeVo>> systemBulletinFindListPage(PlatfNoticPo platfNoticPo) {

        ResultPoJo poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        Page<PlatfNoticeVo> page = platfNoticPo.getPage();

        PlatfNotice platfnotice = new PlatfNotice();

        platfNoticPo.setReleDateStart(OffsetDateTimeUtils.getDayMinTime(platfNoticPo.getReleDateStart()));
        platfNoticPo.setReleDateEnd(OffsetDateTimeUtils.getDayMaxTime(platfNoticPo.getReleDateEnd()));

        ConverterUtil.copyProperties(platfNoticPo, platfnotice);
        // 查询公告列表
        List<PlatfNoticeVo> list = null;
        try {
            list = platfNoticeMapper.findListPage(platfnotice);
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_210);
            poJo.setMsg(ConstantCodeMsg.MSG_210);
        }
        page.setList(list);
        poJo.setResult(page);

        return poJo;
    }

    /**
     * 新增公告信息
     *
     * @param addplatfNotiPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> systemBulletinAdd(AddPlatfNotiPo addplatfNotiPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        PlatfNotice platfnotice = new PlatfNotice();

        ConverterUtil.copyProperties(addplatfNotiPo, platfnotice);

        platfnotice.preInsert();
        platfnotice.preUpdate();

        // 将公告信息保存到数据库
        int i = 0;
        try {
            i = platfNoticeMapper.insert(platfnotice);
        } catch (Exception e) {
            poJo.setCode(ConstantCodeMsg.ERR_212);
            poJo.setMsg(ConstantCodeMsg.MSG_212);
        }

        return poJo;
    }

    /**
     * 修改平台公告
     *
     * @param addplatfNotiPo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> systemBulletinUpdate(AddPlatfNotiPo addplatfNotiPo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        PlatfNotice notice = platfNoticeMapper.selectByPrimaryKey(addplatfNotiPo.getId());
        // 排他校验
        if (!addplatfNotiPo.getUpdateDate().equals(notice.getUpdateDate())) {
            poJo.setCode(ConstantError.ERR_009);
            poJo.setMsg(ConstantError.MSG_009);
            return poJo;
        }

        PlatfNotice platfnotice = new PlatfNotice();

        ConverterUtil.copyProperties(addplatfNotiPo, platfnotice);

        platfNoticeMapper.updateByPrimaryKeySelective(platfnotice);

        return poJo;
    }

    /**
     * 删除平台公告信息
     *
     * @param platfNoticePo
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<String> systemBulletinDelete(PlatfNoticePo platfNoticePo) {

        ResultPoJo<String> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        PlatfNotice platfnotice = new PlatfNotice();
        platfnotice.setId(platfNoticePo.getId());
        platfnotice.setDelFlag("1");
        platfnotice.preUpdate();

        platfNoticeMapper.updateByPrimaryKeySelective(platfnotice);
        return poJo;
    }

}
