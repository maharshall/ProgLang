/*
 * Alexander Marshall - 100487187
 * Compile Errors: <5
 * Runtime Errors: <5 
 */

package mergesort;
import java.util.Random;

public class Sort<T extends Comparable<T>> {
    private T[] input;
    private Object[] holder;
    private boolean ascend;

    public Sort(T[] input, boolean ascend) {
        this.input = input;
        this.ascend = ascend;
        holder = new Object[input.length];
    }

    //boolean ascend determines sort order
    private int compare(T a, T b) {
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

    public void sort() {
        this.print();
        System.out.print("Sorting... ");
        int n = input.length;
        //do the sort
        mergesort(0, input.length-1);
        System.out.println("Done! ");
        this.print();
    }

    private void mergesort(int low, int high) {
        if(low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle+1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        for(int x = low; x <= high; x++) {
            holder[x] = input[x];
        }
        int i = low; int j = middle+1; int k = low;

        while(i <= middle && j <= high) {
            if(compare((T)holder[i], (T)holder[j]) <= 0) {
                input[k++] = (T)holder[i++];
            } else {
                input[k++] = (T)holder[j++];
            }
        }

        while(i <= middle) {
            input[k++] = (T)holder[i++];
        }
    }
}
