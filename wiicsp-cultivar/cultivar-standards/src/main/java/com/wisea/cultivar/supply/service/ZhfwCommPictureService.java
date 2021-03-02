package com.wisea.cultivar.supply.service;

import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.supply.entity.ZhfwCommPicture;
import com.wisea.cultivar.supply.mapper.ZhfwCommPictureMapper;
import com.wisea.cultivar.supply.po.CommoditySavePo;
import com.wisea.cultivar.supply.po.PicturePo;
import com.wisea.cultivar.supply.vo.PictureVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

/**
 * @author chengq
 * @date 2020/8/13 17:16
 */
@Service
public class ZhfwCommPictureService {

    @Resource
    private ZhfwCommPictureMapper zhfwCommPictureMapper;

    /**
     * 保存商品图片
     */
    @Transactional
    public void saveCommPicture(CommoditySavePo commoditySavePo) {
        //删除原图片
        Long commPubId = commoditySavePo.getId();
        zhfwCommPictureMapper.deleteByCommId(commPubId);
        //保存主图片
        save(commoditySavePo.getMainPicture(), commPubId, DictConstants.COMM_PICTURE_TYPE_0);
        //保存详情图片
        save(commoditySavePo.getDetailsPrices(), commPubId, DictConstants.COMM_PICTURE_TYPE_1);
    }

    /**
     * 保存图片
     * @param prices 图片
     * @param commPubId 商品id
     * @param pictureType 图片类型
     */
    @Transactional
    public void save(List<PicturePo> prices, Long commPubId, String pictureType) {
        if (ConverterUtil.isEmpty(prices)) {
            return;
        }
        //把视频放到图片后面
        prices.sort(Comparator.comparing(PicturePo::getPictureType));
        for (int i = 0; i < prices.size(); i++) {
            PicturePo detailsPrice = prices.get(i);
            ZhfwCommPicture mainPicture = new ZhfwCommPicture(commPubId, i, detailsPrice.getUrl(), detailsPrice.getPictureType(), pictureType);
            insert(mainPicture);
        }
    }

    /**
     * 插入图片
     */
    @Transactional
    public void insert(ZhfwCommPicture zhfwCommPicture) {
        zhfwCommPicture.preInsert();
        zhfwCommPictureMapper.insert(zhfwCommPicture);
    }


    /**
     * 通过主图片类型和商品id查询图片
     * @param commPubId 商品id
     * @param pictureType 主图片类型
     */
    public List<PictureVo> findByCommPubId(Long commPubId, String pictureType) {
        return zhfwCommPictureMapper.findByCommPubId(commPubId, pictureType);
    }
}
