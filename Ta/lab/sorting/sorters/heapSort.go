package sorters

type HeapSorter struct {
}

func (sorter *HeapSorter) Sort(input []int) []int {
	size := len(input)
	heap := newHeap(input)
	heap.buildMinHeap(size)
	for i := size - 1; i > 0; i-- {
		heap.swap(0, i)
		heap.downHeapify(0, i)
	}

	return heap.arr
}

func (heap *heap) downHeapify(current int, size int) {
	if heap.isLeaf(current, size) {
		return
	}
	smallest := current
	leftChildIndex := heap.leftChildIndex(current)
	rightRightIndex := heap.rightChildIndex(current)
	if leftChildIndex < size && heap.arr[leftChildIndex] < heap.arr[smallest] {
		smallest = leftChildIndex
	}
	if rightRightIndex < size && heap.arr[rightRightIndex] < heap.arr[smallest] {
		smallest = rightRightIndex
	}
	if smallest != current {
		heap.swap(current, smallest)
		heap.downHeapify(smallest, size)
	}
}

func (heap *heap) sort(size int) {
	heap.buildMinHeap(size)
	for i := size - 1; i > 0; i-- {
		heap.swap(0, i)
		heap.downHeapify(0, i)
	}
}

type heap struct {
	arr []int
}

func newHeap(input []int) *heap {
	array := make([]int, len(input))
	copy(array, input)
	heap := &heap{
		arr: array,
	}
	return heap
}

func (heap *heap) buildMinHeap(size int) {
	for index := (size / 2) - 1; index >= 0; index-- {
		heap.downHeapify(index, size)
	}
}

func (heap *heap) leftChildIndex(index int) int {
	return 2*index + 1
}

func (heap *heap) rightChildIndex(index int) int {
	return 2*index + 2
}

func (heap *heap) swap(first, second int) {
	heap.arr[first], heap.arr[second] = heap.arr[second], heap.arr[first]
}

func (heap *heap) isLeaf(index int, size int) bool {
	return index >= (size/2) && index <= size
}
