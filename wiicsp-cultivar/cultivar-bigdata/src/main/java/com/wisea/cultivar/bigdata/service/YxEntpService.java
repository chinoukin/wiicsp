package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.constants.ConstantCodeMsg;
import com.wisea.cultivar.bigdata.mss.ServiceOritraplaMss;
import com.wisea.cultivar.common.dao.bigdata.YxEntpMapper;
import com.wisea.cultivar.common.entity.bigdata.YxEntp;
import com.wisea.cultivar.common.po.bigdata.QiyeAllInfoPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.YxEntpGetPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpInsertPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpListPo;
import com.wisea.cultivar.common.po.bigdata.YxEntpPagePo;
import com.wisea.cultivar.common.po.bigdata.YxEntpUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.QiyeInfoListVo;
import com.wisea.cultivar.common.vo.bigdata.YxEntpGetVo;
import com.wisea.cultivar.common.vo.bigdata.YxEntpListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * YxEntpService
 * 已选企业 Service
 * 2019/12/02 11:02:15
 */
@Service
public class YxEntpService extends BaseService {
    @Autowired
    protected YxEntpMapper yxEntpMapper;
    @Autowired(required = false)
    protected ServiceOritraplaMss mss;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<YxEntpListVo>> findPage(YxEntpPagePo yxEntpPagePo) {
        ResultPoJo<Page<YxEntpListVo>> result = new ResultPoJo<>();
        Page<YxEntpListVo> page = yxEntpPagePo.getPage();
        List<YxEntpListVo> list = yxEntpMapper.findPage(yxEntpPagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表 已选的标识是有产地ID（传产地ID则取所有企业，已选的标记；不传产地ID则默认查询全部企业）
     */
    public ResultPoJo<List<YxEntpListVo>> findList(YxEntpListPo yxEntpListPo) {
        ResultPoJo<List<YxEntpListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<QiyeInfoListVo> qiyeList = Lists.newArrayList();
        List<YxEntpListVo> resultList = Lists.newArrayList();
        //远程查询所有企业
        QiyeAllInfoPo qiyeAllInfoPo = new QiyeAllInfoPo();
        qiyeAllInfoPo.setName(yxEntpListPo.getEntpName());
        qiyeAllInfoPo.setProv(yxEntpListPo.getSzgj());
        ResultPoJo<List<QiyeInfoListVo>> selAllInfo = mss.selAllInfo(qiyeAllInfoPo);

        if (selAllInfo != null && !ConstantCodeMsg.NOMAL.equals(selAllInfo.getCode())) {
            result.setCode(selAllInfo.getCode());
            result.setMsg(selAllInfo.getMsg());
            return result;
        }
        if (selAllInfo.getResult() != null) {
            //有产地ID则查询已选的
            Map<String, String> map = Maps.newHashMap();
            if (yxEntpListPo.getPlaceOriginId() != null) {

                List<YxEntpListVo> yxEntpList = yxEntpMapper.findList(yxEntpListPo);
                map = yxEntpList.stream().collect(Collectors.toMap(YxEntpListVo::getEntpName, YxEntpListVo::getEntpName));
            }
            //获取企业信息
            qiyeList = selAllInfo.getResult();
            //处理所在地区和已
            for (QiyeInfoListVo e : qiyeList) {

                YxEntpListVo vo = new YxEntpListVo();
                vo.setDaSl(e.getDaSl());
                vo.setDkSl(e.getDkSl());
                vo.setEntpName(e.getOrgName());
                vo.setHjjcsbSl(e.getHjjcsbSl());
                vo.setSpsxtSl(e.getSpsxtSl());
                vo.setMembId(e.getMembId());
                vo.setJd(e.getJd());
                vo.setWd(e.getWd());
                if (e.getAddressProvName() != null && e.getAddressCityName() != null) {

                    vo.setSzgj(e.getAddressProvName().concat(e.getAddressCityName()).concat(e.getAddressCouName()));
                }
                if (map.containsKey(e.getOrgName())) {
                    vo.setPlaceOriginId(yxEntpListPo.getPlaceOriginId());
                }
                resultList.add(vo);
            }
        }
        result.setResult(resultList);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<YxEntpGetVo> get(YxEntpGetPo yxEntpGetPo) {
        ResultPoJo<YxEntpGetVo> result = new ResultPoJo<>();
        YxEntp entity = yxEntpMapper.selectByPrimaryKey(yxEntpGetPo.getId());
        YxEntpGetVo vo = new YxEntpGetVo();
        ConverterUtil.copyProperties(entity, vo);
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> insert(YxEntpInsertPo yxEntpInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        YxEntp yxEntp = new YxEntp();
        ConverterUtil.copyProperties(yxEntpInsertPo, yxEntp);
        yxEntp.preInsert();
        yxEntpMapper.insert(yxEntp);
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(YxEntpUpdatePo yxEntpUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        YxEntp yxEntp = new YxEntp();
        ConverterUtil.copyProperties(yxEntpUpdatePo, yxEntp);
        yxEntp.preUpdate();
        yxEntpMapper.updateByPrimaryKeySelective(yxEntp);
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(YxEntpBatDeletePo yxEntpBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : yxEntpBatDeletePo.getDelList()) {
            YxEntp yxEntp = new YxEntp();
            yxEntp.setId(delId);
            yxEntp.preUpdate();
            yxEntpMapper.deleteLogic(yxEntp);
        }
        return result;
    }
}
