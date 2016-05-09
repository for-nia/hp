package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Fornia.fu on 2016/4/13.
 */
public class DynaProxyHandler implements InvocationHandler
{
    private Object proxy;
    private Object delegate;
    public Object bind(Object proxy,Object delegate)
    {
        this.proxy = proxy;
        this.delegate = delegate;
        return Proxy.newProxyInstance(
            this.delegate.getClass().getClassLoader(),
            this.delegate.getClass().getInterfaces(),
            this
        );
    }
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        Object result = null;
        try{
            Class clazz = this.proxy.getClass();
            Method startMethod = clazz.getMethod("startMethod");
            startMethod.invoke(this.proxy);
            //System.out.println("the method start .");
            System.out.println(proxy.getClass().getName());
            System.out.println(method.getClass().getName());
            System.out.println(this.delegate.getClass().getName());
            result = method.invoke(this.delegate,args);
            Method endMethod = clazz.getMethod("endMethod");
            endMethod.invoke(this.proxy);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
