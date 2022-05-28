package main

import (
	"fmt"
	"linkedLists/additional"
	"linkedLists/linkedList"
)

func main() {
	list := linkedList.OneWayList[int]{}
	list.Append(1, 3, 5).Insert(2, 4).Insert(1, 2).Insert(0, 0).Insert(6, 6).Delete(0).Delete(5).Delete(3)
	fmt.Println(list.Slice())

	stack := additional.NewStack[int]()
	stack.Push(3)
	stack.Push(2)
	stack.Push(1)

	fmt.Println(stack.Pop())
	fmt.Println(stack.Pop())
	fmt.Println(stack.Pop())

	queue := additional.NewQueue[int]()
	queue.Add(1)
	queue.Add(2)
	queue.Add(3)

	fmt.Println(queue.Remove())
	fmt.Println(queue.Remove())
	fmt.Println(queue.Remove())
}
