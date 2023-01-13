package exception;

public class MyException extends Exception{
    public MyException(String event) {
        System.out.println();
        System.out.print(event);
    }


}
