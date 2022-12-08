package Application.Observer;

public interface ControllerObserver {
    public void handleEvent(Events e);
    public void gas(double amount);
    public void brake(double amount);
    public void turboOn();
    public void turboOff();
    public void startCars();
    public void turnOffCars();
}
