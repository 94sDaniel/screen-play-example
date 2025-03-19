package mystore.actions;

import mystore.ui.LogginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

public class LogginWith implements Task {

    private final String user;
    private final String password;

    public LogginWith (String user, String password){
        this.user = user;
        this.password = password;
    }

    public static LogginWithBuilder user(String user){
        return new LogginWithBuilder(user);
    }

    @Override
    @Step ("{0} loggin to his account with user: #user and password: #password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LogginPage.EMAIL, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(user).into(LogginPage.EMAIL).thenHit(Keys.TAB),
                Enter.theValue(password).into(LogginPage.PASSWORD).thenHit(Keys.TAB),
                Click.on(LogginPage.SIGN_IN_BOTTOM)
        );
    }

    public static class LogginWithBuilder {
        private String user;

        public LogginWithBuilder (String user){
            this.user = user;
        }

        public Performable password (String password){
            return Instrumented.instanceOf(LogginWith.class)
                    .withProperties(user,password);
        }
    }



}
