package observer;

public class NewsChannel implements Observer {
    private final String name;
    private String latestHeadline;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String headline) {
        latestHeadline = headline;
        System.out.println(name + " received update: " + headline);
    }

    public String getLatestHeadline() {
        return latestHeadline;
    }

    public String getName() {
        return name;
    }
}
