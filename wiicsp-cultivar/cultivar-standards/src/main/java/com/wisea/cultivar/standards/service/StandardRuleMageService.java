package com.wisea.cultivar.standards.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.standards.entity.*;
import com.wisea.cultivar.standards.mapper.*;
import com.wisea.cultivar.standards.po.*;
import com.wisea.cultivar.standards.vo.StandardMageListVo;
import com.wisea.cultivar.standards.vo.StandardRuleMageGetVo;
import com.wisea.cultivar.standards.vo.StandardRuleMageListVo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * StandardRuleMageService
 * 标准规范管理 Service
 * 2020/07/24 11:21:45
 */
@Service
public class StandardRuleMageService extends BaseService {
    @Autowired
    protected StandardRuleMageMapper standardRuleMageMapper;
    @Autowired
    protected StandardRuleFileMageMapper standardRuleFileMageMapper;
    @Autowired
    protected StandardTypeMageMapper standardTypeMageMapper;
    @Autowired
    protected IcsClassMageMapper icsClassMageMapper;
    @Autowired
    protected ChinaStandardTypeMageMapper chinaStandardTypeMageMapper;

    @Autowired
    protected StandardMageMapper standardMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Page<StandardRuleMageListVo>> findPage(StandardRuleMagePagePo standardRuleMagePagePo) {
        ResultPoJo<Page<StandardRuleMageListVo>> result = new ResultPoJo<>();
        Page<StandardRuleMageListVo> page = standardRuleMagePagePo.getPage();
        List<StandardRuleMageListVo> list = standardRuleMageMapper.findPage(standardRuleMagePagePo);
        page.setList(list);
        result.setResult(page);
        return result;
    }

    /**
     * 查询列表
     */
    public ResultPoJo<List<StandardRuleMageListVo>> findList(StandardRuleMageListPo standardRuleMageListPo) {
        ResultPoJo<List<StandardRuleMageListVo>> result = new ResultPoJo<>();
        List<StandardRuleMageListVo> list = standardRuleMageMapper.findList(standardRuleMageListPo);

        List<StandardRuleMageListVo> listad=new ArrayList<>();
        // StandardTypeMage datag = standardTypeMageMapper.getByName("国家标准");
        //国家标准id
        Long gjId = 2L;
        //StandardTypeMage datad = standardTypeMageMapper.getByName("地方标准");
        //地方标准id
        Long dfId = 3L;
        //StandardTypeMage datah = standardTypeMageMapper.getByName("行业标准");
        //行业标准id
        Long hyId = 4L;

        Integer i=0;   //序号
        double gjcount=0;
        double dfcount=0;
        double hycount=0;
        double size=list.size();
        for (StandardRuleMageListVo standardRuleMageListVo : list) {
            ++i;
            //序号
            standardRuleMageListVo.setNumber(i);
            //标准类型名称
            Long id = standardRuleMageListVo.getStandardTypeMageId();
            StandardTypeMage entity1 = standardTypeMageMapper.selectByPrimaryKey(id);
            Long pid = entity1.getPid();
            StandardTypeMage entity2 = standardTypeMageMapper.selectByPrimaryKey(pid);
            standardRuleMageListVo.setStandardTypeMageIdName(entity2.getStandardTypeName());
            if (gjId.equals(entity2.getId())){
                gjcount++;
            }else if (dfId.equals(entity2.getId())){
                dfcount++;
            }else if (hyId.equals(entity2.getId())){
                hycount++;
            }

            if (ConverterUtil.isNotEmpty(standardRuleMageListVo.getId())){
                standardRuleMageListVo.setStandardRuleFileMageInsertPos(standardRuleFileMageMapper.getById(standardRuleMageListVo.getId()));
            }

            listad.add(standardRuleMageListVo);
        }
        double gj=gjcount/size;
        double df=dfcount/size;
        double hy=hycount/size;
        double qt=(size-gjcount-dfcount-hycount)/size;
        String gjStr= String .format("%.2f",gj);
        String dfStr= String .format("%.2f",df);
        String hyStr= String .format("%.2f",hy);
        String qtStr= String .format("%.2f",qt);
        StandardRuleMageListVo  date= new StandardRuleMageListVo();
        date.setCount(size);
        date.setGbcount(gjStr);
        date.setDbcount(dfStr);
        date.setHbcount(hyStr);
        date.setQtcount(qtStr);
        listad.add(date);
        result.setResult(listad);
        return result;
    }

