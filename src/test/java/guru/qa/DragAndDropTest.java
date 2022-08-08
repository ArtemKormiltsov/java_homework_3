package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1920x1020";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void DragAndDropAction() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @AfterAll
    static void config() {
        Configuration.holdBrowserOpen = false;
    }
}
