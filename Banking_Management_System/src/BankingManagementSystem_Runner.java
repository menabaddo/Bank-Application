import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BankingManagementSystem_Runner {
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {



		UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {


//				new Authentication();
				new Mypage();


			}

		});


	}

}

