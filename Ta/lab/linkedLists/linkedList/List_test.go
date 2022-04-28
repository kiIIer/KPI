package linkedList

import (
	"math/rand"
	"testing"
)

func BenchmarkList_Append_OneSided(b *testing.B) {
	list := NewList[int](WithOneWay[int](true))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Append(5)
	}
}

func BenchmarkList_Append_TwoSided(b *testing.B) {
	list := NewList[int](WithOneWay[int](false))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Append(5)
	}
}

func BenchmarkList_Insert_OneSided_Start(b *testing.B) {
	list := NewList[int](WithOneWay[int](true))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(0, 5)
	}
}

func BenchmarkList_Insert_TwoSided_Start(b *testing.B) {
	list := NewList[int](WithOneWay[int](false))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(0, 5)
	}
}

func BenchmarkList_Insert_OneSided_RandomIndex(b *testing.B) {
	list := NewList[int](WithOneWay[int](true), WithValues([]int{1}))
	rand.Seed(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(rand.Intn(list.size), 5)
	}
}

func BenchmarkList_Insert_TwoSided_RandomIndex(b *testing.B) {
	list := NewList[int](WithOneWay[int](true), WithValues([]int{1}))
	rand.Seed(100)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(rand.Intn(list.size), 5)
	}
}

func BenchmarkList_Delete_OneSided_Random(b *testing.B) {
	rand.Seed(100)
	list := NewList[int](WithOneWay[int](true), WithValues(rand.Perm(5*b.N)))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(rand.Intn(list.size - 1))
	}
}

func BenchmarkList_Delete_TwoSided_Random(b *testing.B) {
	rand.Seed(100)
	list := NewList[int](WithOneWay[int](false), WithValues(rand.Perm(5*b.N)))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(rand.Intn(list.size - 1))
	}
}

func BenchmarkList_Delete_OneSided_Starting(b *testing.B) {
	rand.Seed(100)
	list := NewList[int](WithOneWay[int](true), WithValues(rand.Perm(5*b.N)))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(0)
	}
}

func BenchmarkList_Delete_TwoSided_Starting(b *testing.B) {
	rand.Seed(100)
	list := NewList[int](WithOneWay[int](false), WithValues(rand.Perm(5*b.N)))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(0)
	}
}

func BenchmarkList_Delete_TwoSided_Ending(b *testing.B) {
	rand.Seed(100)
	list := NewList[int](WithOneWay[int](false), WithValues(rand.Perm(5*b.N)))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(list.size - 1)
	}
}

func BenchmarkList_Delete_OneSided_Ending(b *testing.B) {
	rand.Seed(100)
	list := NewList[int](WithOneWay[int](true), WithValues(rand.Perm(5*b.N)))
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(list.size - 1)
	}
}
