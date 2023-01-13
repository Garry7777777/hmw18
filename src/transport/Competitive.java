package transport;
public interface Competitive {
    static void  pitStop(){
        System.out.println("Пит Стоп");
    }

    void bestLapTime();
    void maxSpeed();
    @Override
    boolean equals(Object transport);
}
