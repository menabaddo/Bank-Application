import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import net.proteanit.sql.DbUtils;

public class Mypage extends JFrame {
	java.sql.Connection conn;

	ResultSet rs;

	PreparedStatement pst;

	JFrame frame;

	JLabel imageLabel;

	ImageIcon icon;

	Icon hideIcon;

	Icon editIcon;

	Icon saveIcon;
	
	Icon checkIcon;

	Icon searchIcon;

	Icon withdrawIcon;

	JTabbedPane tabbedPane;

	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JPanel panel8;
	JPanel panel9;

	JLabel label1; // User
	JLabel label2; // Date

	JLabel label3;
	JLabel label4;
	JLabel label5; // profile panel left side
	JLabel label6;
	JLabel label7;

	JLabel label8;
	JLabel label9;
	JLabel label10; // profile panel right side
	JLabel label11;
	JLabel label12;

	JLabel label13;
	JLabel label14; // deposit panel
	JLabel label15;
	JLabel label16;
	JLabel label17;

	JLabel label18;
	JLabel label19;
	JLabel label20;
	JLabel label21; // transfer panel
	JLabel label22;
	JLabel label23;

	JLabel label24;
	JLabel label25;
	JLabel label26; // withdraw panel
	JLabel label27;
	JLabel label28;
	JLabel label29;

	JTextField textField1; // User
	JTextField textField2; // Date

	JTextField textField3;
	JTextField textField4;
	JTextField textField5; // profile panel left side
	JTextField textField6;
	JTextField textField7;

	JTextField textField8;
	JTextField textField9;
	JTextField textField10; // profile panel right side
	JTextField textField11;
	JTextField textField12;

	JTextField textField13;
	JTextField textField14;
	JTextField textField15; // deposit panel
	JTextField textField16;
	JTextField textField17;
	JTextField textField18;

	JTextField textField19;
	JTextField textField20;
	JTextField textField21; // transfer panel
	JTextField textField22;
	JTextField textField23;
	JTextField textField24;
	JTextField textField25;
	JTextField textField26;

	JTextField textField27;
	JTextField textField28;
	JTextField textField29; // withdraw panel
	JTextField textField30;
	JTextField textField31;
	JTextField textField32;

	JComboBox creditAccount;

//	String creditAcc[] = { "" };

	JButton buttonOne;
	JButton buttonTwo;
	JButton buttonThree;
	JButton buttonFour;
	JButton buttonFive;
	JButton buttonSix;
	JButton buttonSeven;
	JButton buttonEight;
	JButton buttonNine;
	JButton buttonTen;
	JButton buttonEleven;
	JButton buttonTwelve;
	JButton buttonThirteen;

	JTable table; // customer list table
	JScrollPane jscroll;

	JTable table2; // Transaction table
	JScrollPane jscroll2;



