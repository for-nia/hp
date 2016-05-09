package thread;

/**
 * Created by Fornia.fu on 2016/2/22.
 */
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.ReentrantLock;

public class Test implements Runnable
{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public void run()
    {
        //lock.lock();
        for (int j = 0; j < 1000; j++)
        {
            lock.lock();
            try
            {
                i++;
                System.out.println(Thread.currentThread().getName());
            }
            finally
            {
                lock.unlock();
            }
        }
        //lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException
    {
        Test test = new Test();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        System.out.println(Thread.currentThread().getName());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
