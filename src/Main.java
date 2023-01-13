
import drivers.*;
import exception.MyException;
import mechanics.Mechanic;
import transport.*;

import java.util.*;

import static transport.Bus.Capacity.*;
import static transport.Car.CarBodyType.*;
import static transport.Trucks.Carrying.*;

public class Main {
    public static void main(String[] args) {


        DriverB driverBob = new DriverB("Bob", 123456, 5);
        DriverC driverCharles  = new DriverC("Charles ", 456789, 10);
        DriverD driverDen = new DriverD("Den",159487, 7);

        Car carLada = new Car( HATCHBACK,"Lada", "Granta",  1.7f, driverBob);
        Car carAudi = new Car( SEDAN,"Audi", "A8 50 L TDI quat",  3.0f, driverBob);
        Car carBMW = new Car(SUV,"BMW", "Z8",  3.0f, driverBob);
        Car carKia = new Car(COUPE,"Kia", "Sportage 4-го поколения", 2.4f, driverBob);

        System.out.println(carLada);
        System.out.println(carAudi);
        System.out.println(carBMW);
        System.out.println(carKia);        System.out.println();

        Bus busLiaz = new Bus(BIG,"ЛИАЗ", "677", 10f,driverDen);
        Bus busIcarus = new Bus(VERYBIG,"Icarus", "280", 20f,driverDen);
        Bus busPaz = new Bus(SMALL,"ПАЗ", " Горбатый", 5f,driverDen);
        Bus busMers = new Bus(VERYSMALL,"Мерседес", " Люкс", 30f,driverDen);

        System.out.println(busLiaz);
        System.out.println(busIcarus);
        System.out.println(busPaz);
        System.out.println(busMers);        System.out.println();

        Trucks trucksZil = new Trucks(N2,"ЗИЛ", "130", 10f,driverCharles);
        Trucks trucksMaz = new Trucks(N2,"МАЗ", "200", 5f,driverCharles);
        Trucks trucksGaz = new Trucks(N3,"ГАЗ", "69", 5f,driverCharles);
        Trucks trucksMers = new Trucks(N1,"Мерседес", "Unimog", 20f,driverCharles);

        System.out.println(trucksZil);
        System.out.println(trucksMaz);
        System.out.println(trucksGaz);
        System.out.println(trucksMers);       System.out.println();

        trucksMaz.startMoving();
        busPaz.endMoving();         System.out.println();

        Competitive.pitStop();
        carLada.bestLapTime();
        busIcarus.maxSpeed();       System.out.println();

        driverBob.startMoving();
        driverDen.refuelCar();
        driverCharles.stopMoving();     System.out.println();

        busPaz.announcement();
        carLada.announcement();         System.out.println();

//  вывод в консоль домашки - Перечисления в Java

        System.out.println(Car.CarBodyType.COUPE);
        System.out.println(N1);
        System.out.println(N2);
        System.out.println(N3);
        System.out.println(SMALL);
        System.out.println(VERYBIG);                System.out.println();

        busPaz.printType();
        carLada.printType();
        trucksMaz.printType();

        trucksMaz.setCarrying(null);
        trucksMaz.printType();                      System.out.println();

//  вывод в консоль домашки - Работа с исключениями

        trucksMaz.passDiagnostics();
        carLada.passDiagnostics();
        busPaz.passDiagnostics();
/*
        try {
            driverBob.setLicenseType( "", "Категория «B»");
        } catch ( MyException exception) {
            System.out.print( driverBob.fullName );
        }

        try {
            driverDen.setLicenseType( "нового образца", "Категория «B»");
        } catch ( MyException exception) {
            System.out.print( driverDen.fullName );
        }
*/

        //  вывод в консоль домашки - Введение в коллекции. List и Queue

        Mechanic mechVasya = new Mechanic("Василий", "Автобусная компания", "автобус");
        Mechanic mechPetya = new Mechanic("Пётр", "Грузовая компания", "грузовик");
        Mechanic mechIvan = new Mechanic("Иван", "Универсальная компания", "все виды");

        List<Mechanic> mechanicsAL = new ArrayList<>(List.of(mechIvan, mechVasya, mechPetya));
        List<Transport> transports = new ArrayList<>(List.of(carLada, busIcarus, trucksZil));
        List<Driver> driversAL = new ArrayList<>(List.of(driverBob, driverCharles, driverDen));
        System.out.println(mechanicsAL);

        busIcarus.setMechanics(mechVasya);
        busIcarus.setMechanics(mechPetya); // не может обслуживать
        busIcarus.setMechanics(mechIvan);

        System.out.println(busIcarus.getMechanics()); // механики икаруса
        System.out.println(" водитель по  имени " + busIcarus.driver.fullName); //

        mechPetya.doMaintenance(busIcarus); // отказ
        mechVasya.doMaintenance(busIcarus);


    //  вывод в консоль домашки -Введение в коллекции. Map
        Map<Transport,Mechanic> mechanicsHM = new HashMap<>(){
            {
                put(busIcarus, mechIvan);
                put(trucksGaz, mechVasya);
                put(busIcarus, mechPetya);
            }
        };

        System.out.println( mechanicsHM.keySet());
        System.out.println( busIcarus.equals(busIcarus) + "  " + busIcarus.equals(busLiaz));

        //  вывод в консоль домашки - Коллекции. Set. Iterator

        Set<Driver> driversHS = new HashSet<>(){
            {   add( driverBob);
                add(driverCharles);

                add(driverDen);
                add(driverDen);
                add(driverDen); }};

        Iterator<Driver> itr = driversHS.iterator();
        while (itr.hasNext())
            System.out.println( itr.next() );




    }
}