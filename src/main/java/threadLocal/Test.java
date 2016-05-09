package threadLocal;

/**
 * Created by Fornia.fu on 2015/12/18.
 */
public class Test implements Runnable {
    
    private Person person;
    private static ThreadLocal<Person> threadLocal = new ThreadLocal<Person>();
    public Test(Person person) {
        this.person = person;
    }
    public static void main(String[] args) throws InterruptedException {
        //多个线程使用同一个Person对象
        Person per = new Person(111, "Sone");
        Test test = new Test(per);
        Thread th1 = new Thread(test);
        Thread th2 = new Thread(test);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        //Person对象已经被线程给修改了！
        System.out.println("Person对象的值为：" + per);
    }


    public void run() {
        threadLocal.set(person);
        String threadName = Thread.currentThread().getName();
        Person perLocal = threadLocal.get();
        System.out.println(threadName + " befoer:" + threadLocal.get());
        perLocal.setId(888);
        perLocal.setName("Admin");
        System.out.println(threadName + " after:" + threadLocal.get());
    }
}