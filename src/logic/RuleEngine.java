package logic;

/**
 * The Rule Engine acts as a placeholder and single interface to construct the
 * two rules.
 * @author 07973435
 */

public class RuleEngine {

    // Instantiate Won and Drawn rules
    private GameWonRule won;
    private GameDrawnRule drawn;

    /**
     * Constructor for Rule Engine
     * @param fsm
     */
    protected RuleEngine(FiniteStateMachine fsm) {
        won = new GameWonRule(fsm);
        drawn = new GameDrawnRule(fsm);
    }

    /**
     * If won, fire the won rule
     * @return
     */
    protected boolean fireGameWonRule() {
        return won.fire();
    }

    /**
     * If drawn, fire drawn rule
     * @return
     */
    protected boolean fireGameDrawnRule() {
        return drawn.fire();
    }
}
