package Application.Model.Factories;

import Application.Model.Vehicle.*;

public class TruckFactory{
    
    public Scania createScania(){
        Scania scania = new Scania();
        return scania;
    }

    public CarTransporter createCarTransporter(){
        CarTransporter carTransport = new CarTransporter();
        return carTransport;
    } 
}
