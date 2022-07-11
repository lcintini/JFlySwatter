import controller.MainController;

import java.awt.*;

public class RunJFlySwatter {
    public static void main(String[] args){
        // Gestisce in maniera parallela il nostro codice e la componente grafica dell'applicazione
        EventQueue.invokeLater( () -> {
            new MainController();
        });
    }
}
