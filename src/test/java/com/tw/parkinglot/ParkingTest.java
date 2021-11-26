package com.tw.parkinglot;

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

        sri = new User(100001, "Sri", "男", "桥车",1006,"比亚迪");
        heny = new User(100002, "heny", "女", "跑车",1100,"兰博基尼");
        lucy = new User(100004, "lucy", "男", "卡车",1400,"解放");
    }

    @Test
    public void should_parking_one_and_return_parkingTicket_when_parkingLot_have_one_position() {
        users.add(sri);
        parkingLot = new ParkingLot(101, 3, carList);
        assertEquals(1, new Parking().parking(parkingLot, users).size());
    }

    @Test
    public void should_return_many_tickets_when_parkingLot_have_many_positions() {
        users.add(sri);
        users.add(heny);
        users.add(lucy);
        parkingLot = new ParkingLot(101, 10, carList);
        assertEquals(3, new Parking().parking(parkingLot, users).size());
        assertEquals("Sri", new Parking().parking(parkingLot, users).get(0).gettName());
    }

    @Test
    public void should_parking_failed_when_no_position_to_park() {
        users.add(sri);
        parkingLot = new ParkingLot(101, 2, carList);

        assertThrows(RuntimeException.class, () -> {
            new Parking().parking(parkingLot, users);
        });
    }

    @Test
    public void should_pick_up_my_car_when_parkinglot_only_have_my_car(){
        users.add(sri);
        parkingLot = new ParkingLot(101, 3, new ArrayList<>());
        Parking park = new Parking();
        List<ParkingTicket> parkings = park.parking(parkingLot, users);

        Car car = park.PickUp(parkingLot, parkings.get(0), users.get(0));
        assertEquals("比亚迪",car.getCarName());
        assertEquals(1006,car.getCid());
    }
    
    @Test
    public void should_pick_up_my_car_when_parkinglot_have_many_cars(){
        users.add(sri);
        parkingLot = new ParkingLot(101, 10, carList);
        Parking park = new Parking();
        List<ParkingTicket> parkings = park.parking(parkingLot, users);

        Car car = park.PickUp(parkingLot, parkings.get(0), users.get(0));
        assertEquals("比亚迪",car.getCarName());
        assertEquals(1006,car.getCid());
    }
}
