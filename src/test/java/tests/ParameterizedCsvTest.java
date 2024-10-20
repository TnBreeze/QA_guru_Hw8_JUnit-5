package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedCsvTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @CsvSource({
            "che, Chemistry",
            "eng, English"
    })

    @ParameterizedTest(name = "Название предмета {1}  по запросу {0}")

    @Tag("BLOCKER")
    void subjectsName(
            String letters,
            String subject
    ) {
        open("/automation-practice-form");
        $("#subjectsInput").setValue(letters);
        $(".subjects-auto-complete__option").shouldHave(text(subject));
    }
}