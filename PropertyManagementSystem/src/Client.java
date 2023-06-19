import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Client {
	

	String username = "root";
	String password = "szabist@100";
	Statement mystatobj = null;
	Connection con= null;
	
	
	
	
/*static Connection con() {	
	try {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/propertymanagementsystem";
		return DriverManager.getConnection(url, "root", "szabist@100");
	}
	catch (SQLException e) {
		System.out.println("Error!");
	}
	return null;
}*/

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField app_id;
	private JTextField client_id;
	private JTextField date;
	private JTextField time;
	private JTextField p_id;
	private JTable propertytable;
	private JTable table;

	
	public static void main(String[] args) {
		Statement mystatObj = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	Connection connection = null;
	private JTextField clientid;
	private JTextField pid;
	private JTextField datE;
	private JTextField comment;
	private JTable table_1;
	private JTextField tenantno;
	private JTextField Prent;
	private JTextField ownerid;
	private JTextField tenantName;
	private JTextField endDate;
	private JTextField tenantid;
	private JTextField startDate;
	private JTable tenanttable;
	private void initialize() {
		
		
		connection = DBconnection.getConnection();
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setSize(new Dimension(1400, 1080));
		frame.setBounds(100, 100, 1428, 783);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(365, -26, 1063, 809);
		frame.getContentPane().add(tabbedPane);
		
		JPanel propertiespanel = new JPanel();
		propertiespanel.setBackground(new Color(0, 139, 139));
		propertiespanel.setForeground(Color.WHITE);
		tabbedPane.addTab("New tab", null, propertiespanel, null);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setBounds(52, 684, 89, 23);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(204, 255, 204));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new CompoundBorder());
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String load = "select * from property;";
					PreparedStatement pst = DBconnection.getConnection().prepareStatement(load);
					ResultSet rs1 = pst.executeQuery();
					propertytable.setModel(DbUtils.resultSetToTableModel(rs1));
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
			}
		});
		propertiespanel.setLayout(null);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1, 126, 1060, 274);
		scrollPane_1.setFocusTraversalKeysEnabled(false);
		scrollPane_1.setBorder(null);
		scrollPane_1.setFocusable(false);
		scrollPane_1.setBackground(Color.cyan);
		scrollPane_1.setForeground(Color.cyan);
		scrollPane_1.setForeground(new Color(102, 204, 102));
		scrollPane_1.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		scrollPane_1.setBackground(new Color(0, 0, 128));
		propertiespanel.add(scrollPane_1);
		
		propertytable = new JTable();
		scrollPane_1.setViewportView(propertytable);
		propertiespanel.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 0, 1080, 126);
		propertiespanel.add(panel);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 139, 139));
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Properties");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 26));
		lblNewLabel_4.setBounds(382, 32, 359, 59);
		panel.add(lblNewLabel_4);
		
		JPanel Tenants = new JPanel();
		Tenants.setBackground(new Color(0, 139, 139));
		tabbedPane.addTab("New tab", null, Tenants, null);
		Tenants.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 117, 1070, 268);
		Tenants.add(scrollPane_3);
		
		tenanttable = new JTable();
		scrollPane_3.setViewportView(tenanttable);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 0, 1054, 127);
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(0, 139, 139));
		Tenants.add(panel_3_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Tenants");
		lblNewLabel_4_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 26));
		lblNewLabel_4_2_1.setBounds(382, 32, 359, 59);
		panel_3_1.add(lblNewLabel_4_2_1);
		
		JButton btnNewButton_3_1 = new JButton("LOAD");
		btnNewButton_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3_1.setBounds(29, 670, 92, 23);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String load = "select * from tenant;";
					PreparedStatement pst = DBconnection.getConnection().prepareStatement(load);
					ResultSet rs1 = pst.executeQuery();
					tenanttable.setModel(DbUtils.resultSetToTableModel(rs1));
					
				} catch (Exception f) {
					f.printStackTrace();
				}
			
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1.setBorder(new CompoundBorder());
		btnNewButton_3_1.setBackground(new Color(204, 255, 204));
		Tenants.add(btnNewButton_3_1);
		
		JButton add2_1 = new JButton("ADD");
		add2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add2_1.setBounds(169, 670, 77, 23);
		add2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToTenant();
			}
		});
		add2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		add2_1.setBorder(new CompoundBorder());
		add2_1.setBackground(new Color(204, 255, 204));
		Tenants.add(add2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("UPDATE");
		btnNewButton_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2_1_1.setBounds(307, 670, 81, 23);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTenant();
			}
		});
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1_1.setBorder(new CompoundBorder());
		btnNewButton_2_1_1.setBackground(new Color(204, 255, 204));
		Tenants.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("DELETE");
		btnNewButton_1_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1_1.setBounds(444, 670, 77, 23);
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTenant();
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_1_1.setBorder(new CompoundBorder());
		btnNewButton_1_1_1_1.setBackground(new Color(204, 255, 204));
		Tenants.add(btnNewButton_1_1_1_1);
		
		JLabel tenantNO = new JLabel("Tenant NO");
		tenantNO.setBounds(29, 478, 114, 16);
		tenantNO.setForeground(Color.WHITE);
		tenantNO.setFont(new Font("Tahoma", Font.BOLD, 12));
		Tenants.add(tenantNO);
		
		tenantno = new JTextField();
		tenantno.setBounds(29, 504, 246, 34);
		tenantno.setColumns(10);
		Tenants.add(tenantno);
		
		JLabel prent = new JLabel("Property Rent");
		prent.setBounds(360, 478, 114, 16);
		prent.setForeground(Color.WHITE);
		prent.setFont(new Font("Tahoma", Font.BOLD, 12));
		Tenants.add(prent);
		
		Prent = new JTextField();
		Prent.setBounds(360, 504, 246, 34);
		Prent.setColumns(10);
		Tenants.add(Prent);
		
		JLabel ownerID = new JLabel("Owner ID");
		ownerID.setBounds(29, 565, 114, 16);
		ownerID.setForeground(Color.WHITE);
		ownerID.setFont(new Font("Tahoma", Font.BOLD, 12));
		Tenants.add(ownerID);
		
		ownerid = new JTextField();
		ownerid.setBounds(29, 591, 246, 34);
		ownerid.setColumns(10);
		Tenants.add(ownerid);
		
		JLabel tenantname = new JLabel("Tenant Name");
		tenantname.setBounds(360, 565, 114, 16);
		tenantname.setForeground(Color.WHITE);
		tenantname.setFont(new Font("Tahoma", Font.BOLD, 12));
		Tenants.add(tenantname);
		
		tenantName = new JTextField();
		tenantName.setBounds(360, 591, 246, 34);
		tenantName.setColumns(10);
		Tenants.add(tenantName);
		
		JLabel enddate = new JLabel("End Date");
		enddate.setBounds(692, 565, 114, 16);
		enddate.setForeground(Color.WHITE);
		enddate.setFont(new Font("Tahoma", Font.BOLD, 12));
		Tenants.add(enddate);
		
		endDate = new JTextField();
		endDate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				SaveToTenant();
			}}
			});
		endDate.setBounds(692, 591, 246, 34);
		endDate.setColumns(10);
		Tenants.add(endDate);
		
		JLabel tenantID = new JLabel("Tenant ID");
		tenantID.setBounds(28, 395, 114, 16);
		tenantID.setForeground(Color.WHITE);
		tenantID.setFont(new Font("Tahoma", Font.BOLD, 12));
		Tenants.add(tenantID);
		
		tenantid = new JTextField();
		tenantid.setBounds(28, 421, 246, 34);
		tenantid.setColumns(10);
		Tenants.add(tenantid);
		
		JLabel startdate = new JLabel("Start Date");
		startdate.setBounds(692, 478, 114, 16);
		startdate.setForeground(Color.WHITE);
		startdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		Tenants.add(startdate);
		
		startDate = new JTextField();
		startDate.setBounds(692, 504, 246, 34);
		startDate.setColumns(10);
		Tenants.add(startDate);
		
		JPanel Appointment = new JPanel();
		Appointment.setBackground(new Color(0, 139, 139));
		tabbedPane.addTab("New tab", null, Appointment, null);
		
		JButton btnNewButton_3 = new JButton("LOAD");
		btnNewButton_3.setBounds(47, 686, 92, 23);
		btnNewButton_3.setBackground(new Color(204, 255, 204));
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBorder(new CompoundBorder());
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String load = "select * from appointment;";
					PreparedStatement pst = DBconnection.getConnection().prepareStatement(load);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		Appointment.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 128, 1058, 273);
		scrollPane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setBackground(new Color(0, 255, 102));
		scrollPane.setForeground(new Color(0, 204, 102));
		scrollPane.setBorder(null);
		Appointment.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(btnNewButton_3);
		
		JButton add2 = new JButton("ADD");
		add2.setBounds(187, 686, 77, 23);
		add2.setBackground(new Color(204, 255, 204));
		add2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add2.setBorder(new CompoundBorder());
		add2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToAppointment();
			}
		});
		add2.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(add2);
		
		JButton btnNewButton_2_1 = new JButton("UPDATE");
		btnNewButton_2_1.setBounds(325, 686, 81, 23);
		btnNewButton_2_1.setBackground(new Color(204, 255, 204));
		btnNewButton_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2_1.setBorder(new CompoundBorder());
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAppointment();
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(btnNewButton_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("DELETE");
		btnNewButton_1_1_1.setBounds(462, 686, 77, 23);
		btnNewButton_1_1_1.setBackground(new Color(204, 255, 204));
		btnNewButton_1_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_1.setBorder(new CompoundBorder());
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteAppointment();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(btnNewButton_1_1_1);
		
		app_id = new JTextField();
		app_id.setBounds(47, 471, 246, 34);
		app_id.setColumns(10);
		Appointment.add(app_id);
		
		JLabel lblNewLabel_5_2 = new JLabel("Appointment ID");
		lblNewLabel_5_2.setBounds(47, 445, 114, 16);
		lblNewLabel_5_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Client ID");
		lblNewLabel_5_1_1.setBounds(336, 446, 58, 15);
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("Date ");
		lblNewLabel_5_3_1.setBounds(47, 528, 60, 15);
		lblNewLabel_5_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_5_4_1 = new JLabel("Time");
		lblNewLabel_5_4_1.setBounds(336, 528, 40, 15);
		lblNewLabel_5_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(lblNewLabel_5_4_1);
		
		client_id = new JTextField();
		client_id.setBounds(336, 471, 246, 34);
		client_id.setColumns(10);
		Appointment.add(client_id);
		
		date = new JTextField();
		date.setBounds(47, 553, 246, 34);
		date.setColumns(10);
		Appointment.add(date);
		
		time = new JTextField();
		time.setBounds(336, 553, 246, 34);
		time.setColumns(10);
		Appointment.add(time);
		
		p_id = new JTextField();
		p_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				SaveToAppointment();
			}}
		});
		p_id.setBounds(47, 633, 246, 34);
		p_id.setColumns(10);
		Appointment.add(p_id);
		
		JLabel lblNewLabel_5_4_1_1 = new JLabel("Property ID");
		lblNewLabel_5_4_1_1.setBounds(47, 610, 107, 15);
		lblNewLabel_5_4_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		Appointment.add(lblNewLabel_5_4_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(4, 1, 1051, 127);
		Appointment.add(panel_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("Appointments");
		lblNewLabel_4_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Bahnschrift", Font.BOLD, 26));
		lblNewLabel_4_1.setBounds(382, 32, 359, 59);
		panel_2.add(lblNewLabel_4_1);
		
		JPanel CommentPanel = new JPanel();
		CommentPanel.setBackground(new Color(0, 139, 139));
		tabbedPane.addTab("New tab", null, CommentPanel, null);
		CommentPanel.setLayout(null);
		
		JLabel clientID = new JLabel("Client ID");
		clientID.setBounds(38, 490, 114, 16);
		clientID.setForeground(new Color(255, 255, 255));
		clientID.setFont(new Font("Tahoma", Font.BOLD, 12));
		CommentPanel.add(clientID);
		
		clientid = new JTextField();
		clientid.setBounds(38, 516, 246, 34);
		clientid.setColumns(10);
		CommentPanel.add(clientid);
		
		JLabel pID = new JLabel("Property ID");
		pID.setBounds(369, 490, 114, 16);
		pID.setForeground(new Color(255, 255, 255));
		pID.setFont(new Font("Tahoma", Font.BOLD, 12));
		CommentPanel.add(pID);
		
		pid = new JTextField();
		pid.setBounds(369, 516, 246, 34);
		pid.setColumns(10);
		CommentPanel.add(pid);
		
		JLabel Date = new JLabel("Date");
		Date.setBounds(38, 577, 114, 16);
		Date.setForeground(new Color(255, 255, 255));
		Date.setFont(new Font("Tahoma", Font.BOLD, 12));
		CommentPanel.add(Date);
		
		datE = new JTextField();
		datE.setBounds(38, 603, 246, 34);
		datE.setColumns(10);
		CommentPanel.add(datE);
		
		JLabel Comment = new JLabel("Comment");
		Comment.setBounds(369, 577, 114, 16);
		Comment.setForeground(new Color(255, 255, 255));
		Comment.setFont(new Font("Tahoma", Font.BOLD, 12));
		CommentPanel.add(Comment);
		
		comment = new JTextField();
		comment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
				SaveToComment();
			}}
		});
		comment.setBounds(369, 603, 246, 34);
		comment.setColumns(10);
		CommentPanel.add(comment);
		
		JButton btnNewButton_4 = new JButton("LOAD");
		btnNewButton_4.setBounds(57, 681, 89, 23);
		btnNewButton_4.setBackground(new Color(204, 255, 204));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String load = "select * from comments;";
					PreparedStatement pst = DBconnection.getConnection().prepareStatement(load);
					ResultSet rs1 = pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		CommentPanel.add(btnNewButton_4);
		
		JButton btnNewButton_1_2 = new JButton("ADD");
		btnNewButton_1_2.setBounds(185, 681, 89, 23);
		btnNewButton_1_2.setBackground(new Color(204, 255, 204));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToComment();
			}
		});
		btnNewButton_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		CommentPanel.add(btnNewButton_1_2);
		
		JButton btnNewButton_2_2 = new JButton("UPDATE");
		btnNewButton_2_2.setBounds(332, 681, 89, 23);
		btnNewButton_2_2.setBackground(new Color(204, 255, 204));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateComment();
			}
		});
		btnNewButton_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		CommentPanel.add(btnNewButton_2_2);
		
		JButton btnNewButton_1_1_2 = new JButton("DELETE");
		btnNewButton_1_1_2.setBounds(474, 681, 89, 23);
		btnNewButton_1_1_2.setBackground(new Color(204, 255, 204));
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteComment();
				}
		});
		btnNewButton_1_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		CommentPanel.add(btnNewButton_1_1_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 139, 139));
		panel_3.setBounds(0, 0, 1055, 127);
		CommentPanel.add(panel_3);
		
		JLabel lblNewLabel_4_2 = new JLabel("Comments");
		lblNewLabel_4_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.BOLD, 26));
		lblNewLabel_4_2.setBounds(382, 32, 359, 59);
		panel_3.add(lblNewLabel_4_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 118, 1058, 299);
		CommentPanel.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		
		Panel sidepanel = new Panel();
		sidepanel.setBounds(0, 0, 372, 783);
		frame.getContentPane().add(sidepanel);
		sidepanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		sidepanel.setBackground(new Color(95, 158, 160));
		sidepanel.setForeground(new Color(204, 51, 102));
		sidepanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95,158,160));
		panel_1.setBounds(0, 263, 66, 63);
		sidepanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
		});
		lblNewLabel.setBounds(16, 0, 50, 63);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-property-48.png"));
		panel_1.add(lblNewLabel);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBackground(new Color(95,158,160));
		panel_1_1_1.setBounds(0, 337, 372, 63);
		sidepanel.add(panel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-comment-64.png"));
		lblNewLabel_2_1.setBounds(10, 0, 60, 63);
		panel_1_1_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton_4_2 = new JButton("Comments");
		btnNewButton_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4_2.setBackground(new Color(95,158,160));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4_2.setBackground(new Color(0,139,139));
			}
		});
		btnNewButton_4_2.setBounds(80, 0, 292, 63);
		panel_1_1_1.add(btnNewButton_4_2);
		btnNewButton_4_2.setBorder(null);
		btnNewButton_4_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_4_2.setForeground(new Color(255, 255, 255));
		btnNewButton_4_2.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		btnNewButton_4_2.setBackground(new Color(0, 139, 139));
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBackground(new Color(95,158,160));
		panel_1_1_2.setBounds(0, 709, 372, 63);
		sidepanel.add(panel_1_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-exit-64.png"));
		lblNewLabel_2_2.setBounds(10, 0, 64, 63);
		panel_1_1_2.add(lblNewLabel_2_2);
		
		JButton btnNewButton_4_3 = new JButton("EXIT");
		btnNewButton_4_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4_3.setBackground(new Color(95,158,160));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4_3.setBackground(new Color(0,139,139));
			}
		});
		btnNewButton_4_3.setBounds(80, 0, 292, 63);
		panel_1_1_2.add(btnNewButton_4_3);
		btnNewButton_4_3.setBorder(null);
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4_3.setForeground(new Color(255, 255, 255));
		btnNewButton_4_3.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		btnNewButton_4_3.setBackground(new Color(0, 139, 139));
		
		JLabel lblNewLabel_6 = new JLabel("Property Managemet System");
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_6.setBounds(37, 170, 292, 28);
		sidepanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("____________________________________");
		lblNewLabel_6_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_6_1.setBounds(31, 185, 306, 28);
		sidepanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-mansion-100 (1).png"));
		lblNewLabel_1.setBounds(133, -7, 134, 220);
		sidepanel.add(lblNewLabel_1);
		
		JButton btnNewButton_4_1_1 = new JButton("Properties");
		btnNewButton_4_1_1.setBounds(80, 263, 292, 63);
		sidepanel.add(btnNewButton_4_1_1);
		btnNewButton_4_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4_1_1.setBackground(new Color(95,158,160));
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4_1_1.setBackground(new Color(0,139,139));
			}
		});
		btnNewButton_4_1_1.setBorder(null);
		btnNewButton_4_1_1.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton_4_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton_4_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_4_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		btnNewButton_4_1_1.setBackground(new Color(0, 139, 139));
		
		JPanel panel_1_1_2_1 = new JPanel();
		panel_1_1_2_1.setLayout(null);
		panel_1_1_2_1.setBackground(new Color(95, 158, 160));
		panel_1_1_2_1.setBounds(0, 636, 372, 63);
		sidepanel.add(panel_1_1_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartPanel SP = new StartPanel();
				SP.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_2_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_2_1.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-logout-rounded-down-64.png"));
		lblNewLabel_2_2_1.setBounds(10, 0, 64, 63);
		panel_1_1_2_1.add(lblNewLabel_2_2_1);
		
		JButton btnNewButton_4_3_1 = new JButton("LOGOUT");
		btnNewButton_4_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartPanel SP = new StartPanel();
				SP.setVisible(true);
			frame.dispose();
			}
		});
		btnNewButton_4_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartPanel SP = new StartPanel();
				SP.setVisible(true);
				frame.dispose();
	
			}
		});
		btnNewButton_4_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4_3_1.setForeground(Color.WHITE);
		btnNewButton_4_3_1.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		btnNewButton_4_3_1.setBorder(null);
		btnNewButton_4_3_1.setBackground(new Color(0, 139, 139));
		btnNewButton_4_3_1.setBounds(80, 0, 292, 63);
		panel_1_1_2_1.add(btnNewButton_4_3_1);
	}
	private void SaveToTenant() {
		connection = DBconnection.getConnection();
		try {
			String query = "insert into tenant  values (?,?,?,?,?,?,?);";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(query);
			ps.setNString(1, tenantid.getText());
			ps.setNString(2, tenantno.getText());
			ps.setNString(3, ownerid.getText());
			ps.setNString(4, Prent.getText());		
			ps.setNString(5, startDate.getText());
			ps.setNString(6, endDate.getText());
			ps.setNString(7, tenantName.getText());
			
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
		
	}
	private void UpdateTenant() {
		connection = DBconnection.getConnection();
		try {
			String update = "update propertymanagementsystem.tenant set tenant_no = ?, owner_id = ?, property_rent = ?, start_date = ?, end_date = ?, tenant_name = ? where tenant_id = ?;";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(update);
			ps.setNString(7, tenantid.getText());
			ps.setNString(1, tenantno.getText());
			ps.setNString(2, ownerid.getText());
			ps.setNString(3, Prent.getText());		
			ps.setNString(4, startDate.getText());
			ps.setNString(5, endDate.getText());
			ps.setNString(6, tenantName.getText());
			//ps.setNString(2, textField_1.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Record Updated");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
		
}


	private void DeleteTenant() {
		connection = DBconnection.getConnection();
		try {
			String Delete = "delete from propertymanagementsystem.tenant where tenant_id = ?;";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(Delete);
			ps.setString(1, tenantid.getText());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Record Deleted!");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
	}

	private void SaveToComment() {
		connection = DBconnection.getConnection();
		try {
			String query = "insert into comments  values (?,?,?,?);";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(query);
			ps.setNString(1, clientid.getText());
			ps.setNString(2, pid.getText());
			ps.setNString(3, datE.getText());
			ps.setNString(4, comment.getText());		
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
		
	}
	private void UpdateComment() {
		connection = DBconnection.getConnection();
		try {
			String update = "update propertymanagementsystem.comments set p_id = ?, date = ?, comment = ? where clientid = ?;";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(update);
			ps.setString(4, clientid.getText());
			ps.setNString(1, p_id.getText());
			ps.setNString(2, date.getText());
			ps.setNString(3, comment.getText());
			
			//ps.setNString(2, textField_1.getText());
		
		

		
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Record Updated");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
		
}
	private void DeleteComment() {
		connection = DBconnection.getConnection();
		try {
			String Delete = "delete from propertymanagementsystem.comments where clientid = ?;";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(Delete);
			ps.setString(1, clientid.getText());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Record Deleted!");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
	}
	private void SaveToAppointment() {
		connection = DBconnection.getConnection();
		try {
			String query = "insert into appointment values (?,?,?,?,?)";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(query);
			ps.setNString(1, app_id.getText());
			ps.setNString(2, date.getText());
			ps.setNString(3, time.getText());
			ps.setNString(4, client_id.getText());
			ps.setNString(5, p_id.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Saved");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
		
	}
	private void UpdateAppointment() {
		connection = DBconnection.getConnection();
		try {
			String update = "update propertymanagementsystem.appointment set date = ?, time = ?, client_id = ?, p_id = ? where Appointment_id = ?";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(update);
			ps.setNString(1, date.getText());
			ps.setNString(2, time.getText());
			ps.setNString(3, client_id.getText());
			ps.setNString(4, p_id.getText());
			ps.setString(5, app_id.getText());
		
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Record Updated");
		}
		catch (Exception O) {
			if(app_id == null) {
				JOptionPane.showMessageDialog(null,  "Enter Appointment ID");
			}
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
	}
	
	private void DeleteAppointment() {
		connection = DBconnection.getConnection();
		try {
			String Delete = "delete from propertymanagementsystem.appointment where appointment_id = ?;";
			PreparedStatement ps = DBconnection.getConnection().prepareStatement(Delete);
			ps.setString(1, app_id.getText());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Record Deleted!");
		}
		catch (Exception O) {
			JOptionPane.showMessageDialog(null, "ERROR!\n\tValues Missing");
			O.printStackTrace();
		}
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
	
		
	}
}