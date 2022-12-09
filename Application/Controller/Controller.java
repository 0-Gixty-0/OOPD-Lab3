package Application.Controller;

import Application.Observer.ControllerObserver;
import java.util.ArrayList;

public class Controller {
    private ArrayList<ControllerObserver> controllerObservers;

    public void addObserver(ControllerObserver observer) {
        controllerObservers.add(observer);
    }

    private void notifyObserver() {
        
    }
}