package com.tw.graduateparkingboy;

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

    //任务分解1：
    @Test
    public void should_return_one_ticket_when_park_one_car() {
        //Given 有一个停车场，该停车场有1个空车位
        parkingLot = new ParkingLot(101, 3, carList);
        //When 停1辆车
        users.add(sri);
        //Then 返回一张停车票
        List<ParkingTicket> parking = new Parking().parking(parkingLot, users);
        assertEquals(1, parking.size());
    }


    @Test
    public void should_park_in_same_parklot_when_carPosition_is_enough() {
        //Given 有两个停车场，第一个有足够多空车位
        List<Car> carList1 = Stream.of(new Car(1009, "保时捷"), new Car(1025, "比亚迪")).collect(Collectors.toList());
        List<Car> carList2 = Stream.of(new Car(1056, "悍马"), new Car(1087, "野马")).collect(Collectors.toList());
        ParkingLot parkingLot1 = new ParkingLot(101, 20, carList1);
        ParkingLot parkingLot2 = new ParkingLot(102, 3, carList2);
        //When 连续多辆车
        users.add(sri);
        users.add(heny);
        users.add(lucy);
        //Then 两辆车都停在第一个停车场
        List<ParkingTicket> parking = new Parking().parking(parkingLot1, parkingLot2, users);
        assertEquals(3, parking.size());
        assertEquals(101, parking.get(0).getPid());
    }

    @Test
    public void should_park_in_different_parklot_when_parklot_carPosition_not_enough() {
        //Given 有两个停车场，每个都只有适量的空车位位
        List<Car> carList1 = Stream.of(new Car(1009, "保时捷"), new Car(1025, "比亚迪")).collect(Collectors.toList());
        List<Car> carList2 = Stream.of(new Car(1056, "悍马"), new Car(1087, "野马")).collect(Collectors.toList());
        ParkingLot parkingLot1 = new ParkingLot(101, 3, carList1);
        ParkingLot parkingLot2 = new ParkingLot(102, 3, carList2);
        //When 连续多辆车
        users.add(sri);
        users.add(heny);
        //Then 多辆车按顺序分别停在两个停车场上(按照票的编号连续)
        List<ParkingTicket> parking = new Parking().parking(parkingLot1, parkingLot2, users);
        assertEquals(2, parking.size());
        assertEquals(101, parking.get(0).getPid());
        assertEquals(102, parking.get(1).getPid());
    }
}
