/*
 * Alexander Marshall - 100487187
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if(args.length < 4) {
            System.out.println("Usage: java Main [Bubble/Quick/Merge] [Integer/String/Float] [ascend/descend] [size]");
            return;
        }
        
        //Setup
        int SIZE;
        boolean ascend;
        Random random = new Random();
        Bubble b;

        try {
            SIZE = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.err.println("Specified size \'" + args[2] + "\' is invalid.");
            return;
        }

        switch(args[2].toLowerCase()) {
            case "ascend":
                ascend = true;
                break;
            case "descend":
                ascend = false;
                break;
           default:
                System.out.println("Invalid option "+args[2]);
                return;
        }
        
        switch(args[0].toLowerCase()) {
            case "bubble":
                Bubble b = new Bubble(args[1], ascend, SIZE);
                break;
            case "quick":
                Quick q = new Qiuck(args[1], ascend, SIZE);
                break;
            case "merge":
                Merge m = new Merge(args[1], ascend, SIZE);
                break;
            default:
                System.out.println("Invalid option "+args[0]);
        }
    }

}
