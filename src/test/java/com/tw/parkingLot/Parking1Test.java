package com.tw.parkingLot;

import com.tw.pojo.Car;
import com.tw.pojo.ParkingLot;
import com.tw.pojo.ParkingTicket;
import com.tw.pojo.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Parking1Test {

    ArrayList<Car> carList = new ArrayList<>();
    ParkingLot parkingLot;
    ArrayList<User> users = new ArrayList<>();
    User sri;
    User heny;
    User lucy;

    @Before
    public void ready() {
        Car tesla = new Car(1001, "特斯拉");
        Car bmw = new Car(1002, "宝马");
        carList.add(tesla);
        carList.add(bmw);

        sri = new User(100001, "Sri", "男", "桥车",1006);
        heny = new User(100002, "heny", "女", "跑车",1100);
        lucy = new User(100004, "lucy", "男", "卡车",1400);
    }

    @Test
    public void should_parking_one_and_return_parkingTicket_when_parkingLot_have_one_position() {
        users.add(sri);
        parkingLot = new ParkingLot(101, 3, carList);
        assertEquals(1, new Parking1().Parking(parkingLot, users).size());
    }

    @Test
    public void should_return_many_tickets_when_parkingLot_have_many_positions() {

    }

    @Test
    public void should_parking_failed_when_no_position_to_park() {
        users.add(sri);
        parkingLot = new ParkingLot(101, 2, carList);

        assertThrows(RuntimeException.class, () -> {
            new Parking1().Parking(parkingLot, users);
        });
    }

}
