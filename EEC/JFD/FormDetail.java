package JFD;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author somnusym
 */
public class FormDetail {
	public FormDetail() {
		initComponents();
	}

	private void btnPrevPicActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnNextPicActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		Detail = new JFrame();
		lbItemPic = new JLabel();
		label2 = new JLabel();
		btnHistory = new JButton();
		spDetails = new JScrollPane();
		taDetails = new JTextArea();
		taItemName = new JTextArea();
		btnGoBuy = new JButton();

		//======== Detail ========
		{
			Detail.setResizable(false);
			Detail.setTitle("\u5546\u54c1\u8be6\u60c5");
			Detail.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			Container DetailContentPane = Detail.getContentPane();
			DetailContentPane.setLayout(null);

			//---- lbItemPic ----
			lbItemPic.setIcon(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")));
			lbItemPic.setVerticalAlignment(SwingConstants.TOP);
			DetailContentPane.add(lbItemPic);
			lbItemPic.setBounds(0, 0, 450, 450);

			//---- label2 ----
			label2.setText("\u4ef7\u683c\uff1a\u00a5700.70");
			label2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 18));
			label2.setMaximumSize(new Dimension(430, 60));
			label2.setMinimumSize(new Dimension(100, 25));
			label2.setForeground(new Color(255, 51, 51));
			DetailContentPane.add(label2);
			label2.setBounds(new Rectangle(new Point(465, 50), label2.getPreferredSize()));

			//---- btnHistory ----
			btnHistory.setText("\u67e5\u770b\u5546\u54c1\u5386\u53f2\u4ef7\u683c\u8d8b\u52bf");
			btnHistory.setFocusable(false);
			btnHistory.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 18));
			DetailContentPane.add(btnHistory);
			btnHistory.setBounds(105, 515, 240, btnHistory.getPreferredSize().height);

			//======== spDetails ========
			{
				spDetails.setBorder(null);

				//---- taDetails ----
				taDetails.setEditable(false);
				taDetails.setFocusable(false);
				taDetails.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
				spDetails.setViewportView(taDetails);
			}
			DetailContentPane.add(spDetails);
			spDetails.setBounds(460, 90, 570, 435);

			//---- taItemName ----
			taItemName.setEditable(false);
			taItemName.setFocusable(false);
			taItemName.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
			taItemName.setText("\u6b63\u5728\u52a0\u8f7d\u5546\u54c1\u540d\u79f0");
			DetailContentPane.add(taItemName);
			taItemName.setBounds(460, 0, 570, 45);

			//---- btnGoBuy ----
			btnGoBuy.setText("\u8df3\u8f6c\u8d2d\u4e70\u94fe\u63a5");
			btnGoBuy.setFocusable(false);
			btnGoBuy.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 18));
			DetailContentPane.add(btnGoBuy);
			btnGoBuy.setBounds(105, 470, 240, 33);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < DetailContentPane.getComponentCount(); i++) {
					Rectangle bounds = DetailContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = DetailContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				DetailContentPane.setMinimumSize(preferredSize);
				DetailContentPane.setPreferredSize(preferredSize);
			}
			Detail.setSize(1060, 600);
			Detail.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	public JFrame Detail;
	private JLabel lbItemPic;
	private JLabel label2;
	private JButton btnHistory;
	private JScrollPane spDetails;
	private JTextArea taDetails;
	private JTextArea taItemName;
	private JButton btnGoBuy;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
