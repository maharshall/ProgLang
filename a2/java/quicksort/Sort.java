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
        quicksort(0, input.length-1);
        System.out.println("Done! ");
        this.print();
        return input;
    }

    private void quicksort(int start, int end) {
        if(end-start <= 1) return;
        int left = start; int right = end;
        while(left <= right) {
            int pivot = (end-start)/2;
            while(compare(input[left], input[pivot]) < 0){
                left++;
            }
            while(compare(input[right], input[pivot]) > 0){
                right--;
            }
            if(left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        quicksort(start, right);
        quicksort(left, end);
    }
}
