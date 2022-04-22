package sorters

type SelectionSorter struct {
}

func (sorter SelectionSorter) Sort(input []int) []int {
	array := make([]int, len(input))
	copy(array, input)

	for i := 0; i < len(array); i++ {
		minIndex := i
		for j := i; j < len(array); j++ {
			if array[j] < array[minIndex] {
				minIndex = j
			}
		}
		array[i], array[minIndex] = array[minIndex], array[i]
	}

	return array
}
