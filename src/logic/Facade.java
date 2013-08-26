package logic;

/**
 * The Facade class acts as a holding class that handles the interactions
 * between the different tiers of the game architecture. It is an instance of
 * the Facade design pattern that is used to pass calls from the GUI to its
 * relevant classes.
 * 
 * @author 07973435
 */

public class Facade {
    // Check if Finite State Machine is full
    public boolean full;
    // Reference Finite State Machine
    FiniteStateMachine fsm;
    // Reference Rule Engine
    public RuleEngine result;
    // Reference Agent
    private Agent agent;

    /**
     * Constructor for Facade
     */
    public Facade() {
        full = false;
        fsm = new FiniteStateMachine();
        result = new RuleEngine(fsm);
        agent = new Agent(fsm);
    }

    /**
     * Update FSM to update game state
     * @param row
     * @param column
     * @param state
     */
    public void updateFiniteStateMachine(int row, int column, FiniteStateMachine.State state) {
        fsm.updateCell(row, column, state);
    }

    /**
     * Is FSM full?
     * @return
     */
    public boolean isFiniteStateMachineFull() {
        return full;
    }

    /**
     * Fire Won method in Rule Engine
     * @return
     */
    public boolean fireGameWonRule() {
        return result.fireGameWonRule();
    }

    /**
     * Fire Drawn method in Rule Engine
     * @return
     */
    public boolean fireGameDrawnRule() {
        return result.fireGameDrawnRule();
    }

    /**
     * Make Agent take its next move
     * @return
     */
    public Action getAgentMove() {
        return agent.getNextMove();
    }
}