package com.tw.pojo;

/**
 * 停车票类
 */
public class ParkingTicket {

    private int tid;
    private String tName; //对应着用户的名字
    private int cid; //对应车的id

    public ParkingTicket(int tid, String tName, int cid) {
        this.tid = tid;
        this.tName = tName;
        this.cid = cid;
    }

    public ParkingTicket() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "tid=" + tid +
                ", tName='" + tName + '\'' +
                ", cid=" + cid +
                '}';
    }
}
