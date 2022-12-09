package Application.Model.Factories;

import Application.Model.Vehicle.Saab95;
import Application.Model.Vehicle.Volvo240;

public class CarFactory{
    
    public Volvo240 createVolvo240() {
        Volvo240 volvo = new Volvo240();
        return volvo;
    }

    public Saab95 createSaab95() {
        Saab95 saab = new Saab95();
        return saab;
    }
}