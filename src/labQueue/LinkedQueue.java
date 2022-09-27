package labQueue;

import java.util.NoSuchElementException;

public class LinkedQueue {
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

    public void enqueue(int item){
        Node newNode = new Node(item);
        if(isEmpty()){
            head = newNode;
        }

        else{
            tail.next = newNode;
        }

        tail = newNode;
        n++;
    }

    /**
     * @return element at the front of the queue.
     * @throws NoSuchElementException if queue is empty!
     */
    public int peek (){
        if(isEmpty()){
            throw new NoSuchElementException("Can't peek at an empty queue");
        }
        return head.item;
    }

    /**
     *
     * @return Element at the front of the queue. FIFO.
     */
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Can't dequeue from an empty queue");
        }
        int dequeuedItem = head.item;
        head = head.next;
        n--;
        return dequeuedItem;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while(current != null){
            sb.append(current.item + " ");
            current = current.next;
        }
        return sb.toString();
    }
    // = = = TEST CLIENT = = = //
    public static void main(String [] args){
        LinkedQueue myLinkedQueue = new LinkedQueue();
        myLinkedQueue.enqueue(10);
        myLinkedQueue.enqueue(20);
        myLinkedQueue.enqueue(30);
        System.out.println("Total queue: " + myLinkedQueue);
        System.out.println("Peek front: " + myLinkedQueue.peek());
        System.out.println("Dequeuing/Removing... " + myLinkedQueue.peek() + " ");
        myLinkedQueue.dequeue();
        System.out.println("New size of list:  " + myLinkedQueue.size());
        System.out.println("Updated queue: " + myLinkedQueue);
        System.out.println("Current head:  " + myLinkedQueue.head.item);
        System.out.println("Current tail:  " + myLinkedQueue.tail.item);
    }
}