	Mypage(){



		conn = javaConnect.ConnecrDb();
		frame = new JFrame("LEXOCORP - Home Page");
		icon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/LEXOCORP_LOGO.png");




		imageLabel = new JLabel(icon);
		
		label1 = new JLabel("User"); // USER
		label2 = new JLabel("Date"); // DATE

		// -----------------------------PROFILE
		// LABEL-------------------------------------------------------------------------------------------------

		label3 = new JLabel("Name");
		label4 = new JLabel("Date of Birth"); // profile left side
		label5 = new JLabel("Nationality");
		label6 = new JLabel("Gender");
		label7 = new JLabel("Address");

		label8 = new JLabel("Account No.");
		label9 = new JLabel("Account Type"); // profile right side
		label10 = new JLabel("State");
		label11 = new JLabel("Mobile");
		label12 = new JLabel("Security Question");

		// ------------------------------DEPOSIT
		// LABEL-------------------------------------------------------------------------------------------------
		label13 = new JLabel("User");
		label14 = new JLabel("Name");
		label15 = new JLabel("Account No.");
		label16 = new JLabel("Available Balance");
		label17 = new JLabel("Deposit Amount");

		// ------------------------------TRANSFER
		// LABEL-------------------------------------------------------------------------------------------------
		label18 = new JLabel("User");
		label19 = new JLabel("Name"); // profile right side
		label20 = new JLabel("Account No.");
		label21 = new JLabel("Available Balance");
		label22 = new JLabel("Transfer Amount");
		label23 = new JLabel("Credit Account");

		// ------------------------------WITHDRAW
		// LABEL-------------------------------------------------------------------------------------------------
		label24 = new JLabel("User");
		label25 = new JLabel("Name"); // profile right side
		label26 = new JLabel("Account No.");
		label27 = new JLabel("Available Balance");
		label28 = new JLabel("Amount");
		label29 = new JLabel("Total");

		textField1 = new JTextField(16);
		textField2 = new JTextField(16);

		textField3 = new JTextField(16);
		textField4 = new JTextField(16); // textField left side profile panel
		textField5 = new JTextField(16);
		textField6 = new JTextField(16);
		textField7 = new JTextField(16);

		textField8 = new JTextField(16);
		textField9 = new JTextField(16);
		textField10 = new JTextField(16); // textField right side profile panel
		textField11 = new JTextField(16);
		textField12 = new JTextField(16);

		hideIcon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/hideIcon.png");
		editIcon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/editIcon.png");
		saveIcon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/saveIcon.png");
		checkIcon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/checkIcon.png");
		searchIcon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/searchIcon.png");
		withdrawIcon = new ImageIcon(
				"C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/withdrawIcon.png");

		buttonOne = new JButton(hideIcon);
		buttonTwo = new JButton("Edit", editIcon);
		buttonThree = new JButton("Save", saveIcon);
		buttonFour = new JButton("Search", searchIcon);
		buttonFive = new JButton("Total");
		buttonSix = new JButton("Deposit", checkIcon);
		buttonSeven = new JButton("Search", searchIcon);
		buttonEight = new JButton("Total");
		buttonNine = new JButton("Show");
		buttonTen = new JButton("Transfer", checkIcon);
		buttonEleven = new JButton("Search", searchIcon);
		buttonTwelve = new JButton("Show", checkIcon);
		buttonThirteen = new JButton("Withdraw", withdrawIcon);

		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(20, 130, 950, 500);

		textField13 = new JTextField(16);
		textField14 = new JTextField(16);
		textField15 = new JTextField(16); // textField Deposit Panel
		textField16 = new JTextField(16);
		textField17 = new JTextField(16);
		textField18 = new JTextField(16);

		textField19 = new JTextField(16);
		textField20 = new JTextField(16);
		textField21 = new JTextField(16); // textField Deposit Panel
		textField22 = new JTextField(16);
		textField23 = new JTextField(16);
		textField24 = new JTextField(16);
		textField25 = new JTextField(16);
		textField26 = new JTextField(16);

		creditAccount = new JComboBox();

		textField27 = new JTextField(16); // textField Withdraw Panel
		textField28 = new JTextField(16);
		textField29 = new JTextField(16);
		textField30 = new JTextField(16);
		textField31 = new JTextField(16);
		textField32 = new JTextField(16);

		

		// PROFILE
		// PANEL-----------------------------------------------------------------------------------------------------------------------------------------------------------------
		panel1 = new JPanel();
		panel1.setLayout(null);


		panel1.add(label3);
		panel1.add(textField3);
		label3.setBounds(30, 50, 50, 50); // NAME
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField3.setBounds(130, 60, 250, 30);
		textField3.setEditable(false);

		panel1.add(label4);
		panel1.add(textField4);
		label4.setBounds(30, 120, 100, 50); // DATE OF BIRTH
		label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField4.setBounds(130, 130, 250, 30);
		textField4.setEditable(false);

		panel1.add(label5);
		panel1.add(textField5);
		label5.setBounds(30, 190, 100, 50); // NATIONALITY
		label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField5.setBounds(130, 200, 250, 30);
		textField5.setEditable(false);

		panel1.add(label6);
		panel1.add(textField6);
		label6.setBounds(30, 260, 100, 50); // GENDER
		label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField6.setBounds(130, 270, 250, 30);
		textField6.setEditable(false);

		panel1.add(label7);
		panel1.add(textField7);
		label7.setBounds(30, 330, 100, 50); // ADDRESS
		label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField7.setBounds(130, 340, 250, 30);
		textField7.setEditable(false);

		// -----------PROFILE RIGHT
		// SIDE---------------------------------------------------------------------//
		panel1.add(label8);
		panel1.add(textField8);
		label8.setBounds(470, 50, 100, 50); // ACCOUNT NO
		label8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField8.setBounds(600, 60, 250, 30);
		textField8.setEditable(false);

		panel1.add(label9);
		panel1.add(textField9);
		label9.setBounds(470, 120, 100, 50); // ACCOUNT TYPE
		label9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField9.setBounds(600, 130, 250, 30);
		textField9.setEditable(false);

		panel1.add(label10);
		panel1.add(textField10);
		label10.setBounds(470, 190, 100, 50); // STATE
		label10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField10.setBounds(600, 200, 250, 30);
		textField10.setEditable(false);

		panel1.add(label11);
		panel1.add(textField11);
		label11.setBounds(470, 260, 100, 50); // MOBILE
		label11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField11.setBounds(600, 270, 250, 30);
		textField11.setEditable(false);

		panel1.add(label12);
		panel1.add(textField12);
		label12.setBounds(470, 330, 200, 50); // SECURITY QUESTION
		label12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField12.setBounds(600, 340, 250, 30);
		textField12.setEditable(false);

		panel1.add(buttonTwo);
		buttonTwo.setBounds(600, 400, 115, 40);

		panel1.add(buttonThree);
		buttonThree.setBounds(735, 400, 115, 40);

		// ---------------------------------------------------DEPOSIT
		// PANEL------------------------------------------------------------------------------

		panel2 = new JPanel();
		panel2.setLayout(null);

		panel2.add(label13);
		panel2.add(textField13);
		label13.setBounds(200, 40, 200, 50);
		label13.setFont(new Font("Tahoma", Font.PLAIN, 16)); // User
		textField13.setBounds(350, 50, 300, 30);

		panel2.add(buttonFour);
		buttonFour.setBounds(670, 50, 100, 30);

		panel2.add(label14);
		panel2.add(textField14);
		label14.setBounds(200, 120, 200, 50);
		label14.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Name
		textField14.setBounds(350, 130, 300, 30);
		textField14.setEditable(false);

		panel2.add(label15);
		panel2.add(textField15);
		label15.setBounds(200, 180, 200, 50);
		label15.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Account No.
		textField15.setBounds(350, 190, 300, 30);
		textField15.setEditable(false);

		panel2.add(label16);
		panel2.add(textField16);
		label16.setBounds(200, 240, 200, 50);
		label16.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Available balance
		textField16.setBounds(350, 250, 300, 30);
		textField16.setEditable(false);

		panel2.add(label17);
		panel2.add(textField17);
		panel2.add(textField18);
		panel2.add(buttonFive);
		label17.setBounds(200, 300, 200, 50);
		label17.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Deposit Amount
		textField17.setBounds(350, 310, 145, 30);
		textField17.setEditable(true);
		textField18.setBounds(500, 310, 150, 30);
		textField18.setEditable(false);
		buttonFive.setBounds(670, 310, 100, 30);

		panel2.add(buttonSix);
		buttonSix.setBounds(450, 370, 100, 30);



		// TRANSFER
		// PANEL--------------------------------------------------------------------------------------------------------------------------------------


		buttonSeven.setBounds(670, 50, 100, 30);
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.add(label18);
		panel3.add(textField19);
		label18.setBounds(200, 40, 200, 50);
		label18.setFont(new Font("Tahoma", Font.PLAIN, 16)); // User
		textField19.setBounds(350, 50, 300, 30);

		panel3.add(buttonSeven);
		buttonSeven.setBounds(670, 50, 100, 30);

		panel3.add(label19);
		panel3.add(textField20);
		label19.setBounds(200, 120, 200, 50);
		label19.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Name
		textField20.setBounds(350, 130, 300, 30);
		textField20.setEditable(false);

		panel3.add(label20);
		panel3.add(textField21);
		label20.setBounds(200, 180, 200, 50);
		label20.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Account No.
		textField21.setBounds(350, 190, 300, 30);
		textField21.setEditable(false);
		
		panel3.add(label21);
		panel3.add(textField22);
		label21.setBounds(200, 240, 200, 50);
		label21.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Available balance
		textField22.setBounds(350, 250, 300, 30);
		textField22.setEditable(false);
		
		panel3.add(label22);
		panel3.add(textField23);
		panel3.add(textField24);
		panel3.add(buttonEight);
		label22.setBounds(200, 300, 200, 50);
		label22.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Transfer Amount
		textField23.setBounds(350, 310, 145, 30);
		textField23.setEditable(true);
		textField24.setBounds(500, 310, 150, 30);
		textField24.setEditable(false);
		buttonEight.setBounds(670, 310, 100, 30);

		panel3.add(label23);
		panel3.add(buttonNine);
		panel3.add(buttonTen); // credit account
		panel3.add(creditAccount);
		panel3.add(textField25);
		panel3.add(textField26);
		label23.setBounds(200, 360, 200, 50);
		label23.setFont(new Font("Tahoma", Font.PLAIN, 16));
		creditAccount.setBounds(350, 370, 300, 30);
		textField25.setBounds(670, 370, 100, 30);
		textField26.setBounds(780, 370, 100, 30);
		textField26.setEditable(false);
		buttonNine.setBounds(350, 430, 100, 30);
		buttonTen.setBounds(500, 430, 200, 30);



		// -----------------------------WITHDRAW
		// PANEL--------------------------------------------------------------------------------------------------------------------------

		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.add(label24);
		panel4.add(textField27);
		label24.setBounds(200, 40, 200, 50);
		label24.setFont(new Font("Tahoma", Font.PLAIN, 16)); // User
		textField27.setBounds(350, 50, 300, 30);
		panel4.add(buttonEleven);
		buttonEleven.setBounds(670, 50, 100, 30);

		panel4.add(label25);
		panel4.add(textField28);
		label25.setBounds(200, 120, 200, 50);
		label25.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Name
		textField28.setBounds(350, 130, 300, 30);
		textField28.setEditable(false);

		panel4.add(label26);
		panel4.add(textField29);
		label26.setBounds(200, 180, 200, 50);
		label26.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Account No.
		textField29.setBounds(350, 190, 300, 30);
		textField29.setEditable(false);

		panel4.add(label27);
		panel4.add(textField30);
		label27.setBounds(200, 240, 200, 50);
		label27.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Available balance
		textField30.setBounds(350, 250, 300, 30);
		textField30.setEditable(false);

		panel4.add(label28);
		panel4.add(textField31);
		label28.setBounds(200, 300, 200, 50);
		label28.setFont(new Font("Tahoma", Font.PLAIN, 16)); // Amount
		textField31.setBounds(350, 310, 300, 30);

		panel4.add(label29);
		panel4.add(buttonTwelve);
		panel4.add(buttonThirteen); // Total
		panel4.add(textField32);
		label29.setBounds(200, 360, 200, 50);
		label29.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField32.setBounds(350, 370, 300, 30);
		buttonTwelve.setBounds(670, 370, 100, 30);
		buttonThirteen.setBounds(450, 430, 130, 30);
		
		
		
		// -----------------------CUSTOMER LIST
		// PANEL-------------------------------------------------------------------------------------------------
		panel5 = new JPanel();
		table = new JTable();
		jscroll = new JScrollPane(table); // allows user to scroll and see the header
		panel5.add(jscroll);
		panel5.setLayout(null);
		table.setPreferredSize(new Dimension(500, 500));
		Table1(); // calling the method to populate the table from the database
		Border blackline = BorderFactory.createLineBorder(Color.red);
		panel5.setBorder(blackline);
		jscroll.setBounds(20, 30, 900, 400);
		
		// -----------------------CUSTOMER LIST
		// PANEL-------------------------------------------------------------------------------------------------
		panel6 = new JPanel();
		table2 = new JTable();
		jscroll2 = new JScrollPane(table2);
		panel6.add(jscroll2);
		panel6.setLayout(null);
		table2.setPreferredSize(new Dimension(500, 500));
		Table2(); // calling the method to populate the table from the database
		Border blackline2 = BorderFactory.createLineBorder(Color.red);
		panel6.setBorder(blackline2);
		jscroll2.setBounds(20, 30, 900, 400);

		panel7 = new JPanel();
		panel8 = new JPanel();
		panel9 = new JPanel();


		tabbedPane.addTab("Profile", panel1);
		tabbedPane.addTab("Deposit", panel2);
		tabbedPane.addTab("Transfer", panel3);
		tabbedPane.addTab("Withdrawal", panel4); // adding panels to tabbed panels
		tabbedPane.addTab("Customer List", panel5);
		tabbedPane.addTab("Transaction", panel6);
		tabbedPane.addTab("View Balance", panel7);
		tabbedPane.addTab("Change Pin", panel8);
		tabbedPane.addTab("About", panel9);

		tabbedPane.setBackground(Color.WHITE);

		frame.setSize(1000, 700); // frame settings
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(imageLabel);
		frame.add(label1);
		frame.add(label2); // added some components to the frame
		frame.add(textField1);
		frame.add(textField2);
		frame.add(buttonOne);
		frame.add(tabbedPane);
		
		

		imageLabel.setBounds(20, 10, 280, 100);
		label1.setBounds(600, 20, 100, 50); // user // settings for components on the frame
		label2.setBounds(600, 70, 100, 50); // date
		textField1.setBounds(650, 30, 150, 30);
		buttonOne.setBounds(810, 30, 50, 30);
		textField2.setBounds(650, 80, 210, 30);
		textField2.setEditable(false);

		Calendar(); // calling the calendar method to get the current date
		Account();





		// PROFILE PANEL BUTTONS
		// -----------------------------------------------------------------------------------------------------------------------------------------------------------------

		// --------------------------HIDE ICON
		// BUTTON----------------------------------------------------------------------------

		// setting the textField to the value in the data base

		buttonOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String sql = "select * from Account where Name=?"; // retrieve all the data of the name specified when
																	// the eye button is clicked

				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField1.getText());
					rs = pst.executeQuery();
					if (rs.next()) {
						String add1 = rs.getString("Name");
						textField3.setText(add1);

						String add2 = rs.getString("Acc");
						textField8.setText(add2);

						String add3 = rs.getString("DOB");
						textField4.setText(add3);
						// gets the info from db and sets it to the various textfield
						String add4 = rs.getString("Acc_Type");
						textField9.setText(add4);

						String add5 = rs.getString("Nationality");
						textField5.setText(add5);

						String add6 = rs.getString("State");
						textField10.setText(add6);

						String add7 = rs.getString("Gender");
						textField6.setText(add7);

						String add8 = rs.getString("Mobile");
						textField11.setText(add8);

						String add9 = rs.getString("Address");
						textField7.setText(add9);

						String add10 = rs.getString("Sec_Q");
						textField12.setText(add10);

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

		// ---------------------EDIT
		// BUTTON------------------------------------------------
		// When clicked it set's some text field to become editable

		buttonTwo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField5.setEditable(true);
				textField6.setEditable(true);
				textField7.setEditable(true); // allows you to edit some text field
				textField10.setEditable(true);
				textField11.setEditable(true);
				textField12.setEditable(true);

			}
		});


		// SAVE BUTTON
		buttonThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String value1 = textField5.getText(); // Nationality
					String value2 = textField6.getText(); // Gender
					String value3 = textField7.getText(); // Address
					String value4 = textField10.getText(); // State // whatever the user enters is stored in a variable
					String value5 = textField11.getText(); // Mobile
					String value6 = textField12.getText(); // Security Question
					String value7 = textField1.getText(); // Security Question

					String sql = "update Account set Nationality='" + value1 + "', Gender='" + value2 + "', Address='"
							+ value3 + "',State='" + value4 + "',Mobile='" + value5 + "',Sec_Q='" + value6
							+ "' where Name='" + value7 + "'"; // those details are updated into the Account table
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Profile Updated");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});

		// ----DEPOSIT PANEL
		// BUTTONS----------------------------------------------------------------------------------------------

		// SEARCH BUTTON
		buttonFour.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM Balances WHERE Name=?"; // retrieving all columns of specified name from the
																	// balance table

				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField13.getText()); // gets the text of the user input on the user textfield
					rs = pst.executeQuery();
					if (rs.next()) { // if there's an error on not finding the record it moves to the else statement
						String add1 = rs.getString("Name"); // gets the name from the database and sets it to the name
															// text field
						textField14.setText(add1);

						String add2 = rs.getString("Acc");
						textField15.setText(add2);

						String add3 = rs.getString("Balance");
						textField16.setText(add3);

					} else {
						JOptionPane.showMessageDialog(null, "User not found");
						textField14.setText("");
						textField15.setText(""); // clear the textField when user tries to search for another user.
						textField16.setText("");
					}

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1); // if any other error, its going to display it

				} finally {
					try {
//						rs.close();
//						pst.close();
					} catch (Exception e1) {

					}
				}

			}

		});

		// TOTAL BUTTON

		buttonFive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

					int initialBalance = rs.getInt("Balance"); // getting the balance of the particular name specified

					int depositAmount = Integer.parseInt(textField17.getText()); // converting the deposit amount from
																					// string to an integer

					int totalDeposit = initialBalance + depositAmount; // initial balance + deposit amount

					String finalDeposit = Integer.toString(totalDeposit);

					textField18.setText(finalDeposit);

				} catch (SQLException e) {

					JOptionPane.showMessageDialog(null, e);
				}

			}
		});

		// DEPOSIT BUTTON

		buttonSix.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String value1 = textField13.getText();
					String value2 = textField18.getText();
					String sql = "UPDATE balances set Balance='" + value2 + "'WHERE Name='" + value1 + "'";
					pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Sucessfully Deposited");

					textField13.setText("");
					textField14.setText("");
					textField15.setText(""); // clears all text field after funds have been deposited
					textField16.setText("");
					textField17.setText("");
					textField18.setText("");

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});


		// ---------TRANSFER PANEL BUTTONS
		// --------------------------------------------------------------------------------------------------------------------

		// SEARCH BUTTON
		buttonSeven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String sql = "SELECT * FROM Balances WHERE Name=?"; // retrieving all columns of specified name from the
				// balance table

				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField19.getText()); // gets the text of the user input on the user textfield
					rs = pst.executeQuery();
					if (rs.next()) { // if there's an error on not finding the record it moves to the else statement
						String add1 = rs.getString("Name"); // gets the name from the database and sets it to the name
						// text field
						textField20.setText(add1);

						String add2 = rs.getString("Acc");
						textField21.setText(add2);

						String add3 = rs.getString("Balance");
						textField22.setText(add3);

					} else {
						JOptionPane.showMessageDialog(null, "User not found");
						textField20.setText("");
						textField21.setText(""); // clear the textField when user tries to search for another user.
						textField22.setText("");
					}

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1); // if any other error, its going to display it

				} finally {
					try {
//rs.close();
//pst.close();
					} catch (Exception e1) {

					}
				}

			}
		});

		// TOTAL BUTTON

		buttonEight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					int initialBalance = rs.getInt("Balance"); // getting the balance of the particular name specified

					int transferAmount = Integer.parseInt(textField23.getText()); // converting the transfer amount from
																					// string to an integer

					int totalTransfer = initialBalance - transferAmount; // initial balance - transfer amount

					String finalTransfer = Integer.toString(totalTransfer);

					textField24.setText(finalTransfer);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e); // if any other error, its going to display it

				}
			}
		});

		// SHOW BUTTON

		buttonNine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					int initialBalance = Integer.parseInt(textField25.getText()); // getting the balance of the
																					// particular name specified

					int transferAmount = Integer.parseInt(textField23.getText()); // converting the deposit amount from
																					// string to an integer

					int totalTransfer = initialBalance + transferAmount; // initial balance + deposit amount

					String finalDeposit = Integer.toString(totalTransfer);

					textField26.setText(finalDeposit);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e); // if any other error, its going to display it

				}
			}
		});

		// CREDIT ACCOUNT COMBO BOX

		creditAccount.addPopupMenuListener(new PopupMenuListener() {

			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				try {

					String a1 = (String) creditAccount.getSelectedItem();
					String sql = "SELECT * FROM Balances WHERE Acc=?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, a1);
					rs = pst.executeQuery();
					if (rs.next()) {
						String add = rs.getString("Balance");
						textField25.setText(add);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e);

				}

			}

			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {
				// TODO Auto-generated method stub

			}

		});

		// TRANSFER BUTTON
		buttonTen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				TransferD();
				TransferC();

			}
		});


		// ---------WITHDRAW PANEL BUTTONS
		// --------------------------------------------------------------------------------------------------------------------

		// SEARCH BUTTONS
		buttonEleven.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String sql = "SELECT * FROM Balances WHERE Name=?"; // retrieving all columns of specified name from the
				// balance table

				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField27.getText()); // gets the text of the user input on the user textfield
					rs = pst.executeQuery();
					if (rs.next()) { // if there's an error on not finding the record it moves to the else statement
						String add1 = rs.getString("Name"); // gets the name from the database and sets it to the name
						// text field
						textField28.setText(add1);

						String add2 = rs.getString("Acc");
						textField29.setText(add2);

						String add3 = rs.getString("Balance");
						textField30.setText(add3);

					} else {
						JOptionPane.showMessageDialog(null, "User not found");
						textField28.setText("");
						textField29.setText(""); // clear the textField when user tries to search for another user.
						textField30.setText("");
					}

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, e1); // if any other error, its going to display it

				} finally {
					try {
//rs.close();
//pst.close();
					} catch (Exception e1) {

					}
				}

			}

		});

		// SHOW BUTTON
		buttonTwelve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					int initialBalance = rs.getInt("Balance"); // getting the balance of the particular name specified

					int withdrawAmount = Integer.parseInt(textField31.getText()); // converting the transfer amount from
																					// string to an integer

					int totalWithdrawn = initialBalance - withdrawAmount; // initial balance - withdraw amount

					String finalWithdraw = Integer.toString(totalWithdrawn);

					textField32.setText(finalWithdraw);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e); // if any other error, its going to display it

				}
			}
		});

		// WITHDRAW BUTTON
		buttonThirteen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				withdrawD();
			}
		});

	}

