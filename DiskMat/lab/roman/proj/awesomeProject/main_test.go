package main

import (
	"fmt"
	"testing"
)

func TestConverters(t *testing.T) {
	for i := 0; i < 3000; i++ {
		got := toDeci(toRome(i))
		if i != got {
			t.Errorf(fmt.Sprintf("Wanted %d got %d", i, got), got)
		}
	}
}
