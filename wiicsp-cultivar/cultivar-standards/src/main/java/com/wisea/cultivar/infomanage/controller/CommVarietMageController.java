package com.wisea.cultivar.infomanage.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.CommVarietMage;
import com.wisea.cultivar.common.po.DelAllPo;
import com.wisea.cultivar.common.po.product.CommVarietMageInsertPo;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import com.wisea.cultivar.common.po.product.CommVarietMagePagePo;
import com.wisea.cultivar.infomanage.service.CommVarierMageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 品种信息控制类
 * @author: wangs
 * @date :2019/4/15
 */
@Api(tags = "【后台管理】商品品种设置")
@RestController
@RequestMapping("/w/commVarietMage")
public class CommVarietMageController {

    @Autowired
    private CommVarierMageService commVarierMageService;

    /**
     * 查询所有的品种列表
     *
     * @param commVarietMagePagePo
     * @return
     */
    @ApiOperation(nickname = "查询商品品种列表", value = "查询商品品种列表", notes = "查询商品品种列表")
    @RequestMapping(value = "/findCommVarierMageList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<CommVarietMageListVo>> findCommVarierMageList(@RequestBody CommVarietMagePagePo commVarietMagePagePo) {
        return commVarierMageService.findCommVarierMageList(commVarietMagePagePo);
    }

    /**
     * 查询所有的品种列表不显示分页信息
     *
     * @param commVarietMagePagePo
     * @return
     */
    @ApiOperation(nickname = "查询商品品种列表", value = "查询商品品种列表", notes = "查询商品品种列表")
    @RequestMapping(value = "/findCommVarierMageListNoPage", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<CommVarietMageListVo>> findCommVarierMageListNoPage(@RequestBody CommVarietMagePagePo commVarietMagePagePo) {
        return commVarierMageService.findCommVarierMageListNoPage(commVarietMagePagePo);
    }

    /**
     * 修改和添加商品品种信息
     *
     * @param commVarietMageInsertPo
     * @return
     */
    @PreAuthorize("hasAuthority('im:gvs')")
    @ApiOperation(nickname = "添加和修改商品品种信息", value = "添加和修改商品品种信息", notes = "添加和修改商品品种信息")
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> saveOrUpdate(@RequestBody CommVarietMageInsertPo commVarietMageInsertPo) {
        return commVarierMageService.saveOrUpdate(commVarietMageInsertPo);
    }

    /**
     * 查询品种详细信息
     *
     * @param po
     * @return
     */
    @ApiOperation(nickname = "查询商品品种详细信息", value = "查询商品品种详细信息", notes = "查询商品品种详细信息")
    @RequestMapping(value = "/findCommVarierMageInfo", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<CommVarietMage> findCommVarierMageInfo(@RequestBody LongIdPo po) {
        return commVarierMageService.findCommMageInfo(po);
    }

    /**
     * 删除商品品种
     *
     * @param po
     * @return
     */
    @PreAuthorize("hasAuthority('im:gvs')")
    @ApiOperation(nickname = "删除商品品种", value = "删除商品品种", notes = "删除商品品种")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> delete(@RequestBody LongIdPo po) {
        return commVarierMageService.delete(po);
    }
    /**
     * 删除商品品种
     *
     * @param po
     * @return
     */
    @PreAuthorize("hasAuthority('im:gvs')")
    @ApiOperation(nickname = "批量删除商品品种", value = "批量删除商品品种", notes = "批量删除商品品种")
    @RequestMapping(value = "/delAll", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> deleteAll(@RequestBody DelAllPo po) {
        return commVarierMageService.delAll(po);
    }


}
