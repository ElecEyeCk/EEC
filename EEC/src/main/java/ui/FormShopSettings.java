package ui;

import DTO.Item;
import DTO.User;
import EEC.EEC;
import Utils.EECError;
import Utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * @author somnusym
 */
public class FormShopSettings extends Form {
    public FormShopSettings() {
        initComponents();
    }

    private void btnOKActionPerformed(ActionEvent e) {
        if (EEC.curUser.getShop().equals("") || EEC.curUser.getShop().equals("null")) {
            if (!ftfShopLink.getText().equals("")) {
                if (Utils.updateShop(Item.getShopName(ftfShopLink.getText()), EEC.curUser.getID()) == EECError.SUCCESS) {
                    EEC.curUser = User.getUser(EEC.curUser.getID());
                    FormManager.FS.show(true);
                    FormManager.FC.show(false);
                    ftfShopLink.setText("");
                    FormManager.FSSe.show(false);
                } else {
                    JOptionPane.showMessageDialog(null, "设置商铺失败！");
                }

            } else {
                JOptionPane.showMessageDialog(null, "请输入正确的认证码！");
            }
        } else {
            if (ftfShopLink.getText().equals("")) {
                if (JOptionPane.showConfirmDialog(null, "您输入的认证码为空，继续操作将使您变为普通用户，是否继续？", "提示", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    if (Utils.updateShop(Item.getShopName(ftfShopLink.getText()), EEC.curUser.getID()) == EECError.SUCCESS) {
                        EEC.curUser = User.getUser(EEC.curUser.getID());
                        FormManager.FC.show(true);
                        FormManager.FS.show(false);
                        ftfShopLink.setText("");
                        FormManager.FSSe.show(false);
                        FormManager.FS.showShopItems(EEC.curUser.getShop(), null);
                    } else {
                        JOptionPane.showMessageDialog(null, "设置商铺失败！");
                    }
                }
            } else {
                if (Utils.validateShop(ftfShopLink.getText()) == EECError.SUCCESS) {
                    if (Utils.updateShop(Item.getShopName(ftfShopLink.getText()), EEC.curUser.getID()) == EECError.SUCCESS) {
                        EEC.curUser = User.getUser(EEC.curUser.getID());
                        FormManager.FC.show(false);
                        FormManager.FS.show(true);
                        ftfShopLink.setText("");
                        FormManager.FSSe.show(false);
                        FormManager.FS.showShopItems(EEC.curUser.getShop(), null);
                    } else {
                        JOptionPane.showMessageDialog(null, "设置商铺失败！");
                    }
                } else {
                    EECError.error(EECError.WRONG_CODE);
                }
            }
        }

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
            ShopSettings.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/ICON.jpg"))).getImage());
            ShopSettings.setResizable(false);
            Container ShopSettingsContentPane = ShopSettings.getContentPane();
            ShopSettingsContentPane.setLayout(null);

            //---- lbShopLink ----
            lbShopLink.setText("店铺认证码：");
            lbShopLink.setFont(lbShopLink.getFont().deriveFont(lbShopLink.getFont().getStyle() | Font.BOLD, lbShopLink.getFont().getSize() + 2f));
            ShopSettingsContentPane.add(lbShopLink);
            lbShopLink.setBounds(new Rectangle(new Point(15, 15), lbShopLink.getPreferredSize()));
            ShopSettingsContentPane.add(ftfShopLink);
            ftfShopLink.setBounds(105, 10, 270, ftfShopLink.getPreferredSize().height);

            //---- btnOK ----
            btnOK.setText("\u786e\u5b9a");
            btnOK.addActionListener(this::btnOKActionPerformed);
            ShopSettingsContentPane.add(btnOK);
            btnOK.setBounds(new Rectangle(new Point(160, 55), btnOK.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < ShopSettingsContentPane.getComponentCount(); i++) {
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
    public JFrame ShopSettings;
    private JLabel lbShopLink;
    private JFormattedTextField ftfShopLink;
    private JButton btnOK;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
