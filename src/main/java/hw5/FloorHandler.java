package hw5;

public class FloorHandler {
    private Elevator elevator;

    public FloorHandler(Elevator elevator) {
        this.elevator = elevator;
    }

    /**
     * Handles the logic for moving to a new floor. State change, update floor, etc.
     * @param floorNum
     * @return String representing what happened after going to new floor
     */
    public String handleNewFloor(int floorNum) {
        StringBuilder responseString = new StringBuilder();
        if(floorNum > elevator.getCurFloor()) {
            responseString.append("Going up...\n");
        } else {
            responseString.append("Going down...\n");
        }

        elevator.setCurFloor(floorNum);
        responseString.append(String.format("*ding* The elevator arrives at Floor %d\n", floorNum));
        return responseString.toString();
    }
}