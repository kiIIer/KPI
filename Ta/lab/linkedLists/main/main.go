package main

import (
	"fmt"
	"linkedLists/linkedList"
)

func main() {
	list := linkedList.OneWayList[int]{}
	list.Append(1, 3, 5).Insert(2, 4).Insert(1, 2).Insert(0, 0).Insert(6, 6).Delete(0).Delete(5).Delete(3)
	fmt.Println(list.Slice())
}
