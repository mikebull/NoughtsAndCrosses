/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author Mike
 */
public class test extends Belief {
    public test(FiniteStateMachine fsm) {
        super(fsm);
    }

    @Override
    public void update() {
        predicate = false;
        rowCheck();
        columnCheck();
        diagonalCheck();
    }

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

            if(x_counter == 1 || o_counter == 1 && grid[i][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 0);
                action.setRow(i);
                action.setColumn(0);
            }

            if(x_counter == 1 || o_counter == 1 && grid[i][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(i, 1);
                action.setRow(i);
                action.setColumn(1);
            }

            if(x_counter == 1 || o_counter == 1 && grid[i][2] == BLANK_STATE) {
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
            if(x_counter == 1 || o_counter == 1 && grid[0][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(0);
                action.setColumn(j);
            }
            if(x_counter == 1 || o_counter == 1 && grid[1][j] == BLANK_STATE) {
                predicate = true;
                action = new Action(0, j);
                action.setRow(1);
                action.setColumn(j);
            }
            if(x_counter == 1 || o_counter == 1 && grid[2][j] == BLANK_STATE) {
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
        if(x_counter == 1 || o_counter == 1 && grid[0][0] == BLANK_STATE) {
            predicate = true;
            action = new Action(0, 0);
            action.setRow(0);
            action.setColumn(0);
        }
        if(x_counter == 1 || o_counter == 1 && grid[1][1] == BLANK_STATE) {
            predicate = true;
            action = new Action(1, 1);
            action.setRow(1);
            action.setColumn(1);
        }
        if(x_counter == 1 || o_counter == 1 && grid[2][2] == BLANK_STATE) {
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
            if(x_counter == 1 || o_counter == 1 && grid[2][0] == BLANK_STATE) {
                predicate = true;
                action = new Action(2, 0);
                action.setRow(2);
                action.setColumn(0);
            }
            if(x_counter == 1 || o_counter == 1 && grid[1][1] == BLANK_STATE) {
                predicate = true;
                action = new Action(1, 1);
                action.setRow(1);
                action.setColumn(1);
            }
            if(x_counter == 1 || o_counter == 1 && grid[0][2] == BLANK_STATE) {
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

    @Override
    public Action getAction() {
        return action;
    }
}
