package reflect;

/**
 * Created by Fornia.fu on 2016/5/31.
 */
public class MethodTest
{
    public void myMethod(Object o)
    {
        System.out.println("my object");
    }
    public void myMethod(String s)
{
    System.out.println("My string");
}

    public void myMethod(char c)
    {
        System.out.println("My char");
    }

    public void myMethod(int i)
    {
        System.out.println("My integer");
    }
    public static void main(String[] args)
    {
        MethodTest methodTest = new MethodTest();
        Integer i = new Integer(1);
        methodTest.myMethod(null);
    }
}
