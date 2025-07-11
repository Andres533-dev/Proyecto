/*
package Proyecto.Code.src.Controler;
import Proyecto.Code.src.Model.User;

import java.util.List;

public class CreditCard {
	
		public String debt;
		private String ccv;
		private String cardNumber;
		private String expDate;
	
	public CreditCard(List<String> answers) { //retrieves the ammount of money that the driver is asking for
		
		this.debt = answers.get(0);
		this.ccv = answers.get(1);
		this.cardNumber = answers.get(2);
		this.expDate = answers.get(3);
	}
	
	public boolean payment(String input1, String input2, String input3) {
		if(input1.equals(this.ccv) && input2.equals(this.cardNumber) && input3.equals(this.expDate)) {
			System.out.println("Your payment has been succesful! ");
		return true;
	}//Output for successful payment
		else {
			System.out.println("Check back your information, it might be wrong!");	//Message made for failed 
			return false;
		}
	}
	
	
/*
 * Group of setter methods, getters are a no need since Credit card information 
 * is quite risky to manipulate, ccv will be elaborated to the future 
 */
	
	
	/* @param1 User user to verify roles
	 * @param2 New CC number 
	 */
/*
	public String setCardNumber(User user, String newCardNumber//input for the new CCnumber) {
		
		if(user.hasRole("Owner")){return this.cardNumber=newCardNumber;} //Verifies ownership
			// Switches values
		return "Can't modify information"; //Denied access
	}
	
	public String setExpDate(User user, String newExpDate//input for the new CCnumber) {
		
		if(user.hasRole("Owner")) //Verifies ownership
			
			return this.expDate=newExpDate; // Switches values
		return "Can't modify information"; //Denied access
	}
	
}

 */