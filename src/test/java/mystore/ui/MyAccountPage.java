package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyAccountPage {
    public static final Target SUBTITTLE = Target.the("MyAccount pag subtittle")
            .located(By.cssSelector(".info-account"));
}
