package ct;

/**
 * Created by Fornia.fu on 2016/2/24.
 */
public class ClassTest
{

    public static void main(String[] args){
        String a = "abc";
        String b = new String("abc");
        System.out.println(a==b);
        System.out.println(a.intern()==b);
        System.out.println(a.equals(b));
    }

}
