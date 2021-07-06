package DTO;

import DAO.DAO;
import com.kitfox.svg.A;

import java.util.ArrayList;

public class Item {
    private String name;
    private String link;
    private String picLink;
    private String icons;
    private int commit;
    private double price;
    private String shop;
    private String date;

    public Item(String name, String link, String picLink, String icons, int commit, double price, String shop,String date) {
        this.name = name;
        this.link = link;
        this.picLink = picLink;
        this.icons = icons;
        this.commit = commit;
        this.price = price;
        this.shop = shop;
        this.date=date;
    }

    public String getLink() {
        return link;
    }

    public String getPicLink() {
        return picLink;
    }

    public String getIcons() {
        return icons;
    }

    public int getCommit() {
        return commit;
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
    
    public String getDate() {
        return date;
    }
    
    public  Item getItem(String name){
        ArrayList<String> columnLabels = new ArrayList<>();

        columnLabels.add("name");
        columnLabels.add("link");
        columnLabels.add("picLink");
        columnLabels.add("icons");
        columnLabels.add("commit");
        columnLabels.add("price");
        columnLabels.add("shop");
        columnLabels.add("date");
        ArrayList<ArrayList<Object>>  itemObjs = DAO.search("SELECT name,link,picLink,icons,commit,price,shop,date FROM user where name='" + name + "'", columnLabels);
        return new Item((String)itemObjs.get(0).get(0),(String)itemObjs.get(1).get(0),(String)itemObjs.get(2).get(0),(String)itemObjs.get(3).get(0),(Integer)itemObjs.get(4).get(0),(Double) itemObjs.get(5).get(0),(String)itemObjs.get(6).get(0),(String)itemObjs.get(7).get(0));
   }
    
     public ArrayList<ArrayList<Object>> getItem2(String keyword){
        ArrayList<String> columnLabels1 = new ArrayList<>();

        columnLabels1.add("name");
        columnLabels1.add("link");
        columnLabels1.add("picLink");
        columnLabels1.add("icons");
        columnLabels1.add("commit");
        columnLabels1.add("price");
        columnLabels1.add("shop");
        columnLabels1.add("date");
        return DAO.search("SELECT name,link,picLink,icons,commit,price,shop,date FROM user where name LIKE'%" + keyword + "%'", columnLabels1);

    }
}
