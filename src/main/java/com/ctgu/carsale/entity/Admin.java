package com.ctgu.carsale.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2020-08-08 11:51:07
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -46413122393035506L;
    /**
    * 管理员账号
    */
    private String adminid;
    /**
    * 管理员密码
    */
    private String adminpw;


    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminpw() {
        return adminpw;
    }

    public void setAdminpw(String adminpw) {
        this.adminpw = adminpw;
    }

}