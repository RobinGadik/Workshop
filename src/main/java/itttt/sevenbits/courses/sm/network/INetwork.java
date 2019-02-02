package itttt.sevenbits.courses.sm.network;

import it.sevenbits.courses.sm.network.NetworkPackage;

public interface INetwork {

    boolean hasPackage();

    NetworkPackage getPackage();

    void addPackage(String message, String type);
}
