package sorters

import (
	"math/rand"
	"testing"
)

func BenchmarkBubbleSortRandom10Elements(b *testing.B) {
	rand.Seed(100)
	input := rand.Perm(10)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortRandom100Elements(b *testing.B) {
	rand.Seed(100)
	input := rand.Perm(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortRandom1_000Elements(b *testing.B) {
	rand.Seed(100)
	input := rand.Perm(1000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortRandom10_000Elements(b *testing.B) {
	rand.Seed(100)
	input := rand.Perm(10000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortRandom100_000Elements(b *testing.B) {
	rand.Seed(100)
	input := rand.Perm(100000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortRandom1_000_000Elements(b *testing.B) {
	rand.Seed(100)
	input := rand.Perm(1000000)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortIdeal10Elements(b *testing.B) {
	var input []int
	for i := 0; i < 10; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortIdeal100Elements(b *testing.B) {
	var input []int
	for i := 0; i < 100; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortIdeal1_000Elements(b *testing.B) {
	var input []int
	for i := 0; i < 1000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortIdeal10_000Elements(b *testing.B) {
	var input []int
	for i := 0; i < 10000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortIdeal100_000Elements(b *testing.B) {
	var input []int
	for i := 0; i < 100000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortIdeal1_000_000Elements(b *testing.B) {
	var input []int
	for i := 0; i < 1000000; i++ {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortWorst10Elements(b *testing.B) {
	var input []int
	for i := 10; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortWorst100Elements(b *testing.B) {
	var input []int
	for i := 100; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortWorst1_000Elements(b *testing.B) {
	var input []int
	for i := 1000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortWorst10_000Elements(b *testing.B) {
	var input []int
	for i := 10000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortWorst100_000Elements(b *testing.B) {
	var input []int
	for i := 100000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}

func BenchmarkBubbleSortWorst1_000_000Elements(b *testing.B) {
	var input []int
	for i := 1000000; i > 0; i-- {
		input = append(input, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		BubbleSort(input)
	}
}
