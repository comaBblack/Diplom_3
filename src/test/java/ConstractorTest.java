import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObj.MainPageLokators;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class ConstractorTest {
    MainPageLokators mpElements;
    @Before
    public void setUp() {
        //Configuration.browser = "yandex";
        Configuration.browserSize = "1920x1080";
        mpElements = open("https://stellarburgers.nomoreparties.site/", MainPageLokators.class);
    }

    @After
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Булки'")
    public void chooseBunsTest(){
        //снять выделение с кнопки Булки, чтобы она стала кликабельной
        mpElements.getFillingsButton().click();
        mpElements.getBunsButton().click();
        mpElements.getBunsHeader().shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Соусы'")
    public void chooseSousesTest(){
        mpElements.getSousesButton().click();
        mpElements.getSouseItem().shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка перехода к разделу 'Начинки'")
    public void chooseFillingsTest(){
        mpElements.getFillingsButton().click();
        mpElements.getFillingsItem().shouldBe(visible);
    }
}
