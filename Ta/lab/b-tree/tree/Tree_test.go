package tree

import (
	"math/rand"
	"testing"
)

func BenchmarkTree_Insert_Seq(b *testing.B) {
	var values = make([]int, b.N)
	for i := 0; i < 10000; i++ {
		values = append(values, i)
	}
	var forest = make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		tree := NewTree[int, int](3)
		for i := 0; i < b.N; i++ {
			tree.Insert(values[i], values[i])
		}
		forest[i] = tree
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		forest[i].Insert(5000, 5000)
	}
}

func BenchmarkTree_Insert_Rand(b *testing.B) {
	var values = make([]int, b.N)
	for i := 0; i < b.N; i++ {
		values = append(values, rand.Intn(40000000))
	}
	var forest = make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		tree := NewTree[int, int](3)
		for i := 0; i < b.N; i++ {
			tree.Insert(values[i], values[i])
		}
		forest[i] = tree
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		forest[i].Insert(2000000, 2000000)
	}
}

func BenchmarkTree_Search_Seq_Un(b *testing.B) {
	tree := NewTree[int, int](3)
	for i := 0; i < 10000; i++ {
		tree.Insert(i, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Search(-1)
	}
}

func BenchmarkTree_Search_Rand_Un(b *testing.B) {
	rand.Seed(100)
	max := 40000000
	tree := NewTree[int, int](3)
	for i := 0; i < 10000; i++ {
		val := rand.Intn(max)
		tree.Insert(val, val)
	}
	tree.Insert(123456, 1)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Search(-1)
	}
}

func BenchmarkTree_Delete_Seq_Un(b *testing.B) {
	var values = make([]int, b.N)
	for i := 0; i < 10000; i++ {
		values = append(values, i)
	}
	var forest = make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		tree := NewTree[int, int](3)
		for i := 0; i < b.N; i++ {
			tree.Insert(values[i], values[i])
		}
		forest[i] = tree
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		forest[i].Delete(5000)
	}
}

func BenchmarkTree_Delete_Rand_Un(b *testing.B) {
	rand.Seed(100)
	max := 40000000
	tree := NewTree[int, int](3)
	for i := 0; i < 10000; i++ {
		val := rand.Intn(max)
		tree.Insert(val, val)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Delete(-1)
	}
}
