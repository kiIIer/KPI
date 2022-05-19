package tree

import (
	"fmt"
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestElement_String(t *testing.T) {
	// Arrange
	key := "ImmaKey"
	value := "ImmaValue"
	expected := fmt.Sprintf("Element:{ key: %v, value: %v }", key, value)
	element := Element[string, string]{key: key, value: value}

	// Act
	actual := element.String()

	// Assert
	assert.Equalf(t, expected, actual, "")
}

func TestNewElement(t *testing.T) {
	// Arrange
	key := 123
	value := 321

	expected := &Element[int, int]{
		key:   key,
		value: value,
	}

	// Act
	actual := NewElement[int, int](key, value)

	// Assert
	assert.Equalf(t, expected, actual, "")
}

func TestElement_Key(t *testing.T) {
	// Arrange
	expected := 1234
	element := NewElement(expected, 1)

	// Act
	actual := element.Key()

	// Assert
	assert.Equalf(t, expected, actual, "")
}

func TestElement_Value(t *testing.T) {
	// Arrange
	expected := 4321
	element := NewElement(1, expected)

	// Act
	actual := element.Value()

	// Assert
	if expected != actual {
		t.Errorf("Want %v got %v", expected, actual)
	}
}
