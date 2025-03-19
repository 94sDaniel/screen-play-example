package mystore.questions;

import mystore.ui.MyAccountPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TheMyAccountPagge {

    public static Question<String> subtittle() {
        return actor -> Text.of(MyAccountPage.SUBTITTLE).answeredBy(actor).toString();
    }
}
