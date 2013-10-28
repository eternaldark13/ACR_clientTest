package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import config.SocketConnectConfig;

public class ToMainTest {

	public static void main(String args[]){
		try{
            URL url = new URL("http://"+SocketConnectConfig.IP+":8080/ACR_serverTest/MainTest");
            URLConnection connection = url.openConnection();

            String inputString = "2";
            //inputString = URLEncoder.encode(inputString, "UTF-8");

            System.out.println("inputString: " + inputString);

            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(inputString);
            out.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String returnString="";
            int doubledValue =0;

            while ((returnString = in.readLine()) != null) 
            {
                doubledValue= Integer.parseInt(returnString);
            }
            in.close();


            
            System.out.println(doubledValue);

            }catch(Exception e)
            {
                e.printStackTrace();
            }
	}
}
