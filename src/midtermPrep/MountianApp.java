package midtermPrep;

import java.util.Arrays;

public class MountianApp {
    public static void main(String [] args){
        Mountian[] mountians ={
                new Mountian("Mt.Everest", 8849),
                new Mountian("K2", 8611),
                new Mountian("Kangchenjunga", 8586)
        };
        System.out.println("= = = = = All of my mountains = = = = =");
        for (Mountian oneMountain: mountians) {
            System.out.print(oneMountain);
            System.out.println("====");
        }
    System.out.println("Sorting my mountains...\n");

    Arrays.sort(mountians);

    System.out.println("= = = = = All of my /sorted/ mountains = = = = =");
        for (Mountian oneMountain: mountians) {
            System.out.print(oneMountain);
            System.out.println("====");
        }
    }
}
