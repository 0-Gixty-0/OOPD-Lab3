package lab2testing;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import lab2.Saab95;
import lab2.Volvo240;
import lab2.CarTransporter;

public class TestCarTransporter {
    private Volvo240 volvo;
    private Saab95 saab;
    private Volvo240 volvo1;
    private Saab95 saab1;
    private Saab95 saab2;
    private CarTransporter carTransport;
    

    public TestCarTransporter() {
        this.volvo = new Volvo240();
        this.saab = new Saab95();
        this.saab1 = new Saab95();
        this.volvo1 = new Volvo240();
        this.saab2 = new Saab95();
        this.carTransport = new CarTransporter();
    }

    @Test
    public void testLowerRamp_while_stationary_should_give_ramp_raised_false() {
        carTransport.lowerRamp();
        assertEquals(false, carTransport.isRampRaised());
    }

    @Test
    public void testLowerRamp_while_moving_should_give_ramp_raised_true() {
        carTransport.gas(0.5);
        carTransport.lowerRamp();
        assertEquals(true, carTransport.isRampRaised());
    }

    @Test
    public void testRaiseRamp_while_stationary_from_lowered_ramp_should_give_ramp_raised_true() {
        carTransport.lowerRamp();
        carTransport.raiseRamp();
        assertEquals(true, carTransport.isRampRaised());
    }

    @Test
    public void testGas_by_0_5_with_ramp_raised_should_give_currentSpeed_0_625() {
        carTransport.gas(0.5);
        assertEquals(0.625, carTransport.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testGas_by_0_5_with_ramp_lowered_should_give_currentSpeed_0() {
        carTransport.lowerRamp();
        carTransport.gas(0.5);
        assertEquals(0, carTransport.getCurrentSpeed(), 0.01);
    }

    //AddCar tests
    @Test
    public void testAddCar_load_car_with_x_and_y_less_than_5_should_result_in_car_in_loaded_list() {
        saab.gas(0.5);
        saab.move();
        carTransport.lowerRamp();
        carTransport.addCar(saab);
        // assertEquals(true, carTransport.getCars().contains(saab));
        assertEquals(1, carTransport.getNumLoadedCars());
    }

    @Test
    public void testAddCar_load_car_with_x_and_y_more_than_5_should_result_in_car_in_loaded_list() {
        saab.gas(0.5);
        for (int i = 0; i < 11; i++) {
            saab.move();
        }
        carTransport.addCar(saab);
        assertEquals(false, carTransport.getCars().contains(saab));
    }

    @Test
    public void testAddCar_load_5_cars_should_result_in_numLoadedCars_being_4() {
        carTransport.addCar(saab);
        carTransport.addCar(volvo);
        carTransport.addCar(saab1);
        carTransport.addCar(volvo1);
        assertEquals(false, carTransport.getCars().contains(saab));
    }

    @Test
    public void testAddCar_load_same_car_should_result_in_numLoadedCars_being_1() {
        carTransport.lowerRamp();
        carTransport.addCar(saab);
        carTransport.addCar(saab);
        assertEquals(1, carTransport.getNumLoadedCars());
    }
    
    @Test
    public void test_if_getmaxCarCapacity_works(){
        assertEquals(4, carTransport.getMaxCarCapacity(), 0.01);
    }
    
     @Test
    public void test_if_getNumLoadedCars_works(){
        carTransport.lowerRamp();
        carTransport.addCar(saab);
        carTransport.addCar(volvo);
        assertEquals(2, carTransport.getNumLoadedCars(), 0.01);
    }

    //Unload car tests
    @Test
    public void test_if_car_notLoaded_unLoadcar_should_do_nothing(){
        carTransport.lowerRamp();
        carTransport.addCar(saab);
        carTransport.unloadCar(volvo);
        assertEquals(1, carTransport.getNumLoadedCars(), 0.01);
    }
    @Test
    public void test_if_car_isLoaded_unLoadcar_should_remove_car(){
        carTransport.addCar(saab);
        carTransport.unloadCar(saab);
        assertEquals(0, carTransport.getNumLoadedCars(), 0.01);
    }

    @Test
    public void test_if_car_isLoaded_unLoadcar_should_make_car_notloaded(){
        carTransport.addCar(saab);
        carTransport.unloadCar(saab);
        assertEquals(false, saab.getIsLoaded());
    }

    @Test
    public void test_if_car_notLoaded_addCar_should_make_car_isloaded(){
        carTransport.lowerRamp();
        assertEquals(false, saab.getIsLoaded());
        carTransport.addCar(saab);
        assertEquals(true, saab.getIsLoaded());
    }
    @Test
    public void test_if_car_unloaded_get_cordsplus5(){
        carTransport.lowerRamp();
        carTransport.addCar(saab);
        carTransport.unloadCar(saab);
        assertEquals(5, saab.getYCord(), 0.01);
        assertEquals(5, saab.getXCord(), 0.01);
    }
}
