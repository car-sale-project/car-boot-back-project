package com.ctgu.carsale.entity;

import java.io.Serializable;

/**
 * (Car)实体类
 *
 * @author makejava
 * @since 2020-08-07 21:34:43
 */
public class Car implements Serializable {
    private static final long serialVersionUID = -71620396153474021L;
    /**
    * 汽车编号
    */
    private Integer carid;
    /**
    * 汽车名称
    */
    private String carname;
    /**
    * 汽车品牌名
    */
    private String carbrand;
    /**
    * 库存
    */
    private Integer carstock;
    /**
    * 汽车图片
    */
    private Object carimg;
    /**
    * 汽车价格
    */
    private Double carprice;
    /**
    * 汽车型号
    */
    private String carmodel;
    /**
    * 汽车简介
    */
    private String carnote;


    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getCarbrand() {
        return carbrand;
    }

    public void setCarbrand(String carbrand) {
        this.carbrand = carbrand;
    }

    public Integer getCarstock() {
        return carstock;
    }

    public void setCarstock(Integer carstock) {
        this.carstock = carstock;
    }

    public Object getCarimg() {
        return carimg;
    }

    public void setCarimg(Object carimg) {
        this.carimg = carimg;
    }

    public Double getCarprice() {
        return carprice;
    }

    public void setCarprice(Double carprice) {
        this.carprice = carprice;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getCarnote() {
        return carnote;
    }

    public void setCarnote(String carnote) {
        this.carnote = carnote;
    }

}