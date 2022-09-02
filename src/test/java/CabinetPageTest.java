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

public class CabinetPageTest {
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

    @DisplayName("Переход в личный кабинет по клику на 'Личный кабинет'")
    @Test
    public void cabinetEnterTest() {
        //клик по кнопке "Личный кабинет"
        mpElements.getCabinetButton().click();
        //вход в приложение
        enter(email, password);
        //клик по кнопке "Личный кабинет" после авторизации
        mpElements.getCabinetButton().click();
        //проверка перехода на страницу личного кабинета
        cElements.getExitButton().shouldBe(visible);
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу при клике на логотип Stellar Burgers.")
    public void goToMainPageFromLogoTest() {
        mpElements.getCabinetButton().click();
        //вход в приложение
        enter(email, password);
        //клик по кнопке "Личный кабинет"
        mpElements.getCabinetButton().click();
        //клик по лого
        mpElements.getLogo().click();
        //проверка перехода на главный экран
        mpElements.getCreateOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную страницу при клике на 'Конструктор'")
    public void goToMainPageFromConstractorTest() {
        mpElements.getCabinetButton().click();
        //вход в приложение
        enter(email, password);
        //клик по кнопке "Личный кабинет"
        mpElements.getCabinetButton().click();
        //клик по конструктору
        mpElements.getConstractorButton().click();
        //проверка перехода на главный экран
        mpElements.getCreateOrderButton().shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка выход по кнопке «Выйти» в личном кабинете")
    public void exitFromCabinetTest(){
        mpElements.getCabinetButton().click();
        //вход в приложение
        enter(email, password);
        //клик по кнопке "Личный кабинет"
        mpElements.getCabinetButton().click();
        cElements.getExitButton().click();
        //проверка перехода на страницу авторизации
        enterElements.getEnterHeaderEnterPage().shouldBe(visible);
    }
}
