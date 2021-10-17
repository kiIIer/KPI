package com.kpi;

public class App {
    public static void main(String[] args) {
        double[][] matrix = new double[][] { { 8, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, -234, 4 }, { 1, 2, 3, 4 } };

        Printer printer = new Printer();
        printer.printM(matrix);

        System.out.println("\n 2nd task \n");

        SecondTask task2 = new SecondTask();
        double[][] res2 = task2.lolSwap(matrix);
        printer.printM(res2);

        System.out.println("\n 3rd task\n");

        ThirdTask task3 = new ThirdTask();
        double[][] res3 = task3.swapColumns(matrix);
        printer.printM(res3);

        System.out.println("\n 4th task\n");

        FourthTask task4 = new FourthTask();
        double[][] res4 = task4.transpose(matrix);
        printer.printM(res4);
    }

}
