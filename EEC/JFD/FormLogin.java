import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Sat Jul 03 20:36:05 CST 2021
 */



/**
 * @author somnusym
 */
public class FormLogin  {

	private void btnRegisterActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnLoginActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void tfAccountActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void rbtnSellerStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void rbtnConsumerStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		Login = new JFrame();
		btnRegister = new JButton();
		btnLogin = new JButton();
		pwPassword = new JPasswordField();
		lbPassword = new JLabel();
		lbAccount = new JLabel();
		ftfAccount = new JFormattedTextField();
		cbAutoLogin = new JCheckBox();
		cbPassword = new JCheckBox();

		//======== Login ========
		{
			Login.setTitle("\u767b\u5f55");
			Login.setResizable(false);
			Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Login.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			Container LoginContentPane = Login.getContentPane();
			LoginContentPane.setLayout(null);

			//---- btnRegister ----
			btnRegister.setText("\u6ce8\u518c\u8d26\u53f7");
			btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));
			LoginContentPane.add(btnRegister);
			btnRegister.setBounds(new Rectangle(new Point(110, 185), btnRegister.getPreferredSize()));

			//---- btnLogin ----
			btnLogin.setText("\u767b\u5f55");
			btnLogin.addActionListener(e -> btnLoginActionPerformed(e));
			LoginContentPane.add(btnLogin);
			btnLogin.setBounds(new Rectangle(new Point(290, 185), btnLogin.getPreferredSize()));
			LoginContentPane.add(pwPassword);
			pwPassword.setBounds(120, 110, 269, pwPassword.getPreferredSize().height);

			//---- lbPassword ----
			lbPassword.setText("\u5bc6\u7801\uff1a");
			LoginContentPane.add(lbPassword);
			lbPassword.setBounds(new Rectangle(new Point(75, 115), lbPassword.getPreferredSize()));

			//---- lbAccount ----
			lbAccount.setText("\u8d26\u53f7\uff1a");
			LoginContentPane.add(lbAccount);
			lbAccount.setBounds(new Rectangle(new Point(75, 70), lbAccount.getPreferredSize()));
			LoginContentPane.add(ftfAccount);
			ftfAccount.setBounds(120, 65, 270, ftfAccount.getPreferredSize().height);

			//---- cbAutoLogin ----
			cbAutoLogin.setText("\u81ea\u52a8\u767b\u5f55");
			LoginContentPane.add(cbAutoLogin);
			cbAutoLogin.setBounds(new Rectangle(new Point(110, 150), cbAutoLogin.getPreferredSize()));

			//---- cbPassword ----
			cbPassword.setText("\u8bb0\u4f4f\u5bc6\u7801");
			LoginContentPane.add(cbPassword);
			cbPassword.setBounds(290, 150, 71, 21);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < LoginContentPane.getComponentCount(); i++) {
					Rectangle bounds = LoginContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = LoginContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				LoginContentPane.setMinimumSize(preferredSize);
				LoginContentPane.setPreferredSize(preferredSize);
			}
			Login.setSize(465, 275);
			Login.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	public JFrame Login;
	private JButton btnRegister;
	private JButton btnLogin;
	private JPasswordField pwPassword;
	private JLabel lbPassword;
	private JLabel lbAccount;
	private JFormattedTextField ftfAccount;
	private JCheckBox cbAutoLogin;
	private JCheckBox cbPassword;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
