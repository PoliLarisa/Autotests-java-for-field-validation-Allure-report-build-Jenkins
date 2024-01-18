public class Practikum {

    public static void main(String[] args) {
        //Тестируемое имя
        String name = "Петр Петров";
        //Создание экземляра класса Account
        Account account = new Account(name);
        //Запуска метода проверки имени
        account.checkNameToEmboss();
    }

}
