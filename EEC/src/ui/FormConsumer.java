package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class FormConsumer extends Form {
    public FormConsumer() {
        initComponents();
    }

    private void btnSearchActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Consumer = new JFrame();
        cbJD = new JCheckBox();
        tfInput = new JTextField();
        btnSearch = new JButton();
        spList = new JScrollPane();
        listResult = new JList();

        //======== Consumer ========
        {
            Consumer.setTitle("\u6d88\u8d39\u8005");
            Consumer.setResizable(false);
            Consumer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container ConsumerContentPane = Consumer.getContentPane();
            ConsumerContentPane.setLayout(null);

            //---- cbJD ----
            cbJD.setText("\u4eac\u4e1c");
            cbJD.setSelected(true);
            ConsumerContentPane.add(cbJD);
            cbJD.setBounds(new Rectangle(new Point(40, 70), cbJD.getPreferredSize()));
            ConsumerContentPane.add(tfInput);
            tfInput.setBounds(40, 25, 340, tfInput.getPreferredSize().height);

            //---- btnSearch ----
            btnSearch.setText("\u67e5\u8be2");
            btnSearch.addActionListener(e -> btnSearchActionPerformed(e));
            ConsumerContentPane.add(btnSearch);
            btnSearch.setBounds(new Rectangle(new Point(405, 25), btnSearch.getPreferredSize()));

            //======== spList ========
            {
                spList.setViewportView(listResult);
            }
            ConsumerContentPane.add(spList);
            spList.setBounds(40, 110, 440, 255);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < ConsumerContentPane.getComponentCount(); i++) {
                    Rectangle bounds = ConsumerContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = ConsumerContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                ConsumerContentPane.setMinimumSize(preferredSize);
                ConsumerContentPane.setPreferredSize(preferredSize);
            }
            Consumer.setSize(525, 455);
            Consumer.setLocationRelativeTo(Consumer.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Consumer;
    private JCheckBox cbJD;
    private JTextField tfInput;
    private JButton btnSearch;
    private JScrollPane spList;
    private JList listResult;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
