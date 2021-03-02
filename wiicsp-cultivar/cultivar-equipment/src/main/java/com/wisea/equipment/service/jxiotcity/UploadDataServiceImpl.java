package com.wisea.equipment.service.jxiotcity;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.influxdb.config.InfluxDBClient;
import com.wisea.equipment.constants.JxiotcityDataTypeEnum;
import com.wisea.equipment.constants.JxiotcityTemplateDataEnum;
import com.wisea.equipment.dao.EquInfoMapper;
import com.wisea.equipment.dao.EquMeteorologyMapper;
import com.wisea.equipment.entity.EquMeteorology;
import com.wisea.equipment.entity.influx.MeteorologyInflux;
import com.wisea.equipment.service.jxiotcity.RegisterOrderService;
import com.wisea.equipment.utils.EquipmentUtil;
import com.wisea.equipment.utils.JxiotcityUtil;
import com.wisea.equipment.vo.EquInfoVo;
import com.wisea.equipment.vo.SubStringVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author chengq
 * @date 2020/11/24 10:51
 */
@Service
public class UploadDataServiceImpl extends RegisterOrderService {

    @Resource
    private EquMeteorologyMapper equMeteorologyMapper;
    @Resource
    private InfluxDBClient influxDBClient;
    @Resource
    private JedisDao jedisDao;
    @Resource
    private EquInfoMapper equInfoMapper;

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public void perform(String data) {
        //解析设备id
        SubStringVo subStringVo = SubStringVo.buildSubStringVo(data, getLength(6));
        String equId = subStringVo.getUse();

        EquInfoVo info = equInfoMapper.findInfoByEntpIdAndNum("精讯畅通", equId);

        //检查时间
        OffsetDateTime now = OffsetDateTime.now();
        long equDecimalId = Long.parseLong(equId, 16);
        Boolean checkDataPoint = JxiotcityUtil.checkDataPoint(equDecimalId, now, info.getEquModel());
        if (!checkDataPoint) {
            //在间隔时间范围内不保存
            LoggerUtil.debug("【精讯畅通】在间隔时间范围内不保存：" + data);
            return;
        }
        //缓存最大时间，把16进制的设备id转成10进制储存
        EquipmentUtil.cacheDataPointMaxDate(equDecimalId, now, info.getEquModel());
        //删除鉴权码din
        subStringVo.delString(getLength(2));
        //删除数据长度
        subStringVo.delString(getLength(2));

        EquMeteorology equMeteorology = new EquMeteorology();
        //设备id
        equMeteorology.setEquId(info.getId());
        //设备数据类型
        equMeteorology.setEquDateType(JxiotcityDataTypeEnum.valueOf(info.getEquModel()).getDataType());
        //从redis中获取解析模板
        List<Integer> templates = jedisDao.getSerialize(getRedisKey(equId), List.class);
        if (ConverterUtil.isEmpty(templates)) {
            return;
        }
        //解析有效数据
        for (Integer template : templates) {
            JxiotcityTemplateDataEnum coefficient = JxiotcityTemplateDataEnum.getCoefficient(template);
            //取出模板对应的16进制值
            subStringVo.subString(getLength(4));
            if (Objects.isNull(coefficient)) {
                continue;
            }
            //实际值 = 10进制数据 * 系数
            double result = JxiotcityUtil.multiply(subStringVo.getDecimalUse(), coefficient.getCoefficient());
            //向对象中赋值
            setValue(equMeteorology, coefficient.getFieldName(), result);
        }

        //插入到数据库
        equMeteorology.preInsert();
        equMeteorology.setCreateDate(now);
        equMeteorologyMapper.batchInsert(Lists.newArrayList(equMeteorology));

        //时序数据库
        MeteorologyInflux xaircraftInfluxe = new MeteorologyInflux();
        ConverterUtil.copyProperties(equMeteorology, xaircraftInfluxe, "id", "equId");
        xaircraftInfluxe.setId(equMeteorology.getId().toString());
        xaircraftInfluxe.setEquId(equMeteorology.getEquId().toString());
        xaircraftInfluxe.setTime(Long.valueOf(now.toEpochSecond() * 1000).toString());
        //异步将设备气象数据列表插入到时序数据库中
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                //事物提交之后执行
                influxDBClient.batchInsert(Lists.newArrayList(xaircraftInfluxe));
            }
        });
    }

    /**
     * 通过反射向对象中赋值
     * @param equMeteorology 对象
     * @param fieldName 属性名称
     * @param value 值
     */
    private void setValue(EquMeteorology equMeteorology, String fieldName, Double value) {
        if (ConverterUtil.isEmpty(fieldName)) {
            return;
        }
        try {
            Field field = equMeteorology.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(equMeteorology, value);
        }catch (NoSuchFieldException | IllegalAccessException e) {
            LoggerUtil.debug("【精讯畅通】反射向属性赋值失败fieldName = " + fieldName + " value = " + value);
            e.printStackTrace();
        }
    }
}
