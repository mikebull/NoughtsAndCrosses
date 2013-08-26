package logic;

/**
 * Creates the Belief that the Agent can win the game by getting three-in-a-row
 * on the condition that there are two in a potential row of three.
 * @author 07973435
 */

public class Win extends Belief {

    /**
     * Creates a new instance of Win
     * @param fsm Finite State Machine
     */
    public Win(FiniteStateMachine fsm) {
        super(fsm);
    }

    /**
     * Update action
     */
    @Override
    public void update() {
        predicate = false;
        rowMatch();
        columnMatch();
        diagonalMatch();
    }

    /**
     * If the environment provides a blank state within a potential row
     * containing two of the Agent's state make a move.
     * @return true if believed, false otherwise
     */
    protected boolean rowMatch() {
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] == NOUGHT_STATE) {
                counter++;
            }
            if(grid[i][1] == NOUGHT_STATE) {
                counter++;
            }
            if(grid[i][2] == NOUGHT_STATE) {
                counter++;
            }
            if(counter == 2 && grid[i][0] == BLANK_STATE) {
                addToAction(i, 0);
            }
            if(counter == 2 && grid[i][1] == BLANK_STATE) {
                addToAction(i, 1);
            }
            if(counter == 2 && grid[i][2] == BLANK_STATE) {
                addToAction(i, 2);
            }
            counter = 0;
        }

        return predicate;
    }

    /**
     * If the environment provides a blank state within a potential column
     * containing two of the Agent's state make a move.
     * @return true if believed, false otherwise
     */
    protected boolean columnMatch() {
        int counter = 0;
        for(int j = 0; j < 3; j++) {
            if(grid[0][j] == NOUGHT_STATE) {
                counter++;
            }
            if(grid[1][j] == NOUGHT_STATE) {
                counter++;
            }
            if(grid[2][j] == NOUGHT_STATE) {
                counter++;
            }
            if(counter == 2 && grid[0][j] == BLANK_STATE) {
                addToAction(0, j);
            }
            if(counter == 2 && grid[1][j] == BLANK_STATE) {
                addToAction(1, j);
            }
            if(counter == 2 && grid[2][j] == BLANK_STATE) {
                addToAction(2, j);
            }
            counter = 0;
        }

        return predicate;
    }

    /**
     * If the environment provides a blank state within a potential diagonal row
     * containing two of the Agent's state make a move.
     * @return true if believed, false otherwise
     */
    protected boolean diagonalMatch() {
        int counter = 0;
        if(grid[0][0] == NOUGHT_STATE) {
            counter++;
        }
        if(grid[1][1] == NOUGHT_STATE) {
            counter++;
        }
        if(grid[2][2] == NOUGHT_STATE) {
            counter++;
        }
        if(counter == 2 && grid[0][0] == BLANK_STATE) {
            addToAction(0, 0);
        }
        if(counter == 2 && grid[1][1] == BLANK_STATE) {
            addToAction(1, 1);
        }
        if(counter == 2 && grid[2][2] == BLANK_STATE) {
            addToAction(2, 2);
        }
        counter = 0;
        if(!predicate) {
            counter = 0;
            if(grid[2][0] == NOUGHT_STATE) {
                counter++;
            }
            if(grid[1][1] == NOUGHT_STATE) {
                counter++;
            }
            if(grid[0][2] == NOUGHT_STATE) {
                counter++;
            }
            if(counter == 2 && grid[2][0] == BLANK_STATE) {
                addToAction(2, 0);
            }
            if(counter == 2 && grid[1][1] == BLANK_STATE) {
                addToAction(1, 1);
            }
            if(counter == 2 && grid[0][2] == BLANK_STATE) {
                addToAction(0, 2);
            }
            counter = 0;
        }
        return predicate;
    }

    /**
     * Reusable method to add values to action
     * @param x
     * @param y
     */
    public void addToAction(int x, int y) {
        predicate = true;
        action = new Action(x, y);
        action.setRow(x);
        action.setColumn(y);
    }

    @Override
    public Action getAction() {
        return action;
    }
}
