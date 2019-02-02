package itttt.sevenbits.courses.sm.manager;

import it.sevenbits.courses.sm.manager.NetworkManagerException;
import it.sevenbits.courses.sm.network.INetwork;

public interface INetworkManager {

    void listen(INetwork network) throws NetworkManagerException;

    void stop();
}
