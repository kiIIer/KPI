package sorters

type BubbleSorter struct {
}

func (sorter BubbleSorter) Sort(input []int) []int {
	array := make([]int, len(input))
	copy(array, input)
	for i := 0; i < len(input); i++ {
		for j := i; j < len(input); j++ {
			if array[i] > array[j] {
				array[i], array[j] = array[j], array[i]
			}
		}
	}
	return array
}
