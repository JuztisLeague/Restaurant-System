package BonAppetit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class OptionsAdmin extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    private static PersonnelLogin personnelLogin;
    private static MenuAdmin menuAdmin;
    private static ProfilePage profilePage;
    private static OrderNumbers orderNumbers;
    private static DinerPage dinerPage;

    private JButton btnAddOrders;
    private JButton jButton2;
    private JButton jButtonProfile;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JButton btnClose;
    private JButton btnMenu;

    public OptionsAdmin() {
        getContentPane().setBackground(new Color(0, 64, 64));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        connect();
        initComponents();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bon_appetit", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(0, 64, 64));
        btnAddOrders = new javax.swing.JButton();
        btnAddOrders.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnAddOrders.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnAddOrders.setFocusable(false);
        btnAddOrders.setBounds(451, 135, 394, 51);
        jButton4 = new javax.swing.JButton();
        jButton4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        jButton4.setFont(new Font("Tahoma", Font.BOLD, 20));
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButtonLogOutActionPerformed(e);
            }
        });
        jButton4.setFocusable(false);
        jButton4.setBounds(451, 259, 394, 51);
        jButtonProfile = new javax.swing.JButton();
        jButtonProfile.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        jButtonProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
        jButtonProfile.setFocusable(false);
        jButtonProfile.setBounds(451, 11, 394, 51);
        jButtonProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButtonProfileActionPerformed(e);
            }
        });
        jButton2 = new javax.swing.JButton();
        jButton2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        jButton2.setFont(new Font("Tahoma", Font.BOLD, 20));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButtonOrderNumbersActionPerformed(e);
            }
        });
        jButton2.setFocusable(false);
        jButton2.setBounds(451, 197, 394, 51);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setPreferredSize(new java.awt.Dimension(207, 501));

        btnAddOrders.setText("Add Orders");
        btnAddOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOrdersActionPerformed(evt);
            }
        });

        jButton4.setText("Log Out");
        jButtonProfile.setText("Profile");
        jButton2.setText("Order Numbers");

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Century Gothic", Font.BOLD, 43));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bon Appettit");

        jLabel2 = new javax.swing.JLabel();
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setFont(new Font("Century Gothic", Font.PLAIN, 30));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrator");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(645)
                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(192)
                            .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 1286, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1306, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(422, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                    .addGap(35)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                    .addGap(41)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(300, Short.MAX_VALUE))
        );

        jPanel1.setLayout(null);
        jPanel1.add(jButton4);
        jPanel1.add(btnAddOrders);
        jPanel1.add(jButton2);
        jPanel1.add(jButtonProfile);

        btnMenu = new JButton();
        btnMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButtonMenuActionPerformed(e);
            }
        });
        btnMenu.setText("Menu");
        btnMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnMenu.setFocusable(false);
        btnMenu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnMenu.setBounds(451, 73, 394, 51);
        jPanel1.add(btnMenu);
        getContentPane().setLayout(layout);

        btnClose = new JButton("Close");
        btnClose.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnClose.setFocusable(false);
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnClose.setBounds(1776, 11, 112, 46);
        getContentPane().add(btnClose);

        pack();
    }

    private void jButtonAddOrdersActionPerformed(java.awt.event.ActionEvent evt) {
        if (menuAdmin == null) {
            menuAdmin = new MenuAdmin();
        }
        menuAdmin.setVisible(true);
        dispose();
    }

    private void jButtonLogOutActionPerformed(ActionEvent e) {
        if (personnelLogin == null) {
            personnelLogin = new PersonnelLogin();
        }
        personnelLogin.setVisible(true);
        dispose();
    }

    private void jButtonProfileActionPerformed(ActionEvent e) {
        if (profilePage == null) {
            profilePage = new ProfilePage();
        }
        profilePage.setVisible(true);
        dispose();
    }

    private void jButtonOrderNumbersActionPerformed(ActionEvent e) {
        if (orderNumbers == null) {
            orderNumbers = new OrderNumbers();
        }
        orderNumbers.setVisible(true);
        dispose();
    }

    private void jButtonMenuActionPerformed(ActionEvent e) {
        if (dinerPage == null) {
            dinerPage = new DinerPage();
        }
        dinerPage.setVisible(true);
        dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsAdmin().setVisible(true);
            }
        });
    }
}
