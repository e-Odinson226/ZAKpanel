package panel;

public class User {
	private String username;
	private String password;
	
	User(String username, String password){
		this.username = username;
		this.password = password;		
	}
	
//-------------------------------------
	
	public String getName() {
		return username;	}
	
	public String getPass() {
		return password;	}
	
	public void setPass(String password) {
		this.password = password;	}
//-------------------------------------
	
	public String toStirng(String user) {
		if(user.equals("admin"))
			return "Username: '" + username + "'    Password: '" + password + "'";
		else if(!user.equals("admin"))
			return "Username: '" + username + "'";
		else
			return "Wrong input";
	}
}
