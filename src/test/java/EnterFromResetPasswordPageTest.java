import api.Data;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObj.EnterPageLocators;
import pageObj.MainPageLokators;
import pageObj.RegistrationPageLokators;
import pageObj.ResetPasswordPageLokators;

import static api.DeleteUser.userDelete;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class EnterFromResetPasswordPageTest {
    Faker faker = new Faker();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    RegistrationPageLokators regElements;
    EnterPageLocators enterElements;
    ResetPasswordPageLokators resElements;
    MainPageLokators mpElements;
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
        enterElements = open("https://stellarburgers.nomoreparties.site/forgot-password", EnterPageLocators.class);
        resElements = open("https://stellarburgers.nomoreparties.site/forgot-password", ResetPasswordPageLokators.class);
        mpElements = open("https://stellarburgers.nomoreparties.site/forgot-password", MainPageLokators.class);
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
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void enterFromResetPasswordPage(){
        //переход на страницу логина со страницы восстановления пароля
        resElements.getEnterButtonResPassPage().click();
        //вход в приложения
        enterElements.setEmailInput(email);
        regElements.setPasswordInput(password);
        enterElements.getToEnterButton().click();
        //проверка перехода на главную страницу авторизованного пользователя
        mpElements.getCreateOrderButton().shouldBe(visible);
    }
}
