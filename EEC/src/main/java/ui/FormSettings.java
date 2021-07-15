package ui;

import EEC.Utils;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

/**
 * @author somnusym
 */
public class FormSettings extends Form {
    public FormSettings() {
        initComponents();
    }

    private void SettingsWindowDeactivated(WindowEvent e) {
        Utils.DATE_RANGE = Integer.parseInt((String) comboBox1.getSelectedItem());
        Utils.setAccountAndPassword(Utils.AC_REMEMBERED, Utils.PW_REMEMBERED);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Settings = new JFrame();
        comboBox1 = new JComboBox<>();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== Settings ========
        {
            Settings.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/ICON.jpg"))).getImage());
            Settings.setResizable(false);
            Settings.setTitle("\u8bbe\u7f6e");
            Settings.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    SettingsWindowDeactivated(e);
                }
            });
            var SettingsContentPane = Settings.getContentPane();
            SettingsContentPane.setLayout(null);

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[]{
                    "7",
                    "15",
                    "30"
            }));
            comboBox1.setFocusable(false);
            SettingsContentPane.add(comboBox1);
            comboBox1.setBounds(new Rectangle(new Point(85, 15), comboBox1.getPreferredSize()));

            //---- label1 ----
            label1.setText("\u663e\u793a\u5546\u54c1");
            SettingsContentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(30, 20), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u5929\u4e4b\u5185\u7684\u8d8b\u52bf");
            SettingsContentPane.add(label2);
            label2.setBounds(new Rectangle(new Point(170, 20), label2.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < SettingsContentPane.getComponentCount(); i++) {
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
            Settings.setSize(275, 90);
            Settings.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Settings;
    private JComboBox<String> comboBox1;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
