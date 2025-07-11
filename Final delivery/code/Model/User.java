package Proyecto.Code.src.Model;

//Quick library summary
/*HashSet is used to efficiently store and check if a particular item exists
in a collection of unique elements, without worrying about the order of those
elements. Think of it as a way to keep track of unique IDs, unique names, or 
any other set of distinct items where the order doesn't matter.*/

import java.util.ArrayList;

public class User {

	protected String name;
	protected String password;
	protected String mail;
	protected String lastName;
	protected ArrayList<String> information;
	/*
	 * Roles mentioned throughout the code 
	 * Owner=account owner
	 * Admin=App administrator
	 * Driver=Selected driver for the trip
	 */
	
	
	public User(String name,String lastName ,String mail,String password) {
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.lastName = lastName;
		this.information = new ArrayList<>();
		this.passInformationSignUp();
	}
	public User(String mail,String password) {
		this.mail = mail;
		this.password = password;
		this.information = new ArrayList<>();
		this.passInformationLogIn();
	}
	
	/*
	 *This method will verify the information requested (Email and password)
	 *so that there is a way to set the profile up and other attributes
	 * @param1 preferably asks for email direction used in sign up
	 * @param2 preferably asks for user's password first settled at the sign-up
	 */
	/*
	public boolean verifyLogin(String input1, String input2) { // Main method to Login into the app
		if(input1.equals(this.mail) && input2.equals(this.password)) {
			System.out.println("WelcomeController back "+ this.name);
		return true;
	}//Output for successful login
		else {
			System.out.println("Wrong username or password\nPlease try again");	//Message made for failed login
			return false;
		}
	}
	q
	 */
	
	/*
	 *Getter methods fundamentally for the Driver class and administrator users
	 *This methods follow the same logic:
	 *  Verifies whether it s and Admin or the Driver willing to take the Trip
	 *    if(condition)
	 *    return info;
	 *  When the condition isn't met the program will display an error message
	 */
	
	protected ArrayList<String> passInformationSignUp() {
		 information.add(getName());
		 information.add(getLastName());
		 information.add(getMail());
		 information.add(getPassword());
		 return information;
	}
	protected ArrayList<String> passInformationLogIn() {
		information.add(getMail());
		information.add(getPassword());
		return information;
	}
	public boolean signUp() {
		UserData newUser = new UserData(passInformationSignUp());
		int exist= newUser.searchUser();
		if(exist==2) {
			return false;
		}
		else {
			newUser.addUser();
			return true;

		}
	}
	public boolean logIn() {
		UserData newUser = new UserData(passInformationLogIn());
		int exist = newUser.searchUser();
        return exist == 2;
	}
	public String getName() {return this.name;}
	
	public String getMail() {return this.mail;}

	public String getLastName() {return this.lastName;}

	public String getPassword() {return this.password;}

	/*
	 * Setter methods so that the user can change his data depending on the situation
	 * They follow a close logic to getters since 
	 *  if(Role){
	 *  	if(newData!=this.data)
	 * 			return this.data=newData;
	 * 		else 
	 * 			return "Same input";
	 * 	else
	 *  	return "Not eligible";
	 */
	/*
	h
	public String setName(User user, String newName) {
		if(user.hasRole("Admin") || user.hasRole("Owner")) {
			if(!Objects.equals(newName, this.name)){
				return this.name=newName;
			}

			
			return "The new input is the same as the old one";
		}
		
		return "You can't modify this information";
		
	}
	
	public String setMail(User user, String newMail) {
		if(user.hasRole("Admin") || user.hasRole("Owner")) {
			if(!Objects.equals(newMail, this.mail)){
				return this.mail=newMail;
			}
			
			return "You are using the same email right now";
		}
		
		return "You can't modify this information";
		
	}
	
	public String setPassword(User user, String newPassword) {
		if(user.hasRole("Admin") || user.hasRole("Owner")) {
			if(!Objects.equals(newPassword, this.password)){
			return this.password=newPassword;
			}
			return "You have already used this password";
		}
		
		return "You can't modify this information";
		
	}
	
	public String setNumber(User user, String newLastName) {
		if(user.hasRole("Admin") || user.hasRole("Owner")) {
			if(!Objects.equals(newLastName, this.lastName))
			return this.lastName=newLastName;
			else{
			return "This is already your current phone number";
			}
		}
		
		return "You can't modify this information";
		
	}

	 */
	
/*
	
	//Methods to grant access to driver's information, mainly used during a travel request
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

	public void requestTrip() {
		grantRole();
		//methods from trip
	}
	h
 */
}
