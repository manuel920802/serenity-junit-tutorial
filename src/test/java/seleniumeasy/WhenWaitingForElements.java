package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.AlertMessagePage;
import seleniumeasy.pageobjects.DynamicDataPage;
import seleniumeasy.pageobjects.ModelDialogPage;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    ModelDialogPage modelDialogPage;

    //Implicit Wait: is the time selenium will wait before it fails (By default is 0)
    //Fluent Wait: is the time selenium will wait before it fails (when using any waitFor functions)
    @Test
    public void waitingForAModalDialog() {
        modelDialogPage.open();

        modelDialogPage.saveChangesButton().shouldNotBeVisible();

        modelDialogPage.openModal();

        modelDialogPage.saveChangesButton().shouldBeVisible();

        modelDialogPage.saveChanges();

        modelDialogPage.saveChangesButton().shouldNotBeVisible();
    }

    AlertMessagePage alertMessagePage;
    @Test
    public void waitingForAMessageToClose() {
        alertMessagePage.open();

        alertMessagePage.openSuccessMessage();

        assertThat(alertMessagePage.alertSuccessMessageText())
                .contains("I'm an autocloseable success message.");

        alertMessagePage.waitForMessageToDisappear();

       alertMessagePage.alertSuccessMessage().shouldNotBeVisible();
    }

    DynamicDataPage dynamicDataPage;
    @Test
    public void waitingForElementsToAppear() {
        dynamicDataPage.open();

        dynamicDataPage.getNewUser();

        assertThat(dynamicDataPage.userDescription())
                .contains("First Name")
                .contains("Last Name");
    }
}
