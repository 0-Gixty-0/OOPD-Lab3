package lab2testing;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import lab2.Scania;

public class TestScania {
    private Scania scania;

    public TestScania() {
        this.scania = new Scania();
    }

    @Test
    public void testRaiseRamp_from_rampAngle_0_should_give_rampAngle_2() {
        scania.raiseRamp();
        assertEquals(2.0, scania.getRampAngle(), 0.01);
    }

    @Test
    public void testRaiseRamp_from_rampAngle_70_should_give_rampAngle_70() {
        scania.raiseRamp();
        assertEquals(2.0, scania.getRampAngle(), 0.01);
    }

    @Test
    public void testRaiseRamp_while_current_speed_not_0_should_give_rampAngle_0() {
        scania.gas(0.5);
        scania.raiseRamp();
        assertEquals(0, scania.getRampAngle(), 0.01);
    }

    @Test
    public void testLowerRamp_from_rampAngle_30_should_give_rampAngle_28() {
        for (int i = 0; i < 15; i++) {
            scania.raiseRamp();
        }
        scania.lowerRamp();
        assertEquals(28, scania.getRampAngle(), 0.01);
    }
    
    @Test
    public void testLowerRamp_from_rampAngle_0_should_give_rampAngle_0() {
        scania.lowerRamp();
        assertEquals(0, scania.getRampAngle(), 0.01);
    }

    @Test
    public void gas_should_currentSpeed_0_when_isRampRaised_is_true(){
        scania.raiseRamp();
        scania.gas(0.5);
        assertEquals(0, scania.getCurrentSpeed(), 0.01);
    }

    @Test
    public void gas_should_currentSpeed_0_625_when_isRampRaised_is_false(){
        scania.gas(0.5);
        assertEquals(0.625, scania.getCurrentSpeed(), 0.01);

    }

}