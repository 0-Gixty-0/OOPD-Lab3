package Application.Observer;

public interface ControllerObserver extends IObserver{
    public void handleEvent(Events.Event e);
    public void gas(double amount);
    public void brake(double amount);
    public void turboOn();
    public void turboOff();
    public void startCars();
    public void turnOffCars();
    public void liftBeds();
    public void lowerBeds();
}
