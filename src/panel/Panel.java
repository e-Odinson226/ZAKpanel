package panel;

import java.util.HashMap;
import java.util.ArrayList;;

public class Panel {
//----------All users------------------------------
	protected static ArrayList<User> users = new ArrayList<User>();
	protected static ArrayList<HashMap<User, String>> timeLog = new ArrayList<HashMap<User, String>>();
	
	public Panel(){
		String username = "admin";
		String password = "admin";
		User admin = new User(username, password);
		users.add(admin);
		
	}

	public static User getUser(String username) {
		for(User user : users)
			if(user.getName().equals(username))
				return user;
		return null;
	}

	public static boolean userExist(String username) {
		for(User user : users)
			if(user.getName().equals(username))
				return true;
		return false;
	}

	public static boolean checkPass(User user, String password) {
		for(User userr : users)
			if(userr.getName().equals(user.getName()))
				if(userr.getPass().equals(password))
					return true;
		return false;
	}

	public static Boolean addUser(String username, String password) {
		User user = new User(username, password);
		for(User userr : users)
			if(userr.getName().equals(user.getName())) {
				System.out.println("Username already in use.");
				return false;
			}
		users.add(user);
		return true;
	}

	public static void showUsers() {
		for(User user : users)
			System.out.println(user.toStirng(" "));
		
	}

	public static void showUsersToAdmin() {
		for(User user : users)
			System.out.println(user.toStirng("admin"));
		
	}

	public static void changePass(User user, String password) {
		for(User userr : users)
			if(userr.getName().equals(user.getName()))
					userr.setPass(password);
	}

	public static void showTimelogs() {
		for(HashMap<User, String> info : timeLog)
			for(User user : info.keySet())
				System.out.println(user.getName() + " || " + info.get(user));
		
	}

	public static void saveTimeLog(User user, String dateinStr) {
		HashMap<User, String> info = new HashMap<User, String>();
		info.put(user, dateinStr);
		timeLog.add(info);	
	}

}
