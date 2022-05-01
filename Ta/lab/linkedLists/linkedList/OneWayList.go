package linkedList

type OneWayList[V comparable] struct {
	head *Element[V]
	tail *Element[V]
	size int
}

func NewOneWayList[V comparable]() *OneWayList[V] {
	return &OneWayList[V]{
		head: nil,
		tail: nil,
		size: 0,
	}
}

func (list *OneWayList[V]) FindByIndex(index int) *Element[V] {
	if index < 0 || index >= list.size {
		panic("What the hell? Index out of bounds! Go fix your iterations. You lil shit")
	}

	current := list.head

	for i := 0; i < index; i++ {
		current = current.next
	}

	return current

}

func (list *OneWayList[V]) Append(values ...V) *OneWayList[V] {
	for _, value := range values {

		element := NewElement[V](WithValue[V](value))

		if list.head == nil {
			list.head = element
			list.tail = element
		} else {
			list.tail.next = element
			list.tail = element
		}
		list.size++
	}
	return list
}

func (list *OneWayList[V]) Insert(index int, value V) *OneWayList[V] {
	if index < 0 || index > list.size {
		panic("What the hell? Index out of bounds! Go fix your iterations. You lil shit")
	}

	element := NewElement[V](WithValue(value))

	if index == 0 {
		element.next = list.head
		list.head = element
	} else if index == list.size {
		return list.Append(value)
	} else {

		current := list.head
		for i := 0; i < index-1; i++ {
			current = current.next
		}
		element.next = current.next
		current.next = element
	}
	list.size++
	return list
}

func (list *OneWayList[V]) Delete(index int) *OneWayList[V] {
	if index < 0 || index >= list.size {
		panic("What the hell? Index out of bounds! Go fix your iterations. You lil shit")
	}

	if index == 0 {
		list.head = list.head.next
	} else {
		current := list.head
		for i := 0; i < index-1; i++ {
			current = current.next
		}
		current.next = current.next.next

	}

	list.size--
	return list
}

func (list *OneWayList[V]) Find(value V) []*Element[V] {
	var slice []*Element[V]

	for current := list.head; current != nil; current = current.next {
		if current.value == value {
			slice = append(slice, current)
		}
	}

	return slice
}

func (list *OneWayList[V]) Slice() []V {
	slice := make([]V, list.size)

	current := list.head
	for i := 0; current != nil; current = current.next {
		slice[i] = current.value
		i++
	}

	return slice
}

func (list *OneWayList[V]) Head() *Element[V] {
	return list.head
}

func (list *OneWayList[V]) Tail() *Element[V] {
	return list.tail
}

func (list *OneWayList[V]) Size() int {
	return list.size
}
