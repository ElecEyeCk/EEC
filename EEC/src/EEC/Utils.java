package EEC;

import DAO.DAO;

import java.util.ArrayList;

public class Utils {
    public static int validateLogin(String account, String password) {
        ArrayList<Object> IDs = DAO.search("SELECT ID FROM user", "ID");
        if (!findID(account, IDs))
            return EECError.ID_NOT_FOUND;
        else {
            ArrayList<Object> passwords = DAO.search("SELECT password FROM user where ID='" + account + "'", "password");
            String pw = (String) passwords.get(0);
            if (!pw.equals(password)){
                return EECError.PASSWORD_ERROR;
            }
            else {
                return EECError.SUCCESS;
            }
        }
    }

    public static int validateRegister(String account) {
        ArrayList<Object> IDs = DAO.search("SELECT ID FROM user", "ID");
        if (findID(account, IDs))
            return EECError.ID_EXISTED;
        else
            return EECError.SUCCESS;
    }

    private static boolean findID(String account, ArrayList<Object> result) {
        for (Object obj : result) {
            String uid = (String) obj;
            if (uid.equals(account))
                return true;
        }
        return false;
    }
}
