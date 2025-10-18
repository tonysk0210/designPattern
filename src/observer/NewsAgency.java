package observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String latestHeadline;

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String headline) {
        for (Observer observer : observers) {
            observer.update(headline);
        }
    }

    public void publishNews(String headline) {
        latestHeadline = headline;
        System.out.println("Publishing headline: " + headline);
        notifyObservers(headline);
    }

    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    public String getLatestHeadline() {
        return latestHeadline;
    }
}
