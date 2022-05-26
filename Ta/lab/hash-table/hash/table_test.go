package hash

import (
	"math"
	"testing"
)

type TestKey struct {
	i int
}

func (k TestKey) Hashcode() int {
	return int(math.Abs(float64(k.i)))
}

func (k TestKey) Equals(key any) bool {
	testKey, ok := key.(TestKey)
	if ok == false {
		return false
	}

	return k.i == testKey.i
}

func BenchmarkTable_Put_1000(b *testing.B) {
	n := 1000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
}

func BenchmarkTable_Put_10000(b *testing.B) {
	n := 10000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
}

func BenchmarkTable_Put_100000(b *testing.B) {
	n := 100000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
}

func BenchmarkTable_Put_200000(b *testing.B) {
	n := 200000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
}

func BenchmarkTable_Get_1000(b *testing.B) {
	n := 1000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Get(TestKey{j})
		}
	}
}

func BenchmarkTable_Get_10000(b *testing.B) {
	n := 10000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Get(TestKey{j})
		}
	}
}

func BenchmarkTable_Get_100000(b *testing.B) {
	n := 100000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Get(TestKey{j})
		}
	}
}

func BenchmarkTable_Get_200000(b *testing.B) {
	n := 200000
	capacity := float64(n) * 1.4
	tables := make([]*Table[TestKey, int], b.N)

	for i := 0; i < b.N; i++ {
		tables[i] = NewTable[TestKey, int](withCapacity[TestKey, int](int(capacity)))
	}

	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Put(TestKey{i: j}, j)
		}
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		for j := 0; j < n; j++ {
			tables[i].Get(TestKey{j})
		}
	}
}
