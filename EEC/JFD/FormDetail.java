/*
 * Created by JFormDesigner on Sat Jul 03 21:58:14 CST 2021
 */

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
		label1 = new JLabel();
		label2 = new JLabel();
		btnPrevPic = new JButton();
		btnNextPic = new JButton();

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
			lbItemPic.setBounds(0, 0, 350, 350);

			//---- label1 ----
			label1.setText("\u7535\u773c\u67e5\u5546\u54c1\u540d\u79f0");
			label1.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 21));
			label1.setMaximumSize(new Dimension(430, 60));
			label1.setMinimumSize(new Dimension(100, 25));
			label1.setForeground(Color.darkGray);
			DetailContentPane.add(label1);
			label1.setBounds(new Rectangle(new Point(360, 10), label1.getPreferredSize()));

			//---- label2 ----
			label2.setText("\u4ef7\u683c\uff1a\u00a5700.70");
			label2.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 18));
			label2.setMaximumSize(new Dimension(430, 60));
			label2.setMinimumSize(new Dimension(100, 25));
			label2.setForeground(new Color(255, 51, 51));
			DetailContentPane.add(label2);
			label2.setBounds(new Rectangle(new Point(360, 75), label2.getPreferredSize()));

			//---- btnPrevPic ----
			btnPrevPic.setText("<");
			btnPrevPic.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
			btnPrevPic.setFocusable(false);
			btnPrevPic.addActionListener(e -> btnPrevPicActionPerformed(e));
			DetailContentPane.add(btnPrevPic);
			btnPrevPic.setBounds(new Rectangle(new Point(50, 350), btnPrevPic.getPreferredSize()));

			//---- btnNextPic ----
			btnNextPic.setText(">");
			btnNextPic.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
			btnNextPic.setFocusable(false);
			btnNextPic.addActionListener(e -> btnNextPicActionPerformed(e));
			DetailContentPane.add(btnNextPic);
			btnNextPic.setBounds(250, 350, 49, 49);

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
			Detail.setSize(960, 600);
			Detail.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	public JFrame Detail;
	private JLabel lbItemPic;
	private JLabel label1;
	private JLabel label2;
	private JButton btnPrevPic;
	private JButton btnNextPic;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
