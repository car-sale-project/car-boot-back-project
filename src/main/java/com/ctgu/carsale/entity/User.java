package com.ctgu.carsale.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-08-07 11:58:45
 */
public class User implements Serializable {
    private static final long serialVersionUID = 700073171011774805L;
    /**
    * 用户id
    */
    private Long userid;
    /**
    * 密码
    */
    private String userpassword;
    /**
    * 地址
    */
    private String useraddress;
    /**
    * 联系方式
    */
    private String userphone;
    /**
    * 删除标记（1：正常； 0：删除）
    */
    private Integer deltag;
    /**
    * 用户名
    */
    private String username;
    /**
    * 性别
    */
    private String gender;


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Integer getDeltag() {
        return deltag;
    }

    public void setDeltag(Integer deltag) {
        this.deltag = deltag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", userpassword='" + userpassword + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", userphone='" + userphone + '\'' +
                ", deltag=" + deltag +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}