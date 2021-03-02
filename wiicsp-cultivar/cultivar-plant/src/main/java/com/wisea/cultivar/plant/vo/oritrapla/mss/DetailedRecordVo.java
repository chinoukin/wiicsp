package com.wisea.cultivar.plant.vo.oritrapla.mss;

import com.wisea.cultivar.plant.vo.oritrapla.ExamRecdVo;
import com.wisea.cultivar.plant.vo.oritrapla.FarmWorkRecdVo;
import com.wisea.cultivar.plant.vo.oritrapla.PadYjInfoListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className DetailedRecordVo
 * @date 2019/7/19 16:12
 * @Description 详细记录VO
 */
@ApiModel("详细记录Vo")
public class DetailedRecordVo {
    @ApiModelProperty("档案ID")
    private Long id;
    @ApiModelProperty("我的档案ID")
    private Long mineArchId;
    @ApiModelProperty("地块名称")
    private String massifName;
    @ApiModelProperty("地块面积")
    private Double massifAcre;
    @ApiModelProperty("种植面积")
    private Double plantAcre;
    @ApiModelProperty("地块类型")
    private String massifType;
    @ApiModelProperty("种植标准")
    private String plantType;
    @ApiModelProperty("当前种植作物-品类")
    private String commName;
    @ApiModelProperty("当前种植作物-品种")
    private String commVariName;
    @ApiModelProperty("种植管理员")
    private String cropAdmin;

    @ApiModelProperty("介绍")
    private String introduce;
    @ApiModelProperty("所属基地")
    private String orgName;
    @ApiModelProperty("联系地址")
    private String address;
    @ApiModelProperty("联系电话")
    private String contTel;
    @ApiModelProperty("联系人")
    private String contName;

    @ApiModelProperty("农事记录列表")
    private List<FarmWorkRecdVo> farmWorkRecdVos;
    @ApiModelProperty("标准农事项")
    private Integer farmWorkRecdCount;
    @ApiModelProperty("已完成农事项")
    private Integer completedFarmWorkRecdCount;
    @ApiModelProperty("待完成农事项")
    private Integer pendingFarmWorkRecdCount;

    @ApiModelProperty("检测记录列表")
    private List<ExamRecdVo> examRecdVos;

    @ApiModelProperty("设备信息列表")
    private List<EquInfoListVo> equInfoListVos;

    @ApiModelProperty("预警信息列表")
    private List<PadYjInfoListVo> padYjInfoListVos;

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public List<PadYjInfoListVo> getPadYjInfoListVos() {
        return padYjInfoListVos;
    }

    public void setPadYjInfoListVos(List<PadYjInfoListVo> padYjInfoListVos) {
        this.padYjInfoListVos = padYjInfoListVos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public Double getMassifAcre() {
        return massifAcre;
    }

    public void setMassifAcre(Double massifAcre) {
        this.massifAcre = massifAcre;
    }

    public Double getPlantAcre() {
        return plantAcre;
    }

    public void setPlantAcre(Double plantAcre) {
        this.plantAcre = plantAcre;
    }

    public String getMassifType() {
        return massifType;
    }

    public void setMassifType(String massifType) {
        this.massifType = massifType;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCropAdmin() {
        return cropAdmin;
    }

    public void setCropAdmin(String cropAdmin) {
        this.cropAdmin = cropAdmin;
    }

    public String getCommVariName() {
        return commVariName;
    }

    public void setCommVariName(String commVariName) {
        this.commVariName = commVariName;
    }

    public List<FarmWorkRecdVo> getFarmWorkRecdVos() {
        return farmWorkRecdVos;
    }

    public void setFarmWorkRecdVos(List<FarmWorkRecdVo> farmWorkRecdVos) {
        this.farmWorkRecdVos = farmWorkRecdVos;
    }

    public Integer getFarmWorkRecdCount() {
        return farmWorkRecdCount;
    }

    public void setFarmWorkRecdCount(Integer farmWorkRecdCount) {
        this.farmWorkRecdCount = farmWorkRecdCount;
    }

    public Integer getCompletedFarmWorkRecdCount() {
        return completedFarmWorkRecdCount;
    }

    public void setCompletedFarmWorkRecdCount(Integer completedFarmWorkRecdCount) {
        this.completedFarmWorkRecdCount = completedFarmWorkRecdCount;
    }

    public Integer getPendingFarmWorkRecdCount() {
        return pendingFarmWorkRecdCount;
    }

    public void setPendingFarmWorkRecdCount(Integer pendingFarmWorkRecdCount) {
        this.pendingFarmWorkRecdCount = pendingFarmWorkRecdCount;
    }

    public List<ExamRecdVo> getExamRecdVos() {
        return examRecdVos;
    }

    public void setExamRecdVos(List<ExamRecdVo> examRecdVos) {
        this.examRecdVos = examRecdVos;
    }

    public List<EquInfoListVo> getEquInfoListVos() {
        return equInfoListVos;
    }

    public void setEquInfoListVos(List<EquInfoListVo> equInfoListVos) {
        this.equInfoListVos = equInfoListVos;
    }
}
