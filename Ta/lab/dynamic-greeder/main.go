package main

import (
	"bufio"
	"dynamic-greeder/combowombo"
	"dynamic-greeder/factorial"
	"dynamic-greeder/fibonacci"
	"dynamic-greeder/greeder"
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

func greed() {
	greedy := greeder.NewGreeder()
	tasks := make([]*greeder.Task, 5)
	tasks[4] = greeder.NewTask(2, 1)
	tasks[1] = greeder.NewTask(2, 1)
	tasks[2] = greeder.NewTask(3, 1)
	tasks[3] = greeder.NewTask(1, 10)
	tasks[0] = greeder.NewTask(2, 100)
	solution := greedy.Solve(tasks)
	profit := 0
	for _, task := range solution {
		profit += task.Cost
		println(task.Deadline, task.Cost)
	}
	println(profit)
}

func main() {
	greed()
}
