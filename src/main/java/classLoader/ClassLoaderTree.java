package classLoader;

/**
 * Created by Fornia.fu on 2016/4/18.
 */
public class ClassLoaderTree
{
    public static void main(String[] args)
    {
        ClassLoader classLoader = ClassLoaderTree.class.getClassLoader();
        while (classLoader!=null)
        {
            System.out.println(classLoader.getClass().getName());
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }
    }
}
