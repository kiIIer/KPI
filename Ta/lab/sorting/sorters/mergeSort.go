package sorters

type MergeSorter struct {
}

func (sorter MergeSorter) Sort(input []int) []int {
	array := make([]int, len(input))
	copy(array, input)

	if len(array) < 2 {
		return array
	}

	middleIndex := (len(array)) / 2

	return sorter.merge(sorter.Sort(array[:middleIndex]), sorter.Sort(array[middleIndex:]))
}

func (sorter MergeSorter) merge(left, right []int) []int {

	size, i, j := len(left)+len(right), 0, 0
	array := make([]int, size, size)

	for k := 0; k < size; k++ {
		if i > len(left)-1 && j <= len(right)-1 {
			array[k] = right[j]
			j++
		} else if j > len(right)-1 && i <= len(left)-1 {
			array[k] = left[i]
			i++
		} else if left[i] < right[j] {
			array[k] = left[i]
			i++
		} else {
			array[k] = right[j]
			j++
		}
	}
	return array
}
