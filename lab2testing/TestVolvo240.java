package lab2testing;

import static org.junit.Assert.assertEquals;

import lab2.Car;
import org.junit.*;

import lab2.Volvo240;

public class TestVolvo240 {
    private Volvo240 testVolvo240;

    public TestVolvo240() {
        testVolvo240 = new Volvo240();
    }

    @Test
    public void testGas_Volvo_by_0_5_from_0_should_give_current_speed_0_625() {
        testVolvo240.gas(0.5);
        assertEquals(0.625, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Volvo_by_0_5_from_0_should_be_0() {
        testVolvo240.brake(0.5);
        assertEquals(0, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Volvo_by_0_5_from_0_625_should_be_0() {
        testVolvo240.gas(0.5);
        testVolvo240.brake(0.5);
        assertEquals(0, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testStopEngine_for_Volvo240_should_have_currentSpeed_0() {
        testVolvo240.stopEngine();
        assertEquals(0, testVolvo240.getCurrentSpeed(), 0.1);
    }

    @Test
    public void testSpeedFactor_Volvo240_should_have_speedFactor_1_25() {
        assertEquals(1.25, testVolvo240.speedFactor(), 0.01);
    }

    @Test
    public void testStartEngine_Volvo240_should_have_currentSpeed_0_1() {
        testVolvo240.startEngine();
        assertEquals(0.1, testVolvo240.getCurrentSpeed(), 0.1);
    }
    
    @Test 
    public void testMove_Volvo240_should_have_xCord_0() {
        testVolvo240.gas(2.5);
        testVolvo240.move();
        assertEquals(0, testVolvo240.getXCord(), 0.01);
    }

    @Test 
    public void testMove_Volvo240_should_have_yCord_minus_3_125() {
        testVolvo240.gas(0.5);
        testVolvo240.move();
        assertEquals(-0.625, testVolvo240.getYCord(), 0.01);
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_up_should_have_direction_left() {
        testVolvo240.turnLeft();
        assertEquals(Car.Direction.LEFT, testVolvo240.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo240_is_up_should_have_xChange_minus_1() {
        testVolvo240.turnLeft();
        assertEquals(-1, testVolvo240.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo240_is_up_should_have_yChange_0() {
        testVolvo240.turnLeft();
        assertEquals(0, testVolvo240.getYChange());
    }

        @Test
    public void testTurnLeft_when_direction_for_Volvo_is_left_should_have_direction_down() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(Car.Direction.DOWN, testVolvo240.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_left_should_have_xChange_0() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(0, testVolvo240.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_left_should_have_yChange_1() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(1, testVolvo240.getYChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_down_should_have_direction_right() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(Car.Direction.RIGHT, testVolvo240.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_down_should_have_xChange_1() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(1, testVolvo240.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_down_should_have_yChange_0() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(0, testVolvo240.getYChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_right_should_have_direction_up() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(Car.Direction.UP, testVolvo240.getDirection());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_right_should_have_xChange_0() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(0, testVolvo240.getXChange());
    }

    @Test
    public void testTurnLeft_when_direction_for_Volvo_is_right_should_have_yChange_minus_1() {
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        testVolvo240.turnLeft();
        assertEquals(-1, testVolvo240.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_up_should_have_direction_right() {
        testVolvo240.turnRight();
        assertEquals(Car.Direction.RIGHT, testVolvo240.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_up_should_have_xChange_1() {
        testVolvo240.turnRight();
        assertEquals(1, testVolvo240.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_up_should_have_yChange_0() {
        testVolvo240.turnRight();
        assertEquals(0, testVolvo240.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_right_should_have_direction_down() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(Car.Direction.DOWN, testVolvo240.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_right_should_have_xChange_0() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(0, testVolvo240.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_right_should_have_yChange_1() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(1, testVolvo240.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_down_should_have_direction_left() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(Car.Direction.LEFT, testVolvo240.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_down_should_have_xChange_minus_1() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(-1, testVolvo240.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_down_should_have_yChange_0() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(0, testVolvo240.getYChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_left_should_have_direction_up() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(Car.Direction.UP, testVolvo240.getDirection());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_left_should_have_xChange_0() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(0, testVolvo240.getXChange());
    }

    @Test
    public void testTurnRight_when_direction_for_Volvo_is_left_should_have_yChange_minus_1() {
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        testVolvo240.turnRight();
        assertEquals(-1, testVolvo240.getYChange());
    }

    // Task 4 testing below

    @Test
    public void testGas_Volvo_by_2_5_from_0_should_give_current_speed_0() {
        testVolvo240.gas(2.5);
        assertEquals(0, testVolvo240.getCurrentSpeed(), 0.01);
    }
    
    @Test
    public void testBrake_Volvo_by_2_5_from_0_should_give_current_speed_0() {
        testVolvo240.gas(0.5);
        testVolvo240.brake(2.5);
        assertEquals(0.625, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Volvo_by_2_5_from_0_625_should_give_current_speed_0_625() {
        testVolvo240.gas(0.5);
        testVolvo240.brake(2.5);
        assertEquals(0.625, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Volvo_by_minus_1_5_from_0_625_should_give_current_speed_0_625() {
        testVolvo240.gas(0.5);
        testVolvo240.brake(-1.5);
        assertEquals(0.625, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testGas_Volvo_higher_than_engine_power_should_give_current_speed_engine_power() {
        for (int i=0; i < 300; i++) {
            testVolvo240.gas(0.5);
        }
        assertEquals(testVolvo240.getEnginePower(), testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Volvo_lower_than_engine_power_should_give_current_speed_0() {
        for (int i=0; i < 300; i++) {
            testVolvo240.gas(0.5);
        }
        for (int i=0; i < 400; i++) {
            testVolvo240.brake(0.5);
        }
        assertEquals(0, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testGas_Volvo_by_minus_0_5_from_0_should_give_current_speed_0() {
        testVolvo240.gas(-0.5);
        assertEquals(0, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Volvo_by_minus_0_5_from_0_should_give_current_speed_0() {
        testVolvo240.brake(-0.5);
        assertEquals(0, testVolvo240.getCurrentSpeed(), 0.01);
    }

    @Test
    public void testBrake_Volvo_by_minus_0_5_from_0_625_should_give_current_speed_0_625() {
        testVolvo240.gas(0.5);
        testVolvo240.brake(-0.5);
        assertEquals(0.625, testVolvo240.getCurrentSpeed(), 0.01);
    }
}