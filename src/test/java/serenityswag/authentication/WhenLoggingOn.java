package serenityswag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn {

    @Managed
    WebDriver driver;
    @Steps
    LoginActions login;
    InventoryPage inventoryPage;

    // How to write an action class: Contains different number of methods that performs different actions
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
        login.as(STANDARD_USER);

        Serenity.recordReportData().withTitle("User credentials").andContents("User: " +STANDARD_USER);

        // Should see product catalog
        Serenity.reportThat("The inventory page should be displayed with the correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")
        );
    }
}
