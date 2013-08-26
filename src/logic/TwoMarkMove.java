package logic;

/**
 * Creates the Belief that the Agent needs to make a tactical move when two
 * marks of the same state have been made.
 * @author 07973435
 */
public class TwoMarkMove extends Belief {

    /**
     * Creates a new instance of TwoMarkMove
     * @param reference to Finite State Machine
     */
    public TwoMarkMove(FiniteStateMachine fsm) {
        super(fsm);
    }

    /**
     * Update the belief that after two marks can be found the Agent
     * should make a tactical move
     */
    @Override
    public void update() {
        predicate = false;
        rowCheck();
        columnCheck();
        diagonalCheck();
        overlayCheck();
        cornerCheck();
        halfCheck();
    }

    /**
     * If the user tries to make a move within the middle, protect self from
     * being in a vulnerable losing position
     * @return predicate
     */
    protected boolean halfCheck() {
        if((grid[0][2] == CROSS_STATE) && (grid[1][0] == CROSS_STATE)) {
            if(grid[0][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 0);
                action.setRow(0);
                action.setColumn(0);
            } else if(grid[2][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 0);
                action.setRow(2);
                action.setColumn(0);
            }
        }
        
        if((grid[1][0] == CROSS_STATE) && (grid[2][2] == CROSS_STATE)) {
            if(grid[0][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 0);
                action.setRow(0);
                action.setColumn(0);
            } else if(grid[2][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 0);
                action.setRow(2);
                action.setColumn(0);
            }
        }

        if((grid[1][2] == CROSS_STATE) && (grid[2][0] == CROSS_STATE)) {
            if(grid[0][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 2);
                action.setRow(0);
                action.setColumn(2);
            }
        }
        
        if((grid[2][0] == CROSS_STATE) && (grid[0][1] == CROSS_STATE)) {
            if(grid[0][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 2);
                action.setRow(0);
                action.setColumn(2);
            }
        }

        if((grid[0][2] == CROSS_STATE) && (grid[2][1] == CROSS_STATE)) {
            if(grid[2][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 0);
                action.setRow(2);
                action.setColumn(0);
            }
        }
        return predicate;
    }

