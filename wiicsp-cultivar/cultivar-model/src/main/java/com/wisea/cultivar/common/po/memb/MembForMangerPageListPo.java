package com.wisea.cultivar.common.po.memb;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.memb.MembForServiceListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运营平台/市场运营供应商认证管理分页列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台/市场运营供应商认证管理分页列表PO")
public class MembForMangerPageListPo extends PagePo<MembForServiceListVo>{

	private static final long serialVersionUID = -6789079952558013657L;

	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

	@ApiModelProperty(value="认证类型(0:个人:企业)")
	private String authType;

	@ApiModelProperty(value="审核状态(auth_state_type 0:待审核1:审核通过2:审核未通过)")
	private String authStateType;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }
}
