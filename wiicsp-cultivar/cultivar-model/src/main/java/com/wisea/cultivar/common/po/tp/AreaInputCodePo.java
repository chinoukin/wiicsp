package com.wisea.cultivar.common.po.tp;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/19 下午1:42
 * @Description:传入省市县PO
 */
public class AreaInputCodePo {

    /**
     * 所在地区省
     */
    private String addressProv;

    /**
     * 所在地区市
     */
    private String addressCity;

    /**
     * 所在地区区县
     */
    private String addressCou;

    /*
    * 详细地址
    * */
    private String addressDetail;

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressProv() {
        return addressProv;
    }

    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCou() {
        return addressCou;
    }

    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou;
    }
}
