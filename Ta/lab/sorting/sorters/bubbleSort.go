package sorters

func BubbleSort(input []int) []int {
	array := make([]int, len(input))
	array = append(array, input...)
	for i := 0; i < len(input); i++ {
		for j := i; j < len(input); j++ {
			if array[i] > array[j] {
				array[i], array[j] = array[j], array[i]
			}
		}
	}
	return array
}
