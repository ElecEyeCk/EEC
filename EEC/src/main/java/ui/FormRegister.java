package ui;

import EEC.EECError;
import EEC.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * @author somnusym
 */
public class FormRegister extends Form {
    private final String allCharactersWith_ = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
    private final String allCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public FormRegister() {
        initComponents();
    }

    private void check() {
        // 用户名检查
        if (ftfAccount.getText().length() == 0)
            cbAccount.setSelected(false);
        else
            cbAccount.setSelected(Pattern.matches("^[0-9a-zA-Z_]{1,25}$", ftfAccount.getText()));

        // 店铺链接检查，可空
        if (ftfShop.getText().length() == 0)
            cbShop.setSelected(true);
        else if (!ftfShop.getText().contains("."))
            cbShop.setSelected(false);
        else {
            cbShop.setSelected(Pattern.matches("^[0-9a-zA-Z]{1,255}$", ftfShop.getText()));
        }

        // 密码检查
        cbPassword.setSelected(String.valueOf(pwPassword.getPassword()).length() >= 6);

        // 确认密码检查
        cbPassword2.setSelected(cbPassword.isSelected() && String.valueOf(pwPassword2.getPassword()).equals(String.valueOf(pwPassword.getPassword())));
    }

    private void btnRegisterActionPerformed(ActionEvent e) {
        if (cbAccount.isSelected() && cbPassword.isSelected() && cbPassword2.isSelected() && cbShop.isSelected()) {
            int errorCode = Utils.validateRegister(ftfAccount.getText());
            if (errorCode != EECError.SUCCESS) {
                EECError.error(errorCode);
            } else {
                if (Utils.register(ftfAccount.getText(), String.valueOf(pwPassword.getPassword()), ftfShop.getText()) == EECError.SUCCESS) {
                    JOptionPane.showMessageDialog(null, "注册成功！");
                    FormManager.FR.show(false);
                    FormManager.FL.show(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "注册失败，请检查注册信息！");
        }
    }

    private void ftfAccountFocusLost(FocusEvent e) {
        check();
    }

    private void pwPasswordFocusLost(FocusEvent e) {
        check();
    }

    private void pwPassword2FocusLost(FocusEvent e) {
        check();
    }

    private void cbAccountActionPerformed(ActionEvent e) {
        cbAccount.setSelected(!cbAccount.isSelected());
    }

    private void cbPasswordActionPerformed(ActionEvent e) {
        cbPassword.setSelected(!cbPassword.isSelected());
    }

    private void cbPassword2ActionPerformed(ActionEvent e) {
        cbPassword2.setSelected(!cbPassword2.isSelected());
    }

    private void ftfShopFocusLost(FocusEvent e) {
        check();
    }

    private void cbShopActionPerformed(ActionEvent e) {
        cbShop.setSelected(!cbShop.isSelected());
    }

    private void RegisterWindowGainedFocus(WindowEvent e) {
        check();
    }

    private void ftfAccountKeyTyped(KeyEvent e) {
        String s = ftfAccount.getText();
        if (s.length() >= 25)
            e.consume();
        if (!allCharactersWith_.contains(String.valueOf(e.getKeyChar())))
            e.consume();
    }

    private void ftfShopKeyTyped(KeyEvent e) {
        String s = ftfShop.getText();
        if (!allCharacters.contains(String.valueOf(e.getKeyChar())))
            e.consume();
    }

    private void pwPasswordKeyTyped(KeyEvent e) {
        String s = String.valueOf(pwPassword.getPassword());
        if (s.length() >= 20)
            e.consume();
    }

    private void pwPassword2KeyTyped(KeyEvent e) {
        String s = String.valueOf(pwPassword2.getPassword());
        if (s.length() >= 20)
            e.consume();
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
        ftfShop = new JFormattedTextField();
        lbShopTips = new JLabel();
        cbShop = new JCheckBox();

        //======== Register ========
        {
            Register.setTitle("\u6ce8\u518c");
            Register.setResizable(false);
            Register.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    FormManager.FR.show(false);
                    FormManager.FL.show(true);
                }
            });
            Register.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/ICON.jpg"))).getImage());
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
            lbAccountTips.setText("用户名由英文、数字和_组成，长度不超过25字符。");
            RegisterContentPane.add(lbAccountTips);
            lbAccountTips.setBounds(new Rectangle(new Point(85, 70), lbAccountTips.getPreferredSize()));

            //---- lbPasswordTips ----
            lbPasswordTips.setText("长度不超过20字符且不少于6字符。");
            RegisterContentPane.add(lbPasswordTips);
            lbPasswordTips.setBounds(new Rectangle(new Point(85, 140), lbPasswordTips.getPreferredSize()));

            //---- btnRegister ----
            btnRegister.setText("\u6ce8\u518c");
            btnRegister.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 15));
            btnRegister.addActionListener(this::btnRegisterActionPerformed);
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
            cbAccount.addActionListener(this::cbAccountActionPerformed);
            RegisterContentPane.add(cbAccount);
            cbAccount.setFocusable(false);
            cbAccount.setBounds(new Rectangle(new Point(360, 40), cbAccount.getPreferredSize()));

            //---- cbPassword ----
            cbPassword.addActionListener(this::cbPasswordActionPerformed);
            RegisterContentPane.add(cbPassword);
            cbPassword.setFocusable(false);
            cbPassword.setBounds(360, 110, 19, 19);

            //---- checkBox3 ----
            cbPassword2.addActionListener(this::cbPassword2ActionPerformed);
            RegisterContentPane.add(cbPassword2);
            cbPassword2.setFocusable(false);
            cbPassword2.setBounds(360, 185, 19, 19);

            //---- lbShop ----
            lbShop.setText("\u5e97\u94fa\u94fe\u63a5\uff1a");
            lbShop.setFont(lbShop.getFont().deriveFont(lbShop.getFont().getStyle() | Font.BOLD, lbShop.getFont().getSize() + 2f));
            RegisterContentPane.add(lbShop);
            lbShop.setBounds(15, 255, 72, 19);

            //---- tftShop ----
            ftfShop.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    ftfShopFocusLost(e);
                }
            });
            ftfShop.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    ftfShopKeyTyped(e);
                }
            });
            RegisterContentPane.add(ftfShop);
            ftfShop.setBounds(85, 250, 269, 27);

            //---- lbShopTips ----
            lbShopTips.setText("（可选）请输入您的店铺链接，以https://开头。");
            RegisterContentPane.add(lbShopTips);
            lbShopTips.setBounds(new Rectangle(new Point(85, 285), lbShopTips.getPreferredSize()));

            //---- cbShop ----
            cbShop.setSelected(true);
            cbShop.addActionListener(this::cbShopActionPerformed);
            RegisterContentPane.add(cbShop);
            cbShop.setFocusable(false);
            cbShop.setBounds(360, 255, 19, 19);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < RegisterContentPane.getComponentCount(); i++) {
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
    public JFrame Register;
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
    private JFormattedTextField ftfShop;
    private JLabel lbShopTips;
    private JCheckBox cbShop;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
