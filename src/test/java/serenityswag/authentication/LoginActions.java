package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.mockito.internal.matchers.Find;
import org.openqa.selenium.By;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

        //Looks for elements by DATA CSS type ($ = replaces find)
        $(LoginForm.USER_NAME).sendKeys(user.getUsername());
        $(LoginForm.PASSWORD).sendKeys(user.getPassword());
        $(LoginForm.LOGIN_BUTTON).click();

        //Looks for elements by ID and $ will allow us to use serenity shortcut(#locator)
//        $(("#user-name")).sendKeys(user.getUsername());
//        $(("#password")).sendKeys(user.getPassword());
//        $(("#login-button")).click();

//        //Looks for elements by ID type
//        $(By.id("user-name")).sendKeys(user.getUsername());
//        find(By.id("password")).sendKeys(user.getPassword());
//        find(By.id("login-button")).click();

//        //Looks for elements by NAME
//        $(By.name("user-name")).sendKeys(user.getUsername());
//        find(By.name("password")).sendKeys(user.getPassword());
//        find(By.name("login-button")).click();

        //Looks for elements by CLASS

    }

}
