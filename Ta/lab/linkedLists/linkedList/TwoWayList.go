package linkedList

type TwoWayList[V comparable] struct {
	head *Element[V]
	tail *Element[V]
	size int
}

func NewTwoWayList[V comparable]() *TwoWayList[V] {
	return &TwoWayList[V]{
		head: nil,
		tail: nil,
		size: 0,
	}
}

func (list *TwoWayList[V]) FindById(id int) *Element[V] {
	if id < 0 || id >= list.size {
		panic("What the hell? Index out of bounds! Go fix your iterations. You lil shit")
	}

	var current *Element[V]
	if id < list.size/2 {
		current = list.head

		for i := 0; i < id; i++ {
			current = current.next
		}

	} else {
		current = list.tail

		for i := list.size - 1; i > id; i-- {
			current = current.prev
		}
	}

	return current
}

func (list *TwoWayList[V]) Append(values ...V) *TwoWayList[V] {
	for _, value := range values {

		element := NewElement[V](WithValue[V](value))

		if list.head == nil {
			list.head = element
			list.tail = element
		} else {
			list.tail.next = element
			element.prev = list.tail
			list.tail = element
		}

		list.size++
	}
	return list
}

func (list *TwoWayList[V]) Insert(id int, value V) *TwoWayList[V] {
	if id < 0 || id > list.size {
		panic("What the hell? Index out of bounds! Go fix your iterations. You lil shit")
	}

	element := NewElement[V](WithValue(value))
	if id == list.size {
		return list.Append(value)
	} else if id == 0 {
		element.next = list.head
		list.head.prev = element
		list.head = element
	} else if id == list.size {
		return list.Append(value)
	} else {
		if id < list.size/2 {
			current := list.head
			for i := 0; i < id-1; i++ {
				current = current.next
			}
			element.next = current.next
			element.next.prev = element
			element.prev = current
			current.next = element
		} else {
			current := list.tail
			for i := list.size; i > id+1; i-- {
				current = current.prev
			}
			element.prev = current.prev
			element.prev.next = element
			element.next = current
			current.prev = element
		}
	}

	list.size++
	return list
}

func (list *TwoWayList[V]) Delete(id int) *TwoWayList[V] {
	if id < 0 || id >= list.size {
		panic("What the hell? Index out of bounds! Go fix your iterations. You lil shit")
	}

	if list.size == 1 {
		list.head = nil
		list.tail = nil
	} else if id == 0 {
		list.head = list.head.next
		list.head.prev = nil
	} else if id == list.size-1 {
		list.tail = list.tail.prev
		list.tail.next = nil
	} else {
		if id < list.size/2 {
			current := list.head
			for i := 0; i < id-1; i++ {
				current = current.next
			}
			current.next = current.next.next
			current.next.prev = current
		} else {
			current := list.tail
			for i := list.size - 1; i > id+1; i-- {
				current = current.prev
			}
			current.prev = current.prev.prev
			current.prev.next = current
		}
	}

	list.size--
	return list
}

func (list *TwoWayList[V]) Find(value V) []*Element[V] {
	var slice []*Element[V]

	starter, ender := list.head, list.tail
	for i, j := 0, list.size-1; i <= j; i, j = i+1, j-1 {
		if starter.value == value {
			slice = append(slice, starter)
		}
		if ender.value == value && ender != starter {
			slice = append(slice, ender)
		}

		starter, ender = starter.next, ender.prev
	}

	return slice
}

func (list *TwoWayList[V]) Slice() []V {
	slice := make([]V, list.size)

	starter, ender := list.head, list.tail
	j, k := 0, list.size-1

	for i := 0; j <= k; i++ {
		slice[i], slice[list.size-i-1] = starter.value, ender.value
		starter, ender = starter.next, ender.prev
		j++
		k--
	}

	return slice
}

func (list *TwoWayList[V]) Head() *Element[V] {
	return list.head
}

func (list *TwoWayList[V]) Tail() *Element[V] {
	return list.tail
}

func (list *TwoWayList[V]) Size() int {
	return list.size
}
