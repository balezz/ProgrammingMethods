package ru.metrolog;

import java.util.Scanner;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Task2B {

    /* Task 2B-1 */
    public void isBelongInterval(double n, double m) {
        out.println("Введите число k");
        Scanner scanner = new Scanner(in);
        double k = scanner.nextDouble();

        scanner.close();

        if ((k > n) && (k < n)) {
            out.println(String.format("k пренадлежит интервалу (%f, %f)", n, m));
        } else if ((k >= n) && (k < m)) {
            out.println(String.format("k пренадлежит интервалу [%f, %f)", n, m));
        } else if ((k > n) && (k <= m)) {
            out.println(String.format("k пренадлежит интервалу (%f, %f]", n, m));
        } else if ((k >= n) && (k <= m)) {
            out.println(String.format("k пренадлежит интервалу [%f, %f]", n, m));
        } else {
            out.println(String.format("k не пренадлежит интервалу [%f, %f]", n, m));
        }
    }

    /* Task 2B-2 */
    public void printMatrix() {

        out.println("Введите число k");
        Scanner scanner = new Scanner(in);
        String str = scanner.nextLine();
        int k = Integer.parseInt(str);

        int N = (int) ceil(sqrt(k));

        for (int j = 1; j < N * N; j++) {
            if (j <= k) out.print(j + " \t");
            else out.print(0 + " \t");

            if (j % N == 0) {
                out.println();
            }
        }
        System.out.println();
    }

    /* Task 2B-4 */
    public void printMonth() {
        out.println("Enter month number:");
        Scanner scanner = new Scanner(in);
        int nMonth = scanner.nextInt();
        scanner.close();

        switch (nMonth) {
            case 1:  out.print("Январь");
                break;
            case 2:  out.print("Февраль");
                break;
            case 3:  out.print("Март");
                break;
            case 4:  out.print("Апрель");
                break;
            case 5:  out.print("Май");
                break;
            case 6:  out.print("Июнь");
                break;
            case 7:  out.print("Июль");
                break;
            case 8:  out.print("Август");
                break;
            case 9:  out.print("Сентябрь");
                break;
            case 10: out.print("Октябрь");
                break;
            case 11: out.print("Ноябрь");
                break;
            case 12: out.print("Декабрь");
                break;
            default: out.print("No such month!");
        }
    }


}
