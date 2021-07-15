/*
 * Created by JFormDesigner on Sun Jul 04 17:34:08 CST 2021
 */

package JFD;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author somnusym
 */
public class FormSettings {
	public FormSettings() {
		initComponents();
	}

	private void SettingsWindowClosed(WindowEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		Settings = new JFrame();
		checkBox1 = new JCheckBox();
		comboBox1 = new JComboBox<>();
		label1 = new JLabel();
		label2 = new JLabel();

		//======== Settings ========
		{
			Settings.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			Settings.setResizable(false);
			Settings.setTitle("\u8bbe\u7f6e");
			Settings.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					SettingsWindowClosed(e);
				}
			});
			var SettingsContentPane = Settings.getContentPane();
			SettingsContentPane.setLayout(null);

			//---- checkBox1 ----
			checkBox1.setText("\u5546\u54c1\u5217\u8868\u663e\u793a\u7f29\u7565\u56fe");
			checkBox1.setFocusable(false);
			SettingsContentPane.add(checkBox1);
			checkBox1.setBounds(new Rectangle(new Point(25, 20), checkBox1.getPreferredSize()));

			//---- comboBox1 ----
			comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
				"7",
				"15",
				"30"
			}));
			comboBox1.setFocusable(false);
			SettingsContentPane.add(comboBox1);
			comboBox1.setBounds(new Rectangle(new Point(85, 55), comboBox1.getPreferredSize()));

			//---- label1 ----
			label1.setText("\u663e\u793a\u5546\u54c1");
			SettingsContentPane.add(label1);
			label1.setBounds(new Rectangle(new Point(30, 60), label1.getPreferredSize()));

			//---- label2 ----
			label2.setText("\u5929\u4e4b\u5185\u7684\u8d8b\u52bf");
			SettingsContentPane.add(label2);
			label2.setBounds(new Rectangle(new Point(170, 60), label2.getPreferredSize()));

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < SettingsContentPane.getComponentCount(); i++) {
					Rectangle bounds = SettingsContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = SettingsContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				SettingsContentPane.setMinimumSize(preferredSize);
				SettingsContentPane.setPreferredSize(preferredSize);
			}
			Settings.setSize(265, 130);
			Settings.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JFrame Settings;
	private JCheckBox checkBox1;
	private JComboBox<String> comboBox1;
	private JLabel label1;
	private JLabel label2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
