package lab2;

import java.awt.*;

public class Car extends Vehicle{
    private boolean isLoaded = false;

    public Car(int nrDoors, double enginePower, Color color){
        super(nrDoors, enginePower, color);
    }

    public boolean getIsLoaded(){
        return isLoaded;
    }
    public void setIsLoaded(boolean b){
        isLoaded = b;
    }
}


