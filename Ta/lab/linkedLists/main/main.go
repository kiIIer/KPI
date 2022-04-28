package main

import (
	"fmt"
	"linkedLists/linkedList"
)

func main() {
	list := linkedList.NewList[int](linkedList.WithValues([]int{1, 2, 3, 4}))
	list.Append(23)
	list.Insert(0, 10)

	current := list.Head()
	for i := 0; i < list.Size(); i++ {
		fmt.Println(current.Value())
		current = current.Next()
	}

	print(list.Size())
	fmt.Println(list.ToSlice())
	list.Delete(0)
	fmt.Println(list.ToSlice())
	list.Delete(2)
	fmt.Println(list.ToSlice())
}
