/*
 * Created by JFormDesigner on Sun Jul 04 17:29:10 CST 2021
 */

package JFD;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author somnusym
 */
public class FormRegister  {

	private void btnRegisterActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void ftfAccountFocusLost(FocusEvent e) {
		// TODO add your code here
	}

	private void pwPasswordFocusLost(FocusEvent e) {
		// TODO add your code here
	}

	private void pwPassword2FocusLost(FocusEvent e) {
		// TODO add your code here
	}

	private void cbAccountActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void cbPasswordActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void checkBox3ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void tftShopFocusLost(FocusEvent e) {
		// TODO add your code here
	}

	private void cbShopActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void RegisterWindowGainedFocus(WindowEvent e) {
		// TODO add your code here
	}

	private void ftfAccountKeyTyped(KeyEvent e) {
		// TODO add your code here
	}

	private void pwPasswordKeyTyped(KeyEvent e) {
		// TODO add your code here
	}

	private void pwPassword2KeyTyped(KeyEvent e) {
		// TODO add your code here
	}

	private void tftShopKeyTyped(KeyEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		Register = new JFrame();
		lbAccount = new JLabel();
		ftfAccount = new JFormattedTextField();
		lbPassword = new JLabel();
		pwPassword = new JPasswordField();
		lbAccountTips = new JLabel();
		lbPasswordTips = new JLabel();
		btnRegister = new JButton();
		lbPassword2 = new JLabel();
		pwPassword2 = new JPasswordField();
		lbPassword2Tips = new JLabel();
		cbAccount = new JCheckBox();
		cbPassword = new JCheckBox();
		cbPassword2 = new JCheckBox();
		lbShop = new JLabel();
		tftShop = new JFormattedTextField();
		lbShopTips = new JLabel();
		cbShop = new JCheckBox();

		//======== Register ========
		{
			Register.setTitle("\u6ce8\u518c");
			Register.setResizable(false);
			Register.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			Register.addWindowFocusListener(new WindowAdapter() {
				@Override
				public void windowGainedFocus(WindowEvent e) {
					RegisterWindowGainedFocus(e);
				}
			});
			Container RegisterContentPane = Register.getContentPane();
			RegisterContentPane.setLayout(null);

			//---- lbAccount ----
			lbAccount.setText("\u7528\u6237\u540d\uff1a");
			lbAccount.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
			RegisterContentPane.add(lbAccount);
			lbAccount.setBounds(new Rectangle(new Point(20, 40), lbAccount.getPreferredSize()));

			//---- ftfAccount ----
			ftfAccount.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					ftfAccountFocusLost(e);
				}
			});
			ftfAccount.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					ftfAccountKeyTyped(e);
				}
			});
			RegisterContentPane.add(ftfAccount);
			ftfAccount.setBounds(85, 35, 270, ftfAccount.getPreferredSize().height);

			//---- lbPassword ----
			lbPassword.setText("\u5bc6\u7801\uff1a");
			lbPassword.setFont(lbPassword.getFont().deriveFont(lbPassword.getFont().getStyle() | Font.BOLD, lbPassword.getFont().getSize() + 2f));
			RegisterContentPane.add(lbPassword);
			lbPassword.setBounds(new Rectangle(new Point(30, 110), lbPassword.getPreferredSize()));

			//---- pwPassword ----
			pwPassword.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					pwPasswordFocusLost(e);
				}
			});
			pwPassword.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					pwPasswordKeyTyped(e);
				}
			});
			RegisterContentPane.add(pwPassword);
			pwPassword.setBounds(85, 105, 269, pwPassword.getPreferredSize().height);

			//---- lbAccountTips ----
			lbAccountTips.setText("\u7528\u6237\u540d\u7531\u82f1\u6587\u3001\u6570\u5b57\u548c_\u7ec4\u6210\uff0c\u957f\u5ea6\u4e0d\u8d85\u8fc725\u5b57\u7b26\u3002");
			RegisterContentPane.add(lbAccountTips);
			lbAccountTips.setBounds(new Rectangle(new Point(85, 70), lbAccountTips.getPreferredSize()));

			//---- lbPasswordTips ----
			lbPasswordTips.setText("\u5bc6\u7801\u7531\u82f1\u6587\u3001\u6570\u5b57\u548c\u7279\u6b8a\u7b26\u53f7\u7ec4\u6210\uff0c\u957f\u5ea6\u4e0d\u8d85\u8fc725\u5b57\u7b26\u3002");
			RegisterContentPane.add(lbPasswordTips);
			lbPasswordTips.setBounds(new Rectangle(new Point(85, 140), lbPasswordTips.getPreferredSize()));

			//---- btnRegister ----
			btnRegister.setText("\u6ce8\u518c");
			btnRegister.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 15));
			btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));
			RegisterContentPane.add(btnRegister);
			btnRegister.setBounds(165, 320, btnRegister.getPreferredSize().width, 36);

			//---- lbPassword2 ----
			lbPassword2.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
			lbPassword2.setFont(lbPassword2.getFont().deriveFont(lbPassword2.getFont().getStyle() | Font.BOLD, lbPassword2.getFont().getSize() + 2f));
			RegisterContentPane.add(lbPassword2);
			lbPassword2.setBounds(new Rectangle(new Point(15, 185), lbPassword2.getPreferredSize()));

			//---- pwPassword2 ----
			pwPassword2.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					pwPassword2FocusLost(e);
				}
			});
			pwPassword2.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					pwPassword2KeyTyped(e);
				}
			});
			RegisterContentPane.add(pwPassword2);
			pwPassword2.setBounds(85, 180, 269, 27);

			//---- lbPassword2Tips ----
			lbPassword2Tips.setText("\u8bf7\u518d\u4e00\u6b21\u8f93\u5165\u5bc6\u7801\u4ee5\u786e\u8ba4\u3002");
			RegisterContentPane.add(lbPassword2Tips);
			lbPassword2Tips.setBounds(85, 215, 240, 17);

			//---- cbAccount ----
			cbAccount.addActionListener(e -> cbAccountActionPerformed(e));
			RegisterContentPane.add(cbAccount);
			cbAccount.setBounds(new Rectangle(new Point(360, 40), cbAccount.getPreferredSize()));

			//---- cbPassword ----
			cbPassword.addActionListener(e -> cbPasswordActionPerformed(e));
			RegisterContentPane.add(cbPassword);
			cbPassword.setBounds(360, 110, 19, 19);

			//---- cbPassword2 ----
			cbPassword2.addActionListener(e -> checkBox3ActionPerformed(e));
			RegisterContentPane.add(cbPassword2);
			cbPassword2.setBounds(360, 185, 19, 19);

			//---- lbShop ----
			lbShop.setText("\u5e97\u94fa\u94fe\u63a5\uff1a");
			lbShop.setFont(lbShop.getFont().deriveFont(lbShop.getFont().getStyle() | Font.BOLD, lbShop.getFont().getSize() + 2f));
			RegisterContentPane.add(lbShop);
			lbShop.setBounds(15, 255, 72, 19);

			//---- tftShop ----
			tftShop.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					tftShopFocusLost(e);
				}
			});
			tftShop.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					tftShopKeyTyped(e);
				}
			});
			RegisterContentPane.add(tftShop);
			tftShop.setBounds(85, 250, 269, 27);

			//---- lbShopTips ----
			lbShopTips.setText("\uff08\u53ef\u9009\uff09\u8bf7\u8f93\u5165\u60a8\u7684\u5e97\u94fa\u94fe\u63a5\u3002");
			RegisterContentPane.add(lbShopTips);
			lbShopTips.setBounds(85, 285, 240, 17);

			//---- cbShop ----
			cbShop.setSelected(true);
			cbShop.addActionListener(e -> cbShopActionPerformed(e));
			RegisterContentPane.add(cbShop);
			cbShop.setBounds(360, 255, 19, 19);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < RegisterContentPane.getComponentCount(); i++) {
					Rectangle bounds = RegisterContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = RegisterContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				RegisterContentPane.setMinimumSize(preferredSize);
				RegisterContentPane.setPreferredSize(preferredSize);
			}
			Register.setSize(405, 435);
			Register.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame Register;
	private JLabel lbAccount;
	private JFormattedTextField ftfAccount;
	private JLabel lbPassword;
	private JPasswordField pwPassword;
	private JLabel lbAccountTips;
	private JLabel lbPasswordTips;
	private JButton btnRegister;
	private JLabel lbPassword2;
	private JPasswordField pwPassword2;
	private JLabel lbPassword2Tips;
	private JCheckBox cbAccount;
	private JCheckBox cbPassword;
	private JCheckBox cbPassword2;
	private JLabel lbShop;
	private JFormattedTextField tftShop;
	private JLabel lbShopTips;
	private JCheckBox cbShop;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
