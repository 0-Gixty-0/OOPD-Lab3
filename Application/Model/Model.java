package Application.Model;

import java.util.HashSet;
import java.util.Set;
import javax.swing.Timer;

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
    private static Set<IObserver> observersSet = new HashSet<IObserver>();
    private Set<Vehicle> vehiclesSet;
    private CarFactory carFactory = new CarFactory();
    private TruckFactory truckFactory = new TruckFactory();
    private int speedChange;
    private Controller controller;
    private final int delay = 50;

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : vehiclesSet) {
                car.move();
                Model.notifyObservers(Events.Event.UPDATESCREEN);
            }
        }
    }

    public Model(Controller controller) {
        this.carFactory = new CarFactory();
        this.truckFactory = new TruckFactory();
        this.vehiclesSet = new HashSet<Vehicle>();
        this.speedChange = 0;
        this.controller = controller;
        this.initalizeModel();
    }

    public void addObserver(IObserver o) {
        observersSet.add(o);
    }

    static private void notifyObservers(Events.Event event) {
        for (IObserver obs : observersSet) {
            obs.handleEvent(event);
        }
    }

    public void run() {
        Model.notifyObservers(Events.Event.UPDATESCREEN);
    }  

    private void initalizeModel() {
        this.initializeTimer();
        this.initalizeVehicleSet();
    }

    private void initializeTimer() {
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
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
            case GASEVENT:
                speedChange = controller.getSpeedChange();
                this.gas(speedChange);
                break;
            case BRAKEEVENT:
                speedChange = controller.getSpeedChange();
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
            double gas = ((double) amount) / 100;
            vehicle.gas(gas);
        }
        Model.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void brake(double amount) {
        for (Vehicle vehicle : vehiclesSet) {
            double brake = ((double) amount) / 100;
            vehicle.brake(brake);
        }
        Model.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void turboOn() {
        for (Vehicle vehicle : vehiclesSet) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOn();
        }
        Model.notifyObservers(Events.Event.UPDATESCREEN);   
    }

    @Override
    public void turboOff() {
        for (Vehicle vehicle : vehiclesSet) {
            if (vehicle instanceof Saab95)
                ((Saab95) vehicle).setTurboOff();
        }
        Model.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void startCars() {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.startEngine();
        }
        Model.notifyObservers(Events.Event.UPDATESCREEN);
    }

    @Override
    public void turnOffCars() {
        for (Vehicle vehicle : vehiclesSet) {
            vehicle.stopEngine();
        }
        Model.notifyObservers(Events.Event.UPDATESCREEN);
    }

    public Set<Vehicle> getVehiclesSet() {
        return this.vehiclesSet;
    }
}