package lab;

import java.util.ArrayList;

public class CarRepairShop {
    private CarManagement managementObj;
    private double xCord;
    private double yCord;

    public CarRepairShop(double xCord, double yCord, int maxLoad){
        this.xCord = xCord;
        this.yCord = yCord;
        managementObj = new CarManagement(maxLoad);
    }
     public void addCar(Car car){
        managementObj.addCar(car, this.getXCord(), this.getYCord());
    }
    
    public void unloadCar(Car car) {
        managementObj.unloadCar(car, this.getXCord(), this.getYCord());
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

    public double getXCord() {
        return xCord;
    }

    public double getYCord() {
        return yCord;
    }
}