package mystore;

import mystore.actions.LogginWith;
import mystore.questions.TheMyAccountPagge;
import mystore.tasks.Decided;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class WhenUserLogIn {

    Actor actor;

    @Managed
    WebDriver browser;

    @Before
    public void setScenario (){
        actor = Actor.named("Daniel");
        actor.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void signInToMyAccountCorrectly (){
        /*
        Actor registered on the sale platform (ok)
        Actor needs sign in to his account
        Actor can see subtitel My Account
        */

        actor.has(Decided.logWithUserAndPassword());

        actor.attemptsTo(LogginWith.user("dan@a.com").password("12345"));

       actor.should(
                seeThat("Subtittle My Account", TheMyAccountPagge.subtittle(),
                        equalTo("Welcome to your account. Here you can manage all of your personal information and orders." ))
        );
    }
}
