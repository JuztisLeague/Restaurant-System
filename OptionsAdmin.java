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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class OptionAdmin extends javax.swing.JFrame {

	
	private static final long serialVersionUID = 1L;


	public OptionAdmin() {
		getContentPane().setBackground(new Color(0, 64, 64));
        
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
        jPanel1.setBackground(new Color(0, 64, 64));
        jButtonMenu = new javax.swing.JButton();
        jButtonMenu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        jButtonMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
        jButtonMenu.setFocusable(false);
        jButtonMenu.setBounds(451, 86, 394, 51);
        jButton4 = new javax.swing.JButton();
        jButton4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        jButton4.setFont(new Font("Tahoma", Font.BOLD, 20));
        jButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		jButtonLogOutActionPerformed(e);
        	}
        });
        jButton4.setFocusable(false);
        jButton4.setBounds(451, 245, 394, 51);
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
        jButton2.setBounds(451, 162, 394, 51);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setPreferredSize(new java.awt.Dimension(207, 501));

        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
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
        jPanel1.add(jButtonMenu);
        jPanel1.add(jButton2);
        jPanel1.add(jButtonProfile);
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
            java.util.logging.Logger.getLogger(OptionAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OptionAdmin().setVisible(true);
            }
        });
    }
    
    public void jButtonProfileActionPerformed(ActionEvent e){
    	ProfilePage profilePage = new ProfilePage();
    	profilePage.setVisible(true);
    	this.dispose();
    }
    
    public void jButtonOrderNumbersActionPerformed(ActionEvent e) {
    	OrderNumbers orderNumbers = new OrderNumbers();
    	orderNumbers.setVisible(true);
    	this.dispose();
    }
    
    private JButton jButtonMenu;
    private JButton jButton2;
    private JButton jButtonProfile;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JButton btnClose;
}
