package ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;


/**
 * @author somnusym
 */
public class FormConsumer extends Form {

	public FormConsumer() {
		initComponents();
	}

	private void btnSearchActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void cbJDStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void cbSortItemStateChanged(ItemEvent e) {
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

	private void miShopDetailActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void miShopBuyActionPerformed(ActionEvent e) {
		// TODO add your code here
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
		pmShop = new JPopupMenu();
		miItemDetail = new JMenuItem();
		miShopBuy = new JMenuItem();

		//======== Consumer ========
		{
			Consumer.setTitle("\u666e\u901a\u7528\u6237");
			Consumer.setResizable(false);
			Consumer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

					//---- miQuitLogin ----
					miQuitLogin.setText("\u9000\u51fa\u767b\u5f55");
					mAccount.add(miQuitLogin);
				}
				mbConsumer.add(mAccount);

				//======== mSettings ========
				{
					mSettings.setText("\u8bbe\u7f6e");

					//---- miSettings ----
					miSettings.setText("\u8bbe\u7f6e");
					mSettings.add(miSettings);

					//---- miAbout ----
					miAbout.setText("\u5173\u4e8e");
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
			cbJD.addChangeListener(e -> cbJDStateChanged(e));
			ConsumerContentPane.add(cbJD);
			cbJD.setBounds(new Rectangle(new Point(105, 115), cbJD.getPreferredSize()));

			//---- cbAMAZON ----
			cbAMAZON.setText("\u4e9a\u9a6c\u900a");
			cbAMAZON.addActionListener(e -> cbAMAZONActionPerformed(e));
			ConsumerContentPane.add(cbAMAZON);
			cbAMAZON.setBounds(new Rectangle(new Point(175, 115), cbAMAZON.getPreferredSize()));

			//---- cbDD ----
			cbDD.setText("\u5f53\u5f53\u7f51");
			cbDD.addActionListener(e -> cbDDActionPerformed(e));
			ConsumerContentPane.add(cbDD);
			cbDD.setBounds(new Rectangle(new Point(255, 115), cbDD.getPreferredSize()));

			//---- cbSort ----
			cbSort.setMaximumRowCount(5);
			cbSort.setModel(new DefaultComboBoxModel<>(new String[] {
				"\u8bc4\u8bba\u6570\u2193",
				"\u8bc4\u8bba\u6570\u2191",
				"\u4ef7\u683c\u2193",
				"\u4ef7\u683c\u2191"
			}));
			cbSort.addItemListener(e -> cbSortItemStateChanged(e));
			ConsumerContentPane.add(cbSort);
			cbSort.setBounds(new Rectangle(new Point(525, 110), cbSort.getPreferredSize()));

			//---- btnSearch ----
			btnSearch.setText("\u67e5\u8be2");
			btnSearch.addActionListener(e -> btnSearchActionPerformed(e));
			ConsumerContentPane.add(btnSearch);
			btnSearch.setBounds(new Rectangle(new Point(530, 65), btnSearch.getPreferredSize()));

			//======== spTableResult ========
			{
				spTabelResult.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						spTableResultMouseClicked(e);
					}
				});
				spTabelResult.setViewportView(tbResult);
			}
			ConsumerContentPane.add(spTabelResult);
			spTabelResult.setBounds(40, 160, 565, 490);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < ConsumerContentPane.getComponentCount(); i++) {
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
			miItemDetail.addActionListener(e -> miShopDetailActionPerformed(e));
			pmShop.add(miItemDetail);

			//---- miShopBuy ----
			miShopBuy.setText("\u8df3\u8f6c\u8d2d\u4e70\u94fe\u63a5");
			miShopBuy.addActionListener(e -> miShopBuyActionPerformed(e));
			pmShop.add(miShopBuy);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
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
	private JPopupMenu pmShop;
	private JMenuItem miItemDetail;
	private JMenuItem miShopBuy;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
