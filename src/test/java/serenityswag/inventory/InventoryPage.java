package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;

public class InventoryPage extends PageObject {

    public String getHeading() {
      return find(".title").getText();
    }
}
