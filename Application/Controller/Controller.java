package Application.Controller;

import Application.Observer.ControllerObserver;
import java.util.ArrayList;

public class Controller {
    private ArrayList<ControllerObserver> controllerObservers;

    public void addObserver() {
        controllerObservers.add(ControllerObserver obj)
    }

    private void notifyObserver() {
        
    }
}