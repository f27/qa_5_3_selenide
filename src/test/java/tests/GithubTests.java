package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void findSelenideInGtihub() {
        //Откройте страницу Selenide в Github
        open("https://github.com/");
        $(byName("q")).setValue("selenide").pressEnter();
        $("[href='/selenide/selenide'").click();

        //Перейдите в раздел Wiki проекта
        $("[href='/selenide/selenide/wiki'").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions"));

        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5"), text("@ExtendWith"));
    }

}
