package com.kpi;

import java.util.ArrayList;
import java.util.List;

public class FootballFlawless implements IMatrixProcessor {

    public void process(double[][] matrix) throws IllegalArgumentException {
        validate(matrix);

        List<Integer> flawlessTeams = getFlawlessTeams(matrix);

        for (int teamIndex : flawlessTeams) {
            System.out.print(teamIndex + " ");
        }
        System.out.println();
    }

    private void validate(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("This aint a football score");
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix.length; column++) {
                double opponentMatchResult = matrix[column][row];
                double matchResult = matrix[row][column];

                if (row == column) {
                    int diagonalZero = 0;
                    if (matrix[row][column] != diagonalZero) {
                        throw new IllegalArgumentException("This aint a foorball score");
                    }
                    continue;
                }

                int defeat = 0;
                int draw = 1;
                int victory = 2;

                if (matchResult == victory && opponentMatchResult == defeat) {
                    continue;
                }
                if (matchResult == draw && opponentMatchResult == draw) {
                    continue;
                }
                if (matchResult == defeat && opponentMatchResult == victory) {
                    continue;
                }

                throw new IllegalArgumentException("This aint a football score");

            }
        }
    }

    private List<Integer> getFlawlessTeams(double[][] matrix) {
        List<Integer> teams = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            if (isFlawless(matrix[i])) {
                teams.add(i);
            }
        }

        return teams;
    }

    private boolean isFlawless(double[] teamResult) {
        int numberOfZeros = 0;

        for (double matchResult : teamResult) {
            if (matchResult == 0) {
                numberOfZeros++;
            }
        }

        return numberOfZeros == 1;
    }
}
