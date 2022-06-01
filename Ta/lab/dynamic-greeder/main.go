package main

import (
	"bufio"
	"dynamic-greeder/combowombo"
	"dynamic-greeder/factorial"
	"dynamic-greeder/fibonacci"
	"os"
	"strconv"
)

func fib() {
	fib := fibonacci.NewFibonacci()
	reader := bufio.NewReader(os.Stdin)
	for {
		line, _, err := reader.ReadLine()
		if err != nil {
			continue
		}

		n, err := strconv.Atoi(string(line))
		if err != nil {
			continue
		}

		println("Fib: ", fib.CalcNth(n))
	}
}

func fac() {
	fac := factorial.NewFactorial()
	reader := bufio.NewReader(os.Stdin)
	for {
		line, _, err := reader.ReadLine()
		if err != nil {
			continue
		}

		n, err := strconv.Atoi(string(line))
		if err != nil {
			continue
		}

		println("Fac: ", fac.CalcNth(n))
	}
}

func comb() {
	comb := combowombo.NewComboWombo()
	reader := bufio.NewReader(os.Stdin)
	for {
		line, _, err := reader.ReadLine()
		if err != nil {
			continue
		}
		top, err := strconv.Atoi(string(line))
		if err != nil {
			continue
		}

		_, _, err = reader.ReadLine()
		if err != nil {
			continue
		}
		bot, err := strconv.Atoi(string(line))
		if err != nil {
			continue
		}

		println("Combo: ", comb.Calc(top, bot))
	}
}

func main() {
	comb()
}
