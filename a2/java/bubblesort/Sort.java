/*
 * Alexander Marshall - 100487187
 * Compile Errors: <10
 * Runtime Errors: <5 (no actual errors, just incorrect sorting)
 */

import java.util.Random;

public class Sort<T extends Comparable<T>> {
    private T[] input;
    private boolean ascend;

    public Sort(T[] input, boolean ascend) {
        this.input = input;
        this.ascend = ascend;
    }

    //boolean ascend determines sort order
    public int compare(T a, T b) {
        if(ascend) {
            return a.compareTo(b);
        } else {
            return -(a.compareTo(b));
        }
    }

    //Swap based on array index
    private void swap(int a, int b) {
        T temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    //Prints arrays of length <= 30
    private void print() {
        if(input.length <= 30) {
            for(int i = 0; i < input.length; i++) {
                System.out.print(input[i] + " ");
            }
            System.out.println("");
        }
    }

    public T[] sort() {
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
