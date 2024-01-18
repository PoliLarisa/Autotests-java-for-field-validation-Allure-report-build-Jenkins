public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }


    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        } else return name.length() >= 3 && name.length() <= 19 && name.matches("(\\S+)\\s(\\S+)");
    }
}
