package tree

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"reflect"
	"testing"
)

func TestTree_String(t *testing.T) {
	// Arrange
	te := 2
	element := NewElement[int, string](123, "oneTwoThree")
	node := NewNode[int, string](te)
	node.elements[0] = element
	expected := fmt.Sprintf("Tree:{ t: %v, root: %v }", te, node)
	tree := NewTree[int, string](te)
	tree.root = node

	// Act
	actual := tree.String()

	// Assert
	assert.Equalf(t, expected, actual, "")
}

func TestNewTree(t *testing.T) {
	// Arrange
	te := 2
	node := NewNode[int, int](te)
	element := NewElement(123, 321)
	node.elements[0] = element
	expected := &Tree[int, int]{t: te, root: node}

	// Act
	actual := NewTree[int, int](te)

	// Assert
	if reflect.DeepEqual(expected, actual) {
		t.Errorf(fmt.Sprintf("Wanted %v got %v", expected, actual))
	}
}

func TestTree_Slice(t *testing.T) {
	// Arrange
	te := 3
	root := NewNode[int, int](te)
	rootElement1 := NewElement(111, 111)
	rootElement2 := NewElement(112, 112)
	root.elements[0] = rootElement1
	root.elements[1] = rootElement2

	node1 := NewNode[int, int](te)
	node1Element1 := NewElement(11, 11)
	node1.elements[0] = node1Element1

	node2 := NewNode[int, int](te)
	node2Element1 := NewElement()
}
