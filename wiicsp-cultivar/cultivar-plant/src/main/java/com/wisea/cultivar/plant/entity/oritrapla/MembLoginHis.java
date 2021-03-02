package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * 会员上线记录
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月20日
 * @version 1.0
 */
public class MembLoginHis  extends DataLongEntity<MembLoginHis> {

    private static final long serialVersionUID = 5787785083907816449L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memb_login_his.memb_id
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    private Long membId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memb_login_his.login_date
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    private OffsetDateTime loginDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column memb_login_his.login_ip
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    private String loginIp;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memb_login_his.memb_id
     *
     * @return the value of memb_login_his.memb_id
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memb_login_his.memb_id
     *
     * @param membId the value for memb_login_his.memb_id
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memb_login_his.login_date
     *
     * @return the value of memb_login_his.login_date
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    public OffsetDateTime getLoginDate() {
        return loginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memb_login_his.login_date
     *
     * @param loginDate the value for memb_login_his.login_date
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    public void setLoginDate(OffsetDateTime loginDate) {
        this.loginDate = loginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column memb_login_his.login_ip
     *
     * @return the value of memb_login_his.login_ip
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column memb_login_his.login_ip
     *
     * @param loginIp the value for memb_login_his.login_ip
     *
     * @mbggenerated Wed Jun 20 10:14:24 CST 2018
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
