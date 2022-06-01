package fibonacci

type Fibonacci struct {
	memory []uint64
}

func NewFibonacci() *Fibonacci {
	return &Fibonacci{
		memory: []uint64{1, 1},
	}
}

func (f *Fibonacci) CalcNth(n int) uint64 {
	if n >= len(f.memory) {
		for i := len(f.memory) - 1; i <= n; i++ {
			f.memory = append(f.memory, f.memory[i-1]+f.memory[i-2])
		}
	}

	return f.memory[n]
}
