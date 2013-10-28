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
                        
            //�e�Xobject            
            objOut.writeObject(new RoomOfUser("���խ�"+new Date().getSeconds(),"roomTest"));
            //objOut.close();
            System.out.println("�e�XObject���\");
            //objOut = null ;
                        
            // ���o���\��T
           /* BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String returnString="";
            String str = "null";

            while ((returnString = in.readLine()) != null) 
            {
                str = returnString;
            }
            System.out.println("recieve "+str);*/
            
            // �e�Xsignal
            /*OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
    		String inputString = ServiceState.READY_SIGNAL;            
            out.write(inputString);
            System.out.println("�e�XSignal���\");
            //out.close();
            */
            
            while(client.isConnected()){

                try{
            		System.out.println("���ݰT����");

                    ObjectInputStream objIn = new ObjectInputStream(client.getInputStream());                	
                    ChatMsg chatMsg = (ChatMsg) objIn.readObject();
                    
                    System.out.println("���쪺�T�� "+chatMsg.getMsg());
                    
                    /*OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
            		String inputString = ServiceState.READY_SIGNAL;            
                    out.write(inputString);
                    System.out.println("�e�XSignal���\");*/
                    
                    //out.flush();
                    //out.close();
                    /*ObjectInputStream objIn2 = new ObjectInputStream(client.getInputStream());                	
                    ChatMsg chatMsg2 = (ChatMsg) objIn2.readObject();
                    
                    System.out.println("���쪺�T�� "+chatMsg2.getMsg());*/
            	}catch(Exception e){
            		e.printStackTrace();
            		break;
            	}
            }
                        
            //in.close();
            
            client.close();
            client = null ;
 
        } catch (java.io.IOException e) {
            System.out.println("Socket�s�u�����D !");
            System.out.println("IOException :" + e.toString());
            e.printStackTrace();
        }
	}
}
