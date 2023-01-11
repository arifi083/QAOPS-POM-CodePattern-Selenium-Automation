package utlis;

public class TimeOut {
    public static final int PAGE_WAIT_TIME=30;

    public static void waitForDomStable(){
        try{

            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }

    }
}
