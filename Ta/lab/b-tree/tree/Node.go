package tree

import (
	"fmt"
	"golang.org/x/exp/constraints"
)

type Node[K constraints.Ordered, V any] struct {
	t        int
	n        int
	isLeaf   bool
	elements []*Element[K, V]
	nodes    []*Node[K, V]
}

func NewNode[K constraints.Ordered, V any](t int, isLeaf bool) *Node[K, V] {
	elements := make([]*Element[K, V], 2*t-1)
	nodes := make([]*Node[K, V], 2*t)
	return &Node[K, V]{
		t:        t,
		n:        0,
		isLeaf:   isLeaf,
		elements: elements,
		nodes:    nodes,
	}
}

func (node *Node[K, V]) findGOEKey(key K) int {
	index := 0

	for ; index < node.n && node.elements[index].key < key; index++ {
	}

	return index
}

func (node *Node[K, V]) delete(key K) {
	index := node.findGOEKey(key)

	if index < node.n && node.elements[index].key == key {
		if node.isLeaf {
			node.deleteFromLeaf(index)
		} else {
			node.deleteFromNode(index)
		}
	} else {
		if node.isLeaf {
			return
		}
		if node.nodes[index].n < node.t {
			node.fill(index)
		}
		if index == node.n && index > node.n {
			node.nodes[index-1].delete(key)
		} else {
			node.nodes[index].delete(key)
		}
	}
}

func (node *Node[K, V]) deleteFromLeaf(index int) {
	for i := index + 1; i < node.n; i++ {
		node.elements[i-1] = node.elements[i]
	}
	node.n--
}

func (node *Node[K, V]) deleteFromNode(index int) {
	key := node.elements[index].key

	if node.nodes[index].n >= node.t {
		pred := node.pred(index)
		node.elements[index] = pred
		node.nodes[index].delete(pred.key)
	} else if node.nodes[index+1].n >= node.t {
		succ := node.succ(index)
		node.elements[index] = succ
		node.nodes[index+1].delete(succ.key)
	} else {
		node.merge(index)
		node.nodes[index].delete(key)
	}
}

func (node *Node[K, V]) pred(index int) *Element[K, V] {
	currentSubNode := node.nodes[index]
	for !currentSubNode.isLeaf {
		currentSubNode = currentSubNode.nodes[currentSubNode.n]
	}

	return currentSubNode.elements[currentSubNode.n-1]
}

func (node *Node[K, V]) succ(index int) *Element[K, V] {
	currentSubNode := node.nodes[index+1]

	for !currentSubNode.isLeaf {
		currentSubNode = currentSubNode.nodes[0]
	}

	return currentSubNode.elements[0]
}

func (node *Node[K, V]) stealFromLeft(index int) {
	subNode := node.nodes[index]
	subNodeLeft := node.nodes[index-1]

	for i := subNode.n - 1; i > -1; i-- {
		subNode.elements[i+1] = subNode.elements[i]
	}

	if !subNode.isLeaf {
		for i := subNode.n; i > -1; i-- {
			subNode.nodes[i+1] = subNode.nodes[i]

		}
	}

	subNode.elements[0] = node.elements[index-1]

	if !subNode.isLeaf {
		subNode.nodes[0] = subNodeLeft.nodes[subNodeLeft.n]
	}

	node.elements[index-1] = subNodeLeft.elements[subNodeLeft.n-1]

	subNode.n++
	subNodeLeft.n--
}

func (node *Node[K, V]) stealFromRight(index int) {
	subNode := node.nodes[index]
	subNodeRight := node.nodes[index+1]

	subNode.elements[subNode.n] = node.elements[index]

	if !subNode.isLeaf {
		subNode.nodes[subNode.n+1] = subNodeRight.nodes[0]
	}

	node.elements[index] = subNodeRight.elements[0]

	for i := 1; i < subNodeRight.n; i++ {
		subNodeRight.elements[i-1] = subNodeRight.elements[i]
	}

	if !subNodeRight.isLeaf {
		for i := 1; i <= subNodeRight.n; i++ {
			subNodeRight.nodes[i-1] = subNodeRight.nodes[i]
		}
	}

	subNode.n++
	subNodeRight.n--
}

