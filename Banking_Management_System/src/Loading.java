import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

public class Loading extends JFrame implements Runnable {
	
	java.sql.Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	JFrame frame;
	JPanel panel;
	ImageIcon icon;
	ImageIcon icon2;
	JLabel imageLabel;
	JLabel imageLabel2;
	JProgressBar bar; // created Jprogress bar
	JLabel label1;
	JLabel label2;
	JLabel label3;
	int s = 0;
	Thread th;
	
	


	Loading() {
		th = new Thread(this);
		conn = javaConnect.ConnecrDb();
		frame = new JFrame("LEXOCORP - Progress");
		panel = new JPanel();

		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(450, 660); // size of frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel.setLayout(null);
//		panel.setBackground(Color.yellow);
		panel.setBounds(20, 40, 400, 500);

		icon = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/LEXOCORP_LOGO.png"); // LEXOCORP
		imageLabel = new JLabel(icon); // added LEXOCORP LOGO TO ICON

		icon2 = new ImageIcon("C:/Users/mmm/eclipse-workspace/Banking_Management_System/src/IMG/Loader.png"); // LEXOCORP
		imageLabel2 = new JLabel(icon2); // added LEXOCORP LOGO TO ICON

		imageLabel.setBounds(55, -80, 300, 300); // LEXOCORP


		TitledBorder blackline = BorderFactory.createTitledBorder("My Page");
		blackline.setTitleColor(Color.RED);
		blackline.setTitleFont(new Font("Tahoma", Font.BOLD, 24));

		panel.setBorder(blackline);

		bar = new JProgressBar(0, 100);
		bar.setBounds(45, 150, 320, 50);
		bar.setStringPainted(true);
		bar.setForeground(Color.red);

		label1 = new JLabel("Redirecting..."); // redirecting label.
		label1.setBounds(170, 205, 100, 20);
		label2 = new JLabel("This software is verified as a secured and trusted site");
		label2.setBounds(42, 480, 400, 200);
		label2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label3 = new JLabel("All information sent or received is encrypted using 256-bit encryption");
		label3.setBounds(25, 500, 400, 200);
		imageLabel2.setBounds(52, 160, 300, 300); // loading icon

		frame.add(panel);
		frame.add(label2);
		frame.add(label3);
		panel.add(imageLabel);
		panel.add(imageLabel2);
		panel.add(bar);
		panel.add(label1);
		
		

	}

	public void setUpLoading() {
		frame.setVisible(true);
		th.start();
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i <= 200; i++) { // For the loading Page
				s = s + 1;
				int m = bar.getMaximum();
				int v = bar.getValue();
				if (v < m) {
					bar.setValue(bar.getValue() + 1);
					;
				} else {
					i = 201; // once the thread is complete it takes us into the Home Page
					frame.setVisible(false);
					Mypage ob = new Mypage();
					ob.setVisible(true);

				}

				Thread.sleep(50);

			}
		} catch (Exception e) {

		}

	}

}
