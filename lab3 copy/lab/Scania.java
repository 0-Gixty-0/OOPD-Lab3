package lab;
import java.awt.*;

import Application.Model.Vehicle.TruckWithRamp;

public class Scania extends TruckWithRamp{

    public Scania(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    public Scania() {
        super(2, 125.0, Color.BLUE, "Scania");
        this.positionVehicle(0, 200);
    }

    @Override
    public void gas(double amount) {
        if (!super.isRampRaised()) {
            super.gas(amount);
        }
    }
}