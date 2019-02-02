package itttt.sevenbits.courses.sm;

import it.sevenbits.courses.sm.PackagesGenerator;
import it.sevenbits.courses.sm.manager.INetworkManager;
import it.sevenbits.courses.sm.manager.SimpleNetworkManager;
import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.Network;

public class Main {


    public static void main(String[] args) throws Exception {
        final INetworkManager nm = new SimpleNetworkManager();
        final INetwork network = new Network(500);

        it.sevenbits.courses.sm.PackagesGenerator packagesGenerator = new PackagesGenerator();
        Thread createMessagesThread = packagesGenerator.packagesFillerTaskOne(nm,network);

        createMessagesThread.start();
        nm.listen(network);
    }
}
