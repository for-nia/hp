import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.*;

/**
 * Created by Fornia.fu on 2016/1/15.
 */
public class Formate {


    public static void main(String[] args){
       /* Map map = new HashMap();

        Set set = new HashSet();
        List list = new ArrayList();
        map.put("id",5);
        Object object = map.get("ID");
        int test = (Integer)map.get("ID");
        System.out.println(test);*/

        /*List list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(7);

        List subList = new ArrayList();
        subList.add(2);
        subList.add(6);

        Map map = new TreeMap();

        boolean retainAll = list.retainAll(subList);

        System.out.println(retainAll);
        System.out.println(list);
        System.out.println(subList);*/


        //mapTest();
        try{
            testHashMap();
        }catch (Exception e){
            e.printStackTrace();
        }





    }

    public static void mapTest(){
        Map map=new HashMap();

        map.put("a", "aaa");

        map.put("b", "bbb");

        map.put("c", "ccc");

        map.put("d", "ddd");



        Iterator iterator = map.keySet().iterator();

        while (iterator.hasNext()) {

            Object key = iterator.next();

            System.out.println("map.get(key) is :"+map.get(key));

        }



        Hashtable tab=new Hashtable();

        tab.put("a", "aaa");

        tab.put("b", "bbb");

        tab.put("c", "ccc");

        tab.put("d", "ddd");

        Iterator iterator_1 = tab.keySet().iterator();

        while (iterator_1.hasNext()) {

            Object key = iterator_1.next();

            System.out.println("tab.get(key) is :"+tab.get(key));

        }



        TreeMap tmp=new TreeMap();

        tmp.put("a", "aaa");

        tmp.put("b", "bbb");

        tmp.put("c", "ccc");

        tmp.put("d", "ddd");

        Iterator iterator_2 = tmp.keySet().iterator();

        while (iterator_2.hasNext()) {

            Object key = iterator_2.next();

            System.out.println("tmp.get(key) is :"+tmp.get(key));

        }
    }

    public static void testHashMap() throws Exception{
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {

            public void run() {
                for (int i = 0; i < 10; i++) {
                    new Thread(new Runnable() {

                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();

        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
