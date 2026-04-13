public class MyStack<T> {

    public static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    public MyStack(){
        top = null;
    }

    public void push(T element){
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
    }

    public T pop(){
        if(top == null){
            System.out.println("Stack is empty");
            return null;
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek(){
        if(top == null){
            System.out.println("Stack is empty");
            return null;
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

}
