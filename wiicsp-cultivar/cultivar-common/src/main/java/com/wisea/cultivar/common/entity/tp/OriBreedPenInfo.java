package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:42
 * @Description 养殖栏信息
 **/
public class OriBreedPenInfo extends DataLongEntity<OriBreedPenInfo> {
    /**
     * 养殖栋id
     */
    private Long breedTungId;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 养殖栏名称
     */
    private String breedPenName;

    /**
     * 养殖场id
     */
    private Long farmId;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 电话
     */
    private String tel;

    public Long getBreedTungId() {
        return breedTungId;
    }

    public void setBreedTungId(Long breedTungId) {
        this.breedTungId = breedTungId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getBreedPenName() {
        return breedPenName;
    }

    public void setBreedPenName(String breedPenName) {
        this.breedPenName = breedPenName;
    }

    public Long getFarmId() {
        return farmId;
    }

    public void setFarmId(Long farmId) {
        this.farmId = farmId;
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
