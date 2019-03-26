import java.util.*;
import java.net.*;
import java.io.*;
public class Server {
	public static void main(String arg[]) throws Exception{
		DatagramSocket socket=new DatagramSocket(4000);
        System.out.println("Receiver is ready......(press ctrl+c to terminate...)...");
		while(true){
		System.out.println("Waiting.....");
		byte[] msg=new byte[100];
		DatagramPacket receive_packet=new DatagramPacket(msg,100);
		socket.receive(receive_packet);
		String received_message=new String(receive_packet.getData());
		System.out.println("Sender:"+received_message.trim());
		Thread.sleep(1000);
		        System.out.print("you:");
				BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
				String send_message=bf.readLine();
				byte[] msg2=send_message.getBytes();
				DatagramPacket send_packet=new DatagramPacket(msg2,msg2.length,InetAddress.getLocalHost(),3000);
				socket.send(send_packet);
				if(!socket.isConnected()){
					System.out.println("Connection LOst.....");
					break;
				}

	}
	}
}