package linkedList

type Element[V comparable] struct {
	prev  *Element[V]
	next  *Element[V]
	value V
}

type ElementOption[V comparable] func(element *Element[V])

// Element constructor

func NewElement[V comparable](options ...ElementOption[V]) *Element[V] {
	element := &Element[V]{}

	for _, option := range options {
		option(element)
	}

	return element
}

// Options

func WithPrev[V comparable](prev *Element[V]) ElementOption[V] {
	return func(element *Element[V]) {
		element.prev = prev
	}
}

func WithNext[V comparable](next *Element[V]) ElementOption[V] {
	return func(element *Element[V]) {
		element.next = next
	}
}

func WithValue[V comparable](value V) ElementOption[V] {
	return func(element *Element[V]) {
		element.value = value
	}
}

// Methods of Element

func (element Element[V]) Prev() *Element[V] {
	return element.prev
}

func (element Element[V]) Next() *Element[V] {
	return element.next
}

func (element Element[V]) Value() V {
	return element.value
}
