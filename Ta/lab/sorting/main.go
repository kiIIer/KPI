/*
Copyright © 2022 NAME HERE <EMAIL ADDRESS>

*/
package main

import (
	"fmt"
	"sorting/sorters"
)

func main() {
	something := []int{1}
	sorter := sorters.MergeSorter{}
	fmt.Println(sorter.Sort(something))
	//cmd.Execute()
}
