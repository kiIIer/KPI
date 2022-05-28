package main

import (
	"fmt"
	"hash-table/hash"
	"strconv"
)

type TestKey struct {
	i int
}

func (k TestKey) Hashcode() int {
	return k.i
}

func (k TestKey) Equals(key any) bool {
	testKey, ok := key.(TestKey)
	if ok == false {
		return false
	}

	return k.i == testKey.i
}

func main() {
	hashtable := hash.NewTable[TestKey, string]()
	for i := 0; i < 100; i++ {
		currentKey := TestKey{i: i}
		currentValue := strconv.FormatInt(int64(i), 10)
		hashtable.Put(currentKey, currentValue)
		if i%10 == 0 {
			hashtable.Delete(TestKey{i: i / 10})
		}
	}
	for _, entry := range hashtable.Slice() {
		fmt.Println(entry.Value())
	}
}
