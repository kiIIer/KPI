package tree

import (
	"fmt"
	"golang.org/x/exp/constraints"
)

type Tree[K constraints.Ordered, V any] struct {
	t    int
	root *Node[K, V]
}

func NewTree[K constraints.Ordered, V any](t int) *Tree[K, V] {
	node := NewNode[K, V](t)

	return &Tree[K, V]{
		t:    t,
		root: node,
	}
}

func (tree *Tree[K, V]) Slice() []*Element[K, V] {
	var slice []*Element[K, V]
	if len(tree.root.elements) == 0 {
		return slice
	}

	slice = append(slice, tree.sliceUtil(tree.root)...)

	return slice
}

func (tree *Tree[K, V]) sliceUtil(node *Node[K, V]) []*Element[K, V] {
	var slice []*Element[K, V]
	for i := 0; i < tree.t-1; i++ {
		currentNode := node.nodes[i]
		if currentNode != nil {
			slice = append(slice, tree.sliceUtil(currentNode)...)
		}

		currentElement := node.elements[i]
		if currentElement != nil {
			slice = append(slice, currentElement)
		}
	}

	return slice
}

func (tree *Tree[K, V]) String() string {
	return fmt.Sprintf("Tree:{ t: %v, root: %v }", tree.t, tree.root)
}

func (tree *Tree[K, V]) T() int {
	return tree.t
}
