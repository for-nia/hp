package httpServer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Fornia.fu on 2016/6/5.
 */
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            String contentType="text/html";
            InputStream inputStream = new FileInputStream("C:\\workspace\\hp\\3344.html");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int c;
            while ((c = inputStream.read())!=-1){
                outputStream.write(c);
            }
            HttpServer httpServer = new HttpServer(outputStream.toByteArray(),contentType,8989);
            new Thread(httpServer).start();
        }catch (Exception e){
            System.out.println("server stared error!");
            e.printStackTrace();
        }

    }
}
