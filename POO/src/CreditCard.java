
public class CreditCard {
	
		public String debt;
		private String ccv;
		private String cardNumber;
		private String expDate;
	
	public CreditCard(String debt /*retrieves the ammount of money that the driver is asking for */) {
		
		this.debt = debt;
		this.ccv = ccv;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
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
}
