package Interfaces.container;

import Interfaces.exceptions.EmptyException;

public interface IKeeperItems<E> {
    E take() throws EmptyException;
}
