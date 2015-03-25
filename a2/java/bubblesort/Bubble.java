import java.util.Random;

public class Bubble {
    Random random = new Random();
    String type;
    boolean ascend;
    int size;

    public Bubble(String type, boolean ascend, int size) {
        this.type = type;
        this.ascend = ascend;
        this.size = size;
    }

    public void go(String type, boolean ascend, int size) {
	    /*
         * Get the type, build a random array, then sort it;
         * Integers and Floats range from 0-100
         * Strings are 10 random alphanumeric characters
         */
        switch(type.toLowerCase()) {
            case "integer":
                Integer[] randInt = new Integer[size];
                for(int i = 0; i < randInt.length; i++) {
                    randInt[i] = random.nextInt(101);
                }
                Sort s1 = new Sort(randInt, ascend);
                s1.sort();
                break;
            
            case "string":
                String[] randStr = new String[size];
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
                Sort s2 = new Sort(randStr, ascend);
                s2.sort();
                break;
            
            case "float":
                Float[] randFloat = new Float[size];
                for(int i = 0; i < randFloat.length; i++) {
                    randFloat[i] = random.nextFloat()*101.0f;
                }
                Sort s3 = new Sort(randFloat, ascend);
                s3.sort();
                break;
            
            default:
                System.out.println("Invalid option " + type);
                break;
        }
    }
}
