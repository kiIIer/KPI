package additional

import "linkedLists/linkedList"

type Queue[V comparable] struct {
	list linkedList.List[V]
}

func NewQueue[V comparable]() *Queue[V] {
	return &Queue[V]{list: linkedList.NewTwoWayList[V]()}
}

func (queue *Queue[V]) Add(values ...V) {
	queue.list.Append(values...)
}

func (queue *Queue[V]) Remove() V {
	value := queue.list.FindByIndex(0).Value()
	queue.list.Delete(0)
	return value
}
