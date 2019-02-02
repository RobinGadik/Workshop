package it.sevenbits.courses.sm.network;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Network implements INetwork {
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();

    public Network(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage(){
        // TODO: add debug log
        return packages.removeFirst();
    }

    @Override
    public void addPackage(String message, String type) {
        if(packages.size() < maxSize) {
            // TODO: add debug log
            packages.addLast(new NetworkPackage(type, message));
        }
        // TODO: add error log
    }
}
