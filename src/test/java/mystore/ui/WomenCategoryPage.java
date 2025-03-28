package mystore.ui;

import net.serenitybdd.screenplay.targets.Target;

public class WomenCategoryPage {
    public static Target TITTLE_FIRST_RESOULT = Target.the("First product Tittle")
            .locatedBy("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]");
}
