package additional

import (
	"linkedLists/linkedList"
)

type Stack[V comparable] struct {
	list linkedList.List[V]
}

func NewStack[V comparable]() *Stack[V] {
	return &Stack[V]{list: linkedList.NewOneWayList[V]()}
}

func (stack *Stack[V]) Push(values ...V) {
	for _, value := range values {
		stack.list.Insert(0, value)
	}
}

func (stack *Stack[V]) Pop() V {
	value := stack.list.FindByIndex(0).Value()
	stack.list.Delete(0)
	return value
}
