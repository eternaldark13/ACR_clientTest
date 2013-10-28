package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import config.ServiceState;
import config.SocketConnectConfig;

public class CreateRoomTest {

	public static void main(String args[]){
		try{
			URL url = new URL("http://"+SocketConnectConfig.IP+":8080/ACR_serverTest/CreateRoomTest");
            URLConnection connection = url.openConnection();
            
            connection.setDoOutput(true); // to be able to write.
            connection.setDoInput(true); // to be able to read.
            
            // 新增RoomId
            String inputString = "roomTest";
            System.out.println("inputString: " + inputString);
            
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(inputString);
            out.close();
            
            // 取得成功資訊
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String returnString="";
            String str = "null";

            while ((returnString = in.readLine()) != null) 
            {
                str = returnString;
            }
            in.close();
            
            if(str.equals(ServiceState.CREATE_ROOM_EXIST_FAILED)){
            	System.out.println("Room Exist");
            }
            else
            	System.out.println("Room created");

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
