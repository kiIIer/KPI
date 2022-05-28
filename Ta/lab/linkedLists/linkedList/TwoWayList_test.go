package linkedList

import "testing"

func BenchmarkTwoWayList_Find(b *testing.B) {
	list := NewTwoWayList[int]()
	for i := 0; i < 100000; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Find(500)
	}
}

func BenchmarkTwoWayList_Append(b *testing.B) {
	list := NewTwoWayList[int]()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Append(1)
	}
}

func BenchmarkTwoWayList_Insert_Start(b *testing.B) {
	list := NewTwoWayList[int]()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(0, 0)
	}
}

func BenchmarkTwoWayList_Insert(b *testing.B) {
	list := NewTwoWayList[int]()
	for i := 0; i < 100; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(100, 1)
	}
}

func BenchmarkTwoWayList_Delete_Start(b *testing.B) {
	list := NewTwoWayList[int]()
	for i := 0; i < b.N; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(0)
	}
}

func BenchmarkTwoWayList_Delete_End(b *testing.B) {
	list := NewTwoWayList[int]()
	for i := 0; i < b.N; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(list.size - 1)
	}
}

func BenchmarkTwoWayList_Delete(b *testing.B) {
	list := NewTwoWayList[int]()
	for i := 0; i < 2*b.N; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(list.size / 2)
	}
}
