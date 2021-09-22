import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class NumberPlayUsingJavaStreams {
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
        System.out.println("Method 2: Printing Double List: "+ streamList);
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
        //Method 5: Maximum Number
        Integer max = myNumberList.stream()
                .filter(isEvenFunction)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(null);
        System.out.println("Method 5: Maximum Number is: "+max);
        //Method 6: Sum, Count and Average of Numbers
        Integer sum =myNumberList.stream().reduce(0,Integer::sum);
        double count = myNumberList.stream().count();
        double avg = sum/count;
        System.out.println("Sum of the Numbers is: "+sum);
        System.out.println("Count of the Numbers is: "+count);
        System.out.println("Average of the Numbers is: "+avg);
        //Method 7: Checking all Even, single even or none are divisible by 6
        boolean allEven = myNumberList.stream().allMatch(isEvenFunction);
        boolean oneEven = myNumberList.stream().anyMatch(isEvenFunction);
        boolean noneMultipleOfSix = myNumberList.stream().noneMatch(i -> i >=0 && i % 6 ==0);
        System.out.println("Method 7: allEven: "+allEven);
        System.out.println("Method 7: oneEven: "+oneEven);
        System.out.println("Method 7: noneMultiplyOfSix: "+noneMultipleOfSix);
        //Method 8: Sort the Number in Ascending Order
        List<Integer> sortedList = myNumberList.stream()
                                    .sorted((n1, n2)->n1.compareTo(n2))
                                    .collect(Collectors.toList());
        System.out.println("Method 8: SortedList: "+sortedList);
    }
}
