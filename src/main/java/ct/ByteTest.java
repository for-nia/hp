package ct;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Fornia.fu on 2016/2/25.
 */
public class ByteTest{

    public static Map map = new HashMap();

    public static void main(String[] args){
        /*String str = "你好啊";
        byte[] bs= str.getBytes();
        char[] chars = str.toCharArray();
        for(char ch:chars){
            System.out.println(ch);
        }
        String s = new String(bs);
        System.out.println(s);
        for(byte b:bs){
            System.out.println(b);
            //System.out.println((char)b);
        }
        ByteTest bt = new ByteTest();
        bt.parseFile("C:\\Users\\fornia.fu\\Desktop\\在 v2.8 PRD_Update.et");
        bt.readFile("C:\\Users\\fornia.fu\\Desktop\\在 v2.8 PRD_Update.et");*/
        ByteTest bt = new ByteTest();
        bt.addMap();
        map.clear();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void parseFile(String path){
        byte[] buff = new byte[28];
        try{
            InputStream is = new FileInputStream(path);
            is.read(buff,0,buff.length);
            String fileHeader = bytesToHexString(buff);
            System.out.println(fileHeader);

        }catch (Exception e){

        }

    }

    private String bytesToHexString(byte[] src){

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public void readFile(String path){
        try{
            InputStream is = new FileInputStream(path);
            Reader reader = new InputStreamReader(is,"ANSI");
            BufferedReader br = new BufferedReader(reader);
            String line = br.readLine();
            while(line!=null){
                System.out.println(line);
                line=br.readLine();
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void addMap(){
        map.put("1",1);
        map.put("2",2);
    }
}
