package DAO;

import EEC.EECError;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;

public class DAO {
    private static final String IP = "123.57.42.155";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://" + IP + ":3306/EEC?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "Somnusym1";

    public static ArrayList<Object> search(String sql, String columnLabel) {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<Object> result = new ArrayList<>();
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(rs.getObject(columnLabel));
            }

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<Object>> search(String sql, ArrayList<String> columnLabels) {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<ArrayList<Object>> result = new ArrayList<>();
        for (int i = 0; i < columnLabels.size(); i++) {
            result.add(new ArrayList<>());
        }

        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (Exception e) {
                EECError.errorTips(EECError.CONNECT_ERROR);
            }

            // 执行查询
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                for (int j = 0; j < columnLabels.size(); j++) {
                    String columnLabel = columnLabels.get(j);
                    result.get(j).add(rs.getObject(columnLabel));
                }
            }

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException ignored) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }
}
