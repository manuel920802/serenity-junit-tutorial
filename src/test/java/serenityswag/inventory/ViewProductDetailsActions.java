package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class ViewProductDetailsActions extends UIInteractionSteps {

    @Step("View Products Details for Product '{0}'")
    public void forProductWithName(String firstItemName) {
    $(ProductList.productDetailsLinkFor(firstItemName)).click();
    }
}