    /**
     * If the user tries to make a move for the corners then protect self
     * @return predicate
     */
    protected boolean cornerCheck() {
        if((grid[0][0] == CROSS_STATE) && (grid[2][2] == CROSS_STATE)) {
            if(grid[1][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(1, 0);
                action.setRow(1);
                action.setColumn(0);
            } else if(grid[0][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 1);
                action.setRow(0);
                action.setColumn(1);
            }
        } else if((grid[2][0] == CROSS_STATE) && (grid[0][2] == CROSS_STATE)) {
            if(grid[1][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(1, 2);
                action.setRow(1);
                action.setColumn(2);
            } else if(grid[2][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 1);
                action.setRow(2);
                action.setColumn(1);
            }
        }
        return predicate;
    }

    /**
     * If the user tries to make a move within the middle protecte self
     * @return predicate
     */
    protected boolean overlayCheck() {
        if((grid[1][0] == CROSS_STATE) && (grid[0][1] == CROSS_STATE)) {
            if(grid[0][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 0);
                action.setRow(0);
                action.setColumn(0);
            }
        }
        if((grid[1][0] == CROSS_STATE) && (grid[2][1] == CROSS_STATE)) {
            if(grid[2][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 0);
                action.setRow(2);
                action.setColumn(0);
            }
        }
        if((grid[2][1] == CROSS_STATE) && (grid[1][2] == CROSS_STATE)) {
            if(grid[2][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 2);
                action.setRow(2);
                action.setColumn(2);
            }
        }
        if((grid[1][2] == CROSS_STATE) && (grid[0][1] == CROSS_STATE)) {
            if(grid[0][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 2);
                action.setRow(0);
                action.setColumn(2);
            }
        }
        return predicate;
    }

    /**
     * If one of both states can be found within a row make a tactical move
     * @return
     */
    protected boolean rowCheck() {
        int x_counter = 0;
        int o_counter = 0;
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] == CROSS_STATE) {
                x_counter++;
            } else if(grid[i][0] == NOUGHT_STATE) {
                o_counter++;
            }
            if(grid[i][1] == CROSS_STATE) {
                x_counter++;
            } else if(grid[i][1] == NOUGHT_STATE) {
                o_counter++;
            }
            if(grid[i][2] == CROSS_STATE) {
                x_counter++;
            } else if(grid[i][2] == NOUGHT_STATE) {
                o_counter++;
            }

            if(x_counter == 1 && o_counter == 1 && grid[i][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 0);
                action.setRow(i);
                action.setColumn(0);
            }

            if(x_counter == 1 && o_counter == 1 && grid[i][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 1);
                action.setRow(i);
                action.setColumn(1);
            }

            if(x_counter == 1 && o_counter == 1 && grid[i][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 2);
                action.setRow(i);
                action.setColumn(2);
            }
            x_counter = 0;
            o_counter = 0;
        }
        return predicate;
    }

    /**
     * If one of both states can be found within a column make a tactical move
     * @return
     */
    protected boolean columnCheck() {
        int x_counter = 0;
        int o_counter = 0;
        for(int j = 0; j < 3; j++) {
            if(grid[0][j] == CROSS_STATE) {
                x_counter++;
            } else if(grid[0][j] == NOUGHT_STATE) {
                o_counter++;
            }
            if(grid[1][j] == CROSS_STATE) {
                x_counter++;
            } else if(grid[1][j] == NOUGHT_STATE) {
                o_counter++;
            }
            if(grid[2][j] == CROSS_STATE) {
                x_counter++;
            } else if(grid[2][j] == NOUGHT_STATE) {
                o_counter++;
            }
            if(x_counter == 1 && o_counter == 1 && grid[0][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(0);
                action.setColumn(j);
            }
            if(x_counter == 1 && o_counter == 1 && grid[1][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(1);
                action.setColumn(j);
            }
            if(x_counter == 1 && o_counter == 1 && grid[2][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(2);
                action.setColumn(j);
            }
            x_counter = 0;
            o_counter = 0;
        }

        return predicate;
    }

    /**
     * If one of both states can be found within a diagonal move make a
     * tactical move
     * @return
     */
    protected boolean diagonalCheck() {
        int x_counter = 0;
        int o_counter = 0;
        if(grid[0][0] == CROSS_STATE) {
            x_counter++;
        } else if(grid[0][0] == NOUGHT_STATE) {
            o_counter++;
        }
        if(grid[1][1] == CROSS_STATE) {
            x_counter++;
        } else if(grid[1][1] == NOUGHT_STATE) {
            o_counter++;
        }
        if(grid[2][2] == CROSS_STATE) {
            x_counter++;
        } else if(grid[2][2] == NOUGHT_STATE) {
            o_counter++;
        }
        if(x_counter == 1 && o_counter == 1 && grid[0][0] == BLANK_STATE) {
            predicate = true;
            action = new Action(0, 0);
            action.setRow(0);
            action.setColumn(0);
        }
        if(x_counter == 1 && o_counter == 1 && grid[1][1] == BLANK_STATE) {
            predicate = true;
            action = new Action(1, 1);
            action.setRow(1);
            action.setColumn(1);
        }
        if(x_counter == 1 && o_counter == 1 && grid[2][2] == BLANK_STATE) {
            predicate = true;
            action = new Action(2, 2);
            action.setRow(2);
            action.setColumn(2);
        }
        x_counter = 0;
        o_counter = 0;
        if(!predicate) {
            x_counter = 0;
            o_counter = 0;
            if(grid[2][0] == CROSS_STATE) {
                x_counter++;
            } else if(grid[2][0] == NOUGHT_STATE) {
                o_counter++;
            }
            if(grid[1][1] == CROSS_STATE) {
                x_counter++;
            } else if(grid[1][1] == NOUGHT_STATE) {
                o_counter++;
            }
            if(grid[0][2] == CROSS_STATE) {
                x_counter++;
            } else if(grid[0][2] == NOUGHT_STATE) {
                o_counter++;
            }
            if(x_counter == 1 && o_counter == 1 && grid[2][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 0);
                action.setRow(2);
                action.setColumn(0);
            }
            if(x_counter == 1 && o_counter == 1 && grid[1][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(1, 1);
                action.setRow(1);
                action.setColumn(1);
            }
            if(x_counter == 1 && o_counter == 1 && grid[0][2] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, 2);
                action.setRow(0);
                action.setColumn(2);
            }
            x_counter = 0;
            o_counter = 0;
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
