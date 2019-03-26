import java.util.*;
import java.net.*;
import java.io.*;
public class Client{
	public static void main(String arg[]) throws Exception{
		DatagramSocket socket=new DatagramSocket(3000);
		System.out.println("Sender..........");
		while(true){
		System.out.print("You:");
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String send_message=bf.readLine();
		byte[] msg=send_message.getBytes();
		DatagramPacket send_packet=new DatagramPacket(msg,msg.length,InetAddress.getLocalHost(),4000);
		socket.send(send_packet);
		Thread.sleep(1000);
		        System.out.println("Waiting.....");
		        byte[] msg2=new byte[100];
				DatagramPacket received_packet=new DatagramPacket(msg2,100);
				socket.receive(received_packet);
				String received_message=new String(received_packet.getData());
		        System.out.println("Sender:"+received_message.trim());
		        if(!socket.isConnected()){
					        System.out.println("connection Lost.....");
									break;
				}
	}
	}
}