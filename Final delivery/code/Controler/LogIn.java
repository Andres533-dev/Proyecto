

/*
package Proyecto.Code.src.Controler;
import Proyecto.Code.src.Model.*;
 * This method will verify the information requested (Email and password)
 * so that there is a way to set the profile up and other attributes
 *
 * @param1 preferably asks for email direction used in sign up
 * @param2 preferably asks for user's password first settled at the sign up


public class LogIn {
    public int validateInfo;
    public int isLogged;

    public LogIn(String[]answers) {
        this.isLogged = 0;
        this.validateInfo=0;
        this.verifyMail(answers[0]);
        this.verifyPassword(answers[1]);
    }


     * This method verifies for connection with the user so
     *  there's no need to log in every time the app is executed
     *

    public void verifyMail(String mail) {
        String arroba="@";
        String point=".";
        if(mail.contains(arroba) && mail.contains(point)) {
            validateInfo=1;
        }

    }
    public void verifyPassword(String password) {
        if (password.length()>3) {
            validateInfo=2;
        }
    }
    public boolean verifyUser(String[]answers) {
        if(validateInfo==2) {
            UserData user=new UserData(answers);
            isLogged=user.searchUser();
            return isLogged==2;
        }
        return false;
    }

    /*
     * This method will verify the information requested (Email and password)
     * so that there is a way to set the profile up and other attributes
     *
     * @param1 preferably asks for email direction used in sign up
     * @param2 preferably asks for user's password first settled at the sign up
     */
    /*
    1
    public boolean isLoggedIn() {
        if(!this.logged) {
            System.out.println("Please Log In");
            this.logIn(null, null, null);
            return false;
        }
        return true;
    }
    public void logIn(String input1, String input2, User user) { // Main method to Login into the app
        if(input1.equals(User.this.mail) && input2.equals(User.this.password)) {
            System.out.println("WelcomeController back "+ User.this.name);
            this.logged=true;
        }//Output for successful login
        else {
            System.out.println("Wrong username or password\nPlease try again");	//Message made for failed login
            this.logged=false;
        }
    }

*/
    /*
     * This method verifies for connection with the user so
     *  there's no need to login every time the app is executed
     *
     */






