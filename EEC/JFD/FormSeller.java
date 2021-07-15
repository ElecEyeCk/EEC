/*
 * Created by JFormDesigner on Wed Jul 07 14:38:56 CST 2021
 */

package JFD;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author somnusym
 */
public class FormSeller  {

	private void miShopSettingsActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miQuitLoginActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miSettingsActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void btnSearchActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void cbSortItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}

	private void btnShopSearchActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void cbJDStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void cbAMAZONActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void cbDDActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void spTableResultMouseClicked(MouseEvent e) {
		// TODO add your code here
	}

	private void spTabelShopResultMouseClicked(MouseEvent e) {
		// TODO add your code here
	}

	private void miShopDetailActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miShopBuyActionPerformed(ActionEvent e) {
		// TODO add your code here
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
		tbResult = new JTable();
		spTabelShopResult = new JScrollPane();
		tbShopResult = new JTable();
		pmShop = new JPopupMenu();
		miShopDetail = new JMenuItem();
		miShopBuy = new JMenuItem();
		miCopyItemName = new JMenuItem();
		miChangePrice = new JMenuItem();
		miDeleteItem = new JMenuItem();

		//======== Seller ========
		{
			Seller.setTitle("\u5e97\u4e3b");
			Seller.setResizable(false);
			Seller.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Seller.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			var SellerContentPane = Seller.getContentPane();
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
			sp.setBounds(655, -5, 5, 660);
			SellerContentPane.add(tfInput);
			tfInput.setBounds(40, 65, 495, tfInput.getPreferredSize().height);

			//---- btnSearch ----
			btnSearch.setText("\u67e5\u8be2");
			btnSearch.addActionListener(e -> btnSearchActionPerformed(e));
			SellerContentPane.add(btnSearch);
			btnSearch.setBounds(new Rectangle(new Point(560, 65), btnSearch.getPreferredSize()));

			//---- cbSort ----
			cbSort.setMaximumRowCount(5);
			cbSort.setModel(new DefaultComboBoxModel<>(new String[] {
				"\u8bc4\u8bba\u6570\u2193",
				"\u8bc4\u8bba\u6570\u2191",
				"\u4ef7\u683c\u2193",
				"\u4ef7\u683c\u2191"
			}));
			cbSort.addItemListener(e -> cbSortItemStateChanged(e));
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
			lbShop.setBounds(new Rectangle(new Point(675, 25), lbShop.getPreferredSize()));
			SellerContentPane.add(tfShopInput);
			tfShopInput.setBounds(675, 65, 465, 27);

			//---- btnShopSearch ----
			btnShopSearch.setText("\u68c0\u7d22");
			btnShopSearch.addActionListener(e -> btnShopSearchActionPerformed(e));
			SellerContentPane.add(btnShopSearch);
			btnShopSearch.setBounds(1165, 65, 76, 27);

			//---- lbPlatform ----
			lbPlatform.setText("\u5e73\u53f0\uff1a");
			SellerContentPane.add(lbPlatform);
			lbPlatform.setBounds(new Rectangle(new Point(40, 115), lbPlatform.getPreferredSize()));

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
				spTableResult.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						spTableResultMouseClicked(e);
					}
				});
				spTableResult.setViewportView(tbResult);
			}
			SellerContentPane.add(spTableResult);
			spTableResult.setBounds(40, 160, 595, 490);

			//======== spTabelShopResult ========
			{
				spTabelShopResult.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						spTabelShopResultMouseClicked(e);
					}
				});
				spTabelShopResult.setViewportView(tbShopResult);
			}
			SellerContentPane.add(spTabelShopResult);
			spTabelShopResult.setBounds(675, 115, 565, 535);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < SellerContentPane.getComponentCount(); i++) {
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

			//---- miCopyItemName ----
			miCopyItemName.setText("\u590d\u5236\u5546\u54c1\u540d\u79f0");
			pmShop.add(miCopyItemName);

			//---- miChangePrice ----
			miChangePrice.setText("\u4fee\u6539\u4ef7\u683c");
			pmShop.add(miChangePrice);

			//---- miDeleteItem ----
			miDeleteItem.setText("\u4e0b\u67b6\u5546\u54c1");
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
	private JScrollPane spTabelShopResult;
	private JTable tbShopResult;
	private JPopupMenu pmShop;
	private JMenuItem miShopDetail;
	private JMenuItem miShopBuy;
	private JMenuItem miCopyItemName;
	private JMenuItem miChangePrice;
	private JMenuItem miDeleteItem;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
