package tree

import (
	"golang.org/x/exp/constraints"
)

type Tree[K constraints.Ordered, V any] struct {
	root *Element[K, V]
}

func NewTree[K constraints.Ordered, V any]() *Tree[K, V] {
	return &Tree[K, V]{}
}

func (tree *Tree[K, V]) Insert(key K, value V) {
	toInsert := NewElement(key, value)
	if tree.root == nil {
		tree.root = toInsert
	}

	tree.insertUtil(toInsert, tree.root)

}
func (tree *Tree[K, V]) insertUtil(toInsert *Element[K, V], current *Element[K, V]) {
	if toInsert.key < current.key {
		if current.left == nil {
			current.left = toInsert
		} else {
			tree.insertUtil(toInsert, current.left)
		}
	} else if toInsert.key > current.key {
		if current.right == nil {
			current.right = toInsert
		} else {
			tree.insertUtil(toInsert, current.right)
		}
	} else {
		current.value = toInsert.value
	}
}

func (tree *Tree[K, V]) Slice() []*Element[K, V] {
	if tree.root == nil {
		return make([]*Element[K, V], 0)
	}

	return tree.sliceUtil(tree.root)
}

func (tree *Tree[K, V]) sliceUtil(current *Element[K, V]) []*Element[K, V] {
	var elements []*Element[K, V]
	if current.left != nil {
		elements = append(elements, tree.sliceUtil(current.left)...)
	}
	elements = append(elements, current)
	if current.right != nil {
		elements = append(elements, tree.sliceUtil(current.right)...)
	}
	return elements
}

func (tree *Tree[K, V]) Get(key K) *Element[K, V] {
	if tree.root == nil {
		return nil
	}

	return tree.getUtil(key, tree.root)
}

func (tree *Tree[K, V]) getUtil(key K, current *Element[K, V]) *Element[K, V] {
	if key < current.key {
		if current.left == nil {
			return nil
		}
		return tree.getUtil(key, current.left)
	}
	if key > current.key {
		if current.right == nil {
			return nil
		}
		return tree.getUtil(key, current.right)
	}
	return current
}

func (tree *Tree[K, V]) Delete(key K) {
	if tree.root == nil {
		return
	}

	tree.deleteUtil(key, tree.root)
}

func (tree *Tree[K, V]) deleteUtil(key K, current *Element[K, V]) {
	if key < current.key {
		if current.left == nil {
			return
		}
		if current.left.key == key {
			homeLess := current.left.right
			current.left = current.left.left
			if homeLess != nil {
				tree.insertUtil(homeLess, current)
			}
			return
		}
		tree.deleteUtil(key, current.left)
		return
	}
	if key > current.key {
		if current.right == nil {
			return
		}
		if current.right.key == key {
			homeLess := current.right.left
			current.right = current.right.right
			if homeLess != nil {
				tree.insertUtil(homeLess, current)
			}
			return
		}
		tree.deleteUtil(key, current.right)
		return
	}

}

func (tree *Tree[K, V]) Balance() {
	elements := tree.Slice()
	tree.root = tree.balanceUtil(elements, 0, len(elements)-1)
}

func (tree *Tree[K, V]) balanceUtil(elements []*Element[K, V], start, end int) *Element[K, V] {
	if start > end {
		return nil
	}

	middle := (start + end) / 2
	current := elements[middle]

	current.left = tree.balanceUtil(elements, start, middle-1)
	current.right = tree.balanceUtil(elements, middle+1, end)

	return current
}

func (tree *Tree[K, V]) Root() *Element[K, V] {
	return tree.root
}
