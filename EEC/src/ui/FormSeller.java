package ui;

import DTO.Item;
import EEC.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;


/**
 * @author somnusym
 */
public class FormSeller extends Form {

    public FormSeller() {
        initComponents();
    }

    private void btnSearchActionPerformed(ActionEvent e) {
        if (tfInput.getText().equals(""))
            return;
        ArrayList<Item> items = Item.getItems(tfInput.getText(), cbSort.getSelectedIndex(), EEC.currentDate);
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
        Utils.FitTableColumns(tbResult, ignoredColumnLabels);
    }

    private void cbsortActionPerformed(ActionEvent e) {
        btnSearchActionPerformed(e);
    }

    private void btnShopSearchActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void cbJDStateChanged(ChangeEvent e) {
        cbJD.setSelected(true);
    }

    private void miShopDetailActionPerformed(ActionEvent e) {
        Item item = Item.getItem((String) tbResult.getValueAt(tbResult.getSelectedRow(), 0), EEC.currentDate);
        FormManager.FD.setDetail(item);
        FormManager.FD.show(true);
    }

    private void miShopBuyActionPerformed(ActionEvent e) {
        JMenuItem mi = (JMenuItem) e.getSource();
        if (mi.getX() >= tbResult.getX() && mi.getY() >= tbResult.getY() && mi.getX() <= tbResult.getX() + tbResult.getWidth() && mi.getY() <= tbResult.getY() + tbResult.getHeight()) {
            String name = (String) tbResult.getValueAt(tbResult.getSelectedRow(), 0);
            Item item = Item.getItem(name, EEC.currentDate);
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https:" + item.getLink());
            } catch (IOException ioException) {
                EECError.errorTips(EECError.OPEN_URL_ERROR);
            }
        }
    }

    private void miShopSettingsActionPerformed(ActionEvent e) {
        FormManager.FSSe.show(true);
    }

    private void miSettingsActionPerformed(ActionEvent e) {
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
            pmShop.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    private void tbShopResultMouseClicked(MouseEvent e) {
        if (e.isMetaDown() && tbShopResult.hasFocus()) {
            pmShop.show(e.getComponent(), e.getX(), e.getY());
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
        spTabelShopResult = new JScrollPane();
        tbShopResult = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        pmShop = new JPopupMenu();
        miShopDetail = new JMenuItem();
        miShopBuy = new JMenuItem();

        //======== Seller ========
        {
            Seller.setTitle("\u5e97\u4e3b");
            Seller.setResizable(false);
            Seller.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Seller.setIconImage(new ImageIcon(getClass().getResource("/jpg/ICON.jpg")).getImage());
            Container SellerContentPane = Seller.getContentPane();
            SellerContentPane.setLayout(null);

            //======== mbSeller ========
            {

                //======== mShop ========
                {
                    mShop.setText("\u8d26\u53f7");

                    //---- miShopSettings ----
                    miShopSettings.setText("\u5e97\u94fa\u8bbe\u7f6e");
                    miShopSettings.addActionListener(e -> miShopSettingsActionPerformed(e));
                    mShop.add(miShopSettings);

                    //---- miQuitLogin ----
                    miQuitLogin.setText("\u9000\u51fa\u767b\u5f55");
                    miQuitLogin.addActionListener(e -> miQuitLoginActionPerformed(e));
                    mShop.add(miQuitLogin);
                }
                mbSeller.add(mShop);

                //======== mSettings ========
                {
                    mSettings.setText("\u8bbe\u7f6e");

                    //---- miSettings ----
                    miSettings.setText("\u8bbe\u7f6e");
                    miSettings.addActionListener(e -> miSettingsActionPerformed(e));
                    mSettings.add(miSettings);

                    //---- miAbout ----
                    miAbout.setText("\u5173\u4e8e");
                    mSettings.add(miAbout);
                }
                mbSeller.add(mSettings);
            }
            Seller.setJMenuBar(mbSeller);

            //---- sp ----
            sp.setForeground(new Color(153, 153, 153));
            sp.setOrientation(SwingConstants.VERTICAL);
            SellerContentPane.add(sp);
            sp.setBounds(500, 5, 5, 535);
            SellerContentPane.add(tfInput);
            tfInput.setBounds(40, 65, 340, tfInput.getPreferredSize().height);

            //---- btnSearch ----
            btnSearch.setText("\u67e5\u8be2");
            btnSearch.addActionListener(e -> btnSearchActionPerformed(e));
            SellerContentPane.add(btnSearch);
            btnSearch.setBounds(new Rectangle(new Point(405, 65), btnSearch.getPreferredSize()));

            //---- cbSort ----
            cbSort.setMaximumRowCount(5);
            cbSort.setModel(new DefaultComboBoxModel<>(new String[]{
                    "\u8bc4\u8bba\u6570\u2193",
                    "\u8bc4\u8bba\u6570\u2191",
                    "\u4ef7\u683c\u2193",
                    "\u4ef7\u683c\u2191"
            }));
            cbSort.addActionListener(e -> cbsortActionPerformed(e));
            SellerContentPane.add(cbSort);
            cbSort.setBounds(new Rectangle(new Point(400, 110), cbSort.getPreferredSize()));

            //---- lbSearch ----
            lbSearch.setText("\u67e5\u8be2");
            lbSearch.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            SellerContentPane.add(lbSearch);
            lbSearch.setBounds(40, 25, 35, lbSearch.getPreferredSize().height);

            //---- lbShop ----
            lbShop.setText("\u6211\u7684\u5e97\u94fa");
            lbShop.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
            SellerContentPane.add(lbShop);
            lbShop.setBounds(new Rectangle(new Point(520, 25), lbShop.getPreferredSize()));
            SellerContentPane.add(tfShopInput);
            tfShopInput.setBounds(520, 65, 340, 27);

            //---- btnShopSearch ----
            btnShopSearch.setText("\u68c0\u7d22");
            btnShopSearch.addActionListener(e -> btnShopSearchActionPerformed(e));
            SellerContentPane.add(btnShopSearch);
            btnShopSearch.setBounds(885, 65, 76, 27);

            //---- lbPlatform ----
            lbPlatform.setText("\u5e73\u53f0\uff1a");
            SellerContentPane.add(lbPlatform);
            lbPlatform.setBounds(new Rectangle(new Point(40, 120), lbPlatform.getPreferredSize()));

            //---- cbJD ----
            cbJD.setText("\u4eac\u4e1c");
            cbJD.setSelected(true);
            cbJD.addChangeListener(e -> cbJDStateChanged(e));
            SellerContentPane.add(cbJD);
            cbJD.setBounds(new Rectangle(new Point(105, 115), cbJD.getPreferredSize()));

            //---- cbAMAZON ----
            cbAMAZON.setText("\u4e9a\u9a6c\u900a");
            cbAMAZON.addActionListener(e -> cbAMAZONActionPerformed(e));
            SellerContentPane.add(cbAMAZON);
            cbAMAZON.setBounds(new Rectangle(new Point(175, 115), cbAMAZON.getPreferredSize()));

            //---- cbDD ----
            cbDD.setText("\u5f53\u5f53\u7f51");
            cbDD.addActionListener(e -> cbDDActionPerformed(e));
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
            spTableResult.setBounds(40, 160, 440, 355);

            //======== spTabelShopResult ========
            {
                tbShopResult.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tbShopResultMouseClicked(e);
                    }
                });
                spTabelShopResult.setViewportView(tbShopResult);
            }
            SellerContentPane.add(spTabelShopResult);
            spTabelShopResult.setBounds(520, 115, 440, 400);

            //======== tbResult ========


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
            Seller.setSize(1000, 600);
            Seller.setLocationRelativeTo(null);
        }

        //======== pmShop ========
        {

            //---- miShopDetail ----
            miShopDetail.setText("\u67e5\u770b\u8be6\u7ec6\u4fe1\u606f");
            miShopDetail.addActionListener(e -> miShopDetailActionPerformed(e));
            pmShop.add(miShopDetail);

            //---- miShopBuy ----
            miShopBuy.setText("\u8df3\u8f6c\u8d2d\u4e70\u94fe\u63a5");
            miShopBuy.addActionListener(e -> miShopBuyActionPerformed(e));
            pmShop.add(miShopBuy);
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
    private JScrollPane spTabelShopResult;
    private JTable tbShopResult;
    private JPopupMenu pmShop;
    private JMenuItem miShopDetail;
    private JMenuItem miShopBuy;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
