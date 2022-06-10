package machineCore

import "strconv"

type Machine struct {
	state        string
	tapes        []*tape
	instructions []func(machine *Machine)
	stats        *machineStatistics
}

type machineStatistics struct {
	moveL      int
	moveR      int
	read       int
	write      int
	readState  int
	writeState int
}

func NewMachine(tapesCount int, initialState string, instructions ...func(machine *Machine)) *Machine {
	tapes := make([]*tape, tapesCount)
	for i := 0; i < tapesCount; i++ {
		tapes[i] = newTape()
	}
	for i := 0; i < len(initialState); i++ {
		tapes[0].write(rune(initialState[i]))
		tapes[0].moveR()
	}
	for i := 0; i < len(initialState); i++ {
		tapes[0].moveL()
	}
	return &Machine{
		state:        "init",
		tapes:        tapes,
		instructions: instructions,
		stats: &machineStatistics{
			moveL:      0,
			moveR:      0,
			read:       0,
			write:      0,
			readState:  0,
			writeState: 0,
		},
	}
}

func (machine *Machine) WriteState(newState string) {
	machine.stats.writeState++
	machine.state = newState
}

func (machine *Machine) ReadState() string {
	machine.stats.readState++
	return machine.state
}

func (machine *Machine) Read(tape int) rune {
	machine.stats.read++
	return machine.tapes[tape].read()
}

func (machine *Machine) Write(symbol rune, tapes ...int) {
	for _, tape := range tapes {
		machine.stats.write++
		machine.tapes[tape].write(symbol)
	}
}

func (machine *Machine) MoveR(tapes ...int) {
	for _, tape := range tapes {
		machine.stats.moveR++
		machine.tapes[tape].moveR()
	}
}

func (machine *Machine) MoveL(tapes ...int) {
	for _, tape := range tapes {
		machine.stats.moveL++
		machine.tapes[tape].moveL()
	}
}

func (machine *Machine) Run() {
	i := 0
	for machine.state != "return" {
		machine.instructions[i](machine)
		i++
		i %= len(machine.instructions)
	}
}

func (machine *Machine) String() string {
	result := machine.state + "\n"
	for i, tape := range machine.tapes {
		result += strconv.Itoa(i) + "(" + strconv.Itoa(tape.position) + "): " + string(tape.runes) + "\n"
	}

	return result
}

func (machine *Machine) Stats() string {
	result := ""
	result += "Number of instructions: " + strconv.Itoa(len(machine.instructions)) + "\n"
	result += "ReadState: " + strconv.Itoa(machine.stats.readState) + "\n"
	result += "WriteState: " + strconv.Itoa(machine.stats.writeState) + "\n"
	result += "MoveL: " + strconv.Itoa(machine.stats.moveL) + "\n"
	result += "MoveR: " + strconv.Itoa(machine.stats.moveR) + "\n"
	result += "Read: " + strconv.Itoa(machine.stats.read) + "\n"
	result += "Write: " + strconv.Itoa(machine.stats.write) + "\n"

	for i, tape := range machine.tapes {
		result += strconv.Itoa(i) + ": \n"
		result += "    MoveL: " + strconv.Itoa(tape.stats.moveL) + "\n"
		result += "    MoveR: " + strconv.Itoa(tape.stats.moveR) + "\n"
		result += "    Read: " + strconv.Itoa(tape.stats.read) + "\n"
		result += "    Write: " + strconv.Itoa(tape.stats.write) + "\n"
	}

	return result
}
