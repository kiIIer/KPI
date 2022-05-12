package tree

import (
	"golang.org/x/exp/rand"
	"testing"
)

func BenchmarkTree_Insert_Seq(b *testing.B) {
	tree := NewTree[int, int]()

	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Insert(i, i)
	}
}

func BenchmarkTree_Insert_Rand(b *testing.B) {
	rand.Seed(100)
	min := -4000000000
	max := 4000000000
	tree := NewTree[int, int]()
	values := make([]int, b.N)
	for i := 0; i < b.N; i++ {
		values[i] = rand.Intn(max-min) + min
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Insert(values[i], values[i])
	}
}

func BenchmarkTree_Get_Seq_Un(b *testing.B) {
	tree := NewTree[int, int]()
	for i := 0; i < 10000; i++ {
		tree.Insert(i, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Get(-1)
	}
}

func BenchmarkTree_Get_Rand_Un(b *testing.B) {
	rand.Seed(100)
	max := 40000000
	tree := NewTree[int, int]()
	for i := 0; i < 10000; i++ {
		val := rand.Intn(max)
		tree.Insert(val, val)
	}
	tree.Insert(123456, 1)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Get(-1)
	}
}

func BenchmarkTree_Get_Seq_Ba(b *testing.B) {
	tree := NewTree[int, int]()
	for i := 0; i < 10000; i++ {
		tree.Insert(i, i)
	}
	tree.Balance()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Get(1000000)
	}

}

func BenchmarkTree_Get_Rand_Ba(b *testing.B) {
	rand.Seed(100)
	max := 40000000
	tree := NewTree[int, int]()
	for i := 0; i < 10000; i++ {
		val := rand.Intn(max)
		tree.Insert(val, val)
	}
	tree.Balance()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Get(-1)
	}
}

func BenchmarkTree_Delete_Seq_Un(b *testing.B) {
	tree := NewTree[int, int]()
	for i := 0; i < 5*b.N; i++ {
		tree.Insert(i, i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Delete(5*b.N + 1)
	}
}

func BenchmarkTree_Delete_Rand_Un(b *testing.B) {
	rand.Seed(100)
	max := 40000000
	tree := NewTree[int, int]()
	for i := 0; i < 10000; i++ {
		val := rand.Intn(max)
		tree.Insert(val, val)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Delete(-1)
	}
}

func BenchmarkTree_Delete_Seq_Ba(b *testing.B) {
	tree := NewTree[int, int]()
	for i := 0; i < 10000; i++ {
		tree.Insert(i, i)
	}
	tree.Balance()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Delete(-1)
	}
}

func BenchmarkTree_Delete_Rand_Ba(b *testing.B) {
	tree := NewTree[int, int]()
	for i := 0; i < 10000; i++ {
		tree.Insert(i, i)
	}
	tree.Balance()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		tree.Delete(-1)
	}
}

func BenchmarkTree_Balance_Seq(b *testing.B) {
	var values = make([]int, b.N)
	for i := 0; i < b.N; i++ {
		values = append(values, i)
	}
	var forest = make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		tree := NewTree[int, int]()
		for i := 0; i < b.N; i++ {
			tree.Insert(values[i], values[i])
		}
		forest[i] = tree
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		forest[i].Balance()
	}
}

func BenchmarkTree_Balance_Rand(b *testing.B) {
	var values = make([]int, b.N)
	for i := 0; i < b.N; i++ {
		values = append(values, rand.Intn(40000000))
	}
	var forest = make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		tree := NewTree[int, int]()
		for i := 0; i < b.N; i++ {
			tree.Insert(values[i], values[i])
		}
		forest[i] = tree
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		forest[i].Balance()
	}
}

func BenchmarkGo_Map(b *testing.B) {
	rand.Seed(100)
	max := 40000000
	gomap := make(map[int]int, 0)
	for i := 0; i < 10000; i++ {
		gomap[rand.Intn(max)] = i
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		_ = gomap[-1]
	}
}
