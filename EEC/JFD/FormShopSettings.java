/*
 * Created by JFormDesigner on Sun Jul 04 17:34:42 CST 2021
 */

package JFD;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author somnusym
 */
public class FormShopSettings {
	public FormShopSettings() {
		initComponents();
	}

	private void btnOKActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ShopSettings = new JFrame();
		lbShopLink = new JLabel();
		ftfShopLink = new JFormattedTextField();
		btnOK = new JButton();

		//======== ShopSettings ========
		{
			ShopSettings.setTitle("\u5e97\u94fa\u8bbe\u7f6e");
			ShopSettings.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			ShopSettings.setResizable(false);
			Container ShopSettingsContentPane = ShopSettings.getContentPane();
			ShopSettingsContentPane.setLayout(null);

			//---- lbShopLink ----
			lbShopLink.setText("\u5e97\u94fa\u94fe\u63a5\uff1a");
			lbShopLink.setFont(lbShopLink.getFont().deriveFont(lbShopLink.getFont().getStyle() | Font.BOLD, lbShopLink.getFont().getSize() + 2f));
			ShopSettingsContentPane.add(lbShopLink);
			lbShopLink.setBounds(new Rectangle(new Point(15, 15), lbShopLink.getPreferredSize()));
			ShopSettingsContentPane.add(ftfShopLink);
			ftfShopLink.setBounds(85, 10, 290, ftfShopLink.getPreferredSize().height);

			//---- btnOK ----
			btnOK.setText("\u786e\u5b9a");
			btnOK.addActionListener(e -> btnOKActionPerformed(e));
			ShopSettingsContentPane.add(btnOK);
			btnOK.setBounds(new Rectangle(new Point(160, 55), btnOK.getPreferredSize()));

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
	private JLabel lbShopLink;
	private JFormattedTextField ftfShopLink;
	private JButton btnOK;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
