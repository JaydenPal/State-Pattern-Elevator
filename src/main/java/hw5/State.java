package hw5;
/**
 * Interface for State classes that need to be able to handle a press button event on the elevator
 * 
 * @author Jayden Palacios (ubc007) | CS-4773 Fall '23
 */
public interface State {
    public String pressButton(int floorNum);
}