package org.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PraktikumTest
    extends TestCase
{
    private final String nameAndSurname;
    private final String expected;


    public PraktikumTest(String nameAndSurname, String expected)
    {
        this.nameAndSurname = nameAndSurname;
        this.expected = expected;
    }

    @Parameterized.Parameters
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

    @Test
    public void AccountNameIsCorrect() {
        Account account = new Account(nameAndSurname);
        assertEquals(expected, String.valueOf(account.checkNameToEmboss()));
    }

}
