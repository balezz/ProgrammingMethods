package ru.metrolog.chapter1;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.System.*;

/**
 * Solutions for chapter 1 in Java Programming Methods
 * by BlinovIN and RomanchicVS, 2013
 */
public class Task1B {

    /* Count and array for input numbers */
    int N;
    int[] array;

    /**
     * Constructor only for N, numbers input from console
     */
    public Task1B(int n) {
        N = n;
        array = new int[N];
    }

    /**
     * Constructor for N and array, no need to input from console
     */
    public Task1B(int[] array) {
        N = array.length;
        this.array = array;
    }

    /* Prepare operation */
    public void enterNumbers() {
        out.println("Enter " + N + " integer numbers: ");
        Scanner scanner = new Scanner(in);
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
    }

    /* Task 1B-1*/
    public void printEvenOdds() {
        out.println("Even: \t ");
        for (int i = 0; i < N; i++) {
            if (array[i] % 2 == 0) {
                out.print(array[i] + " ");
            }
        }
        out.println();
        out.println("Odds: \t ");
        for (int i = 0; i < N; i++) {
            if (array[i] % 2 == 1) {
                out.print(array[i] + " ");
            }
        }
    }

    /* Task 1B-2 */
    public void printMinMax() {
        int max_num = array[0];
        int min_num = array[0];
        for (int i = 1; i < N; i++) {
            if (array[i] > max_num) {
                max_num = array[i];
            }
            if (array[i] < min_num) {
                min_num = array[i];
            }
        }
        out.println();
        out.print("Maximum number is: " + max_num);
        out.println();
        out.print("Minimum number is: " + min_num);
    }

    /* Task 1B-3 */
    public void dividedOn3and9() {
        out.print("Divided on 3: ");
        for (int n : array) {
            if (n % 3 == 0) {
                out.print(n + "; ");
            }
        }
        out.println();
        out.print("Divided on 9: ");
        for (int n : array) {
            if (n % 9 == 0) {
                out.print(n + "; ");
            }
        }
        out.println();
    }

    /* Task 1B-4 */
    public void dividedOn5and7() {
        out.print("Divided on 5: ");
        for (int n : array) {
            if (n % 5 == 0) {
                out.print(n + "; ");
            }
        }
        out.println();
        out.print("Divided on 7: ");
        for (int n : array) {
            if (n % 7 == 0) {
                out.print(n + "; ");
            }
        }
        out.println();
    }

    /* Task 1B-5 */
    public void sortBubble() {
        int bubble = 0;
        for (int j = 1; j < N - 1; j++) {
            for (int i = 0; i < N - j -1; i++) {
                if (abs(array[i]) > abs(array[i + 1])) {
                    bubble = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = bubble;
                }
            }
        }
        out.println();
        out.println("Sorted array: " + Arrays.toString(array));
    }

    /* Task 1B-6 */
    public void noSame3digits() {
        int d1, d10, d100 = 0;
        out.println("Numbers with different 3 digits");
        for (int n : array) {
            if ((n > 99) && (n < 1000)) {
                d1 = n % 10;
                d10 = (n / 10) % 10;
                d100 = (n / 100) % 10;
                if ((d1 != d10) || (d1 != d100)) {
                    out.print(n + "; ");
                }
            }
        }
    }

    /* Task 1B-7 */

    /**
     * Method finding GCD for N numbers
     */
    public void gcdN() {
        if (array.length < 1) return;
        int gcdA = gcd(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            gcdA = gcd(gcdA, array[i]);
        }
        out.println("Greatest common divider: " + gcdA);
    }

    /**
     * Method finding GCD for 2 numbers
     */
    static private int gcd(int a, int b) {
        if (b == 0) return a;
        if (a > b) return gcd(b, a - b);
        else return gcd(a, b - a);
    }

    /**
     * Method finding LCM for N numbers
     */
    public void lcmN() {
        if (array.length < 1) return;
        int lcmA = abs(array[0] * array[1]) / gcd(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            lcmA = abs(lcmA * array[i]) / gcd(lcmA, array[i]);
        }
        out.println("Least common multiple: " + lcmA);
    }

