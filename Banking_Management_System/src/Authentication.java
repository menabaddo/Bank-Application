
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

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
	JTextField textField2;

	ImageIcon icon;
	ImageIcon icon2;
	ImageIcon icon3;

	JLabel imageLabel;
	JLabel imageLabel2;
	JLabel imageLabel3;

	JButton buttonOne;
	JButton buttonTwo;

	Authentication() {


		conn = javaConnect.ConnecrDb();
		frame = new JFrame("LEXOCORP");
		authentication = new JPanel();

		label = new JLabel();
		label2 = new JLabel("Enter Account no.");
		label3 = new JLabel("Pin");
		textField1 = new JTextField(16);
		textField2 = new JTextField(16);
		buttonOne = new JButton("Login");
		buttonTwo = new JButton("New Account");



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
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		authentication.setSize(700, 400);
		authentication.setBackground(Color.WHITE);
		authentication.setLayout(null);
		authentication.setBounds(40, 40, 700, 400);

		TitledBorder blackline = BorderFactory.createTitledBorder("Authentication");
		blackline.setTitleColor(Color.RED);
		blackline.setTitleFont(new Font("Tahoma", Font.BOLD, 24));

		frame.add(authentication);

		authentication.add(imageLabel);
		authentication.add(imageLabel2);
		authentication.add(imageLabel3);
		authentication.setBorder(blackline);

		authentication.add(label2);
		authentication.add(label3);

		authentication.add(textField1); // added textField for entering Account number
		authentication.add(textField2); // added textField for entering pin

		authentication.add(buttonOne); // added login button
		authentication.add(buttonTwo); // added new account button

		// --------------------------------------------------
		imageLabel.setBounds(250, -50, 300, 300); // LEXOCORP

		imageLabel2.setBounds(540, 100, 200, 200); // PADDLOCK

		imageLabel3.setBounds(545, 160, 200, 200); // KEY

		label2.setBounds(50, 100, 300, 200); // Enter Account Number
		label2.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField1.setBounds(300, 190, 300, 30);

		label3.setBounds(120, 220, 300, 100); // Enter Pin
		label3.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField2.setBounds(300, 250, 300, 30);

		buttonOne.setBounds(300, 300, 100, 50); // login button
		buttonTwo.setBounds(420, 300, 200, 50); // New Account button

//-----------------------------------------CREATE ACCOUNT------------------------------------------------------------------------------------------------------------

		createAccount = new JFrame("LEXOCORP");
		
		buttonOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = "select * from Account where Acc=? and Pin =?"; // This retrieves the Account number and
																				// pin from the database
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField1.getText());
					pst.setString(2, textField2.getText());
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

		buttonTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				CreateAccountPage obj = new CreateAccountPage();
				obj.setVisible(true);

			}
		});


	}


	}




