package tree

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestNode_String(t *testing.T) {
	// Arrange
	node := NewNode[int, int](3)
	element1 := NewElement(123, 321)
	element2 := NewElement(234, 432)
	node.elements[0] = element1
	node.elements[1] = element2
	expected := fmt.Sprintf("Node:{ t: 3, isLeaf: true, elements: [%v %v], nodes: [<nil> <nil> <nil>] }", element1, element2)

	// Act
	actual := node.String()

	// Assert
	assert.Equalf(t, expected, actual, "")
}

func TestNewNode(t *testing.T) {
	// Arrange
	elements := make([]*Element[int, string], 31)
	nodes := make([]*Node[int, string], 32)
	expected := &Node[int, string]{t: 32, isLeaf: true, nodes: nodes, elements: elements}

	// Act
	actual := NewNode[int, string](32)

	// Assert
	assert.Equalf(t, expected, actual, "")
}
