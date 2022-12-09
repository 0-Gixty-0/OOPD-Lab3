package Application.Model.Vehicle;

import java.awt.*;

public class Vehicle implements Movable{
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    private double xCord;
    private double yCord;
    private Direction direction;
    private int xChange;
    private int yChange;
    private boolean isStationary;
    private String modelName;
    //. private String modelName;

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Vehicle(int nrDoors, double enginePower, Color color, String modelname){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.xCord = 0;
        this.yCord = 0;
        this.direction = Direction.RIGHT;
        this.xChange = 1;
        this.yChange = 0;
        this.isStationary = true;
        this.modelName = modelname;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
        isStationary = false;
    }

    public void stopEngine(){
	    currentSpeed = 0;
        isStationary = true;
    }
    
    public double speedFactor(){
        return enginePower * 0.01;
    }

    protected void incrementSpeed(double amount) {
        if (amount <= 1 && amount >= 0) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
    }

    protected void decrementSpeed(double amount){
        if (amount <= 1 && amount >= 0) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
    }
    
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
        isStationary = false;
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
        if (currentSpeed == 0) {
            isStationary = true;
        }
    }

    protected void positionVehicle(double x, double y) {
        this.xCord = x;
        this.yCord = y;
    }

    public double getXCord() {
        return xCord;
    }

    public double getYCord() {
        return yCord;
    }

    public int getXChange() {
        return xChange;
    }

    public int getYChange() {
        return yChange;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public boolean isStationary() {
        return isStationary;
    }

    @Override
    public void move() {
        this.xCord += this.xChange * currentSpeed;
        this.yCord += this.yChange * currentSpeed;
    }

    @Override
    public void turnLeft() {
        switch (this.direction) {
            case UP:
                this.xChange = -1;
                this.yChange = 0;
                this.direction = Direction.LEFT;
                break;
            case DOWN:
                this.xChange = 1;
                this.yChange = 0;
                this.direction = Direction.RIGHT;
                break;
            case LEFT:
                this.xChange = 0;
                this.yChange = 1;
                this.direction = Direction.DOWN;
                break;
            case RIGHT:
                this.xChange = 0;
                this.yChange = -1;
                this.direction = Direction.UP;
                break;
        }
    }

    @Override
    public void turnRight() {
        switch (this.direction) {
            case UP:
                this.xChange = 1;
                this.yChange = 0;
                this.direction = Direction.RIGHT;
                break;
            case DOWN:
                this.xChange = -1;
                this.yChange = 0;
                this.direction = Direction.LEFT;
                break;
            case LEFT:
                this.xChange = 0;
                this.yChange = -1;
                this.direction = Direction.UP;
                break;
            case RIGHT:
                this.xChange = 0;
                this.yChange = 1;
                this.direction = Direction.DOWN;
                break;
        }
    }

    public String getModelName() {
        return this.modelName;
    }
}