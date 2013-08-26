package logic;

/**
 * Inherits Rule and determines the environment if a draw arises in the
 * game.
 * @author 07973435
 */

public class DrawRule extends Rule {

    /**
     * Instantiate DrawRule and get grid from Finite State Machine
     * @param fsm
     */
    public DrawRule(FiniteStateMachine fsm) {
        super(fsm);
        grid = fsm.getGrid();
    }
    
    /**
     * Does the rule fire?
     * @return true if rule holds, false otherwise
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
