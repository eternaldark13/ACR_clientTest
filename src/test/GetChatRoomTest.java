package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Set;

import serialized.RoomList;
import config.ServiceState;
import config.SocketConnectConfig;

public class GetChatRoomTest {

	static OutputStreamWriter writer;
	//static URLConnection connection;
	
	public static void main(String args[]) throws IOException{
		try{
			URL url = new URL("http://"+SocketConnectConfig.IP+":8080/ACR_serverTest/GetRoomListTest");
			URLConnection connection = url.openConnection();
            
            connection.setDoOutput(true); // to be able to write.
            connection.setDoInput(true); // to be able to read.


            String inputString = ServiceState.READY_SIGNAL;
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(inputString);
            out.close();

//***********************************
            ObjectInputStream objIn = new ObjectInputStream(connection.getInputStream());
            RoomList room = (RoomList) objIn.readObject();
            
            System.out.println(room.roomList.size());
            
            Set<String> roomSet = room.roomList.keySet();
            Iterator it = roomSet.iterator();
            
            while(it.hasNext()){
            	System.out.println(it.next());
            }
            
            //************************
            
           /* BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String returnString="";
            int doubledValue =0;

            while ((returnString = in.readLine()) != null) 
            {
                doubledValue= Integer.parseInt(returnString);
            }
            

            
            System.out.println(doubledValue);
            System.out.println("done");

            in.close();*/
		}catch(Exception e){
			e.printStackTrace();
			
			/*writer = new OutputStreamWriter(connection.getOutputStream());

			writer.write(ServiceState.EXCEPTION);
			writer.flush();
			writer.close(); */           			
			
		}
	}
}
