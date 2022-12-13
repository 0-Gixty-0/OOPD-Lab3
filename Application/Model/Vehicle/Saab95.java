package Application.Model.Vehicle;

import java.awt.*;

import Application.Model.Vehicle.Types.VehicleType;

public class Saab95 extends Car{

    private boolean turboOn;
    
    public Saab95(){
        super(2, 150.0, Color.red, "Saab95", VehicleType.SAAB);
        this.turboOn = false;
        this.positionVehicle(0, 100);
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) {
            turbo = 1.3;
        } 
        return enginePower * 0.01 * turbo;
    }

}
