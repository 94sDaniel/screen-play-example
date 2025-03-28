package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PricipalPage {
    public static final  Target CATEGORY_WOMEN = Target.the("Women Category Bottom")
            .located(By.xpath("//a[@title='Women']"));
}
