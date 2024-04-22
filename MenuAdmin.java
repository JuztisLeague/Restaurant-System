package BonAppetit;

import java.awt.EventQueue;

//import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Frame;
//import java.awt.FlowLayout;
import javax.swing.JPanel;
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
		initialize();
		connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
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
	
	
	
	
	private void initialize() {
		//frame = new JFrame();
		setUndecorated(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(0,0, 1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 308, 1058);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Appetizers");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AppetizerPage appetizer = new AppetizerPage();
				appetizer.setVisible(true);
			}
		});
		btnNewButton.setBounds(20, 111, 254, 23);
		panel.add(btnNewButton);
		
		JButton btnEntree = new JButton("Entree");
		btnEntree.setBounds(20, 164, 254, 23);
		panel.add(btnEntree);
		
		JButton btnDesert = new JButton("Desert");
		btnDesert.setBounds(20, 215, 254, 23);
		panel.add(btnDesert);
		
		JButton btnDrinks = new JButton("Drinks");
		btnDrinks.setBounds(20, 274, 254, 23);
		panel.add(btnDrinks);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(1557, 11, 353, 1058);
		getContentPane().add(panel_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dishName, description, price;
				
				dishName = textDishName.getText();
				description = textDescription.getText();
				price = textPrice.getText();
				
				try {
			        pst = con.prepareStatement("insert into appetizer(dish_name,description,price)values(?,?,?)");
			        pst.setString(1, dishName);
			        pst.setString(2, description);
			        pst.setString(3, price);
			        pst.executeUpdate();
			        JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
			        //table_load();
			                       
			        textDishName.setText("");
			        textDescription.setText("");
			        textPrice.setText("");
			        textDishName.requestFocus();
			       }
			    catch (SQLException e1) 
			        {            
			    		e1.printStackTrace();
			        }
				
			}
		});
		btnAdd.setBounds(32, 242, 96, 47);
		panel_1.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(32, 374, 292, 37);
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Add Dishes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(20, 43, 323, 178);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 28, 48, 27);
		panel_2.add(lblNewLabel);
		
		textDishName = new JTextField();
		textDishName.setBounds(108, 33, 185, 20);
		panel_2.add(textDishName);
		textDishName.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(10, 79, 88, 27);
		panel_2.add(lblDescription);
		
		textDescription = new JTextField();
		textDescription.setColumns(10);
		textDescription.setBounds(108, 84, 185, 20);
		panel_2.add(textDescription);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(10, 136, 88, 27);
		panel_2.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(108, 141, 185, 20);
		panel_2.add(textPrice);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(32, 326, 292, 37);
		panel_1.add(btnUpdate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(326, 11, 1221, 1058);
		getContentPane().add(panel_3);
	}
	
	
	/*private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        SignInPage signInPage = new SignInPage();
        signInPage.setVisible(true);
        this.dispose();
       
   }    */

}
