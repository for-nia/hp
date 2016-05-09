package aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Fornia.fu on 2016/4/25.
 */
public class CglibMethodInterceptor implements MethodInterceptor
{

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable
    {
        //method.invoke(o,objects);
        System.out.println("before call the method");
        Object rev = methodProxy.invokeSuper(o,objects);
        System.out.println("after call the method");
        return rev;
    }
}
