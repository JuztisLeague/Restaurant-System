package BonAppetit;

import java.awt.Font;
import java.awt.Frame;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsAdmin extends javax.swing.JFrame {

	
	private static final long serialVersionUID = 1L;


	public OptionsAdmin() {
        
    	setExtendedState(Frame.MAXIMIZED_BOTH);
    	setUndecorated(true);
    	
    	connect();
    	
    	initComponents();
        
    }
    
    
    Connection con;
	PreparedStatement pst;
	ResultSet rs;
    
    
    public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bon_appetit", "root", "");
		}
		
		catch (ClassNotFoundException ex) {
			
		}
		
		catch (SQLException ex) {
			
		}
	}
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setBounds(23, 478, 157, 38);
        jButtonMenu = new javax.swing.JButton();
        jButtonMenu.setFocusable(false);
        jButtonMenu.setBounds(0, 149, 1306, 23);
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		jButtonLogOutActionPerformed(e);
        	}
        });
        jButton4.setFocusable(false);
        jButton4.setBounds(0, 231, 1306, 23);
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setBounds(10, 11, 1286, 62);
        jButton3 = new javax.swing.JButton();
        jButton3.setFocusable(false);
        jButton3.setBounds(0, 108, 1306, 23);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	//jProfileButtonActionPerformed
            }
        });
        jButton2 = new javax.swing.JButton();
        jButton2.setFocusable(false);
        jButton2.setBounds(0, 190, 1306, 23);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setPreferredSize(new java.awt.Dimension(207, 501));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 33));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bon Appettit");

        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });

        jButton4.setText("Log Out");

        jLabel2.setFont(new java.awt.Font("Blackadder ITC", 0, 30)); 
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrator");

        jButton3.setText("Profile");

        jButton2.setText("Order Numbers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(191)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1306, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(423, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(151)
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(388, Short.MAX_VALUE))
        );
        jPanel1.setLayout(null);
        jPanel1.add(jButton4);
        jPanel1.add(jLabel1);
        jPanel1.add(jButtonMenu);
        jPanel1.add(jLabel2);
        jPanel1.add(jButton2);
        jPanel1.add(jButton3);
        getContentPane().setLayout(layout);
        
        btnClose = new JButton("Close");
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
    
    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        MenuAdmin frame = new MenuAdmin();
        frame.setVisible(true);
        this.dispose();
       
   }   
    
    private void jButtonLogOutActionPerformed(ActionEvent e) {                                         
        
        PersonnelLogin personnelLogin = new PersonnelLogin();
        personnelLogin.setVisible(true);
        this.dispose();
       
   }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OptionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionsAdmin().setVisible(true);
            }
        });
    }
    
    private JButton jButtonMenu;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JButton btnClose;
}
