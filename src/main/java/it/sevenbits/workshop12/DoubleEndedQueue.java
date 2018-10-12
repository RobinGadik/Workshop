package it.sevenbits.workshop12;


import it.sevenbits.workshop12.matrix.Matrix;

public class DoubleEndedQueue {
    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<Matrix> first;
    private Node<Matrix> last;

    public DoubleEndedQueue() {
        first = null;
        last = null;
    }

    public Node<Matrix> getFirst() {
        return first;
    }

    public Node<Matrix> getLast() {
        return last;
    }

    public void addFirst(Matrix m){
        if(first == null && last == null){
            first = new Node<Matrix>(m, null , null);
            last = first;
        }
        else {
            first.setPrev(new Node<Matrix>(m, null, first));
        }

    }


    public void addLast(Matrix m){
        if(first == null && last == null){
            first = new Node<Matrix>(m, null , null);
            last = first;
        }
        else {
            last.setNext(new Node<Matrix>(m, null, first));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Node<Matrix> i = first;i!=null;i = i.getNext()){
            sb.append(i.getElement().toString()).append("\n\n");
        }

        return sb.toString();
    }
}

