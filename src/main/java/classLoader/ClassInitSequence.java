package classLoader;

/**
 * Created by Fornia.fu on 2016/4/28.
 */
public class ClassInitSequence
{
    private static int a=1;
    static {
        System.out.println("this is static block ");
        System.out.println(a);
    }

    {
        System.out.println("this is common block");
    }

    public ClassInitSequence(){
        System.out.println("this is contrust");
    }

    public static void staticMethod(){
        System.out.println("this is static method");
    }

    public void commonMethod(){
        System.out.println("this is common method");
    }
}
