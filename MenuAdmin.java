package BonAppetit;

import java.awt.EventQueue;

//import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Frame;
//import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuAdmin extends javax.swing.JFrame{

	//private JFrame frame;
	private JTextField textDishName;
	private JTextField textDescription;
	private JTextField textPrice;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public MenuAdmin() {
		setUndecorated(true);
		getContentPane().setFocusable(false);
		initialize();
		connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
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
	        ex.printStackTrace(); // Handle or log the ClassNotFoundException
	        JOptionPane.showMessageDialog(null, "Failed to connect to database. ClassNotFoundException: " + ex.getMessage());
	    } catch (SQLException ex) {
	        ex.printStackTrace(); // Handle or log the SQLException
	        JOptionPane.showMessageDialog(null, "Failed to connect to database. SQLException: " + ex.getMessage());
	    }
	}
	
	AppetizerPage appetizerPage = new AppetizerPage();
	EntreePage entreePage = new EntreePage();
	DessertPage dessertPage = new DessertPage();
	DrinksPage drinksPage = new DrinksPage();
	//int refreshKey = 0;
	
	
	private void initialize() {
		
		JPanel panel_3 = new JPanel();
		panel_3.setFocusable(false);
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBounds(328, 12, 1216, 1055);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(0,0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panelCategories = new JPanel();
		panelCategories.setFocusable(false);
		panelCategories.setBounds(10, 11, 308, 1058);
		getContentPane().add(panelCategories);
		panelCategories.setLayout(null);
		
		
		
		JButton btnAppetizers = new JButton("Appetizers");
		btnAppetizers.setFocusable(false);
		btnAppetizers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(1);
			}
		});
		btnAppetizers.setBounds(20, 111, 254, 23);
		panelCategories.add(btnAppetizers);
		
		JButton btnEntree = new JButton("Entree");
		btnEntree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(2);
				
			}
		});
		btnEntree.setFocusable(false);
		btnEntree.setBounds(20, 164, 254, 23);
		panelCategories.add(btnEntree);
		
		JButton btnDessert = new JButton("Desert");
		btnDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(3);
				
			}
		});
		btnDessert.setFocusable(false);
		btnDessert.setBounds(20, 215, 254, 23);
		panelCategories.add(btnDessert);
		
		JButton btnDrinks = new JButton("Drinks");
		btnDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menuRefresh(4);
				
			}
		});
		btnDrinks.setFocusable(false);
		btnDrinks.setBounds(20, 274, 254, 23);
		panelCategories.add(btnDrinks);
		
		JPanel panelEditables = new JPanel();
		panelEditables.setFocusable(false);
		panelEditables.setLayout(null);
		panelEditables.setBounds(1557, 11, 353, 1058);
		getContentPane().add(panelEditables);
		
		JPanel panel_2 = new JPanel();
		panel_2.setFocusable(false);
		panel_2.setBorder(new TitledBorder(null, "Add Dishes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(20, 43, 323, 256);
		panelEditables.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnAppetizer1 = new JRadioButton("Appetizer");
		rdbtnAppetizer1.setFocusable(false);
		rdbtnAppetizer1.setBounds(47, 185, 88, 23);
		panel_2.add(rdbtnAppetizer1);
		
		JRadioButton rdbtnEntree1 = new JRadioButton("Entree");
		rdbtnEntree1.setFocusable(false);
		rdbtnEntree1.setBounds(186, 185, 71, 23);
		panel_2.add(rdbtnEntree1);
		
		JRadioButton rdbtnDessert1 = new JRadioButton("Dessert");
		rdbtnDessert1.setFocusable(false);
		rdbtnDessert1.setBounds(47, 211, 71, 23);
		panel_2.add(rdbtnDessert1);
		
		JRadioButton rdbtnDrinks1 = new JRadioButton("Drinks");
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
			menubtnGrp1.add(btnAppetizers);
			menubtnGrp1.add(btnEntree);
			menubtnGrp1.add(btnDessert);
			menubtnGrp1.add(btnDrinks);
		}
		JButton btnBack = new JButton("Back");
		btnBack.setFocusable(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				actionBackPerformed(e);
			}
		});
		btnBack.setBounds(140, 405, 89, 23);
		panelCategories.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setFocusable(false);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search Dish", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 406, 312, 118);
		panelEditables.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnAppetizer2 = new JRadioButton("Appetizer");
		rdbtnAppetizer2.setFocusable(false);
		rdbtnAppetizer2.setBounds(47, 20, 88, 23);
		panel.add(rdbtnAppetizer2);
		
		JRadioButton rdbtnEntree2 = new JRadioButton("Entree");
		rdbtnEntree2.setFocusable(false);
		rdbtnEntree2.setBounds(186, 20, 71, 23);
		panel.add(rdbtnEntree2);
		
		JRadioButton rdbtnDessert2 = new JRadioButton("Dessert");
		rdbtnDessert2.setFocusable(false);
		rdbtnDessert2.setBounds(47, 46, 71, 23);
		panel.add(rdbtnDessert2);
		
		JRadioButton rdbtnDrinks2 = new JRadioButton("Drinks");
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
					//rdbtnGrp2.clearSelection();
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
		btnAdd.setBounds(30, 325, 96, 47);
		panelEditables.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFocusable(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dishID = textDishID.getText();
			    String option = tableSelected(rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2);

	            try {

			        // Delete the dish
	            	PreparedStatement deleteStatement = con.prepareStatement("DELETE FROM " + option + " where id = ?");
	            	deleteStatement.setString(1, dishID); // Use deleteStatement here instead of pst
	            	deleteStatement.executeUpdate();
	            	JOptionPane.showMessageDialog(null, "Record deleted successfully.");

	            	textDishName.setText("");
	            	textDescription.setText("");
	            	textPrice.setText("");
	            	textDishID.setText(""); // Clear the dish ID field as well
	            	textDishName.requestFocus();
	            	 
	               }
	               catch (SQLException e1) {
	                   
	                   e1.printStackTrace();
	               }
				
			}
		});
		btnDelete.setBounds(20, 657, 292, 37);
		panelEditables.add(btnDelete);
		
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 28, 48, 27);
		panel_2.add(lblNewLabel);
		
		textDishName = new JTextField();
		textDishName.setBounds(108, 33, 185, 20);
		panel_2.add(textDishName);
		textDishName.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFocusable(false);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 79, 88, 27);
		panel_2.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		textDescription.setBounds(108, 84, 185, 20);
		panel_2.add(textDescription);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFocusable(false);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 136, 88, 27);
		panel_2.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(108, 141, 185, 20);
		panel_2.add(textPrice);
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dishName,description,price,dishID;
                
                
                dishName = textDishName.getText();
                description = textDescription.getText();
                price = textPrice.getText();
                dishID  = textDishID.getText();
                
                String option = tableSelected(rdbtnAppetizer2,rdbtnEntree2, rdbtnDessert2, rdbtnDrinks2);
				
				try {
					
			        pst = con.prepareStatement("update " +  option + " set dish_name = ?,description =?,price=? where id =?");
                        pst.setString(1, dishName);
                        pst.setString(2, description);
                        pst.setString(3, price);
                        pst.setString(4, dishID);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Record Update!!!!!");
                        //table_load();
                       
                        textDishName.setText("");
                        textDescription.setText("");
                        textPrice.setText("");
                        textDishName.requestFocus();
                        rdbtnGrp2.clearSelection();
                    }
                    catch (SQLException e1) {
                        
                        e1.printStackTrace();
                    }
			}
		});
		btnUpdate.setFocusable(false);
		btnUpdate.setBounds(20, 535, 292, 37);
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
		//int refreshKey = Integer.parseInt(option);
		
		try {
			
	        pst = con.prepareStatement("insert into " +  option + " (dish_name,description,price)values(?,?,?)");
	        pst.setString(1, dishName);
	        pst.setString(2, description);
	        pst.setString(3, price);
	        pst.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
	        
	        //menuRefresh(refreshKey);
	        
	        
	        
	        appetizerPage.setVisible(true);
			entreePage.dispose();
			dessertPage.dispose();
			drinksPage.dispose();
	        
	        
	        //menubtnGrp1.clearSelection();
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
	
	public void actionBackPerformed(ActionEvent e){
		OptionsAdmin optionsAdmin = new OptionsAdmin();
		optionsAdmin.setVisible(true);
		this.dispose();
	}
}
