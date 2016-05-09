package thread;

/**
 * Created by Fornia.fu on 2016/5/4.
 */
public class VolatileTest
{
    private static volatile int count = 0;

    public static class MyThread implements Runnable{

        public void run()
        {
            count++;
        }
    }

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        for(int i = 0;i<10000;i++){
            new Thread(myThread).start();
        }
        try{
            Thread.sleep(5000L);

        }catch (Exception e){

        }
        System.out.println(count);
    }
}
