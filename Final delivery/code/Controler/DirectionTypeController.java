package Proyecto.Code.src.Controler;

import javax.swing.*;

public class DirectionTypeController {

    public DirectionTypeController(){

    }
    public String[] typeDirectionLabels() {
        Object[] options = {"Yes", "No"};
        int answer = JOptionPane.showOptionDialog(null,
                "The first part of the direction is a street?",
                "Question",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

        if(answer == 0) {
            return new String[]{"Number of the Street", "Number of the Career", "Number of the house"};
        } else {
            return new String[]{"Number of the Career", "Number of the Street", "Number of the house"};
        }
    }
}

