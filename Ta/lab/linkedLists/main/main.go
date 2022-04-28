package main

import (
	"fmt"
	"linkedLists/linkedList"
)

func main() {
	list := linkedList.NewList[int](linkedList.WithValues([]int{1, 2, 3, 4}))
	list.Append(23)
	list.Insert(1, 10)

	current := list.Head()
	for i := 0; i < list.Size(); i++ {
		fmt.Println(current.Value())
		current = current.Next()
	}
}
