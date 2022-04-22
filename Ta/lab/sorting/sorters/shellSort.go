package sorters

type ShellSorter struct {
}

func (sorter *ShellSorter) Sort(input []int) []int {
	array := make([]int, len(input))
	copy(array, input)
	var (
		length = len(array)
		gaps   = []int{1}
		gap    int
	)

	for k := 1; gap < length; k++ {
		gap = sorter.gapFormer(2, k) + 1
		gaps = append([]int{gap}, gaps...)
	}

	for _, gap := range gaps {
		for i := gap; i < length; i += gap {
			for j := i; j > 0; j = -gap {
				if array[j-gap] > array[j] {
					array[j-gap], array[j] = array[j], array[j-gap]
				}
			}
		}
	}

	return array
}

func (sorter *ShellSorter) gapFormer(a, b int) int {
	e := 1
	for b > 0 {
		if b&1 != 0 {
			e *= a
		}
		b >>= 1
		a *= a
	}
	return e
}
