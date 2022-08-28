package pageObj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageLokators {
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Войти в аккаунт']")
    private SelenideElement enterButtonMainPage;

    @FindBy(how = How.XPATH, using = ".//p[text() = 'Личный Кабинет']")
    private SelenideElement cabinetButton;

    @FindBy(how = How.XPATH, using = ".//span[text() = 'Булки']")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using = ".//h2[text() = 'Булки']")
    private SelenideElement bunsHeader;

    @FindBy(how = How.XPATH, using = ".//span[text() = 'Соусы']")
    private SelenideElement sousesButton;

    @FindBy(how = How.XPATH, using = ".//p[text() = 'Соус традиционный галактический']")
    private SelenideElement souseItem;

    @FindBy(how = How.XPATH, using = ".//span[text() = 'Начинки']")
    private SelenideElement fillingsButton;

    @FindBy(how = How.XPATH, using = ".//p[text() = 'Соус традиционный галактический']")
    private SelenideElement fillingsItem;

    @FindBy(how = How.XPATH, using = ".//p[text() = 'Конструктор']")
    private SelenideElement constractorButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH, using = ".//button[text() = 'Оформить заказ']")
    private SelenideElement createOrderButton;

    public SelenideElement getCreateOrderButton(){
        return createOrderButton;
    }
    public SelenideElement getEnterButtonMainPage(){
        return enterButtonMainPage;
    }
    public SelenideElement getCabinetButton(){
        return cabinetButton;
    }
    public SelenideElement getLogo(){
        return logo;
    }
    public SelenideElement getConstractorButton(){
        return constractorButton;
    }
    public SelenideElement getBunsButton(){
        return bunsButton;
    }
    public SelenideElement getBunsHeader(){
        return bunsHeader;
    }
    public SelenideElement getSousesButton(){
        return sousesButton;
    }
    public SelenideElement getSouseItem(){
        return souseItem;
    }
    public SelenideElement getFillingsButton(){
        return fillingsButton;
    }
    public SelenideElement getFillingsItem(){
        return fillingsItem;
    }
}

