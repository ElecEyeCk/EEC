package EEC;

import DTO.User;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import ui.FormManager;

public class EEC {
    public static User curUser;

    public static void main(String[] args) {
        FlatGitHubIJTheme.setup();
        FormManager.FL.show(true);
    }
}
