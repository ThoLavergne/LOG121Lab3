package observer;

public interface MyObservable {
    public void notifyObservers();
    public void addObserver(MyObserver obs);
    public void removeObserver(MyObserver obs);
}
