package lab2;
import java.awt.*;

public class Scania extends TruckWithRamp{

    public Scania(int nrDoors, double enginePower, Color color) {
        super(nrDoors, enginePower, color);
    }

    public Scania() {
        super(2, 125.0, Color.BLUE);
    }

    @Override
    public void gas(double amount) {
        if (!super.isRampRaised()) {
            super.gas(amount);
        }
    }
}