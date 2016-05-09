package thread;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Fornia.fu on 2016/4/25.
 */
public class Goods
{
    Vector<Object> vector = new Vector<Object>();

    private final int MAX_SIZE = 100;
    public void product(int num)
    {
        synchronized (vector){
            try{
                while(vector.size()+num>=MAX_SIZE){
                    System.out.println("the vector is full to wait consumer to consumer good:"+vector.size()+" num:"+num);
                    vector.wait();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

            for(int i=0;i<num;i++)
            {
                vector.add(i);
            }
            System.out.println("has produce "+num+" products");
            vector.notifyAll();
        }


    }

    public void consume(int num)
    {
        synchronized (vector){
            try{
                while(vector.size()<num){
                    System.out.println("the current size of vector is :"+vector.size()+"consume num:"+num);
                    vector.wait();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            int count = num;
            Iterator iterator = vector.iterator();
            while (count>0&&iterator.hasNext()){
                iterator.next();
                iterator.remove();
                count--;
            }
            System.out.println("has consumed "+ num + "goods");
            vector.notifyAll();
        }

    }
}
