package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class SoftwareProductTests extends TestBase {

    @BeforeEach
    void setUp() {
        open("https://ppr.ru/");
        Configuration.holdBrowserOpen = true;
    }

    static Stream<Arguments> checkLocaleTest() {
        return Stream.of(
                Arguments.of("EN", List.of("", "Portfolio", "Services", "Clients", "Our partners", "About the group"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Check for the presence of buttons from list {1} on the page in locale {0}")
    void checkLocaleTest(String locale, List<String> buttons) {
        step("Click on the button EN", () -> {
            $(".tolang").$(byText(locale)).click();
        });
        step("Check that the menu has become english elements", () -> {
            $$("#menu ul li").shouldHave(CollectionCondition.texts(buttons));
        });
    }

    @ValueSource(strings = {
            "Пресс-центр", "Проекты", "Услуги и решения", "Наши клиенты", "О группе компаний", "Карьера"})
    @ParameterizedTest(name = "Check for the presence of the element {0} on the main page in the header")
    void checkElementTest(String element) {
        step("Check that the menu has elements", () -> {
            $("#menu").shouldHave(text(element));
        });
    }

    @DisplayName("Check opening VK page when click on VK icon")
    @Test
    void checkYouTubeButton() {
        step("Click on VK icon", () -> {
            $$(".toright a").findBy(href("https://vk.com/programmproduct")).click();
        });
        step("Switch to new page and check URL", () -> {
            switchTo().window(1);
            webdriver().shouldHave(url("https://vk.com/programmproduct"));
        });
    }

    @DisplayName("Check opening P Labs page when click on P Labs icon")
    @Test
    void checkPLabsPage() {
        step("Click on P Labs icon", () -> {
            $$("#menu ul li a").findBy(href("/bigdata/")).click();
        });
        step("Check the P Labs page has '– Платформа для анализа и управления большими данными' text", () -> {
            $(".pp-labs_posterText").shouldHave(text("– Платформа для анализа и управления большими данными"));
        });
    }

    @DisplayName("Check open ratings page from the drop-down menu")
    @Test
    void checkRatingsButton() {
        step("Click on the menu button", () -> {
            $(".menubtn").click();
        });
        step("Click on ratings button and check page has header with 'Рейтинги' text", () -> {
            $("#menubig").$(byText("Рейтинги")).click();
            $("div h1").shouldHave(text("Рейтинги"));
        });
    }

    @DisplayName("Check qa vacancies in Moscow")
    @Test
    void checkVacancyOfQaInMoscow() {
        step("Click on the career button ang check page has 'Карьера в компании' text", () -> {
            $("#menu").$(byText("Карьера")).click();
            $(".global-section").shouldHave(text("Карьера в компании"));
        });
        step("Enter in the form 'qa', select the city Moscow and click on the search button", () -> {
            $("#TITLE_4").setValue("QA");
            $("#city-styler").click();
            $(".jq-selectbox__dropdown").$(byText("Москва")).click();
            $(".wstatic").click();
        });
        step("Check page has 'Специалист по тестированию ПО (Manual)' text", () -> {
            $(".searchplace").shouldHave(text("Специалист по тестированию ПО (Manual)"));
        });
    }

    @DisplayName("Check 'contacts' button in the footer page")
    @Test
    void checkContactsButtonInFooterOfPage() {
        step("Click on the 'about the group of companies' button in the right menu", () -> {
            $$("#pp-nav ul li a").findBy(href("#about")).click();
        });
        step("Check page has '© 2021 Все права защищены, ООО «Программный Продукт»' text", () -> {
            $("#footerblock").shouldHave(text("© 2021 Все права защищены, ООО «Программный Продукт»"));
        });
        step("Click on the 'Контакты' button and check page has 'Наши контакты' text", () -> {
            $("#footerblock").$(byText("Контакты")).click();
            $(".circle").shouldHave(text("Наши контакты"));
        });
    }
}
