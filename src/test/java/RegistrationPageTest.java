import api.Data;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObj.EnterPageLocators;
import pageObj.MainPageLokators;
import pageObj.RegistrationPageLokators;

import static api.DeleteUser.userDelete;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageTest {
    RegistrationPageLokators elements;
    EnterPageLocators locators;
    MainPageLokators mplocators;
    @Before
    public void setUp() {
        //Configuration.browser = "yandex";
        Configuration.browserSize = "1920x1080";
        elements = open("https://stellarburgers.nomoreparties.site/register", RegistrationPageLokators.class);
        locators = open("https://stellarburgers.nomoreparties.site/register", EnterPageLocators.class);
        mplocators = open("https://stellarburgers.nomoreparties.site/register", MainPageLokators.class);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void incorrectPasswordTextTest(){
        elements.setPasswordInput(RandomStringUtils.randomAlphabetic(4));
        elements.getEmailRegInput().click();
        elements.getPasswordError().shouldHave(Condition.exactText("Некорректный пароль"));
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void successfulRegistrationTest(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        elements.setNameRegInput(faker.name().name());
        elements.setEmailInput(email);
        elements.setPasswordInput(password);
        elements.getRegistrationButton().click();
        //проверка перехода на страницу логина
        locators.getEnterHeaderEnterPage().shouldBe(visible);
        //удаление позьвателя
        Data user = Data.builder()
                .email(email)
                .password(password)
                .build();
        userDelete(user);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void enterFromRegistrationPage(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        //зарегистрировать пользователя
        elements.setNameRegInput(faker.name().name());
        elements.setEmailInput(email);
        elements.setPasswordInput(password);
        elements.getRegistrationButton().click();
        //вернуться на страницу регистрации
        locators.getToRegistrateButton().click();
        //перейти на страницу логина
        elements.getEnterButtonRegPage().click();
        //войти в приложение
        locators.setEmailInput(email);
        elements.setPasswordInput(password);
        locators.getToEnterButton().click();
        //проверка перехода на главную страницу авторизованного пользователя
        mplocators.getCreateOrderButton().shouldBe(visible);
        //удаление позьвателя
        Data user = Data.builder()
                .email(email)
                .password(password)
                .build();
        userDelete(user);
    }
}
