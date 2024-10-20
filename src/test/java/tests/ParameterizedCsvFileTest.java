package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedCsvFileTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @CsvFileSource(resources = "/test_data.csv")

    @ParameterizedTest(name = "Название предмета {1} по запросу {0}")

    @Tags({@Tag("BLOCKER"), @Tag("UI_TEST")})
    void subjectsName(
            String letters,
            String subject
    ) {
        open("/automation-practice-form");
        $("#subjectsInput").setValue(letters);
        $(".subjects-auto-complete__option").shouldHave(text(subject));
    }
}