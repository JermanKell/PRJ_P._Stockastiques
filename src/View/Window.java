package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;

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

    private JPanel contentPane;

    public Window() {

        setTitle("Solveur de problèmes stockastiques");
        setBounds(100, 100, 756, 246);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Format format = new DecimalFormat("#.##");

        //pan main
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnvalid = new JButton ("Calculer");
        btnvalid.setBounds(12, 150, 245, 36);
        contentPane.add(btnvalid);
        JFormattedTextField textλ = new JFormattedTextField(format);
        textλ.setBounds(196, 13, 61, 22);
        contentPane.add(textλ);
        JFormattedTextField textμ = new JFormattedTextField(format);
        textμ.setBounds(196, 43, 61, 22);
        contentPane.add(textμ);
        JFormattedTextField texts = new JFormattedTextField(format);
        texts.setBounds(196, 75, 61, 22);
        contentPane.add(texts);
        PlaceholderTextField textcap = new PlaceholderTextField(format);
        textcap.setPlaceholder("0 = ∞");
        textcap.setBounds(196, 110, 61, 22);
        contentPane.add(textcap);

        JLabel labλ = new JLabel("Nb d'arrivées moyen clients λ:");
        labλ.setBounds(12, 16, 172, 16);
        contentPane.add(labλ);
        labλ.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel labμ = new JLabel("Nb servives moyen μ:");
        labμ.setBounds(12, 46, 172, 16);
        contentPane.add(labμ);
        labμ.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel labs = new JLabel("Nb de serveurs s:");
        labs.setBounds(83, 78, 101, 16);
        contentPane.add(labs);
        labs.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel labcap = new JLabel("Nb max clients dans système:");
        labcap.setBounds(14, 113, 170, 16);
        contentPane.add(labcap);
        labcap.setHorizontalAlignment(SwingConstants.RIGHT);

        JLabel lblL = new JLabel("L=");
        lblL.setHorizontalAlignment(SwingConstants.RIGHT);
        lblL.setBounds(269, 16, 47, 16);
        contentPane.add(lblL);

        JLabel lblLq = new JLabel("Lq=");
        lblLq.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLq.setBounds(269, 46, 47, 16);
        contentPane.add(lblLq);

        JLabel lblW = new JLabel("W=");
        lblW.setHorizontalAlignment(SwingConstants.RIGHT);
        lblW.setBounds(269, 78, 47, 16);
        contentPane.add(lblW);

        JLabel lblWq = new JLabel("Wq=");
        lblWq.setHorizontalAlignment(SwingConstants.RIGHT);
        lblWq.setBounds(269, 113, 47, 16);
        contentPane.add(lblWq);

        JLabel labelL = new JLabel("0");
        labelL.setHorizontalAlignment(SwingConstants.RIGHT);
        labelL.setBounds(328, 16, 61, 16);
        contentPane.add(labelL);

        JLabel labelLq = new JLabel("0");
        labelLq.setHorizontalAlignment(SwingConstants.RIGHT);
        labelLq.setBounds(328, 46, 61, 16);
        contentPane.add(labelLq);

        JLabel labelW = new JLabel("0");
        labelW.setHorizontalAlignment(SwingConstants.RIGHT);
        labelW.setBounds(328, 78, 61, 16);
        contentPane.add(labelW);

        JLabel labelWq = new JLabel("0");
        labelWq.setHorizontalAlignment(SwingConstants.RIGHT);
        labelWq.setBounds(328, 113, 61, 16);
        contentPane.add(labelWq);

        setVisible(true);
    }

    class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("TEXT : jtf ");
        }
    }
}