package com.wisea.transac.tp.system.service;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.dao.LateFeePropMageMapper;
import com.wisea.transac.common.entity.LateFeePropMage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jirg
 * @version 1.0
 * @className LateFeeMageService
 * @date 2019/8/21 11:35
 * @Description 账期滞纳金设置Service
 */
@Service
public class LateFeePropMageService extends BaseService {
    @Autowired
    private LateFeePropMageMapper mapper;
    @Autowired
    private JedisDao jedisDao;

    //滞纳金缓存key
    public static final String LATE_FEE_MAGE_KEY = "LATE_FEE_MAGE";

    /**
     * @Author jirg
     * @Date 2019/8/21 14:58
     * @Description 获取滞纳金设置
     **/
    public ResultPoJo<LateFeePropMage> getLateFeeMage() {
        ResultPoJo<LateFeePropMage> result = new ResultPoJo<LateFeePropMage>(ConstantError.NOMAL);
        LateFeePropMage lateFeeMage = jedisDao.getSerialize(LATE_FEE_MAGE_KEY, LateFeePropMage.class);
        if(ConverterUtil.isEmpty(lateFeeMage)){
            lateFeeMage = mapper.getLateFeeMage();
            if(ConverterUtil.isNotEmpty(lateFeeMage)){
                jedisDao.setSerialize(LATE_FEE_MAGE_KEY, lateFeeMage);
            }
        }
        result.setResult(lateFeeMage);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/8/21 15:34
     * @Description 设置滞纳金比例
     **/
    public ResultPoJo<?> saveOrUpdate(LateFeePropMage po) {
        ResultPoJo<LateFeePropMage> result = new ResultPoJo<LateFeePropMage>(ConstantError.NOMAL);
        LateFeePropMage lateFeeMage = mapper.getLateFeeMage();
        if (ConverterUtil.isNotEmpty(lateFeeMage)){
            //逻辑删除旧的滞纳金设置
            lateFeeMage.setDelFlag(LateFeePropMage.DEL_FLAG_DELETE);
            mapper.updateByPrimaryKeySelective(lateFeeMage);
        }
        po.preInsert();
        mapper.insert(po);
        jedisDao.delSerialize(LATE_FEE_MAGE_KEY);
        return result;
    }
}
