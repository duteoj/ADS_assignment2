public class MyQueue<T> {
    public static class Node<T>{
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

    public MyQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean offer(T data){
        Node<T> newNode = new Node<>(data);
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

    public T poll(){
        if(head == null){
            return null;
        }
        T data = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object[]  toArray(){
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
