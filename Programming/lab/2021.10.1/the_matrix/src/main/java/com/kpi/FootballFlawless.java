package com.kpi;

import java.util.ArrayList;
import java.util.List;

public class FootballFlawless implements IMatrixProcessor {

    public void process(double[][] matrix) {
        int[] result = toArrayConvert(getFTeams(matrix));

        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public List<Integer> getFTeams(double[][] matrix) {
        List<Integer> teams = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            if (checkTeam(matrix[i])) {
                teams.add(i);
            }
        }

        return teams;
    }

    private boolean checkTeam(double[] teamResult) {
        int numberOfZeros = 0;

        for (double matchResult : teamResult) {
            if (matchResult == 0) {
                numberOfZeros++;
            }
        }

        if (numberOfZeros == 1) {
            return true;
        }
        return false;

    }

    private int[] toArrayConvert(List<Integer> list) {
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        
        return array;
    }

}
