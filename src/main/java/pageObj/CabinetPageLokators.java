package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CabinetPageLokators {
    @FindBy(how = How.XPATH, using = ".//label[text()='Email']")
    private SelenideElement emailInput;

    @FindBy(how = How.XPATH, using = ".//label[text()='Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement exitButton;

    public SelenideElement getExitButton(){
        return  exitButton;
    }

}
