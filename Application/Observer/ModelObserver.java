package Application.Observer;

public interface ModelObserver{
    public void handleEvent(Events.Event e);
    public void update();
}
