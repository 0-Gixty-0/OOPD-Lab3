package Application.View;
import Application.Observer.Events;

public interface ModelObserver{
    public void handleEvent(Events.Event e);
    public void update();
}
