package ui;

public class Form {
    public boolean showing;


    public Form() {
        showing = false;
    }

    public void show(boolean status) {
        showing = status;
        Form t = this;
        if (this instanceof FormConsumer) {
            ((FormConsumer) t).Consumer.setVisible(status);
        } else if (this instanceof FormSeller) {
            ((FormSeller) t).Seller.setVisible(status);
        } else if (this instanceof FormLogin) {
            ((FormLogin) t).Login.setVisible(status);
        } else if (this instanceof FormDetail) {
            ((FormDetail) t).Detail.setVisible(status);
        } else if (this instanceof FormRegister) {
            ((FormRegister) t).Register.setVisible(status);
        } else if (this instanceof FormSettings) {
            ((FormSettings) t).Settings.setVisible(status);
        } else if (this instanceof FormShopSettings) {
            ((FormShopSettings) t).ShopSettings.setVisible(status);
        }
    }
}
