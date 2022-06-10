package main

import (
	"fmt"
	"turing-machine/machineCore"
)

func prepareInput() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Prepare to split
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "init" {
				machine.WriteState("split-input")

				fmt.Println(machine)
			}
		},
	)
	instructions = append(instructions, splitInput()...)
	instructions = append(instructions, normalize()...)

	return instructions
}

func splitInput() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		//Copy x to T1
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "split-input" {
				if machine.Read(0) != separator {
					machine.Write(machine.Read(0), 1)
					machine.Write(blank, 0)
					machine.MoveR(0, 1)
				}
				if machine.Read(0) == separator {
					machine.Write(blank, 0)
					machine.MoveR(0)
					machine.MoveL(1)
					machine.WriteState("split-input-y")
				}

				fmt.Println(machine)
			}
		},
		//Copy y to T2
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "split-input-y" {
				if machine.Read(0) != blank {
					machine.Write(machine.Read(0), 2)
					machine.Write(blank, 0)
					machine.MoveR(0, 2)
				}
				if machine.Read(0) == blank {
					machine.MoveL(2)
					machine.WriteState("normalize")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func normalize() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Make x and y one length
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "normalize" {
				if machine.Read(1) != blank || machine.Read(2) != blank {
					if machine.Read(1) == blank {
						machine.Write(zero, 1)
					}
					if machine.Read(2) == blank {
						machine.Write(zero, 2)
					}
					machine.Write(zero, 4)
					machine.MoveL(1, 2, 4)
				}
				if machine.Read(1) == blank && machine.Read(2) == blank {
					machine.MoveR(1, 2, 4)
					machine.WriteState("choose-formula")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}
