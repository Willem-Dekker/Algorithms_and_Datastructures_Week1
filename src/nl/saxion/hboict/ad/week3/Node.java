package nl.saxion.hboict.ad.week3;

public class Node <T>{
    private Node<T> next;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public void setNext(Node<T> node){
        this.next = node;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}
