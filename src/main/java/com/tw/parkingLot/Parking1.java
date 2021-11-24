package com.tw.parkingLot;

import com.tw.pojo.ParkingLot;
import com.tw.pojo.ParkingTicket;
import com.tw.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class Parking1 {

    public List<ParkingTicket> Parking(ParkingLot parkingLot, List<User> users) {
        int usersNum = users.size(); //当前等待停车的用户数量
        int prakNum = parkingLot.getpNumber() - parkingLot.getCarList().size(); //当前停车场剩余车位数 = 停车场的车位数-停车场已有车数量
        ArrayList<ParkingTicket> ticketList = new ArrayList<>();
        if (parkingLot.getCarList().size() >= parkingLot.getpNumber()) {
            throw new RuntimeException("停车场已满，无法停车");
        } else {
            for (int i = 0; i < usersNum; i++) {
                while (prakNum > 0) {
                    ParkingTicket parkingTicket = new ParkingTicket(i + 10000, users.get(i).getName(), users.get(i).getCid());
                    ticketList.add(parkingTicket);
                    prakNum --;
                }
            }
            return ticketList;
        }
    }
}
