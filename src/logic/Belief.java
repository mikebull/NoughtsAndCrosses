package logic;

/**
 * The Belief class determines the agent's selection of its next move within
 * the game by evaluating its beliefs based on the environment.
 * @author 07973435
 */

public abstract class Belief {

    // Some finals for convenience, to save typing
    protected static final FiniteStateMachine.State BLANK_STATE;
    protected static final FiniteStateMachine.State NOUGHT_STATE;
    protected static final FiniteStateMachine.State CROSS_STATE;

    // Boolean to hold truth of belief
    public boolean predicate;

    
    // Reference to enviroment i.e. the grid of cells
    protected FiniteStateMachine.State grid[][];

    // Based on our beliefs, we determine the correct action
    protected Action action;

    /**
     * Creates a new instance of Belief
     * @param fsm
     */
    public Belief(FiniteStateMachine fsm) {
        predicate = false;
        grid = fsm.getGrid();
    }

    /**
     * Is the belief true?
     * @return predicate
     */
    public boolean isTrue() {
        return predicate;
    }

    /**
     * Update the Belief
     */
    public abstract void update();

    /**
     * Get the action as determined from the belief
     * Note: this is null until the Beliefs are updated
     * @return action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Static variables
     */
    static {
        BLANK_STATE = FiniteStateMachine.State.blank;
        NOUGHT_STATE = FiniteStateMachine.State.nought;
        CROSS_STATE = FiniteStateMachine.State.cross;
    }
}
