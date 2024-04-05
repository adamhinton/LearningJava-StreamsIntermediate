package dev.lpa;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        IntStream.iterate((int) 'A', i-> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
//                .filter(i -> Character.toUpperCase(i) > 'E')
//                .skip(5)
//                .takeWhile(i -> i < 'a')
                // Only evaluated for els until it first becomes false
                // Once it reaches 'F' it stops checking
                // This distinguishes it in fxnlty from .filter
//                .dropWhile(i -> Character.toUpperCase(i )<= 'E')
                .forEach(d -> System.out.printf("%c ", d));


        System.out.println("---------------------");
        System.out.println("---------------------");

        Random random = new Random();

        // If this feels like SQL that's for good reason
        // Lets you say what should happen, not *how* it will happen
        // Lets us do what we're good at, in other words.
        Stream.generate(() -> random.nextInt((int)'A', (int)'Z' + 1))
                .limit(50)
//                .distinct()
                .sorted()
                .forEach(d-> System.out.printf("%c", d));



    System.out.println("---------------------");
    int maxSeats = 100;
    int seatsInRow = 10;
    // Intellij intelligently shows final stream type, cool
    var stream = Stream.iterate(0, i -> i < maxSeats, i -> i+1)
            // THis is now a stream of Seats
                .map(i-> new Seat((char) ('A' + i / seatsInRow),
                        i & seatsInRow + 1))
                        .map(Seat::toString);


        stream.forEach(System.out::println);



    }
}