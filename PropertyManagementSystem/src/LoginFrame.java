import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.Cursor;
import javax.swing.SwingConstants;





import java.sql.ResultSet;
import java.sql.Statement;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField pass;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(220, 20, 60));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartPanel SP = new StartPanel();
				SP.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-exit-64.png"));
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel_4.setBounds(0, 0, 64, 64);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_3.setBounds(857, 0, 35, 34);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addKeyListener(new KeyAdapter() {
		
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertymanagementsystem","root","szabist@100");
					String username = user.getText();
					String password = pass.getText();
					Statement stm = con.createStatement();
					String sql = "select * from users where username='"+username+"'and Password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "OKAY");
						PrpertyManagementSystem pms = new PrpertyManagementSystem();
						pms.setVisible(true);
						dispose();
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
						user.setText("");
						pass.setText("");
					}
					con.close();
					} catch (Exception g) {
					JOptionPane.showMessageDialog(null, g);
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(255, 245, 238));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnNewButton.setBounds(375, 432, 169, 46);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 245, 238));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2.setAlignmentY(1.0f);
		lblNewLabel_2.setBounds(285, 323, 121, 21);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel_1.setForeground(new Color(255, 245, 238));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(285, 201, 121, 21);
		contentPane.add(lblNewLabel_1);
		
		pass = new JTextField();
		pass.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					try {
						//Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertymanagementsystem","root","szabist@100");
						String username = user.getText();
						String password = pass.getText();
						Statement stm = con.createStatement();
						String sql = "select * from users where username='"+username+"'and Password='"+password+"'";
						ResultSet rs = stm.executeQuery(sql);
						if(rs.next()) {
							//JOptionPane.showMessageDialog(null, "OKAY");
							PrpertyManagementSystem pms = new PrpertyManagementSystem();
							pms.setVisible(true);
							dispose();
							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
							user.setText("");
							pass.setText("");
						}
						con.close();
						} catch (Exception g) {
						JOptionPane.showMessageDialog(null, g);
					}
				
				}
				}
		});
		pass.setForeground(new Color(255, 248, 220));
		pass.setFont(new Font("Tahoma", Font.PLAIN, 21));
		pass.setColumns(10);
		pass.setBackground(new Color(0, 128, 128));
		pass.setBounds(285, 355, 346, 46);
		contentPane.add(pass);
		
		user = new JTextField();
		user.setForeground(new Color(255, 245, 238));
		user.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		user.setBackground(new Color(0, 128, 128));
		user.setBounds(285, 229, 346, 46);
		contentPane.add(user);
		user.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 892, 622);
		contentPane.add(panel);
	}
}
