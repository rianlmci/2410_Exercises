package labQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Demo of simple implementation of a queue structure in Java.
 */
public class numberQueue implements Iterable<Integer> {
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
     * @return number of elements in the queue
     */
    public int size() {
        return n;
    }

    /**
     * @return if the queue is empty or not as a true/false.
     */
    public boolean isEmpty(){
        return n == 0;
    }

    /**
     * Adds an item to the back of the linked queue.
     * @param item to be added to the back of the queue.
     */
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
     * @throws NoSuchElementException if queue is empty!
     */
    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Can't dequeue from an empty queue");
        }
        int dequeuedItem = head.item;
        head = head.next;
        n--;
        //reassigns tail if completely empty at this point
        if(isEmpty()){
            tail = null;
        }
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

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedQueueIterator();
    }
    private class LinkedQueueIterator implements Iterator<Integer> {
        Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            int next = current.item;
            current = current.next;
            return next;
        }
    }

    // = = = TEST CLIENT = = = //
    public static void main(String [] args){
        numberQueue myLinkedQueue = new numberQueue();
        myLinkedQueue.enqueue(10);
        myLinkedQueue.enqueue(20);
        myLinkedQueue.enqueue(30);
        System.out.println("Total queue: " + myLinkedQueue);
        System.out.println("Peek front: " + myLinkedQueue.peek());
        System.out.println("Dequeuing/Removing... " + myLinkedQueue.peek() + " ");
        myLinkedQueue.dequeue();
        System.out.println("New size of list:  " + myLinkedQueue.size());
        System.out.println("Updated queue: " + myLinkedQueue);
        System.out.println("Updated head:  " + myLinkedQueue.head.item);
        System.out.println("Updated tail:  " + myLinkedQueue.tail.item);
        System.out.println("Testing iterator... ");

        for (int oneInt: myLinkedQueue) {
            System.out.print(oneInt + " ");
        }
        System.out.println("\n");
    }
}