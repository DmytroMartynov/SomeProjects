package StreamingAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListOfRandoms {

    public static void main(String[] args) {

        Random random = new Random();
        List< Integer > list = Arrays.asList(
                random.nextInt(10),
                random.nextInt(10),
                random.nextInt(10),
                random.nextInt(10),
                random.nextInt(10));
        System.out.println("basic list :" + list.toString());
        double result = list.stream()
                .map(x -> x * x)
                .mapToDouble(a -> a)
                .average().getAsDouble();
        System.out.println(result);

    }
}
