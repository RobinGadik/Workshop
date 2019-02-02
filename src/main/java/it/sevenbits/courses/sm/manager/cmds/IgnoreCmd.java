package it.sevenbits.courses.sm.manager.cmds;

import it.sevenbits.courses.sm.manager.sm.Pair;

public class IgnoreCmd implements INetworkManagerCommand {

    private Pair<StringBuilder, StringBuilder> buffer;

    public IgnoreCmd(Pair<StringBuilder, StringBuilder> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        buffer.getFirst().delete(0, buffer.getFirst().length());
        buffer.getSecond().delete(0, buffer.getSecond().length());
    }
}
