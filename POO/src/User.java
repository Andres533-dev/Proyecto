import java.util.HashSet;
import java.util.Set;

//Quick library summary
/*HashSet is used to efficiently store and check if a particular item exists
in a collection of unique elements, without worrying about the order of those
elements. Think of it as a way to keep track of unique IDs, unique names, or 
any other set of distinct items where the order doesn't matter.*/

public class User {

	public String name;
	protected String password;
	protected String mail;
	protected long number;
	private Set<String> roles;	
	
	
	public User(){
		
		
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.number = number;
		this.roles = new HashSet<>();
	}
	
	public boolean verifyLogin(String input1, String input2) { // Main method to Login into the app
		if(input1.equals(this.mail) && input2.equals(this.password)) {
			System.out.println("Welcome back "+ this.name);
		return true;
	}//Output for successful login
		else {
			System.out.println("Wrong username or password\nPlease try again");	//Message made for failed login
			return false;
		}
	}
	
	
	//Methods to grant access to driver's information 
	public void grantRole() {
		roles.add("Passenger");
	}
	
	public void removeRole() {
		roles.remove("Passenger");
	}
	
	//Checking if the user is on an active trip
	public boolean hasRole(String role) {
		return roles.contains("Passenger");
	}

	public void requestTrip(/*Trip trip*/) {
		grantRole();
		//methods from trip
	}
}
