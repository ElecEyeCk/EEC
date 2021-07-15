package ui;

import DTO.Item;
import DTO.User;
import EEC.*;

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
public class FormSeller extends Form {
    private boolean flag = true;

    public FormSeller() {
        initComponents();
        flag = false;
    }

    private void btnSearchActionPerformed(ActionEvent e) {
        if (tfInput.getText().equals(""))
            return;
        ArrayList<Item> items = Item.getItems(tfInput.getText(), cbSort.getSelectedIndex(), EEC.newestDate);
        String[] columnLabels = {"名称", "价格", "评论数", "店铺", "标签"};
        String[][] rowData = new String[items.size()][];
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            String[] ob = new String[columnLabels.length];
            ob[0] = item.getName();
            ob[1] = String.valueOf(item.getPrice());
            ob[2] = item.getComments();
            ob[3] = item.getShop();
            ob[4] = item.getIcons();
            rowData[i] = ob;
        }
        tbResult.setModel(new DefaultTableModel(rowData, columnLabels));
        String[] ignoredColumnLabels = {"名称", "店铺"};
        Utils.fitTableColumns(tbResult, ignoredColumnLabels);
    }

    private void cbSortActionPerformed(ActionEvent e) {
        btnSearchActionPerformed(e);
    }

    public void showShopItems(String keyword, String key) {
        lbShop.setText("我的店铺（" + keyword + ")");
        ArrayList<Item> items = null;
        items = Item.getShopItems(keyword, EEC.newestDate, key);
        String[] columnLabels = {"名称", "价格", "评论数", "标签"};

        String[][] rowData = new String[items.size()][];
        ArrayList<Integer> hides = new ArrayList<Integer>();
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (!item.getHide()) {
                hides.add(i);
            }
            String[] ob = new String[columnLabels.length];
            ob[0] = item.getName();
            ob[1] = String.valueOf(item.getPrice());
            ob[2] = item.getComments();
            ob[3] = item.getIcons();
            rowData[i] = ob;
        }
        for (Integer h : hides) {
            rowData = Utils.deleteRowFromTwoDimensionsArray(h, rowData);
        }
        tbShopResult.setModel(new DefaultTableModel(rowData, columnLabels));
        String[] ignoredColumnLabels = {"名称"};
        Utils.fitTableColumns(tbShopResult, ignoredColumnLabels);
    }

    private void btnShopSearchActionPerformed(ActionEvent e) {
        showShopItems(EEC.curUser.getShop(), tfShopInput.getText());
    }

    private void miOpenMyShopActionPerformed(ActionEvent actionEvent) {
        Utils.openURL(Item.getShopLink(EEC.curUser.getShop()));
    }

    private void cbJDStateChanged(ChangeEvent e) {
        cbJD.setSelected(true);
    }

    private void miItemDetailActionPerformed(ActionEvent e) {
        showItemDetail(tbResult);
    }

    private void showItemDetail(JTable table) {
        Item item = Item.getItem((String) table.getValueAt(table.getSelectedRow(), 0), EEC.newestDate);
        Item.increaseDetail(item);
        item.setDetail(item.getDetail() + 1);
        FormManager.FD.show(true);
        FormManager.FD.setDetail(item);
    }

    private void miJumpBuyActionPerformed(ActionEvent e) {
        String name = (String) tbResult.getValueAt(tbResult.getSelectedRow(), 0);
        Item item = Item.getItem(name, EEC.newestDate);
        Utils.openURL("https:" + item.getLink());

    }

    private void miShopSettingsActionPerformed(ActionEvent e) {
        FormManager.FSSe.show(true);
    }

    private void miSettingsActionPerformed(ActionEvent e) {
        Utils.getSettings();
        FormManager.FSe.show(true);
    }

    private void miQuitLoginActionPerformed(ActionEvent e) {
        FormManager.hideAllForms();
        EEC.curUser = null;
        FormManager.FL.show(true);
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
            showItemDetail(tbResult);
        }
    }

    private void tbShopResultMouseClicked(MouseEvent e) {
        if (e.isMetaDown()) {
            int row = tbShopResult.rowAtPoint(e.getPoint());
            int[] rows = tbShopResult.getSelectedRows();
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
                tbShopResult.setRowSelectionInterval(row, row);
            }
            pmShop.show(e.getComponent(), e.getX(), e.getY());
        } else if (e.getClickCount() == 2) {
            showItemDetail(tbShopResult);
        }
    }

    private void cbDDActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "当当网 网站正在开发中！");
        cbDD.setSelected(false);
    }

    private void cbAMAZONActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "亚马逊 网站正在开发中！");
        cbAMAZON.setSelected(false);
    }

    private void miAboutActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "本软件由BJUT制作。");
    }

    private void miCopyItemNameActionPerformed(ActionEvent e) {
        JMenuItem mi = (JMenuItem) e.getSource();
        String name = (String) tbResult.getValueAt(tbResult.getSelectedRow(), 0);
        if (Utils.setSysClipboardText(name) == EECError.SUCCESS) {
            JOptionPane.showMessageDialog(null, "商品名称已复制到剪切板！");
        }
    }

    private void miShopCopyItemNameActionPerformed(ActionEvent actionEvent) {
        String name = (String) tbShopResult.getValueAt(tbShopResult.getSelectedRow(), 0);
        if (Utils.setSysClipboardText(name) == EECError.SUCCESS) {
            JOptionPane.showMessageDialog(null, "商品名称已复制到剪切板！");
        }
    }

    private void miShopJumpBuyActionPerformed(ActionEvent actionEvent) {
        String name = (String) tbShopResult.getValueAt(tbShopResult.getSelectedRow(), 0);
        Item item = Item.getItem(name, EEC.newestDate);
        Utils.openURL("https:" + item.getLink());
    }

    private void miShopItemDetailActionPerformed(ActionEvent actionEvent) {
        showItemDetail(tbShopResult);
    }

    private void miDeleteItemActionPerformed(ActionEvent actionEvent) {
        if (JOptionPane.showConfirmDialog(null, "您确定要下架该商品吗？该操作不可逆！", "警告", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Item.setItemHide(Item.getID((String) tbShopResult.getValueAt(tbShopResult.getSelectedRow(), 0), EEC.newestDate), 0);
            EEC.curUser = User.getUser(EEC.curUser.getID());
            showShopItems(EEC.curUser.getShop(), null);
        }
    }

    private void miChangePriceActionPerformed(ActionEvent actionEvent) {
        FormManager.FCP.show(true);
        FormManager.FCP.setID(Item.getID((String) tbShopResult.getValueAt(tbShopResult.getSelectedRow(), 0), EEC.newestDate));
        FormManager.FCP.ChangePrice.setTitle((String) tbShopResult.getValueAt(tbShopResult.getSelectedRow(), 0));
        EEC.curUser = User.getUser(EEC.curUser.getID());
        showShopItems(EEC.curUser.getShop(), null);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Seller = new JFrame();
        mbSeller = new JMenuBar();
        mShop = new JMenu();
        miShopSettings = new JMenuItem();
        miQuitLogin = new JMenuItem();
        mSettings = new JMenu();
        miSettings = new JMenuItem();
        miAbout = new JMenuItem();
        sp = new JSeparator();
        tfInput = new JTextField();
        btnSearch = new JButton();
        cbSort = new JComboBox<>();
        lbSearch = new JLabel();
        lbShop = new JLabel();
        tfShopInput = new JTextField();
        btnShopSearch = new JButton();
        lbPlatform = new JLabel();
        cbJD = new JCheckBox();
        cbAMAZON = new JCheckBox();
        cbDD = new JCheckBox();
        spTableResult = new JScrollPane();
        tbResult = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        spTableShopResult = new JScrollPane();
        tbShopResult = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        pmItem = new JPopupMenu();
        miItemDetail = new JMenuItem();
        miShopJumpBuy = new JMenuItem();
        miOpenMyShop = new JMenuItem();
        miCopyItemName = new JMenuItem();
        miDeleteItem = new JMenuItem();
        miChangePrice = new JMenuItem();
        pmShop = new JPopupMenu();
        miJumpBuy = new JMenuItem();
        miShopCopyItemName = new JMenuItem();
        miShopItemDetail = new JMenuItem();

        //======== Seller ========
        {
            Seller.setTitle("\u5e97\u4e3b");
            Seller.setResizable(false);
            Seller.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Seller.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/ICON.jpg"))).getImage());
            Container SellerContentPane = Seller.getContentPane();
            SellerContentPane.setLayout(null);
            Seller.addWindowListener(new WindowAdapter() {
                @Override
                public void windowActivated(WindowEvent e) {
                    if (!flag)
                        showShopItems(EEC.curUser.getShop(), null);
                }
            });

            //======== mbSeller ========
            {

                //======== mShop ========
                {
                    mShop.setText("\u8d26\u53f7");

                    //---- miOpenMyShop
                    miOpenMyShop.setText("打开我的店铺");
                    miOpenMyShop.addActionListener(this::miOpenMyShopActionPerformed);
                    mShop.add(miOpenMyShop);

                    //---- miShopSettings ----
                    miShopSettings.setText("\u5e97\u94fa\u8bbe\u7f6e");
                    miShopSettings.addActionListener(this::miShopSettingsActionPerformed);
                    mShop.add(miShopSettings);

                    //---- miQuitLogin ----
                    miQuitLogin.setText("\u9000\u51fa\u767b\u5f55");
                    miQuitLogin.addActionListener(this::miQuitLoginActionPerformed);
                    mShop.add(miQuitLogin);
                }
                mbSeller.add(mShop);

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
                mbSeller.add(mSettings);
            }
            Seller.setJMenuBar(mbSeller);

            //---- sp ----
            sp.setForeground(new Color(153, 153, 153));
            sp.setOrientation(SwingConstants.VERTICAL);
            SellerContentPane.add(sp);
            sp.setBounds(655, 10, 5, 655);
            SellerContentPane.add(tfInput);
            tfInput.setBounds(40, 65, 495, tfInput.getPreferredSize().height);

            //---- btnSearch ----
            btnSearch.setText("\u67e5\u8be2");
            btnSearch.addActionListener(this::btnSearchActionPerformed);
            SellerContentPane.add(btnSearch);
            btnSearch.setBounds(new Rectangle(new Point(560, 65), btnSearch.getPreferredSize()));

            //---- cbSort ----
            cbSort.setMaximumRowCount(5);
            cbSort.setModel(new DefaultComboBoxModel<>(new String[]{
                    "\u8bc4\u8bba\u6570\u2193",
                    "\u8bc4\u8bba\u6570\u2191",
                    "\u4ef7\u683c\u2193",
                    "\u4ef7\u683c\u2191"
            }));
            cbSort.addActionListener(this::cbSortActionPerformed);
            SellerContentPane.add(cbSort);
            cbSort.setBounds(new Rectangle(new Point(555, 110), cbSort.getPreferredSize()));

            //---- lbSearch ----
            lbSearch.setText("\u67e5\u8be2");
            lbSearch.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            SellerContentPane.add(lbSearch);
            lbSearch.setBounds(40, 25, 35, lbSearch.getPreferredSize().height);

            //---- lbShop ----
            lbShop.setText("\u6211\u7684\u5e97\u94fa");
            lbShop.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            SellerContentPane.add(lbShop);
            lbShop.setBounds(new Rectangle(675, 25, 465, lbShop.getPreferredSize().height));
            SellerContentPane.add(tfShopInput);
            tfShopInput.setBounds(675, 65, 465, 27);

            //---- btnShopSearch ----
            btnShopSearch.setText("\u68c0\u7d22");
            btnShopSearch.addActionListener(this::btnShopSearchActionPerformed);
            SellerContentPane.add(btnShopSearch);
            btnShopSearch.setBounds(1165, 65, 76, 27);

            //---- lbPlatform ----
            lbPlatform.setText("\u5e73\u53f0\uff1a");
            SellerContentPane.add(lbPlatform);
            lbPlatform.setBounds(new Rectangle(new Point(40, 115), lbPlatform.getPreferredSize()));

            //---- cbJD ----
            cbJD.setText("\u4eac\u4e1c");
            cbJD.setSelected(true);
            cbJD.addChangeListener(this::cbJDStateChanged);
            SellerContentPane.add(cbJD);
            cbJD.setBounds(new Rectangle(new Point(105, 115), cbJD.getPreferredSize()));

            //---- cbAMAZON ----
            cbAMAZON.setText("\u4e9a\u9a6c\u900a");
            cbAMAZON.addActionListener(this::cbAMAZONActionPerformed);
            SellerContentPane.add(cbAMAZON);
            cbAMAZON.setBounds(new Rectangle(new Point(175, 115), cbAMAZON.getPreferredSize()));

            //---- cbDD ----
            cbDD.setText("\u5f53\u5f53\u7f51");
            cbDD.addActionListener(this::cbDDActionPerformed);
            SellerContentPane.add(cbDD);
            cbDD.setBounds(new Rectangle(new Point(255, 115), cbDD.getPreferredSize()));

            //======== spTableResult ========
            {
                tbResult.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tbResultMouseClicked(e);
                    }
                });
                spTableResult.setViewportView(tbResult);
            }
            SellerContentPane.add(spTableResult);
            spTableResult.setBounds(40, 160, 595, 490);

            //======== spTableShopResult ========
            {
                tbShopResult.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tbShopResultMouseClicked(e);
                    }
                });
                spTableShopResult.setViewportView(tbShopResult);
            }
            SellerContentPane.add(spTableShopResult);
            spTableShopResult.setBounds(675, 115, 565, 535);

            //======== tbResult ========
            tbResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbShopResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
            Seller.setSize(1280, 720);
            Seller.setLocationRelativeTo(null);
        }

        //======== pmItem ========
        {

            //---- miItemDetail ----
            miItemDetail.setText("\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f");
            miItemDetail.addActionListener(this::miItemDetailActionPerformed);
            pmItem.add(miItemDetail);
            miShopItemDetail.setText("\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f");
            miShopItemDetail.addActionListener(this::miShopItemDetailActionPerformed);
            pmShop.add(miShopItemDetail);

            //---- miShopBuy ----
            miShopJumpBuy.setText("\u8df3\u8f6c\u8d2d\u4e70\u94fe\u63a5");
            miShopJumpBuy.addActionListener(this::miShopJumpBuyActionPerformed);
            miJumpBuy.setText("\u8df3\u8f6c\u8d2d\u4e70\u94fe\u63a5");
            miJumpBuy.addActionListener(this::miJumpBuyActionPerformed);
            pmItem.add(miJumpBuy);
            pmShop.add(miShopJumpBuy);

            miCopyItemName.setText("复制商品名称");
            miCopyItemName.addActionListener(this::miCopyItemNameActionPerformed);
            miShopCopyItemName.setText("复制商品名称");
            miShopCopyItemName.addActionListener(this::miShopCopyItemNameActionPerformed);
            pmItem.add(miCopyItemName);
            pmShop.add(miShopCopyItemName);

            //---- miChangePrice ----
            miChangePrice.setText("\u4fee\u6539\u4ef7\u683c");
            miChangePrice.addActionListener(this::miChangePriceActionPerformed);
            pmShop.add(miChangePrice);

            //---- miDeleteItem ----
            miDeleteItem.setText("\u4e0b\u67b6\u5546\u54c1");
            miDeleteItem.addActionListener(this::miDeleteItemActionPerformed);
            pmShop.add(miDeleteItem);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Seller;
    private JMenuBar mbSeller;
    private JMenu mShop;
    private JMenuItem miShopSettings;
    private JMenuItem miQuitLogin;
    private JMenu mSettings;
    private JMenuItem miSettings;
    private JMenuItem miAbout;
    private JSeparator sp;
    private JTextField tfInput;
    private JButton btnSearch;
    private JComboBox<String> cbSort;
    private JLabel lbSearch;
    private JLabel lbShop;
    private JTextField tfShopInput;
    private JButton btnShopSearch;
    private JLabel lbPlatform;
    private JCheckBox cbJD;
    private JCheckBox cbAMAZON;
    private JCheckBox cbDD;
    private JScrollPane spTableResult;
    private JTable tbResult;
    private JScrollPane spTableShopResult;
    private JTable tbShopResult;
    private JPopupMenu pmItem;
    private JMenuItem miShopItemDetail;
    private JMenuItem miShopJumpBuy;
    private JMenuItem miOpenMyShop;
    private JMenuItem miShopCopyItemName;
    private JMenuItem miItemDetail;
    private JMenuItem miJumpBuy;
    private JMenuItem miCopyItemName;
    private JMenuItem miChangePrice;
    private JMenuItem miDeleteItem;
    private JPopupMenu pmShop;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
