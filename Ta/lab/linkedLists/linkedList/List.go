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
	newElement := NewElement[V](WithValue(value))

	if id == 0 {
		if !list.isOneWay {
			head := list.head
			head.prev = newElement
		}
		newElement.next = list.head
		list.head = newElement
		list.size++

	} else if id == list.size {
		list.Append(value)
	} else if list.isOneWay || id < list.size/2 {
		current := list.head

		for i := 0; i < id-1; i++ {
			current = current.next
		}

		nextLink := current.next
		newElement.next = nextLink
		current.next = newElement
		if !list.isOneWay {
			newElement.prev = current
			nextLink.prev = newElement
		}
		list.size++
	} else {
		current := list.tail
		for i := list.size - 1; i > id-1; i-- {
			current = current.prev
		}
		nextLink := current.next
		newElement.next = nextLink
		current.next = newElement
		newElement.prev = current
		nextLink.prev = newElement
		list.size++
	}

	return list
}

func (list *List[V]) Delete(index int) *Element[V] {
	var toDelete *Element[V]
	if index == 0 {
		list.head = list.head.next
		if !list.isOneWay {
			list.head.prev = nil
		}
	} else if list.isOneWay || index < list.size/2 {
		current := list.head
		for i := 0; i < index; i++ {
			current = current.next
		}

		toDelete = current.next
		afterDelete := toDelete.next

		current.next = afterDelete
		if !list.isOneWay {
			afterDelete.prev = current
		}
	} else {
		current := list.tail
		for i := list.size - 1; i > index; i-- {
			current = current.prev
		}

		toDelete = current.next
		afterDelete := toDelete.next

		current.next = afterDelete
		afterDelete.prev = current
	}

	list.size--
	return toDelete
}

func (list *List[V]) ToSlice() []V {
	slice := make([]V, list.size)

	current := list.head

	for i := 0; current != nil; i++ {
		slice[i] = current.value
		current = current.next
	}

	return slice
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
