package common;

/**
 * Created by Fornia.fu on 2016/6/2.
 */
public class CommonTest
{
    public static void main(String[] args)
    {
        String str1="hello";
        String str2="hello";

        String str3=str1;
        String str4= new String("hello");
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1=="hello");
        System.out.println(str1==str4);
        System.out.println(str1==str4.intern());
    }
}
