package mystore.actions;

import mystore.ui.PricipalPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class GoToCategory implements Task {

    private Target categoryTarget;
    private static String chossenCategory;

    public GoToCategory (Target category){
        this.categoryTarget = category;
    }

    public static Performable women(){
        chossenCategory = "Women Category";
        return Instrumented
                .instanceOf(GoToCategory.class)
                .withProperties(PricipalPage.CATEGORY_WOMEN);
    }

    @Override
    @Step ("{0} want to go to Category: #choosenCategory")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(this.categoryTarget));
    }
}
