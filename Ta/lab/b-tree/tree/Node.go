package tree

import (
	"fmt"
	"golang.org/x/exp/constraints"
)

type Node[K constraints.Ordered, V any] struct {
	t        int
	isLeaf   bool
	elements []*Element[K, V]
	nodes    []*Node[K, V]
}

func NewNode[K constraints.Ordered, V any](t int) *Node[K, V] {
	elements := make([]*Element[K, V], t-1)
	nodes := make([]*Node[K, V], t)
	return &Node[K, V]{
		t:        t,
		isLeaf:   true,
		elements: elements,
		nodes:    nodes,
	}
}

func (node *Node[K, V]) String() string {
	return fmt.Sprintf("Node:{ t: %v, isLeaf: %v, elements: %v, nodes: %v }", node.t, node.isLeaf, node.elements, node.nodes)
}
