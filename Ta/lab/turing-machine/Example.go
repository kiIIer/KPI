package main

import (
	"fmt"
	"os"
	"turing-machine/machineCore"
)

const (
	blank     = ' '
	zero      = '0'
	one       = '1'
	separator = '#'
)

func main() {
	instructions := getInstructions()

	machine := machineCore.NewMachine(6, os.Args[1], instructions...)

	fmt.Println(machine)

	machine.Run()

	fmt.Println(machine)
	fmt.Println(machine.Stats())
}

func getInstructions() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions, prepareInput()...)
	instructions = append(instructions, chooseFormula()...)
	instructions = append(instructions, formula1()...)
	instructions = append(instructions, formula2()...)

	return instructions
}
