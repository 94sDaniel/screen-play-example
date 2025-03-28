package mystore.questions;

import mystore.ui.PricipalPage;
import mystore.ui.WomenCategoryPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class WomenPage {

    public static Question <String>  firsTittleProduct(){
        return actor -> Text.of(WomenCategoryPage.TITTLE_FIRST_RESOULT).answeredBy(actor).toString();
    }
}
