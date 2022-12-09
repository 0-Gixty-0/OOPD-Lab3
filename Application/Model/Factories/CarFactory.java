package Application.Model.Factories;

public class CarFactory {
    
    public Volvo240 createVolvo240() {
        Volvo240 volvo = new Volvo240();
        return volvo;
    }

    public Saab95 createSaab95() {
        Saab95 saab = new Saab95();
        return saab;
    }
}