package aop;

import java.lang.reflect.Method;

/**
 * Created by Fornia.fu on 2016/4/13.
 */
public class LogImpl implements LogInface
{
    public void startMethod()
    {
        System.out.println("the method is started!");
    }
    public void endMethod()
    {
        System.out.println("the method is ended!");
    }
}
