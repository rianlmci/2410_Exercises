package labQueue;

import java.util.Iterator;
//practice iterable/iterator
public class Puppies implements Iterable <Puppies>{
    String name;
    String color;

    Puppies(String name, String color){
        this.name = name;
        this.color= color;
    }

    private Node head;
    private Node tail;
    //elements in the queue
    private int n;

    private class Node{
        Puppies item;
        Node next;
        Node(Puppies value){
            this.item = value;
        }
    }
    private class PuppiesIterator implements Iterator<Puppies>{

       Node current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Puppies next() {
            Puppies next = current.item;
            current = current.next;
            return next;
        }
    }
    @Override
    public Iterator<Puppies> iterator() {
        return new PuppiesIterator();
    }

    @Override
    public String toString(){
        return "Puppy name:" + name + "\n"
                + "Puppy's color: " + color;
    }

    public static void main(String [] args){
        Puppies puppy1 = new Puppies("Clifford", "red");
        Puppies puppy2 = new Puppies("Scooby", "brown");

    }
}
