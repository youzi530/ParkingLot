package com.tw.parkinglot;

import com.tw.pojo.Car;
import com.tw.pojo.ParkingLot;
import com.tw.pojo.ParkingTicket;
import com.tw.pojo.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parking {

    /**
     * 停车方法
     *
     * @param parkingLot
     * @param users
     * @return
     */
    public List<ParkingTicket> parking(ParkingLot parkingLot, List<User> users) {
        int usersNum = users.size(); //当前等待停车的用户数量
        int prakNum = parkingLot.getpNumber() - parkingLot.getCarList().size(); //当前停车场剩余车位数 = 停车场的车位数-停车场已有车数量
        ArrayList<ParkingTicket> ticketList = new ArrayList<>();
        if (parkingLot.getCarList().size() >= parkingLot.getpNumber()) {
            throw new RuntimeException("停车场已满，无法停车");
        } else {
            for (int i = 0; i < usersNum; i++) {
                if (prakNum > 0) {
                    ParkingTicket parkingTicket = new ParkingTicket(100 + users.get(i).getUid(), users.get(i).getName(), users.get(i).getCid());
                    ticketList.add(parkingTicket);
                    prakNum--;

                    //停车后就需要往停车场新增一辆车的信息，以模拟取车的时候业务
                    List<Car> carList = parkingLot.getCarList();
                    carList.add(new Car(users.get(i).getCid(), users.get(i).getcName()));
                    parkingLot.setCarList(carList);
                }
            }
            return ticketList;
        }
    }

    //错误逻辑：不能用用户保存的cid去和车的cid进行比较，而应该是车票和票池去比较
    public Car pickUp(ParkingLot parkingLot, List<ParkingTicket> originTickets, ParkingTicket ticket, User user) {
        List<Car> carList = parkingLot.getCarList();
        Iterator<Car> iterator = carList.iterator();
        if (originTickets.isEmpty() || !originTickets.contains(ticket)) {
            throw new RuntimeException("车票无效，取车失败！");
        }
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getCid().equals(user.getCid())) {
                carList.remove(car);
                break;
            }
        }
        originTickets.remove(ticket);
        return new Car(user.getCid(), user.getcName());
    }

    //1、根据票池来去和票做判断，
    //2、换一个数据结构，使用map<>,key为票，然后value是车，这样就能克服
    //3、进行方法重构，省去用户的加入
    public Car pickUp(ParkingLot parkingLot, List<ParkingTicket> originTickets, ParkingTicket ticket) {
        List<Car> carList = parkingLot.getCarList();
        if (originTickets.isEmpty() || !originTickets.contains(ticket)) {
            throw new RuntimeException("车票无效，取车失败！");
        }
        // car id = ticket id
        Car car1 = carList.stream().filter(car -> car.getCid().equals(ticket.getCid())).findFirst().get();
        ParkingTicket parkingTicket = originTickets.stream().filter(tickets -> tickets.getCid() == ticket.getCid()).findFirst().get();
        originTickets.remove(ticket);
        return car1;
    }
}
