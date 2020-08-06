package com.ctgu.carsale.entity;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-08-06 13:51:29
 */
public class User implements Serializable {
    private static final long serialVersionUID = 103144418911767927L;
    /**
    * 用户编号
    */
    private String userid;
    /**
    * 密码
    */
    private String password;
    /**
    * 用户名称
    */
    private String username;
    /**
    * 用户性别（1：男； 0：女）
    */
    private Integer usersex;
    /**
    * 用户头像
    */
    private Object userimg;
    /**
    * 删除标记（1：正常； 0：删除）
    */
    private Integer deltag;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public Object getUserimg() {
        return userimg;
    }

    public void setUserimg(Object userimg) {
        this.userimg = userimg;
    }

    public Integer getDeltag() {
        return deltag;
    }

    public void setDeltag(Integer deltag) {
        this.deltag = deltag;
    }

}