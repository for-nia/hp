package aop;

/**
 * Created by Fornia.fu on 2016/4/13.
 */
public class MainTest
{
    public static void main(String[] args)
    {
        DynaProxyHandler dynaProxyHandler = new DynaProxyHandler();
        Car car = (Car) dynaProxyHandler.bind(new LogImpl(),new CarImpl());
        //car.start();
        car.run();
        //car.stop();
        System.out.println(car.getClass().getName());

        System.out.println("=======================");
        Car carCglib = (Car)CglibEnahnceProxy.getInstance(CarImpl.class);
        carCglib.run();
    }
}
