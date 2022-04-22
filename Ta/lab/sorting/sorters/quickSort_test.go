package sorters

import (

	"fmt"

	"math/rand"
	"testing"
)

func BenchmarkQuickSortRandom10Elements(b *testing.B) {
	sorter := QuickSorter{}
	rand.Seed(100)
	input := rand.Perm(10)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortRandom100Elements(b *testing.B) {
	sorter := QuickSorter{}
	rand.Seed(100)
	input := rand.Perm(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortRandom1_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	rand.Seed(100)
	input := rand.Perm(1000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortRandom10_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	rand.Seed(100)
	input := rand.Perm(10000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortRandom100_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	rand.Seed(100)
	input := rand.Perm(100000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortRandom1_000_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	rand.Seed(100)
	input := rand.Perm(1000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortRandom1_000_000_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	rand.Seed(100)
	input := rand.Perm(1000000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortIdeal10Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int

	for i := 0; i < 10; i++ {

		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)

	}
}

func BenchmarkQuickSortIdeal100Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 0; i < 100; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortIdeal1_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 0; i < 1000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortIdeal10_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 0; i < 10000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortIdeal100_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 0; i < 100000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortIdeal1_000_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 0; i < 1000000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}

}

func BenchmarkQuickSortWorst10Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 10; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortWorst100Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 100; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortWorst1_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 1000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortWorst10_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 10000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortWorst100_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 100000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}

func BenchmarkQuickSortWorst1_000_000Elements(b *testing.B) {
	sorter := QuickSorter{}
	var input []int
	for i := 1000000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		sorter.Sort(input)
	}
}
