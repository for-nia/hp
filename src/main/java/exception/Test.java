package exception;

/**
 * Created by Fornia.fu on 2016/6/20.
 */
public class Test
{
    public static void main(String[] args)
    {
        Test test = new Test();
        try{
            System.out.println(test.exceptionTest());
        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public int exceptionTest()
        throws Exception
    {
        String a=null;
        int ret=0;
        try{
            System.out.println("try block");
            ret = Integer.valueOf(a);
            return ret;
        }catch (Exception e){
            System.out.println("catch block");
           // e.printStackTrace();
            //ret = Integer.valueOf(a);
            //ret++;
            return ret;
        }finally
        {

            //return ret==0?0:++ret;
            try
            {
                ret = Integer.valueOf(a);
            }catch (Exception e){
                throw new Exception("finally exception ");
            }
            return 0;
        }

    }
}
