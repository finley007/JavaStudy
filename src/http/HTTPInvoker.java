package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HTTPInvoker {
	
	public static final String GET_URL = "http://qt.gtimg.cn/q=ff_sh600278"; 
    public static final String POST_URL = " http://localhost:8080/demo/  "; 

    public static void readContentFromGet() throws IOException { 
           String getURL = GET_URL ; 
           URL getUrl = new URL(getURL); 
           HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection(); 
           connection.connect(); 
           BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
           System.out.println(" ============================= "); 
           System.out.println(" Contents of get request "); 
           System.out.println(" ============================= "); 
           String lines; 
           while ((lines = reader.readLine()) != null) { 
                   System.out.println(lines); 
           } 
           reader.close(); 
           connection.disconnect(); 
           System.out.println(" ============================= "); 
           System.out.println(" Contents of get request ends "); 
           System.out.println(" ============================= "); 
    } 

    public static void readContentFromPost() throws IOException { 
           URL postUrl = new URL(POST_URL); 
           HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection(); 
           connection.setDoOutput(true);             
           connection.setDoInput(true); 
           connection.setRequestMethod(" POST "); 
           connection.setUseCaches(false); 
           connection.setInstanceFollowRedirects(true); 
           connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
           DataOutputStream out = new DataOutputStream(connection.getOutputStream()); 
           String content = " firstname= "+URLEncoder.encode("", " utf-8 "); 
           out.writeBytes(content); 
           out.flush(); 
           out.close(); // flush and close 
           BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
           String line; 
           System.out.println(" ============================= "); 
           System.out.println(" Contents of post request "); 
           System.out.println(" ============================= "); 
           while ((line = reader.readLine()) != null) { 
                   System.out.println(line); 
           } 
           System.out.println(" ============================= "); 
           System.out.println(" Contents of post request ends "); 
           System.out.println(" ============================= "); 
           reader.close(); 
           //connection.disconnect(); 
    } 

    public static void main(String[] args) { 
           // TODO Auto-generated method stub 
           try { 
                   readContentFromGet(); 
//                   readContentFromPost(); 
           } catch (IOException e) { 
                   // TODO Auto-generated catch block 
                   e.printStackTrace(); 
           } 
    } 

}
