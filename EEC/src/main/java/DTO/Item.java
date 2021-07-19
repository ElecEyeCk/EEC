package DTO;

import DAO.DAO;
import EEC.EEC;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Item {
    private String ID;
    private String name;
    private String link;
    private String class_;
    private String icons;
    private String comments;
    private double price;
    private String shop;
    private int date;
    private String imgLink;
    private boolean hide;
    private int jump;
    private int detail;

    public static final int COMMENTS_HIGH_TO_LOW = 0;
    public static final int COMMENTS_LOW_TO_HIGH = 1;
    public static final int PRICE_HIGH_TO_LOW = 2;
    public static final int PRICE_LOW_TO_HIGH = 3;

    public Item(String id, String name, String link, String class_, String icons, String commit, double price, String shop, int date, String imgLink, boolean hide, int jump, int detail) {
        ID = id;
        this.name = name;
        this.link = link;
        this.class_ = class_;
        this.icons = icons;
        this.comments = commit;
        this.price = price;
        this.shop = shop;
        this.date = date;
        this.imgLink = imgLink;
        this.hide = hide;
        this.jump = jump;
        this.detail = detail;
    }

    public String getLink() {
        return link;
    }

    public String getClass_() {
        return class_;
    }

    public String getIcons() {
        return icons;
    }

    public String getComments() {
        return comments;
    }

    public double getPrice() {
        return price;
    }

    public String getShop() {
        return shop;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return date;
    }

    public static Item getItem(String name, int date) {
        ArrayList<String> columnLabels = initItemColumnLabels();
        ArrayList<ArrayList<Object>> itemObjs = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity user where name='" + name + "' and date=" + date, columnLabels);
        return AAOtoI(itemObjs, 0);
    }

    public static Item getItemByID(String id, int date) {
        ArrayList<String> columnLabels = initItemColumnLabels();
        ArrayList<ArrayList<Object>> itemObjs = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity user where id=" + id + " and date=" + date, columnLabels);
        return AAOtoI(itemObjs, 0);
    }

    private static ArrayList<String> initItemColumnLabels() {
        ArrayList<String> columnLabels = new ArrayList<>();
        columnLabels.add("name");
        columnLabels.add("adr");
        columnLabels.add("class");
        columnLabels.add("icons");
        columnLabels.add("commit");
        columnLabels.add("price");
        columnLabels.add("shop");
        columnLabels.add("date");
        columnLabels.add("id");
        columnLabels.add("img");
        columnLabels.add("hide");
        return columnLabels;
    }

    public static ArrayList<Item> getItems(String keyword, int sort, int date) {
        ArrayList<String> columnLabels = initItemColumnLabels();
        ArrayList<ArrayList<Object>> result = null;
        if (sort == COMMENTS_LOW_TO_HIGH)
            result = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity where name LIKE '%" + keyword + "%' and date=" + date + " ORDER BY commit ASC", columnLabels);
        else if (sort == COMMENTS_HIGH_TO_LOW)
            result = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity where name LIKE '%" + keyword + "%' and date=" + date + " ORDER BY commit DESC", columnLabels);
        else if (sort == PRICE_LOW_TO_HIGH)
            result = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity where name LIKE '%" + keyword + "%' and date=" + date + " ORDER BY price ASC", columnLabels);
        else if (sort == PRICE_HIGH_TO_LOW)
            result = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity where name LIKE '%" + keyword + "%' and date=" + date + " ORDER BY price DESC", columnLabels);
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < result.get(0).size(); i++) {
            items.add(AAOtoI(result, i));
        }
        return items;
    }

    public static ArrayList<Item> getShopItems(String keyword, int date, String key) {
        ArrayList<String> columnLabels = initItemColumnLabels();
        ArrayList<ArrayList<Object>> result = null;
        if (key == null)
            result = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity where shop='" + keyword + "' and date=" + date + " ORDER BY commit DESC", columnLabels);
        else {
            result = DAO.search("SELECT name,adr,class,icons,commit,price,shop,date,id,img,hide FROM 07commodity where shop='" + keyword + "' and date=" + date + " and name like '%" + key + "%' ORDER BY commit DESC", columnLabels);
        }
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 0; i < result.get(0).size(); i++) {
            items.add(AAOtoI(result, i));
        }
        return items;
    }

    public static String getShopName(String code) {
        ArrayList<Object> names = DAO.search("SELECT name FROM merchant where keycode='" + code + "'", "name");
        if (names.size() == 0) {
            return null;
        } else {
            return (String) names.get(0);
        }
    }

    public static String getShopLink(String name) {
        ArrayList<Object> names = DAO.search("SELECT adr FROM merchant where name='" + name + "'", "adr");
        if (names.size() == 0) {
            return null;
        } else {
            return "https:" + names.get(0);
        }
    }

    private static Item AAOtoI(ArrayList<ArrayList<Object>> AAO, int index) {
        Integer commentsInteger = (Integer) AAO.get(4).get(index);
        String comments = String.valueOf(commentsInteger);
        if (comments.equals("null"))
            comments = "0";
        if (Integer.parseInt(comments) >= 100) {
            comments = AAO.get(4).get(index) + "+";
        }
        String icons = (String) AAO.get(3).get(index);
        if (icons == null || icons.equals("nan"))
            icons = "";
        String picLink = (String) AAO.get(9).get(index);
        if (picLink == null || picLink.equals("0"))
            picLink = "";
        int jump, detail;
        String sql = "SELECT dianji,tiaozhuan FROM product WHERE ID='" + AAO.get(8).get(index) + "'";
        ArrayList<String> columnLabels = new ArrayList<>();
        columnLabels.add("dianji");
        columnLabels.add("tiaozhuan");
        ArrayList<ArrayList<Object>> result = DAO.search(sql, columnLabels);
        jump = (Integer) result.get(1).get(0);
        detail = (Integer) result.get(0).get(0);
        return new Item(
                (String) AAO.get(8).get(index),
                (String) AAO.get(0).get(index),
                (String) AAO.get(1).get(index),
                (String) AAO.get(2).get(index),
                icons,
                comments,
                (Double) AAO.get(5).get(index),
                (String) AAO.get(6).get(index),
                (Integer) AAO.get(7).get(index),
                picLink,
                (Boolean) AAO.get(10).get(index),
                jump,
                detail);
    }

    public static ResultSet getItemPriceHistory(String itemID) {
        String sql = "SELECT price,date FROM 07commodity WHERE ID='" + itemID + "'";
        return DAO.search(sql);
    }

    @Override
    public String toString() {
        return name + ' ' +
                link + ' ' +
                class_ + ' ' +
                icons + ' ' +
                comments + ' ' +
                price + ' ' +
                shop + ' ' +
                date + ' ';
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getID() {
        return ID;
    }

    public static String getID(String name, int date) {
        String sql = "SELECT ID from 07commodity WHERE name='" + name + "' AND date=" + date;
        ArrayList<Object> result = DAO.search(sql, "ID");
        return (String) result.get(0);
    }

    public static void setItemHide(String ID, int bool) {
        String sql = "UPDATE 07commodity SET hide=" + bool + " WHERE ID='" + ID + "'";
        DAO.executeSQL(sql, DAO.UPDATE);
    }

    public boolean getHide() {
        return hide;
    }

    public int getJump() {
        return jump;
    }

    public int getDetail() {
        return detail;
    }

    public static void increaseDetail(Item item) {
        String sql = "UPDATE product SET dianji=" + (item.getDetail() + 1) + " WHERE ID='" + item.getID() + "'";
        DAO.executeSQL(sql, DAO.UPDATE);
    }

    public static void increaseJump(Item item) {
        String sql = "UPDATE product SET tiaozhuan=" + (item.getJump() + 1) + " WHERE ID='" + item.getID() + "'";
        DAO.executeSQL(sql, DAO.UPDATE);
    }

    public static void updatePrice(String ID, double price) {
        String sql = "UPDATE 07commodity SET price=" + price + " WHERE ID='" + ID + "' AND date=" + EEC.newestDate;
        DAO.executeSQL(sql, DAO.UPDATE);
    }

    public void setDetail(int detail) {
        this.detail = detail;
    }
}
