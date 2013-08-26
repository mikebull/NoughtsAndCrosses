package logic;

/**
 * The Action class holds both row and column of the grid in order to set states
 * @author 07973435
 */

public class Action {

    // Row and Column number
    private int row;
    private int column;

    /**
     * Constructor for Action
     * @param row
     * @param column
     */
    public Action(int row, int column) {

    }

    /**
     * Getter for Row
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * Setter for Row
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Getter for Column
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Setter for Column
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }
}
