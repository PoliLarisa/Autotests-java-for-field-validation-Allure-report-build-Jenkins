import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AccountTest {

    private final String value;
    private final boolean expectedResult;

    public AccountTest(String value, boolean expectedResult) {
        this.value = value;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Тестовые данные – {0} {1}")
    public static Object[] getParameters() {
        return new Object[][]{
                {"Петр Петров", true}, // Корректное имя
                {"Петр Ииииииииииииии", true}, // Имя из 19ти символов (граничное значение)
                {"М И", true}, // Имя из 3х символов (граничное значение)
                {"Ш ьи", true}, // Имя из 4х символов (внутреннее граничное значение)
                {"Иван Ппппппппппппп", true}, // Имя из 18ти символов (внутреннее граничное значение)
                {" Петр Иванов", false}, // Имя с пробелом в начале
                {"Олег Тюрин ", false}, // Имя с пробелом в конце
                {"Лн", false}, // Имя меньше трех символов
                {"Сергей Ивановскийййййййййййввввввввв", false}, // Имя больше девятнадцати символов
                {"Иван  Рыков", false}, // Имя с двумя пробелами
                {"ТарасРусланов", false}, // Имя без пробелов
                {"", false}, // Пустая строка
                {null, false}, // Имя  null

        };
    }

    @Test
    @DisplayName("Check the name and surname of the bank card")

    public void withParametersTest() {
        Account account = new Account(value);

        boolean actual = account.checkNameToEmboss();

        assertEquals(expectedResult, actual);
    }
}

