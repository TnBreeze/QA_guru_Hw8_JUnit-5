package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedValueTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @ValueSource(
            strings = {"ma", "m"}
    )

    @ParameterizedTest(name = "Название предмета Maths по запросу {0}")

    @Tag("BLOCKER")
    void subjectsName(
            String letters
    ) {
        open("/automation-practice-form");
        $("#subjectsInput").setValue(letters);
        $(".subjects-auto-complete__option").shouldHave(text("Maths"));
    }
}