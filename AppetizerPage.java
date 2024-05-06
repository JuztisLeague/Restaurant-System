package BonAppetit;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import java.awt.FlowLayout;
import java.awt.Color;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class AppetizerPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
    
	int update = 0;
	
	AppetizerPage(int newUpdate) {
		update = newUpdate;
	}
	
	public void setUpdate(int newUpdate) {
		update = newUpdate;
	}
	
	public int getUpdate() {
		return update;
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppetizerPage frame = new AppetizerPage();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppetizerPage() {
		
		
		connect();
		
		setFocusable(false);
		setFocusableWindowState(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 12, 1330, 1055);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setFocusable(false);
		panel.setBounds(0, 0, 1219, 1056);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JPanel panelData1 = new JPanel();
		panelData1.setFocusable(false);
		panelData1.setBounds(66, 74, 261, 261);
		panel.add(panelData1);
		panelData1.setLayout(null);
		panelData1.setVisible(false);
		
		JLabel lblDishName1 = new JLabel("");
		lblDishName1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName1.setBounds(29, 42, 70, 28);
		panelData1.add(lblDishName1);
		
		JLabel lblDescription1 = new JLabel("");
		lblDescription1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription1.setBounds(29, 107, 193, 28);
		panelData1.add(lblDescription1);
		
		JLabel lblPrice1 = new JLabel("");
		lblPrice1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice1.setBounds(29, 178, 81, 28);
		panelData1.add(lblPrice1);
		
		JPanel panelData2 = new JPanel();
		panelData2.setFocusable(false);
		panelData2.setLayout(null);
		panelData2.setBounds(423, 74, 261, 261);
		panel.add(panelData2);
		panelData2.setVisible(false);
		
		JLabel lblDishName2 = new JLabel("");
		lblDishName2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName2.setBounds(29, 42, 70, 28);
		panelData2.add(lblDishName2);
		
		JLabel lblDescription2 = new JLabel("");
		lblDescription2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription2.setBounds(29, 107, 193, 28);
		panelData2.add(lblDescription2);
		
		JLabel lblPrice2 = new JLabel("");
		lblPrice2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice2.setBounds(29, 178, 81, 28);
		panelData2.add(lblPrice2);
		
		JPanel panelData3 = new JPanel();
		panelData3.setFocusable(false);
		panelData3.setLayout(null);
		panelData3.setBounds(806, 74, 261, 261);
		panel.add(panelData3);
		panelData3.setVisible(false);
		
		JLabel lblDishName3 = new JLabel("");
		lblDishName3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName3.setBounds(29, 42, 70, 28);
		panelData3.add(lblDishName3);
		
		JLabel lblDescription3 = new JLabel("");
		lblDescription3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription3.setBounds(29, 107, 193, 28);
		panelData3.add(lblDescription3);
		
		JLabel lblPrice3 = new JLabel("");
		lblPrice3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice3.setBounds(29, 178, 81, 28);
		panelData3.add(lblPrice3);
		
		JPanel panelData4 = new JPanel();
		panelData4.setFocusable(false);
		panelData4.setLayout(null);
		panelData4.setBounds(66, 404, 261, 261);
		panel.add(panelData4);
		panelData4.setVisible(false);
		
		JLabel lblDishName4 = new JLabel("");
		lblDishName4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName4.setBounds(29, 42, 70, 28);
		panelData4.add(lblDishName4);
		
		JLabel lblDescription4 = new JLabel("");
		lblDescription4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription4.setBounds(29, 107, 193, 28);
		panelData4.add(lblDescription4);
		
		JLabel lblPrice4 = new JLabel("");
		lblPrice4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice4.setBounds(29, 178, 81, 28);
		panelData4.add(lblPrice4);
		
		JPanel panelData5 = new JPanel();
		panelData5.setFocusable(false);
		panelData5.setLayout(null);
		panelData5.setBounds(423, 404, 261, 261);
		panel.add(panelData5);
		panelData5.setVisible(false);
		
		JLabel lblDishName5 = new JLabel("");
		lblDishName5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName5.setBounds(29, 42, 70, 28);
		panelData5.add(lblDishName5);
		
		JLabel lblDescription5 = new JLabel("");
		lblDescription5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription5.setBounds(29, 107, 193, 28);
		panelData5.add(lblDescription5);
		
		JLabel lblPrice5 = new JLabel("");
		lblPrice5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice5.setBounds(29, 178, 81, 28);
		panelData5.add(lblPrice5);
		
		JPanel panelData6 = new JPanel();
		panelData6.setFocusable(false);
		panelData6.setLayout(null);
		panelData6.setBounds(806, 404, 261, 261);
		panel.add(panelData6);
		panelData6.setVisible(false);
		
		JLabel lblDishName6 = new JLabel("");
		lblDishName6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName6.setBounds(29, 42, 70, 28);
		panelData6.add(lblDishName6);
		
		JLabel lblDescription6 = new JLabel("");
		lblDescription6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription6.setBounds(29, 107, 193, 28);
		panelData6.add(lblDescription6);
		
		JLabel lblPrice6 = new JLabel("");
		lblPrice6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice6.setBounds(29, 178, 81, 28);
		panelData6.add(lblPrice6);
		
		JPanel panelData7 = new JPanel();
		panelData7.setFocusable(false);
		panelData7.setLayout(null);
		panelData7.setBounds(66, 736, 261, 261);
		panel.add(panelData7);
		panelData7.setVisible(false);
		
		JLabel lblDishName7 = new JLabel("");
		lblDishName7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName7.setBounds(29, 42, 70, 28);
		panelData7.add(lblDishName7);
		
		JLabel lblDescription7 = new JLabel("");
		lblDescription7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription7.setBounds(29, 107, 193, 28);
		panelData7.add(lblDescription7);
		
		JLabel lblPrice7 = new JLabel("");
		lblPrice7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice7.setBounds(29, 178, 81, 28);
		panelData7.add(lblPrice7);
		
		JPanel panelData8 = new JPanel();
		panelData8.setFocusable(false);
		panelData8.setLayout(null);
		panelData8.setBounds(423, 736, 261, 261);
		panel.add(panelData8);
		panelData8.setVisible(false);
		
		JLabel lblDishName8 = new JLabel("");
		lblDishName8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName8.setBounds(29, 42, 70, 28);
		panelData8.add(lblDishName8);
		
		JLabel lblDescription8 = new JLabel("");
		lblDescription8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription8.setBounds(29, 107, 193, 28);
		panelData8.add(lblDescription8);
		
		JLabel lblPrice8 = new JLabel("");
		lblPrice8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice8.setBounds(29, 178, 81, 28);
		panelData8.add(lblPrice8);
		
		JPanel panelData9 = new JPanel();
		panelData9.setFocusable(false);
		panelData9.setLayout(null);
		panelData9.setBounds(806, 736, 261, 261);
		panel.add(panelData9);
		panelData9.setVisible(false);
		
		JLabel lblDishName9 = new JLabel("");
		lblDishName9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDishName9.setBounds(29, 42, 70, 28);
		panelData9.add(lblDishName9);
		
		JLabel lblDescription9 = new JLabel("");
		lblDescription9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescription9.setBounds(29, 107, 193, 28);
		panelData9.add(lblDescription9);
		
		JLabel lblPrice9 = new JLabel("");
		lblPrice9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice9.setBounds(29, 178, 81, 28);
		panelData9.add(lblPrice9);
		
		JLabel lblNumber = new JLabel("");
		lblNumber.setBounds(155, 27, 172, 31);
		panel.add(lblNumber);
		
		String dishName,description,price;
	    try {
	    	pst = con.prepareStatement("SELECT COUNT(*) FROM appetizer");
	        ResultSet countResult = pst.executeQuery();
	        countResult.next();
	        int totalRows = countResult.getInt(1); // Total number of rows in the ResultSet
	        String total  = Integer.toString(totalRows);
	        // Set the limit to the total number of rows
	        int limit = totalRows + update;
	        
	        
	        lblNumber.setText(total);
	    	
	        pst = con.prepareStatement("select dish_name,description,price from appetizer");
	        ResultSet rs = pst.executeQuery();
	        
	        int count = 0;
	        while (rs.next() && count < limit) {
	            dishName = rs.getString("dish_name");
	            description = rs.getString("description");
	            price = rs.getString("price");
	            switch (count) {
	                case 0:
	                    lblDishName1.setText(dishName);
	                    lblDescription1.setText(description);
	                    lblPrice1.setText(price);
	                    panelData1.setVisible(true);
	                    break;
	                case 1:
	                	lblDishName2.setText(dishName);
	                    lblDescription2.setText(description);
	                    lblPrice2.setText(price);
	                    panelData2.setVisible(true);
	                    break;
	                case 2:
	                	lblDishName3.setText(dishName);
	                    lblDescription3.setText(description);
	                    lblPrice3.setText(price);
	                    panelData3.setVisible(true);
	                    break;
	                case 3:
	                	lblDishName4.setText(dishName);
	                    lblDescription4.setText(description);
	                    lblPrice4.setText(price);
	                    panelData4.setVisible(true);
	                    break;
	                case 4:
	                	lblDishName5.setText(dishName);
	                    lblDescription5.setText(description);
	                    lblPrice5.setText(price);
	                    panelData5.setVisible(true);
	                    break;
	                case 5:
	                	lblDishName6.setText(dishName);
	                    lblDescription6.setText(description);
	                    lblPrice6.setText(price);
	                    panelData6.setVisible(true);
	                    break;
	                case 6:
	                	lblDishName7.setText(dishName);
	                    lblDescription7.setText(description);
	                    lblPrice7.setText(price);
	                    panelData7.setVisible(true);
	                    break;
	                case 7:
	                	lblDishName8.setText(dishName);
	                    lblDescription8.setText(description);
	                    lblPrice8.setText(price);
	                    panelData8.setVisible(true);
	                    break;
	                case 8:
	                	lblDishName9.setText(dishName);
	                    lblDescription9.setText(description);
	                    lblPrice9.setText(price);
	                    panelData9.setVisible(true);
	                    break;
	            }
	            count++;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		
		
		
	}
	

}
