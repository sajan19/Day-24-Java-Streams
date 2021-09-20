import java.util.ArrayList;
import java.util.List;
public class JavaStreams {
    public static void main(String[] args) {
        System.out.println("Welcome to Java Streams...");
        //Creating Sample Collection
        List<Integer> myNumberList =  new ArrayList<Integer>();
        for (int i =0; i<5; i++)
            myNumberList.add(i);
        //Method 1: Processing the Stream
        myNumberList.stream().forEach(n ->{
            System.out.println("Method_1: Stream forEach Value: "+n);
        });
    }
}
