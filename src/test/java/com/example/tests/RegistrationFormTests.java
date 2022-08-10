package com.example.tests;

import com.example.pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivan.ivanov@example.com")
                .setGender("Male")
                .setNumber("1234567890")
                .setBirthDate("01", "January", "2000")
                .setSubjects("Math")
                .uploadPicture("img.jpg")
                .setHobbies("Sports")
                .setAddress("Main st. 666")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivan.ivanov@example.com")
                .checkResult("Gender","Male")
                .checkResult("Mobile","1234567890")
                .checkResult("Date of Birth", "01 January,2000")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "img.jpg")
                .checkResult("Address", "Main st. 666")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }
}

