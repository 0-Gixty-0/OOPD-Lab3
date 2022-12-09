package Application.Model.Factories;

import lab.CarTransporter;
import lab.Scania;

public class TruckFactory {
    
    public Scania createScania(){
        Scania scania = new Scania();
        return scania;
    }

    public CarTransporter createCarTransporter(){
        CarTransporter carTransport = new CarTransporter();
        return carTransport;
    } 
}
