package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PraktikumTest
{
    private final String nameAndSurname;
    private final String expected;


    public PraktikumTest(String nameAndSurname, String expected)
    {
        this.nameAndSurname = nameAndSurname;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тест: \"{0}\" → ожидается {1}")
    public static Object[][] data() {
        return new Object[][] {
                {"Иванов Иван", "true"},
                {" Иванов Иван", "false"},
                {"Иванов Иван ", "false"},
                {"Иванов  Иван", "false"},
                {"Иванов Иван!", "false"},
                {"ИвановИван", "false"},
                {"И В", "true"},
                {"ИВ", "false"},
                {"Иванов Иван Иванович", "false"},
        };
    }

    @DisplayName("Проверка корректности имени и фамилии")
    @Description("Проверяет, соответствует ли формат имени требованиям для чеканки карты")
    @Test
    public void accountNameIsCorrect() {
        Account account = createAccount(nameAndSurname);
        boolean actual = checkName(account);
        verifyResult(expected, actual);
    }

    // === ALlURE STEPS === //

    @Step("Создаем аккаунт с именем: {name}")
    private Account createAccount(String name) {
        return new Account(name);
    }

    @Step("Проверяем имя через метод checkNameToEmboss()")
    private boolean checkName(Account account) {
        return account.checkNameToEmboss();
    }

    @Step("Сравниваем ожидаемый результат: {expected} и фактический: {actual}")
    private void verifyResult(String expected, boolean actual) {
        assertEquals("Некорректная проверка имени", expected, String.valueOf(actual));
    }
}

