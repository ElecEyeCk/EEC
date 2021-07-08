package DTO;

import DAO.DAO;

import java.util.ArrayList;

public class User {
    private String ID;
    private String shopLink = null;

    public User(String uid) {
        this.ID = uid;
    }

    public User(String uid, String shopLink) {
        this.ID = uid;
        this.shopLink = shopLink;
    }

    public String getID() {
        return ID;
    }

    public String getShopLink() {
        return shopLink;
    }

    public static User getUser(String ID) {
        ArrayList<String> columnLabels = new ArrayList<>();
        columnLabels.add("ID");
        columnLabels.add("shop");
        ArrayList<ArrayList<Object>> userObjs = DAO.search("SELECT ID,shop FROM user where ID='" + ID + "'", columnLabels);
        return new User((String) userObjs.get(0).get(0), (String) userObjs.get(1).get(0));
    }
}
