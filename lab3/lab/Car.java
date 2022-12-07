package lab;

import java.awt.*;

public class Car extends Vehicle{
    private boolean isLoaded = false;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
    }

    public boolean getIsLoaded(){
        return isLoaded;
    }
    public void setIsLoaded(boolean b){
        isLoaded = b;
    }
}


