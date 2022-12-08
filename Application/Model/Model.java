package Application.Model;

import java.util.HashSet;
import java.util.Set;

import Application.Observer.ControllerObserver;
import Application.Observer.Events;
import Application.Observer.IObserver;
import lab.Saab95;
import lab.Vehicle;

public class Model implements ControllerObserver {
    private Set<IObserver> observersSet;
    private Set<Vehicle> vehiclesSet;
    private IFactory carFactory = new CarFactory();
    private IFactory truckFactory = new TruckFactory();

    public Model() {
        this.carFactory = new CarFactory();
        this.truckFactory = new TruckFactory();
        this.observersSet = new HashSet<IObserver>();
        this.vehiclesSet = new HashSet<Vehicle>();
    }

    public void addObserver(IObserver o) {
        observersSet.add(o);
    }

    private void notifyObservers(Events.ModelEvents event) {
        for (IObserver obs : observersSet) {
            obs.handleEvent(event);
        }
    }

    public void run() {
        this.initalizeModel();
    }

    private void initalizeModel() {
        this.initalizeVehicleSet();
    }

    private void initalizeVehicleSet() {
        this.addVehicle(carFactory.createSaab95());
        this.addVehicle(carFactory.volvo240());
        this.addVehicle(truckFactory.createScania());
    }

    private void addVehicle(Vehicle v) {
        vehiclesSet.add(v);
    }

    @Override
    public void handleEvent(Events e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void gas(double amount) {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.gas(amount);
        }
        this.notifyObservers(null);
    }

    @Override
    public void brake(double amount) {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.brake(amount);
        }
        this.notifyObservers(null);
    }

    @Override
    public void turboOn() {
        for (Vehicle vehicle : vehiclesSet) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }
        this.notifyObservers(null);   
    }

    @Override
    public void turboOff() {
        for (Vehicle vehicle : vehiclesSet) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
        }
        this.notifyObservers(null);
    }

    @Override
    public void startCars() {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.startEngine();
        }
        this.notifyObservers(null);
    }

    @Override
    public void turnOffCars() {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.stopEngine();
        }
        this.notifyObservers(Events.ModelEvents.TURNOFFCARSEVENT);
    }



}
