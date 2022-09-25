package labQueue;

public class linkedQueue {
    private Node head;
    private Node tail;
    //elements in the queue
    private int n;
    private class Node{
        int item;
        Node next;

        Node(int value){
            this.item = value;
        }
    }

    /**
     *
     * @return number of elements in the queue
     */
    public int size() {
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void enqueue(int newNum){
        Node newNode = new Node(newNum);
        tail.next = newNode;
        tail = newNode;
    }

    public int dequeue(){
        int dequeuedItem = head.item;
        return dequeuedItem;
    }

    // = = = TEST CLIENT = = = //
    public static void main(String [] args){

    }
}