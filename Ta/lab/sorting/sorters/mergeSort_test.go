package sorters

import (
	"math/rand"
	"testing"
)

func BenchmarkMergeSortRandom10Elements(b *testing.B) {
	sorter := MergeSorter{}
	rand.Seed(100)
	input := rand.Perm(10)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortRandom100Elements(b *testing.B) {
	sorter := MergeSorter{}
	rand.Seed(100)
	input := rand.Perm(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortRandom1_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	rand.Seed(100)
	input := rand.Perm(1000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortRandom10_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	rand.Seed(100)
	input := rand.Perm(10000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortRandom100_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	rand.Seed(100)
	input := rand.Perm(100000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortRandom1_000_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	rand.Seed(100)
	input := rand.Perm(1000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortIdeal10Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 0; i < 10; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortIdeal100Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 0; i < 100; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortIdeal1_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 0; i < 1000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortIdeal10_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 0; i < 10000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortIdeal100_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 0; i < 100000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortIdeal1_000_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 0; i < 1000000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortWorst10Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 10; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortWorst100Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 100; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortWorst1_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 1000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortWorst10_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 10000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortWorst100_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 100000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkMergeSortWorst1_000_000Elements(b *testing.B) {
	sorter := MergeSorter{}
	var input []int
	for i := 1000000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}
