package ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author somnusym
 */
public class FormSettings extends Form {
    public FormSettings() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Settings = new JFrame();

        //======== Settings ========
        {
            Settings.setIconImage(new ImageIcon(getClass().getResource("/jpg/ICON.jpg")).getImage());
            Container SettingsContentPane = Settings.getContentPane();
            SettingsContentPane.setLayout(null);

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
            Settings.pack();
            Settings.setLocationRelativeTo(Settings.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Settings;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
