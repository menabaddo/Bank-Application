import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ForgotPass extends JFrame {
	
	java.sql.Connection conn;

	ResultSet rs;

	PreparedStatement pst;

	JFrame frame;
	JPanel panel;
	ImageIcon icon;
	ImageIcon searchIcon;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel imageLabel;
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	JPasswordField passwordField1;
	JPasswordField passwordField2;
	JButton buttonOne;
	JButton buttonTwo;
	JButton buttonThree;
	JButton buttonFour;
	boolean checker = false;
	ForgotPass() {
		conn = javaConnect.ConnecrDb();

		icon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/LEXOCORP_LOGO.png");
		searchIcon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/searchIcon.png");
		imageLabel = new JLabel(icon);
		frame = new JFrame("Reset Pin");
		panel = new JPanel();

		label1 = new JLabel("Enter Your Name");
		label2 = new JLabel("Security Question");
		label3 = new JLabel("Security Answer");
		label4 = new JLabel("Enter New Pin");
		label5 = new JLabel("Re-Enter Pin");

		textField1 = new JTextField(16);
		textField2 = new JTextField(16);
		textField3 = new JTextField(16);
		passwordField1 = new JPasswordField();
		passwordField2 = new JPasswordField();

		buttonOne = new JButton(searchIcon);
		buttonTwo = new JButton("Validate");
		buttonThree = new JButton("Back");
		buttonFour = new JButton("Submit");

		panel.setLayout(null);
		panel.setBounds(0, 0, 700, 600);
		panel.setBackground(Color.WHITE);

		panel.add(label1);
		panel.add(textField1);
		textField1.setEditable(true); // Enter your name
		panel.add(buttonOne);
		label1.setBounds(80, 100, 150, 30);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField1.setBounds(210, 100, 250, 30);
		buttonOne.setBounds(470, 100, 50, 30);

		panel.add(label2);
		panel.add(textField2);
		textField2.setEditable(false);
		label2.setBounds(80, 160, 150, 30); // security question
		textField2.setBounds(210, 160, 250, 30);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 13));

		panel.add(label3);
		panel.add(textField3);
		textField3.setEditable(false); // security answer
		label3.setBounds(80, 220, 100, 30);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField3.setBounds(210, 220, 250, 30);

		panel.add(label4);
		panel.add(passwordField1);
		passwordField1.setEditable(false); // enter new pin
		label4.setBounds(80, 280, 100, 30);
		label4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField1.setBounds(210, 280, 250, 30);

		panel.add(label5);
		panel.add(passwordField2);
		passwordField2.setEditable(false);
		label5.setBounds(80, 340, 100, 30); // re-enter pin
		label5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField2.setBounds(210, 340, 250, 30);




		panel.add(buttonTwo);
		buttonTwo.setBounds(470, 220, 115, 30);
		panel.add(buttonThree);
		buttonThree.setBounds(210, 400, 115, 40);
		panel.add(buttonFour);
		buttonFour.setBounds(345, 400, 115, 40);
		buttonFour.setEnabled(false);

		panel.add(imageLabel);
		imageLabel.setBounds(180, 10, 300, 50);





		frame.add(panel);
		frame.setLayout(null);
		frame.setBackground(Color.white);
//		frame.getContentPane().setBackground(Color.white);
		frame.setResizable(false);
		frame.setSize(700, 500); // size of frame
		frame.setLocationRelativeTo(null);
//		frame.dispose();
//		frame.setUndecorated(true);
//		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buttonOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

//				buttonTwo.setEnabled(true);


				String sql = "select * from Account where Name=?"; // retrieve all the data of the name specified when
																	// the eye button is clicked

				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField1.getText());
					rs = pst.executeQuery();

					if (rs.next()) {
						textField3.setEditable(true);
						String add1 = rs.getString("Sec_Q");
						textField2.setText(add1);
						rs.close();
						pst.close();

					}

					else {
						JOptionPane.showMessageDialog(null, "Enter Correct Name"); // if record not found it displays an
																					// option pane
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e); // if any other error occurs it displays the error on an
															// option pane

				} finally {
					try {
						rs.close();
						pst.close();
					} catch (Exception e) {

					}
				}

			}
		});

		buttonTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String sql = "select * from Account where Name=?";
				try {
					String userAnswer = textField3.getText().trim();
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField1.getText());
					rs = pst.executeQuery();
					if (rs.next()) {

						String add1 = rs.getString("Sec_A").trim();

						if (userAnswer.equals(add1)) {

							checker = true;
							textField3.setBackground(Color.GREEN);
							textField3.setEditable(false);
							passwordField1.setEditable(true);
							passwordField2.setEditable(true);

							buttonFour.setEnabled(true);
						} else {
							System.out.println(userAnswer);
							System.out.println(add1);
							JOptionPane.showMessageDialog(null, "Wrong answer");
						}

						rs.close();
						pst.close();
					}

				} catch (SQLException e) {

					JOptionPane.showMessageDialog(null, e);
				}

			}
		});

		// BACK BUTTON
		buttonThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Authentication obj = new Authentication();
				obj.setVisible(true);

			}
		});

		buttonFour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String value1 = textField1.getText();

				char[] pass = passwordField1.getPassword();
				String passString = new String(pass);

				char[] pass2 = passwordField2.getPassword();
				String passString2 = new String(pass2);

				System.out.println("Pass String 1: " + passString);

				System.out.println("Pass String 2: " + passString2);



				String value2 = passString;
				String value3 = passString2;

				if (value2.equals(value3)) {
					try {
						String sql = "UPDATE Account set Pin='" + value3 + "'WHERE Name='" + value1 + "'";
						pst = conn.prepareStatement(sql);

						pst.execute();
						JOptionPane.showMessageDialog(null, "Pin Successfully Changed");
						textField1.setText("");
						textField2.setText("");
						textField3.setText("");
						passwordField1.setText("");
						passwordField2.setText("");

						textField2.setEditable(false);
						textField3.setEditable(false);
						passwordField1.setEditable(false);
						passwordField2.setEditable(false);
						textField3.setBackground(Color.WHITE);

						rs.close();
						pst.close();

					} catch (SQLException e) {

						JOptionPane.showMessageDialog(null, e);
					}

				} else {

					JOptionPane.showMessageDialog(null, "Recheck Pin Entries");
					passwordField1.setText("");
					passwordField2.setText("");

				}

			}
		});

	}
	
	

}
