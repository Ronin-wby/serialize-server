package source;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

import source.DemoSerializer.Demo;

/**
 * UDP广播服务器搭建
 * 
 * @author Ronin_Wang
 *
 */

public class Servier {
	static String host;
	static int port;
	static String data;
	public static void main(String[] args) {
		host = "255.255.255.255"; //设置广播地址ַ
		port = 8888; // 设置端口
		System.out.println("------服务器启动------");
		System.out.println("-----输入要发送的消息-----");

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
						
				data = new GetJsonDemo().getdata();	
				
				System.out.println("11111");
				System.out.println(data);
				try {
					senddata();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
						
		};
		Timer timer = new Timer();  
		long delay = 0;  
		long intevalPeriod = 10 * 1000;  
		// schedules the task to be run in an interval  
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
		
		
	}//end main
	
	private static void senddata() throws Exception {

		byte[] byteArray = new DataSerialize().serialize(data);	

		InetAddress adds = InetAddress.getByName(host);
		DatagramSocket ds = new DatagramSocket();
		//一个中文字符和英文字符所占字节问题
		//解决方法： message.getBytes().length
		DatagramPacket dp = new DatagramPacket(byteArray, byteArray.length, adds, port);
		ds.send(dp);
		ds.close();
	}
	
	public static Demo deserialize(byte[] byteArray) throws Exception {
		
		Demo demo = DemoSerializer.Demo.parseFrom(byteArray);
		
		return demo;
		
	}
	
	

}// end class























