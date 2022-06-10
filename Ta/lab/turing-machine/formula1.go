package main

import (
	"fmt"
	"turing-machine/machineCore"
)

func formula1() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Start calculations
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "formula-1" {
				machine.WriteState("f1-position")

				fmt.Println(machine)
			}
		},
	)
	instructions = append(instructions, f1Position()...)
	instructions = append(instructions, f1Add()...)
	instructions = append(instructions, f1PositionForMulti()...)
	instructions = append(instructions, f1Multi()...)
	instructions = append(instructions, f1Return()...)

	return instructions
}

func f1Position() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Position x and y at right
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f1-position" {
				if machine.Read(1) != blank {
					machine.MoveR(1, 2)
				}
				if machine.Read(1) == blank {
					machine.MoveL(1, 2)
					machine.WriteState("f1-add")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f1Add() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Start addition
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f1-add" {
				machine.WriteState("f1-add-zero")

				fmt.Println(machine)
			}
		},
		// Add without one in memory
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f1-add-zero" {
				if machine.Read(1) == zero && machine.Read(2) == zero {
					machine.Write(zero, 3)
					machine.MoveL(1, 2, 3)
				}
				if machine.Read(1) == one && machine.Read(2) == zero || machine.Read(1) == zero && machine.Read(2) == one {
					machine.Write(one, 3)
					machine.MoveL(1, 2, 3)
				}
				if machine.Read(1) == one && machine.Read(2) == one {
					machine.Write(zero, 3)
					machine.WriteState("f1-add-one")
					machine.MoveL(1, 2, 3)
				}
				if machine.Read(1) == blank && machine.ReadState() != "f1-add-one" {
					machine.MoveR(1, 2, 3)
					machine.WriteState("f1-position-m")
				}

				fmt.Println(machine)
			}
		},
		// Add with one in memory
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f1-add-one" {
				if machine.Read(1) == zero && machine.Read(2) == zero {
					machine.Write(one, 3)
					machine.WriteState("f1-add-zero")
					machine.MoveL(1, 2, 3)
				}
				if machine.Read(1) == one && machine.Read(2) == one {
					machine.Write(one, 3)
					machine.MoveL(1, 2, 3)
				}
				if machine.Read(1) == one && machine.Read(2) == zero || machine.Read(1) == zero && machine.Read(2) == one {
					machine.Write(zero, 3)
					machine.MoveL(1, 2, 3)
				}
				if machine.Read(1) == blank {
					machine.MoveR(1, 2)
					if machine.ReadState() != "f1-add-zero" {
						machine.Write(one, 3)
					} else {
						machine.MoveR(3)
					}
					machine.WriteState("f1-position-m")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f1PositionForMulti() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Go to right of T3
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f1-position-m" {
				if machine.Read(3) != blank {
					machine.MoveR(3)
				}
				if machine.Read(3) == blank {
					machine.MoveL(3)
					machine.WriteState("f1-m")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f1Multi() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Add zero to the right of T3
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f1-m" {
				machine.MoveR(3)
				machine.Write(zero, 3)
				machine.WriteState("f1-return")

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f1Return() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Write result
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f1-return" {
				if machine.Read(3) != blank {
					machine.Write(machine.Read(3), 0)
					machine.MoveL(0, 3)
				}
				if machine.Read(3) == blank {
					machine.WriteState("return")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}
