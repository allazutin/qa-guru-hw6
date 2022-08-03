package com.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com/";

    }

    @Test
    void fillFormTest(){
        open("automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan.ivanov@example.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("2000");
        $(".react-datepicker__month-select").selectOptionContainingText("January");
        $(".react-datepicker__day--022").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img.jpg"));
        $("#currentAddress").setValue("Street");
        $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
        $("#react-select-4-input").setValue("Lucknow").pressEnter();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Ivan"));
        $(".table-responsive").shouldHave(text("Ivanov"));
        $(".table-responsive").shouldHave(text("ivan.ivanov@example.com"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("22 January,2000"));
        $(".table-responsive").shouldHave(text("Physics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("img.jpg"));
        $(".table-responsive").shouldHave(text("Street"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh"));
        $(".table-responsive").shouldHave(text("Lucknow"));
    }
}
