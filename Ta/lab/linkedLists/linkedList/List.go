package linkedList

type List[V any] struct {
	head     *Element[V]
	tail     *Element[V]
	size     int
	isOneWay bool
}

type ListOption[V any] func(*List[V])

func NewList[V any](options ...ListOption[V]) *List[V] {
	list := &List[V]{isOneWay: false, size: 0}
	for _, option := range options {
		option(list)
	}

	return list
}

func WithOneWay[V any](isOneWay bool) ListOption[V] {
	return func(list *List[V]) {
		list.isOneWay = isOneWay
	}
}

func WithValues[V any](values []V) ListOption[V] {
	return func(list *List[V]) {
		for _, value := range values {
			list.Append(value)
		}
	}
}

func (list *List[V]) Append(value V) *List[V] {
	element := NewElement[V](WithValue[V](value))
	list.size++

	if list.head == nil {
		list.head = element
		list.tail = element
		return list
	}

	if !list.isOneWay {
		element.prev = list.tail
	}

	list.tail.next = element
	list.tail = element

	return list
}

func (list *List[V]) Insert(id int, value V) *List[V] {

	var current *Element[V]
	if id < list.size/2 {
		current = list.head
		for i := 0; i < id-1; i++ {
			current = current.next
		}
	} else {
		current = list.tail
		for i := list.size; i > id; i-- {
			current = current.prev
		}
	}

	newPev := current
	newNext := current.next

	newElement := NewElement(WithValue(value), WithPrev(newPev), WithNext(newNext))

	newPev.next = newElement
	newNext.prev = newElement

	return list
}

func (list *List[V]) Head() *Element[V] {
	return list.head
}

func (list *List[V]) Tail() *Element[V] {
	return list.tail
}

func (list *List[V]) Size() int {
	return list.size
}
