package logic;

/**
 * The Finite State Machine handles the various states of the Noughts and
 * Crosses game. It acts as a knowledge database holding all possible states,
 * together with the links to possible actions. The Finite State Machine is
 * ideal for this environment because it is static, discrete and deterministic.
 * @author 07973435
 */

public class FiniteStateMachine {
    
    // Represents the three possible values of a cell.
    public enum State {
        blank,
        nought,
        cross
    };

    // Represents row and column index
    protected static final int NUMBER_OF_ROWS = 3;
    protected static final int NUMBER_OF_COLUMNS = 3;

    // Represents the state of cells of game grid
    private State[][] grid;

    /**
     * Creates a new instance of FiniteStateMachine that sets up all of the
     * cells within the grid to blank (start state).
     */
    public FiniteStateMachine() {
        grid = new State[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                // Change state to blank
                grid[i][j] = State.blank;
            }
        }
    }

    /**
     * Updates the state of a cell in the game grid throughout the game.
     * @param row number
     * @param column number
     * @param new cell state
    */
    protected void updateCell(int row, int column, FiniteStateMachine.State state) {
        grid[row][column] = state;
    }

    /**
     * Get the state of a cell in the game grid
     * @param row
     * @param column
     * @return grid
     */
    protected State getCellState(int row, int column) {
        return grid[row][column];
    }
    
    /**
     * Get the entire grid
     * @return reference to grid of states
    */
    protected State[][] getGrid() {
        return grid;
    }
}