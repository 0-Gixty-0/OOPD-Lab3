package Application.Model.Vehicle;
import java.awt.*;

import Application.Model.Vehicle.Types.VehicleType;

public class Scania extends TruckWithRamp{

    public Scania(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName, VehicleType.SCANIA);
    }

    public Scania() {
        super(2, 80.0, Color.BLUE, "Scania", VehicleType.SCANIA);
        this.positionVehicle(0, 200);
    }

    @Override
    public void gas(double amount) {
        if (!super.isRampRaised()) {
            super.gas(amount);
        }
    }
}