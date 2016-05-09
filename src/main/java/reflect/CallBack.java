package reflect;

import java.lang.reflect.Method;

/**
 * Created by Fornia.fu on 2016/4/15.
 */
public class CallBack
{
    public static void main(String[] args)
    {
        try
        {
            CallBack callBack = new CallBack();
            Method method = callBack.getClass().getMethod("testCallBack",new Class[]{String.class});
            callBack.callBack(callBack,method,new Object[]{"hello callback method"});
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void callBack(Object o,Method method,Object[] args) throws Exception{
        System.out.println("this is the callBack method!");
        method.invoke(o,args);
    }
    public void testCallBack(String str)
    {
        System.out.println("this is the method callbacked");
        System.out.println("this is the args : "+str);
    }
}
