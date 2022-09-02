package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EnterPageLocators {
    @FindBy(how = How.XPATH, using = ".//h2[text() = 'Вход']")
    private SelenideElement enterHeaderEnterPage;
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Зарегистрироваться']")
    private SelenideElement toRegistrateButton;
    @FindBy(how = How.XPATH,using = ".//button[text() = 'Войти']")
    private SelenideElement toEnterButton;
    @FindBy(how = How.XPATH, using = ".//input[@name = 'name']")
    private SelenideElement emailInput;
    public SelenideElement getEnterHeaderEnterPage(){
        return enterHeaderEnterPage;
    }
    public SelenideElement getToRegistrateButton(){
        return toRegistrateButton;
    }
    public SelenideElement getToEnterButton(){
        return toEnterButton;
    }
    public void setEmailInput(String email){
        emailInput.setValue(email);
    }
}
