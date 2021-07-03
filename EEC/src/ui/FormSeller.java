package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class FormSeller extends Form {
    public FormSeller() {
        initComponents();
    }

    private void btnSearchActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Seller = new JFrame();
        cbJD = new JCheckBox();
        tfInput = new JTextField();
        btnSearch = new JButton();
        spList = new JScrollPane();
        listResult = new JList();

        //======== Seller ========
        {
            Seller.setTitle("\u5e97\u4e3b");
            Seller.setResizable(false);
            Seller.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container SellerContentPane = Seller.getContentPane();
            SellerContentPane.setLayout(null);

            //---- cbJD ----
            cbJD.setText("\u4eac\u4e1c");
            cbJD.setSelected(true);
            SellerContentPane.add(cbJD);
            cbJD.setBounds(new Rectangle(new Point(40, 70), cbJD.getPreferredSize()));
            SellerContentPane.add(tfInput);
            tfInput.setBounds(40, 25, 340, tfInput.getPreferredSize().height);

            //---- btnSearch ----
            btnSearch.setText("\u67e5\u8be2");
            btnSearch.addActionListener(e -> btnSearchActionPerformed(e));
            SellerContentPane.add(btnSearch);
            btnSearch.setBounds(new Rectangle(new Point(405, 25), btnSearch.getPreferredSize()));

            //======== spList ========
            {
                spList.setViewportView(listResult);
            }
            SellerContentPane.add(spList);
            spList.setBounds(40, 110, 440, 255);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < SellerContentPane.getComponentCount(); i++) {
                    Rectangle bounds = SellerContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = SellerContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                SellerContentPane.setMinimumSize(preferredSize);
                SellerContentPane.setPreferredSize(preferredSize);
            }
            Seller.setSize(525, 455);
            Seller.setLocationRelativeTo(Seller.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Seller;
    private JCheckBox cbJD;
    private JTextField tfInput;
    private JButton btnSearch;
    private JScrollPane spList;
    private JList listResult;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
