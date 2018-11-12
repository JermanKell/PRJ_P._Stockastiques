package View;

import javax.swing.*;

public class Window extends JFrame {

    /*
        Valeur associee au processus d'arrivee
     */
    private double λ = 0;

    /*
        Valeur associee au processus de service
     */
    private double μ = 0;

    /*
        Valeur associee au nombre de serveurs
     */
    private int S = 0;

    public Window() {
        setTitle("Stockasticity problems solver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setAlwaysOnTop(true);
        ConfigureView();
        setVisible(true);

    }

    private void ConfigureView() {

    }
}