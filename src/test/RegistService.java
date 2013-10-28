package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;

import serialized.Account;
import config.ServiceState;
import config.SocketConnectConfig;

public class RegistService {

	public static void main(String args[]){
		try{
			URL url = new URL("http://"+SocketConnectConfig.IP+":8080/ACR_serverTest/RegistTest");
            URLConnection connection = url.openConnection();
            
            connection.setDoOutput(true); // to be able to write.
            connection.setDoInput(true); // to be able to read.

            Account acc = new Account("�b��2","123");
            
            ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
            out.writeObject(acc);
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
            	System.out.println("exception in regist.==>" + str);
            
            System.gc();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
