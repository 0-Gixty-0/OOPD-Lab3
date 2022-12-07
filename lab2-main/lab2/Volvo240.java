package lab2;

import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    private String modelName; // The car model name
    
    public Volvo240(){
        super(4, 100.0, Color.black);
        this.modelName = "Volvo240";
    } 

    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}