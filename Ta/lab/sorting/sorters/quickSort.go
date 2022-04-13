package sorters

func QuickSort(input []int) []int {
	array := make([]int, len(input))
	array = append(array, input...)
	return conquer(array, 0, len(array)-1)
}

func conquer(array []int, low, high int) []int {
	if low < high {
		var p int
		array, p = divide(array, low, high)
		array = conquer(array, low, p-1)
		array = conquer(array, p+1, high)
	}
	return array
}

func divide(array []int, low, high int) ([]int, int) {
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
