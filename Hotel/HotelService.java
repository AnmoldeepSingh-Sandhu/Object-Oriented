import java.io.*;
import java.net.*;
import java.util.*;

public class HotelService implements Runnable{

    private Socket s;
	private Scanner in;
	private PrintWriter out;
	private Hotel hotel;
	
	
	public HotelService(Socket aSocket, Hotel aHotel)
	{
		s = aSocket;
		hotel = aHotel;

		System.out.println("s = " + s);
	}

	@Override
	public void run()
	{
		try
		{

			try
			{
				in = new Scanner(s.getInputStream());
				out = new PrintWriter(s.getOutputStream());
				doService();
			}
			finally
			{
				s.close();
			}
		}
	
		catch(IOException exception)
		{
			exception.printStackTrace();
		}

	}

	public void doService() throws IOException
	{
		while (true)
		{
			String command = in.nextLine();

			System.out.println("command doservice = " + command);

			if (!in.hasNext()){
				return;}

			

			if (command.equalsIgnoreCase("QUIT")){
				out.println("Thank you so much for coming here.");
				return;}
			else{
				executeCommand(command);
			}
		}
	}

	public void executeCommand(String command)
	{

		System.out.println("command = " + command);

		if (command.equalsIgnoreCase("Reservation"))
		{ 

			String user = in.nextLine();
			int first = in.nextInt();
			int last = in.nextInt();

			System.out.println("user = " + user);
			System.out.println("first = " + first);
			System.out.println("last = " + last);

			out.println("Your Reservation Details: " + hotel.requestReservation(user,first,last));
			out.flush();

		}else if(command.equalsIgnoreCase("Cancel")){

			String user = in.nextLine();

			// hotel.cancelReservation(user);

			out.println("Your Cancellation Details: " + hotel.cancelReservation(user));
			out.flush();
		}else if(command.equalsIgnoreCase("Availability")){

			// hotel.toString();
			out.println(hotel.toString());
			out.flush();

		}else if(command.equalsIgnoreCase("QUIT")){

			out.println("Thank you so much for coming here.");
			out.flush();

		}else{

			out.println("This is not a valid Option.");
			out.flush();

		}
		
     
		
	}
    
}
