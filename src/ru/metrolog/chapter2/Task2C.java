package ru.metrolog.chapter2;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.Math.round;
import static java.lang.System.in;
import static java.lang.System.out;

public class Task2C {

    double[][] matrix;
    int N;

    /* Task2C-1 */
    public void sortMatrix() {
        createMatrix();
        printMatrix();
        out.println("Rounded matrix:");
        roundMatrix();
        printMatrix();
        bubbleSort();
        out.println("Sorted by columns matrix:");
        printMatrix();
    }

    /* Task2C-14*/
    public void roundMatrix() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = round(matrix[i][j]);
            }
        }
    }

    private void bubbleSort() {
        double bubble;
        for (int k = 0; k < N; k++) {
            for (int j = 1; j < N; j++) {
                for (int i = 0; i < N - j; i++) {
                    if (matrix[i][k] > matrix[i + 1][k]) {
                        bubble = matrix[i][k];
                        matrix[i][k] = matrix[i + 1][k];
                        matrix[i + 1][k] = bubble;
                    }
                }
            }
        }
    }

    private void createMatrix() {
        out.println("Hello, sir! Enter size or matrix: ");
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 2 * n * random() - n;
            }
        }
        this.N = n;
    }

    private void printMatrix() {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            out.println(Arrays.toString(matrix[i]));
        }
    }


}
