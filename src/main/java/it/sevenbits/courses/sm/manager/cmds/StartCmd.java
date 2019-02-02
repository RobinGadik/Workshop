package it.sevenbits.courses.sm.manager.cmds;

import it.sevenbits.courses.sm.manager.sm.Pair;

public class StartCmd implements INetworkManagerCommand {

    private Pair<StringBuilder, StringBuilder> buffer;

    public StartCmd(Pair<StringBuilder, StringBuilder> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        buffer.getSecond().delete(0, buffer.getSecond().length());
        buffer.getFirst().delete(0, buffer.getFirst().length());
    }
}