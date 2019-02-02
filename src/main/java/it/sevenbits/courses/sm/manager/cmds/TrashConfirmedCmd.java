package it.sevenbits.courses.sm.manager.cmds;

import it.sevenbits.courses.sm.manager.sm.Pair;

public class TrashConfirmedCmd implements INetworkManagerCommand {

    private Pair<StringBuilder, StringBuilder> buffer;

    public TrashConfirmedCmd(Pair<StringBuilder, StringBuilder> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        buffer.getSecond().delete(0,buffer.getSecond().length());
    }
}
