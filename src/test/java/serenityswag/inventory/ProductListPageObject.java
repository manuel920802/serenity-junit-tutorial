package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> titles() {

        return findAll(By.className("inventory_item_name")).textContents();
        // or use serenity shortcut: return findAll(".inventory_item_name").textContents();

    }
    public void openProductDetailsFor(String itemName) {
        find(By.linkText(itemName)).click();

    }
    /*CSS functions
     ^= Starts with
     $= Ends With
     *= Contains Text
     */
    public String imageTextForProduct(String productName) {
        return find(By.xpath(("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img"))).getAttribute("alt");

    }
}
