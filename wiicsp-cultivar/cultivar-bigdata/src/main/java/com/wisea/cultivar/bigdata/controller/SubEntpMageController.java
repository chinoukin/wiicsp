package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.bigdata.service.SubEntpMageService;
import com.wisea.cultivar.common.po.bigdata.BuyerSalesRankPo;
import com.wisea.cultivar.common.po.bigdata.QueryTotalPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageBatDeletePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageGetPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageInsertPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMagePagePo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.AreaReportVo;
import com.wisea.cultivar.common.vo.bigdata.BuyerSalesRankVo;
import com.wisea.cultivar.common.vo.bigdata.GetJxRankVo;
import com.wisea.cultivar.common.vo.bigdata.QueryTotalVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMageGetVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMageListVo;
import com.wisea.cultivar.common.vo.bigdata.XlRankVo;
import com.wisea.cultivar.common.vo.bigdata.XsAnalysisVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * SubEntpMageController
 * 分公司名录管理 Controller
 * 2019/12/02 11:02:15
 */
@Api(tags = "分公司名录管理相关接口")
@RequestMapping(value = "/w/subEntpMage")
@RestController
public class SubEntpMageController {
    @Autowired
    protected SubEntpMageService subEntpMageService;

    @ApiOperation(value = "获取分公司名录管理分页列表")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Page<SubEntpMageListVo>> findPage(@RequestBody SubEntpMagePagePo subEntpMagePagePo) {
        return subEntpMageService.findPage(subEntpMagePagePo);
    }

    @ApiOperation(value = "获取分公司名录管理列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<SubEntpMageListVo>> list(@RequestBody SubEntpMageListPo subEntpMageListPo) {
        return subEntpMageService.findList(subEntpMageListPo);
    }

    @ApiOperation(value = "查询分公司名录管理")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<SubEntpMageGetVo> get(@RequestBody SubEntpMageGetPo subEntpMageGetPo) {
        return subEntpMageService.get(subEntpMageGetPo);
    }

    @ApiOperation(value = "新增分公司名录管理")
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> insert(@RequestBody SubEntpMageInsertPo subEntpMageInsertPo) {
        return subEntpMageService.insert(subEntpMageInsertPo);
    }

    @ApiOperation(value = "修改分公司名录管理")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody SubEntpMageUpdatePo subEntpMageUpdatePo) {
        return subEntpMageService.update(subEntpMageUpdatePo);
    }
    @ApiOperation(value = "新增or修改分公司名录管理")
    @RequestMapping(value = "saveOrupd", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> saveOrupdate(@RequestBody SubEntpMageUpdatePo subEntpMageUpdatePo) {
    	return subEntpMageService.saveOrupdate(subEntpMageUpdatePo);
    }

    @ApiOperation(value = "批量删除分公司名录管理")
    @RequestMapping(value = "batDelete", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> batDelete(@RequestBody SubEntpMageBatDeletePo subEntpMageBatDeletePo) {
        return subEntpMageService.batDelete(subEntpMageBatDeletePo);
    }

    /**
     * 导出分公司名录管理
     *
     * @param
     * @return
     * @throws IOException
     */
	@DataCheck
    @ApiOperation("导出分公司名录管理")
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ResultPoJo<Object> export(@RequestBody SubEntpMageListPo po, HttpServletResponse response) throws IOException {
		return subEntpMageService.export(po, response);
    }

	/**
	 * 查询基础配置
	 * @param QueryTotalPo
	 * @return
	 */
	@ApiOperation(value = "查询基础配置")
    @RequestMapping(value = "getTotal", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<QueryTotalVo> getTotal(@RequestBody QueryTotalPo QueryTotalPo) {
        return subEntpMageService.getTotal(QueryTotalPo);
    }

	@ApiOperation(value = "采购商销售排行")
    @RequestMapping(value = "xsRank", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<BuyerSalesRankVo>> getXsRank(@RequestBody BuyerSalesRankPo buyerSalesRankPo) {
        return subEntpMageService.getXsRank(buyerSalesRankPo);
    }

	@ApiOperation(value = "同比环比分析")
	@RequestMapping(value = "xsAnalysis", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<List<XsAnalysisVo>> getXsAnalysis(@RequestBody BuyerSalesRankPo buyerSalesRankPo) {
		return subEntpMageService.getXsAnalysis(buyerSalesRankPo);
	}

	@ApiOperation(value = "单品交易排行")
	@RequestMapping(value = "jxRank", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<List<GetJxRankVo>> getJxRank(@RequestBody BuyerSalesRankPo buyerSalesRankPo) {
		return subEntpMageService.getJxRank(buyerSalesRankPo);
	}

	@ApiOperation(value = "地图报表展示")
	@RequestMapping(value = "areaReport", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<List<AreaReportVo>> getAreaReport(@RequestBody BuyerSalesRankPo buyerSalesRankPo) {
		return subEntpMageService.getAreaReport(buyerSalesRankPo);
	}

	@ApiOperation(value = "分公司销量排行榜")
	@RequestMapping(value = "xlRank", method = RequestMethod.POST)
	@DataCheck
	public ResultPoJo<List<XlRankVo>> getXlRank(@RequestBody BuyerSalesRankPo buyerSalesRankPo) {
		return subEntpMageService.getXlRank(buyerSalesRankPo);
	}


}
