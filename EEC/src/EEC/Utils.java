package EEC;

import DAO.DAO;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

public class Utils {
    // 数据库验证登录
    public static int validateLogin(String account, String password) {
        ArrayList<Object> IDs = DAO.search("SELECT ID FROM user", "ID");
        if (!findID(account, IDs))
            return EECError.ID_NOT_FOUND;
        else {
            ArrayList<Object> passwords = DAO.search("SELECT password FROM user where ID='" + account + "'", "password");
            String pw = (String) passwords.get(0);
            if (!pw.equals(password)) {
                return EECError.WRONG_PASSWORD;
            } else {
                return EECError.SUCCESS;
            }
        }
    }

    // 数据库验证注册
    public static int validateRegister(String account) {
        ArrayList<Object> IDs = DAO.search("SELECT ID FROM user", "ID");
        if (findID(account, IDs))
            return EECError.ID_EXISTED;
        else
            return EECError.SUCCESS;
    }

    // 在数据库中注册用户
    public static int register(String ID, String password, String shopLink) {
        String sql = "INSERT INTO user (ID,password,shop) VALUES ('" + ID + "','" + password + "','" + shopLink + "')";
        return DAO.executeSQL(sql, DAO.INSERT);
    }

    // 更新user数据库记录中的shop字段
    public static int updateShop(String shopLink, String ID) {
        String sql = "UPDATE user SET shop='" + shopLink + "' where ID='" + ID + "'";
        return DAO.executeSQL(sql, DAO.UPDATE);
    }

    private static boolean findID(String account, ArrayList<Object> result) {
        for (Object obj : result) {
            String uid = (String) obj;
            if (uid.equals(account))
                return true;
        }
        return false;
    }

    // 使JTable自动适应列宽
    public static void fitTableColumns(JTable myTable, String[] ignoredColumnLabels) {
        JTableHeader header = myTable.getTableHeader();
        int rowCount = myTable.getRowCount();
        int sum = 0;
        Enumeration<TableColumn> columns = myTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            boolean flag = false;
            TableColumn column = columns.nextElement();
            for (String str : ignoredColumnLabels)
                if (column.getHeaderValue().equals(str)) {
                    flag = true;
                    sum += column.getWidth();
                    break;
                }
            if (flag) continue;
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) myTable.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(myTable, column.getIdentifier(), false, false, -1, col)
                    .getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferredWidth = (int) myTable.getCellRenderer(row, col)
                        .getTableCellRendererComponent(myTable, myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferredWidth);
            }
            header.setResizingColumn(column);
            int fixedW = myTable.getIntercellSpacing().width;
            column.setWidth(width + fixedW + 5);
            sum += column.getWidth();
        }
        if (sum < myTable.getWidth())
            myTable.getColumnModel().getColumn(0).setWidth(myTable.getWidth() - sum + myTable.getColumnModel().getColumn(0).getWidth());
    }

    // 获取当前程序运行日期
    public static int getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        return Integer.parseInt(df.format(new Date()));// new Date()为获取当前系统时间
    }

    // 获取服务器中商品信息最新日期
    public static int getNewestDate() {
        ArrayList<Object> result = DAO.search("select date from date", "date");
        int max = 0;
        for (Object obj : result) {
            int date = (Integer) obj;
            max = Math.max(date, max);
        }
        return max;
    }

    // 调用系统浏览器打开链接
    public static void openURL(String url) {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } catch (IOException ioException) {
            EECError.error(EECError.OPEN_URL_ERROR);
        }
    }

    // 复制文本到指定剪切板
    public static void setSysClipboardText(String writeMe) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(writeMe);
        clip.setContents(tText, null);
    }
}
