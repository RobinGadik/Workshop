package it.sevenbits.courses.sm.network;

public interface INetwork {

    boolean hasPackage();

    NetworkPackage getPackage();

    void addPackage(String message, String type);
}
