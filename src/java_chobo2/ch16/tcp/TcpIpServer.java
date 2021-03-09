package java_chobo2.ch16.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

public class TcpIpServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(7777);
			System.out.println(getTime() + "서버가 준비되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime()+"연결요청을 기다립니다.");
				Socket socket = ss.accept();
				System.out.println(getTime()+socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime()+"데이터를 전송했습니다.");
				
				dos.close();
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		
		return f.format(new Date());
	}

}
