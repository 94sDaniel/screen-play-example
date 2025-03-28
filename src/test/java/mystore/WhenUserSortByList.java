package mystore;

import mystore.actions.GoToCategory;
import mystore.actions.LogginWith;
import mystore.actions.SortBy;
import mystore.questions.TheMyAccountPagge;
import mystore.questions.WomenPage;
import mystore.tasks.Decided;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.time.temporal.ChronoUnit;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class WhenUserSortByList {

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

        BrowseTheWeb.as(actor).setImplicitTimeout(20, ChronoUnit.SECONDS);

        actor.has(Decided.logWithUserAndPassword());

        actor.attemptsTo(GoToCategory.women());

        actor.attemptsTo(SortBy.alphabeticalOrderFromA());

        actor.should(seeThat("First alphabtic resoult tittle is blouse",
                WomenPage.firsTittleProduct(),equalTo("Blouse")));
    }
}
