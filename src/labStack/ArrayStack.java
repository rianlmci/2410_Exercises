package labStack;

import java.util.NoSuchElementException;

/**
 * Stack of strings implementation.
 * The elements are stored in an array.
 * @author Rianna McIntyre
 */
public class ArrayStack {
    private String [] items;
    //undeclared default value is 0!
    private int n;

    public ArrayStack(int capacity){
        this.items = new String [capacity];
    }

    /**
     * adds an item to top of stack.
     * @param item we are going to add them into the stack.
     * @throws UnsupportedOperationException if stack is full
     */
    public void push (String item){

         if(n == items.length){throw new
                 UnsupportedOperationException("Can't add an element to full stack");
        }
        items[n++] = item;
    }

    /**
     * pops item off of the top of the stack and
     * @return string item from the top of the
     * stack we popped.
     * @throws NoSuchElementException is array is empty
     */
    public String pop(){
        //readability!
        if(isEmpty()){
            throw new NoSuchElementException("Can't pop an empty stack");
        }
        //garbage collector collects nulls, so the null here
        //is to avoid loitering.
        String returnString = items[n-1];
        items[n-1]= null;
        n--;
        return returnString;
    }

    /**
     * @return String value from the top of the stack.
     * @throws NoSuchElementException if stack is empty.
     */
    public String peek(){
        //readability!
        if(isEmpty()){
            throw new NoSuchElementException("Can't peek an empty stack");
        }
        return items[n-1];}

    /**
     * @return number of items in the stack
     */
    public int size (){return n;}

    /**
     * @return true if no elements in stack, false otherwise.
     */
    public boolean isEmpty(){
        return (n == 0);
    }

    @Override
    public String toString(){
        StringBuilder stringToReturn = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            stringToReturn.append(items[i] + " ");
        }
        return stringToReturn.toString();
    }

    public static void main(String[] args){
        ArrayStack stack = new ArrayStack(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack:" + stack);
        System.out.println("size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Adding D...");
        stack.push("D");
        System.out.println("Stack:" + stack);
        System.out.println("isEmpty: " + stack.isEmpty());
    }
}
