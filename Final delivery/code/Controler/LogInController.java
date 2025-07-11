
package Proyecto.Code.src.Controler;

import Proyecto.Code.src.Model.User;

import java.util.ArrayList;
public class LogInController {
    public int success;
    protected String mail;
    protected String password;
    public LogInController(ArrayList<String> answers) {
        success=0;
        this.verifyInfo(answers);
        this.verifyMail(answers.get(0));
        this.verifyPassword(answers.get(1));
        this.register();

    }
    public void verifyInfo(ArrayList<String> answers){
        if (!answers.get(0).isEmpty() && !answers.get(1).isEmpty()) {
            success=1;
        }
    }
    public void register() {
        User user=new User(this.mail,this.password);
        if( success==3){
            if(user.logIn()) {
                success = 4;
            }
        }
    }
    /*
     * 	This method sets the password for a variable while restraining it
     *  in case it´s too short to be secure
     */
    public void verifyPassword(String password) {
        if (password.length() > 5 && success!=0){
            this.password = password;
            success=3;
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
            success=2;
        }
    }
    /*
     * 	This method sets the number for a variable while checking if
     *  the number length is in the correct format (local colombian number)
     */
}
