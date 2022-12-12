package Application.Model.Vehicle;
import java.awt.*;
import java.util.ArrayList;

import Application.Model.Vehicle.Types.VehicleType;

public class CarTransporter extends TruckWithRamp{
    private int maxCarCapacity;
    private CarManagement managementObj;
    
    public CarTransporter(int nrDoors, double enginePower, Color color, int maxCarCapacity) {
        super(nrDoors, enginePower, color, "CarTransporter", VehicleType.CARTRANSPORTER);
        this.maxCarCapacity = maxCarCapacity;
        this.managementObj = new CarManagement(maxCarCapacity);
        this.raiseRamp();
    }

    public CarTransporter() {
        super(2, 125, Color.GRAY, "CarTransporter", VehicleType.CARTRANSPORTER);
        this.maxCarCapacity = 4;
        this.managementObj = new CarManagement(this.maxCarCapacity);
        this.raiseRamp();
    }

    @Override
    public void lowerRamp() {
        if (this.isStationary()) {
            super.setRampRaised(false);
        }
    }

    @Override
    public void raiseRamp() {
        if (this.isStationary()) {
            super.setRampRaised(true);
        }
    }

    @Override
    public void gas(double amount) {
        if (super.isRampRaised()){
            super.gas(amount);
        }
    }
    
    public void addCar(Car car){
        if (!super.isRampRaised()) {
            managementObj.addCar(car, this.getXCord(), this.getYCord());
        }
    }
    
    public void unloadCar(Car car) {
        if (!super.isRampRaised()) {
            managementObj.unloadCar(car, this.getXCord(), this.getYCord());
        }
    }

    public ArrayList<Car> getCars() {
        return managementObj.getCars();
    }

    public int getNumLoadedCars() {
        return managementObj.getNumLoadedCars();
    }

    public int getMaxCarCapacity() {
        return managementObj.getMaxCarCapacity();
    }
}