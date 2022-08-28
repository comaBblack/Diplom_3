package pageObj;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPageLokators {
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement nameRegInput;

    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailRegInput;

    @FindBy(how = How.XPATH, using = ".//input[@name = 'Пароль']")
    private SelenideElement passwordInput;

    @FindBy(how = How.XPATH, using = ".//button[text() = 'Зарегистрироваться']")
    private SelenideElement registrationButton;

    @FindBy(how = How.XPATH, using = ".//p[text() = 'Некорректный пароль']")
    private SelenideElement passwordError;

    @FindBy(how = How.XPATH, using = ".//a[text() = 'Войти']")
    private SelenideElement enterButtonRegPage;

    public void setNameRegInput(String name) {
        nameRegInput.shouldBe(Condition.visible).setValue(name);
    }
    public void setEmailInput(String email) {
        emailRegInput.setValue(email);
    }
    public void setPasswordInput(String password) {
        passwordInput.shouldBe(Condition.visible).setValue(password);
    }
    public SelenideElement getPasswordError(){
        return passwordError;
    }
    public SelenideElement getEmailRegInput(){
        return emailRegInput;
    }
    public SelenideElement getRegistrationButton(){
        return registrationButton;
    }
    public SelenideElement getEnterButtonRegPage(){
        return enterButtonRegPage;
    }
}
