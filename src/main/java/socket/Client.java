package socket;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * Created by Fornia.fu on 2016/4/16.
 */
public class Client
{
    public static void main(String[] args)
    {
        try{
            Socket client = new Socket("localhost",12345);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            writer.write("Hello Server.");
            writer.flush();//写完后要记得flush
            client.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
