
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Fornia.fu on 2015/11/25.
 */
public class Test {


    public static void main(String[] args){

       // int b = Integer.parseInt("a");

        /*String str = null;
        String str2 = null;
        boolean isStr = str.equals(str2);
        System.out.println(isStr);*/

       /* Map map = new HashMap();
        map.put("a","b");
        map.put("a","c");
        map.put("a","");*/
/*
        System.out.println(System.currentTimeMillis());
        java.util.Date d = new java.util.Date(System.currentTimeMillis());
        Date date = new Date(d.getTime());

        System.out.println(date.toString());
        System.out.println(d.toString());*/
        switchTest();
        String str = "_IS_QUERY__";
        String[] strs = str.split("_");


        int[] arr = new int[]{1,2,3,5,6,7,10};
        Test test = new Test();
        int flag = test.dividSearch(arr,0,arr.length-1,5);
        System.out.println(flag);
        if(flag>=0){
            System.out.println(arr[flag]);
        }

        testListCopy();



       // System.out.println(b);
        /*try{
            SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

            Long time=new Long(System.currentTimeMillis());

            String d = format.format(time);

            Date date=format.parse(d);

            System.out.println("Format To String(Date):"+d);
            System.out.println("Format To Date:"+date);
        }catch (Exception e){

        }

        Date testDate = new Date();
        System.out.println(testDate.toString());*/




    }

    public int dividSearch(int[] arr,int h,int t,int target){
        if(h>t){
            return -1;
        }
        int m = (h+t)/2;
        if(arr[m]<target){
            return dividSearch(arr,m+1,t,target);
        }else if(arr[m]>target){
            return dividSearch(arr,h,m-1,target);
        }else{
            return m;
        }
    }

    public static void testListCopy(){
        List list = new ArrayList();
        int yinyong = 2;
        list.add(1);
        list.add(yinyong);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        yinyong = 7;
        List list2 = new ArrayList(list);
        List list3 = list;
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = (Integer)iterator.next();
            if(integer.equals(2)){
                iterator.remove();
            }

        }
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);
    }


    public static void switchTest(){
        int[] a={1,2,3,3,5};
        for(int i:a){
            switch (i){
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                default:
                    break;
            }
        }
    }

}
