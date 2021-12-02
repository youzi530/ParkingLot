package com.tw.smartparkingboy;

import com.tw.parkinglot.Parking;
import com.tw.pojo.Car;
import com.tw.pojo.ParkingLot;
import com.tw.pojo.ParkingTicket;
import com.tw.pojo.User;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTest {

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

        sri = new User(100001, "Sri", "男", "桥车", 1006, "比亚迪");
        heny = new User(100002, "heny", "女", "跑车", 1100, "兰博基尼");
        lucy = new User(100004, "lucy", "男", "卡车", 1400, "解放");
    }

    //任务分解1
    @Test
    public void should_return_one_ticket_when_parkingLot_have_one_position() {
        parkingLot = new ParkingLot(101, 3, carList);
        //When 停1辆车
        users.add(sri);
        //Then 返回一张停车票
        List<ParkingTicket> parking = new Parking().parking(parkingLot, users);
        assertEquals(1, parking.size());
    }

    @Test
    public void should_park_in_first_parkingLot_when_fist_parkingLot_has_more_parking_spaces() {
        //Given 有两个停车场，第一个空车位比第二个多
        List<Car> carList1 = Stream.of(new Car(1009, "保时捷"), new Car(1025, "比亚迪")).collect(Collectors.toList());
        List<Car> carList2 = Stream.of(new Car(1056, "悍马"), new Car(1087, "野马")).collect(Collectors.toList());
        ParkingLot parkingLot1 = new ParkingLot(101, 20, carList1);
        ParkingLot parkingLot2 = new ParkingLot(102, 3, carList2);
        //When 停1辆车
        users.add(sri);
        List<ParkingTicket> parking = new Parking().parking(parkingLot1, parkingLot2, users);
        //Then 车停在第一个停车场
        assertEquals(1, parking.size());
        assertEquals(101, parking.get(0).getPid());
    }

    @Test
    public void should_park_in_second_parkingLot_when_second_parkingLot_has_more_parking_spaces() {
        //Given 有两个停车场，第二个空车位比第一个多
        List<Car> carList1 = Stream.of(new Car(1009, "保时捷"), new Car(1025, "比亚迪")).collect(Collectors.toList());
        List<Car> carList2 = Stream.of(new Car(1056, "悍马"), new Car(1087, "野马")).collect(Collectors.toList());
        ParkingLot parkingLot1 = new ParkingLot(101, 3, carList1);
        ParkingLot parkingLot2 = new ParkingLot(102, 20, carList2);
        //When 停1辆车
        users.add(sri);
        List<ParkingTicket> parking = new Parking().parking(parkingLot1, parkingLot2, users);
        //Then 车停在第二个停车场
        assertEquals(1, parking.size());
        assertEquals(102, parking.get(0).getPid());
    }
}
