package it.sevenbits.courses.sm.manager.sm;

import com.sun.org.apache.xpath.internal.operations.Bool;
import it.sevenbits.courses.sm.log.MessageFormatter;
import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.cmds.*;
import it.sevenbits.courses.sm.manager.NetworkManagerException;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.Network;
import it.sevenbits.courses.sm.network.NetworkPackage;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    private Map<String, INetworkManagerCommand> map;
    private Pair<StringBuilder, StringBuilder> buffer;

    private MessageFormatter mf = new MessageFormatter();
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Network.class.getName());

    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
        this.map = new HashMap<>();
        this.buffer = new Pair<>(new StringBuilder(), new StringBuilder());
        /* state types
        "IGNORE"
        "START"
        "LISTEN"
        "TRASH CONFIRMED"
        "TRASH_SUSPICION"
        "FINISH"
        */
        map.put("IGNORE", new IgnoreCmd(buffer));
        map.put("START", new StartCmd(buffer));
        map.put("LISTEN", new ListenCmd(buffer));
        map.put("TRASH_CONFIRMED", new TrashConfirmedCmd(buffer));
        map.put("TRASH_SUSPICION", new TrashSuspictionListenCmd(buffer));
        map.put("FINISH", new FinishCmd(buffer));
    }

    @Override
    public void listen(INetwork network) throws NetworkManagerException {
        State currentState = stateTransition.getStartState();
        try {
            while(!isInterrupted){
                while(network.hasPackage()){
                    NetworkPackage p = network.getPackage();
                    currentState = stateTransition.nextState(currentState, p);
                    buffer.getSecond().append(p.getMessage());
                    map.get(currentState.toString()).execute();

                    LOGGER.info(String.format(mf.getStringFormatByType(p.getType()), p.getMessage()));
                    System.out.println(String.format("%1$s: %2$s", p.getType(), currentState.toString()));

                }

                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e){
            LOGGER.error("Network manager was interrupted unexpectedly");
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        LOGGER.info("StateMachine is Interrupted");
        isInterrupted = true;
    }
}
