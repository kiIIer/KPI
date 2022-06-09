package main

import (
	"fmt"
	"turing-machine/machineCore"
)

const one = '1'
const zero = '0'
const separator = '#'
const blank = ' '

func main() {
	instructions := getInstructions()

	machine := machineCore.NewMachine(4, "101#11", instructions...)
	machine.Run()

	fmt.Println(machine)
}

func getInstructions() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions, separateParams()...)
	instructions = append(instructions, goBackToX()...)
	instructions = append(instructions, normalize()...)
	instructions = append(instructions, selectMathFunc()...)
	instructions = append(instructions, func1()...)

	return instructions
}

func separateParams() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions, goToSeparator()...)
	instructions = append(instructions, copyY()...)

	return instructions
}

func goToSeparator() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "init" && machine.Read(0) != separator {
				machine.MoveR(0)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "init" && machine.Read(0) == separator {
				machine.Write(blank, 0)
				machine.MoveR(0)
				machine.WriteState("copy-y")
			}
		})

	return instructions
}

func copyY() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "copy-y" && machine.Read(0) != blank {
				machine.Write(machine.Read(0), 1)
				machine.Write(blank, 0)
				machine.MoveR(0, 1)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "copy-y" && machine.Read(0) == blank {
				machine.MoveL(0, 1)
				machine.WriteState("go-back-to-x")
			}
		})

	return instructions
}

func goBackToX() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "go-back-to-x" && machine.Read(0) == blank {
				machine.MoveL(0)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "go-back-to-x" && machine.Read(0) != blank {
				machine.WriteState("normalize")
			}
		},
	)

	return instructions
}

func normalize() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "normalize" && (machine.Read(0) != blank || machine.Read(1) != blank) {
				if machine.Read(0) == blank {
					machine.Write(zero, 0)
				}
				if machine.Read(1) == blank {
					machine.Write(zero, 1)
				}
				machine.MoveL(0, 1)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "normalize" && machine.Read(0) == blank && machine.Read(1) == blank {
				machine.MoveR(0, 1)
				machine.WriteState("select-math-func")
			}
		},
	)

	return instructions
}

func selectMathFunc() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "select-math-func" && machine.Read(0) == machine.Read(1) {
				machine.MoveR(0, 1)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "select-math-func" && machine.Read(0) > machine.Read(1) {
				machine.WriteState("go-to-start-1")
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "select-math-func" && machine.Read(0) < machine.Read(1) {
				//TODO: change to func-2
				machine.WriteState("return")
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "select-math-func" && machine.Read(0) == blank {
				//TODO: change to func-2
				machine.WriteState("return")
			}
		})

	return instructions
}

func func1() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions, goToStart1()...)
	instructions = append(instructions, add1()...)
	instructions = append(instructions, goToStartL2()...)
	instructions = append(instructions, multi1()...)

	return instructions
}

func goToStart1() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "go-to-start-1" && machine.Read(0) != blank {
				machine.MoveR(0, 1)
			}
		}, func(machine *machineCore.Machine) {
			if machine.ReadState() == "go-to-start-1" && machine.Read(0) == blank {
				machine.MoveL(0, 1)
				machine.WriteState("add-1-zero")
			}
		})

	return instructions
}

func add1() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions, func(machine *machineCore.Machine) {
		if machine.ReadState() == "add-1-zero" && machine.Read(0) != blank {
			if machine.Read(0) != machine.Read(1) {
				machine.Write(one, 3)
			} else {
				if machine.Read(0) == one {
					machine.WriteState("add-1-one")
				}
				machine.Write(zero, 3)
			}
			machine.MoveL(0, 1, 3)
		}
	},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "add-1-one" && machine.Read(0) != blank {
				if machine.Read(0) == machine.Read(1) {
					machine.Write(one, 3)
					if machine.Read(0) == zero {
						machine.WriteState("add-1-zero")
					}
				} else {
					machine.Write(zero, 3)
				}
				machine.MoveL(0, 1, 3)
			}
		},
		func(machine *machineCore.Machine) {
			if (machine.ReadState() == "add-1-zero" || machine.ReadState() == "add-1-one") && machine.Read(0) == blank {
				if machine.ReadState() == "add-1-one" {
					machine.Write(one, 3)
				}
				machine.WriteState("go-to-start-l-1")
			}
		})

	return instructions
}

func goToStartL2() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "go-to-start-l-1" && machine.Read(3) != blank {
				machine.MoveR(3)
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "go-to-start-l-1" && machine.Read(3) == blank {
				machine.WriteState("multi-1")
			}
		})

	return instructions
}

func multi1() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "multi-1" {
				machine.Write(zero, 3)
				machine.WriteState("return")
			}
		})

	return instructions
}

func func2() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions, copyY2()...)

	return instructions
}

func copyY2() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "copy-y-2" {
				if machine.Read(1) != blank {
					machine.Write(machine.Read(1), 2)
					machine.MoveL(1, 2)
				}
				if machine.Read(1) == blank {
					machine.WriteState("to-start-y-y")
				}
			}
		},
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "to-start-y-y" {
				if machine.Read(1) != blank {
					machine.MoveR(1, 2)
				}
				if machine.Read(1) == blank {
					machine.MoveL(1)
					machine.WriteState("check-top")
				}
			}
		})

	return instructions
}

func checkTop() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "check-top" {
				if machine.Read(1) == zero {
					machine.WriteState("multiply-mid")
				} else {
					machine.WriteState("add-mid-zero")
				}
				machine.MoveL(1)
			}
		})

	return instructions
}

func multiplyMid() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "multiply-mid" {
				machine.Write(zero, 2)
				machine.MoveR(2)
				machine.WriteState("check-top")
			}
		})

	return instructions
}

func addMid() []func(machine *machineCore.Machine) {
	var instructions []func(machine *machineCore.Machine)

	instructions = append(instructions,
		func(machine *machineCore.Machine) {
			if machine.ReadState() == "add-mid-zero" && machine{
				if machine.ReadState()
			}
		})

	return instructions
}
