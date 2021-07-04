package DTO;

public class Item {
    private String name;
    private String link;
    private String picLink;
    private String icons;
    private int commit;
    private double price;
    private String shop;

    public Item(String name, String link, String picLink, String icons, int commit, double price, String shop) {
        this.name = name;
        this.link = link;
        this.picLink = picLink;
        this.icons = icons;
        this.commit = commit;
        this.price = price;
        this.shop = shop;
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
}
