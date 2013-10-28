package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;

import config.ServiceState;
import config.SocketConnectConfig;

import serialized.RoomOfUser;

public class LeaveRoom {

	public static void main(String args[]){
		connect_LeaveRoom("user","roomId");
	}
	
	public static void connect_LeaveRoom(String user, String roomId){
		try{
			 URL url = new URL("http://"+SocketConnectConfig.IP+":8080/ACR_serverTest/LeaveRoomSession"); 
	            URLConnection connection = url.openConnection(); 
	              
	            connection.setDoOutput(true); // to be able to write. 
	            connection.setDoInput(true); // to be able to read. 
	              
	            ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream()); 
	            out.writeObject(new RoomOfUser(user,roomId)); 
	            out.close(); 
	            
	         // get service signal
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

	            String returnString="";
	            String str = "null";

	            while ((returnString = in.readLine()) != null) 
	            {
	                str = returnString;
	            }
	            in.close();
	            
	            if(str.equals(ServiceState.SUCCESS))
	            	System.out.println(str);
	            else
	            	System.out.println("exception in login.==>" + str);
	            
	            
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}