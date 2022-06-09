package machineCore

type Machine struct {
	state        string
	tapes        []*tape
	instructions []func(machine *Machine)
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
	}
}

func (machine *Machine) WriteState(newState string) {
	machine.state = newState
}

func (machine *Machine) ReadState() string {
	return machine.state
}

func (machine *Machine) Read(tape int) rune {
	return machine.tapes[tape].read()
}

func (machine *Machine) Write(symbol rune, tapes ...int) {
	for _, tape := range tapes {
		machine.tapes[tape].write(symbol)
	}
}

func (machine *Machine) MoveR(tapes ...int) {
	for _, tape := range tapes {
		machine.tapes[tape].moveR()
	}
}

func (machine *Machine) MoveL(tapes ...int) {
	for _, tape := range tapes {
		machine.tapes[tape].moveL()
	}
}

func (machine *Machine) Run() {
	i := 0
	for machine.state != "return" {
		machine.instructions[i](machine)
		i++
		i %= len(machine.instructions)
		//println(machine.state)
		//fmt.Println(machine)
	}
}

func (machine *Machine) String() string {
	result := ""
	for _, tape := range machine.tapes {
		result += string(tape.runes) + "\n"
	}

	return result
}
