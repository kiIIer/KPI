package sorters

type InsertionSorter struct {
}

func (sorter InsertionSorter) Sort(input []int) []int {
	array := make([]int, len(input))
	copy(array, input)

	for i := 1; i < len(array); i++ {
		for j := i; j > 0; {
			if array[j-1] > array[j] {
				array[j-1], array[j] = array[j], array[j-1]
			}
			j = j - 1
		}
	}

	return array
}
