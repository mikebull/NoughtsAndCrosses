package logic;

/**
 * Inherits Rule and determines the environment if a win arises in the
 * game.
 * @author 07973435
 */

public class WinRule extends Rule {

    private boolean found;

    /**
     * Instantiate WinRule and get grid from Finite State Machine
     * @param fsm
     */
    public WinRule(FiniteStateMachine fsm) {
        super(fsm);
        grid = fsm.getGrid();
    }

    /**
     * Does the rule fire?
     * @return true if rule holds, false otherwise
     */
    @Override
    public boolean fire() {
        found = false;

        if(rowSet()) {
            found = true;
        } else if(columnSet()) {
            found = true;
        } else if(diagonalSet()) {
            found = true;
        }

        return found;
    }

    /**
     * Check if states in squares in a row the same and if they are not blank
     * @return true if same, false otherwise
     */
    public boolean rowSet() {
        boolean check = false;

        if(grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][2] != BLANK_STATE) {
            check = true;
        }

        if(grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][2] != BLANK_STATE) {
            check = true;
        }

        if(grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][2] != BLANK_STATE) {
            check = true;
        }

        return check;
    }

    /**
     * Check if states in squares in a column the same and if they are not blank
     * @return true if same, false otherwise
     */
    public boolean columnSet() {
        boolean check = false;

        if(grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[1][0] != BLANK_STATE) {
            check = true;
        }

        if(grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && grid[1][1] != BLANK_STATE) {
            check = true;
        }

        if(grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[1][2] != BLANK_STATE) {
            check = true;
        }

        return check;
    }

    /**
     * Check if states in squares in a diagonal row the same and if they are
     * not blank
     * @return true if same, false otherwise
     */
    public boolean diagonalSet() {
        boolean check = false;

        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            if(grid[1][1] != BLANK_STATE) {
                check = true;
            }
        } else if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[1][1] != BLANK_STATE) {
            check = true;
        }
        
        return check;
    }
}
