package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void findSelenideInGtihub() {
        open("https://github.com/selenide/selenide");

        $("[href='/selenide/selenide/wiki'").click();
        $("[data-filterable-for=wiki-pages-filter]").$(byLinkText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5"), text("@ExtendWith"));
    }

}
