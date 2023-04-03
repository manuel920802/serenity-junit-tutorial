package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
public class RadioButtonForm extends SeleniumEasyForm {


    public void selectOption(String value) {
        inRadioButtonGroup("optradio").selectByValue(value);
    }

    public void getCheckedValue() {
        $("#buttoncheck").click();
    }

    public String getResult() {
        return $(".radiobutton").getText();
    }
}
