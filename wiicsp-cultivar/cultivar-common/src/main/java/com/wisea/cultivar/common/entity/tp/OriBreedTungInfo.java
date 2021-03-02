package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:41
 * @Description 养殖栋信息
 **/
public class OriBreedTungInfo extends DataLongEntity<OriBreedTungInfo> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 养殖场id
     */
    private Long farmId;

    /**
     * 养殖栋名称
     */
    private String breedTungName;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 电话
     */
    private String tel;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
    }

    public String getBreedTungName() {
        return breedTungName;
    }

    public void setBreedTungName(String breedTungName) {
        this.breedTungName = breedTungName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
