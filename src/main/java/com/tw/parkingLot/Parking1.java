package com.tw.parkingLot;

import com.tw.pojo.Car;
import com.tw.pojo.ParkingLot;
import com.tw.pojo.ParkingTicket;

import java.util.ArrayList;

public class Parking1 {

    static {
        ArrayList<Car> carList = new ArrayList<Car>();
        Car car1 = new Car(1001, "特斯拉");
        Car car2 = new Car(1002, "宝马");
        carList.add(car1);
        carList.add(car2);
        ParkingLot parkingLot = new ParkingLot(101, 20, carList);
    }

    public ParkingTicket Parking(ParkingLot parkingLot) {
        if (parkingLot.getCarList().size() >= parkingLot.getpNumber()) {
            throw new RuntimeException("停车场已满，无法停车");
        }else{
            return new ParkingTicket();
        }
    }
}
