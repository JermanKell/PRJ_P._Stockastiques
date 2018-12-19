package View;

import Model.FileAttenteMM1K;
import Model.FileAttenteMMS;

import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class Fenetre extends JFrame {

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JTextField TxtLambdaMMS;
    private JTextField TxtServiceMMS;
    private JTextField TxtServeurMMS;
    private JTextField TxtLambdaMM1K;
    private JTextField TxtServiceMM1K;
    private JTextField TxtmaxKMM1K;
    private JTextPane textPaneMMS;
    private JTextPane textPaneMM1K;

    private JScrollPane scrollPaneMMS;
    JScrollPane scrollPaneMM1K;
    private JTextField TxtTpsSejSysMMS;
    private JTextField LbTpsSejSysMM1K;

    public Fenetre() {
        setBackground(new Color(230, 230, 250));
        setTitle("Calculateur | Files d'attentes");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icone.png"));


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(491, 529);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(300, 250));

        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 1, 0, 0));

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(new Color(230, 230, 250));
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.add(tabbedPane);

        /////////////////////////////////////////////////////////////////////////
        //////////////////////////////	MMS//////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////

        JPanel panMMS = new JPanel();
        panMMS.setBackground(new Color(152, 251, 152));
        tabbedPane.addTab("   M|M|S   ", null, panMMS, null);
        SpringLayout sl_panMMS = new SpringLayout();
        panMMS.setLayout(sl_panMMS);

        JPanel panFormMMS = new JPanel();
        sl_panMMS.putConstraint(SpringLayout.NORTH, panFormMMS, 0, SpringLayout.NORTH, panMMS);
        sl_panMMS.putConstraint(SpringLayout.WEST, panFormMMS, 10, SpringLayout.WEST, panMMS);
        sl_panMMS.putConstraint(SpringLayout.SOUTH, panFormMMS, 127, SpringLayout.NORTH, panMMS);
        sl_panMMS.putConstraint(SpringLayout.EAST, panFormMMS, -20, SpringLayout.EAST, panMMS);
        panFormMMS.setBackground(new Color(152, 251, 152));
        panMMS.add(panFormMMS);

        JPanel panBouttonMMS = new JPanel();
        sl_panMMS.putConstraint(SpringLayout.NORTH, panBouttonMMS, 6, SpringLayout.SOUTH, panFormMMS);
        panBouttonMMS.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panBouttonMMS.setBackground(new Color(230, 230, 250));
        sl_panMMS.putConstraint(SpringLayout.WEST, panBouttonMMS, 107, SpringLayout.WEST, panMMS);
        sl_panMMS.putConstraint(SpringLayout.EAST, panBouttonMMS, -120, SpringLayout.EAST, panMMS);
        panMMS.add(panBouttonMMS);

        JPanel panTextResultatMMS = new JPanel();
        sl_panMMS.putConstraint(SpringLayout.SOUTH, panBouttonMMS, -6, SpringLayout.NORTH, panTextResultatMMS);
        sl_panMMS.putConstraint(SpringLayout.NORTH, panTextResultatMMS, 181, SpringLayout.NORTH, panMMS);
        panTextResultatMMS.setBackground(new Color(230, 230, 250));
        panBouttonMMS.setLayout(new GridLayout(0, 1, 0, 0));

        JButton BtnCalculerMMS = new JButton("CALCULER");
        BtnCalculerMMS.setBackground(new Color(152, 251, 152));
        BtnCalculerMMS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                        FileAttenteMMS mms = new FileAttenteMMS(parse(TxtLambdaMMS.getText().replace(',', '.')), parse(TxtServiceMMS.getText().replace(',', '.')), Integer.parseInt(TxtServeurMMS.getText().replace(',', '.')));
                        StyledDocument DocMMS = (StyledDocument)textPaneMMS.getDocument();
                        textPaneMMS.setText("");
                        String chaine = "";
                        chaine += "Nombre de clients en attente dans la file Lq = " + String.format("%.04f", mms.getLq()) + "\n";
                        chaine += "Nombre de client dans le système L = " + String.format("%.04f", mms.getL()) + "\n";
                        chaine += "Duree moyenne d'attente d'un client dans la file Wq = " + String.format("%.04f", mms.getWq()) + "\n";
                        chaine += "Duree moyenne d'attente d'un client dans le systeme W = " + String.format("%.04f", mms.getW()) + "\n";
                        chaine += "Probabilite d'etre à l'etat q0 = " + String.format("%.04f", mms.getQ0()) + "\n";
                        if (TxtTpsSejSysMMS.getText().length() > 0) {
                            chaine += "Probabilite temps de sejour du client dans le systeme = " + String.format("%.04f", mms.getPrDureeSejSys(parse(TxtTpsSejSysMMS.getText().replace(',', '.')))) + "\n";
                        }
                        for(int i= 1; i <= 10; i++) {
                            chaine += "Probabilite d'etre à l'etat q" + i + " = " + String.format("%.04f", mms.getQj(i)) + "\n";
                        }

                        DocMMS.insertString(0, chaine, textPaneMMS.getStyle("default"));
                        textPaneMMS.setCaretPosition(0);

                } catch (Exception err) { new JOptionPane().showMessageDialog(null, err.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);}
            }
        });
        BtnCalculerMMS.setFont(new Font("Tekton Pro", Font.BOLD, 16));
        panBouttonMMS.add(BtnCalculerMMS);
        sl_panMMS.putConstraint(SpringLayout.WEST, panTextResultatMMS, 10, SpringLayout.WEST, panMMS);
        sl_panMMS.putConstraint(SpringLayout.SOUTH, panTextResultatMMS, -10, SpringLayout.SOUTH, panMMS);
        sl_panMMS.putConstraint(SpringLayout.EAST, panTextResultatMMS, -10, SpringLayout.EAST, panMMS);
        panFormMMS.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel LbLambdaMMS = new JLabel("Nombre de clients λ :   ");
        LbLambdaMMS.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMMS.add(LbLambdaMMS);

        TxtLambdaMMS = new JTextField();
        panFormMMS.add(TxtLambdaMMS);
        TxtLambdaMMS.setColumns(10);

        JLabel LbServiceMMS = new JLabel("Nombre de services μ :   ");
        LbServiceMMS.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMMS.add(LbServiceMMS);

        TxtServiceMMS = new JTextField();
        panFormMMS.add(TxtServiceMMS);
        TxtServiceMMS.setColumns(10);

        JLabel LbServeurMMS = new JLabel("Nombre de serveurs s :   ");
        LbServeurMMS.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMMS.add(LbServeurMMS);

        TxtServeurMMS = new JTextField();
        panFormMMS.add(TxtServeurMMS);
        TxtServeurMMS.setColumns(10);

        JLabel lbTpsSejsysMMS = new JLabel("Séjour dans le systeme t (opt) :   ");
        lbTpsSejsysMMS.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMMS.add(lbTpsSejsysMMS);

        TxtTpsSejSysMMS = new JTextField();
        TxtTpsSejSysMMS.setToolTipText("optionnel");
        panFormMMS.add(TxtTpsSejSysMMS);
        TxtTpsSejSysMMS.setColumns(10);
        panMMS.add(panTextResultatMMS);
        panTextResultatMMS.setLayout(new GridLayout(1, 1, 0, 0));
        panTextResultatMMS.setLayout(new GridLayout(1, 1, 0, 0));

        textPaneMMS = new JTextPane();
        panTextResultatMMS.add(textPaneMMS);

        scrollPaneMMS = new JScrollPane(textPaneMMS,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panTextResultatMMS.add(scrollPaneMMS);
        scrollPaneMMS.setBounds(0, 0, 200, 300);

        /////////////////////////////////////////////////////////////////////////
        //////////////////////////////  	MM1K	 ////////////////////////////
        /////////////////////////////////////////////////////////////////////////
        JPanel panMM1K = new JPanel();
        panMM1K.setBackground(new Color(250, 235, 215));
        tabbedPane.addTab("   M|M|1|K   ", null, panMM1K, null);
        SpringLayout sl_panMM1K = new SpringLayout();
        panMM1K.setLayout(sl_panMM1K);

        JPanel panFormMM1K = new JPanel();
        sl_panMM1K.putConstraint(SpringLayout.SOUTH, panFormMM1K, 127, SpringLayout.NORTH, panMM1K);
        sl_panMM1K.putConstraint(SpringLayout.EAST, panFormMM1K, -21, SpringLayout.EAST, panMM1K);
        panFormMM1K.setBackground(new Color(250, 235, 215));
        sl_panMM1K.putConstraint(SpringLayout.NORTH, panFormMM1K, 0, SpringLayout.NORTH, panMM1K);
        sl_panMM1K.putConstraint(SpringLayout.WEST, panFormMM1K, 15, SpringLayout.WEST, panMM1K);
        panMM1K.add(panFormMM1K);

        JPanel panBouttonMM1K = new JPanel();
        sl_panMM1K.putConstraint(SpringLayout.NORTH, panBouttonMM1K, 6, SpringLayout.SOUTH, panFormMM1K);
        panBouttonMM1K.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panBouttonMM1K.setBackground(new Color(250, 235, 215));
        sl_panMM1K.putConstraint(SpringLayout.WEST, panBouttonMM1K, 107, SpringLayout.WEST, panMM1K);
        sl_panMM1K.putConstraint(SpringLayout.EAST, panBouttonMM1K, -120, SpringLayout.EAST, panMM1K);
        panMM1K.add(panBouttonMM1K);

        JPanel panTextResultatMM1K = new JPanel();
        sl_panMM1K.putConstraint(SpringLayout.SOUTH, panBouttonMM1K, -6, SpringLayout.NORTH, panTextResultatMM1K);
        sl_panMM1K.putConstraint(SpringLayout.NORTH, panTextResultatMM1K, 181, SpringLayout.NORTH, panMM1K);
        panTextResultatMM1K.setBackground(new Color(230, 230, 250));
        panBouttonMM1K.setLayout(new GridLayout(0, 1, 0, 0));

        JButton BtnCalculerMM1K = new JButton("CALCULER");
        BtnCalculerMM1K.setBackground(new Color(250, 235, 215));
        BtnCalculerMM1K.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    FileAttenteMM1K mm1k = new FileAttenteMM1K(parse(TxtLambdaMM1K.getText().replace(',', '.')), parse(TxtServiceMM1K.getText().replace(',', '.')), Integer.parseInt(TxtmaxKMM1K.getText().replace(',', '.')));
                    StyledDocument DocMM1K = (StyledDocument)textPaneMM1K.getDocument();
                    textPaneMM1K.setText("");
                    String chaine = "";
                    chaine += "Nombre de clients en attente dans la file Lq = " + String.format("%.04f", mm1k.getLq()) + "\n";
                    chaine += "Nombre de client dans le système L = " + String.format("%.04f", mm1k.getL()) + "\n";
                    chaine += "Duree moyenne d'attente d'un client dans la file Wq = " + String.format("%.04f", mm1k.getWq()) + "\n";
                    chaine += "Duree moyenne d'attente d'un client dans le systeme W = " + String.format("%.04f", mm1k.getW()) + "\n";
                    chaine += "Probabilite d'etre à l'etat q0 = " + String.format("%.04f", mm1k.getQ0()) + "\n";
                    if (LbTpsSejSysMM1K.getText().length() > 0) {
                        chaine += "Probabilite temps de sejour du client dans le systeme = " + String.format("%.04f", mm1k.getPrDureeSejSys(parse(LbTpsSejSysMM1K.getText().replace(',', '.')))) + "\n";
                    }
                    for(int i= 1; i <= Integer.parseInt(TxtmaxKMM1K.getText().replace(',', '.')); i++) {
                        chaine += "Probabilite d'etre à l'etat q" + i + " = " + String.format("%.04f", mm1k.getQj(i)) + "\n";
                    }

                    DocMM1K.insertString(0, chaine, textPaneMM1K.getStyle("default"));
                    textPaneMM1K.setCaretPosition(0);

                } catch (Exception err) { new JOptionPane().showMessageDialog(null, err.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);}
            }
        });
        BtnCalculerMM1K.setFont(new Font("Tekton Pro", Font.BOLD, 16));
        panBouttonMM1K.add(BtnCalculerMM1K);
        sl_panMM1K.putConstraint(SpringLayout.WEST, panTextResultatMM1K, 10, SpringLayout.WEST, panMM1K);
        sl_panMM1K.putConstraint(SpringLayout.SOUTH, panTextResultatMM1K, -10, SpringLayout.SOUTH, panMM1K);
        sl_panMM1K.putConstraint(SpringLayout.EAST, panTextResultatMM1K, -10, SpringLayout.EAST, panMM1K);
        panFormMM1K.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel LbLambdaMM1K = new JLabel("Nombre de clients λ :   ");
        LbLambdaMM1K.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMM1K.add(LbLambdaMM1K);

        TxtLambdaMM1K = new JTextField();
        panFormMM1K.add(TxtLambdaMM1K);
        TxtLambdaMM1K.setColumns(10);

        JLabel LbServiceMM1K = new JLabel("Nombre de services μ :   ");
        LbServiceMM1K.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMM1K.add(LbServiceMM1K);

        TxtServiceMM1K = new JTextField();
        panFormMM1K.add(TxtServiceMM1K);
        TxtServiceMM1K.setColumns(10);

        JLabel LbmaxKMM1K = new JLabel("Nombre de clients max K :   ");
        LbmaxKMM1K.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMM1K.add(LbmaxKMM1K);

        TxtmaxKMM1K = new JTextField();
        panFormMM1K.add(TxtmaxKMM1K);
        TxtmaxKMM1K.setColumns(10);

        JLabel lbTpsSejsysMM1K = new JLabel("Séjour dans le systeme t (opt) :   ");
        lbTpsSejsysMM1K.setHorizontalAlignment(SwingConstants.RIGHT);
        panFormMM1K.add(lbTpsSejsysMM1K);

        LbTpsSejSysMM1K = new JTextField();
        LbTpsSejSysMM1K.setToolTipText("optionnel");
        panFormMM1K.add(LbTpsSejSysMM1K);
        LbTpsSejSysMM1K.setColumns(10);
        panMM1K.add(panTextResultatMM1K);
        panTextResultatMM1K.setLayout(new GridLayout(1, 1, 0, 0));
        panTextResultatMM1K.setLayout(new GridLayout(1, 1, 0, 0));

        textPaneMM1K = new JTextPane();
        panTextResultatMM1K.add(textPaneMM1K);

        scrollPaneMM1K = new JScrollPane(textPaneMM1K,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panTextResultatMM1K.add(scrollPaneMM1K);
        scrollPaneMM1K.setBounds(0, 0, 200, 300);

        /////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////

        addWindowListener(new WindowsEvent());
        tabbedPane.setSelectedIndex(0);
        setVisible(true);
    }

    double parse(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }

    class WindowsEvent implements WindowListener {
        @Override
        public void windowClosing(WindowEvent e) {
            new Thread(new Runnable(){public void run(){
                System.out.println("windowsClosing");
            }}).start();

        }

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosed(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowIconified(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowActivated(WindowEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            // TODO Auto-generated method stub

        }
    }

    public static void main(String[] args){
        Fenetre fenetre =new Fenetre();
    }
}