package main

import (
	"fmt"
	"math"
)

func solveGauss(matrix [][]float64) {
	n := len(matrix)

	for i := 0; i < n; i++ {
		if matrix[i][i] == 0 {
			c := 1
			for (i+c) < n && matrix[i+c][i] == 0 {
				c++
			}
			for j, k := i, 0; k <= n; k++ {
				matrix[j][k], matrix[j+c][k] = matrix[j+c][k], matrix[j][k]
			}
		}

		for j := 0; j < n; j++ {
			if j != i {
				p := matrix[j][i] / matrix[i][i]

				for k := 0; k <= n; k++ {
					matrix[j][k] = matrix[j][k] - (matrix[i][k])*p
				}
			}
		}

	}
}

func formResults(matrix [][]float64) []float64 {
	results := make([]float64, len(matrix))
	for i := 0; i < len(matrix); i++ {
		results[i] = matrix[i][len(matrix)] / matrix[i][i]
	}

	return results
}

func buildFuncs(matrix [][]float64) []func(exes []float64) float64 {
	funcs := make([]func(exes []float64) float64, len(matrix))

	for i := 0; i < len(matrix); i++ {
		index := i
		funcs[i] = func(exes []float64) float64 {
			result := matrix[index][len(matrix)]
			for j := 0; j < len(exes); j++ {
				if j == index {
					continue
				}
				result -= matrix[index][j] * exes[j]
			}
			result /= matrix[index][index]

			return result
		}
	}

	return funcs
}

func checkPrecision(exes, prevExes []float64, precision float64) bool {
	var maxDif float64 = 0

	for i := 0; i < len(exes); i++ {
		currentDif := math.Abs(exes[i] - prevExes[i])
		if currentDif > maxDif {
			maxDif = currentDif
		}
	}

	return maxDif < precision
}

func solveIterations(matrix [][]float64, eps float64) []float64 {
	funcs := buildFuncs(matrix)

	prevExes := make([]float64, len(matrix))
	exes := make([]float64, len(matrix))
	for i := 0; i < len(matrix); i++ {
		exes[i] = matrix[i][len(matrix)]
	}

	for !checkPrecision(exes, prevExes, eps) {
		copy(prevExes, exes)

		for i := 0; i < len(funcs); i++ {
			exes[i] = funcs[i](exes)
		}

	}

	return exes
}

func main() {
	matrixG := [][]float64{
		{-1, -7, -3, -2, -12},
		{-8, 1, -9, 0, -60},
		{8, 2, -5, -3, -91},
		{-5, 3, 5, -9, -43},
	}

	//matrixG := [][]float64{{0, 2, 1, 4},
	//	{1, 1, 2, 6},
	//	{2, 1, 1, 7}}

	solveGauss(matrixG)

	fmt.Println(formResults(matrixG))

	matrixI := [][]float64{
		{10, -1, -2, 5, -99},
		{4, 28, 7, 9, 0},
		{6, 5, -23, 4, 67},
		{1, 4, 5, -15, 58},
	}

	fmt.Println(solveIterations(matrixI, 0.01))
}
