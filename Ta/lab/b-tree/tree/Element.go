package tree

import (
	"fmt"
	"golang.org/x/exp/constraints"
)

type Element[K constraints.Ordered, V any] struct {
	key   K
	value V
}

func NewElement[K constraints.Ordered, V any](key K, value V) *Element[K, V] {
	return &Element[K, V]{
		key:   key,
		value: value,
	}
}

func (element *Element[K, V]) Key() K {
	return element.key
}

func (element *Element[K, V]) Value() V {
	return element.value
}

func (element *Element[K, V]) String() string {
	return fmt.Sprintf("Element:{ key: %v, value: %v }", element.key, element.value)
}
