package it.sevenbits.courses.sm.manager.cmds;

import it.sevenbits.courses.sm.manager.sm.Pair;

public class TrashSuspictionListenCmd implements INetworkManagerCommand {

    private Pair<StringBuilder, StringBuilder> buffer;

    public TrashSuspictionListenCmd(Pair<StringBuilder, StringBuilder> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        buffer.getFirst().append(buffer.getSecond());
        buffer.getSecond().delete(0,buffer.getSecond().length());
    }
}
