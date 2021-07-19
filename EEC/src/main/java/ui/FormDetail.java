package ui;

import DTO.Item;
import EEC.EEC;
import Utils.EECError;
import Utils.Utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.TimeSeriesPlot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author somnusym
 */
public class FormDetail extends Form {
    private Item currentItem = null;

    public FormDetail() {
        initComponents();
    }

    private void btnHistoryActionPerformed(ActionEvent e) {
        Table history = null;
        try {
            history = Table.read().db(Item.getItemPriceHistory(currentItem.getID()), "07commodity");
        } catch (SQLException throwables) {
            EECError.error(EECError.TABLESAW_ERROR);
        }
        if (history == null) {
            EECError.error(EECError.GET_HISTORY_ERROR);
            return;
        }
        if (history.rowCount() - Utils.DATE_RANGE > 0) {
            int size = history.rowCount() - Utils.DATE_RANGE;
            for (int i = 0; i < size; i++) {
                history = history.dropRows(0);
            }
        }
        Plot.show(
                TimeSeriesPlot.create("历史价格趋势", history, "date", "price"),
                new File(Utils.SYSTEM_TEMP_PATH + "result.html")
        );
    }

    private void btnGoBuyActionPerformed(ActionEvent e) {
        Item.increaseJump(currentItem);
        Utils.openURL("https:" + currentItem.getLink());
        setDetail(Item.getItem(currentItem.getName(), EEC.newestDate));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        Detail = new JFrame();
        lbItemPic = new JLabel();
        taItemName = new JTextArea();
        lbPrice = new JLabel();
        btnHistory = new JButton();
        spDetails = new JScrollPane();
        taDetails = new JTextArea();
        btnGoBuy = new JButton();

        //======== Detail ========
        {
            Detail.setResizable(false);
            Detail.setTitle("\u5546\u54c1\u8be6\u60c5");
            Detail.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/jpg/ICON.jpg"))).getImage());
            Container DetailContentPane = Detail.getContentPane();
            DetailContentPane.setLayout(null);

            //---- lbItemPic ----
            lbItemPic.setVerticalAlignment(SwingConstants.CENTER);
            lbItemPic.setHorizontalAlignment(SwingConstants.CENTER);
            DetailContentPane.add(lbItemPic);
            lbItemPic.setBounds(0, 0, 450, 450);

            //---- taItemName ----
            taItemName.setEditable(false);
            taItemName.setFocusable(false);
            taItemName.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 20));
            taItemName.setText("\u6b63\u5728\u52a0\u8f7d\u5546\u54c1\u540d\u79f0");
            DetailContentPane.add(taItemName);
            taItemName.setBounds(460, 0, 570, 45);
            taItemName.setLineWrap(true);
            taItemName.setWrapStyleWord(true);
            taItemName.setMaximumSize(new Dimension(570, 45));

            //---- label2 ----
            lbPrice.setText("\u4ef7\u683c\uff1a\u00a5正在加载...");
            lbPrice.setFont(new Font("\u7b49\u7ebf", Font.PLAIN, 18));
            lbPrice.setMaximumSize(new Dimension(430, 60));
            lbPrice.setMinimumSize(new Dimension(100, 25));
            lbPrice.setForeground(new Color(255, 51, 51));
            DetailContentPane.add(lbPrice);
            lbPrice.setBounds(new Rectangle(465, 65, 550, lbPrice.getPreferredSize().height));

            //======== spDetails ========
            {
                spDetails.setBorder(null);

                //---- taDetails ----
                taDetails.setEditable(false);
                taDetails.setFocusable(false);
                spDetails.setViewportView(taDetails);
                taDetails.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            }
            DetailContentPane.add(spDetails);
            spDetails.setBounds(460, 90, 570, 435);

            //---- btnHistory ----
            btnHistory.setText("\u67e5\u770b\u5546\u54c1\u5386\u53f2\u4ef7\u683c\u8d8b\u52bf");
            btnHistory.setFocusable(false);
            btnHistory.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 18));
            DetailContentPane.add(btnHistory);
            btnHistory.setBounds(105, 515, 240, btnHistory.getPreferredSize().height);
            btnHistory.addActionListener(this::btnHistoryActionPerformed);

            //---- btnGoBuy ----
            btnGoBuy.setText("\u8df3\u8f6c\u8d2d\u4e70\u94fe\u63a5");
            btnGoBuy.setFocusable(false);
            btnGoBuy.setFont(new Font("\u65b9\u6b63\u7c97\u9ed1\u5b8b\u7b80\u4f53", Font.PLAIN, 18));
            DetailContentPane.add(btnGoBuy);
            btnGoBuy.setBounds(105, 470, 240, 33);
            btnGoBuy.addActionListener(this::btnGoBuyActionPerformed);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for (int i = 0; i < DetailContentPane.getComponentCount(); i++) {
                    Rectangle bounds = DetailContentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = DetailContentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                DetailContentPane.setMinimumSize(preferredSize);
                DetailContentPane.setPreferredSize(preferredSize);
            }
            Detail.setSize(1060, 600);
            Detail.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void setDetail(Item item) {
        currentItem = item;
        JSONObject json;
        String result = Utils.getStrByUrl("http://123.57.42.155:8000/crawler/?url=https:" + item.getLink());
        json = JSON.parseObject(result);
        String detailStr = json.getString("detail");
        String imgURL = json.getString("img");
        imgURL = Utils.purifyJSON(imgURL);
        lbItemPic.setText("<html><img src='https:" + imgURL + "' /></html>");

        taItemName.setText(item.getName());
        taItemName.setBounds(new Rectangle(new Point(460, 10), taItemName.getPreferredSize()));

        String detail = Utils.purifyJSON(detailStr);
        taDetails.setText(detail);
        double rate;
        if (item.getDetail() != 0) {
            rate = 100 * (double) item.getJump() / (double) item.getDetail();
            String sr = String.format("%.2f", rate);
            lbPrice.setText("价格：" + item.getPrice() + "    跳转购买链接率：" + sr + "%(" + item.getJump() + "/" + item.getDetail() + ")");
        } else
            lbPrice.setText("价格：" + item.getPrice() + "    跳转购买链接率：0%");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public JFrame Detail;
    private JLabel lbItemPic;
    private JTextArea taItemName;
    private JLabel lbPrice;
    private JButton btnHistory;
    private JScrollPane spDetails;
    private JTextArea taDetails;
    private JButton btnGoBuy;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
