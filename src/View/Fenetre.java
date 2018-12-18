package View;

import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Fenetre extends JFrame {

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JTextField TxtLambdaMMS;
    private JTextField TxtServiceMMS;
    private JTextField TxtServeurMMS;
    private JTextField TxtLambdaMM1K;
    private JTextField TxtServiceMM1K;
    private JTextField TxtmaxKMM1K;

    public Fenetre() {
        setBackground(new Color(230, 230, 250));
        setTitle("Calculateur | Files d'attentes");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(/*1800, 800*/475, 529);
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
                System.out.println("CALCULER");
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
        panMMS.add(panTextResultatMMS);
        panTextResultatMMS.setLayout(new GridLayout(1, 1, 0, 0));
        panTextResultatMMS.setLayout(new GridLayout(1, 1, 0, 0));

        JTextPane textPaneMMS = new JTextPane();
        panTextResultatMMS.add(textPaneMMS);

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
                System.out.println("CALCULER");
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
        panMM1K.add(panTextResultatMM1K);
        panTextResultatMM1K.setLayout(new GridLayout(1, 1, 0, 0));
        panTextResultatMM1K.setLayout(new GridLayout(1, 1, 0, 0));

        JTextPane textPaneMM1K = new JTextPane();
        panTextResultatMM1K.add(textPaneMM1K);

        /////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////

        addWindowListener(new WindowsEvent());
        tabbedPane.setSelectedIndex(0);
        setVisible(true);
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
}