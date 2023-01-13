package transport;
import drivers.DriverD;
import mechanics.Mechanic;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Bus extends Transport<DriverD> {
    private Capacity capacity;

    public enum Capacity {
        VERYSMALL(0, 10),
        SMALL(0, 20),
        MEDIUM(40, 50),
        BIG(60, 80),
        VERYBIG(100, 120);
        private final int minCapacity;
        private final int maxCapacity;
        Capacity(int minCapacity, int maxCapacity) {
            this.minCapacity = minCapacity;
            this.maxCapacity = maxCapacity;
        }
        @Override
        public String toString() {
            if (minCapacity == 0) return "Вместимость : до " + maxCapacity + " мест";
            if (maxCapacity == 0) return "Вместимость: от " + minCapacity + " мест";
            return "Вместимость: " + minCapacity + " - " + maxCapacity + " мест";
        }
    }

    public Bus(Capacity capacity, String brand, String model, float engineVolume, DriverD driver) {
        super(brand, model, engineVolume, driver);

        this.capacity = capacity;
    }

    public void printType() {
        if(capacity == null) System.out.println("Данных по транспортному средству недостаточно");
        else System.out.println(capacity);
    }


    @Override
    public void bestLapTime() {
        System.out.println("лучшее время круга бусика "+ this.brand + this.model);
    }

    @Override
    public void maxSpeed() {
        System.out.println("максимальная скорость бусика "+ this.brand + this.model);
    }
    @Override
    public String toString() {
        return "Bus марка:" + brand + " модель:" + model + " объем двигателя:" + engineVolume + " водитель:" + driver;
    }
    @Override
    public void setMechanics(Mechanic mechanic) {
    if (mechanic.transport.equals("автобус") || mechanic.transport.equals("все виды")) {
        carMechanics.add(mechanic);
        }
        else System.out.println("Механик " + mechanic.name + " не может обслуживать этот транспорт");
    }

    public Capacity getCapacity() {
        return capacity;
    }
    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }
}