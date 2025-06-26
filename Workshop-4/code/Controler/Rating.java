package Proyecto.Code.src;

/* 
This file is the creation of the class Rating

Author: Andres Murillo <afmurillot@udistrital.edu.co> - Abr/2025
*/
public class Rating {
    int calification;
    String commentary;
    /*
    Creation of the constructor and realize the variable inicialitation.
    */
    public Rating(){
        calification=0;
        commentary=" ";
    }
     /**
     * This method recibe a new calification and revise if are between 0 and 5 and actualize the calification.
     * 
     * @param newCalification: calification to analize.
     */
    public void makeCalification(int newCalification){
        if(0<=newCalification || newCalification<=5 )
        calification=newCalification;
        
    }
     /**
     * This method recibe a new commentary and revise if are between 0 and 150 and actualize the commentary.
     * 
     * @param newCommentary: commentary to analize.
     */
    public void makeCommentary(String newCommentary){
        int sizeCommentary=newCommentary.length();
        if(0<sizeCommentary || sizeCommentary<=150)
        commentary=newCommentary;
        else
        System.out.println("The commentary's size isnt correct, please try again ");
    }
}