//---------------------------------------------------------- METHODS------------------------------------------------------------------------------------------------------
	// CALENDAR
	public void Calendar() {
		GregorianCalendar cal = new GregorianCalendar();
		int month = cal.get(java.util.Calendar.MONTH); // this generates the current date at the top of the frame
		int year = cal.get(java.util.Calendar.YEAR);
		int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
		textField2.setText(+day + " - " + (month + 1) + " - " + year);

	}

	// DEBIT METHOD
	public void TransferD() {
		try {

			String value1 = textField19.getText(); // get's the current user name to be debited
			String value2 = textField24.getText(); // get's the final balance of the sender
			String sql = "UPDATE Balances SET Balance='" + value2 + "'WHERE Name='" + value1 + "'"; // updates the
																									// sender's balance
																									// based on the name
																									// entered into the
																									// search box

			pst = conn.prepareStatement(sql);
			pst.execute();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// CREDIT METHOD
	public void TransferC() {
		try {
			String value1 = (String) creditAccount.getSelectedItem(); // getting the generated account number
			String value2 = textField26.getText(); // getting the final balance of the receiver
			String sql = "UPDATE Balances SET Balance='" + value2 + "'WHERE Acc='" + value1 + "'"; // updates the user's
																									// balance on the
																									// receiver end
			pst = conn.prepareStatement(sql);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Successfully Transferred");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// ACCOUNT GENERATOR
	public void Account() {

		try {
			String sql = "SELECT * FROM Balances";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String account = rs.getString("Acc");
				creditAccount.addItem(account);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	// DEBIT METHOD
	public void withdrawD() {
		try {

			String value1 = textField28.getText(); // get's the current user name to be debited
			String value2 = textField32.getText(); // get's the final balance to be withdrawn
			String sql = "UPDATE Balances SET Balance='" + value2 + "'WHERE Name='" + value1 + "'"; // updates the
																									// sender's balance
																									// based on the name
																									// entered into the
																									// search box

			pst = conn.prepareStatement(sql);
			pst.execute();
			JOptionPane.showMessageDialog(null, "Successfully Withdrawn");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// POPULATE THE TABLE UNDER CUSTOMER LIST
	public void Table1() {
		// in order to be able to populate a table from an external database we had to
		// use a jar file " rs2xml "
		try {
			String sql = "SELECT Acc,Name,DOB,Acc_Type,Gender,Mobile FROM account";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {
				rs.close();
				pst.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	// POPULATE THE TABLE UNDER TRANSACTION PANEL
	public void Table2() {
		// in order to be able to populate a table from an external database we had to
		// use a jar file " rs2xml "
		try {
			String sql = "SELECT Acc,Name,MICR_No,Balance FROM Balances";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			table2.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} finally {

			try {
				rs.close();
				pst.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
}
