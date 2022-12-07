package lab2testing;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import lab2.Saab95;
import lab2.Car;

public class TestSaab95 {
    private Saab95 testSaab95;

    public TestSaab95() {
        testSaab95 = new Saab95();
    }

    @Before
    public void initializeTest() {
        testSaab95 = new Saab95();
    }

    @Test
    public void testGas_Saab_by_0_5_from_0_should_give_current_speed_0_625() {
        testSaab95.gas(0.5);
        assertEquals(0.625, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Saab_by_0_5_from_0_should_be_0() {
        testSaab95.brake(0.5);
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Saab_by_0_5_from_0_625_should_be_0() {
        testSaab95.gas(0.5);
        testSaab95.brake(0.5);
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testSpeedFactor_Saab_with_turbo_on_should_have_speedFactor_1_625() {
        testSaab95.setTurboOn();
        assertEquals(1.625, testSaab95.speedFactor(), 0.01);
    }

    @Test
    public void testStopEngine_for_Saab_should_have_currentSpeed_0() {
        testSaab95.stopEngine();
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testSpeedFactor_Saab_should_have_speedFactor_1_25() {
        assertEquals(1.25, testSaab95.speedFactor(), 0.01);
    }

    @Test
    public void testStartEngine_Saab_should_have_currentSpeed_0_1() {
        testSaab95.startEngine();
        assertEquals(0.1, testSaab95.getCurrentSpeed(), 0.1);
    }

    @Test 
    public void testMove_Saab_should_have_xCord_0() {
        testSaab95.gas(2.5);
        testSaab95.move();
        assertEquals(0, testSaab95.getXCord(), 0.01);
    }

    @Test 
    public void testMove_Saab_should_have_yCord_minus_3_125() {
        testSaab95.gas(0.5);
        testSaab95.move();
        assertEquals(-0.625, testSaab95.getYCord(), 0.01);
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_up_should_have_direction_left() {
        testSaab95.turnLeft();
        assertEquals(Car.Direction.LEFT, testSaab95.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_up_should_have_xChange_minus_1() {
        testSaab95.turnLeft();
        assertEquals(-1, testSaab95.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_up_should_have_yChange_0() {
        testSaab95.turnLeft();
        assertEquals(0, testSaab95.getYChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_left_should_have_direction_down() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(Car.Direction.DOWN, testSaab95.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_left_should_have_xChange_0() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(0, testSaab95.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_left_should_have_yChange_1() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(1, testSaab95.getYChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_down_should_have_direction_right() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(Car.Direction.RIGHT, testSaab95.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_down_should_have_xChange_1() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(1, testSaab95.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_down_should_have_yChange_0() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(0, testSaab95.getYChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_right_should_have_direction_up() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(Car.Direction.UP, testSaab95.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_right_should_have_xChange_0() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(0, testSaab95.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Saab_is_right_should_have_yChange_minus_1() {
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        testSaab95.turnLeft();
        assertEquals(-1, testSaab95.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_up_should_have_direction_right() {
        testSaab95.turnRight();
        assertEquals(Car.Direction.RIGHT, testSaab95.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_up_should_have_xChange_1() {
        testSaab95.turnRight();
        assertEquals(1, testSaab95.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_up_should_have_yChange_0() {
        testSaab95.turnRight();
        assertEquals(0, testSaab95.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_right_should_have_direction_down() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(Car.Direction.DOWN, testSaab95.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_right_should_have_xChange_0() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(0, testSaab95.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_right_should_have_yChange_1() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(1, testSaab95.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_down_should_have_direction_left() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(Car.Direction.LEFT, testSaab95.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_down_should_have_xChange_minus_1() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(-1, testSaab95.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_down_should_have_yChange_0() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(0, testSaab95.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_left_should_have_direction_up() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(Car.Direction.UP, testSaab95.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_left_should_have_xChange_0() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(0, testSaab95.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Saab_is_left_should_have_yChange_minus_1() {
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        testSaab95.turnRight();
        assertEquals(-1, testSaab95.getYChange());
    }

    // Task 4 testing below

    @Test
    public void testGas_Saab_by_2_5_from_0_should_give_current_speed_0() {
        testSaab95.gas(2.5);
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testGas_Saab_by_minus_1_5_from_0_should_give_current_speed_0() {
        testSaab95.gas(-1.5);
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Saab_by_2_5_from_0_625_should_give_current_speed_0_625() {
        testSaab95.gas(0.5);
        testSaab95.brake(2.5);
        assertEquals(0.625, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Saab_by_minus_1_5_from_0_625_should_give_current_speed_0_625() {
        testSaab95.gas(0.5);
        testSaab95.brake(-1.5);
        assertEquals(0.625, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testGas_Saab_higher_than_engine_power_should_give_current_speed_engine_power() {
        for (int i=0; i < 300; i++) {
            testSaab95.gas(0.5);
        }
        assertEquals(testSaab95.getEnginePower(), testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Saab_lower_than_engine_power_should_give_current_speed_0() {
        for (int i=0; i < 300; i++) {
            testSaab95.gas(0.5);
        }
        for (int i=0; i < 400; i++) {
            testSaab95.brake(0.5);
        }
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testGas_Saab_by_minus_0_5_from_0_should_give_current_speed_0() {
        testSaab95.gas(-0.5);
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Saab_by_minus_0_5_from_0_should_give_current_speed_0() {
        testSaab95.brake(-0.5);
        assertEquals(0, testSaab95.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Saab_by_minus_0_5_from_0_625_should_give_current_speed_0_625() {
        testSaab95.gas(0.5);
        testSaab95.brake(-0.5);
        assertEquals(0.625, testSaab95.getCurrentSpeed(), 0.01);
    }
}