func (node *Node[K, V]) merge(index int) {
	subNode := node.nodes[index]
	subNodeRight := node.nodes[index+1]

	subNode.elements[node.t-1] = node.elements[index]

	for i := 0; i < subNodeRight.n; i++ {
		subNode.elements[i+node.t] = subNodeRight.elements[i]
	}

	if !subNode.isLeaf {
		for i := 0; i < subNodeRight.n; i++ {
			subNode.nodes[i+node.t] = subNodeRight.nodes[i]
		}
	}

	for i := index + 1; i < node.n; i++ {
		node.elements[i-1] = node.elements[i]
	}

	for i := index + 2; i < node.n; i++ {
		node.nodes[i-1] = node.nodes[i]
	}

	subNode.n += subNodeRight.n + 1

	node.n--
}

func (node *Node[K, V]) fill(index int) {
	if index != 0 && node.nodes[index-1].n >= node.t {
		node.stealFromLeft(index)
	} else if index != node.n && node.nodes[index+1].n >= node.t {
		node.stealFromRight(index)
	} else {
		if index != node.n {
			node.merge(index)
		} else {
			node.merge(index - 1)
		}
	}
}

func (node *Node[K, V]) insertUtil(element *Element[K, V]) {
	i := node.n - 1

	for j := 0; j < node.n; j++ {
		if node.elements[j].key == element.key {
			node.elements[j] = element
			return
		}
	}

	if node.isLeaf {

		for ; i > -1 && node.elements[i].key > element.key; i-- {
			node.elements[i+1] = node.elements[i]
		}

		node.elements[i+1] = element

		node.n++

	} else {
		for ; i > -1 && node.elements[i].key > element.key; i-- {
		}

		if node.nodes[i+1].n == 2*node.t-1 {
			node.split(i+1, node.nodes[i+1])

			if node.elements[i+1].key < element.key {
				i++
			}
		}
		node.nodes[i+1].insertUtil(element)
	}
}

func (node *Node[K, V]) split(i int, child *Node[K, V]) {
	additionalChild := NewNode[K, V](node.t, child.isLeaf)

	additionalChild.n = node.t - 1

	for j := 0; j < node.t-1; j++ {
		additionalChild.elements[j] = child.elements[j+node.t]
	}

	if !node.isLeaf {
		for j := 0; j < node.t; j++ {
			additionalChild.nodes[j] = child.nodes[j+node.t]
		}
	}

	child.n = node.t - 1

	for j := node.n; j >= i+1; j-- {
		node.nodes[j+1] = node.nodes[j]
	}

	node.nodes[i+1] = additionalChild

	for j := node.n - 1; j >= i; j-- {
		node.elements[j+1] = node.elements[j]
	}

	node.elements[i] = child.elements[node.t-1]

	node.n++
}

func (node *Node[K, V]) search(key K) *Element[K, V] {
	i := 0
	for ; i < node.n && key > node.elements[i].key; i++ {
	}

	if i < node.n && node.elements[i] != nil && node.elements[i].key == key {
		return node.elements[i]
	}

	if node.isLeaf {
		return nil
	}

	return node.nodes[i].search(key)
}

func (node *Node[K, V]) slice() []*Element[K, V] {
	var elements []*Element[K, V]
	for i := 0; i < node.n; i++ {
		if !node.isLeaf {
			elements = append(elements, node.nodes[i].slice()...)
		}
		elements = append(elements, node.elements[i])

	}
	if !node.isLeaf {
		elements = append(elements, node.nodes[node.n].slice()...)
	}

	return elements
}

func (node *Node[K, V]) String() string {
	return fmt.Sprintf("Node:{ t: %v, n:%v, isLeaf: %v, elements: %v, nodes: %v }", node.t, node.n, node.isLeaf, node.elements, node.nodes)
}
