import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class StartPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPanel frame = new StartPanel();
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
	public StartPanel() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6_1 = new JLabel("____________________________________");
		lblNewLabel_6_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_6_1.setBounds(235, 188, 367, 28);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("Property Managemet System");
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel_6.setBounds(241, 173, 361, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-mansion-100 (1).png"));
		lblNewLabel_3.setBounds(365, 30, 102, 147);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Client C = new Client();
				C.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-client-100.png"));
		lblNewLabel_2_1.setBounds(510, 295, 102, 100);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CLIENT");
		lblNewLabel_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Client C = new Client();
				C.setVisible(true);
				dispose();	
			}
		});
		lblNewLabel_1_1.setForeground(new Color(255, 240, 245));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(520, 388, 98, 57);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame LF = new LoginFrame();
				LF.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\EURO COMPUTERS\\Downloads\\icons8-administrator-male-skin-type-7-100.png"));
		lblNewLabel_2.setBounds(235, 295, 102, 100);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame LF = new LoginFrame();
				LF.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(255, 240, 245));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(245, 388, 98, 57);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 867, 644);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("X");
		lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3_1.setBounds(839, 0, 28, 38);
		lblNewLabel_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 31));
		panel.add(lblNewLabel_3_1);
	}

}
