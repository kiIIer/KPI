package main

import (
	tree2 "b-tree/tree"
	"fmt"
)

func main() {
	tree := tree2.NewTree[int, string](3)
	tree.Insert(1, "One")
	tree.Insert(2, "Two")
	tree.Insert(3, "Three")
	tree.Insert(4, "Four")
	tree.Insert(6, "new")
	tree.Insert(7, "Seven")
	tree.Insert(-1, "-One")
	tree.Insert(-2, "-Two")
	tree.Insert(33, "TriTri")
	tree.Insert(6, "Six")
	tree.Insert(5, "FIFE")
	fmt.Println(tree.Search(6))
	fmt.Println(tree.Slice())
	fmt.Println()
	tree.Delete(4)
	fmt.Println(tree.Slice())
}
