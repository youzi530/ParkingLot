package com.tw.pojo;

/**
 * 用户类
 */
public class User {

    private Integer uid;
    private String name;
    private String sex;
    private String carType;
    private int cid; //对应车的id

    public User(Integer uid, String name, String sex, String carType, int cid) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.carType = carType;
        this.cid = cid;
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", carType='" + carType + '\'' +
                ", cid=" + cid +
                '}';
    }
}
