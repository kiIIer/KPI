package linkedList

type Element[V any] struct {
	prev  *Element[V]
	next  *Element[V]
	value V
}

type ElementOption[V any] func(element *Element[V])

// Element constructor

func NewElement[V any](options ...ElementOption[V]) *Element[V] {
	element := &Element[V]{}

	for _, option := range options {
		option(element)
	}

	return element
}

// Options

func WithPrev[V any](prev *Element[V]) ElementOption[V] {
	return func(element *Element[V]) {
		element.prev = prev
	}
}

func WithNext[V any](next *Element[V]) ElementOption[V] {
	return func(element *Element[V]) {
		element.next = next
	}
}

func WithValue[V any](value V) ElementOption[V] {
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
