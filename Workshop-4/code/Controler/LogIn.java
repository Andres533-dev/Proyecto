package Proyecto.Code.src.Controler;

public class Login {

    private boolean logged;

    public Login(boolean logged) {

        this.logged = logged;

    }

    /*
     * This method will verify the information requested (Email and password)
     * so that there is a way to set the profile up and other attributes
     *
     * @param1 preferably asks for email direction used in sign up
     * @param2 preferably asks for user's password first settled at the sign up
     */

    public void logIn(String input1, String input2, User user) { // Main method to Login into the app
        if(input1.equals(user.this.mail) && input2.equals(user.this.password)) {
            System.out.println("Welcome back "+ user.this.name);
            this.logged=true;
        }//Output for successful login
        else {
            System.out.println("Wrong username or password\nPlease try again");	//Message made for failed login
            this.logged=false;
        }
    }


    /*
     * This method verifies for connection with the user so
     *  there's no need to login every time the app is executed
     *
     */
    public boolean isLoggedIn() {
        if(!this.logged) {
            System.out.println("Please Log In");
            this.logIn(null, null, null);
            return false;
        }
        return true;
    }


    public void logOut() {
        //Quick method to stop using the app.
        this.logged = false;
    }
}

