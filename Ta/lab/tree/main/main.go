package main

import "tree/tree"

func main() {
	myTree := tree.NewTree[int, string]()
	myTree.Insert(1, "one")
	myTree.Insert(4, "Two")
	myTree.Insert(5, "fifa")
	myTree.Insert(3, "Tri")
	myTree.Insert(0, "Zero")
	myTree.Insert(1, "AnotherOne")
	myTree.Insert(6, "six")
	myTree.Insert(7, "seven")
	myTree.Insert(8, "seven")
	myTree.Insert(9, "seven")
	myTree.Insert(10, "seven")
	myTree.Delete(6)
	println(myTree.Get(6))
	for _, e := range myTree.Slice() {
		println(e.Key())
	}
	myTree.Balance()

}
