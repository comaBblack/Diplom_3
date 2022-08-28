package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordPageLokators {
    @FindBy(how = How.XPATH, using = ".//a[text() = 'Войти']")
    private SelenideElement enterButtonResPassPage;
    public SelenideElement getEnterButtonResPassPage(){
        return enterButtonResPassPage;
    }
}
