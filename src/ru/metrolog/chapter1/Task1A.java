package ru.metrolog.chapter1;

import ru.metrolog.TestArrays;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.Math.round;

/**
 * Class with Chapter 1-A solutions
 *
 * @author LabintsevAI
 */
public class Task1A {
    private String author = "LabintsevAI";
    private String dateBegin = "13.03.2019 16:00";
    private String dateEnd = "14.03.2019 11:20";

    public void run() {
        greetingUser();

        System.out.println(Arrays.toString(
                reverseArgs(TestArrays.STRING_ARRAY_1)));

        System.out.println(Arrays.toString(
                randomNumbers() ));

        System.out.println(passwordCompare());

        System.out.println(sumProdArgs(TestArrays.STRING_ARRAY_2));

        System.out.println(authorDate());


    }

    /** Task 1A-1 */
    private void greetingUser() {
        System.out.println("Enter your name, please: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }

    /** Task 1A-2 */
    private String[] reverseArgs(String[] args) {
        int argSize = args.length;
        String[] result = new String[argSize];
        for (int i = 0; i < argSize; i++) {
            result[i] = args[argSize - i - 1];
        }
        return result;
    }

    /** Task 1A-3 */
    private int[] randomNumbers() {
        System.out.println("Enter random number array size: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] randomArray = new int[N];
        System.out.println("Random number array is: ");
        for (int i = 0; i < N; i++) {
            randomArray[i] = (int) round(10 * random());
        }
        return randomArray;
    }

    /** Task 1A-4 */
    private String passwordCompare() {
        String passwordCorrect = "qwerty";
        System.out.println("Enter a password, please: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        if (password.equals(passwordCorrect))
            return "You are right!";
        else
            return "Access denied :( ";

    }

    /** Task 1A-5 */
    private String sumProdArgs(String[] args) {
        int sumArgs = Integer.parseInt(args[0]);
        int prodArgs = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length; i++) {
            sumArgs += Integer.parseInt(args[i]);
            prodArgs *= Integer.parseInt(args[i]);
        }
        return String.format(
                "The sum of args = %d, the product of args = %d", sumArgs, prodArgs);
    }

    /** Task 1A-6 */
    private String authorDate() {
        return String.format("Author is %s\n" +
        "Date and time of task 1A begin: %s\n" +
        "Date and time of task 1A end: %s\n", author, dateBegin, dateEnd);

    }
}
