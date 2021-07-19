package Utils;

import DAO.DAO;
import DTO.User;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Scanner;

public class Utils {
    public static final String SYSTEM_TEMP_PATH = System.getProperty("java.io.tmpdir");

    public static boolean AUTO_LOGIN = false;
    public static boolean REMEMBER_PASSWORD = false;
    public static int DATE_RANGE = 30;
    public static String PW_REMEMBERED = "";
    public static String AC_REMEMBERED = "";
    public static User USER_REMEMBERED = null;

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

    public static int validateShop(String code) {
        ArrayList<Object> names = DAO.search("SELECT name FROM merchant where keycode='" + code + "'", "name");
        if (names.size() == 0) {
            return EECError.WRONG_CODE;
        } else {
            return EECError.SUCCESS;
        }
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

    public static boolean findID(String account, ArrayList<Object> result) {
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
        ArrayList<Object> result = DAO.search("select distinct date from 07commodity", "date");
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
    public static int setSysClipboardText(String writeMe) {
        try {
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable tText = new StringSelection(writeMe);
            clip.setContents(tText, null);
        } catch (Exception e) {
            EECError.error(EECError.CLIPBOARD_ERROR);
            return EECError.CLIPBOARD_ERROR;
        }
        return EECError.SUCCESS;
    }

    public static void getURLImage(String destUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            fos = new FileOutputStream("c:\\haha.gif");
            while ((size = bis.read(buf)) != -1) {
                fos.write(buf, 0, size);
            }
            fos.flush();
        } catch (IOException e) {
        } catch (ClassCastException e) {
        } finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (IOException e) {
            } catch (NullPointerException e) {
            }
        }
    }

    // 获取URL文本
    public static String getStrByUrl(String urlStr) {
        String res = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //得到输入流
            InputStream inputStream = conn.getInputStream();
            res = readInputStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toString(StandardCharsets.UTF_8);
    }

    // 去掉JSON中的格式文本
    public static String purifyJSON(String JSON) {
        String result = JSON.replace(",", "\n");
        result = result.replace("\"", "");
        result = result.replace("[", "");
        result = result.replace("]", "");
        result = result.replace(":", "：");
        return result;
    }



    public static void setAccountAndPassword(String account, String password) {
        File f = new File(SYSTEM_TEMP_PATH + "/EEC/settings.ini");
        try {
            PrintWriter bw = new PrintWriter(new FileWriter(f, StandardCharsets.UTF_8));
//            bw.println("Show Image:" + SHOW_IMAGE);
            bw.println("Date Range:" + DATE_RANGE);
            bw.println("Remember Password:" + REMEMBER_PASSWORD);
            bw.println("Auto Login:" + AUTO_LOGIN);
            if (REMEMBER_PASSWORD) {
                bw.println("AC:" + account);
                bw.println("PW:" + password);
            }
            bw.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void getSettings() {
        File f = new File(SYSTEM_TEMP_PATH + "/EEC/settings.ini");
        Scanner sc = null;
        PrintWriter bw = null;
        try {
            sc = new Scanner(new FileReader(f, StandardCharsets.UTF_8));
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] strs = str.split(":");
                String attribute = strs[0];
                String data = strs[1];
                switch (attribute) {
                    case "Show Image":
//                        SHOW_IMAGE = Boolean.parseBoolean(data);
                        break;
                    case "Date Range":
                        DATE_RANGE = Integer.parseInt(data);
                        break;
                    case "Remember Password":
                        REMEMBER_PASSWORD = Boolean.parseBoolean(data);
                        break;
                    case "Auto Login":
                        AUTO_LOGIN = Boolean.parseBoolean(data);
                        break;
                    case "PW":
                        if (REMEMBER_PASSWORD)
                            PW_REMEMBERED = data;
                        break;
                    case "AC":
                        if (REMEMBER_PASSWORD)
                            AC_REMEMBERED = data;
                        break;
                }
            }
            if (AUTO_LOGIN)
                USER_REMEMBERED = User.getUser(AC_REMEMBERED);
        } catch (IOException e) {
            try {
                bw = new PrintWriter(new FileWriter(f, StandardCharsets.UTF_8));
                bw.println("Show Image:false");
                bw.println("Date Range:30");
                bw.println("Remember Password:false");
                bw.println("Auto Login:false");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } finally {
                if (bw != null)
                    bw.close();
            }
        } finally {
            if (sc != null)
                sc.close();
        }
    }

    public static String[][] deleteRowFromTwoDimensionsArray(int target, String[][] array) {
        String[][] result = new String[array.length - 1][];
        System.arraycopy(array, 0, result, 0, target);
        for (int i = target; i < array.length - 1; i++) {
            System.arraycopy(array, i + 1, result, i, 1);
        }
        return result;
    }
}
