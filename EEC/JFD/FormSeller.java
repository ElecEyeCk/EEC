import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Sat Jul 03 17:11:01 CST 2021
 */



/**
 * @author somnusym
 */
public class FormSeller  {

	private void btnSearchActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void comboBox1ItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}

	private void cbSortItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}

	private void listShopResultValueChanged(ListSelectionEvent e) {
		// TODO add your code here
	}

	private void btnShopSearchActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void cbJDStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void cbAMAZONStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void cbDDStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void miShopDetailActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miShopBuyActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miShopSettingsActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miSettingsActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		Seller = new JFrame();
		mbSeller = new JMenuBar();
		mShop = new JMenu();
		miShopSettings = new JMenuItem();
		mSettings = new JMenu();
		miSettings = new JMenuItem();
		miAbout = new JMenuItem();
		sp = new JSeparator();
		tfInput = new JTextField();
		btnSearch = new JButton();
		spList = new JScrollPane();
		listResult = new JList();
		cbSort = new JComboBox<>();
		spShopList = new JScrollPane();
		listShopResult = new JList();
		lbSearch = new JLabel();
		lbShop = new JLabel();
		tfShopInput = new JTextField();
		btnShopSearch = new JButton();
		lbPlatform = new JLabel();
		cbJD = new JCheckBox();
		cbAMAZON = new JCheckBox();
		cbDD = new JCheckBox();
		pmShop = new JPopupMenu();
		miShopDetail = new JMenuItem();
		miShopBuy = new JMenuItem();

		//======== Seller ========
		{
			Seller.setTitle("\u5e97\u4e3b");
			Seller.setResizable(false);
			Seller.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Seller.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
			Container SellerContentPane = Seller.getContentPane();
			SellerContentPane.setLayout(null);

			//======== mbSeller ========
			{

				//======== mShop ========
				{
					mShop.setText("\u5e97\u94fa");

					//---- miShopSettings ----
					miShopSettings.setText("\u5e97\u94fa\u8bbe\u7f6e");
					miShopSettings.addActionListener(e -> miShopSettingsActionPerformed(e));
					mShop.add(miShopSettings);
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

			//======== spList ========
			{
				spList.setViewportView(listResult);
			}
			SellerContentPane.add(spList);
			spList.setBounds(40, 160, 440, 355);

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
			cbSort.setBounds(new Rectangle(new Point(400, 110), cbSort.getPreferredSize()));

			//======== spShopList ========
			{

				//---- listShopResult ----
				listShopResult.addListSelectionListener(e -> listShopResultValueChanged(e));
				spShopList.setViewportView(listShopResult);
			}
			SellerContentPane.add(spShopList);
			spShopList.setBounds(520, 115, 440, 400);

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
			cbAMAZON.addChangeListener(e -> cbAMAZONStateChanged(e));
			SellerContentPane.add(cbAMAZON);
			cbAMAZON.setBounds(new Rectangle(new Point(175, 115), cbAMAZON.getPreferredSize()));

			//---- cbDD ----
			cbDD.setText("\u5f53\u5f53\u7f51");
			cbDD.addChangeListener(e -> cbDDStateChanged(e));
			SellerContentPane.add(cbDD);
			cbDD.setBounds(new Rectangle(new Point(255, 115), cbDD.getPreferredSize()));

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
	private JMenu mSettings;
	private JMenuItem miSettings;
	private JMenuItem miAbout;
	private JSeparator sp;
	private JTextField tfInput;
	private JButton btnSearch;
	private JScrollPane spList;
	private JList listResult;
	private JComboBox<String> cbSort;
	private JScrollPane spShopList;
	private JList listShopResult;
	private JLabel lbSearch;
	private JLabel lbShop;
	private JTextField tfShopInput;
	private JButton btnShopSearch;
	private JLabel lbPlatform;
	private JCheckBox cbJD;
	private JCheckBox cbAMAZON;
	private JCheckBox cbDD;
	private JPopupMenu pmShop;
	private JMenuItem miShopDetail;
	private JMenuItem miShopBuy;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
