package com.tw.pojo;

/**
 * 用户类
 */
public class User {

    private Integer uid;
    private String name;
    private String sex;
    private String carType;

    public User(Integer uid, String name, String sex, String carType) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.carType = carType;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
