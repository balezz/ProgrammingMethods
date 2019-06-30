package ru.metrolog.chapter2;

public class Task2A {

    /* Task 2A-1 */
    public void minMaxNumbers(int[] array) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int elem : array) {
            if (numLength(elem) > numLength(max)) max = elem;
            if (numLength(elem) < numLength(min)) min = elem;
        }
        System.out.println("Min Length: " + min);
        System.out.println("Max Length: " + max);
    }


    /* Finding length (nDigit) of number X */
    private static int numLength(int number) {
        int nDig = 0;
        while (number > 0) {
            number /= 10;
            ++nDig;
        }
        return nDig;
    }
}
