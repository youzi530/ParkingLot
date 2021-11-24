package com.tw.pojo;

/**
 * 停车票类
 */
public class ParkingTicket {

    private int tid;
    private String tName;

    public ParkingTicket(int tid, String tName) {
        this.tid = tid;
        this.tName = tName;
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

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "tid=" + tid +
                ", tName='" + tName + '\'' +
                '}';
    }
}
