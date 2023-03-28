package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.SoftAssertions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.authentication.User;
import serenityswag.cart.AddToCartActions;
import serenityswag.cart.ShoppingCartBadge;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    ProductList productList;

    @Before
    public void login(){
        login.as(STANDARD_USER);
    }

    ShoppingCartBadge shoppingCartBadge;

    @Steps
    AddToCartActions addToCart;

    @Test
    public void theCorrectItemCountShouldBeShown() {
        //Check the shopping cart badge is empty
        Serenity.reportThat("The shopping cart badge should be empty",
                () ->assertThat(shoppingCartBadge.count()).isEmpty()
                );

        //Add 1 item to the cart
        addToCart.item("Sauce Labs Backpack");

        //The Shopping cart badge should be "1"
        Serenity.reportThat("The shopping cart badge should now be '1' ",
                () -> assertThat(shoppingCartBadge.count()).isEqualTo("1")
                );
    }

    @Test
    public void allTheItemsShouldAppearInTheCart() {


    }
}
