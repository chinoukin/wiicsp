package com.wisea.equipment.vo;

/**
 * 字符串截取
 * @author chengq
 * @date 2020/11/16 10:46
 */
public class SubStringVo {

    /**
     * 截取之后剩余的字符串
     */
    private String last;

    /**
     * 要是用的字符串
     */
    private String use;

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    /**
     * 16进制转10进制之后的数据
     */
    public Integer getDecimalUse() {
        int toint;
        toint = Integer.parseUnsignedInt(use, 16);  //将16进制转为int型
        if(toint > 32767) {  //32767是7fff的整型
            toint = toint - 65536;  //65536就是ffff+1的整型
        }
        return toint;
    }

    /**
     * 从头删除字符
     */
    public void delString(int length) {
        this.last = last.substring(length);
    }

    /**
     * 截取使用的字符串
     */
    public void subString(int length) {
        this.use = last.substring(0, length);
        this.last = last.substring(length);
    }

    private SubStringVo(String last, String use) {
        this.last = last;
        this.use = use;
    }

    /**
     * 构建对象
     * @param data 数据
     * @param length 使用长度
     */
    public static SubStringVo buildSubStringVo(String data, int length) {
        return new SubStringVo(data.substring(length), data.substring(0, length));
    }
}
