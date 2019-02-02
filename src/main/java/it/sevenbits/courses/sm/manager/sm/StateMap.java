package it.sevenbits.courses.sm.manager.sm;

import java.util.HashMap;
import java.util.Map;

class StateMap {
    private final State defaultState = new State("IGNORE");

    private final Map<Pair<State, String>, State> states;

    StateMap() {
        /* packet types
        "MESSAGE_START"
        "MESSAGE"
        "TRASH"
        "MESSAGE_FINISH"
        */
        states = new HashMap<>();
        State start = new State("START");
        State listenState = new State("LISTEN");
        State confirmTrash = new State("TRASH_CONFIRMED");
        State stubSuspicion = new State("TRASH_SUSPICION");
        State finish = new State("FINISH");

        states.put(new Pair<>(defaultState, "MESSAGE_START"), start);

        states.put(new Pair<>(start, "MESSAGE"), listenState);
        states.put(new Pair<>(start, "TRASH"), confirmTrash);
        states.put(new Pair<>(start, "MESSAGE_FINISH"), finish);

        states.put(new Pair<>(listenState, "MESSAGE"), listenState);
        states.put(new Pair<>(listenState, "TRASH"), confirmTrash);
        states.put(new Pair<>(listenState, "MESSAGE_FINISH"), finish);

        states.put(new Pair<>(confirmTrash, "MESSAGE"), stubSuspicion);
        states.put(new Pair<>(confirmTrash, "TRASH"), defaultState);
        states.put(new Pair<>(confirmTrash, "MESSAGE_FINISH"), finish);

        states.put(new Pair<>(stubSuspicion, "MESSAGE"), stubSuspicion);
        states.put(new Pair<>(stubSuspicion, "TRASH"), defaultState);
        states.put(new Pair<>(stubSuspicion, "MESSAGE_FINISH"), finish);

        states.put(new Pair<>(finish, "MESSAGE_START"), start);

    }

    public State getStartState() {
        return defaultState;
    }

    public State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }
}
