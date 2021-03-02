package com.wisea.transac.seller.service;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.CertMageMapper;
import com.wisea.transac.common.dao.CertPictureMapper;
import com.wisea.transac.common.entity.CertMage;
import com.wisea.transac.common.entity.CertPicture;
import com.wisea.transac.common.po.seller.CertMagePageListPo;
import com.wisea.transac.common.po.seller.CertMagePo;
import com.wisea.transac.common.po.seller.CertPicturePageListPo;
import com.wisea.transac.common.po.seller.CertPicturePo;
import com.wisea.transac.common.vo.seller.CertMageInfoVo;
import com.wisea.transac.common.vo.seller.CertMagePageListVo;
import com.wisea.transac.common.vo.seller.CertPicturePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className CertMageService
 * @date 2020/04/27 17:01:28
 * @Description
 */
@Service
public class CertMageService extends BaseService {
    @Autowired
    private CertMageMapper mapper;
    @Autowired
    private CertPictureMapper certPictureMapper;

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询CertMage
     */
    public ResultPoJo<Page<CertMagePageListVo>> findPageList(CertMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
        ResultPoJo<Page<CertMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Page<CertMagePageListVo> page = po.getPage();
        List<CertMagePageListVo> list = mapper.findPageList(po);

        list.forEach(i -> {
            CertPicturePageListPo picturePageListPo = new CertPicturePageListPo();
            picturePageListPo.setCertMageId(i.getId());
            List<CertPicturePageListVo> vos = certPictureMapper.findPageList(picturePageListPo);
            i.setCertPictures(vos);
        });

        page.setList(list);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 逻辑删除CertMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        CertMage entity = mapper.selectByPrimaryKey(po.getId());
        if (ConverterUtil.isNotEmpty(entity)) {
            entity.setDelFlag(CertMage.DEL_FLAG_DELETE);
            entity.preUpdate();
            mapper.updateByPrimaryKey(entity);
            deleteCertPicsByertMageId(po.getId());
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 新增或修改CertMage
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultPoJo saveOrUpdate(CertMagePo po) {
        ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Long id;
        if (po.getId() != null) {
            CertMage mage = mapper.selectByPrimaryKey(po.getId());
            if (mage == null) {
                resultPoJo.setCode(ConstantError.ERR_004);
                resultPoJo.setMsg(ConstantError.MSG_004);
                return resultPoJo;
            }
            //不为空或跟原来的不一样去检查重复
            if (ConverterUtil.isNotEmpty(po.getCertName())&&
                    !po.getCertName().equals(mage.getCertName())) {
                CertMage certMage = new CertMage();
                certMage.setId(po.getId());
                certMage.setShopId(po.getShopId());
                certMage.setCertName(po.getCertName());
                Integer count = mapper.findByCertName(certMage);
                if (count >= 1) {
                    resultPoJo.setCode("999");
                    resultPoJo.setMsg("证书名字重复");
                    return resultPoJo;
                }
            }
            id = mage.getId();
            ConverterUtil.copyProperties(po, mage);
            mage.preUpdate();
            mapper.updateByPrimaryKeySelective(mage);

            //删除certMageId下所有的图片
            deleteCertPicsByertMageId(po.getId());

        } else {

            CertMage certMage = new CertMage();
            certMage.setCertName(po.getCertName());
            certMage.setShopId(po.getShopId());
            Integer count = mapper.findByCertName(certMage);
            if (count >= 1) {
                resultPoJo.setCode("999");
                resultPoJo.setMsg("证书名字重复");
                return resultPoJo;
            }

            //新增
            CertMage entity = new CertMage();
            BeanUtils.copyProperties(po, entity);
            entity.preInsert();
            mapper.insert(entity);
            id = entity.getId();
        }
        //插入新的图片
        List<CertPicturePo> pictures = po.getPictures();
        pictures.forEach(i -> {
            CertPicture picture = new CertPicture();
            picture.setCertMageId(id);
            picture.setUrl(i.getUrl());
            picture.preInsert();
            certPictureMapper.insert(picture);
        });

        return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息CertMage
     */
    public ResultPoJo<CertMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
        ResultPoJo<CertMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        CertMageInfoVo vo = mapper.findInfo(po);
        if (ConverterUtil.isNotEmpty(vo)) {
            List<CertPicturePageListVo> pictures = certPictureMapper.findAllByCertMageId(vo.getId());
            vo.setPictures(pictures);
            resultPoJo.setResult(vo);
        } else {
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 删除certMageId下的所有图片
     *
     * @param certMageId
     */
    private void deleteCertPicsByertMageId(Long certMageId) {
        List<CertPicturePageListVo> all = certPictureMapper.findAllByCertMageId(certMageId);
        all.forEach(i -> {
            CertPicture picture = new CertPicture();
            picture.setId(i.getId());
            picture.setDelFlag(DictConstants.DEL_FLAG_1);
            picture.preUpdate();
            certPictureMapper.updateByPrimaryKey(picture);
        });
    }


}
