package com.ctgu.carsale.entity;

import java.io.Serializable;

/**
 * (Collects)实体类
 *
 * @author makejava
 * @since 2020-08-08 15:21:08
 */
public class Collects implements Serializable {
    private static final long serialVersionUID = -84436320202491870L;
    /**
    * 收藏编号
    */
    private Integer collectid;
    /**
    * 用户名
    */
    private Long userid;
    /**
    * 汽车编号
    */
    private Integer carid;

    private User user;

    private Car car;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

}