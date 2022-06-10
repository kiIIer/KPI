package machineCore

const blank = ' '

type tape struct {
	position int
	runes    []rune
	stats    *tapeStatistics
}

type tapeStatistics struct {
	moveL int
	moveR int
	read  int
	write int
}

func newTape() *tape {
	return &tape{
		position: 0,
		runes:    []rune{' '},
		stats: &tapeStatistics{
			moveL: 0,
			moveR: 0,
			read:  0,
			write: 0,
		},
	}
}

func (tape *tape) read() rune {
	tape.stats.read++
	return tape.runes[tape.position]
}

func (tape *tape) write(symbol rune) {
	tape.stats.write++
	tape.runes[tape.position] = symbol
}

func (tape *tape) moveR() {
	tape.position++
	tape.stats.moveR++
	if tape.position == len(tape.runes) {
		tape.runes = append(tape.runes, ' ')
	}
}

func (tape *tape) moveL() {
	tape.position--
	tape.stats.moveL++
	if tape.position == -1 {
		tape.position++
		tape.runes = append([]rune{' '}, tape.runes...)
	}
}
