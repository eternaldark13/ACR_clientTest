package test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import serialized.ChatMsg;
import serialized.RoomList;
import serialized.RoomOfUser;

import config.ServiceState;
import config.SocketConnectConfig;

public class ChatListenTest {

	private static int port = 8081;
	
	public static void main(String args[]){
		Socket client = new Socket();
        InetSocketAddress isa = new InetSocketAddress(SocketConnectConfig.IP, port);
        try {
            client.connect(isa, 15000);
            
            ObjectOutputStream objOut = new ObjectOutputStream(client.getOutputStream());
                        
            //送出object            
            objOut.writeObject(new RoomOfUser("測試員"+new Date().getSeconds(),"roomTest"));
            //objOut.close();
            System.out.println("送出Object成功");
            //objOut = null ;
                        
            // 取得成功資訊
           /* BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String returnString="";
            String str = "null";

            while ((returnString = in.readLine()) != null) 
            {
                str = returnString;
            }
            System.out.println("recieve "+str);*/
            
            // 送出signal
            /*OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
    		String inputString = ServiceState.READY_SIGNAL;            
            out.write(inputString);
            System.out.println("送出Signal成功");
            //out.close();
            */
            
            while(client.isConnected()){

                try{
            		System.out.println("等待訊息中");

                    ObjectInputStream objIn = new ObjectInputStream(client.getInputStream());                	
                    ChatMsg chatMsg = (ChatMsg) objIn.readObject();
                    
                    System.out.println("收到的訊息 "+chatMsg.getMsg());
                    
                    /*OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
            		String inputString = ServiceState.READY_SIGNAL;            
                    out.write(inputString);
                    System.out.println("送出Signal成功");*/
                    
                    //out.flush();
                    //out.close();
                    /*ObjectInputStream objIn2 = new ObjectInputStream(client.getInputStream());                	
                    ChatMsg chatMsg2 = (ChatMsg) objIn2.readObject();
                    
                    System.out.println("收到的訊息 "+chatMsg2.getMsg());*/
            	}catch(Exception e){
            		e.printStackTrace();
            		break;
            	}
            }
                        
            //in.close();
            
            client.close();
            client = null ;
 
        } catch (java.io.IOException e) {
            System.out.println("Socket連線有問題 !");
            System.out.println("IOException :" + e.toString());
            e.printStackTrace();
        }
	}
}
