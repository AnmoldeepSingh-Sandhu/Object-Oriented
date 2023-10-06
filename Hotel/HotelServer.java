import java.io.*;
import java.net.*;

public class HotelServer {

    public static void main(String[] args) throws IOException
    {
		Hotel hotel = new Hotel();
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("Hotel is open");
	        
		while(true)
		{
			// System.out.println("Waiting for guests.....");
			Socket socket = serverSocket.accept();
			
			System.out.println("Welcome to our Hotel.");

			HotelService Reservation = new HotelService(socket, hotel);
			

			Thread t = new Thread(Reservation);
			t.start();

		}
       
	} 
    
}
