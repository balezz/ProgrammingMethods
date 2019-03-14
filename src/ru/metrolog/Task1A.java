package ru.metrolog;

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

    /* Task 1A-1 */
    public void greetingUser() {
        System.out.println("Enter your name, please: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }

    /* Task 1A-2 */
    public void reverseArgs(String[] args) {
        int argSize = args.length;
        System.out.println(argSize);
        for (int i = argSize - 1; i >= 0; --i) {
            System.out.print(args[i] + " ");
        }
    }

    /* Task 1A-3 */
    public void randomNumbers() {
        System.out.println("Enter random number array size: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();
        int[] randomArray = new int[N];
        System.out.println("Random number array is: ");
        for (int i = 0; i < N; i++) {
            randomArray[i] = (int) round(10 * random());
            System.out.print(randomArray[i] + "; ");
        }
    }

    /* Task 1A-4 */
    public void passwordCompare() {
        String passwordCorrect = "qwerty";
        System.out.println("Enter a password, please: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        scanner.close();
        if (password.equals(passwordCorrect)) {
            System.out.println("You are right!");
        } else {
            System.out.println("Access denided");
        }
    }

    /* Task 1A-5 */
    public void sumProdArgs(String[] args) {
        int sumArgs = Integer.parseInt(args[0]);
        int prodArgs = Integer.parseInt(args[0]);
        for (int i = 1; i < args.length; i++) {
            sumArgs += Integer.parseInt(args[i]);
            prodArgs *= Integer.parseInt(args[i]);
        }
        System.out.println();
        System.out.println("The sum of args = " + sumArgs);
        System.out.println("The product of args = " + prodArgs);
    }

    /* Task 1A-6 */
    public void authorDate() {
        System.out.println("Author is " + author);
        System.out.println("Date and time of task 1A begin: " + dateBegin);
        System.out.println("Date and time of task 1A end: " + dateEnd);

    }
}
