package logic;

/**
 * Creates the Belief that the Agent needs to make a tactical move in order to
 * block its opponent.
 * @author 07973435
 */

public class BlockMove extends Belief {

    /**
     * Creates a new instance of BlockMove
     * @param reference to Finite State Machine
     */
    public BlockMove(FiniteStateMachine fsm) {
        super(fsm);
    }

    /**
     * Update the belief that the agent should block a move
     */
    @Override
    public void update() {
        predicate = false;
        rowBlock();
        columnBlock();
        diagonalBlock();
    }

    /**
     * If two of the opponents states can be found within a row, block by
     * placing own state in blank space.
     * @return true if can block, false otherwise
     */
    protected boolean rowBlock() {
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] == CROSS_STATE) {
                counter++;
            }
            if(grid[i][1] == CROSS_STATE) {
                counter++;
            }
            if(grid[i][2] == CROSS_STATE) {
                counter++;
            }
            if(counter == 2 && grid[i][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 0);
                action.setRow(i);
                action.setColumn(0);
            }
            if(counter == 2 && grid[i][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 1);
                action.setRow(i);
                action.setColumn(1);
            }
            if(counter == 2 && grid[i][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 2);
                action.setRow(i);
                action.setColumn(2);
            }
            counter = 0;
        }

        return predicate;
    }
    
    /**
     * If two of the opponents states can be found within a column, block by
     * placing own state in blank space.
     * @return true if can block, false otherwise
     */
    protected boolean columnBlock() {
        int counter = 0;
        for(int j = 0; j < 3; j++) {
            if(grid[0][j] == CROSS_STATE) {
                counter++;
            }
            if(grid[1][j] == CROSS_STATE) {
                counter++;
            }
            if(grid[2][j] == CROSS_STATE) {
                counter++;
            }
            if(counter == 2 && grid[0][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(0);
                action.setColumn(j);
            }
            if(counter == 2 && grid[1][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(1);
                action.setColumn(j);
            }
            if(counter == 2 && grid[2][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(2);
                action.setColumn(j);
            }
            counter = 0;
        }

        return predicate;
    }

    /**
     * If two of the opponents states can be found within a diagonal line, block
     * by placing own state in blank space.
     * @return true if can block, false otherwise
     */
    protected boolean diagonalBlock() {
        int counter = 0;
        if(grid[0][0] == CROSS_STATE) {
            counter++;
        }
        if(grid[1][1] == CROSS_STATE) {
            counter++;
        }
        if(grid[2][2] == CROSS_STATE) {
            counter++;
        }
        if(counter == 2 && grid[0][0] == BLANK_STATE) {
            predicate = true;
            action = new Action(0, 0);
            action.setRow(0);
            action.setColumn(0);
        }
        if(counter == 2 && grid[1][1] == BLANK_STATE) {
            predicate = true;
            action = new Action(1, 1);
            action.setRow(1);
            action.setColumn(1);
        }
        if(counter == 2 && grid[2][2] == BLANK_STATE) {
            predicate = true;
            action = new Action(2, 2);
            action.setRow(2);
            action.setColumn(2);
        }
        counter = 0;
        if(!predicate) {
            counter = 0;
            if(grid[2][0] == CROSS_STATE) {
                counter++;
            }
            if(grid[1][1] == CROSS_STATE) {
                counter++;
            }
            if(grid[0][2] == CROSS_STATE) {
                counter++;
            }
            if(counter == 2 && grid[2][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 0);
                action.setRow(2);
                action.setColumn(0);
            }
            if(counter == 2 && grid[1][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(1, 1);
                action.setRow(1);
                action.setColumn(1);
            }
            if(counter == 2 && grid[0][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 2);
                action.setRow(0);
                action.setColumn(2);
            }
            counter = 0;
        }
        return predicate;
    }

    /**
     * Return required action
     * @return
     */
    @Override
    public Action getAction() {
        return action;
    }
}
