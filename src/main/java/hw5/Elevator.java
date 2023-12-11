package hw5;
/**
 * The Elevator class is meant to represent the elevator in our simulation. This class 
 * is the equivalent to the context class in the generic form of the state pattern.
 * Contains info about the elevator's state
 * 
 * @author Jayden Palacios (ubc007) | CS-4773 Fall '23
 */
public class Elevator {
    private int curFloor;
    private State doorsClosedState;
    private State doorsOpenState;
    private State state;

    public Elevator() {
        curFloor = 1;
        doorsClosedState = new DoorsClosedState(this);
        doorsOpenState = new DoorsOpenState(this);
        state = doorsOpenState;
    }

    /**
     * triggers the press button action, called on the elevators current state
     * @param floorNum
     * @return String representing what happened from the button press
     */
    public String handleButtonPress(int floorNum) {
       return state.pressButton(floorNum);
    }

    public int getCurFloor() {
        return curFloor;
    }

    public void setCurFloor(int newFloor) {
        curFloor = newFloor;
    }

    public void setState(State newState) {
        this.state = newState;
    }

    public State getDoorsClosedState() {
        return doorsClosedState;
    }

    public State getDoorsOpenState() {
        return doorsOpenState;
    }
}