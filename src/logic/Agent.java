package logic;

/**
 * The Agent class handles the movement of the Agent throughout the game.
 * @author 07973435
 */

public class Agent {
    // Initialise potential beliefs
    private Win win;
    private BlockMove blockMove;
    private MakeMove makeMove;
    private TwoMarkMove twoMarkMove;

    /**
     * Creates a new instance of Agent
     * @param f Finite State Machine
     */
    public Agent(FiniteStateMachine f) {
        win = new Win(f);
        blockMove = new BlockMove(f);
        makeMove = new MakeMove(f);
        twoMarkMove = new TwoMarkMove(f);
    }

    /**
     * Retrieves the next move of the Agent based on the following rules.
     *
     * <ol>
     * <li>Two of the Agent's marks can be found in a potential row</li>
     * <li>Two of my marks can be found in a potential row</li>
     * <li>Two strategic marks have been made</li>
     * <li>Either both an X and a 0 can be found in a potential row, or row empty</li>
     * </ol>
     *
     * After one strategic move the game can be handled by determining whether
     * a row contains an X or a 0.
     * @return
     */
    public Action getNextMove() {
        // Result always starts off as null
        Action result = null;
        
        win.update();
        blockMove.update();
        makeMove.update();
        twoMarkMove.update();

        // Subsumption Hierarchy (Reactive)
        if(win.isTrue()) {
            // Line with two 0's
            result = win.getAction();
        } else if(blockMove.isTrue()) {
            // Line with two X's
            result = blockMove.getAction();
        } else if(twoMarkMove.isTrue()) {
            // Row with two of same type
            result = twoMarkMove.getAction();
        } else if(makeMove.isTrue()) {
            // Random
            result = makeMove.getAction();
        }

        return result;
    }
}