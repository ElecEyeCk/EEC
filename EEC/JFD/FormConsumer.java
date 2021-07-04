import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Sat Jul 03 17:10:59 CST 2021
 */



/**
 * @author somnusym
 */
public class FormConsumer  {

	private void btnSearchActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void comboBox1ItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}

	private void cbJDItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}

	private void cbJDStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void cbAMAZONStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void listResultMouseClicked(MouseEvent e) {
		// TODO add your code here
	}

	private void cbSortItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}

	private void cbDDStateChanged(ChangeEvent e) {
		// TODO add your code here
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		Consumer = new JFrame();
		mbConsumer = new JMenuBar();
		mAccount = new JMenu();
		miConvertToShop = new JMenuItem();
		mSettings = new JMenu();
		miSettings = new JMenuItem();
		miAbout = new JMenuItem();
		cbJD = new JCheckBox();
		tfInput = new JTextField();
		btnSearch = new JButton();
		spList = new JScrollPane();
		listResult = new JList();
		cbSort = new JComboBox<>();
		cbAMAZON = new JCheckBox();
		cbDD = new JCheckBox();
		lbPlatform = new JLabel();

		//======== Consumer ========
		{
			Consumer.setTitle("\u666e\u901a\u7528\u6237");
			Consumer.setResizable(false);
			Consumer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Consumer.setIconImage(new ImageIcon(getClass().getResource("/resource/jpg/ICON.jpg")).getImage());
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

			//---- cbJD ----
			cbJD.setText("\u4eac\u4e1c");
			cbJD.setSelected(true);
			cbJD.addChangeListener(e -> cbJDStateChanged(e));
			ConsumerContentPane.add(cbJD);
			cbJD.setBounds(new Rectangle(new Point(110, 70), cbJD.getPreferredSize()));

			//---- tfInput ----
			tfInput.setText("\u6b32\u67e5\u8be2\u7684\u5546\u54c1");
			ConsumerContentPane.add(tfInput);
			tfInput.setBounds(40, 25, 340, tfInput.getPreferredSize().height);

			//---- btnSearch ----
			btnSearch.setText("\u67e5\u8be2");
			btnSearch.addActionListener(e -> btnSearchActionPerformed(e));
			ConsumerContentPane.add(btnSearch);
			btnSearch.setBounds(new Rectangle(new Point(405, 25), btnSearch.getPreferredSize()));

			//======== spList ========
			{

				//---- listResult ----
				listResult.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listResultMouseClicked(e);
					}
				});
				spList.setViewportView(listResult);
			}
			ConsumerContentPane.add(spList);
			spList.setBounds(40, 110, 440, 335);

			//---- cbSort ----
			cbSort.setMaximumRowCount(5);
			cbSort.setModel(new DefaultComboBoxModel<>(new String[] {
				"\u8bc4\u8bba\u6570\u2193",
				"\u8bc4\u8bba\u6570\u2191",
				"\u4ef7\u683c\u2193",
				"\u4ef7\u683c\u2191",
				"\u9500\u91cf\u2193",
				"\u9500\u91cf\u2191"
			}));
			cbSort.addItemListener(e -> cbSortItemStateChanged(e));
			ConsumerContentPane.add(cbSort);
			cbSort.setBounds(new Rectangle(new Point(398, 70), cbSort.getPreferredSize()));

			//---- cbAMAZON ----
			cbAMAZON.setText("\u4e9a\u9a6c\u900a");
			cbAMAZON.addChangeListener(e -> cbAMAZONStateChanged(e));
			ConsumerContentPane.add(cbAMAZON);
			cbAMAZON.setBounds(new Rectangle(new Point(180, 70), cbAMAZON.getPreferredSize()));

			//---- cbDD ----
			cbDD.setText("\u5f53\u5f53\u7f51");
			cbDD.addChangeListener(e -> cbDDStateChanged(e));
			ConsumerContentPane.add(cbDD);
			cbDD.setBounds(260, 70, 59, 21);

			//---- lbPlatform ----
			lbPlatform.setText("\u5e73\u53f0\uff1a");
			ConsumerContentPane.add(lbPlatform);
			lbPlatform.setBounds(new Rectangle(new Point(45, 72), lbPlatform.getPreferredSize()));

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
			Consumer.setSize(525, 525);
			Consumer.setLocationRelativeTo(Consumer.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	public JFrame Consumer;
	private JMenuBar mbConsumer;
	private JMenu mAccount;
	private JMenuItem miConvertToShop;
	private JMenu mSettings;
	private JMenuItem miSettings;
	private JMenuItem miAbout;
	private JCheckBox cbJD;
	private JTextField tfInput;
	private JButton btnSearch;
	private JScrollPane spList;
	private JList listResult;
	private JComboBox<String> cbSort;
	private JCheckBox cbAMAZON;
	private JCheckBox cbDD;
	private JLabel lbPlatform;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
