package sorters

import (
	"math/rand"
	"testing"
)

func BenchmarkSuperSortRandom10Elements(b *testing.B) {
	sorter := SuperSorter{}
	rand.Seed(100)
	input := make([]int, 10)
	for k, _ := range input {
		input[k] = rand.Intn(1000000)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortRandom100Elements(b *testing.B) {
	sorter := SuperSorter{}
	rand.Seed(100)
	input := rand.Perm(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortRandom1_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	rand.Seed(100)
	input := rand.Perm(1000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortRandom10_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	rand.Seed(100)
	input := rand.Perm(10000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortRandom100_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	rand.Seed(100)
	input := rand.Perm(100000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortRandom1_000_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	rand.Seed(100)
	input := rand.Perm(1000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortRandom1_000_000_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	rand.Seed(100)
	input := rand.Perm(1000000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortIdeal10Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 0; i < 10; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortIdeal100Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 0; i < 100; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortIdeal1_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 0; i < 1000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortIdeal10_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 0; i < 10000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortIdeal100_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 0; i < 100000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortIdeal1_000_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 0; i < 1000000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortWorst10Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 10; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortWorst100Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 100; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortWorst1_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 1000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortWorst10_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 10000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortWorst100_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 100000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSuperSortWorst1_000_000Elements(b *testing.B) {
	sorter := SuperSorter{}
	var input []int
	for i := 1000000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}
