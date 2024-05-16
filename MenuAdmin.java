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
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.border.BevelBorder;

public class MenuAdmin extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField textDishName;
	private JTextField textDescription;
	private JTextField textPrice;
	
	//kani ako gi usab
	 File f = null;
	    String path = null;
	    private ImageIcon format = null;
	    String fname = null;
	    int s = 0;
	    byte[] pimage = null;
//hangtod ari
	    
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
	private JTextField textDishID;
	
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
	
	AppetizerPage appetizerPage = new AppetizerPage();
	EntreePage entreePage = new EntreePage();
	DessertPage dessertPage = new DessertPage();
	DrinksPage drinksPage = new DrinksPage();
	
	private void initialize() {
		
		JPanel panel_3 = new JPanel();
		panel_3.setFocusable(false);
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(21, 25, 28));
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setBounds(150, 12, 1394, 1055);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(0,0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panelCategories = new JPanel();
		panelCategories.setBackground(new Color(27, 32, 33));
		panelCategories.setFocusable(false);
		panelCategories.setBounds(10, 11, 130, 1058);
		getContentPane().add(panelCategories);
		
		
		
		JButton jButtonAppetizers = new JButton("");
		jButtonAppetizers.setBackground(new Color(27, 32, 33));
		jButtonAppetizers.setAlignmentX(Component.CENTER_ALIGNMENT);
		jButtonAppetizers.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/nachos.png")));
		jButtonAppetizers.setPreferredSize(new Dimension(64, 64));
		jButtonAppetizers.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonAppetizers.setFocusable(false);
		jButtonAppetizers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(1);
			}
		});
		panelCategories.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 30));
		panelCategories.add(jButtonAppetizers);
		
		JButton jButtonEntree = new JButton("");
		jButtonEntree.setBackground(new Color(27, 32, 33));
		jButtonEntree.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/Entree.png")));
		jButtonEntree.setPreferredSize(new Dimension(64, 64));
		jButtonEntree.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonEntree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(2);
				
			}
		});
		jButtonEntree.setFocusable(false);
		panelCategories.add(jButtonEntree);
		
		JButton jButtonDessert = new JButton("");
		jButtonDessert.setBackground(new Color(27, 32, 33));
		jButtonDessert.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/dessert.png")));
		jButtonDessert.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonDessert.setPreferredSize(new Dimension(64, 64));
		jButtonDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(3);
				
			}
		});
		jButtonDessert.setFocusable(false);
		panelCategories.add(jButtonDessert);
		
		JButton jButtonDrinks = new JButton("");
		jButtonDrinks.setBackground(new Color(27, 32, 33));
		jButtonDrinks.setIcon(new ImageIcon(MenuAdmin.class.getResource("/images/drinks.png")));
		jButtonDrinks.setPreferredSize(new Dimension(64, 64));
		jButtonDrinks.setBounds(new Rectangle(0, 0, 64, 64));
		jButtonDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(4);
				
			}
		});
		jButtonDrinks.setFocusable(false);
		panelCategories.add(jButtonDrinks);
		
		JPanel panelEditables = new JPanel();
		panelEditables.setBackground(new Color(27, 32, 33));
		panelEditables.setFocusable(false);
		panelEditables.setLayout(null);
		panelEditables.setBounds(1557, 11, 353, 1058);
		getContentPane().add(panelEditables);
		
		JPanel panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		panel_2.setForeground(new Color(21, 25, 28));
		panel_2.setBackground(new Color(27, 32, 33));
		panel_2.setFocusable(false);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Add Dishes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_2.setBounds(20, 43, 323, 499);
		panelEditables.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnAppetizer1 = new JRadioButton("Appetizer");
		rdbtnAppetizer1.setForeground(new Color(255, 255, 255));
		rdbtnAppetizer1.setBackground(new Color(27, 32, 33));
		rdbtnAppetizer1.setFocusable(false);
		rdbtnAppetizer1.setBounds(47, 185, 88, 23);
		panel_2.add(rdbtnAppetizer1);
		
		JRadioButton rdbtnEntree1 = new JRadioButton("Entree");
		rdbtnEntree1.setForeground(new Color(255, 255, 255));
		rdbtnEntree1.setBackground(new Color(27, 32, 33));
		rdbtnEntree1.setFocusable(false);
		rdbtnEntree1.setBounds(186, 185, 71, 23);
		panel_2.add(rdbtnEntree1);
		
		JRadioButton rdbtnDessert1 = new JRadioButton("Dessert");
		rdbtnDessert1.setBackground(new Color(27, 32, 33));
		rdbtnDessert1.setForeground(new Color(255, 255, 255));
		rdbtnDessert1.setFocusable(false);
		rdbtnDessert1.setBounds(47, 211, 71, 23);
		panel_2.add(rdbtnDessert1);
		
		JRadioButton rdbtnDrinks1 = new JRadioButton("Drinks");
		rdbtnDrinks1.setForeground(new Color(255, 255, 255));
		rdbtnDrinks1.setBackground(new Color(27, 32, 33));
		rdbtnDrinks1.setFocusTraversalPolicyProvider(true);
		rdbtnDrinks1.setFocusable(false);
		rdbtnDrinks1.setBounds(186, 211, 71, 23);
		panel_2.add(rdbtnDrinks1);
		
		ButtonGroup rdbtnGrp1 = new ButtonGroup();{
			rdbtnGrp1.add(rdbtnAppetizer1);
			rdbtnGrp1.add(rdbtnEntree1);
			rdbtnGrp1.add(rdbtnDessert1);
			rdbtnGrp1.add(rdbtnDrinks1);
		}
		
		ButtonGroup menubtnGrp1 = new ButtonGroup();{
			menubtnGrp1.add(jButtonAppetizers);
			menubtnGrp1.add(jButtonEntree);
			menubtnGrp1.add(jButtonDessert);
			menubtnGrp1.add(jButtonDrinks);
		}
		JButton jButtonBack = new JButton("");
		jButtonBack.setBackground(new Color(27, 32, 33));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(27, 32, 33));
		panel.setFocusable(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0)), "Search Dish", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(32, 622, 312, 118);
		panelEditables.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnAppetizer2 = new JRadioButton("Appetizer");
		rdbtnAppetizer2.setForeground(new Color(255, 255, 255));
		rdbtnAppetizer2.setBackground(new Color(27, 32, 33));
		rdbtnAppetizer2.setFocusable(false);
		rdbtnAppetizer2.setBounds(47, 20, 88, 23);
		panel.add(rdbtnAppetizer2);
		
		JRadioButton rdbtnEntree2 = new JRadioButton("Entree");
		rdbtnEntree2.setForeground(new Color(255, 255, 255));
		rdbtnEntree2.setBackground(new Color(27, 32, 33));
		rdbtnEntree2.setFocusable(false);
		rdbtnEntree2.setBounds(186, 20, 71, 23);
		panel.add(rdbtnEntree2);
		
		JRadioButton rdbtnDessert2 = new JRadioButton("Dessert");
		rdbtnDessert2.setBackground(new Color(27, 32, 33));
		rdbtnDessert2.setForeground(new Color(255, 255, 255));
		rdbtnDessert2.setFocusable(false);
		rdbtnDessert2.setBounds(47, 46, 71, 23);
		panel.add(rdbtnDessert2);
		
		JRadioButton rdbtnDrinks2 = new JRadioButton("Drinks");
		rdbtnDrinks2.setBackground(new Color(27, 32, 33));
		rdbtnDrinks2.setForeground(new Color(255, 255, 255));
		rdbtnDrinks2.setFocusable(false);
		rdbtnDrinks2.setFocusTraversalPolicyProvider(true);
		rdbtnDrinks2.setBounds(186, 46, 71, 23);
		panel.add(rdbtnDrinks2);
		
		ButtonGroup rdbtnGrp2 = new ButtonGroup();{
			rdbtnGrp2.add(rdbtnAppetizer2);
			rdbtnGrp2.add(rdbtnEntree2);
			rdbtnGrp2.add(rdbtnDessert2);
			rdbtnGrp2.add(rdbtnDrinks2);
		}
		
		
		JLabel lblDishId = new JLabel("Dish ID");
		lblDishId.setForeground(new Color(255, 255, 255));
		lblDishId.setBounds(20, 82, 62, 17);
		panel.add(lblDishId);
		lblDishId.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFocusable(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addDish(e, rdbtnAppetizer1,rdbtnEntree1, rdbtnDessert1, rdbtnDrinks1, rdbtnGrp1 );
				
			}
		});
		btnAdd.setBounds(32, 553, 96, 47);
		panelEditables.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFocusable(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteDish(e, rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2, rdbtnGrp2);
				
			}
		});
		btnDelete.setBounds(31, 835, 292, 37);
		panelEditables.add(btnDelete);
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 28, 48, 27);
		panel_2.add(lblNewLabel);
		
		textDishName = new JTextField();
		textDishName.setBounds(108, 33, 185, 20);
		panel_2.add(textDishName);
		textDishName.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setFocusable(false);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 79, 88, 27);
		panel_2.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		textDescription.setBounds(108, 84, 185, 20);
		panel_2.add(textDescription);
		
		JLabel lblPrice = new JLabel("Upload Image");
		lblPrice.setForeground(new Color(255, 255, 255));
		lblPrice.setBackground(new Color(21, 25, 28));
		lblPrice.setFocusable(false);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 256, 125, 27);
		panel_2.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(108, 141, 185, 20);
		panel_2.add(textPrice);
		
		JLabel lblPrice_1 = new JLabel("Price");
		lblPrice_1.setForeground(Color.WHITE);
		lblPrice_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice_1.setFocusable(false);
		lblPrice_1.setBackground(new Color(21, 25, 28));
		lblPrice_1.setBounds(10, 136, 88, 27);
		panel_2.add(lblPrice_1);
		
		JLabel labelImage = new JLabel("");
		labelImage.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0), new Color(0, 0, 0)));
		labelImage.setForeground(Color.WHITE);
		labelImage.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelImage.setFocusable(false);
		labelImage.setBackground(new Color(255, 255, 255));
		labelImage.setBounds(10, 282, 303, 147);
		panel_2.add(labelImage);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//kani
				JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG", "png", "jpeg", "jpg");
		        fileChooser.addChoosableFileFilter(fnwf);
		        int load = fileChooser.showOpenDialog(null);
		        
		        if(load==fileChooser.APPROVE_OPTION){
		            f = fileChooser.getSelectedFile();
		            
		            path = f.getAbsolutePath();
		            //imagePath.setText(path);
		            ImageIcon ii = new ImageIcon(path);
		            Image img = ii.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		            
		            labelImage.setIcon(new ImageIcon(img));
		            //hangtod diri
		        }
			}
		});
		btnUpload.setFocusable(false);
		btnUpload.setBounds(10, 440, 303, 37);
		panel_2.add(btnUpload);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				updateDish(e, rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2, rdbtnGrp2);
				
			}
		});
		btnUpdate.setFocusable(false);
		btnUpdate.setBounds(31, 771, 292, 37);
		panelEditables.add(btnUpdate);
		
	}
	
	public void menuRefresh(int value) {
		
		switch(value) {
		case 1:{
			appetizerPage.setVisible(true);
			entreePage.dispose();
			dessertPage.dispose();
			drinksPage.dispose();
			break;
		}
		
		case 2:{
			entreePage.setVisible(true);
			dessertPage.dispose();
			drinksPage.dispose();
			appetizerPage.dispose();
			break;
		}
		
		case 3:{
			dessertPage.setVisible(true);
			appetizerPage.dispose();
			entreePage.dispose();
			drinksPage.dispose();
			break;
		}
		
		case 4:{
			drinksPage.setVisible(true);
			appetizerPage.dispose();
			entreePage.dispose();
			dessertPage.dispose();
			break;
		}
		}
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
            ResultSet rs = pst.executeQuery();
            
            
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
		
		String dishName, description, price;
		
		dishName = textDishName.getText();
		description = textDescription.getText();
		price = textPrice.getText();
		
		String option = tableSelected(rb1, rb2, rb3, rb4);
		
		try {
			
	        pst = con.prepareStatement("insert into " +  option + " (dish_name,description,price)values(?,?,?)");
	        pst.setString(1, dishName);
	        pst.setString(2, description);
	        pst.setString(3, price);
	        pst.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
	        
	        appetizerPage.setVisible(true);
			entreePage.dispose();
			dessertPage.dispose();
			drinksPage.dispose();
	        
	        textDishName.setText("");
	        textDescription.setText("");
	        textPrice.setText("");
	        textDishName.requestFocus();
	        buttonGroup.clearSelection();
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
}
