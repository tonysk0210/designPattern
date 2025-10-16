package singleton;

public enum EnumSingleton {
    INSTANCE;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
