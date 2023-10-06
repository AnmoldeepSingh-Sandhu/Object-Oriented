import java.io.*;
import java.net.*;
import java.util.*;

public class HotelClient {

    public static void main(String[] args) throws IOException
	{

 
		final int SBAP_PORT = 8888;
		Socket s = new Socket("localhost", SBAP_PORT);

		InputStream instream = s.getInputStream();
		OutputStream outstream = s.getOutputStream();

		Scanner in = new Scanner(instream);
		PrintWriter out = new PrintWriter(outstream);

		Scanner input = new Scanner(System.in);

		boolean done = false;

		while(done == false){

			//String command = "";
			String user = "";

			
			//Menu
			System.out.println("Press R to make a reservation.");
			System.out.println("Press C to cancel your reservation");
			System.out.println("Press A to check for availibility.");
			System.out.println("Press Q to Quit");

			System.out.print("Choose a option from above menu: ");
			String option = input.next();

			char choice = option.toUpperCase().charAt(0);
			
			if(choice == 'R'){
				
				String command = "Reservation";
				System.out.println("Sending " + command + " Delails.");
				out.println(command);
				System.out.print("Please enter your Name: ");
				while(user.length() < 1){
					
					user = input.nextLine();
				}
				out.println(user);
				
				System.out.print("Please enter the first Day between 1 to 31: ");
				int firstDay = input.nextInt();
				
				out.println(firstDay);
				
				System.out.print("Please enter the Last Day between 1 to 31: ");
				int lastDay = input.nextInt();
				
				out.println(lastDay);
				
				out.flush();     

				String response = in.nextLine();
				System.out.println("Receiving: " + response);

				done = true;
			}else if(choice == 'C'){

				String command = "Cancel";
				System.out.println("Sending message to " + command + " the reservation");
				out.println(command);
				System.out.print("Please enter your Name: ");
				while(user.length() < 1){
					
					user = input.nextLine();
				}
				out.println(user);
				
				out.flush();     

				String response = in.nextLine();
				System.out.println("Receiving: " + response);
			
				done = true;

			}else if(choice == 'A'){

				String command = "Availability";
				System.out.println("Sending message to show " + command);
				out.println(command);
				out.flush();     
				
				String response = in.nextLine();
				System.out.println("Receiving: " + response);

				done = true;

			}else if(choice == 'Q'){

				String command = "QUIT";
				System.out.println("Sending " + command + " Command.");
				out.println(command);
				out.flush();    

				String response = in.nextLine();
				System.out.println("Receiving: " + response);
      
				done = true;

			}else{

				String command = "Invalid";
				System.out.println("Sending: " + command + " Command.");
				out.println(command);
				out.flush();     
				
				String response = in.nextLine();
				System.out.println("Receiving: " + response);

				done = true;

			}

			done = true;
		}

		input.close();

		in.close();

		s.close();
	}
    
}
