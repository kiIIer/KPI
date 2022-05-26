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

func BenchmarkTree_Insert_1000(b *testing.B) {
	n := 1000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	rand.Seed(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
}

func BenchmarkTree_Insert_10000(b *testing.B) {
	n := 10000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	rand.Seed(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
}

func BenchmarkTree_Insert_100000(b *testing.B) {
	n := 100000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	rand.Seed(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
}

func BenchmarkTree_Insert_200000(b *testing.B) {
	n := 200000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	rand.Seed(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
}

func BenchmarkTree_Get_1000(b *testing.B) {
	n := 1000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Search(j)
		}
	}
}

func BenchmarkTree_Get_10000(b *testing.B) {
	n := 10000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Search(j)
		}
	}
}

func BenchmarkTree_Get_100000(b *testing.B) {
	n := 100000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Search(j)
		}
	}
}

func BenchmarkTree_Get_200000(b *testing.B) {
	n := 200000
	forest := make([]*Tree[int, int], b.N)
	for i := 0; i < b.N; i++ {
		forest[i] = NewTree[int, int](3)
	}
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Insert(rand.Intn(n), j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			forest[i].Search(j)
		}
	}
}
