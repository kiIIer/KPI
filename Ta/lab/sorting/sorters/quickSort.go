package sorters

type QuickSorter struct {
}

func (sorter QuickSorter) Sort(input []int) []int {
	array := make([]int, len(input))
	copy(array, input)
	return sorter.conquer(array, 0, len(array)-1)
}

func (sorter QuickSorter) conquer(array []int, low, high int) []int {
	if low < high {
		var conqueror int
		array, conqueror = sorter.divide(array, low, high)
		array = sorter.conquer(array, low, conqueror-1)
		array = sorter.conquer(array, conqueror+1, high)
	}
	return array
}

func (sorter QuickSorter) divide(array []int, low, high int) ([]int, int) {
	conqueror := array[high]
	i := low
	for j := low; j < high; j++ {
		if array[j] < conqueror {
			array[i], array[j] = array[j], array[i]
			i++
		}
	}
	array[i], array[high] = array[high], array[i]
	return array, i
}
