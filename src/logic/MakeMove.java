package logic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Creates the Belief that the Agent can make a move as long as the game is not
 * lost or drawn by selecting either a random blank square or one of the main
 * tactical squares.
 * @author 07973435
 */

public class MakeMove extends Belief {

    /**
     * Creates a new instance of MakeMove
     * @param reference to Finite State Machine
     */
    public MakeMove(FiniteStateMachine fsm) {
        super(fsm);
    }

    /**
     * Tactically take one of the corner squares if they are blank.
     */
    public void chooseCornerSquare(ArrayList<Action> blanks) {
        boolean isAvailable = true;
        while(isAvailable) {
            Random rand = new Random();
            int index = rand.nextInt(4);
            if(index == 1) {
                if(!(grid[0][0] == BLANK_STATE)) {
                    isAvailable = true;
                } else {
                    action = new Action(0,0);
                    action.setRow(0);
                    action.setColumn(0);
                    isAvailable = false;
                }
            } else if(index == 2) {
                if(!(grid[0][2] == BLANK_STATE)) {
                    isAvailable = true;
                } else {
                    action = new Action(0,2);
                    action.setRow(0);
                    action.setColumn(2);
                    isAvailable = false;
                }
            } else if(index == 3) {
                if(!(grid[2][0] == BLANK_STATE)) {
                    isAvailable = true;
                } else {
                    action = new Action(2,0);
                    action.setRow(2);
                    action.setColumn(0);
                    isAvailable = false;
                }
            } else {
                if(!(grid[2][2] == BLANK_STATE)) {
                    isAvailable = true;
                } else {
                    action = new Action(2,2);
                    action.setRow(2);
                    action.setColumn(2);
                    isAvailable = false;
                }
            }

            if(!(grid[0][0] == BLANK_STATE)) {
                if(!(grid[0][2] == BLANK_STATE)) {
                    if(!(grid[2][0] == BLANK_STATE)) {
                        if(!(grid[2][2] == BLANK_STATE)) {
                            isAvailable = false;
                            generateRandomNumber(blanks);
                        }
                    }
                }
            }
        }
    }

    /**
     * Update the belief that I can make a move,
     * assuming this is always true!
     */
    @Override
    public void update() {
        // Reset belief to default - "I don't believe it!"
        predicate = false;

        // Create a list to hold all potential actions
        // i.e. the current blank cells
        ArrayList<Action> blanks = new ArrayList<Action>();

        // Find the blank cells in the grid
        // Use the Action class for convenience
        for(int i = 0; i < FiniteStateMachine.NUMBER_OF_ROWS; i++) {
                for(int j = 0; j < FiniteStateMachine.NUMBER_OF_COLUMNS; j++) {
                    if(grid[i][j] == BLANK_STATE) {
                        action = new Action(i,j);
                        action.setRow(i);
                        action.setColumn(j);
                        blanks.add(action);
                    }
                }
        }
        
        assert blanks.size( ) > 1 : "There are no blank cells";

        if(grid[1][1] == BLANK_STATE) {
            predicate = true;
            action = new Action(1, 1);
            action.setRow(1);
            action.setColumn(1);
        } else if((grid[1][1] == CROSS_STATE) || (grid[1][1] == NOUGHT_STATE)) {
            chooseCornerSquare(blanks);
            predicate = true;
        } else {
            generateRandomNumber(blanks);
        }
    }

    /**
     * Picks a random square
     * @param blanks
     */
    protected void generateRandomNumber(ArrayList<Action> blanks) {
        // Generate a Random Number
        final int randomNumber = getRandomInRange(1, blanks.size());

        // If there are blanks, randomly choose where to go
        if(blanks.size() > 0) {
            action = (Action)blanks.get(randomNumber);
        }

        // Now I believe it!
        predicate = true;
    }

    /**
     * Get random number in range
     * @param lower bound of range
     * @param upper bound of range
     * @return random number in stated range
    */
    private int getRandomInRange(int lower, int higher) {
        return (int)(Math.floor(Math.random() * (double)(higher - lower - 1)) + (double)lower);
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