package com.wisea.equipment.service.jxiotcity;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.equipment.service.jxiotcity.RegisterOrderService;
import com.wisea.equipment.vo.SubStringVo;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 1001注册协议
 * @author chengq
 * @date 2020/11/24 10:51
 */
@Service
public class RegisterServiceImpl extends RegisterOrderService {

    @Resource
    private JedisDao jedisDao;

    /**
     * 解析上传数据，把模板保存到redis中
     * FEDC 1001 4230002D003C D677 000E 10000002 0002 0003 0018 0019 001A 9181
     */
    @Override
    public void perform(String data) {
        //解析设备id
        SubStringVo subStringVo = SubStringVo.buildSubStringVo(data, getLength(6));
        String equId = subStringVo.getUse();
        //删除鉴权码din
        subStringVo.delString(getLength(2));
        //删除数据长度
        subStringVo.delString(getLength(2));
        //删除Version
        subStringVo.delString(getLength(4));
        //删除设备类型
        subStringVo.delString(getLength(2));
        //获取模板数量需要转成10进制
        subStringVo.subString(getLength(2));
        int templateCount = subStringVo.getDecimalUse();
        //解析模板id
        List<Integer> templates = Lists.newArrayList();
        for (int i = 0; i < templateCount; i++) {
            subStringVo.subString(getLength(2));
            templates.add(subStringVo.getDecimalUse());
        }
        //将模板id存到redis中
        jedisDao.setSerialize(getRedisKey(equId),templates);
    }

}
