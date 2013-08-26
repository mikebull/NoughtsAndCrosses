package logic;

/**
 * Inherits from Rule and determines whether the game is Drawn by checking
 * if any blank cells remain.
 * @author 07973435
 */

public class GameDrawnRule extends Rule {

    /**
     * Creates a new instance of GameDrawnRule
     * @param reference to Finite State Machine
     */
    public GameDrawnRule(FiniteStateMachine fsm) {
        super(fsm);
        grid = fsm.getGrid();
    }

    /**
     * Does the game drawn rule fire? (implementation of abstract method)
     * Looks for the absence of cells in the blank state
     * @param true if game is drawn, false otherwise
     */
    @Override
    public boolean fire() {
        boolean found = false;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] == FiniteStateMachine.State.blank) {
                    found = true;
                }
            }
        }
        return !found;
    }
}
