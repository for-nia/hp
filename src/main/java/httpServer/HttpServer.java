package httpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Fornia.fu on 2016/6/5.
 */
public class HttpServer implements Runnable
{

    private byte[] headers;
    private byte[] content;
    private int port=8888;
    public HttpServer(byte[] data,String MIMEType,int port)
    {
        this.content=data;
        this.port=port;
        String header = "HTTP/1.0 200 OK\t\n"+
            //"ServerFile:SingleHeader\r\n"+
            "Server: OneFile 1.0\r\n"+
            "Content-length: "+content.length+"\r\n"+
            "Content-type: "+MIMEType+"\r\n\r\n";
        try
        {
            this.headers=header.getBytes("ASCII");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

    }
    public void run()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket connection = null;
            try
            {
                while (true)
                {
                    connection = serverSocket.accept();
                    OutputStream outputStream = new BufferedOutputStream(connection.getOutputStream());
                    InputStream inputStream = new BufferedInputStream(connection.getInputStream());
                    // 暂时不解析http  request header
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true){
                        int c = inputStream.read();
                        if(c==-1){
                            break;
                        }
                        stringBuilder.append((char)c);
                    }
                    System.out.println(stringBuilder.toString());
                    if(stringBuilder.toString().indexOf("HTTP/")!=-1){
                        /*System.out.println("this is the response header:");
                        System.out.println(new String(this.headers));*/
                        outputStream.write(this.headers);
                    }
                    outputStream.write(this.content);
                    outputStream.flush();
                }
            }
            catch (Exception e)
            {
                System.out.println("Connect Exception:");
                e.printStackTrace();
            }
            finally
            {
                connection.close();
            }
        }
        catch (Exception e)
        {
            System.out.println("Server Exception :");
            e.printStackTrace();
        }
    }
}
