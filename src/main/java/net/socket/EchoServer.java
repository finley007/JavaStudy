package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	private int port = 8888;
	private ServerSocket serverSocket;
	
	public EchoServer() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Server start..");
	}
	
	public String echo(String msg){
		return "echo:" + msg;
	}
	
	private PrintWriter getWriter(Socket socket) throws IOException{
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut);
	}
	
	private BufferedReader getReader(Socket socket) throws IOException{
		InputStream socketIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(socketIn));
	}
	
	public void service(){
		while(true){
			Socket socket = null;
			try{
				socket = serverSocket.accept();
				System.out.println("New connection accepted" + socket.getInetAddress() + ":" + socket.getPort());
				BufferedReader br = getReader(socket);
				PrintWriter pw = getWriter(socket);
				
				String msg = null;
				while(( msg = br.readLine()) != null){
					System.out.println(msg);
					pw.println(echo(msg));
					pw.flush();
					if(msg.equals("bye"))
						break;
				}
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
					if(socket != null)
						socket.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[])throws Exception{
		new EchoServer().service();
	}
}
