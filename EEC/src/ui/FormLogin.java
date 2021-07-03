package ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;


public class FormLogin extends Form {

    public FormLogin() {
        initComponents();
    }

    private void btnRegisterActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        this.show(false);
        FormManager.FC.show(true);
    }

    private void tfAccountActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void rbtnSellerStateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void rbtnConsumerStateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Login = new JFrame();
        btnRegister = new JButton();
        btnLogin = new JButton();
        pwPassword = new JPasswordField();
        lbPassword = new JLabel();
        lbAccount = new JLabel();
        tfAccount = new JTextField();
        rbtnSeller = new JRadioButton();
        rbtnConsumer = new JRadioButton();

        //======== Login ========
        {
            Login.setTitle("\u767b\u5f55");
            Login.setResizable(false);
            Login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container LoginContentPane = Login.getContentPane();
            LoginContentPane.setLayout(null);

            //---- btnRegister ----
            btnRegister.setText("\u6ce8\u518c");
            btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));
            LoginContentPane.add(btnRegister);
            btnRegister.setBounds(new Rectangle(new Point(110, 205), btnRegister.getPreferredSize()));

            //---- btnLogin ----
            btnLogin.setText("\u767b\u5f55");
            btnLogin.addActionListener(e -> btnLoginActionPerformed(e));
            LoginContentPane.add(btnLogin);
            btnLogin.setBounds(new Rectangle(new Point(285, 205), btnLogin.getPreferredSize()));
            LoginContentPane.add(pwPassword);
            pwPassword.setBounds(120, 110, 269, pwPassword.getPreferredSize().height);

            //---- lbPassword ----
            lbPassword.setText("\u5bc6\u7801\uff1a");
            LoginContentPane.add(lbPassword);
            lbPassword.setBounds(new Rectangle(new Point(75, 115), lbPassword.getPreferredSize()));

            //---- lbAccount ----
            lbAccount.setText("\u8d26\u53f7\uff1a");
            LoginContentPane.add(lbAccount);
            lbAccount.setBounds(new Rectangle(new Point(75, 70), lbAccount.getPreferredSize()));

            //---- tfAccount ----
            tfAccount.addActionListener(e -> tfAccountActionPerformed(e));
            LoginContentPane.add(tfAccount);
            tfAccount.setBounds(120, 65, 269, tfAccount.getPreferredSize().height);

            //---- rbtnSeller ----
            rbtnSeller.setText("\u5e97\u4e3b");
            rbtnSeller.addChangeListener(e -> rbtnSellerStateChanged(e));
            LoginContentPane.add(rbtnSeller);
            rbtnSeller.setBounds(new Rectangle(new Point(125, 160), rbtnSeller.getPreferredSize()));

            //---- rbtnConsumer ----
            rbtnConsumer.setText("\u5ba2\u6237");
            rbtnConsumer.setSelected(true);
            rbtnConsumer.addChangeListener(e -> rbtnConsumerStateChanged(e));
            LoginContentPane.add(rbtnConsumer);
            rbtnConsumer.setBounds(new Rectangle(new Point(300, 160), rbtnConsumer.getPreferredSize()));

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
            Login.setSize(465, 330);
            Login.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Login;
    private JButton btnRegister;
    private JButton btnLogin;
    private JPasswordField pwPassword;
    private JLabel lbPassword;
    private JLabel lbAccount;
    private JTextField tfAccount;
    private JRadioButton rbtnSeller;
    private JRadioButton rbtnConsumer;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
