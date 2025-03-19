package mystore.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class Browse implements Interaction {


    @Override
    @Step("{0} browse to a Page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(urlOptions));
    }

    public static Performable goTo(String urlOption) {
        return Instrumented.instanceOf(Browse.class).withProperties(urlOption);
    }

    private final String urlOptions;
    public Browse (String urlOptions){
        this.urlOptions = urlOptions;
    }
}
