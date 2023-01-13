package drivers;
public class Driver {
    public String fullName;
    protected int driverLicense;
    protected int drivingExperience;

    public Driver(String fullName, int driverLicense, int drivingExperience) {
        this.fullName = fullName;
        this.driverLicense = driverLicense;
        this.drivingExperience = drivingExperience;
    }


    public void startMoving(){
        System.out.println( this  + " движется ");
    }

    public void stopMoving(){
        System.out.println( this  + " остановился ");
    }

    public void refuelCar(){
        System.out.println( this  + " заправляет ");
    }

    @Override
    public String toString() {
        return " водитель " + fullName;
    }



}
