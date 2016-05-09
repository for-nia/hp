package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fornia.fu on 2016/2/17.
 */
public class NioTest
{

    public static void main(String[] args){
        try{
            FileInputStream fileInputStream = new FileInputStream("/data/hello.txt");
            /*StringBuffer sb = new StringBuffer();
            int cha = fileInputStream.read();
            while (cha>0){
                char c = (char)cha;
                sb.append(c);
               // sb.append(cha);
                cha=fileInputStream.read();
            }
            String str = sb.toString();
            System.out.println(str);
            System.out.println("====================");*/

            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            StringBuilder stringBuilder = new StringBuilder();

            FileOutputStream fileOutputStream = new FileOutputStream("/data/hello.txt");
            fileOutputStream.getChannel().write(byteBuffer.wrap("hello worledddddddd!".getBytes()));
            while (true){
                byteBuffer.clear();
                int flag = fileChannel.read(byteBuffer);
                if(flag==-1){
                    break;
                }
                byte[] bytes = byteBuffer.array();
                /*for(byte b:bytes){
                    stringBuilder.append((char)b);
                }*/
                String str = new String(bytes);
                str.getBytes();
                stringBuilder.append(str);
            }

            System.out.println(stringBuilder.toString());


            Selector selector = Selector.open();

            /*ByteBuffer buffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer = CharBuffer.allocate(128);
            FileChannel fileChannel = fileInputStream.getChannel();
            byte[] bytes = buffer.array();
            FileOutputStream fileOutputStream = new FileOutputStream("/data/test.txt");
            FileChannel outChannel = fileOutputStream.getChannel();
            List lsit = new LinkedList();
            while(true){
                buffer.clear();
                int i = fileChannel.read(buffer);
                if(i==-1){
                    break;
                }
                byte b = buffer.get();
                char ch = (char)b;
                buffer.flip();
                outChannel.write(buffer);
            }

            String decoded = new String(bytes, "UTF-8");
            System.out.println(decoded);*/
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
