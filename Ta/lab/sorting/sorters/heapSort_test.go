package sorters

import (
	"math/rand"
	"testing"
)

func BenchmarkHeapSortRandom10Elements(b *testing.B) {
	sorter := HeapSorter{}
	rand.Seed(100)
	input := rand.Perm(10)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortRandom100Elements(b *testing.B) {
	sorter := HeapSorter{}
	rand.Seed(100)
	input := rand.Perm(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortRandom1_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	rand.Seed(100)
	input := rand.Perm(1000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortRandom10_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	rand.Seed(100)
	input := rand.Perm(10000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortRandom100_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	rand.Seed(100)
	input := rand.Perm(100000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortRandom1_000_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	rand.Seed(100)
	input := rand.Perm(1000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortIdeal10Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 0; i < 10; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortIdeal100Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 0; i < 100; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortIdeal1_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 0; i < 1000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortIdeal10_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 0; i < 10000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortIdeal100_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 0; i < 100000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortIdeal1_000_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 0; i < 1000000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortWorst10Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 10; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortWorst100Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 100; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortWorst1_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 1000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortWorst10_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 10000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortWorst100_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 100000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkHeapSortWorst1_000_000Elements(b *testing.B) {
	sorter := HeapSorter{}
	var input []int
	for i := 1000000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}
