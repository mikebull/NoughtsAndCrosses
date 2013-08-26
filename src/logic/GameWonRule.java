package logic;

/**
 * Inherits from Rule. The game is won if the Agent first selects three cells in
 * a straight line, either vertically, horizontally or diagonally.
 * @author 07973435
 */

public class GameWonRule extends Rule {
    // Check if a line is found
    private boolean found;

    /**
     * Creates a new instance of GameWonRule
     * @param fsm
     */
    public GameWonRule(FiniteStateMachine fsm) {
        super(fsm);
        // Get grid array from FSM
        grid = fsm.getGrid();
    }

    /**
     * Does the Game Won Rule fire? (Implementation of abstract method)
     * Checks if a line can be found vertically, horizontally or diagonally.
     * @return true if game is won, false otherwise
     */
    @Override
    public boolean fire() {
        found = false;

        if(rowSet()) {                  // Horizontal Line
            found = true;
        } else if(columnSet()) {        // Vertical Line
            found = true;
        } else if(diagonalSet()) {      // Diagonal Line
            found = true;
        }

        return found;
    }

    /**
     * Checks if a horizontal line can be found in the grid
     * @return true if found, false otherwise
     */
    protected boolean rowSet() {
        boolean check = false;

        if((grid[0][0] == grid[0][1]) && (grid[0][1] == grid[0][2]) && (grid[0][2] != BLANK_STATE)) {
            check = true;
        }

        if((grid[1][0] == grid[1][1]) && (grid[1][1] == grid[1][2]) && (grid[1][2] != BLANK_STATE)) {
            check = true;
        }

        if((grid[2][0] == grid[2][1]) && (grid[2][1] == grid[2][2]) && (grid[2][2] != BLANK_STATE)) {
            check = true;
        }

        return check;
    }

    /**
     * Checks if a vertical line can be found in the grid
     * @return true if found, false otherwise
     */
    protected boolean columnSet() {
        boolean check = false;

        if((grid[0][0] == grid[1][0]) && (grid[1][0] == grid[2][0]) && (grid[1][0] != BLANK_STATE)) {
            check = true;
        }

        if((grid[0][1] == grid[1][1]) && (grid[1][1] == grid[2][1]) && (grid[1][1] != BLANK_STATE)) {
            check = true;
        }

        if((grid[0][2] == grid[1][2]) && (grid[1][2] == grid[2][2]) && (grid[1][2] != BLANK_STATE)) {
            check = true;
        }

        return check;
    }

    /**
     * Checks if a diagonal line can be found in the grid
     * @return true if found, false otherwise
     */
    protected boolean diagonalSet() {
        boolean check = false;

        if((grid[0][0] == grid[1][1]) && (grid[1][1] == grid[2][2]) && (grid[1][1] != BLANK_STATE)) {
            check = true;
        } else if((grid[0][2] == grid[1][1]) && (grid[1][1] == grid[2][0]) && (grid[1][1] != BLANK_STATE)) {
            check = true;
        }
        
        return check;
    }
}
