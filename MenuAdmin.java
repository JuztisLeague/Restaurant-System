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
import javax.swing.border.EmptyBorder;

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
		getContentPane().setBackground(new Color(0, 0, 0));
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
	
	int update;
	private JButton jButtonUpload;
	private JLabel labelImage;
	private java.sql.Blob imageBlob;
	
	private void initialize() {
		
		jMiddlePanel = new JPanel();
		jMiddlePanel.setFocusable(false);
		jMiddlePanel.setBorder(null);
		jMiddlePanel.setBackground(new Color(21, 25, 28));
		jMiddlePanel.setForeground(new Color(255, 255, 255));
		jMiddlePanel.setBounds(109, 0, 1321, 1080);
		getContentPane().add(jMiddlePanel);
		jMiddlePanel.setLayout(null);
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(0,0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panelCategories = new JPanel();
		panelCategories.setBackground(new Color(21, 25, 28));
		panelCategories.setFocusable(false);
		panelCategories.setBounds(0, 0, 103, 1080);
		getContentPane().add(panelCategories);
		
		
		
		jButtonAppetizers = new JButton("");
		jButtonAppetizers.setBorder(null);
		jButtonAppetizers.setBackground(new Color(21, 25, 28));
		jButtonAppetizers.setAlignmentX(Component.CENTER_ALIGNMENT);
		jButtonAppetizers.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/nachos.png")));
		jButtonAppetizers.setPreferredSize(new Dimension(64, 64));
		jButtonAppetizers.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonAppetizers.setFocusable(false);
		jButtonAppetizers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jAppetizerButtonActionPerformed(e);
			}
		});
		panelCategories.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
		panelCategories.add(jButtonAppetizers);
		
		jButtonEntree = new JButton("");
		jButtonEntree.setBorder(null);
		jButtonEntree.setBackground(new Color(21, 25, 28));
		jButtonEntree.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/Entree.png")));
		jButtonEntree.setPreferredSize(new Dimension(64, 64));
		jButtonEntree.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonEntree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jEntreeButtonActionPerformed(e);
				
			}
		});
		jButtonEntree.setFocusable(false);
		panelCategories.add(jButtonEntree);
		
		jButtonDessert = new JButton("");
		jButtonDessert.setBorder(null);
		jButtonDessert.setBackground(new Color(21, 25, 28));
		jButtonDessert.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/dessert.png")));
		jButtonDessert.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonDessert.setPreferredSize(new Dimension(64, 64));
		jButtonDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jDessertButtonActionPerformed(e);
				
			}
		});
		jButtonDessert.setFocusable(false);
		panelCategories.add(jButtonDessert);
		
		jButtonDrinks = new JButton("");
		jButtonDrinks.setBorder(null);
		jButtonDrinks.setBackground(new Color(21, 25, 28));
		jButtonDrinks.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/drinks.png")));
		jButtonDrinks.setPreferredSize(new Dimension(64, 64));
		jButtonDrinks.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jDrinksButtonActionPerformed(e);
				
			}
		});
		jButtonDrinks.setFocusable(false);
		panelCategories.add(jButtonDrinks);
		
		panelEditables = new JPanel();
		panelEditables.setOpaque(false);
		panelEditables.setBackground(new Color(21, 25, 28));
		panelEditables.setFocusable(false);
		panelEditables.setLayout(null);
		panelEditables.setBounds(1436, 0, 495, 1080);
		getContentPane().add(panelEditables);
		
		panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(new Color(44, 44, 44));
		panel_2.setFocusable(false);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Dishes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_2.setBounds(70, 43, 325, 513);
		panelEditables.add(panel_2);
		panel_2.setLayout(null);
		
		rdbtnAppetizer1 = new JRadioButton("Appetizer");
		rdbtnAppetizer1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnAppetizer1.setBackground(new Color(44, 44, 44));
		rdbtnAppetizer1.setForeground(new Color(255, 255, 255));
		rdbtnAppetizer1.setFocusable(false);
		rdbtnAppetizer1.setBounds(47, 185, 88, 23);
		panel_2.add(rdbtnAppetizer1);
		
		rdbtnEntree1 = new JRadioButton("Entree");
		rdbtnEntree1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnEntree1.setBackground(new Color(44, 44, 44));
		rdbtnEntree1.setForeground(new Color(255, 255, 255));
		rdbtnEntree1.setFocusable(false);
		rdbtnEntree1.setBounds(186, 185, 71, 23);
		panel_2.add(rdbtnEntree1);
		
		rdbtnDessert1 = new JRadioButton("Dessert");
		rdbtnDessert1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnDessert1.setBackground(new Color(44, 44, 44));
		rdbtnDessert1.setForeground(new Color(255, 255, 255));
		rdbtnDessert1.setFocusable(false);
		rdbtnDessert1.setBounds(47, 211, 71, 23);
		panel_2.add(rdbtnDessert1);
		
		rdbtnDrinks1 = new JRadioButton("Drinks");
		rdbtnDrinks1.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnDrinks1.setBackground(new Color(44, 44, 44));
		rdbtnDrinks1.setForeground(new Color(255, 255, 255));
		rdbtnDrinks1.setFocusTraversalPolicyProvider(true);
		rdbtnDrinks1.setFocusable(false);
		rdbtnDrinks1.setBounds(186, 211, 71, 23);
		panel_2.add(rdbtnDrinks1);
		
		rdbtnGrp1 = new ButtonGroup();{
			rdbtnGrp1.add(rdbtnAppetizer1);
			rdbtnGrp1.add(rdbtnEntree1);
			rdbtnGrp1.add(rdbtnDessert1);
			rdbtnGrp1.add(rdbtnDrinks1);
		}
		
		menubtnGrp1 = new ButtonGroup();{
			menubtnGrp1.add(jButtonAppetizers);
			menubtnGrp1.add(jButtonEntree);
			menubtnGrp1.add(jButtonDessert);
			menubtnGrp1.add(jButtonDrinks);
		}
		jButtonBack = new JButton("");
		jButtonBack.setBorder(null);
		jButtonBack.setBackground(new Color(21, 25, 28));
		jButtonBack.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/left-arrow.png")));
		jButtonBack.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonBack.setPreferredSize(new Dimension(64, 64));
		jButtonBack.setFocusable(false);
		jButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actionBackPerformed(e);
			}
		});
		panelCategories.add(jButtonBack);
		
		panel = new JPanel();
		panel.setBackground(new Color(44, 44, 44));
		panel.setFocusable(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search Dish", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(70, 680, 325, 120);
		panelEditables.add(panel);
		panel.setLayout(null);
		
		rdbtnAppetizer2 = new JRadioButton("Appetizer");
		rdbtnAppetizer2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnAppetizer2.setForeground(new Color(255, 255, 255));
		rdbtnAppetizer2.setBackground(new Color(44, 44, 44));
		rdbtnAppetizer2.setFocusable(false);
		rdbtnAppetizer2.setBounds(47, 20, 88, 23);
		panel.add(rdbtnAppetizer2);
		
		rdbtnEntree2 = new JRadioButton("Entree");
		rdbtnEntree2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnEntree2.setForeground(new Color(255, 255, 255));
		rdbtnEntree2.setBackground(new Color(44, 44, 44));
		rdbtnEntree2.setFocusable(false);
		rdbtnEntree2.setBounds(186, 20, 71, 23);
		panel.add(rdbtnEntree2);
		
		rdbtnDessert2 = new JRadioButton("Dessert");
		rdbtnDessert2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnDessert2.setForeground(new Color(255, 255, 255));
		rdbtnDessert2.setBackground(new Color(44, 44, 44));
		rdbtnDessert2.setFocusable(false);
		rdbtnDessert2.setBounds(47, 46, 71, 23);
		panel.add(rdbtnDessert2);
		
		rdbtnDrinks2 = new JRadioButton("Drinks");
		rdbtnDrinks2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		rdbtnDrinks2.setForeground(new Color(255, 255, 255));
		rdbtnDrinks2.setBackground(new Color(44, 44, 44));
		rdbtnDrinks2.setFocusable(false);
		rdbtnDrinks2.setFocusTraversalPolicyProvider(true);
		rdbtnDrinks2.setBounds(186, 46, 71, 23);
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
        labelImage.setBounds(10, 282, 303, 147);
        panel_2.add(labelImage);
	        
		
		
		lblDishId = new JLabel("Dish ID");
		lblDishId.setForeground(new Color(255, 255, 255));
		lblDishId.setBounds(20, 82, 62, 17);
		panel.add(lblDishId);
		lblDishId.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblDishId.setFocusable(false);
		
		textDishID = new JTextField();
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
		textDishID.setBounds(116, 82, 186, 20);
		panel.add(textDishID);
		textDishID.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addDish(e, rdbtnAppetizer1,rdbtnEntree1, rdbtnDessert1, rdbtnDrinks1, rdbtnGrp1 );
				
			}
		});
		btnAdd.setBounds(190, 567, 96, 47);
		panelEditables.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFocusable(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteDish(e, rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2, rdbtnGrp2);
				
			}
		});
		btnDelete.setBounds(242, 819, 150, 37);
		panelEditables.add(btnDelete);
		
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 28, 48, 27);
		panel_2.add(lblNewLabel);
		
		textDishName = new JTextField();
		textDishName.setBounds(108, 33, 185, 20);
		panel_2.add(textDishName);
		textDishName.setColumns(10);
		
		lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setFocusable(false);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 79, 88, 27);
		panel_2.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		textDescription.setBounds(108, 84, 185, 20);
		panel_2.add(textDescription);
		
		lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setBackground(new Color(21, 25, 28));
		lblPrice.setFocusable(false);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 136, 88, 27);
		panel_2.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(108, 141, 185, 20);
		panel_2.add(textPrice);
		
		jButtonUpload = new JButton("Upload");
		jButtonUpload.setForeground(new Color(255, 255, 255));
		jButtonUpload.setOpaque(false);
		jButtonUpload.setBackground(new Color(44, 44, 44));
		jButtonUpload.setBorder(null);
		jButtonUpload.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		jButtonUpload.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/upload.png")));
		jButtonUpload.setBounds(108, 445, 115, 47);
		panel_2.add(jButtonUpload);
		jButtonUpload.addActionListener(new ActionListener() {
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
		
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				updateDish(e, rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2, rdbtnGrp2);
				
			}
		});
		btnUpdate.setFocusable(false);
		btnUpdate.setBounds(70, 819, 150, 37);
		panelEditables.add(btnUpdate);
		
		jButtonClose = new JButton("");
		jButtonClose.setBackground(new Color(21, 25, 28));
		jButtonClose.setPreferredSize(new Dimension(64, 64));
		jButtonClose.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/cancel.png")));
		jButtonClose.setBorder(null);
		jButtonClose.setBounds(410, 10, 64, 64);
		panelEditables.add(jButtonClose);
		jButtonClose.setFocusable(false);
		jButtonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jButtonClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		
		panelData_1 = new JPanel();
        panelData_1.setBounds(47, 79, 327, 251);
        
        lblNumber = new JLabel("Numbers");
        lblNumber.setBounds(10, 11, 248, 50);
        lblNumber.setForeground(new Color(255, 255, 255));
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panelData_1.setLayout(null);
        panelData_1.setVisible(false);
        jMiddlePanel.setLayout(null);
        jMiddlePanel.add(lblNumber);
        jMiddlePanel.add(panelData_1);
        
        lblDishPhoto_1 = new JLabel("");
        lblDishPhoto_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_1.setBounds(0, 0, 150, 150);
        panelData_1.add(lblDishPhoto_1);
        
        lblDishName_1 = new JLabel("New label");
        lblDishName_1.setBounds(172, 22, 72, 14);
        panelData_1.add(lblDishName_1);
        
        lblPrice_1 = new JLabel("New label");
        lblPrice_1.setBounds(172, 71, 96, 14);
        panelData_1.add(lblPrice_1);
        
        lblDescription_1 = new JLabel("New label");
        lblDescription_1.setBounds(20, 150, 96, 14);
        panelData_1.add(lblDescription_1);
        
        panelData_2 = new JPanel();
        panelData_2.setBounds(491, 79, 327, 251);
        jMiddlePanel.add(panelData_2);
        panelData_2.setLayout(null);
        panelData_2.setVisible(false);
        
        lblDishPhoto_2 = new JLabel("");
        lblDishPhoto_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_2.setBounds(0, 0, 150, 150);
        panelData_2.add(lblDishPhoto_2);
        
        lblDishName_2 = new JLabel("New label");
        lblDishName_2.setBounds(172, 22, 72, 14);
        panelData_2.add(lblDishName_2);
        
        lblPrice_2 = new JLabel("New label");
        lblPrice_2.setBounds(172, 71, 96, 14);
        panelData_2.add(lblPrice_2);
        
        lblDescription_2 = new JLabel("New label");
        lblDescription_2.setBounds(20, 150, 96, 14);
        panelData_2.add(lblDescription_2);
        
        panelData_3 = new JPanel();
        panelData_3.setBounds(933, 79, 327, 251);
        jMiddlePanel.add(panelData_3);
        panelData_3.setLayout(null);
        panelData_3.setVisible(false);
        
        lblDishPhoto_3 = new JLabel("");
        lblDishPhoto_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_3.setBounds(0, 0, 150, 150);
        panelData_3.add(lblDishPhoto_3);
        
        lblDishName_3 = new JLabel("New label");
        lblDishName_3.setBounds(172, 22, 72, 14);
        panelData_3.add(lblDishName_3);
        
        lblPrice_3 = new JLabel("New label");
        lblPrice_3.setBounds(172, 71, 96, 14);
        panelData_3.add(lblPrice_3);
        
        lblDescription_3 = new JLabel("New label");
        lblDescription_3.setBounds(20, 150, 96, 14);
        panelData_3.add(lblDescription_3);
        
        panelData_4 = new JPanel();
        panelData_4.setLayout(null);
        panelData_4.setBounds(47, 391, 327, 251);
        jMiddlePanel.add(panelData_4);
        panelData_4.setVisible(false);
        
        lblDishPhoto_4 = new JLabel("");
        lblDishPhoto_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_4.setBounds(0, 0, 150, 150);
        panelData_4.add(lblDishPhoto_4);
        
        lblDishName_4 = new JLabel("New label");
        lblDishName_4.setBounds(172, 22, 72, 14);
        panelData_4.add(lblDishName_4);
        
        lblPrice_4 = new JLabel("New label");
        lblPrice_4.setBounds(172, 71, 96, 14);
        panelData_4.add(lblPrice_4);
        
        lblDescription_4 = new JLabel("New label");
        lblDescription_4.setBounds(20, 150, 96, 14);
        panelData_4.add(lblDescription_4);
        
        panelData_5 = new JPanel();
        panelData_5.setLayout(null);
        panelData_5.setBounds(491, 391, 327, 251);
        jMiddlePanel.add(panelData_5);
        panelData_5.setVisible(false);
        
        lblDishPhoto_5 = new JLabel("");
        lblDishPhoto_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_5.setBounds(0, 0, 150, 150);
        panelData_5.add(lblDishPhoto_5);
        
        lblDishName_5 = new JLabel("New label");
        lblDishName_5.setBounds(172, 22, 72, 14);
        panelData_5.add(lblDishName_5);
        
        lblPrice_5 = new JLabel("New label");
        lblPrice_5.setBounds(172, 71, 96, 14);
        panelData_5.add(lblPrice_5);
        
        lblDescription_5 = new JLabel("New label");
        lblDescription_5.setBounds(20, 150, 96, 14);
        panelData_5.add(lblDescription_5);
        
        panelData_6 = new JPanel();
        panelData_6.setLayout(null);
        panelData_6.setBounds(933, 391, 327, 251);
        jMiddlePanel.add(panelData_6);
        panelData_6.setVisible(false);
        
        lblDishPhoto_6 = new JLabel("");
        lblDishPhoto_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_6.setBounds(0, 0, 150, 150);
        panelData_6.add(lblDishPhoto_6);
        
        lblDishName_6 = new JLabel("New label");
        lblDishName_6.setBounds(172, 22, 72, 14);
        panelData_6.add(lblDishName_6);
        
        lblPrice_6 = new JLabel("New label");
        lblPrice_6.setBounds(172, 71, 96, 14);
        panelData_6.add(lblPrice_6);
        
        lblDescription_6 = new JLabel("New label");
        lblDescription_6.setBounds(20, 150, 96, 14);
        panelData_6.add(lblDescription_6);
        
        panelData_7 = new JPanel();
        panelData_7.setLayout(null);
        panelData_7.setBounds(47, 704, 327, 251);
        jMiddlePanel.add(panelData_7);
        panelData_7.setVisible(false);
        
        lblDishPhoto_7 = new JLabel("");
        lblDishPhoto_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_7.setBounds(0, 0, 150, 150);
        panelData_7.add(lblDishPhoto_7);
        
        lblDishName_7 = new JLabel("New label");
        lblDishName_7.setBounds(172, 22, 72, 14);
        panelData_7.add(lblDishName_7);
        
        lblPrice_7 = new JLabel("New label");
        lblPrice_7.setBounds(172, 71, 96, 14);
        panelData_7.add(lblPrice_7);
        
        lblDescription_7 = new JLabel("New label");
        lblDescription_7.setBounds(20, 150, 96, 14);
        panelData_7.add(lblDescription_7);
        
        panelData_8 = new JPanel();
        panelData_8.setLayout(null);
        panelData_8.setBounds(491, 704, 327, 251);
        jMiddlePanel.add(panelData_8);
        panelData_8.setVisible(false);
        
        lblDishPhoto_8 = new JLabel("");
        lblDishPhoto_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_8.setBounds(0, 0, 150, 150);
        panelData_8.add(lblDishPhoto_8);
        
        lblDishName_8 = new JLabel("New label");
        lblDishName_8.setBounds(172, 22, 72, 14);
        panelData_8.add(lblDishName_8);
        
        lblPrice_8 = new JLabel("New label");
        lblPrice_8.setBounds(172, 71, 96, 14);
        panelData_8.add(lblPrice_8);
        
        lblDescription_8 = new JLabel("New label");
        lblDescription_8.setBounds(20, 150, 96, 14);
        panelData_8.add(lblDescription_8);
        
        panelData_9 = new JPanel();
        panelData_9.setLayout(null);
        panelData_9.setBounds(933, 704, 327, 251);
        jMiddlePanel.add(panelData_9);
        panelData_9.setVisible(false);
        
        lblDishPhoto_9 = new JLabel("");
        lblDishPhoto_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblDishPhoto_9.setBounds(0, 0, 150, 150);
        panelData_9.add(lblDishPhoto_9);
        
        lblDishName_9 = new JLabel("New label");
        lblDishName_9.setBounds(172, 22, 72, 14);
        panelData_9.add(lblDishName_9);
        
        lblPrice_9 = new JLabel("New label");
        lblPrice_9.setBounds(172, 71, 96, 14);
        panelData_9.add(lblPrice_9);
        
        lblDescription_9 = new JLabel("New label");
        lblDescription_9.setBounds(20, 150, 96, 14);
        panelData_9.add(lblDescription_9);
		
		
		
		
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
		
		String dishName, description, price, type;
		
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
	        pst.setString(4, path);
	        pst.setBinaryStream(5, fis, (int) f.length());
	        pst.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
	        
	        menuPrinter(option);
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
    	menuPrinter("appetizer");
    }
    public void jEntreeButtonActionPerformed(ActionEvent e) {
    	
    	refreshPrint();
    	menuPrinter("entree");
    }
    public void jDessertButtonActionPerformed(ActionEvent e) {
	
    	refreshPrint();
    	menuPrinter("dessert");
    }
    public void jDrinksButtonActionPerformed(ActionEvent e) {
	
    	refreshPrint();
    	menuPrinter("drinks");
	}
    
    public void menuPrinter(String option) {
    	String dishName,description,price;
    	int totalRows = 0;
    	try {
	    	pst = con.prepareStatement("SELECT COUNT(*) FROM " + option);
	        countResult = pst.executeQuery();
	        countResult.next();
	        totalRows = countResult.getInt(1); // Total number of rows in the ResultSet
	        String total  = Integer.toString(totalRows);
	        // Set the limit to the total number of rows
	        int limit = totalRows + update;
	        
	        
	        lblNumber.setText(total);
	        pst = con.prepareStatement("select dish_name,description,price,image, type from " + option);
	        rs = pst.executeQuery();
	        
	        int count = 0;
	        while (rs.next() && count < limit) {
	            dishName = rs.getString("dish_name");
	            description = rs.getString("description");
	            price = rs.getString("price");
	            
	            
	            imageBlob = rs.getBlob("image");
				byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
	   	 		ImageIcon imageIcon = new ImageIcon(imageBytes);
	   		 	Image img = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	            
	            switch (count) {
	                case 0:
	                    lblDishName_1.setText(dishName);
	                    lblDescription_1.setText(description);
	                    lblPrice_1.setText(price);
	                    panelData_1.setVisible(true);
	                    lblDishPhoto_1.setIcon(new ImageIcon(img));
	                    break;
	                case 1:
	                	lblDishName_2.setText(dishName);
	                    lblDescription_2.setText(description);
	                    lblPrice_2.setText(price);
	                    panelData_2.setVisible(true);
	                    lblDishPhoto_2.setIcon(new ImageIcon(img));
	                    break;
	                case 2:
	                	lblDishName_3.setText(dishName);
	                    lblDescription_3.setText(description);
	                    lblPrice_3.setText(price);
	                    panelData_3.setVisible(true);
	                    lblDishPhoto_3.setIcon(new ImageIcon(img));
	                    break;
	                case 3:
	                	lblDishName_4.setText(dishName);
	                    lblDescription_4.setText(description);
	                    lblPrice_4.setText(price);
	                    panelData_4.setVisible(true);
	                    lblDishPhoto_4.setIcon(new ImageIcon(img));
	                    break;
	                case 4:
	                	lblDishName_5.setText(dishName);
	                    lblDescription_5.setText(description);
	                    lblPrice_5.setText(price);
	                    panelData_5.setVisible(true);
	                    lblDishPhoto_5.setIcon(new ImageIcon(img));
	                    break;
	                case 5:
	                	lblDishName_6.setText(dishName);
	                    lblDescription_6.setText(description);
	                    lblPrice_6.setText(price);
	                    panelData_6.setVisible(true);
	                    lblDishPhoto_6.setIcon(new ImageIcon(img));
	                    break;
	                case 6:
	                	lblDishName_7.setText(dishName);
	                    lblDescription_7.setText(description);
	                    lblPrice_7.setText(price);
	                    panelData_7.setVisible(true);
	                    lblDishPhoto_7.setIcon(new ImageIcon(img));
	                    break;
	                case 7:
	                	lblDishName_8.setText(dishName);
	                    lblDescription_8.setText(description);
	                    lblPrice_8.setText(price);
	                    panelData_8.setVisible(true);
	                    lblDishPhoto_8.setIcon(new ImageIcon(img));
	                    break;
	                case 8:
	                	lblDishName_9.setText(dishName);
	                    lblDescription_9.setText(description);
	                    lblPrice_9.setText(price);
	                    panelData_9.setVisible(true);
	                    lblDishPhoto_9.setIcon(new ImageIcon(img));
	                    break;
	            }
	            count++;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
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
	
    
    private JLabel lblDishId;
	private JButton jButtonEntree;
	private JButton jButtonAppetizers;
	private JPanel panelCategories;
	private JPanel jMiddlePanel;
	private JButton jButtonDessert;
	private JButton jButtonDrinks;
	private JPanel panelEditables;
	private JPanel panel_2;
	private JRadioButton rdbtnAppetizer1;
	private JRadioButton rdbtnEntree1;
	private JRadioButton rdbtnDessert1;
	private JRadioButton rdbtnDrinks1;
	private ButtonGroup rdbtnGrp1;
	private ButtonGroup menubtnGrp1;
	private JButton jButtonBack;
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
    private JLabel lblNumber;
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
	 private JButton jButtonClose;
}
