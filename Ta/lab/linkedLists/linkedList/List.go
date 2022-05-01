package linkedList

type List[V comparable] interface {
	FindByIndex(index int) *Element[V]
	Append(values ...V) *OneWayList[V]
	Insert(index int, value V) *OneWayList[V]
	Delete(index int) *OneWayList[V]
	Find(value V) []*Element[V]
	Slice() []V
	Head() *Element[V]
	Tail() *Element[V]
	Size() int
}
