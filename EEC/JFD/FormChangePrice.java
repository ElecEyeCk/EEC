/*
 * Created by JFormDesigner on Thu Jul 15 21:01:01 CST 2021
 */

package JFD;

import java.awt.*;
import javax.swing.*;

/**
 * @author somnusym
 */
public class FormChangePrice {
	public FormChangePrice() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		ChangePrice = new JFrame();
		label1 = new JLabel();
		textField1 = new JTextField();
		button1 = new JButton();

		//======== ChangePrice ========
		{
			ChangePrice.setResizable(false);
			var ChangePriceContentPane = ChangePrice.getContentPane();
			ChangePriceContentPane.setLayout(null);

			//---- label1 ----
			label1.setText("\u5c06\u4ef7\u683c\u4fee\u6539\u4e3a\uff1a");
			ChangePriceContentPane.add(label1);
			label1.setBounds(new Rectangle(new Point(20, 20), label1.getPreferredSize()));
			ChangePriceContentPane.add(textField1);
			textField1.setBounds(110, 15, 180, textField1.getPreferredSize().height);

			//---- button1 ----
			button1.setText("\u786e\u5b9a");
			ChangePriceContentPane.add(button1);
			button1.setBounds(new Rectangle(new Point(300, 15), button1.getPreferredSize()));

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < ChangePriceContentPane.getComponentCount(); i++) {
					Rectangle bounds = ChangePriceContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = ChangePriceContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				ChangePriceContentPane.setMinimumSize(preferredSize);
				ChangePriceContentPane.setPreferredSize(preferredSize);
			}
			ChangePrice.setSize(400, 95);
			ChangePrice.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame ChangePrice;
	private JLabel label1;
	private JTextField textField1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
