package hw5;
/**
 * The DoorsOpenState is an implementation of the State interface aimed to represent
 * the elevator state of having its doors open and cotains logic for action events
 * when in this state
 * 
 * @author Jayden Palacios (ubc007) | CS-4773 Fall '23
 */
public class DoorsOpenState implements State {

    private Elevator elevator;
    private FloorHandler floorHandler;

    public DoorsOpenState(Elevator elevator) {
        this.elevator = elevator;
        this.floorHandler = new FloorHandler(elevator);
    }

    /**
     * pressButton returns a string that describes what is happening in the simulation
     * when a button is pressed in this current state. Hanldes logic for chaning state.
     * 
     * @return String representing what happened after button press
     */
    public String pressButton(int floorNum) {
        StringBuilder responseString = new StringBuilder();
        responseString.append(String.format("%d pressed\n", floorNum));

        elevator.setState(elevator.getDoorsClosedState());
        responseString.append("Doors are closed\n");

        if(floorNum == elevator.getCurFloor()) {
            responseString.append("Nothing happens\n");
        } else {
            responseString.append(floorHandler.handleNewFloor(floorNum));
            elevator.setState(elevator.getDoorsOpenState());
            responseString.append("Doors are open\n");
        }

        return responseString.toString();
    }
}