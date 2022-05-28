package sorters

import (
	"math/rand"
	"testing"
)

func BenchmarkSelectionSortRandom10Elements(b *testing.B) {
	sorter := SelectionSorter{}
	rand.Seed(100)
	input := rand.Perm(10)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortRandom100Elements(b *testing.B) {
	sorter := SelectionSorter{}
	rand.Seed(100)
	input := rand.Perm(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortRandom1_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	rand.Seed(100)
	input := rand.Perm(1000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortRandom10_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	rand.Seed(100)
	input := rand.Perm(10000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortRandom100_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	rand.Seed(100)
	input := rand.Perm(100000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortRandom1_000_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	rand.Seed(100)
	input := rand.Perm(1000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortIdeal10Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 0; i < 10; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortIdeal100Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 0; i < 100; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortIdeal1_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 0; i < 1000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortIdeal10_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 0; i < 10000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortIdeal100_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 0; i < 100000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortIdeal1_000_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 0; i < 1000000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortWorst10Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 10; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortWorst100Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 100; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortWorst1_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 1000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortWorst10_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 10000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortWorst100_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 100000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkSelectionSortWorst1_000_000Elements(b *testing.B) {
	sorter := SelectionSorter{}
	var input []int
	for i := 1000000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}
