package linkedList

import "testing"

func BenchmarkOneWayList_Find(b *testing.B) {
	list := NewOneWayList[int]()
	for i := 0; i < 100000; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Find(500)
	}
}

func BenchmarkOneWayList_Append(b *testing.B) {
	list := NewOneWayList[int]()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Append(1)
	}
}

func BenchmarkOneWayList_Insert_Start(b *testing.B) {
	list := NewOneWayList[int]()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(0, 0)
	}
}

func BenchmarkOneWayList_Insert(b *testing.B) {
	list := NewOneWayList[int]()
	for i := 0; i < 100; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Insert(100, 1)
	}
}

func BenchmarkOneWayList_Delete_Start(b *testing.B) {
	list := NewOneWayList[int]()
	for i := 0; i < b.N; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(0)
	}
}

func BenchmarkOneWayList_Delete_End(b *testing.B) {
	list := NewOneWayList[int]()
	for i := 0; i < b.N; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(list.size - 1)
	}
}

func BenchmarkOneWayList_Delete(b *testing.B) {
	list := NewOneWayList[int]()
	for i := 0; i < 2*b.N; i++ {
		list.Append(i)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		list.Delete(list.size / 2)
	}
}
