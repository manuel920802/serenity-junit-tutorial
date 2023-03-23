package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class LoginActions extends UIInteractionSteps {

    public void asAStandardUser() {
        openUrl("https://www.saucedemo.com/");
        //$ = find
        $("[data-test='username']").sendKeys("standard_user");
        find("[data-test='password']").sendKeys("secret_sauce");
        find("[data-test='login-button']").click();
    }
}
