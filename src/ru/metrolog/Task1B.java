package ru.metrolog;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Solutions for chapter 1 in Java Programming Methods
 * by BlinovIN and RomanchicVS, 2013
 */
public class Task1B {

    /* Count and array for input numbers */
    int N;
    int[] array;

    /* Constructor only for N,
     * numbers input from console */
    public Task1B(int n) {
        N = n;
        array = new int[N];
    }

    /* Constructor for N and array,
     * no need to input from console */
    public Task1B(int[] array) {
        N = array.length;
        this.array = array;
    }

    /* Prepare operation */
    public void enterNumbers() {
        System.out.println("Enter " + N + " integer numbers: ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
    }

    /* Task 1B-1*/
    public void printEvenOdds() {
        System.out.println("Even: \t ");
        for (int i = 0; i < N; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Odds: \t ");
        for (int i = 0; i < N; i++) {
            if (array[i] % 2 == 1) {
                System.out.print(array[i] + " ");
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
        System.out.println();
        System.out.print("Maximum number is: " + max_num);
        System.out.println();
        System.out.print("Minimum number is: " + min_num);
    }


    /* Task 1B-3 */
    public void dividedOn3and9() {
        System.out.print("Divided on 3: ");
        for (int n : array) {
            if (n % 3 == 0) {
                System.out.print(n + "; ");
            }
        }
        System.out.println();
        System.out.print("Divided on 9: ");
        for (int n : array) {
            if (n % 9 == 0) {
                System.out.print(n + "; ");
            }
        }
        System.out.println();
    }

    /* Task 1B-4 */
    public void dividedOn5and7() {
        System.out.print("Divided on 5: ");
        for (int n : array) {
            if (n % 5 == 0) {
                System.out.print(n + "; ");
            }
        }
        System.out.println();
        System.out.print("Divided on 7: ");
        for (int n : array) {
            if (n % 7 == 0) {
                System.out.print(n + "; ");
            }
        }
        System.out.println();
    }

    /* Task 1B-5 */
    public void sortBubble() {
        int bubble = 0;
        for (int j = 1; j < N - 1; j++) {
            for (int i = 0; i < N - j; i++) {
                if (array[i] > array[i + 1]) {
                    bubble = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = bubble;
                }
            }
        }
        System.out.println();
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    /* Task 1B-6 */
    public void noSame3digits() {
        int d1, d10, d100 = 0;
        System.out.println("Numbers with different 3 digits");
        for (int n : array) {
            if ((n > 99) && (n < 1000)) {
                d1 = n % 10;
                d10 = (n / 10) % 10;
                d100 = (n / 100) % 10;
                if ((d1 != d10) || (d1 != d100)) {
                    System.out.print(n + "; ");
                }
            }
        }

    }

    /* Task 1B-10 */
    public void freqNumSort() {
        int[] freq = new int[N];
        int freqTmp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i] == array[j]) {
                    freqTmp += 1;
                }
            }
            freq[i] = freqTmp;
            freqTmp = 0;
        }
        int[] freqSorted = sortFreq(freq, array);
        System.out.println(Arrays.toString(freqSorted));
    }

    public static int[] sortFreq(int[] freq, int[] array) {
        int bubleA;
        int bubleF;
        int N = array.length;
        for (int j = 1; j < N - 1; j++) {
            for (int i = 0; i < N-j; i++) {
                if (freq[i] < freq[i + 1]) {
                    bubleA = array[i];
                    bubleF = freq[i];
                    array[i] = array[i + 1];
                    freq[i] = freq[i + 1];
                    array[i+1] = bubleA;
                    freq[i + 1] = bubleF;
                }
            }
        }
        return array;
    }
}
