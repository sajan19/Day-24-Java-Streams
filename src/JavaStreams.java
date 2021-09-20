import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
public class JavaStreams {
    public static void main(String[] args) {
        System.out.println("Welcome to Java Streams...");
        //Creating Sample Collection
        List<Integer> myNumberList =  new ArrayList<Integer>();
        for (int i =0; i<5; i++)
            myNumberList.add(i);
        //Method to Store Double Value
        Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
        //Method 1: Processing the Stream
//        myNumberList.stream().forEach(n ->{
//            System.out.println("Method_1: Stream forEach Value: "+n);
//        });
        //Method 2: Process the Stream, Apply Operations on the Stream and then
        //Store the Result
        List<Double> streamList = myNumberList.stream().map(toDoubleFunction).collect(Collectors.toList());
        System.out.println("Method_2: Printing Double List: "+ streamList);
    }
}
