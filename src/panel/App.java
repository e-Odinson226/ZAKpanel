package panel;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
	public static void saveTlog(String username) {
		LocalDateTime dateObj = LocalDateTime.now();;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateinStr = dateObj.format(dateFormat);
		Panel.saveTimeLog(Panel.getUser(username), dateinStr);
	}

	public static void main(String[] args) {
		String username;
		String password;
		Scanner scn = new Scanner(System.in);
		Boolean key = true;
		new Panel();
		String order;
		
		Boolean keyWhile = true;
		while(key) {
			System.out.print("Username: "); username = scn.nextLine();
			
		//-------------------------------------------------	
			if(username.equals("admin")) {
				System.out.print("Password: "); password = scn.nextLine();
				if(Panel.checkPass(Panel.getUser(username), password)) {
					System.out.println("Welcome " + username);
					System.out.println("Options --> { q: quit    n: New user    u: Users list    p: Change Password    t: Time log ");
					saveTlog(username);;					
					do {
						System.out.print("Order: "); order = scn.nextLine();
						
						if(order.equals("q")) {
							keyWhile = false;
							username = "";	}
						
						if(order.equals("n")) {
							System.out.print("Enter new Username: "); username = scn.nextLine();
							System.out.print("Enter new Password: "); password = scn.nextLine();
							if(Panel.addUser(username, password))
								System.out.println("User successfully created :) ");	}
						
						if(order.equals("u")) 
							Panel.showUsersToAdmin();	
						
						if(order.equals("p")) {
							System.out.print("Enter new Password: "); password = scn.nextLine();
							Panel.changePass(Panel.getUser("admin"), password);		}
						
						if(order.equals("t")) {
							Panel.showTimelogs();	}
							
					}while(keyWhile == true);
				}
				keyWhile = true;
			}
		//-------------------------------------------------
			if(Panel.userExist(username) && !username.equals("admin")) {
				System.out.print("Password: "); password = scn.nextLine();
				if(Panel.checkPass(Panel.getUser(username), password)) {
					System.out.println("welcome " + username);
					System.out.println("Options --> { q: quit    u: Users list    p: Change Password    t: Time log ");
					saveTlog(username);;					
					do {
						System.out.print("Order: "); order = scn.nextLine();
						
						if(order.equals("q")) {
							keyWhile = false;		}
						
						if(order.equals("u")) 
							Panel.showUsers();	
						
						if(order.equals("p")) {
							System.out.print("Enter new Password: "); password = scn.nextLine();
							Panel.changePass(Panel.getUser(username), password);		}
						
						if(order.equals("t")) {
							Panel.showTimelogs();	}
							
					}while(keyWhile == true);
				}
			}
		//-------------------------------------------------
			if(username.equals("q"))
				key = false;
		}
	}
}
