package main

import (
	"fmt"
	"turing-machine/machineCore"
)

func chooseFormula() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "choose-formula" {
				if machine.Read(1) == one && machine.Read(2) == zero {
					machine.WriteState("formula-1")
				}
				if machine.Read(1) == zero && machine.Read(2) == one {
					machine.WriteState("formula-2")
				}
				if machine.Read(1) == blank {
					machine.WriteState("formula-2")
					machine.MoveL(1, 2)
					machine.MoveL(1, 2)
				}
				machine.MoveR(1, 2)
				fmt.Println(machine)
			}
		},
	)

	return instructions
}
