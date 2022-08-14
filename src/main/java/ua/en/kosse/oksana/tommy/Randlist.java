package ua.en.kosse.oksana.tommy;

import com.github.javafaker.Faker;
import java.util.*;

public class Randlist {

    public static void main(String[] args) {

        int max = 20;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int n = new Random().nextInt(max);
            values.add(n);
        }
        System.out.println("ArrayList: " + values);

        values.stream().map(i->i*i).forEach(System.out::println);

        System.out.println("Squares: "+values.stream().map(i -> i * i).reduce(0, (acc, x) -> acc + x));

        System.out.println("sum of Squares: "+values.stream().mapToInt(value -> value * value).sum());

        System.out.println("number for Even: "+values.stream().filter(value -> value % 2 == 0).count());

        List<String> valuess = new ArrayList<String>(13);
        valuess.add("Jklmn");
        for (int i = 0; i < 10; i++) {
            Faker faker = Faker.instance();
            valuess.add(faker.name().lastName());
        }
        valuess.add("jprst");
        valuess.add("prJst");
        valuess.add("JonSilver");
        System.out.println("Surname: " + valuess);
        System.out.println("Surname 'J': " + valuess.stream().filter(name -> name.startsWith("J")).count());
        NotOdd ref1;
        ref1 = (d) -> {
            if (d%2==0) return true;
            else return false;
        };

        int sum =  Sum((ArrayList<Integer>) values, ref1);

        System.out.println("Honest: sum = " + sum);

        sum =  Sum((ArrayList<Integer>) values,
                (NotOdd)((d) -> {
                    if (d%2!=0) return true;
                    else return false;
                }));
        System.out.println("Odd: sum = " + sum);



        }
    public static int Sum(ArrayList<Integer> values, NotOdd refLambda) {
        int sum=0;
        for (int i=0; i<values.size(); i++)

            if (refLambda.NotOdd(values.get(i)))
                sum+= values.get(i);

        return sum;
    }

    }

    interface NotOdd{
        boolean NotOdd(int d);
    }



