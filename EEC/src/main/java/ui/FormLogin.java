package ui;

import DTO.User;
import EEC.EEC;
import EEC.EECError;
import EEC.Utils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;


/**
 * @author somnusym
 */
public class FormLogin extends Form {
    private int times = 0;

    public FormLogin() {
        initComponents();
        times = 1;
    }

    private void btnRegisterActionPerformed(ActionEvent e) {
        FormManager.FL.show(false);
        FormManager.FR.show(true);
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        // 调试专用
        if (ftfAccount.getText().equals("s")) {
            FormManager.FL.show(false);
            FormManager.FS.show(true);
            return;
        } else if (ftfAccount.getText().equals("c")) {
            FormManager.FL.show(false);
            FormManager.FC.show(true);
            return;
        }

        if (ftfAccount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "用户名不可为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (pwPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "密码不可为空！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int errorCode = Utils.validateLogin(ftfAccount.getText(), String.valueOf(pwPassword.getPassword()));
        if (errorCode != EECError.SUCCESS) {
            EECError.error(errorCode);
            return;
        }
        EEC.curUser = User.getUser(ftfAccount.getText());
        FormManager.FL.show(false);
        if (EEC.curUser.getShop() == null || EEC.curUser.getShop().equals("")) {
            FormManager.FC.show(true);
        } else {
            FormManager.FS.show(true);
        }
        Utils.REMEMBER_PASSWORD = cbPassword.isSelected();
        Utils.AUTO_LOGIN = cbAutoLogin.isSelected();
        if (Utils.REMEMBER_PASSWORD) {
            Utils.setAccountAndPassword(ftfAccount.getText(), String.valueOf(pwPassword.getPassword()));
        }
        else {
            Utils.setAccountAndPassword(Utils.AC_REMEMBERED, Utils.PW_REMEMBERED);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Login = new JFrame();
        btnRegister = new JButton();
        btnLogin = new JButton();
        pwPassword = new JPasswordField();
        lbPassword = new JLabel();
        lbAccount = new JLabel();
        ftfAccount = new JFormattedTextField();
        cbAutoLogin = new JCheckBox();
        cbPassword = new JCheckBox();

        //======== Login ========
        {
            Login.setTitle("\u767b\u5f55");
            Login.setResizable(false);
            Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Login.addWindowListener(new WindowAdapter() {
                @Override
                public void windowActivated(WindowEvent e) {
                    if (times != 1)
                        return;
                    times++;
                    cbPassword.setSelected(Utils.REMEMBER_PASSWORD);
                    cbAutoLogin.setSelected(Utils.AUTO_LOGIN);
                    if (Utils.REMEMBER_PASSWORD) {
                        ftfAccount.setText(Utils.AC_REMEMBERED);
                        pwPassword.setText(Utils.PW_REMEMBERED);
                    }
                    if (Utils.AUTO_LOGIN && Utils.USER_REMEMBERED != null) {
                        EEC.curUser = Utils.USER_REMEMBERED;
                        FormManager.FL.show(false);
                        if (EEC.curUser.getShop() == null || EEC.curUser.getShop().equals("")) {
                            FormManager.FC.show(true);
                        } else {
                            FormManager.FS.show(true);
                        }
                    }
                }
            });
            Login.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/ICON.jpg"))).getImage());
            Container LoginContentPane = Login.getContentPane();
            LoginContentPane.setLayout(null);

            //---- btnRegister ----
            btnRegister.setText("\u6ce8\u518c\u8d26\u53f7");
            btnRegister.addActionListener(this::btnRegisterActionPerformed);
            LoginContentPane.add(btnRegister);
            btnRegister.setBounds(new Rectangle(new Point(110, 185), btnRegister.getPreferredSize()));

            //---- btnLogin ----
            btnLogin.setText("\u767b\u5f55");
            btnLogin.addActionListener(this::btnLoginActionPerformed);
            LoginContentPane.add(btnLogin);
            btnLogin.setBounds(new Rectangle(new Point(290, 185), btnLogin.getPreferredSize()));
            LoginContentPane.add(pwPassword);
            pwPassword.setBounds(120, 90, 269, pwPassword.getPreferredSize().height);

            //---- lbPassword ----
            lbPassword.setText("\u5bc6\u7801\uff1a");
            LoginContentPane.add(lbPassword);
            lbPassword.setBounds(new Rectangle(new Point(75, 95), lbPassword.getPreferredSize()));

            //---- lbAccount ----
            lbAccount.setText("\u8d26\u53f7\uff1a");
            LoginContentPane.add(lbAccount);
            lbAccount.setBounds(new Rectangle(new Point(75, 50), lbAccount.getPreferredSize()));
            LoginContentPane.add(ftfAccount);
            ftfAccount.setBounds(120, 45, 270, ftfAccount.getPreferredSize().height);

            //---- cbAutoLogin ----
            cbAutoLogin.setText("\u81ea\u52a8\u767b\u5f55");
            cbAutoLogin.setFocusable(false);
            LoginContentPane.add(cbAutoLogin);
            cbAutoLogin.setBounds(new Rectangle(new Point(110, 145), cbAutoLogin.getPreferredSize()));

            //---- cbPassword ----
            cbPassword.setText("\u8bb0\u4f4f\u5bc6\u7801");
            cbPassword.setFocusable(false);
            cbAutoLogin.addActionListener(this::cbAutoLoginActionPerformed);
            cbPassword.addActionListener(this::cbPasswordActionPerformed);
            LoginContentPane.add(cbPassword);
            cbPassword.setBounds(290, 145, 71, 21);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < LoginContentPane.getComponentCount(); i++) {
                    Rectangle bounds = LoginContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = LoginContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                LoginContentPane.setMinimumSize(preferredSize);
                LoginContentPane.setPreferredSize(preferredSize);
            }
            Login.setSize(465, 275);
            Login.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void cbPasswordActionPerformed(ActionEvent actionEvent) {
        if (!cbPassword.isSelected())
            cbAutoLogin.setSelected(false);
    }

    private void cbAutoLoginActionPerformed(ActionEvent actionEvent) {
        if (cbAutoLogin.isSelected())
            cbPassword.setSelected(true);
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Login;
    private JButton btnRegister;
    private JButton btnLogin;
    private JPasswordField pwPassword;
    private JLabel lbPassword;
    private JLabel lbAccount;
    private JFormattedTextField ftfAccount;
    private JCheckBox cbAutoLogin;
    private JCheckBox cbPassword;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
