/*
 * Alexander Marshall - 100487187
 * Compile Errors: <10
 * Runtime Errors: <5 (no actual errors, just incorrect sorting)
 */

import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Usage: java Sort [Integer/String/Float] [ascend/descend] [size]");
            return;
        }
        
        //Setup
        int SIZE;
        boolean ascend;
        Random random = new Random();
        Bubble b;

        try {
            SIZE = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Specified size \'" + args[2] + "\' is invalid.");
            return;
        }

        switch(args[1].toLowerCase()) {
            case "ascend":
                ascend = true;
                break;
            case "descend":
                ascend = false;
                break;
            default:
                System.out.println("Invalid option "+args[1]);
                return;
        }
        
        /*
         * Get the type, build a random array, then sort it;
         * Integers and Floats range from 0-100
         * Strings are 10 random alphanumeric characters
         */
        switch(args[0].toLowerCase()) {
            case "integer":
                Integer[] randInt = new Integer[SIZE];
                for(int i = 0; i < randInt.length; i++) {
                    randInt[i] = random.nextInt(101);
                }
                b = new Bubble(randInt, ascend);
                b.Sort();
                break;
            
            case "string":
                String[] randStr = new String[SIZE];
                String chars = "123456789abcdefghijklmnopqrstuvwxyz";
                StringBuilder str = new StringBuilder();
                for(int i = 0; i < randStr.length; i++) {
                    while(str.length() < 10) {
                        int index = (int) (random.nextFloat() * chars.length());
                        str.append(chars.charAt(index));
                    }
                    randStr[i] = str.toString();
                    str.delete(0, 9);
                }
                b = new Bubble(randStr, ascend);
                b.Sort();
                break;
            
            case "float":
                Float[] randFloat = new Float[SIZE];
                for(int i = 0; i < randFloat.length; i++) {
                    randFloat[i] = random.nextFloat()*101.0f;
                }
                b = new Bubble(randFloat, ascend);
                b.Sort();
                break;
            
            default:
                System.out.println("Invalid option " + args[0]);
                return;
        }
    }

}

class Bubble<T extends Comparable<T>> {
    private T[] input;
    private boolean ascend;

    public Bubble(T[] input, boolean ascend) {
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
