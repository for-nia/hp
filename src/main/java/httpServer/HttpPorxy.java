package httpServer;

import org.apache.activemq.protobuf.BufferInputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Fornia.fu on 2016/6/14.
 */
public class HttpPorxy
{
    public static void main(String[] args)
    {
        try{
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket client = null;
            while (true)
            {
                try{
                    char[] content = "hello world!".toCharArray();
                    String MIMEType = "text/html";
                    String header = "HTTP/1.0 200 OK\t\n"+
                        //"ServerFile:SingleHeader\r\n"+
                        "Server: OneFile 1.0\r\n"+
                        "Content-length: "+content.length+"\r\n"+
                        "Content-type: "+MIMEType+"\r\n\r\n";
                    Socket socket = serverSocket.accept();
                    OutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
                    InputStream inputStream = new BufferedInputStream(socket.getInputStream());
                    StringBuilder stringBuilder = new StringBuilder();
                    int ch=inputStream.read();
                    while (ch!=-1){
                        stringBuilder.append((char)ch);
                    }
                    String request = stringBuilder.toString();
                    System.out.println(request);
                    outputStream.write(header.getBytes("ASCII"));
                    outputStream.write(new String(content).getBytes("ASCII"));
                    outputStream.flush();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }

        }catch (Exception e){

        }
    }
}
