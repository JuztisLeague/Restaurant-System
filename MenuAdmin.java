package BonAppetit;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.SwingConstants;

public class MenuAdmin extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField textDishName;
	private JTextField textDescription;
	private JTextField textPrice;
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin window = new MenuAdmin();
					
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuAdmin() {
		getContentPane().setBackground(new Color(21, 25, 28));
		setUndecorated(true);
		getContentPane().setFocusable(false);
		initialize();
		connect();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	ResultSet countResult;
	
	File f = null;
    String path = null;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bon_appetit", "root", "");
		}
		
		catch (ClassNotFoundException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to connect to database. ClassNotFoundException: " + ex.getMessage());
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to connect to database. SQLException: " + ex.getMessage());
	    }
	}
	
	
	private void initialize() {
		
		jMiddlePanel = new JPanel();
		jMiddlePanel.setFocusable(false);
		jMiddlePanel.setBorder(null);
		jMiddlePanel.setBackground(new Color(0, 0, 0));
		jMiddlePanel.setForeground(new Color(255, 255, 255));
		jMiddlePanel.setBounds(109, 11, 1321, 1058);
		getContentPane().add(jMiddlePanel);
		jMiddlePanel.setLayout(null);
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(0,0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelCategories = new JPanel();
		panelCategories.setBackground(new Color(0, 0, 0));
		panelCategories.setFocusable(false);
		panelCategories.setBounds(0, 11, 103, 1058);
		getContentPane().add(panelCategories);
		
		
		
		btnAppetizers = new JButton("");
		btnAppetizers.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAppetizers.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/nachos.png")));
		btnAppetizers.setPreferredSize(new Dimension(64, 64));
		btnAppetizers.setBounds(new Rectangle(0, 0, 64, 64));
		btnAppetizers.setFocusable(false);
		btnAppetizers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jAppetizerButtonActionPerformed(e);
			}
		});
		panelCategories.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
		
		lblNewLabel_1 = new JLabel("MENU");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panelCategories.add(lblNewLabel_1);
		panelCategories.add(btnAppetizers);
		
		btnEntree = new JButton("");
		btnEntree.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/Entree.png")));
		btnEntree.setPreferredSize(new Dimension(64, 64));
		btnEntree.setBounds(new Rectangle(0, 0, 64, 64));
		btnEntree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jEntreeButtonActionPerformed(e);
				
			}
		});
		
		lblNewLabel_2 = new JLabel("Appetizers");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		panelCategories.add(lblNewLabel_2);
		btnEntree.setFocusable(false);
		panelCategories.add(btnEntree);
		
		btnDessert = new JButton("");
		btnDessert.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/dessert.png")));
		btnDessert.setBounds(new Rectangle(0, 0, 64, 64));
		btnDessert.setPreferredSize(new Dimension(64, 64));
		btnDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jDessertButtonActionPerformed(e);
				
			}
		});
		
		lblNewLabel_3 = new JLabel("Entree");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		panelCategories.add(lblNewLabel_3);
		btnDessert.setFocusable(false);
		panelCategories.add(btnDessert);
		
		btnDrinks = new JButton("");
		btnDrinks.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/drinks.png")));
		btnDrinks.setPreferredSize(new Dimension(64, 64));
		btnDrinks.setBounds(new Rectangle(0, 0, 64, 64));
		btnDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jDrinksButtonActionPerformed(e);
				
			}
		});
		
		lblNewLabel_4 = new JLabel("Dessert");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		panelCategories.add(lblNewLabel_4);
		btnDrinks.setFocusable(false);
		panelCategories.add(btnDrinks);
		
		panelEditables = new JPanel();
		panelEditables.setBackground(new Color(0, 0, 0));
		panelEditables.setFocusable(false);
		panelEditables.setLayout(null);
		panelEditables.setBounds(1436, 11, 484, 1058);
		getContentPane().add(panelEditables);
		
		btnClose = new JButton("");
		btnClose.setBackground(new Color(64, 64, 64));
		btnClose.setOpaque(false);
		btnClose.setBounds(420, 0, 64, 64);
		panelEditables.add(btnClose);
		btnClose.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/cancel.png")));
		btnClose.setFocusable(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		panel_2 = new JPanel();
		panel_2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(64, 64, 64));
		panel_2.setFocusable(false);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(21, 25, 28)), "Admin Edit", TitledBorder.LEFT, TitledBorder.TOP, new Font("Century Gothic", Font.BOLD, 18), new Color(255, 255, 255)));
		panel_2.setBounds(20, 43, 454, 577);
		panelEditables.add(panel_2);
		panel_2.setLayout(null);
		
		rdbtnAppetizer1 = new JRadioButton("Appetizer");
		rdbtnAppetizer1.setBackground(new Color(64, 64, 64));
		rdbtnAppetizer1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnAppetizer1.setForeground(new Color(255, 255, 255));
		rdbtnAppetizer1.setFocusable(false);
		rdbtnAppetizer1.setBounds(76, 204, 140, 23);
		panel_2.add(rdbtnAppetizer1);
		
		rdbtnEntree1 = new JRadioButton("Entree");
		rdbtnEntree1.setBackground(new Color(64, 64, 64));
		rdbtnEntree1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnEntree1.setForeground(new Color(255, 255, 255));
		rdbtnEntree1.setFocusable(false);
		rdbtnEntree1.setBounds(255, 204, 107, 23);
		panel_2.add(rdbtnEntree1);
		
		rdbtnDessert1 = new JRadioButton("Dessert");
		rdbtnDessert1.setBackground(new Color(64, 64, 64));
		rdbtnDessert1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnDessert1.setForeground(new Color(255, 255, 255));
		rdbtnDessert1.setFocusable(false);
		rdbtnDessert1.setBounds(76, 230, 140, 23);
		panel_2.add(rdbtnDessert1);
		
		rdbtnDrinks1 = new JRadioButton("Drinks");
		rdbtnDrinks1.setBackground(new Color(64, 64, 64));
		rdbtnDrinks1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnDrinks1.setForeground(new Color(255, 255, 255));
		rdbtnDrinks1.setFocusTraversalPolicyProvider(true);
		rdbtnDrinks1.setFocusable(false);
		rdbtnDrinks1.setBounds(255, 230, 107, 23);
		panel_2.add(rdbtnDrinks1);
		
		rdbtnGrp1 = new ButtonGroup();{
			rdbtnGrp1.add(rdbtnAppetizer1);
			rdbtnGrp1.add(rdbtnEntree1);
			rdbtnGrp1.add(rdbtnDessert1);
			rdbtnGrp1.add(rdbtnDrinks1);
		}
		
		menubtnGrp1 = new ButtonGroup();{
			menubtnGrp1.add(btnAppetizers);
			menubtnGrp1.add(btnEntree);
			menubtnGrp1.add(btnDessert);
			menubtnGrp1.add(btnDrinks);
		}
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/left-arrow.png")));
		btnBack.setBounds(new Rectangle(0, 0, 64, 64));
		btnBack.setPreferredSize(new Dimension(64, 64));
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actionBackPerformed(e);
			}
		});
		
		lblNewLabel_5 = new JLabel("Drinks");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		panelCategories.add(lblNewLabel_5);
		panelCategories.add(btnBack);
		
		lblNewLabel_6 = new JLabel("Back");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		panelCategories.add(lblNewLabel_6);
		
		panel = new JPanel();
		panel.setBackground(new Color(64, 64, 64));
		panel.setFocusable(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(21, 25, 28)), "Search Dish", TitledBorder.LEFT, TitledBorder.TOP, new Font("Century Gothic", Font.BOLD, 18), new Color(255, 255, 255)));
		panel.setBounds(20, 631, 454, 268);
		panelEditables.add(panel);
		panel.setLayout(null);
		
		rdbtnAppetizer2 = new JRadioButton("Appetizer");
		rdbtnAppetizer2.setForeground(new Color(255, 255, 255));
		rdbtnAppetizer2.setBackground(new Color(64, 64, 64));
		rdbtnAppetizer2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnAppetizer2.setFocusable(false);
		rdbtnAppetizer2.setBounds(78, 30, 125, 23);
		panel.add(rdbtnAppetizer2);
		
		rdbtnEntree2 = new JRadioButton("Entree");
		rdbtnEntree2.setForeground(new Color(255, 255, 255));
		rdbtnEntree2.setBackground(new Color(64, 64, 64));
		rdbtnEntree2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnEntree2.setFocusable(false);
		rdbtnEntree2.setBounds(242, 30, 116, 23);
		panel.add(rdbtnEntree2);
		
		rdbtnDessert2 = new JRadioButton("Dessert");
		rdbtnDessert2.setForeground(new Color(255, 255, 255));
		rdbtnDessert2.setBackground(new Color(64, 64, 64));
		rdbtnDessert2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnDessert2.setFocusable(false);
		rdbtnDessert2.setBounds(78, 66, 125, 23);
		panel.add(rdbtnDessert2);
		
		rdbtnDrinks2 = new JRadioButton("Drinks");
		rdbtnDrinks2.setForeground(new Color(255, 255, 255));
		rdbtnDrinks2.setBackground(new Color(64, 64, 64));
		rdbtnDrinks2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		rdbtnDrinks2.setFocusable(false);
		rdbtnDrinks2.setFocusTraversalPolicyProvider(true);
		rdbtnDrinks2.setBounds(242, 66, 116, 23);
		panel.add(rdbtnDrinks2);
		
		rdbtnGrp2 = new ButtonGroup();{
			rdbtnGrp2.add(rdbtnAppetizer2);
			rdbtnGrp2.add(rdbtnEntree2);
			rdbtnGrp2.add(rdbtnDessert2);
			rdbtnGrp2.add(rdbtnDrinks2);
		}
		
		labelImage = new JLabel("");
		labelImage.setHorizontalAlignment(SwingConstants.CENTER);
        labelImage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        labelImage.setForeground(Color.WHITE);
        labelImage.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelImage.setFocusable(false);
        labelImage.setBackground(new Color(255, 255, 255));
        labelImage.setBounds(10, 278, 434, 214);
        panel_2.add(labelImage);
	        
		
		
		lblDishId = new JLabel("Dish ID");
		lblDishId.setForeground(new Color(255, 255, 255));
		lblDishId.setBounds(29, 132, 86, 17);
		panel.add(lblDishId);
		lblDishId.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblDishId.setFocusable(false);
		
		textDishID = new JTextField();
		textDishID.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textDishID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				searchDish(e, rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2);
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			        
					textDishName.setText("");
                    textDescription.setText("");
                    textPrice.setText("");
			    }
				
			}
		});
		textDishID.setBounds(117, 123, 291, 35);
		panel.add(textDishID);
		textDishID.setColumns(10);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(64, 64, 64));
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnDelete.setBounds(225, 194, 150, 37);
		panel.add(btnDelete);
		btnDelete.setFocusable(false);
		
		
		btnUpdate = new JButton("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(64, 64, 64));
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnUpdate.setBounds(48, 194, 135, 37);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				updateDish(e, rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2, rdbtnGrp2);
				
			}
		});
		btnUpdate.setFocusable(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteDish(e, rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2, rdbtnGrp2);
				
			}
		});
		
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 47, 61, 27);
		panel_2.add(lblNewLabel);
		
		textDishName = new JTextField();
		textDishName.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textDishName.setBounds(132, 52, 312, 32);
		panel_2.add(textDishName);
		textDishName.setColumns(10);
		
		lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setFocusable(false);
		lblDescription.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblDescription.setBounds(10, 98, 112, 27);
		panel_2.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textDescription.setColumns(10);
		textDescription.setBounds(132, 103, 312, 32);
		panel_2.add(textDescription);
		
		lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setBackground(new Color(21, 25, 28));
		lblPrice.setFocusable(false);
		lblPrice.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPrice.setBounds(10, 155, 88, 27);
		panel_2.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		textPrice.setColumns(10);
		textPrice.setBounds(132, 155, 312, 32);
		panel_2.add(textPrice);
		
		
		
		btnUpload = new JButton("Upload");
		btnUpload.setBackground(new Color(64, 64, 64));
		btnUpload.setForeground(new Color(255, 255, 255));
		btnUpload.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnUpload.setBounds(90, 503, 107, 47);
		panel_2.add(btnUpload);
		
		btnAdd = new JButton("Save");
		btnAdd.setBackground(new Color(64, 64, 64));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		btnAdd.setBounds(255, 503, 107, 47);
		panel_2.add(btnAdd);
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addDish(e, rdbtnAppetizer1,rdbtnEntree1, rdbtnDessert1, rdbtnDrinks1, rdbtnGrp1 );
				
			}
		});
		btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
                fileChooser.addChoosableFileFilter(fnwf);
                int load = fileChooser.showOpenDialog(null);

                if (load == fileChooser.APPROVE_OPTION) {
                    f = fileChooser.getSelectedFile();
                    path = f.getAbsolutePath();
                    ImageIcon ii = new ImageIcon(path);
                    Image img = ii.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    labelImage.setIcon(new ImageIcon(img));
                }
            }
        });
		
		
		
		panelData_1 = new JPanel();
		panelData_1.setBackground(new Color(64, 64, 64));
        panelData_1.setBounds(47, 79, 327, 251);
        panelData_1.setLayout(null);
        panelData_1.setVisible(false);
        jMiddlePanel.setLayout(null);
        jMiddlePanel.add(panelData_1);
        
        lblDishPhoto_1 = new JLabel("");
        lblDishPhoto_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_1.setBounds(11, 11, 150, 150);
        panelData_1.add(lblDishPhoto_1);
        
        lblDishName_1 = new JLabel("New label");
        lblDishName_1.setForeground(new Color(255, 255, 255));
        lblDishName_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_1.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_1.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_1.setBounds(160, 40, 157, 50);
        panelData_1.add(lblDishName_1);
        
        lblPrice_1 = new JLabel("New label");
        lblPrice_1.setForeground(new Color(255, 255, 255));
        lblPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_1.setBounds(160, 100, 157, 23);
        panelData_1.add(lblPrice_1);
        
        lblDescription_1 = new JLabel("New label");
        lblDescription_1.setForeground(new Color(255, 255, 255));
        lblDescription_1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_1.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_1.setBounds(10, 169, 307, 71);
        panelData_1.add(lblDescription_1);
        
        panelData_2 = new JPanel();
        panelData_2.setBackground(new Color(64, 64, 64));
        panelData_2.setBounds(491, 79, 327, 251);
        jMiddlePanel.add(panelData_2);
        panelData_2.setLayout(null);
        panelData_2.setVisible(false);
        
        lblDishPhoto_2 = new JLabel("");
        lblDishPhoto_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_2.setBounds(11, 11, 150, 150);
        panelData_2.add(lblDishPhoto_2);
        
        lblDishName_2 = new JLabel("New label");
        lblDishName_2.setForeground(new Color(255, 255, 255));
        lblDishName_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_2.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_2.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_2.setBounds(160, 40, 157, 50);
        panelData_2.add(lblDishName_2);
        
        lblPrice_2 = new JLabel("New label");
        lblPrice_2.setForeground(new Color(255, 255, 255));
        lblPrice_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_2.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_2.setBounds(160, 100, 157, 23);
        panelData_2.add(lblPrice_2);
        
        lblDescription_2 = new JLabel("New label");
        lblDescription_2.setForeground(new Color(255, 255, 255));
        lblDescription_2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_2.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_2.setBounds(10, 169, 307, 71);
        panelData_2.add(lblDescription_2);
        
        panelData_3 = new JPanel();
        panelData_3.setBackground(new Color(64, 64, 64));
        panelData_3.setBounds(933, 79, 327, 251);
        jMiddlePanel.add(panelData_3);
        panelData_3.setLayout(null);
        panelData_3.setVisible(false);
        
        lblDishPhoto_3 = new JLabel("");
        lblDishPhoto_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_3.setBounds(11, 11, 150, 150);
        panelData_3.add(lblDishPhoto_3);
        
        lblDishName_3 = new JLabel("New label");
        lblDishName_3.setForeground(new Color(255, 255, 255));
        lblDishName_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_3.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_3.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_3.setBounds(160, 40, 157, 50);
        panelData_3.add(lblDishName_3);
        
        lblPrice_3 = new JLabel("New label");
        lblPrice_3.setForeground(new Color(255, 255, 255));
        lblPrice_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_3.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_3.setBounds(160, 100, 157, 23);
        panelData_3.add(lblPrice_3);
        
        lblDescription_3 = new JLabel("New label");
        lblDescription_3.setForeground(new Color(255, 255, 255));
        lblDescription_3.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_3.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_3.setBounds(10, 169, 307, 71);
        panelData_3.add(lblDescription_3);
        
        panelData_4 = new JPanel();
        panelData_4.setBackground(new Color(64, 64, 64));
        panelData_4.setLayout(null);
        panelData_4.setBounds(47, 391, 327, 251);
        jMiddlePanel.add(panelData_4);
        panelData_4.setVisible(false);
        
        lblDishPhoto_4 = new JLabel("");
        lblDishPhoto_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_4.setBounds(11, 11, 150, 150);
        panelData_4.add(lblDishPhoto_4);
        
        lblDishName_4 = new JLabel("New label");
        lblDishName_4.setForeground(new Color(255, 255, 255));
        lblDishName_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_4.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_4.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_4.setBounds(160, 40, 157, 50);
        panelData_4.add(lblDishName_4);
        
        lblPrice_4 = new JLabel("New label");
        lblPrice_4.setForeground(new Color(255, 255, 255));
        lblPrice_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_4.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_4.setBounds(160, 100, 157, 23);
        panelData_4.add(lblPrice_4);
        
        lblDescription_4 = new JLabel("New label");
        lblDescription_4.setForeground(new Color(255, 255, 255));
        lblDescription_4.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_4.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_4.setBounds(10, 169, 307, 71);
        panelData_4.add(lblDescription_4);
        
        panelData_5 = new JPanel();
        panelData_5.setBackground(new Color(64, 64, 64));
        panelData_5.setLayout(null);
        panelData_5.setBounds(491, 391, 327, 251);
        jMiddlePanel.add(panelData_5);
        panelData_5.setVisible(false);
        
        lblDishPhoto_5 = new JLabel("");
        lblDishPhoto_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_5.setBounds(11, 11, 150, 150);
        panelData_5.add(lblDishPhoto_5);
        
        lblDishName_5 = new JLabel("New label");
        lblDishName_5.setForeground(new Color(255, 255, 255));
        lblDishName_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_5.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_5.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_5.setBounds(160, 40, 157, 50);
        panelData_5.add(lblDishName_5);
        
        lblPrice_5 = new JLabel("New label");
        lblPrice_5.setForeground(new Color(255, 255, 255));
        lblPrice_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_5.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_5.setBounds(160, 100, 157, 23);
        panelData_5.add(lblPrice_5);
        
        lblDescription_5 = new JLabel("New label");
        lblDescription_5.setForeground(new Color(255, 255, 255));
        lblDescription_5.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_5.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_5.setBounds(10, 169, 307, 71);
        panelData_5.add(lblDescription_5);
        
        panelData_6 = new JPanel();
        panelData_6.setBackground(new Color(64, 64, 64));
        panelData_6.setLayout(null);
        panelData_6.setBounds(933, 391, 327, 251);
        jMiddlePanel.add(panelData_6);
        panelData_6.setVisible(false);
        
        lblDishPhoto_6 = new JLabel("");
        lblDishPhoto_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_6.setBounds(11, 11, 150, 150);
        panelData_6.add(lblDishPhoto_6);
        
        lblDishName_6 = new JLabel("New label");
        lblDishName_6.setForeground(new Color(255, 255, 255));
        lblDishName_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_6.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_6.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_6.setBounds(160, 40, 157, 50);
        panelData_6.add(lblDishName_6);
        
        lblPrice_6 = new JLabel("New label");
        lblPrice_6.setForeground(new Color(255, 255, 255));
        lblPrice_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_6.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_6.setBounds(160, 100, 157, 23);
        panelData_6.add(lblPrice_6);
        
        lblDescription_6 = new JLabel("New label");
        lblDescription_6.setForeground(new Color(255, 255, 255));
        lblDescription_6.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_6.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_6.setBounds(10, 169, 307, 71);
        panelData_6.add(lblDescription_6);
        
        panelData_7 = new JPanel();
        panelData_7.setBackground(new Color(64, 64, 64));
        panelData_7.setLayout(null);
        panelData_7.setBounds(47, 704, 327, 251);
        jMiddlePanel.add(panelData_7);
        panelData_7.setVisible(false);
        
        lblDishPhoto_7 = new JLabel("");
        lblDishPhoto_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_7.setBounds(11, 11, 150, 150);
        panelData_7.add(lblDishPhoto_7);
        
        lblDishName_7 = new JLabel("New label");
        lblDishName_7.setForeground(new Color(255, 255, 255));
        lblDishName_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_7.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_7.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_7.setBounds(160, 40, 157, 50);
        panelData_7.add(lblDishName_7);
        
        lblPrice_7 = new JLabel("New label");
        lblPrice_7.setForeground(new Color(255, 255, 255));
        lblPrice_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_7.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_7.setBounds(160, 100, 157, 23);
        panelData_7.add(lblPrice_7);
        
        lblDescription_7 = new JLabel("New label");
        lblDescription_7.setForeground(new Color(255, 255, 255));
        lblDescription_7.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_7.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_7.setBounds(10, 169, 307, 71);
        panelData_7.add(lblDescription_7);
        
        panelData_8 = new JPanel();
        panelData_8.setBackground(new Color(64, 64, 64));
        panelData_8.setLayout(null);
        panelData_8.setBounds(491, 704, 327, 251);
        jMiddlePanel.add(panelData_8);
        panelData_8.setVisible(false);
        
        lblDishPhoto_8 = new JLabel("");
        lblDishPhoto_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_8.setBounds(11, 11, 150, 150);
        panelData_8.add(lblDishPhoto_8);
        
        lblDishName_8 = new JLabel("New label");
        lblDishName_8.setForeground(new Color(255, 255, 255));
        lblDishName_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_8.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_8.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_8.setBounds(160, 40, 157, 50);
        panelData_8.add(lblDishName_8);
        
        lblPrice_8 = new JLabel("New label");
        lblPrice_8.setForeground(new Color(255, 255, 255));
        lblPrice_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_8.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_8.setBounds(160, 100, 157, 23);
        panelData_8.add(lblPrice_8);
        
        lblDescription_8 = new JLabel("New label");
        lblDescription_8.setForeground(new Color(255, 255, 255));
        lblDescription_8.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_8.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_8.setBounds(10, 169, 307, 71);
        panelData_8.add(lblDescription_8);
        
        panelData_9 = new JPanel();
        panelData_9.setBackground(new Color(64, 64, 64));
        panelData_9.setLayout(null);
        panelData_9.setBounds(933, 704, 327, 251);
        jMiddlePanel.add(panelData_9);
        panelData_9.setVisible(false);
        
        lblDishPhoto_9 = new JLabel("");
        lblDishPhoto_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_9.setBounds(11, 11, 150, 150);
        panelData_9.add(lblDishPhoto_9);
        
        lblDishName_9 = new JLabel("New label");
        lblDishName_9.setForeground(new Color(255, 255, 255));
        lblDishName_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishName_9.setVerticalAlignment(SwingConstants.TOP);
        lblDishName_9.setFont(new Font("Century Gothic", Font.BOLD, 20));
        lblDishName_9.setBounds(160, 40, 157, 50);
        panelData_9.add(lblDishName_9);
        
        lblPrice_9 = new JLabel("New label");
        lblPrice_9.setForeground(new Color(255, 255, 255));
        lblPrice_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrice_9.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPrice_9.setBounds(160, 100, 157, 23);
        panelData_9.add(lblPrice_9);
        
        lblDescription_9 = new JLabel("New label");
        lblDescription_9.setForeground(new Color(255, 255, 255));
        lblDescription_9.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        lblDescription_9.setVerticalAlignment(SwingConstants.TOP);
        lblDescription_9.setBounds(10, 169, 307, 71);
        panelData_9.add(lblDescription_9);
        
        btnPreviousPage = new JButton("<");
        btnPreviousPage.setForeground(new Color(255, 255, 255));
        btnPreviousPage.setBackground(new Color(64, 64, 64));
        btnPreviousPage.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnPreviousPage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnPreviousPage.setBounds(510, 999, 89, 35);
        
        jMiddlePanel.add(btnPreviousPage);
        
        btnNextPage = new JButton(">");
        btnNextPage.setForeground(new Color(255, 255, 255));
        btnNextPage.setBackground(new Color(64, 64, 64));
        btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNextPage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNextPage.setBounds(710, 999, 89, 35);
        jMiddlePanel.add(btnNextPage);
        
        txtPageNumber = new JTextField();
        txtPageNumber.setForeground(new Color(255, 255, 255));
        txtPageNumber.setBackground(new Color(64, 64, 64));
        txtPageNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
        txtPageNumber.setHorizontalAlignment(SwingConstants.CENTER);
        txtPageNumber.setText("0");
        txtPageNumber.setBounds(614, 999, 86, 35);
        jMiddlePanel.add(txtPageNumber);
        txtPageNumber.setColumns(10);
        
        lblAdministratorMenu = new JLabel("Administrator Menu");
        lblAdministratorMenu.setForeground(Color.LIGHT_GRAY);
        lblAdministratorMenu.setFont(new Font("Century Gothic", Font.BOLD, 38));
        lblAdministratorMenu.setBounds(10, 11, 406, 43);
        jMiddlePanel.add(lblAdministratorMenu);
		
        btnPreviousPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 0) {
                    currentPage--;
                    menuPrinter(currentOption, currentPage); 
                } else {
                    JOptionPane.showMessageDialog(null, "You have reached the first page.");
                }
            }
        });

        btnNextPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalPages = getTotalPages(currentOption);
                if (currentPage < totalPages - 1) {
                    currentPage++;
                    menuPrinter(currentOption, currentPage); 
                } else {
                    JOptionPane.showMessageDialog(null, "You have reached the last page.");
                }
            }
        });
		
		
	}
	
	private int getTotalPages(String option) {
	    try {
	        pst = con.prepareStatement("SELECT COUNT(*) FROM " + option);
	        countResult = pst.executeQuery();
	        countResult.next();
	        int totalRows = countResult.getInt(1); 
	        return (int) Math.ceil((double) totalRows / PAGE_SIZE);
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return 0;
	}
	

	
	public String tableSelected(JRadioButton rb1, JRadioButton rb2, JRadioButton rb3, JRadioButton rb4) {
		String option = null;
		
		if(rb1.isSelected()== true) {
			option = "appetizer";
		}
		else if(rb2.isSelected()== true) {
			option = "entree";
		}
		else if(rb3.isSelected()== true) {
			option = "dessert";
		}
		else if(rb4.isSelected()== true){
			option = "drinks";
		}
		return option;
		
	}
	
	public void searchDish (KeyEvent e, JRadioButton rdbtnAppetizer2,JRadioButton rdbtnEntree2, JRadioButton rdbtnDessert2, JRadioButton rdbtnDrinks2) {
		
		try {
			
			String option = tableSelected(rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2);
			
			String id = textDishID.getText();
	        pst = con.prepareStatement("select dish_name,description,price from " +  option + " where id = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            
            
            if(rs.next()==true)
            {
            	
              
            	String dish_name = rs.getString(1);
                String description = rs.getString(2);
                String price = rs.getString(3);
                
                textDishName.setText(dish_name);
                textDescription.setText(description);
                textPrice.setText(price);
                
            }   
            else
            {
                textDishName.setText("");
                textDescription.setText("");
                textPrice.setText("");
                 
            }
        } 
    
     catch (SQLException ex) {
           
        }
	}
	
	public void addDish(ActionEvent e, JRadioButton rb1, JRadioButton  rb2, JRadioButton rb3, JRadioButton rb4, ButtonGroup buttonGroup) {
		refreshPrint();
		String dishName, description, price;
		
		dishName = textDishName.getText();
		description = textDescription.getText();
		price = textPrice.getText();
		
		String option = tableSelected(rb1, rb2, rb3, rb4);
		
		
		try {
			FileInputStream fis = new FileInputStream(f);
	        pst = con.prepareStatement("insert into " +  option + " (dish_name,description,price,image, type)values(?,?,?,?,?)");
	        pst.setString(1, dishName);
	        pst.setString(2, description);
	        pst.setString(3, price);
	        pst.setString(5, path);
	        pst.setBinaryStream(4, fis, (int) f.length());
	        pst.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
	        
	        menuPrinter(currentOption, currentPage);
	        textDishName.setText("");
			textDescription.setText("");
			textPrice.setText("");
			rdbtnGrp1.clearSelection();
			labelImage.setIcon(null);
	        textDishName.requestFocus();
	        
	       }
		
		catch (FileNotFoundException ex) 
        {            
			JOptionPane.showMessageDialog(null, "File Not Found: " + ex.getMessage());
        }
	    catch (SQLException e1) 
	        {            
	    		e1.printStackTrace();
	        }
	}
	
	public void deleteDish(ActionEvent e, JRadioButton rb1, JRadioButton  rb2, JRadioButton rb3, JRadioButton rb4, ButtonGroup buttonGroup) {
		
		String dishID = textDishID.getText();
	    String option = tableSelected(rb1,rb2, rb3, rb4);

        try {

        	PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM " + option + " where id = ?");
        	deleteStatement.setString(1, dishID);
        	deleteStatement.executeUpdate();
        	JOptionPane.showMessageDialog(null, "Record deleted successfully.");

        	textDishName.setText("");
        	textDescription.setText("");
        	textPrice.setText("");
        	textDishID.setText("");
        	textDishName.requestFocus();
        	 
           }
           catch (SQLException e1) {
               
               e1.printStackTrace();
           }
	}
	
	public void updateDish(ActionEvent e, JRadioButton rb1, JRadioButton  rb2, JRadioButton rb3, JRadioButton rb4, ButtonGroup buttonGroup) {
		
		String dishName,description,price,dishID;
        
        
        dishName = textDishName.getText();
        description = textDescription.getText();
        price = textPrice.getText();
        dishID  = textDishID.getText();
        
        String option = tableSelected(rb1,rb2, rb3, rb4);
		
		try {
			
	        pst = con.prepareStatement("update " +  option + " set dish_name = ?,description =?,price=? where id =?");
                pst.setString(1, dishName);
                pst.setString(2, description);
                pst.setString(3, price);
                pst.setString(4, dishID);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Update!!!!!");
               
                textDishName.setText("");
                textDescription.setText("");
                textPrice.setText("");
                textDishName.requestFocus();
                buttonGroup.clearSelection();
            }
            catch (SQLException e1) {
                
                e1.printStackTrace();
            }
	}
	
	public void actionBackPerformed(ActionEvent e){
		OptionsAdmin optionsAdmin = new OptionsAdmin();
		optionsAdmin.setVisible(true);
		this.dispose();
	}
	
	public void jAppetizerButtonActionPerformed(ActionEvent e) {
	    refreshPrint();
	    currentOption = "appetizer";
	    currentPage = 0; 
	    menuPrinter(currentOption, currentPage);
	}

	public void jEntreeButtonActionPerformed(ActionEvent e) {
	    refreshPrint();
	    currentOption = "entree";
	    currentPage = 0; 
	    menuPrinter(currentOption, currentPage);
	}

	public void jDessertButtonActionPerformed(ActionEvent e) {
	    refreshPrint();
	    currentOption = "dessert";
	    currentPage = 0; 
	    menuPrinter(currentOption, currentPage);
	}
	
	public void jDrinksButtonActionPerformed(ActionEvent e) {
	    refreshPrint();
	    currentOption = "drinks";
	    currentPage = 0; 
	    menuPrinter(currentOption, currentPage);
	}

    
	public void menuPrinter(String option, int page) {
	    String dishName, description, price;
	    try {
	        pst = con.prepareStatement("SELECT COUNT(*) FROM " + option);
	        countResult = pst.executeQuery();
	        countResult.next();
	        
	        int offset = page * PAGE_SIZE;

	        pst = con.prepareStatement("SELECT dish_name, description, price, image FROM " + option + " LIMIT ? OFFSET ?");
	        pst.setInt(1, PAGE_SIZE);
	        pst.setInt(2, offset);
	        rs = pst.executeQuery();

	        for (int i = 1; i <= PAGE_SIZE; i++) {
	            getPanelData(i).setVisible(false);
	        }

	        int count = 0;
	        while (rs.next() && count < PAGE_SIZE) {
	            dishName = rs.getString("dish_name");
	            description = rs.getString("description");
	            price = rs.getString("price");

	            Blob imageBlob = rs.getBlob("image");
	            byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
	            ImageIcon imageIcon = new ImageIcon(imageBytes);
	            Image img = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

	            getLabelDishName(count + 1).setText(formatText(dishName, getLabelDishName(count + 1).getFont(), 145));
	            getLabelDescription(count + 1).setText(formatText(description, getLabelDescription(count + 1).getFont(), 280));
	            getLabelPrice(count + 1).setText("Php " + price + "0");
	            getPanelData(count + 1).setVisible(true);
	            getLabelDishPhoto(count + 1).setIcon(new ImageIcon(img));
	            count++;
	        }
	        
	        txtPageNumber.setText(Integer.toString(page + 1));
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

	private JPanel getPanelData(int index) {
	    switch (index) {
	        case 1: return panelData_1;
	        case 2: return panelData_2;
	        case 3: return panelData_3;
	        case 4: return panelData_4;
	        case 5: return panelData_5;
	        case 6: return panelData_6;
	        case 7: return panelData_7;
	        case 8: return panelData_8;
	        case 9: return panelData_9;
	        default: return null;
	    }
	}

	private JLabel getLabelDishName(int index) {
	    switch (index) {
	        case 1: return lblDishName_1;
	        case 2: return lblDishName_2;
	        case 3: return lblDishName_3;
	        case 4: return lblDishName_4;
	        case 5: return lblDishName_5;
	        case 6: return lblDishName_6;
	        case 7: return lblDishName_7;
	        case 8: return lblDishName_8;
	        case 9: return lblDishName_9;
	        default: return null;
	    }
	}

	private JLabel getLabelDescription(int index) {
	    switch (index) {
	        case 1: return lblDescription_1;
	        case 2: return lblDescription_2;
	        case 3: return lblDescription_3;
	        case 4: return lblDescription_4;
	        case 5: return lblDescription_5;
	        case 6: return lblDescription_6;
	        case 7: return lblDescription_7;
	        case 8: return lblDescription_8;
	        case 9: return lblDescription_9;
	        default: return null;
	    }
	}

	private JLabel getLabelPrice(int index) {
	    switch (index) {
	        case 1: return lblPrice_1;
	        case 2: return lblPrice_2;
	        case 3: return lblPrice_3;
	        case 4: return lblPrice_4;
	        case 5: return lblPrice_5;
	        case 6: return lblPrice_6;
	        case 7: return lblPrice_7;
	        case 8: return lblPrice_8;
	        case 9: return lblPrice_9;
	        default: return null;
	    }
	}

	private JLabel getLabelDishPhoto(int index) {
	    switch (index) {
	        case 1: return lblDishPhoto_1;
	        case 2: return lblDishPhoto_2;
	        case 3: return lblDishPhoto_3;
	        case 4: return lblDishPhoto_4;
	        case 5: return lblDishPhoto_5;
	        case 6: return lblDishPhoto_6;
	        case 7: return lblDishPhoto_7;
	        case 8: return lblDishPhoto_8;
	        case 9: return lblDishPhoto_9;
	        default: return null;
	    }
	}
    
    public void refreshPrint() {
    	panelData_1.setVisible(false);
    	panelData_2.setVisible(false);
    	panelData_3.setVisible(false);
    	panelData_4.setVisible(false);
    	panelData_5.setVisible(false);
    	panelData_6.setVisible(false);
    	panelData_7.setVisible(false);
    	panelData_8.setVisible(false);
    	panelData_9.setVisible(false);
    	
    }
    
    private static String formatText(String text, Font font, int width) {
        JLabel tempLabel = new JLabel();
        tempLabel.setFont(font);
        FontMetrics metrics = tempLabel.getFontMetrics(font);

        StringBuilder formattedText = new StringBuilder("<html><body>");
        String[] words = text.split(" ");
        int lineWidth = 0;

        for (String word : words) {
            int wordWidth = metrics.stringWidth(word + " ");
            if (lineWidth + wordWidth > width) {
                formattedText.append("<br>");
                lineWidth = 0;
            }
            formattedText.append(word).append(" ");
            lineWidth += wordWidth;
        }

        formattedText.append("</body></html>");
        return formattedText.toString();
    }
    
	
    int update;
	private JButton btnUpload;
	private JLabel labelImage;
	private String currentOption;
    private int currentPage = 0;
    private final int PAGE_SIZE = 9;
    private JLabel lblDishId;
	private JButton btnEntree;
	private JButton btnAppetizers;
	private JPanel panelCategories;
	private JPanel jMiddlePanel;
	private JButton btnDessert;
	private JButton btnDrinks;
	private JPanel panelEditables;
	private JPanel panel_2;
	private JRadioButton rdbtnAppetizer1;
	private JRadioButton rdbtnEntree1;
	private JRadioButton rdbtnDessert1;
	private JRadioButton rdbtnDrinks1;
	private ButtonGroup rdbtnGrp1;
	private ButtonGroup menubtnGrp1;
	private JButton btnBack;
	private JPanel panel;
	private JRadioButton rdbtnAppetizer2;
	private JRadioButton rdbtnEntree2;
	private JRadioButton rdbtnDessert2;
	private JRadioButton rdbtnDrinks2;
	private ButtonGroup rdbtnGrp2;
	private JButton btnAdd;
	private JLabel lblNewLabel;
	private JLabel lblDescription;
	private JLabel lblPrice;
	private JButton btnUpdate;
	private JButton btnDelete;
    private JTextField textDishID;
    private JPanel panelData_1;
    private JLabel lblDishPhoto_1;
    private JLabel lblDishName_1;
    private JLabel lblDescription_1;
    private JLabel lblPrice_1;
    private JPanel panelData_2;
    private JLabel lblDishPhoto_2;
    private JLabel lblDishName_2;
    private JLabel lblDescription_2;
    private JLabel lblPrice_2;
    private JPanel panelData_3;
    private JLabel lblDishPhoto_3;
    private JLabel lblDishName_3;
    private JLabel lblPrice_3;
    private JLabel lblDescription_3;
    private JPanel panelData_4;
    private JLabel lblDishPhoto_4;
    private JLabel lblDishName_4;
    private JLabel lblPrice_4;
    private JLabel lblDescription_4;
    private JPanel panelData_5;
    private JLabel lblDishPhoto_5;
    private JLabel lblDishName_5;
    private JLabel lblPrice_5;
    private JLabel lblDescription_5;
    private JPanel panelData_6;
    private JLabel lblDishPhoto_6;
    private JLabel lblDishName_6;
    private JLabel lblPrice_6;
    private JLabel lblDescription_6;
    private JPanel panelData_7;
    private JLabel lblDishPhoto_7;
    private JLabel lblDishName_7;
    private JLabel lblPrice_7;
    private JLabel lblDescription_7;
    private JPanel panelData_8;
    private JLabel lblDishPhoto_8;
    private JLabel lblDishName_8;
    private JLabel lblPrice_8;
    private JLabel lblDescription_8;
    private JPanel panelData_9;
    private JLabel lblDishPhoto_9;
    private JLabel lblDishName_9;
    private JLabel lblPrice_9;
    private JLabel lblDescription_9;
	 private JButton btnClose;
	 private JButton btnPreviousPage;
	 private JButton btnNextPage;
	 private JTextField txtPageNumber;
	 private JLabel lblNewLabel_1;
	 private JLabel lblNewLabel_2;
	 private JLabel lblNewLabel_3;
	 private JLabel lblNewLabel_4;
	 private JLabel lblNewLabel_5;
	 private JLabel lblNewLabel_6;
	 private JLabel lblAdministratorMenu;
}
