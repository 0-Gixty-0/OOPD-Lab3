package Application.Model;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

import Application.Observer.ControllerObserver;
import Application.Observer.Events;
import Application.Observer.IObserver;
import Application.Model.Vehicle.TruckWithRamp;
import Application.Model.Factories.*;
import Application.Model.Vehicle.Saab95;
import Application.Model.Vehicle.Vehicle;
import Application.Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model implements ControllerObserver{
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle v : vehiclesSet) {
                v.move(); 
            }
        }
    }
    private Set<IObserver> observersSet;
    private Set<Vehicle> vehiclesSet;
    private CarFactory carFactory = new CarFactory();
    private TruckFactory truckFactory = new TruckFactory();
    private int speedChange;
    private Controller controller;
    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());

    public Model(Controller controller) {
        this.carFactory = new CarFactory();
        this.truckFactory = new TruckFactory();
        this.observersSet = new HashSet<IObserver>();
        this.vehiclesSet = new HashSet<Vehicle>();
        this.speedChange = 0;
        this.controller = controller;
        this.initalizeModel();
    }

    public void addObserver(IObserver o) {
        observersSet.add(o);
    }

    private void notifyObservers(Events.Event event) {
        for (IObserver obs : observersSet) {
            obs.handleEvent(event);
        }
    }

    public void run() {
        while (true) {
            this.notifyObservers(Events.Event.UPDATESCREEN);
        }
    }  

    private void initalizeModel() {
        this.initalizeVehicleSet();
    }

    private void initalizeVehicleSet() {
        this.addVehicle(carFactory.createSaab95());
        this.addVehicle(carFactory.createVolvo240());
        this.addVehicle(truckFactory.createScania());
    }

    private void addVehicle(Vehicle v) {
        vehiclesSet.add(v);
    }

    @Override
    public void handleEvent(Events.Event e) {
        switch (e) {
            case SETSPEEDCHANGE:
                speedChange = controller.getSpeedChange();
                break;
            case GASEVENT:
                System.out.println("recieved notification");
                this.gas(speedChange);
                break;
            case BRAKEEVENT:
                this.brake(speedChange);
                break;
            case STARTCARSEVENT:
                this.startCars();
                break;
            case TURNOFFCARSEVENT:
                this.turnOffCars();
                break;
            case TURBOONEVENT:
                this.turboOn();
                break;
			case TURBOOFFEVENT:
                this.turboOff();
				break;
            case LIFTBEDEVENT:
                this.liftBeds();
                break;
            case LOWERBEDEVENT:
                this.lowerBeds();
                break;
			default:
				break;
        }
        
    }

    @Override
    public void lowerBeds() {
        for (Vehicle v : vehiclesSet) {
            if (v instanceof TruckWithRamp)
                ((TruckWithRamp) v).lowerRamp();
        }
	}

    @Override
	public void liftBeds() {
        for (Vehicle v : vehiclesSet) {
            if (v instanceof TruckWithRamp)
                ((TruckWithRamp) v).raiseRamp();
        }
	}

	@Override
    public void gas(double amount) {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.gas(amount);
        }
        this.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void brake(double amount) {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.brake(amount);
        }
        this.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void turboOn() {
        for (Vehicle vehicle : vehiclesSet) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }
        this.notifyObservers(Events.Event.UPDATESCREEN);   
    }

    @Override
    public void turboOff() {
        for (Vehicle vehicle : vehiclesSet) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
        }
        this.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void startCars() {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.startEngine();
        }
        this.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void turnOffCars() {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.stopEngine();
        }
        this.notifyObservers(Events.Event.UPDATESCREEN);
    }

    public Set<Vehicle> getVehiclesSet() {
        return this.vehiclesSet;
    }
}