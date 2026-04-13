public class MyLinkedList<T> {
    static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean add(T element){
        Node<T> newNode = new Node<>(element);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object[] toArray(){
        Object[] array = new Object[size];
        Node<T> temp = head;
        int i = 0;
        while(temp != null){
            array[i] = temp.data;
            temp = temp.next;
            i++;
        }
        return array;
    }
}
