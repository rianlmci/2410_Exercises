package midterm;

import java.util.Iterator;

/**
 * Fixed-length list that stores characters of the primitive type char.
 * It allows the adding of elements but not their removal.
 * Once the number of elements reaches the capacity, no more elements
 * can be added to the list.
 * 
 * @author Starter Code + Rianna McIntyre
 *
 */
public class CharList implements Iterable<Character> {
	private char[] items;
	private int n;
	
	public CharList(int capacity) {
		items = new char[capacity];
		n = 0;
	}
	
	/**
	 * Adds the element <code>item</code> to the list.
	 * If the list is full, an UnsupportedOperationException is thrown.
	 * 
	 * @param item element to add to the list
	 * @throws UnsupportedOperationException if the list is full
	 */
	public void add(char item) {
		if(n == items.length)
			throw new UnsupportedOperationException(
					"Can't add elements to a full list.");
		
		items[n] = item;
		n++;
	}

	/**
	 * Identifies the number of elements in the list.
	 * 
	 * @return the number of elements in the list.
	 */
	public int size() {
		return n;
	}
	
	/** 
	 * Determines whether there are elements on the list or not.
	 * 
	 * @return true if the list is empty.
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(items[i]).append(" ");
		}
		return sb.toString();
	}

	private class CharListIterator implements Iterator<Character>{
		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex == n;
		}

		@Override
		public Character next() {
			Character next = items[currentIndex];
			currentIndex ++;
			return next;
		}
	}
	@Override
	public Iterator<Character> iterator() {
		return new CharListIterator();
	}
	
	// = = = =   T e s t   C l i e n t    = = = = = 

	public static void main(String[] args) {
		CharList list = new CharList(6);		
		
		list.add('a');
		list.add('B');	
		list.add('c');
		list.add('D');
		list.add('e');
		list.add('F');
		System.out.println("list: " + list);
		

		// Implement the appropriate interface so that the foreach loop
		// below prints the elements in the order in which they were added 
		// to the list.

		// This loop should not be changed.
		for (char el : list) {
			System.out.print(el + "|" + el + " "); 
		}
		System.out.println();
	}
}
