package com.kpi;

public class Swapper {
    public double[][] lolSwap(double[][] matrex){
        double[] first = matrex[0];
        matrex[0] = matrex[matrex.length-1]; 
        matrex[matrex.length-1] = first;
        return matrex;
    }
}
