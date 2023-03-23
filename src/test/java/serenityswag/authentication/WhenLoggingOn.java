package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn {

    @Managed
    WebDriver driver;
    @Steps
    LoginActions login;
    InventoryPage inventoryPage;

    @Test
    public void usersCanLogOnViaTheHomePage(){
       // driver.get("https://www.saucedemo.com/");

        //Login as a standard user
//        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
//        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
//        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        // Should see product catalog
//        assertThat(driver.findElement(By.cssSelector(".title")).getText())
//                .isEqualToIgnoringCase("Products");

        //Login as a standard user
        login.asAStandardUser();
        // Should see product catalog
        assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products");


    }
}
