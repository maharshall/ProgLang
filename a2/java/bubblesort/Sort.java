/*
 * CSCI 3055U
 * Assignment Two
 * Alexander Marshall
 * 100487187
 */

import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Usage: java Sort [Integer/String/Float] [ascend/descend] [size]");
            return;
        }
        Integer[] rando = new Integer[Integer.parseInt(args[2])];
        Random random = new Random();
        for(int i = 0; i < rando.length; i++) { 
            rando[i] = random.nextInt(101);
        }
        
        Bubble b = new Bubble(rando);
        b.Sort();
    }

}

class Bubble<T extends Comparable<T>> {
    private T[] input;

    public Bubble(T[] input) {
        this.input = input;
    }
    public int compare(T a, T b) {
        return a.compareTo(b);
    }

    private void swap(int a, int b) {
        //System.out.println("Swapping "+input[a]+" and "+input[b]+" ...");
        T temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    private void print() {
        if(input.length <= 30) {
            for(int i = 0; i < input.length; i++) {
                System.out.print(input[i] + " ");
            }
            System.out.println("");
        }
    }

    public T[] Sort() {
        this.print();
        System.out.print("Sorting... ");
        int n = input.length;
        boolean flag = true;
        int j = 0;

        while(flag) {
           //System.out.println("\nIteration: "+(j++));
            flag = false;
            for(int i = 1; i < n; i++) {
                if(compare(input[i-1], input[i]) > 0) {
                    swap(i-1, i);
                    flag = true;
                }
            }
        }
        System.out.println("Done! ");
        this.print();
        return input;
    }
}
