package encode;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by Fornia.fu on 2016/3/28.
 */
public class Encode
{
    public static void main(String[] args){
        try{
            String encodeStr = URLEncoder.encode("hello)","UTF-8");
            System.out.println(encodeStr);
            String decodeStr = URLDecoder.decode(encodeStr,"UTF-8");
            System.out.println(decodeStr);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
