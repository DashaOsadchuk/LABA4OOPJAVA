package main;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Main prog = new Main();
        prog.run();
    }

    private void run() {
        double x = 1, step = getStep();
        int n = calcN(step);
        double[] xArr = createArr(n), yArr = createArr(n);
        for (int i = 0; i < n; i++) {
            xArr[i] = x;
            yArr[i] = calcY(x,2.4);
            x+=step;
            //System.out.println(x);
        }
        int maxE_x = getMinMaxNum(xArr, true), minE_x = getMinMaxNum(xArr, false), maxE_y = getMinMaxNum(yArr, true), minE_y = getMinMaxNum(yArr, false);
        double[] xN = getSumAndArif(xArr), yN = getSumAndArif(yArr);
        printValues(xArr, minE_x, maxE_x, xN);
        printValues(yArr, minE_y, maxE_y, yN);
    }

    private int getMinMaxNum(double[] arr, boolean max) {
        double buff = arr[0];
        int n = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < buff && max) {
                buff = arr[i];
                n = i;
            } else if (buff < arr[i] && !max) {
                buff = arr[i];
                n = i;
            }
        }
        return n;
    }

    protected double[] getSumAndArif(double[] arr) {
        double[] out = new double[2];
        double buff = 0;
        for (int i = 0; i < arr.length; i++) {
            buff += arr[i];
        }
        out[0] = buff;
        out[1] = buff/arr.length;
        return out;
    }

    private void printValues(double[] arr, int nMin, int nMax, double[] sumArif) {
        System.out.println("Minimal element number: [" + nMin + "] = " + arr[nMin] + "\nMaximal element number: [" + nMax + "] = " + arr[nMax] +
                "\nSumm of elements: " + sumArif[0] + "\nMiddle value of elements: " + sumArif[1]);
    }

    protected double[] createArr(int amountOfElem) {
        return new double[amountOfElem];
    }

    private double getStep() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    protected int calcN(double step) {
        int amount = 0;
        for (double i = 1; i <= 5; i+=step) {
            amount++;
        }
        return amount;
    }

    protected double calcY(double x, double a) {
        if (x > a) {
            return x*Math.sqrt(x-a);
        } else if (x == a) {
            return (x * Math.sin(a) * x);
        } else if (x < a) {
            return Math.pow(Math.exp(0),-a*x) * Math.cos(a) * x;
        } else {
            return 0;
        }
    }
}

