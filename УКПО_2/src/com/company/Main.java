package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void show(double[][] matrix, double[] y, int n) {     //n - кол-во строк
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "*x" + j);
                if (j < n - 1) {
                    System.out.print(" + ");
                }
            }
            System.out.print(" = " + y[i] + "\n");
        }
    }

    public static int findMax(double[][] matrix, int n, int k) {  //Поиск строки с максимальным matrix[i][k]
        double max = Math.abs(matrix[k][k]);
        int index = k;
        for (int i = k + 1; i < n; i++) {
            if (Math.abs(matrix[i][k]) > max) {
                max = Math.abs(matrix[i][k]);
                index = i;
            }
        }
        return index;
    }

    public static double[] gauss(double[][] matrix, double[] y, int n) {
        double[] x;
        double max;
        int k, index;
        double eps = 0.00001;
        x = new double[n];
        k = 0;
        while (k < n) {
            index = findMax(matrix,n,k);
            //Перетасовка строк
            if (matrix[index][k] < eps) {
                //Нет нулевых диагональных элементов
                System.out.print("Решение получить невозможно из-за нулевого столбца " + index + " матрицы\n");
                break;
            }
            for (int j = 0; j < n; j++) {
                double temp = matrix[k][j];
                matrix[k][j] = matrix[index][j];
                matrix[index][j] = temp;
            }
            double temp = y[k];
            y[k] = y[index];
            y[index] = temp;
            //Нормализация уровней
            for (int i = k; i < n; i++) {
                double temp1 = matrix[i][k];
                if (Math.abs(temp1) < eps) continue; // для нулевого коэффициента пропустить
                for (int j = 0; j < n; j++)
                    matrix[i][j] = matrix[i][j] / temp1;
                y[i] = y[i] / temp1;
                if (i == k)  continue; // уравнение не вычитать само из себя
                for (int j = 0; j < n; j++)
                    matrix[i][j] = matrix[i][j] - matrix[k][j];
                y[i] = y[i] - y[k];
            }
            k++;
        }
        //Обратная подстановка
        for (k = n - 1; k >= 0; k--) {
            x[k] = y[k];
            for (int i = 0; i < k; i++)
                y[i] = y[i] - matrix[i][k] * x[k];
        }
        return x;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[][] matrix;
        double[] y;
        double[] x;
        int n;
        System.out.print("Введите кол-во уравнений: ");
        n = Integer.parseInt(reader.readLine());
        System.out.println();
        matrix = new double[n][3];
        y = new double[n];
        for (int i = 0; i < n; i++)
        {
            matrix[i] = new double[n];
            for (int j = 0; j < n; j++)
            {
                System.out.print("a[" + i + "][" + j + "]= ");
                matrix[i][j] = Double.parseDouble(reader.readLine());
            }
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print("y[" + i + "]= ");
            y[i] = Double.parseDouble(reader.readLine());
        }
        show(matrix, y, n);
        x = gauss(matrix, y, n);
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "]=" + x[i]);
        }
//        double[] x = Main.gauss(new double[][] {{1,0,2},{3,0,5},{5,0,1}}, new double[] {12,56,87},3);
//                for (int i = 0; i < 3; i++) {
//            System.out.println("x[" + i + "]=" + x[i]);
//        }

    }
}