package com.kpi;

public class Transposer {
    public double[][] transpose(double[][] matrex){
        double[][] transMatrex = new double[matrex[0].length][matrex.length];
        for(int i = 0; i < matrex.length; i++){
            for(int j = 0; j < matrex[0].length; j++){
                transMatrex[j][i] = matrex[i][j];
            }
        }
        return transMatrex;
    }
}
