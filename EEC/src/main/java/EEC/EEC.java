package EEC;

import DTO.User;
import Utils.Utils;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import ui.FormManager;

public class EEC {
    public static User curUser;
    public static int currentDate = Utils.getCurrentDate();
    public static int newestDate = Utils.getNewestDate();

    public static void main(String[] args) {
        FlatGitHubIJTheme.setup();
        Utils.getSettings();
        FormManager.FL.show(true);
    }
}
