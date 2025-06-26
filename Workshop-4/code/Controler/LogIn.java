import View.FormGui;

public class LogIn{
    public LogIn(){
        this.ShowLogIn();
        }
    public void ShowLogIn(){
        String[] labelTexts={"Name","Password"};
        FormGui formLogin=new FormGui(labelTexts);
    }
    public static void main(String[] args) {
        LogIn jeffersonCrack=new LogIn();
    }
}
