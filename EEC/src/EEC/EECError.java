package EEC;

import javax.swing.*;
import java.util.*;

public class EECError {
    public static final int SUCCESS = 0;

    // 用户操作错误
    public static final int ID_NOT_FOUND = 10001;
    public static final int PASSWORD_ERROR = 10002;
    public static final int ID_EXISTED = 10003;

    // 系统逻辑错误
    public static final int CONNECT_ERROR = 20001;
    public static final int AWT_ERROR = 20002;

    private static Map<Integer, String> map = new HashMap<>();

    public EECError() {
        map.put(ID_NOT_FOUND, "用户名不存在");
        map.put(PASSWORD_ERROR, "密码错误");
        map.put(ID_EXISTED, "用户名已存在");

        map.put(CONNECT_ERROR, "服务器连接失败");
        map.put(AWT_ERROR, "窗口组件错误");
    }

    public static void errorTips(int errorCode) {
        JOptionPane.showMessageDialog(null, map.get(errorCode), "错误代码：" + errorCode, JOptionPane.WARNING_MESSAGE);
    }
}

