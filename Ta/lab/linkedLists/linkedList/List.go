package linkedList

type List[V comparable] interface {
	FindByIndex(index int) *Element[V]
	Append(values ...V) List[V]
	Insert(index int, value V) List[V]
	Delete(index int) List[V]
	Find(value V) []*Element[V]
	Slice() []V
	Head() *Element[V]
	Tail() *Element[V]
	Size() int
}
