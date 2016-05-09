/**
 * Created by Fornia.fu on 2015/11/5.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*************************************
 * ???????????????????
 *************************************
 */


public class HttpProxy extends Thread {
    static public int CONNECT_RETRIES=5;
    static public int CONNECT_PAUSE=5;
    static public int TIMEOUT=50;
    static public int BUFSIZ=1024;
    static public boolean logging = false;
    static public OutputStream log=null;
    // ???????????Socket
    protected Socket socket;
    // ?????????????????
    static private String parent=null;
    static private int parentPort=-1;
    static public void setParentProxy(String name, int pport) {
        parent=name;
        parentPort=pport;
    }

    // ?????Socket????????????????
    public HttpProxy(Socket s) { socket=s; start(); }

    public void writeLog(int c, boolean browser) throws IOException {
        log.write(c);
    }

    public void writeLog(byte[] bytes,int offset, int len, boolean browser) throws IOException {
        for (int i=0;i<len;i++) {
            writeLog((int) bytes[offset + i], browser);
        }
    }


    // ????????????????????
    // ???????豸
    // ??????????????
    public String processHostName(String url, String host, int port, Socket sock) {
        java.text.DateFormat cal=java.text.DateFormat.getDateTimeInstance();
        System.out.println(cal.format(new java.util.Date()) + " - " + url + " "
                + sock.getInetAddress()+"\n");
        return host;
    }



    // ??в????????
    public void run() {
        String line;
        String host;
        int port=80;
        Socket outbound=null;
        try {
            socket.setSoTimeout(TIMEOUT);
            InputStream is=socket.getInputStream();
            OutputStream os=null;
            try {
                // ????????е?????
                line="";
                host="";
                int state=0;
                boolean space;
                while (true) {
                    int c=is.read();
                    if (c==-1) break;
                    if (logging) writeLog(c,true);
                    space=Character.isWhitespace((char)c);
                    switch (state) {
                        case 0:
                            if (space) continue;
                            state=1;
                        case 1:
                            if (space) {
                                state=2;
                                continue;
                            }
                            line=line+(char)c;
                            break;
                        case 2:
                            if (space) continue; // ?????????????
                            state=3;
                        case 3:
                            if (space) {
                                state=4;
                                // ???????????????
                                String host0=host;
                                int n;
                                n=host.indexOf("//");
                                if (n!=-1) host=host.substring(n+2);
                                n=host.indexOf('/');
                                if (n!=-1) host=host.substring(0,n);
                                // ???????????????
                                n=host.indexOf(":");
                                if (n!=-1) {
                                    port=Integer.parseInt(host.substring(n+1));
                                    host=host.substring(0,n);
                                }
                                host=processHostName(host0,host,port,socket);
                                if (parent!=null) {
                                    host=parent;
                                    port=parentPort;
                                }
                                int retry=CONNECT_RETRIES;
                                while (retry--!=0) {
                                    try {
                                        outbound=new Socket(host,port);
                                        break;
                                    } catch (Exception e) { }
                                    // ???
                                    Thread.sleep(CONNECT_PAUSE);
                                }
                                if (outbound==null) break;
                                outbound.setSoTimeout(TIMEOUT);
                                os=outbound.getOutputStream();
                                os.write(line.getBytes());
                                os.write(' ');
                                os.write(host0.getBytes());
                                os.write(' ');
                                pipe(is,outbound.getInputStream(),os,socket.getOutputStream());
                                break;
                            }
                            host=host+(char)c;
                            break;
                    }
                }
            }
            catch (IOException e) { }

        } catch (Exception e) { }
        finally {
            try { socket.close();} catch (Exception e1) {}
            try { outbound.close();} catch (Exception e2) {}
        }
    }


    void pipe(InputStream is0, InputStream is1,
              OutputStream os0,  OutputStream os1) throws IOException {
        try {
            int ir;
            byte bytes[]=new byte[BUFSIZ];
            while (true) {
                try {
                    if ((ir=is0.read(bytes))>0) {
                        os0.write(bytes,0,ir);
                        if (logging) writeLog(bytes,0,ir,true);
                    }
                    else if (ir<0)
                        break;
                } catch (InterruptedIOException e) { }
                try {
                    if ((ir=is1.read(bytes))>0) {
                        os1.write(bytes,0,ir);
                        if (logging) writeLog(bytes,0,ir,false);
                    }
                    else if (ir<0)
                        break;
                } catch (InterruptedIOException e) { }
            }
        } catch (Exception e0) {
            System.out.println("Pipe??: " + e0);
        }
    }


    static public void startProxy(int port,Class clobj) {
        ServerSocket ssock;
        Socket sock;
        try {
            ssock=new ServerSocket(port);
            while (true) {
                Class [] sarg = new Class[1];
                Object [] arg= new Object[1];
                sarg[0]=Socket.class;
                try {
                    java.lang.reflect.Constructor cons = clobj.getDeclaredConstructor(sarg);
                    arg[0]=ssock.accept();
                    cons.newInstance(arg); // ????HttpProxy??????????????
                } catch (Exception e) {
                    Socket esock = (Socket)arg[0];
                    try { esock.close(); } catch (Exception ec) {}
                }
            }
        } catch (IOException e) {
        }
    }


    // ????????main????
    static public void main(String args[]) {
        System.out.println("????808?????????????\n");
        HttpProxy.log=System.out;
        HttpProxy.logging=false;
        HttpProxy.startProxy(808,HttpProxy.class);
    }

    public static void updatePerson(Person p){

        p.setAge(5);

    }
}

