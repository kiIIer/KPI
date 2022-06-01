package factorial

type Factorial struct {
	memory []uint64
}

func NewFactorial() *Factorial {
	return &Factorial{memory: []uint64{1, 1}}
}

func (fac *Factorial) CalcNth(n int) uint64 {
	if n >= len(fac.memory) {
		for i := len(fac.memory); i <= n; i++ {
			fac.memory = append(fac.memory, fac.memory[i-1]*uint64(i))
		}
	}

	return fac.memory[n]
}
