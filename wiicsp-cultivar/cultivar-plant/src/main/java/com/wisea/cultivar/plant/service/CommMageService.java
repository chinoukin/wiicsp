package com.wisea.cultivar.plant.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.TreeUtils;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.CommMageMapper;
import com.wisea.cultivar.common.dao.CommSaleSetMapper;
import com.wisea.cultivar.common.po.product.CommMageTreePo;
import com.wisea.cultivar.common.utils.CacheUtil;
import com.wisea.cultivar.common.vo.product.CommMageTreeModelVo;
import com.wisea.cultivar.common.vo.product.ZhfwCommMageTreeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础品类信息
 */
@Service
public class CommMageService extends BaseService {

    @Autowired
    CommMageMapper commMageMapper;
    @Autowired
    CommSaleSetMapper commSaleSetMapper;
    /**
     * 查询基础品类信息
     *
     * @param po
     * @return
     */
    public ResultPoJo<List<ZhfwCommMageTreeVo>> findCommMageTree(CommMageTreePo po) {
        ResultPoJo<List<ZhfwCommMageTreeVo>> poJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<ZhfwCommMageTreeVo> commMageTree = new ArrayList<>();
        List<ZhfwCommMageTreeVo> getlist = CacheUtil.getCommMageTree();
        if(ConverterUtil.isNotEmpty(po.getPid())&&po.getPid()!=0){
            for (ZhfwCommMageTreeVo commMageTreeVo : getlist) {
                if(commMageTreeVo.getId()==po.getPid()){
                    commMageTree.add(commMageTreeVo);
                }
            }
        }else{
            for (ZhfwCommMageTreeVo commMageTreeVo : getlist) {
                commMageTree.add(commMageTreeVo);
            }
        }

        if (ConverterUtil.isEmpty(po.getQuery()) && ConverterUtil.isEmpty(po.getEffeInvalState())) {
            poJo.setResult(commMageTree);
        } else {
            List<ZhfwCommMageTreeVo> list = TreeUtils.treeToList(commMageTree, CommMageTreeModelVo.class);
            List<ZhfwCommMageTreeVo> newList = Lists.newArrayList();
            if (ConverterUtil.isNotEmpty(po.getQuery()) && ConverterUtil.isNotEmpty(po.getEffeInvalState())) {
                newList = list.stream().filter(e -> e.getCommCatgName().indexOf(po.getQuery()) >= 0 && e.getEffeInvalState().equals(po.getEffeInvalState())).collect(Collectors.toList());
            } else if (ConverterUtil.isNotEmpty(po.getQuery())) {
                newList = list.stream().filter(e -> e.getCommCatgName().indexOf(po.getQuery()) >= 0).collect(Collectors.toList());
            } else if (ConverterUtil.isNotEmpty(po.getEffeInvalState())) {
                newList = list.stream().filter(e -> e.getEffeInvalState().equals(po.getEffeInvalState())).collect(Collectors.toList());
            }
            poJo.setResult(newList);
        }
        return poJo;
    }


}
