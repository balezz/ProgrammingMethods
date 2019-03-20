package ru.metrolog;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] testArray1 = {5, 2, 3, 3, 3, 4, 5};
        int[] testArray2 = {555, -212, 28, 15, 05};

        Task1A task1A = new Task1A();
//        task1A.greetingUser();
//        task1A.reverseArgs(args);
//        task1A.randomNumbers();
//        task1A.passwordCompare();
//        task1A.sumProdArgs(args);
//        task1A.authorDate();

        Task1B task1B = new Task1B(testArray2);
//        task1B.enterNumbers();
//        task1B.printEvenOdds();
//        task1B.printMinMax();
//        task1B.dividedOn3and9();
//        task1B.dividedOn5and7();
//        task1B.sortBubble();
//        task1B.noSame3digits();
//        task1B.freqNumSort();

        task1B.findPeriod(1, 234);
    }
}
