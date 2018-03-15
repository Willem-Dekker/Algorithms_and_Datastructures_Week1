package nl.saxion.hboict.ad.week3;

public class Mlll <T> {
    private Node<T> head;

    public Mlll() {
    }

    public void add(T element){
        if (head == null){
            this.head = new Node<>(element);
        } else{
            Node<T> node = head;
            while (node != null){
                node = node.getNext();
            }
            //assert node != null;
            node.setNext(new Node<>(element));
        }
    }

    public int size(){
        if (head == null){
            return 0;
        }else {
            int i = 1;
            Node<T> node = head;
            while (node.getNext() != null){
                node = node.getNext();
                i++;
            }
            return i;
        }
    }

   public T get(int index){
        if (index > size() || index < 0){
            throw new IndexOutOfBoundsException();
        }else {
            Node<T> node = head;
            for (int i = 0; i < size(); i++) {
                if (i == index) {
                    return node.getData();
                } else {
                    node = node.getNext();
                }
            }
        }
        return null;
   }

}
