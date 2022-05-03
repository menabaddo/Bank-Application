import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.BorderFactory;     
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class CreateAccountPage extends JFrame {

	java.sql.Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	JFrame frame;
	ImageIcon icon;
	JLabel imageLabel;
	JPanel createAccountP;

	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4; // Sign up details
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9; // Sign up details
	JLabel label10;
	JLabel label11;
	JLabel label12;
	JLabel label13;
	JLabel label14;
	JLabel label15;


	JComboBox accType;
	JComboBox Nationality;
	JComboBox State;
	JComboBox SecQ;

	JButton buttonOne;
	JButton buttonTwo;
	JButton buttonThree;


	// left side

	JTextField textField1;
	JTextField textField2; // to enter details
	JTextField textField3;
	JTextField textField4;
	JRadioButton r1;
	JRadioButton r2;
	ButtonGroup bg;

	// right side
	JTextField textField5;
	JTextField textField6;
	JTextField textField7;
	JTextField textField8;
	JTextField textField9;
//	JTextField textField10;

	JDateChooser dob;

	String accountType[] = { "Select", "Savings", "Current" };

	String Nationale[] = { "Select", "Nigeria", "United States", "China" };

	String Statee[] = { "Select", "Lagos", "Abuja", "Ekiti" };
	
	String SecurityQ[] = { "What is your nick name?", "What is your mother's maiden name?" };



	CreateAccountPage() {
		

		conn = javaConnect.ConnecrDb();


		frame = new JFrame("LEXOCORP - Create Account");
		createAccountP = new JPanel();
		label1 = new JLabel("Account No.");
		label2 = new JLabel("MICR No.");
		label3 = new JLabel("Pin");
		label4 = new JLabel("Account Type");
		label5 = new JLabel("Gender");
		label6 = new JLabel("Address");
		label7 = new JLabel("Name");
		label8 = new JLabel("Date of Birth");
		label9 = new JLabel("Nationality");
		label10 = new JLabel("State");
		label11 = new JLabel("Mobile");
		label12 = new JLabel("Security Q.");
		label13 = new JLabel("Answer");
		label14 = new JLabel("Thank You For Banking With Us.");
		label15 = new JLabel("Amount");

		textField1 = new JTextField(16);
		textField2 = new JTextField(16);
		textField3 = new JTextField(16);
		textField4 = new JTextField(16);
		textField5 = new JTextField(16);
		textField6 = new JTextField(16);
		textField7 = new JTextField(16);
		textField8 = new JTextField(16);
		textField9 = new JTextField(16);
		

		buttonOne = new JButton("Create");
		buttonTwo = new JButton("Back");
		buttonThree = new JButton("Clear");
//
//		buttonTwo.addActionListener(this);
//		buttonThree.addActionListener(this.actionPerformed2(null));

		dob = new JDateChooser();

		dob.setDateFormatString("yyyy-mm-dd");



		icon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/LEXOCORP_LOGO.png"); // LEXOCORP
		imageLabel = new JLabel(icon); // added LEXOCORP LOGO TO ICON
		
		accType = new JComboBox(accountType);
		Nationality = new JComboBox(Nationale);
		State = new JComboBox(Statee);
		SecQ = new JComboBox(SecurityQ);
		
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");

		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		TitledBorder blackline = BorderFactory.createTitledBorder("New Account");
		blackline.setTitleColor(Color.RED);
		blackline.setTitleFont(new Font("Tahoma", Font.BOLD, 24));
//----------------------------------------------------------------------------------------------------------------------------------------------------
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(1200, 800); // size of frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(label14);
		label14.setBounds(400, 720, 400, 40);
		label14.setFont(new Font("Tahoma", Font.BOLD, 20));
		label14.setForeground(Color.RED);


		createAccountP.setBorder(blackline);

		frame.add(createAccountP);
		createAccountP.setLayout(null);
		createAccountP.setBackground(Color.WHITE);
		createAccountP.setBounds(42, 20, 1100, 700); // size of panel

		createAccountP.add(imageLabel);
		createAccountP.add(label1);
		createAccountP.add(label2);
		createAccountP.add(label3);
		createAccountP.add(label4);
		createAccountP.add(label5);
		createAccountP.add(label6);
		createAccountP.add(label7);
		createAccountP.add(label8);
		createAccountP.add(label9);
		createAccountP.add(label10);
		createAccountP.add(label11);
		createAccountP.add(label12);
		createAccountP.add(label13);
		createAccountP.add(label15);


		createAccountP.add(textField1);
		createAccountP.add(textField2);
		createAccountP.add(textField3);
		createAccountP.add(textField4);
		createAccountP.add(textField5);
		createAccountP.add(textField6);
//		createAccountP.add(textField7);
		createAccountP.add(SecQ);

		createAccountP.add(textField8);
		createAccountP.add(textField9);


		createAccountP.add(dob);

		createAccountP.add(accType);
		createAccountP.add(r1);
		createAccountP.add(r2);
		createAccountP.add(Nationality);
		createAccountP.add(State);

		createAccountP.add(buttonOne);
		createAccountP.add(buttonTwo);
		createAccountP.add(buttonThree);

		// text left side

		imageLabel.setBounds(0, -80, 300, 300); // LEXOCORP
		label1.setBounds(100, 40, 200, 200);
		label2.setBounds(100, 100, 200, 200);
		label3.setBounds(100, 160, 200, 200);
		label4.setBounds(100, 220, 200, 200);
		label5.setBounds(100, 280, 200, 200);
		label6.setBounds(100, 340, 200, 200);
		label15.setBounds(100, 400, 200, 200);

		// text right side

		label7.setBounds(600, 40, 200, 200);
		label8.setBounds(600, 100, 200, 200);
		label9.setBounds(600, 160, 200, 200);
		label10.setBounds(600, 220, 200, 200);
		label11.setBounds(600, 280, 200, 200);
		label12.setBounds(600, 340, 200, 200);


		// Center
		label13.setBounds(600, 400, 200, 200);

		// textField left side
		textField1.setBounds(200, 120, 250, 30); // Account No
		textField2.setBounds(200, 180, 250, 30); // MICR No
		textField3.setBounds(200, 240, 250, 30); // Pin
		textField1.setEditable(false);
		textField2.setEditable(false); // Generated Automatically
		textField3.setEditable(false);

		accType.setBounds(200, 300, 250, 30); // Account Type
		textField4.setBounds(200, 420, 250, 30); // Address
		r1.setBounds(200, 350, 100, 50); // Male
		r1.setBackground(Color.WHITE);
		r2.setBounds(300, 350, 150, 50); // Female
		r2.setBackground(Color.WHITE);
		textField9.setBounds(200, 480, 250, 30); // Amount
		// ------------------------------------------------------------------------------------------
		//text field right side

		textField5.setBounds(700, 120, 250, 30); // Name
		dob.setBounds(700, 180, 250, 30); // Date of Birth

		Nationality.setBounds(700, 240, 250, 30); // Nationality
		State.setBounds(700, 300, 250, 30); // State

		textField6.setBounds(700, 360, 250, 30); // Mobile
		SecQ.setBounds(700, 420, 250, 30); // Security Q
		textField8.setBounds(700, 480, 250, 30); // Answer

		buttonOne.setBounds(200, 600, 100, 30);
		buttonTwo.setBounds(500, 600, 100, 30);
		buttonThree.setBounds(800, 600, 100, 30);
		
		
		RandomAcc();
		RandomMICR();
		RandomPin();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//		String date = sdf.format(dob.getDate());
		
		
		buttonOne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = "insert into Account(Acc,Name,DOB,Pin,Acc_Type,Nationality,State,MICR_No,Gender,Mobile,Address,Sec_Q,Sec_A,Balance) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // inserting all values entered into the account
																// database
				try {
					pst =conn.prepareStatement(sql);
					pst.setString(1, textField1.getText());
					pst.setString(2, textField5.getText());
					pst.setString(3, ((JTextField) dob.getDateEditor().getUiComponent()).getText());
					pst.setString(4, textField3.getText());
					pst.setString(5, (String) accType.getSelectedItem());
					pst.setString(6, (String) Nationality.getSelectedItem());
					pst.setString(7, (String) State.getSelectedItem());
					pst.setString(8, textField2.getText());

					r1.setActionCommand("Male");
					r2.setActionCommand("Female");
					pst.setString(9, bg.getSelection().getActionCommand());
					pst.setString(10, textField6.getText());
					pst.setString(11, textField4.getText());
					pst.setString(12, (String) SecQ.getSelectedItem());
					pst.setString(13, textField8.getText());
					pst.setString(14, textField9.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Congrats\n Account has been created");
					Bal();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});



		buttonTwo.addActionListener(new ActionListener() { // back button
			@Override
			public void actionPerformed(ActionEvent arg0) { // when button two is clicked it makes the CreateAccount
															// Page not visible
				frame.setVisible(false);
				Authentication obj = new Authentication(); // Then Makes the Authentication Page visible
				obj.setVisible(true);

			}
		});

		buttonThree.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText(""); // When button three is clicked it clears all the text in the textField.
				textField6.setText("");
				textField7.setText("");
				textField8.setText("");
				textField9.setText("");



			}
		});

	}
	
	public void RandomAcc() {				//CREATED A METHOD FOR GENERATING RANDOM NUMBERS FOR ACCOUNT NUMBER
		Random ra = new Random();
		textField1.setText(""+ra.nextInt(10000 + 1));
	}



public void RandomMICR() {				//CREATED A METHOD FOR GENERATING RANDOM  NUMBERS FOR MICR NUMBER
	Random ra = new Random();
	textField2.setText(""+ra.nextInt(1000 + 1));
}

	
public void RandomPin() {				//CREATED A METHOD FOR GENERATING RANDOM NUMBERS FOR PIN NUMBER
	Random ra = new Random();
	textField3.setText(""+ra.nextInt(1000 + 1));
}

public void Bal() {
	String sql = "insert into Balances(Name,Acc,MICR_No,Balance)values (?,?,?,?)"; // Tsql used to insert into the
																					// balances table from the account
																					// table
	try {
		pst=conn.prepareStatement(sql);
		pst.setString(1, textField5.getText());
		pst.setString(2, textField1.getText());			// inserting into the balances table whatever the user enters into the text field whilst signing up
		pst.setString(3, textField2.getText());
		pst.setString(4, textField9.getText());
		pst.execute(); // to execute the sql statements
		
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
	}
}
}

	


	