    /**
     * 查询
     */
    public ResultPoJo<StandardRuleMageGetVo> get(StandardRuleMageGetPo standardRuleMageGetPo) {
        ResultPoJo<StandardRuleMageGetVo> result = new ResultPoJo<>();
        StandardRuleMage entity = standardRuleMageMapper.selectByPrimaryKey(standardRuleMageGetPo.getId());
         if (ConverterUtil.isNotEmpty(entity.getIcsClassMageId())){
             IcsClassMage icsClassMage = icsClassMageMapper.selectByPrimaryKey(entity.getIcsClassMageId());
             entity.setIcsClassMageIdName(icsClassMage.getIcsClassName());
         }
         if (ConverterUtil.isNotEmpty(entity.getChinaStandardTypeMageId())){
             ChinaStandardTypeMage chinaStandardTypeMage = chinaStandardTypeMageMapper.selectByPrimaryKey(entity.getChinaStandardTypeMageId());
            entity.setChinaStandardTypeMageIdName(chinaStandardTypeMage.getStandardTypeName());
         }

       /* String remarks = entity.getRemarks();
        String[] split = remarks.split(";");
            String v1 = split[0];
            String v2 = split[1];
            String v3 = split[2];
            String v4 = split[3];
        HashMap<String, Object> map = new HashMap<>();
        map.put("k1",v1);
        map.put("k2",v2);
        map.put("k3",v3);
        map.put("k4",v4);*/
        StandardRuleMageGetVo vo = new StandardRuleMageGetVo();
        ConverterUtil.copyProperties(entity, vo);
      //  vo.setMap(map);
        if (ConverterUtil.isNotEmpty(entity)){
            Long id = entity.getId();
            vo.setStandardRuleFileMageInsertPos(standardRuleFileMageMapper.getById(id));
        }
        result.setResult(vo);
        return result;
    }

    /**
     * 新增
     */
    @Transactional(readOnly = false)
    public  ResultPoJo<Object> insert(StandardRuleMageInsertPo standardRuleMageInsertPo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
     /*   HashMap<String, Object> map = standardRuleMageInsertPo.getMap();
        String k1 = (String)map.get("k1");
        String k2 = (String)map.get("k2");
        String k3 = (String)map.get("k3");
        String k4 = (String)map.get("k4");*/
        StandardRuleMage standardRuleMage = new StandardRuleMage();
        ConverterUtil.copyProperties(standardRuleMageInsertPo, standardRuleMage);
        standardRuleMage.preInsert();
    /*    standardRuleMage.setRemarks(k1+";"+k2+";"+k3+";"+k4);*/
        standardRuleMage.setViews(0);
        standardRuleMageMapper.insert(standardRuleMage);
        Long id = standardRuleMage.getId();
        List<StandardRuleFileMageInsertPo> standardRuleFileMageInsertPos = standardRuleMageInsertPo.getStandardRuleFileMageInsertPos();
        if (ConverterUtil.isNotEmpty(standardRuleFileMageInsertPos)){
        for (StandardRuleFileMageInsertPo ruleFileMageInsertPo : standardRuleFileMageInsertPos) {
            StandardRuleFileMage standardRuleFileMage = new StandardRuleFileMage();
            ConverterUtil.copyProperties(ruleFileMageInsertPo, standardRuleFileMage);
            standardRuleFileMage.preInsert();
            standardRuleFileMage.setStandardRuleMageId(id);
            standardRuleFileMageMapper.insert(standardRuleFileMage);
        }}
        return result;
    }

    /**
     * 修改
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> update(StandardRuleMageUpdatePo standardRuleMageUpdatePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
      /*  HashMap<String, Object> map = standardRuleMageUpdatePo.getMap();
        String k1 = (String)map.get("k1");
        String k2 = (String)map.get("k2");
        String k3 = (String)map.get("k3");
        String k4 = (String)map.get("k4");*/
        StandardRuleMage standardRuleMage = new StandardRuleMage();
        ConverterUtil.copyProperties(standardRuleMageUpdatePo, standardRuleMage);
        standardRuleMage.preUpdate();
      /*  standardRuleMage.setRemarks(k1+";"+k2+";"+k3+";"+k4);*/
        standardRuleMageMapper.updateByPrimaryKeySelective(standardRuleMage);
        standardRuleFileMageMapper.deleteStandardRuleMageId(standardRuleMageUpdatePo.getId());
        List<StandardRuleFileMageInsertPo> standardRuleFileMageInsertPos = standardRuleMageUpdatePo.getStandardRuleFileMageInsertPos();
        if (ConverterUtil.isNotEmpty(standardRuleFileMageInsertPos)){
            for (StandardRuleFileMageInsertPo ruleFileMageInsertPo : standardRuleFileMageInsertPos) {
                StandardRuleFileMage standardRuleFileMage = new StandardRuleFileMage();
                ConverterUtil.copyProperties(ruleFileMageInsertPo, standardRuleFileMage);
                standardRuleFileMage.preInsert();
                standardRuleFileMage.setStandardRuleMageId(standardRuleMageUpdatePo.getId());
                standardRuleFileMageMapper.insert(standardRuleFileMage);
            }}
        return result;
    }

    /**
     * 批量删除
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> batDelete(StandardRuleMageBatDeletePo standardRuleMageBatDeletePo) {
        ResultPoJo<Object> result = new ResultPoJo<>();
        for(Long delId : standardRuleMageBatDeletePo.getDelList()) {
            StandardRuleMage standardRuleMage = new StandardRuleMage();
            standardRuleMage.setId(delId);
            standardRuleMage.preUpdate();
            standardRuleMageMapper.deleteLogic(standardRuleMage);
            standardRuleFileMageMapper.deleteStandardRuleMageId(delId);
        }
        return result;
    }


    public ResultPoJo<List<StandardMageListVo>> queryList(StandardMageListPo standardMageListPo) {
        ResultPoJo<List<StandardMageListVo>> result = new ResultPoJo<>();
            standardMageListPo.setPlantRecoProcessType(null);
            result.setResult(standardMageMapper.findList(standardMageListPo));
            return result;
        }



}
