package socket;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Fornia.fu on 2016/4/16.
 */
public class Server
{

    public static void main(String[] args)
    {
        try{
            int port = 12345;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            Reader reader = new InputStreamReader(socket.getInputStream());
            char chars[] = new char[64];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len=reader.read(chars)) != -1) {
                sb.append(new String(chars, 0, len));
            }
            System.out.println("from client: " + sb);
            reader.close();
            socket.close();
            serverSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
