package mystore.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.By;

public class SortBy implements Task {

    private String order;

    public SortBy (String order){
        this.order = order;
    }

    public static Performable alphabeticalOrderFromA(){
        return Instrumented
                .instanceOf(SortBy.class)
                .withProperties("Product Name: A to Z");
    }

    @Override
    @Step ("{0} sort the produc resoutls using criteria: #order")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(By.id("selectProductSort")),
                SelectFromOptions.byVisibleText(order).from(By.id("selectProductSort")),
                Click.on("//span[@class='cat-name']")
        );
    }
}
