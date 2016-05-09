package thread;

/**
 * Created by Fornia.fu on 2016/4/25.
 */
public class Main
{
    public static void main(String[] args)
    {
        Goods goods = new Goods();
        Productor productor1 = new Productor(goods);
        Productor productor2 = new Productor(goods);
        Productor productor3 = new Productor(goods);
        productor1.setNum(10);
        productor2.setNum(20);
        productor3.setNum(30);
        Consumer consumer1 = new Consumer(goods);
        Consumer consumer2 = new Consumer(goods);
        Consumer consumer3 = new Consumer(goods);
        Consumer consumer4 = new Consumer(goods);
        consumer1.setNum(5);
        consumer2.setNum(50);
        consumer3.setNum(30);
        consumer4.setNum(20);
        productor1.start();
        productor2.start();
        productor3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        /*try{
            Thread thread1 = new Thread(productor1);
            Thread thread2 = new Thread(productor2);
            Thread thread3 = new Thread(productor3);
            Thread thread4 = new Thread(consumer1);
            Thread thread5 = new Thread(consumer2);
            Thread thread6 = new Thread(consumer3);
            Thread thread7 = new Thread(consumer4);
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        }catch (Exception e){
            e.printStackTrace();
        }*/


    }
}
