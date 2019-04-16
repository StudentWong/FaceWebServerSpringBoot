package socketconnect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketConnect {
    static private String host = "106.14.201.250";
    static private int port = 9999;

    public static void testDetect(String filename){
        try{
            Socket socket=new Socket(host,port);

            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            //由系统标准输入设备构造BufferedReader对象
            PrintWriter write=new PrintWriter(socket.getOutputStream());
            //由Socket对象得到输出流，并构造PrintWriter对象
            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            String readline;
            readline = "{\"cmd\":\"face_detect\",\"pic\":\"/root/container_share/face_copy/"+filename+"\"}";
            int len = readline.length();
            readline = String.format("%04d", len) + readline;
            write.println(readline);
            //将从系统标准输入读入的字符串输出到Server
            write.flush();
            //刷新输出流，使Server马上收到该字符串
            char[] outputstring = new char[10000];

            if(in.read(outputstring,0,4) == 4){
                System.out.println("receive:"+new String(outputstring, 0, 4));
                int recevLen = Integer.parseInt(new String(outputstring, 0, 4));
                if(in.read(outputstring,0,recevLen) == recevLen){
                    System.out.println("\n");
                    System.out.println("receive:"+new String(outputstring, 0, recevLen));
                }
            }



            write.close(); //关闭Socket输出流
            in.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
        }catch(Exception e) {
            System.out.println("can not listen to:"+e);//出错，打印出错信息
        }
    }
}
