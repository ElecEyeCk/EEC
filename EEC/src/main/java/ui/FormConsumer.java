package ui;

import DTO.Item;
import EEC.*;
import Utils.EECError;
import Utils.Utils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;


/**
 * @author somnusym
 */
public class FormConsumer extends Form {
    private static final int SEARCH_RESULT = 0;
    private static final int SHOP_RESULT = 1;

    public FormConsumer() {
        initComponents();
    }

    private void btnSearchActionPerformed(ActionEvent e) {
        if (tfInput.getText().equals(""))
            return;
        ArrayList<Item> items = Item.getItems(tfInput.getText(), cbSort.getSelectedIndex(), EEC.newestDate);
        String[] columnLabels = {"名称", "价格", "评论数", "标签"};
        String[][] rowData = new String[items.size()][];
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            String[] ob = new String[columnLabels.length];
            ob[0] = item.getName();
            ob[1] = String.valueOf(item.getPrice());
            ob[2] = item.getComments();
            ob[3] = item.getIcons();
            rowData[i] = ob;
        }
        tbResult.setModel(new DefaultTableModel(rowData, columnLabels));
        String[] ignoredColumnLabels = {"名称"};
        Utils.fitTableColumns(tbResult, ignoredColumnLabels);
    }

    private void cbJDStateChanged(ChangeEvent e) {
        cbJD.setSelected(true);
    }

    private void cbSortActionPerformed(ActionEvent e) {
        btnSearchActionPerformed(e);
    }

    private void cbAMAZONActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "亚马逊 网站正在开发中！");
        cbAMAZON.setSelected(false);
    }

    private void cbDDActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "当当网 网站正在开发中！");
        cbDD.setSelected(false);
    }

    private void showItemDetail(int eventFrom) {
        if (eventFrom == SEARCH_RESULT) {
            Item item = Item.getItem((String) tbResult.getValueAt(tbResult.getSelectedRow(), 0), EEC.newestDate);
            FormManager.FD.setDetail(item);
            FormManager.FD.show(true);
        }
    }

    private void tbResultMouseClicked(MouseEvent e) {
        if (e.isMetaDown()) {
            int row = tbResult.rowAtPoint(e.getPoint());
            int[] rows = tbResult.getSelectedRows();
            boolean inSelected = false;
            //判断当前右键所在行是否已选中
            for (int r : rows) {
                if (row == r) {
                    inSelected = true;
                    break;
                }
            }
            //当前鼠标右键点击所在行不被选中则高亮显示选中行
            if (!inSelected) {
                tbResult.setRowSelectionInterval(row, row);
            }
            pmItem.show(e.getComponent(), e.getX(), e.getY());
        } else if (e.getClickCount() == 2) {
            showItemDetail(SEARCH_RESULT);
        }
    }

    private void miItemDetailActionPerformed(ActionEvent e) {
        JMenuItem mi = (JMenuItem) e.getSource();
        if (mi.getX() >= tbResult.getX() && mi.getY() >= tbResult.getY() && mi.getX() <= tbResult.getX() + tbResult.getWidth() && mi.getY() <= tbResult.getY() + tbResult.getHeight()) {
            Item item = Item.getItem((String) tbResult.getValueAt(tbResult.getSelectedRow(), 0), EEC.newestDate);
            FormManager.FD.setDetail(item);
            FormManager.FD.show(true);
        }
    }

    private void miShopBuyActionPerformed(ActionEvent e) {
        JMenuItem mi = (JMenuItem) e.getSource();
        if (mi.getX() >= tbResult.getX() && mi.getY() >= tbResult.getY() && mi.getX() <= tbResult.getX() + tbResult.getWidth() && mi.getY() <= tbResult.getY() + tbResult.getHeight()) {
            String name = (String) tbResult.getValueAt(tbResult.getSelectedRow(), 0);
            Item item = Item.getItem(name, EEC.newestDate);
            Utils.openURL("https:" + item.getLink());
        }
    }

    private void miSettingsActionPerformed(ActionEvent e) {
        FormManager.FSe.show(true);
    }

    private void miQuitLoginActionPerformed(ActionEvent e) {
        FormManager.hideAllForms();
        EEC.curUser = null;
        FormManager.FL.show(true);
    }

    private void miAboutActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "本软件由BJUT制作。");
    }

    private void miCopyItemNameActionPerformed(ActionEvent e) {
        JMenuItem mi = (JMenuItem) e.getSource();
        if (mi.getX() >= tbResult.getX() && mi.getY() >= tbResult.getY() && mi.getX() <= tbResult.getX() + tbResult.getWidth() && mi.getY() <= tbResult.getY() + tbResult.getHeight()) {
            String name = (String) tbResult.getValueAt(tbResult.getSelectedRow(), 0);
            if (Utils.setSysClipboardText(name) == EECError.SUCCESS) {
                JOptionPane.showMessageDialog(null, "商品名称已复制到剪切板！");
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Consumer = new JFrame();
        mbConsumer = new JMenuBar();
        mAccount = new JMenu();
        miConvertToShop = new JMenuItem();
        miQuitLogin = new JMenuItem();
        mSettings = new JMenu();
        miSettings = new JMenuItem();
        miAbout = new JMenuItem();
        lbSearch = new JLabel();
        tfInput = new JTextField();
        lbPlatform = new JLabel();
        cbJD = new JCheckBox();
        cbAMAZON = new JCheckBox();
        cbDD = new JCheckBox();
        cbSort = new JComboBox<>();
        btnSearch = new JButton();
        spTabelResult = new JScrollPane();
        tbResult = new JTable();
        pmItem = new JPopupMenu();
        miItemDetail = new JMenuItem();
        miShopBuy = new JMenuItem();
        miCopyItemName = new JMenuItem();

        //======== Consumer ========
        {
            Consumer.setTitle("\u666e\u901a\u7528\u6237");
            Consumer.setResizable(false);
            Consumer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Consumer.addWindowListener(new WindowAdapter() {
                @Override
                public void windowActivated(WindowEvent e) {
                    showing = true;
                }

                @Override
                public void windowDeactivated(WindowEvent e) {
                    showing = false;
                }

            });
            Consumer.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/ICON.jpg"))).getImage());
            Container ConsumerContentPane = Consumer.getContentPane();
            ConsumerContentPane.setLayout(null);

            //======== mbConsumer ========
            {

                //======== mAccount ========
                {
                    mAccount.setText("\u8d26\u6237");

                    //---- miConvertToShop ----
                    miConvertToShop.setText("\u7533\u8bf7\u6210\u4e3a\u5e97\u4e3b");
                    mAccount.add(miConvertToShop);
                    miConvertToShop.addActionListener(this::miConvertToShopActionPerformed);

                    //---- miQuitLogin ----
                    miQuitLogin.setText("\u9000\u51fa\u767b\u5f55");
                    miQuitLogin.addActionListener(this::miQuitLoginActionPerformed);
                    mAccount.add(miQuitLogin);
                }
                mbConsumer.add(mAccount);

                //======== mSettings ========
                {
                    mSettings.setText("\u8bbe\u7f6e");

                    //---- miSettings ----
                    miSettings.setText("\u8bbe\u7f6e");
                    miSettings.addActionListener(this::miSettingsActionPerformed);
                    mSettings.add(miSettings);

                    //---- miAbout ----
                    miAbout.setText("\u5173\u4e8e");
                    miAbout.addActionListener(this::miAboutActionPerformed);
                    mSettings.add(miAbout);
                }
                mbConsumer.add(mSettings);
            }
            Consumer.setJMenuBar(mbConsumer);

            //---- lbSearch ----
            lbSearch.setText("\u67e5\u8be2");
            lbSearch.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            ConsumerContentPane.add(lbSearch);
            lbSearch.setBounds(40, 25, 35, lbSearch.getPreferredSize().height);
            ConsumerContentPane.add(tfInput);
            tfInput.setBounds(40, 65, 465, tfInput.getPreferredSize().height);

            //---- lbPlatform ----
            lbPlatform.setText("\u5e73\u53f0\uff1a");
            ConsumerContentPane.add(lbPlatform);
            lbPlatform.setBounds(new Rectangle(new Point(40, 115), lbPlatform.getPreferredSize()));

            //---- cbJD ----
            cbJD.setText("\u4eac\u4e1c");
            cbJD.setSelected(true);
            cbJD.addChangeListener(this::cbJDStateChanged);
            ConsumerContentPane.add(cbJD);
            cbJD.setBounds(new Rectangle(new Point(105, 115), cbJD.getPreferredSize()));

            //---- cbAMAZON ----
            cbAMAZON.setText("\u4e9a\u9a6c\u900a");
            cbAMAZON.addActionListener(this::cbAMAZONActionPerformed);
            ConsumerContentPane.add(cbAMAZON);
            cbAMAZON.setBounds(new Rectangle(new Point(175, 115), cbAMAZON.getPreferredSize()));

            //---- cbDD ----
            cbDD.setText("\u5f53\u5f53\u7f51");
            cbDD.addActionListener(this::cbDDActionPerformed);
            ConsumerContentPane.add(cbDD);
            cbDD.setBounds(new Rectangle(new Point(255, 115), cbDD.getPreferredSize()));

            //---- cbSort ----
            cbSort.setMaximumRowCount(5);
            cbSort.setModel(new DefaultComboBoxModel<>(new String[]{
                    "\u8bc4\u8bba\u6570\u2193",
                    "\u8bc4\u8bba\u6570\u2191",
                    "\u4ef7\u683c\u2193",
                    "\u4ef7\u683c\u2191"
            }));
            cbSort.addActionListener(this::cbSortActionPerformed);
            ConsumerContentPane.add(cbSort);
            cbSort.setBounds(new Rectangle(new Point(525, 110), cbSort.getPreferredSize()));

            //---- btnSearch ----
            btnSearch.setText("\u67e5\u8be2");
            btnSearch.addActionListener(this::btnSearchActionPerformed);
            ConsumerContentPane.add(btnSearch);
            btnSearch.setBounds(new Rectangle(new Point(530, 65), btnSearch.getPreferredSize()));

            //======== spTableResult ========
            {
                spTabelResult.setViewportView(tbResult);
                tbResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                tbResult.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tbResultMouseClicked(e);
                    }
                });
            }
            ConsumerContentPane.add(spTabelResult);
            spTabelResult.setBounds(40, 160, 565, 490);

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
            Consumer.setSize(645, 720);
            Consumer.setLocationRelativeTo(Consumer.getOwner());
        }

        //======== pmShop ========
        {

            //---- miShopDetail ----
            miItemDetail.setText("\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f");
            miItemDetail.addActionListener(this::miItemDetailActionPerformed);
            pmItem.add(miItemDetail);

            //---- miShopBuy ----
            miShopBuy.setText("\u8df3\u8f6c\u8d2d\u4e70\u94fe\u63a5");
            miShopBuy.addActionListener(this::miShopBuyActionPerformed);
            pmItem.add(miShopBuy);

            miCopyItemName.setText("复制商品名称");
            miCopyItemName.addActionListener(this::miCopyItemNameActionPerformed);
            pmItem.add(miCopyItemName);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void miConvertToShopActionPerformed(ActionEvent actionEvent) {
        FormManager.FSSe.show(true);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Consumer;
    private JMenuBar mbConsumer;
    private JMenu mAccount;
    private JMenuItem miConvertToShop;
    private JMenuItem miQuitLogin;
    private JMenu mSettings;
    private JMenuItem miSettings;
    private JMenuItem miAbout;
    private JLabel lbSearch;
    private JTextField tfInput;
    private JLabel lbPlatform;
    private JCheckBox cbJD;
    private JCheckBox cbAMAZON;
    private JCheckBox cbDD;
    private JComboBox<String> cbSort;
    private JButton btnSearch;
    private JScrollPane spTabelResult;
    private JTable tbResult;
    private JPopupMenu pmItem;
    private JMenuItem miItemDetail;
    private JMenuItem miShopBuy;
    private JMenuItem miCopyItemName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
