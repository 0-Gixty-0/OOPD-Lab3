package Application.Model.Vehicle;

import java.awt.*;

import Application.Model.Vehicle.Types.VehicleType;

public class Car extends Vehicle{
    private boolean isLoaded = false;

    public Car(int nrDoors, double enginePower, Color color, String modelName, VehicleType type){
        super(nrDoors, enginePower, color, modelName, type);
    }

    public boolean getIsLoaded(){
        return isLoaded;
    }
    public void setIsLoaded(boolean b){
        isLoaded = b;
    }
}


