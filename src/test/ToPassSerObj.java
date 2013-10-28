package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;

import config.SocketConnectConfig;
import serialized.TestObj;

public class ToPassSerObj {

	public static void main(String args[]){
		try{
			URL url = new URL("http://"+SocketConnectConfig.IP+":8080/ACR_serverTest/PassSerObj");
            URLConnection connection = url.openConnection();
            
            connection.setDoOutput(true); // to be able to write.
            connection.setDoInput(true); // to be able to read.

            TestObj names = new TestObj("¤¤¤å",2);
            
            ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
            out.writeObject(names);
            out.close();

            // OK signal
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String returnString="";
            String str = "null";

            while ((returnString = in.readLine()) != null) 
            {
                str = returnString;
            }
            in.close();
            
            System.out.println(str);
            System.gc();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
