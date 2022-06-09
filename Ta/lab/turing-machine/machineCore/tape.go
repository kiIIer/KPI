package machineCore

type tape struct {
	position int
	runes    []rune
}

func newTape() *tape {
	return &tape{
		position: 0,
		runes:    []rune{' '},
	}
}

func (tape *tape) read() rune {
	return tape.runes[tape.position]
}

func (tape *tape) write(symbol rune) {
	tape.runes[tape.position] = symbol
}

func (tape *tape) moveR() {
	tape.position++
	if tape.position == len(tape.runes) {
		tape.runes = append(tape.runes, ' ')
	}
}

func (tape *tape) moveL() {
	tape.position--
	if tape.position == -1 {
		tape.position++
		tape.runes = append([]rune{' '}, tape.runes...)
	}
}
