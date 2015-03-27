/*
 * Alexander Marshall - 100487187
 * Compile Errors: <5
 * Runtime Errors: <5 
 */

package mergesort;
import java.util.Random;

public class Sort<T extends Comparable<T>> {
    private T[] input;
    private boolean ascend;

    public Sort(T[] input, boolean ascend) {
        this.input = input;
        this.ascend = ascend;
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
        T[] holder = input;

        int i = low; int j = middle+1; int k = low;

        while(i <= middle && j <= high) {
            if(compare(holder[i], holder[j]) <= 0) {
                input[k] = holder[i];
                i++;
            } else {
                input[k] = holder[j];
                j++;
            }
            k++;
        }

        while(i <= middle) {
            input[k] = holder[i];
            k++; i++;
        }
    }
}
