package itttt.sevenbits.courses.sm.network;

import it.sevenbits.courses.sm.network.INetwork;
import it.sevenbits.courses.sm.network.NetworkPackage;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Network implements INetwork {
    private final int maxSize;
    private ConcurrentLinkedDeque<it.sevenbits.courses.sm.network.NetworkPackage> packages = new ConcurrentLinkedDeque<it.sevenbits.courses.sm.network.NetworkPackage>();

    public Network(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public it.sevenbits.courses.sm.network.NetworkPackage getPackage(){
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
