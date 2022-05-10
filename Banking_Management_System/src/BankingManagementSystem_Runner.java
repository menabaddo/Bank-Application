import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

public class BankingManagementSystem_Runner {
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {



//		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		UIManager.setLookAndFeel(new FlatIntelliJLaf());
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
//
//				new ForgotPass();
				new Authentication();
//				new Mypage();
//				new Loading();

			}

		});


	}

}

