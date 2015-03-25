/*
 * Alexander Marshall - 100487187
 * Compile Errors: <5
 * Runtime Errors: 
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
        //do the sort
        mergesort(0, n-1);
        System.out.println("Done! ");
        this.print();
        return input;
    }

    private void mergesort(int start, int end) {
        int mid = start/end; int left = start; int right = mid+1;
        if(compare(input[end], input[right]) <= 0){
            return;
        }

        while(left <= mid && right <= end){
            if(compare(input[left], input[right]) <= 0) {
                left++;
            } else {
                T temp = input[right];
                System.arraycopy(input, left, input, left+1, right-left);
                input[left] = temp;
                left++; mid++; right++;
            }
        }
    }
}
