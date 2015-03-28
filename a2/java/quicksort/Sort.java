/*
 * Alexander Marshall - 100487187
 * Compile Errors: <5
 * Runtime Errors: 
 */

package quicksort;
import java.util.Random;

public class Sort<T extends Comparable<T>> {
    private T[] input;
    private boolean ascend;
    Random random;

    public Sort(T[] input, boolean ascend) {
        this.input = input;
        this.ascend = ascend;
        random = new Random();
    }

    //boolean ascend determines sort order
    public int compare(T a, T b) {
        if(ascend) {
            return a.compareTo(b);
        } else {
            return -(a.compareTo(b));
        }
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
        quicksort(0, input.length-1);
        System.out.println("Done! ");
        this.print();
        return input;
    }

    private void quicksort(int start, int end) {
        if(start < end) {
            T pivot = input[end];
            int i = start; int j = end;

            while(i != j) {
                if(compare(input[i], pivot) < 0) {
                    i++;
                } else {
                    input[j] = input[i];
                    input[i] = input[j-1];
                    j--;
                }
            }
            input[j] = pivot;
            quicksort(start, j-1);
            quicksort(j+1, end);
        }
    }
}
