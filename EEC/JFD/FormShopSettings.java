/*
 * Created by JFormDesigner on Sun Jul 04 17:34:42 CST 2021
 */

package JFD;

import java.awt.*;
import javax.swing.*;

/**
 * @author somnusym
 */
public class FormShopSettings {
	public FormShopSettings() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ShopSettings = new JFrame();
		lbPassword3 = new JLabel();
		pwPassword3 = new JPasswordField();
		button1 = new JButton();

		//======== ShopSettings ========
		{
			ShopSettings.setTitle("\u5e97\u94fa\u8bbe\u7f6e");
			ShopSettings.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			Container ShopSettingsContentPane = ShopSettings.getContentPane();
			ShopSettingsContentPane.setLayout(null);

			//---- lbPassword3 ----
			lbPassword3.setText("\u5e97\u94fa\u94fe\u63a5\uff1a");
			lbPassword3.setFont(lbPassword3.getFont().deriveFont(lbPassword3.getFont().getStyle() | Font.BOLD, lbPassword3.getFont().getSize() + 2f));
			ShopSettingsContentPane.add(lbPassword3);
			lbPassword3.setBounds(new Rectangle(new Point(15, 15), lbPassword3.getPreferredSize()));
			ShopSettingsContentPane.add(pwPassword3);
			pwPassword3.setBounds(85, 10, 269, pwPassword3.getPreferredSize().height);

			//---- button1 ----
			button1.setText("\u786e\u5b9a");
			ShopSettingsContentPane.add(button1);
			button1.setBounds(new Rectangle(new Point(160, 55), button1.getPreferredSize()));

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < ShopSettingsContentPane.getComponentCount(); i++) {
					Rectangle bounds = ShopSettingsContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = ShopSettingsContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				ShopSettingsContentPane.setMinimumSize(preferredSize);
				ShopSettingsContentPane.setPreferredSize(preferredSize);
			}
			ShopSettings.setSize(400, 135);
			ShopSettings.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame ShopSettings;
	private JLabel lbPassword3;
	private JPasswordField pwPassword3;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
