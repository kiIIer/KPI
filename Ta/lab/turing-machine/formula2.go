package main

import (
	"fmt"
	"turing-machine/machineCore"
)

func formula2() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Start calculations
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "formula-2" {
				machine.WriteState("f2-position")

				fmt.Println(machine)
			}
		},
	)
	instructions = append(instructions, f2Position()...)
	instructions = append(instructions, f2CopyY()...)
	instructions = append(instructions, f2PositionForMulti()...)
	instructions = append(instructions, f2Multi()...)
	instructions = append(instructions, f2Add()...)
	instructions = append(instructions, f2Return()...)

	return instructions
}

func f2Position() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Position x and y at right
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-position" {
				if machine.Read(1) != blank {
					machine.MoveR(1, 2, 4)
				}
				if machine.Read(1) == blank {
					machine.MoveL(1, 2)
					machine.WriteState("f2-copy-y")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f2CopyY() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		// Copy T2 to T3
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-copy-y" {

				if machine.Read(2) != blank {
					machine.Write(machine.Read(2), 3)
					machine.MoveL(2, 3)
				}
				if machine.Read(2) == blank {
					machine.MoveR(2, 3)
					machine.WriteState("f2-position-m")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f2PositionForMulti() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-position-m" {
				if machine.Read(2) != blank {
					machine.MoveR(2, 3)
				}
				if machine.Read(2) == blank {
					machine.MoveL(2, 3)
					machine.WriteState("f2-m")
				}
			}
		},
	)

	return instructions
}

func f2Multi() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-m" {
				machine.WriteState("f2-check-top")

				fmt.Println(machine)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-check-top" {
				if machine.Read(2) == zero {
					machine.WriteState("f2-m2")
					machine.MoveL(2)
				} else if machine.Read(2) == one {
					machine.WriteState("f2-m-add")
					machine.MoveL(2)
				} else {
					machine.WriteState("f2-add")
				}

				fmt.Println(machine)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-m2" {
				machine.MoveR(3)
				machine.Write(zero, 3)
				machine.WriteState("f2-check-top")

				fmt.Println(machine)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-m-add" {
				machine.WriteState("f2-m-add-zero")

				fmt.Println(machine)
			}
		},
		// Add without one in memory
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-m-add-zero" {
				if machine.Read(4) == blank {
					machine.Write(zero, 4)
				}
				if machine.Read(3) == zero && machine.Read(4) == zero {
					machine.Write(zero, 5)
					machine.MoveL(3, 4, 5)
				}
				if machine.Read(3) == one && machine.Read(4) == zero || machine.Read(3) == zero && machine.Read(4) == one {
					machine.Write(one, 5)
					machine.MoveL(3, 4, 5)
				}
				if machine.Read(3) == one && machine.Read(4) == one {
					machine.Write(zero, 5)
					machine.WriteState("f2-m-add-one")
					machine.MoveL(3, 4, 5)
				}
				if machine.Read(3) == blank && machine.ReadState() != "f2-m-add-one" {
					machine.MoveR(3, 4, 5)
					machine.WriteState("f2-m-pos-cop")
				}

				fmt.Println(machine)
			}
		},
		// Add with one in memory
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-m-add-one" {
				if machine.Read(4) == blank {
					machine.Write(zero, 4)
				}
				if machine.Read(3) == zero && machine.Read(4) == zero {
					machine.Write(one, 5)
					machine.WriteState("f2-m-add-zero")
					machine.MoveL(3, 4, 5)
				}
				if machine.Read(3) == one && machine.Read(4) == one {
					machine.Write(one, 5)
					machine.MoveL(3, 4, 5)
				}
				if machine.Read(3) == one && machine.Read(4) == zero || machine.Read(3) == zero && machine.Read(4) == one {
					machine.Write(zero, 5)
					machine.MoveL(3, 4, 5)
				}
				if machine.Read(3) == blank {
					machine.MoveR(3, 4)
					machine.Write(one, 5)
					machine.WriteState("f2-m-pos-cop")
				}

				fmt.Println(machine)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-m-pos-cop" {
				if machine.Read(3) != blank {
					machine.MoveR(3)
				}
				if machine.Read(5) != blank {
					machine.Write(machine.Read(5), 4)
					machine.MoveR(4, 5)
				}
				if machine.Read(3) == blank && machine.Read(5) == blank {
					machine.MoveL(3, 4, 5)
					machine.WriteState("f2-m2")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f2Add() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-add" {
				machine.WriteState("f2-add-zero")
			}

			fmt.Println(machine)
		},
		// Add without one in memory
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-add-zero" {
				if (machine.Read(1) == blank || machine.Read(4) == blank) && machine.Read(1) != machine.Read(4) {
					if machine.Read(1) == blank {
						machine.Write(zero, 1)
					}
					if machine.Read(4) == blank {
						machine.Write(zero, 4)
					}
				}
				if machine.Read(1) == zero && machine.Read(4) == zero {
					machine.Write(zero, 5)
					machine.MoveL(1, 4, 5)
				}
				if machine.Read(1) == one && machine.Read(4) == zero || machine.Read(1) == zero && machine.Read(4) == one {
					machine.Write(one, 5)
					machine.MoveL(1, 4, 5)
				}
				if machine.Read(1) == one && machine.Read(4) == one {
					machine.Write(zero, 5)
					machine.WriteState("f2-add-one")
					machine.MoveL(1, 4, 5)
				}
				if machine.Read(1) == blank && machine.ReadState() != "f2-add-one" {
					machine.MoveR(1, 4, 5)
					machine.WriteState("f2-return")
				}

				fmt.Println(machine)
			}
		},
		// Add with one in memory
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-add-one" {
				if (machine.Read(1) == blank || machine.Read(4) == blank) && machine.Read(1) != machine.Read(4) {
					if machine.Read(1) == blank {
						machine.Write(zero, 1)
					}
					if machine.Read(4) == blank {
						machine.Write(zero, 4)
					}
				}
				if machine.Read(1) == zero && machine.Read(4) == zero {
					machine.Write(one, 5)
					machine.WriteState("f2-add-zero")
					machine.MoveL(1, 4, 5)
				}
				if machine.Read(1) == one && machine.Read(4) == one {
					machine.Write(one, 5)
					machine.MoveL(1, 4, 5)
				}
				if machine.Read(1) == one && machine.Read(4) == zero || machine.Read(1) == zero && machine.Read(4) == one {
					machine.Write(zero, 5)
					machine.MoveL(1, 4, 5)
				}
				if machine.Read(1) == blank {
					machine.MoveR(1, 4)
					if machine.ReadState() != "f2-add-zero" {
						machine.Write(one, 5)
					} else {
						machine.MoveR(5)
					}
					machine.WriteState("f2-return")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}

func f2Return() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-return" {
				if machine.Read(5) != blank {
					machine.MoveR(5)
				}
				if machine.Read(5) == blank {
					machine.MoveL(5)
					machine.WriteState("f2-print-result")
				}

				fmt.Println(machine)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "f2-print-result" {
				if machine.Read(5) != blank {
					machine.Write(machine.Read(5), 0)
					machine.MoveL(0, 5)
				}
				if machine.Read(5) == blank {
					machine.WriteState("return")
				}

				fmt.Println(machine)
			}
		},
	)

	return instructions
}
