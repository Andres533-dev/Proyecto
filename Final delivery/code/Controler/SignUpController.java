package Proyecto.Code.src.Controler;
import Proyecto.Code.src.Model.User;

import java.util.ArrayList;

public class SignUpController {

    public int success;
    private String name,lastName ,password, mail;

    public SignUpController(ArrayList<String> answers){
        success=0;
        this.verifyInfo(answers);
        this.verifyName(answers.get(0));
        this.verifyLastName(answers.get(1));
        this.verifyMail(answers.get(2));
        this.verifyPassword(answers.get(3));
        this.register();
    }
    public void verifyInfo(ArrayList<String> answers){
        if (!answers.get(0).isEmpty() && !answers.get(1).isEmpty() && !answers.get(2).isEmpty() && !answers.get(3).isEmpty()) {
            success=1;
        }
    }
    public void register() {
        User user=new User(this.name,this.lastName,this.mail,this.password);
        if( success==5){
            if(user.signUp()) {
                success = 6;
            }
        }
    }

    /* This method can be used to further verify whether the user
     * has already signedUp to follow up and use the app
     */

    /*
     * 	This method sets the name for the variable so that it can later be
     *  validated and used to give the user a name.
     */
    public void verifyName(String name){
        if(name.length() > 3 && success!=0) {
            this.name = name;
            success=2;
        }
    }
    public void verifyLastName(String lastName){
        if(lastName.length() > 3 && success!=0) {
            this.lastName = lastName;
            success=3;
        }
    }
    /*
     * 	This method sets the password for a variable while restraining it
     *  in case it´s too short to be secure
     */
    public void verifyPassword(String password) {
        if (password.length() > 5 && success!=0){
            this.password = password;
            success=5;
        }
    }

    /*
     * 	This method sets the mail for a variable so that it can be
     *  set for the users mail.
     */
    public void verifyMail(String mail){
        String arroba="@";
        String point=".";
        if(mail.contains(arroba) && mail.contains(point) && success!=0){
            this.mail=mail;
            success=4;
        }
    }
    /*
     * 	This method sets the number for a variable while checking if
     *  the number length is in the correct format (local colombian number)
     */

}
