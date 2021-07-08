package EEC;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class EECError {
    public static final int SUCCESS = 0;

    // 用户操作错误
    public static final int ID_NOT_FOUND = 10001;
    public static final int WRONG_PASSWORD = 10002;
    public static final int ID_EXISTED = 10003;

    // 系统逻辑错误 --- 一律以ERROR结尾
    public static final int CONNECT_ERROR = 20001;
    public static final int OPEN_URL_ERROR = 20002;
    public static final int MYSQL_OPERATION_ERROR = 20003;

    private static Map<Integer, String> map = new HashMap<>();

    private static void initEECError() {
        map.put(ID_NOT_FOUND, "用户名不存在");
        map.put(WRONG_PASSWORD, "密码错误");
        map.put(ID_EXISTED, "用户名已存在");

        map.put(CONNECT_ERROR, "服务器连接失败！");
        map.put(OPEN_URL_ERROR, "浏览器打开链接失败！");
        map.put(MYSQL_OPERATION_ERROR, "数据库操作失败！");
    }

    public static void error(int errorCode) {
        if (map.isEmpty())
            initEECError();

        if (errorCode == CONNECT_ERROR) {
            System.exit(1);
        }

        JOptionPane.showMessageDialog(null, map.get(errorCode), "错误代码：" + errorCode, JOptionPane.WARNING_MESSAGE);
    }
}

