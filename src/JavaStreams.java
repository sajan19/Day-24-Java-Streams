import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
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
        //Method to distinguish Even Numbers
        Predicate<Integer> isEvenFunction = n -> n >=0 && n%2 ==0;
        //Method 1: Processing the Stream
//        myNumberList.stream().forEach(n ->{
//            System.out.println("Method_1: Stream forEach Value: "+n);
//        });
        //Method 2: Process the Stream, Apply Operations on the Stream and then
        //Store the Result
        //Collection of Double Numbers in streamList
        List<Double> streamList = myNumberList.stream()
                                  .filter(isEvenFunction)
                                  .map(toDoubleFunction)
                                  .collect(Collectors.toList());
        System.out.println("Method_2: Printing Double List: "+ streamList);
        //Method 3: Listing the First Element
//        Integer first = myNumberList.stream()
//                        .filter(isEvenFunction)
//                        .peek(n -> System.out.println("Peek Even Number: "+n))
//                        .findFirst()
//                        .orElse(null);
//        System.out.println("Method 3: First Even Number is: "+first);
        //Method 4: Minimum Number
        Integer min = myNumberList.stream()
                .filter(isEvenFunction)
                .min((n1, n2) -> n1-n2)
                .orElse(null);
        System.out.println("Method 4: Minimum Number is: "+min);
    }
}
