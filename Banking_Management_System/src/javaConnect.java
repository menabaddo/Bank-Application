
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class javaConnect {
	Connection conn = null;

	public static Connection ConnecrDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com/sql4490229",
					"sql4490229",
					"zvzLcR6RIz");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bank", "root", "");
			System.out.println("Xamp Mysql connected");
			return conn;
		} catch (Exception e) {
			System.out.println("Not connected");
			JOptionPane.showMessageDialog(null, "No Internet");


		}
		return null;

	}

}
