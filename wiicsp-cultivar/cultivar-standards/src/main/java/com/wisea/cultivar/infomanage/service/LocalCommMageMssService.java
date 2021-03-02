package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.mss.RemoteCommMageMss;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.vo.product.ZhfwCommMageTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 本地商品(品类)接口
 */
@Service
public class LocalCommMageMssService implements RemoteCommMageMss {
    @Autowired
    protected CommMageService commMageService;

    /**
     * 查询商品树数据
     *
     * @param po
     * @return
     */
    @Override
    public ResultPoJo<List<ZhfwCommMageTreeVo>> findCommMageTree(CommMageTreePo po) {
        return commMageService.findCommMageTree(po);
    }
}
