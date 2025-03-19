package mystore.tasks;

import mystore.actions.Browse;
import mystore.constants.Constant;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Decided implements Task {

    public Decided(){

    }

    @Override
    @Step ("{0} decided log in with his account")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Browse.goTo(Constant.SIGN_IN_PAGE)
        );
    }

    public static Performable logWithUserAndPassword() {
        return instrumented(Decided.class);
    }

}
