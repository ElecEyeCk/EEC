package ui;

import java.util.ArrayList;

public class FormManager {
    public static FormConsumer FC = new FormConsumer();
    public static FormSeller FS = new FormSeller();
    public static FormLogin FL = new FormLogin();
    public static FormDetail FD = new FormDetail();
    public static FormRegister FR = new FormRegister();
    public static FormSettings FSe = new FormSettings();
    public static FormShopSettings FSSe = new FormShopSettings();
    public static FormChangePrice FCP = new FormChangePrice();
    private static ArrayList<Form> allForms = new ArrayList<>();

    public static void hideAllForms() {
        if (allForms.isEmpty()) {
            initAllForms();
        }

        for (Form form : allForms) {
            form.show(false);
        }
    }

    private static void initAllForms() {
        allForms.add(FC);
        allForms.add(FS);
        allForms.add(FL);
        allForms.add(FD);
        allForms.add(FR);
        allForms.add(FSe);
        allForms.add(FSSe);
        allForms.add(FCP);
    }
}
