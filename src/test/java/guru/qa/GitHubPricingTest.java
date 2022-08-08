package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubPricingTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1020";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void pricingTestWithHover() {
        open("https://github.com");
        $(".Header-old").$(byText("Pricing")).hover();
        $("ul.list-style-none").$(byText("Compare plans")).click();
        $(".logged-out").shouldHave(text("Choose the plan that’s right for you.")).scrollTo();
    }

    @AfterAll
    static void config() {
        Configuration.holdBrowserOpen = false;
    }

}
