package labQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Demo of simple implementation of a queue structure in Java.
 */
public class LinkedQueue<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    //elements in the queue
    private int n;

    private class Node{
        E item;
        Node next;

        Node(E value){
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
    public void enqueue(E item){
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
    public E peek (){
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
    public E dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Can't dequeue from an empty queue");
        }
        E dequeuedItem = head.item;
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
            sb.append(current.item).append( ", ");
            current = current.next;
        }

        return sb.substring(0, sb.length() - 2) + ".";
    }

    /**
     * takes the first <code>count</code> elements from
     * the queue and returns them in the order in
     * which they were added to the queue.
     * @param count
     * @throws IllegalArgumentException if count is < 0 or count > size of queue.
     * @return
     */
    public Iterable<E> take(int count){
        if(count < 0){
            throw new IllegalArgumentException("Count can't be negative.");
        }
        if(count > n){
            throw new IllegalArgumentException("Count cannot be greater than the size.");
        }
        LinkedQueue<E> results = new LinkedQueue<>();
        Node current = head;

        for (int i = 0; i < count; i++) {
          results.enqueue(current.item);
          current = current.next;
        }

        return results;
    }

    public Iterable<E> takeLast(int count){
        if(count < 0){
            throw new IllegalArgumentException("Count can't be negative.");
        }
        if(count > n){
            throw new IllegalArgumentException("Count cannot be greater than the size.");
        }

        LinkedQueue<E> results = new LinkedQueue<>();
        Node current = head;

        for (int i = 0; i < n-count; i++){
            current = current.next;
        }
        for (int i = n-count; i < n; i++) {
            results.enqueue(current.item);
            current = current.next;
        }

        return results;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }
    private class LinkedQueueIterator implements Iterator<E> {
        Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E next = current.item;
            current = current.next;
            return next;
        }
    }
    private static void testingFloat() {
        LinkedQueue <Float>myLinkedQueue = new LinkedQueue<>();
        myLinkedQueue.enqueue(1.1f);
        myLinkedQueue.enqueue(2.2f);
        myLinkedQueue.enqueue(3.3f);
        System.out.println("Starting queue: " + myLinkedQueue);
        System.out.println("Peek front: " + myLinkedQueue.peek());
        System.out.println("Dequeuing/Removing... " + myLinkedQueue.dequeue() + " ");
        System.out.println("Updated queue: " + myLinkedQueue);
        System.out.println("Updated size of list: " + myLinkedQueue.size());
        System.out.println("Adding 4.4 and 5.5...");
        myLinkedQueue.enqueue(4.4f);
        myLinkedQueue.enqueue(5.5f);
        System.out.println("Updated queue: " + myLinkedQueue);
        System.out.println("Updated size of list: " + myLinkedQueue.size());
        System.out.println("Testing iterator on original linked queue... ");
        for (float oneFloat: myLinkedQueue) {
            System.out.print(oneFloat + " ");
        }
        System.out.println("\nTesting iterator on take 1 queue... ");
        LinkedQueue<Float> takeOne = (LinkedQueue<Float>) myLinkedQueue.take(1);
        for (float oneFloat: takeOne) {
                System.out.print(oneFloat + " ");
        }
        System.out.println("\nTesting iterator on take LAST 2 queue... ");
        LinkedQueue<Float> takeTwo = (LinkedQueue<Float>) myLinkedQueue.takeLast(2);
        for (float oneFloat: takeTwo) {
            System.out.print(oneFloat + " ");
        }
        System.out.println("\nTesting iterator on take LAST 4 queue... ");
        LinkedQueue<Float> takeFour = (LinkedQueue<Float>) myLinkedQueue.takeLast(4);
        for (float oneFloat: takeFour) {
            System.out.print(oneFloat + " ");
        }
    }
    // = = = TEST CLIENT = = = //
    public static void main(String [] args){
        testingFloat();
    }

}