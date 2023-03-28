package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class WhenViewingHighlightedProducts {
        @Managed(driver = "chrome")
        WebDriver driver;
        @Steps
        LoginActions login;

        @Steps
        ViewProductDetailsActions viewProductDetails;

        ProductList productList;

        ProductDetails productDetails;

        @Test
        public void shouldDisplayHighLightedProductsOnTheWelcomePage(){
            login.as(User.STANDARD_USER);

            List<String> productsOnDisplay = productList.titles();

            assertThat(productsOnDisplay).hasSize(6)
                                            .contains("Sauce Labs Backpack");
    }

        @Test
        public void highlightedProductsShouldDisplayTheCorrespondingImages(){
            login.as(User.STANDARD_USER);

            List<String> productsOnDisplay = productList.titles();

            //It will not fail immediately, it will fail at the end when assertAll is called
            //If there are two images that don't work, it will report both them
            SoftAssertions softly = new SoftAssertions();
            productsOnDisplay.forEach(
                    productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
            );
            softly.assertAll();;
        }


        @Test
        public void shouldDisplayCorrectProductDetailsPage(){
            login.as(User.STANDARD_USER);

            String firstItemName = productList.titles().get(0);

            viewProductDetails.forProductWithName(firstItemName);

            Serenity.reportThat("The product name should be correctly displayed",
                    () -> assertThat(productDetails.productName()).isEqualTo(firstItemName)
                    );
            Serenity.reportThat("The Product image should have the correct alt text",
                    ()-> productDetails.productImageWithAltValueOf(firstItemName).shouldBeVisible()
                    );
    }




}
