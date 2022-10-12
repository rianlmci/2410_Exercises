package midterm;

import java.util.NoSuchElementException;

/**
 * Queue that stores numbers of the primitive type int.
 * This queue is implement with a singly-linked structure.
 * 
 * @author Starter Code + Rianna McIntyre
 *
 */
public class NumberQueue {
	private int n;
	private Node head;
	private Node tail;
	
	private class Node {
		private int item;
		private Node next;
		
		Node(int item) {
			this.item = item;
		}
	}
	
	public int size() {
		return n; 
	}
	
	public boolean isEmpty() {
		return n == 0; 
	}
	
	/**
	 * Adds an element to the end of the queue.
	 * 
	 * @param item new element to be added
	 */
	public void enqueue(int item) {
		Node newNode = new Node(item);
		
		if (isEmpty()) 
			head = newNode;
		else 
			tail.next = newNode;
		
		tail = newNode;
		n++;
	}
	
	/**
	 * Removes the next element from the queue.
	 * Elements are removed in the order in which they were added to the queue.
	 * 
	 * @return int element from the beginning of the queue
	 */
	public int dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Can't remove an element from an empty queue!");
		
		int item = head.item;
		head = head.next;
		n--;
		
		if (isEmpty())
			tail = null;
		
		return item;
	}
	
	/**
	 * Calculates the average of all the numbers in the queue.
	 * If the queue is empty, an UnsupportedOperationException should be thrown.
	 * E.g., if the queue includes 1, 5, 1, 3 the average should be 2.5
	 * 
	 * @return average of all the numbers in the queue
	 * @throws UnsupportedOperationException if the queue is empty
	 */
	public double average() {
		if (isEmpty()){throw new UnsupportedOperationException("Can't check the average of an empty queue!");}

		Node current = head;
		double sum = 0;

		while(current != null){
			sum = sum + current.item;
			current = current.next;
		}
		return sum/n;
	}
	
	/**
	 * Determines whether the last element in the queue (the element that has 
	 * been added last) is an even number.
	 * Throws a NoSuchElementException if the queue is empty.
	 * 
	 * @return true if the last element is even and odd otherwise.
	 * @throws NoSuchElementException if the queue is empty
	 */
	public boolean endsEven() {
		if(isEmpty()){throw new NoSuchElementException("Can't check odd/even on an empty queue!");}
		return (tail.item % 2 == 0);
	}
	
	/**
	 * Creates a string that includes all elements in the order in which they were
	 * added to the queue. Elements are separated by a space, however, there is no
	 * space at the end of the string. </br></br>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		if (isEmpty()) 
			return "";
		
		StringBuilder sb = new StringBuilder();		
		Node current = head;
		while (current != null) {
			sb.append(current.item).append(" ");
			current = current.next;
		}
		return sb.toString().substring(0, sb.length()-1);
		
	}
	
	// = = = =   T e s t   C l i e n t    = = = = = 

	public static void main(String[] args) {
		NumberQueue queue = new NumberQueue();
		queue.enqueue(1);
		queue.enqueue(5);
		queue.enqueue(1);
		queue.enqueue(3);

		
		// write code to test the methods average and endsEven.

		// = = = AVERAGE TESTS = = = //
		//average of empty returns exception
		/*NumberQueue emptyQueue = new NumberQueue();
		emptyQueue.average();*/
		System.out.println(" = = = AVERAGE TESTS = = = ");
		System.out.println("Queue: " + queue);
		System.out.println("Average of our queue:");
		System.out.println("Expected: 2.5");
		System.out.println("Actual: " + queue.average());

		// = = = ENDS EVEN TESTS = = = //
		//endseven of empty returns exception
		/*NumberQueue emptyQueue = new NumberQueue();
		emptyQueue.endsEven();*/
		System.out.println(" = = = ENDS EVEN TESTS = = = ");
		System.out.println("Queue: " + queue);
		System.out.println("Does our queue end in an even number?");
		System.out.println("Expected: false");
		System.out.println("Actual: " + queue.endsEven());
	}


}
