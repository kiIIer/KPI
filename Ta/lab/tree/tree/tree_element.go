package tree

import "golang.org/x/exp/constraints"

type Element[K constraints.Ordered, V any] struct {
	left  *Element[K, V]
	right *Element[K, V]
	key   K
	value V
}

func NewElement[K constraints.Ordered, V any](key K, value V) *Element[K, V] {
	return &Element[K, V]{key: key, value: value}
}

func (element *Element[K, V]) Key() K {
	return element.key
}

func (element *Element[K, V]) Value() V {
	return element.value
}
