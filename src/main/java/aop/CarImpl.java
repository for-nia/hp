package aop;

/**
 * Created by Fornia.fu on 2016/4/13.
 */
public class CarImpl implements Car
{
    public void start()
    {
        System.out.println("starting the car");
    }
    public void run()
    {
        System.out.println("the car is running.");
        System.out.println(this.getClass().getName());
    }

    public void stop()
    {
        System.out.println("the cat has stoped.");
    }
}
