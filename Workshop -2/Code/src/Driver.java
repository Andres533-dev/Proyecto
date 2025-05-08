package Proyecto.Code.src;


/*Subclass from User since they both require credentials to login (mail and password) &
  basic info for communication (name and number)
  */
public class Driver extends User {

	//Own attributes
		private String price;
		
		
	public Driver(/*calls the class vehicle to get information about the vehicle*/){
		
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.number = number;
		this.price = price;

	}
	
	//returns driver price (should be used to give the user/payment the amount to pay
	public String getPrice() {
		return this.price;
	}
	
	
	
	public void getname(User user) {
		if(user.hasRole("Passenger")) {
			System.out.println("Name: " + this.name);
		}
		else 
			System.out.println("You don't have permission to check this info");
	}
}