    /* Task 1B-8 */
    public void findPrime() {
        out.println("Prime numbers are: ");
        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) out.print(array[i] + " ");
        }
    }

    static private boolean isPrime(int n) {
        if (n < 4) return true;
        int i = 1;
        if ((n % 2 == 0) || (n % 3 == 0)) return false;
        while (6 * i < n / 2) {
            if (((n % (6 * i - 1)) == 0) || ((n % (6 * i + 1)) == 0)) {
                return false;
            }
            ++i;
        }
        return true;
    }

    /* Task 1B-9 */
    public void sortingShaker(boolean ascending) {
        int buff;
        int left = 0;
        int right = array.length - 1;
        if (ascending == true) {
            do {
                for (int i = left; i < right; i++) {
                    if (array[i] > array[i + 1]) {
                        buff = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = buff;
                    }
                }
                right--;
                for (int i = right; i > left; i--) {
                    if (array[i] < array[i - 1]) {
                        buff = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = buff;
                    }
                }
                left++;
            } while (left < right);
        } else {
            do {
                for (int i = left; i < right; i++) {
                    if (array[i] < array[i + 1]) {
                        buff = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = buff;
                    }
                }
                right--;
                for (int i = right; i > left; i--) {
                    if (array[i] > array[i - 1]) {
                        buff = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = buff;
                    }
                }
                left++;
            } while (left < right);
        }
        out.println(Arrays.toString(array));
    }

    /* Task 1B-11 */
    public void printHappy() {
        out.println("Happy numbers: ");
        for (int i = 0; i < array.length; i++) {
            if (isHappy(array[i])) {
                out.print(array[i] + "; ");
            }
        }

    }

    /**
     * Check number is happy ;-)
     */
    static private boolean isHappy(int number) {
        /* Max digital positions for int */
        int N_log = 10;
        int[] digit = new int[N_log];
        int t = number;
        int i = 0;

        // Decomposing number into digit[] array
        while (number > pow(10, i)) {
            digit[i] = t % 10;
            t = t / 10;
            i++;
        }

        int sum_left = 0, sum_right = 0;
        int left = 0, right = i - 1;
        while (left < right) {
            sum_left += digit[left];
            sum_right += digit[right];
            left++;
            right--;
        }
        if (sum_left == sum_right) return true;
        else {
            return false;
        }

    }

    /* Task 1B-12 */
    public void printFibonacci(int n) {
        if (n == 1) {
            out.print(1);
        }
        if (n == 2) {
            out.print(1 + "; " + 1);
        }
        if (n > 2) {
            out.print("Fibonacci series: 1; 1; ");
            int a = 1, b = 1, c = 0;
            for (int i = 1; i < n; i++) {
                c = a + b;
                out.print(c + "; ");
                b = a;
                a = c;
            }
        } else {
            out.print("Enter correct n, please");
        }

    }

    /* Task 1B-13 */
    public void printPaly() {
        out.println("Palyndrome numbers: ");
        for (int i = 0; i < array.length; i++) {
            if (isPaly(array[i])) {
                out.print(array[i] + "; ");
            }
        }
    }

    /**
     * Check number is palyndrome
     */
    static private boolean isPaly(int number) {
        /* Max digital positions for int */
        int N_log = 10;
        int[] digit = new int[N_log];
        int t = number;
        int i = 0;

        // Decomposing number into digit[] array
        while (number > pow(10, i)) {
            digit[i] = t % 10;
            t = t / 10;
            i++;
        }

        int left = 0, right = i - 1;
        while (left < right) {
            if (digit[left] != digit[right]) return false;
            left++;
            right--;
        }

        return true;

    }

    /* Task 1B-14 */
    public void meanNeighbours() {
        int N = array.length;
        float[] mean_arr = new float[N];
        mean_arr[0] = array[0];
        for (int i = 1; i < N; i++) {
            mean_arr[i] = (float) (array[i - 1] + array[i]) / 2;
        }
        out.print("Mean array: " + Arrays.toString(mean_arr));
    }

    /* Task 1B-15 */
    public void periodFraction() {

    }


}

