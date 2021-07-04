package ui;

import EEC.EECError;
import EEC.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author somnusym
 */
public class FormRegister extends Form {

    public FormRegister() {
        initComponents();
    }

    private void btnRegisterActionPerformed(ActionEvent e) {
        int errorCode = Utils.validateRegister(ftfAccount.getText());
        if (errorCode != EECError.SUCCESS) {
            EECError.errorTips(errorCode);
        }
        else {
            FormManager.FR.show(false);
            FormManager.FL.show(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Register = new JFrame();
        lbAccount = new JLabel();
        ftfAccount = new JFormattedTextField();
        lbPassword = new JLabel();
        pwPassword = new JPasswordField();
        label1 = new JLabel();
        label2 = new JLabel();
        btnRegister = new JButton();
        lbPassword2 = new JLabel();
        pwPassword2 = new JPasswordField();
        label3 = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        lbPassword3 = new JLabel();
        pwPassword3 = new JPasswordField();
        label4 = new JLabel();
        checkBox4 = new JCheckBox();

        //======== Register ========
        {
            Register.setTitle("\u6ce8\u518c");
            Register.setResizable(false);
            Register.setIconImage(new ImageIcon(getClass().getResource("/jpg/ICON.jpg")).getImage());
            Container RegisterContentPane = Register.getContentPane();
            RegisterContentPane.setLayout(null);

            //---- lbAccount ----
            lbAccount.setText("\u7528\u6237\u540d\uff1a");
            lbAccount.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
            RegisterContentPane.add(lbAccount);
            lbAccount.setBounds(new Rectangle(new Point(20, 40), lbAccount.getPreferredSize()));
            RegisterContentPane.add(ftfAccount);
            ftfAccount.setBounds(85, 35, 270, ftfAccount.getPreferredSize().height);

            //---- lbPassword ----
            lbPassword.setText("\u5bc6\u7801\uff1a");
            lbPassword.setFont(lbPassword.getFont().deriveFont(lbPassword.getFont().getStyle() | Font.BOLD, lbPassword.getFont().getSize() + 2f));
            RegisterContentPane.add(lbPassword);
            lbPassword.setBounds(new Rectangle(new Point(30, 110), lbPassword.getPreferredSize()));
            RegisterContentPane.add(pwPassword);
            pwPassword.setBounds(85, 105, 269, pwPassword.getPreferredSize().height);

            //---- label1 ----
            label1.setText("\u7528\u6237\u540d\u53ea\u80fd\u7531\u82f1\u6587\u3001\u6c49\u5b57\u548c\u6570\u5b57\u7ec4\u6210\u3002");
            RegisterContentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(85, 70), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("\u5bc6\u7801\u53ea\u80fd\u7531\u82f1\u6587\u3001\u6570\u5b57\u548c\u4e00\u4e9b\u7279\u6b8a\u7b26\u53f7\u7ec4\u6210\u3002");
            RegisterContentPane.add(label2);
            label2.setBounds(new Rectangle(new Point(85, 140), label2.getPreferredSize()));

            //---- btnRegister ----
            btnRegister.setText("\u6ce8\u518c");
            btnRegister.setFont(new Font("\u9ed1\u4f53", Font.PLAIN, 15));
            btnRegister.addActionListener(e -> btnRegisterActionPerformed(e));
            RegisterContentPane.add(btnRegister);
            btnRegister.setBounds(165, 320, btnRegister.getPreferredSize().width, 36);

            //---- lbPassword2 ----
            lbPassword2.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
            lbPassword2.setFont(lbPassword2.getFont().deriveFont(lbPassword2.getFont().getStyle() | Font.BOLD, lbPassword2.getFont().getSize() + 2f));
            RegisterContentPane.add(lbPassword2);
            lbPassword2.setBounds(new Rectangle(new Point(15, 185), lbPassword2.getPreferredSize()));
            RegisterContentPane.add(pwPassword2);
            pwPassword2.setBounds(85, 180, 269, 27);

            //---- label3 ----
            label3.setText("\u8bf7\u518d\u4e00\u6b21\u8f93\u5165\u5bc6\u7801\u4ee5\u786e\u8ba4\u3002");
            RegisterContentPane.add(label3);
            label3.setBounds(85, 215, 240, 17);

            //---- checkBox1 ----
            checkBox1.setEnabled(false);
            RegisterContentPane.add(checkBox1);
            checkBox1.setBounds(new Rectangle(new Point(360, 40), checkBox1.getPreferredSize()));

            //---- checkBox2 ----
            checkBox2.setEnabled(false);
            RegisterContentPane.add(checkBox2);
            checkBox2.setBounds(360, 110, 19, 19);

            //---- checkBox3 ----
            checkBox3.setEnabled(false);
            RegisterContentPane.add(checkBox3);
            checkBox3.setBounds(360, 185, 19, 19);

            //---- lbPassword3 ----
            lbPassword3.setText("\u5e97\u94fa\u94fe\u63a5\uff1a");
            lbPassword3.setFont(lbPassword3.getFont().deriveFont(lbPassword3.getFont().getStyle() | Font.BOLD, lbPassword3.getFont().getSize() + 2f));
            RegisterContentPane.add(lbPassword3);
            lbPassword3.setBounds(15, 255, 72, 19);
            RegisterContentPane.add(pwPassword3);
            pwPassword3.setBounds(85, 250, 269, 27);

            //---- label4 ----
            label4.setText("\uff08\u53ef\u9009\uff09\u8bf7\u8f93\u5165\u60a8\u7684\u5e97\u94fa\u94fe\u63a5\u3002");
            RegisterContentPane.add(label4);
            label4.setBounds(85, 285, 240, 17);

            //---- checkBox4 ----
            checkBox4.setSelected(true);
            checkBox4.setEnabled(false);
            RegisterContentPane.add(checkBox4);
            checkBox4.setBounds(360, 255, 19, 19);

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
    private JLabel label1;
    private JLabel label2;
    private JButton btnRegister;
    private JLabel lbPassword2;
    private JPasswordField pwPassword2;
    private JLabel label3;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JLabel lbPassword3;
    private JPasswordField pwPassword3;
    private JLabel label4;
    private JCheckBox checkBox4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
