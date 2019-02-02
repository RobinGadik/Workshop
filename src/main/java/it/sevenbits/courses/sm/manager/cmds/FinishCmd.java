package it.sevenbits.courses.sm.manager.cmds;

import it.sevenbits.courses.sm.manager.sm.Pair;

public class FinishCmd implements INetworkManagerCommand {
    private Pair<StringBuilder, StringBuilder> buffer;

    public FinishCmd(Pair<StringBuilder, StringBuilder> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void execute() {
        System.out.println(buffer.getFirst().toString());
        buffer.getFirst().delete(0, buffer.getFirst().length());
        buffer.getSecond().delete(0, buffer.getSecond().length());
    }
}
