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

	return &Tree[K, V]{
		t:    t,
		root: nil,
	}
}

func (tree *Tree[K, V]) Delete(key K) {
	if tree.root == nil {
		return
	}
	tree.root.delete(key)

	if tree.root.n == 0 {
		if tree.root.isLeaf {
			tree.root = nil
		} else {
			tree.root = tree.root.nodes[0]
		}

	}
}

func (tree *Tree[K, V]) Insert(key K, value V) {
	toInsert := NewElement(key, value)

	if tree.root == nil {
		tree.root = NewNode[K, V](tree.t, true)
		tree.root.elements[0] = toInsert
		tree.root.n = 1
	} else {
		if tree.root.n == 2*tree.t-1 {
			newRoot := NewNode[K, V](tree.t, false)

			newRoot.nodes[0] = tree.root

			newRoot.split(0, tree.root)

			i := 0
			if newRoot.elements[0].key < toInsert.key {
				i++
			}
			newRoot.insertUtil(toInsert)

			tree.root = newRoot
		} else {
			tree.root.insertUtil(toInsert)
		}
	}
}

func (tree *Tree[K, V]) Search(key K) *Element[K, V] {
	if tree.root == nil {
		return nil
	}
	return tree.root.search(key)
}

func (tree *Tree[K, V]) Slice() []*Element[K, V] {
	if tree.root == nil {
		return []*Element[K, V]{}
	}
	return tree.root.slice()
}

func (tree *Tree[K, V]) String() string {
	return fmt.Sprintf("Tree:{ t: %v, root: %v }", tree.t, tree.root)
}

func (tree *Tree[K, V]) T() int {
	return tree.t
}
