package com.wisea.cultivar.operation.entity;

/**
 * TIM通知用户
 *
 * @author XuDL(Wisea)
 *
 *         2020年5月6日 上午11:32:29
 */
public class TIMNoticeUser {
    /** id */
    private String id;
    /** 昵称 */
    private String nick;
    /** 头像链接 */
    private String faceUrl;

    public TIMNoticeUser() {

    }

    public TIMNoticeUser(String id, String nick, String faceUrl) {
        this.id = id;
        this.nick = nick;
        this.faceUrl = faceUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

}
