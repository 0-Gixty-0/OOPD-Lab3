package lab;
import java.util.ArrayList;
import java.lang.Math;

public class CarManagement {

    private int maxCarCapacity;
    private int numLoadedCars;
    private ArrayList<Car> loadedCars;
    
    public CarManagement(int maxCarCapacity) {
        this.maxCarCapacity = maxCarCapacity;
        this.numLoadedCars = 0;
        this.loadedCars = new ArrayList<Car>();

    }

    public void addCar(Car car, double x, double y){
        if (Math.abs(x - car.getXCord()) <= 5.0 && Math.abs(y - car.getYCord()) <= 5.0) {
            if (this.loadedCars.size() < this.maxCarCapacity && !car.getIsLoaded()) {
                loadedCars.add(car);
                numLoadedCars++;
                car.setIsLoaded(true);
            }
        }
    }
    
    public void unloadCar(Car car, double x, double y){
        if(this.loadedCars.size() > 0 && car.getIsLoaded()){
            loadedCars.remove(car);
            car.positionVehicle(x + 5, y + 5);
            numLoadedCars--;
            car.setIsLoaded(false);
        }
    }

    public ArrayList<Car> getCars() {
        return this.loadedCars;
    }

    public int getNumLoadedCars() {
        return this.numLoadedCars;
    }

    public int getMaxCarCapacity() {
        return this.maxCarCapacity;
    }


}
