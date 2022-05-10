
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Authentication extends JFrame {
	java.sql.Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	JFrame frame;
	JFrame createAccount;

	JPanel authentication;

	JLabel label;
	JLabel label2;
	JLabel label3;

	JTextField textField1;
//	JTextField textField2;
	JPasswordField passwordField;

	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon icon3;

	JLabel imageLabel;
	JLabel imageLabel2;
	JLabel imageLabel3;

	JButton buttonOne;
	JButton buttonTwo;
	JButton buttonThree;

	Authentication() {


		conn = javaConnect.ConnecrDb();
		frame = new JFrame("LEXOCORP Bank");
		authentication = new JPanel();

		label = new JLabel();
		label2 = new JLabel("      Account no.");
		label3 = new JLabel("Pin");
		textField1 = new JTextField(16);
		passwordField = new JPasswordField();
		buttonOne = new JButton("Login");
		buttonTwo = new JButton("New Account");
		buttonThree = new JButton("Forgot Password");



		icon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/LEXOCORP_LOGO.png"); // LEXOCORP
																													// LOGO
		icon2 = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/lockIcon.png"); // lockIcon
		icon3 = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/keyIcon.png"); // keyLogo

		imageLabel = new JLabel(icon); // added LEXOCORP LOGO TO ICON
		imageLabel2 = new JLabel(icon2); // added paddlock icon TO ICON
		imageLabel3 = new JLabel(icon3); // added keyIcon TO ICON

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
//		frame.getContentPane().setBackground(Color.GRAY);
		frame.setSize(800, 570);
		frame.setLocationRelativeTo(null); // keep the frame in center
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//		authentication.setSize(700, 400);
		authentication.setBackground(Color.WHITE);
		authentication.setLayout(null);
		authentication.setBounds(0, 0, 800, 570);

//		TitledBorder blackline = BorderFactory.createTitledBorder("Authentication");
//		blackline.setTitleColor(Color.RED);
//		blackline.setTitleFont(new Font("verdana", Font.BOLD, 20));

		frame.add(authentication);

		authentication.add(imageLabel);
		authentication.add(imageLabel2);
		authentication.add(imageLabel3);
//		authentication.setBorder(blackline);

		authentication.add(label2);
		authentication.add(label3);

		authentication.add(textField1); // added textField for entering Account number
		authentication.add(passwordField); // added textField for entering pin

		authentication.add(buttonOne); // added login button
		authentication.add(buttonTwo); // added new account button
		authentication.add(buttonThree);
		// --------------------------------------------------
		imageLabel.setBounds(240, -50, 300, 300); // LEXOCORP

		imageLabel2.setBounds(490, 100, 200, 200); // PADDLOCK

		imageLabel3.setBounds(495, 165, 200, 200); // KEY

		label2.setBounds(50, 100, 300, 200); // Enter Account Number
		label2.setFont(new Font("sans-serif", Font.PLAIN, 20));
		textField1.setBounds(250, 190, 300, 30);

		label3.setBounds(120, 220, 300, 100); // Enter Pin
		label3.setFont(new Font("sans-serif", Font.PLAIN, 20));
		passwordField.setBounds(250, 250, 300, 30);

		buttonOne.setBounds(250, 300, 100, 50); // login button
		buttonTwo.setBounds(370, 300, 180, 50); // New Account button
		buttonThree.setBounds(250, 400, 300, 50);

//-----------------------------------------CREATE ACCOUNT------------------------------------------------------------------------------------------------------------

		createAccount = new JFrame("LEXOCORP");
		// LOGIN BUTTON
		buttonOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = "select * from Account where Acc=? and Pin =?"; // This retrieves the Account number and
																				// pin from the database
				try {
					char[] pass = passwordField.getPassword();
					String passString = new String(pass);
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField1.getText());
					pst.setString(2, passString);
					rs = pst.executeQuery();
					if (rs.next()) {
						frame.setVisible(false);
						Loading ob = new Loading();
						ob.setUpLoading();// pops up loading page if credentials is correct
						ob.setVisible(true);
						rs.close();
						pst.close();

					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Credential"); // shows invalid if incorrect
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				} finally {
					try {
						rs.close();
						pst.close();

					} catch (Exception e1) {

					}
				}

			}

		});

		// CREATE NEW PAGE BUTTON
		buttonTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				CreateAccountPage obj = new CreateAccountPage();
				obj.setVisible(true);

			}
		});

		buttonThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ForgotPass obj = new ForgotPass();
				obj.setVisible(true);

			}
		});




	}


	}




