package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogginPage {
    public static Target EMAIL = Target.the("EMAIL entry").located(By.id("email"));
    public static Target PASSWORD = Target.the("PASSWORD entry").located(By.id("passwd"));
    public static Target SIGN_IN_BOTTOM = Target.the("SIGN IN BOTTOM").located(By.id("SubmitLogin"));
}
