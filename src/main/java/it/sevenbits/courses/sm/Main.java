package it.sevenbits.courses.sm;

import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.SimpleNetworkManager;
import it.sevenbits.courses.sm.manager.sm.StateMachineNetworkManager;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.Network;

public class Main {


    public static void main(String[] args) throws Exception {
        //final INetworkManager nm = new SimpleNetworkManager();
        final INetworkManager nm = new StateMachineNetworkManager();
        final INetwork network = new Network(500);

        PackagesGenerator packagesGenerator = new PackagesGenerator();
        Thread createMessagesThread = packagesGenerator.packagesFillerTaskTwo(nm,network);

        createMessagesThread.start();
        nm.listen(network);
    }
}
