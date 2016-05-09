package aop;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Fornia.fu on 2016/4/25.
 */
public class CglibEnahnceProxy
{
    public static Object getInstance(Class clazz)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CglibMethodInterceptor());
        return enhancer.create();
    }
}
