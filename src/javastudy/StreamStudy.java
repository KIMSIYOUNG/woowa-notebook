package javastudy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy {

    public void practice1(){
        Arrays.asList("a1","a2","a3")
                .stream()
                .findAny()
                .ifPresent(System.out::println);
        Stream.of("a3","a2","a4")
                .findFirst()
                .ifPresent(System.out::println);
    }

    public void primitiveTypeStream(){
        IntStream.range(1,4)
                .forEach(System.out::print);

        IntStream.range(1,4)
                .map(n -> n*2+1)
                .average()
                .ifPresent(System.out::print);

        Stream.of("a1","a2","a3","a4")
                .map(s->s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
    }

    public void orderStream(){
        Stream.of("d1","a2","a1","d1","d2")
                .map(s->{
                    System.out.println("map : " + s);
                    return s.toUpperCase();
                })
                .filter(s->{
                    System.out.println("Filter : " + s);
                    return s.startsWith("A");
                })
                .forEach(s-> System.out.println("FOREACH : " + s));

    }

    public static void main(String[] args) {
        StreamStudy s = new StreamStudy();
        s.practice1();
        s.primitiveTypeStream();
        s.orderStream();

        List<String> list = Arrays.asList("a","b","C","a2","a3","a4");
        list.stream()
                .filter(a->a.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
