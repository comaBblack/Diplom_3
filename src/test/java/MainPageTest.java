import api.Data;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObj.CabinetPageLokators;
import pageObj.EnterPageLocators;
import pageObj.MainPageLokators;
import pageObj.RegistrationPageLokators;

import static api.DeleteUser.userDelete;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    RegistrationPageLokators regElements;
    EnterPageLocators enterElements;
    MainPageLokators mpElements;
    CabinetPageLokators cElements;

    public void enter(String email, String password){
        enterElements.setEmailInput(email);
        regElements.setPasswordInput(password);
        enterElements.getToEnterButton().click();
    }

    @Before
    public void setUp() {
        //Configuration.browser = "yandex";
        Configuration.browserSize = "1920x1080";
        regElements = open("https://stellarburgers.nomoreparties.site/register", RegistrationPageLokators.class);
        //зарегистрировать пользователя
        regElements.setNameRegInput(faker.name().name());
        regElements.setEmailInput(email);
        regElements.setPasswordInput(password);
        regElements.getRegistrationButton().click();
        mpElements = open("https://stellarburgers.nomoreparties.site/", MainPageLokators.class);
        enterElements = open("https://stellarburgers.nomoreparties.site/", EnterPageLocators.class);
        cElements = open("https://stellarburgers.nomoreparties.site/", CabinetPageLokators.class);
    }

    @After
    public void tearDown() {
        //удаление пользователя
        Data user = Data.builder()
                .email(email)
                .password(password)
                .build();
        userDelete(user);

        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    public void enterFromMainPageTest(){
        //переход на экран логина с главного экрана
        mpElements.getEnterButtonMainPage().click();
        //вход в приложение
        enter(email, password);
        //проверка перехода на главную страницу авторизованного пользователя
        mpElements.getCreateOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void enterFromCabinetTest(){
        //клик по кнопке "Личный кабинет"
        mpElements.getCabinetButton().click();
        //вход в приложение
        enter(email, password);
        //проверка перехода на главную страницу авторизованного пользователя
        mpElements.getCreateOrderButton().shouldBe(visible);
    }
}
