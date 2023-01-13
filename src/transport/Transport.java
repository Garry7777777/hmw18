package transport;

import mechanics.Mechanic;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport<T> implements Competitive {
    protected final String brand;
    protected final String model;
    protected float engineVolume;
    public T driver;
    public List<Mechanic> carMechanics;

    public Transport(String brand, String model, float engineVolume, T driver) {

        if (brand == null) this.brand = "default";
        else this.brand = brand;

        if (model == null) this.model = "default";
        else this.model = model;

        if (engineVolume <= 0) this.engineVolume = 1.5f;
        else this.engineVolume = engineVolume;

        this.driver = driver;
         carMechanics = new ArrayList<>();
    }

    public void startMoving() {
        System.out.println("начал движение:" + this.brand + this.model + "  " + this.driver);
    }

    public void endMoving() {
        System.out.println("закончил движение:" + this.brand + this.model + "  " + this.driver);
    }

    public void announcement() {
        System.out.println(this.driver + " управляет автомобилем " + this.brand + this.model + "  " + " и будет участвовать в заезде");
    }

    public abstract void printType();

    public void passDiagnostics() {
        System.out.println("Диагностика " + this.brand + this.model + " невозможна ");
    }

    ;


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public abstract void setMechanics(Mechanic mechanic);


    public List<Mechanic> getMechanics() {
        return carMechanics;
    }

    @Override
    public boolean equals(Object transport) {
        if (transport == null) return false;
        Transport tr = (Transport)transport;
        return brand.equals(tr.brand) &&
                model.equals(tr.model) &&
                engineVolume == tr.engineVolume &&
                driver.equals(tr.driver) &&
                carMechanics.equals( tr.carMechanics);

    }
    @Override
    public int hashCode() {
        return brand.hashCode() +
               model.hashCode() +
               ((Float)engineVolume).hashCode() +
               driver.hashCode() +
               carMechanics.hashCode();

    }
}
