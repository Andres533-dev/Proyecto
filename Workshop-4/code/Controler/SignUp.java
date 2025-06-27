package Proyecto.Code.src.Controler;
import java.util.List;
public class SignUp {

    private boolean success;
    private String name,lastName ,password, mail;
    User user=new User();

    public SignUp(List<String>answers){

        setName(answers.get(0));
        setLastName(answers.get(1));
        setPassword(answers.get(2));
        setMail(answers.get(3));
    }


    public void register() {
        //Checks that all spaces have been filled and valid
        if(this.name==(null) || this.password==(null) || this.mail==(null) || this.lastName==(null)) {
            this.success = false;
            System.out.println("There was a mistake while filling the SignUp form, please try again");
        }

        //Assigns values to the user
        User user=new User(this.name,this.password,this.mail,this.lastName);
        System.out.println("Successful Log In!");
        this.success = true;
    }

    /* This method can be used to further verify whether the user
     * has already signedUp to follow up and use the app
     */
    public boolean getState() {
        return this.success;
    }

    /*
     * 	This method sets the name for the variable so that it can later be
     *  validated and used to give the user a name.
     */
    public void setName(String name){
        if(name.length() > 3)
            this.name = name;
        System.out.println("can't be shorter than 3 characters");
    }
    public void setLastName(String lastName){
        if(lastName.length() > 3)
            this.lastName = lastName;
        System.out.println("can't be shorter than 3 characters");
    }
    /*
     * 	This method sets the password for a variable while restraining it
     *  in case it´s too short to be secure
     */
    public void setPassword(String password){
        if(password.length() > 5)
            this.password = password;
        System.out.println("Password can't be shorter than 5 characters");
    }

    /*
     * 	This method sets the mail for a variable so that it can be
     *  setted for the users mail.
     */
    public void setMail(String mail){
        this.mail = mail;
    }

    /*
     * 	This method sets the number for a variable while checking if
     *  the number length is in the correct format (local colombian number)
     */

}
