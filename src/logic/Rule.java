package logic;

/**
 * Abstract class containing all methods and attributes common to each 
 * rule. By encompassing the common rules within this class it is easier to
 * add new rules when needed.
 * @author 07973435
 */

public abstract class Rule {

    // Get states from FSM
    protected static final FiniteStateMachine.State BLANK_STATE;
    protected static final FiniteStateMachine.State NOUGHT_STATE;
    protected static final FiniteStateMachine.State CROSS_STATE;

    /**
     * Reference to grid of Finite State Machine
     */
    protected FiniteStateMachine.State grid[][];

    /**
     * Constructor for Rule
     * @param fsm reference to finite state machine
     */
    public Rule(FiniteStateMachine fsm) {
        
    }

    /**
     * Does the rule fire?
     * @return true if rule holds, false otherwise
     */
    public abstract boolean fire();

    static {
        BLANK_STATE = FiniteStateMachine.State.blank;
        NOUGHT_STATE = FiniteStateMachine.State.nought;
        CROSS_STATE = FiniteStateMachine.State.cross;
    }
}
