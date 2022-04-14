package sorters

import (
	"runtime"
	"sync"
)

type SuperSorter struct {
}

type settings struct {
	low   int
	high  int
	array []int
}

//func (sorter SuperSorter) Sort(input []int) []int {
//	array := make([]int, len(input))
//	copy(array, input)
//
//	sorter.start(array)
//	return array
//}
//
//func (sorter SuperSorter) start(array []int) {
//	var wg sync.WaitGroup
//	wg.Add(1)
//	sorter.conquer(array, 0, len(array)-1, &wg)
//	wg.Wait()
//}
//
//func (sorter SuperSorter) conquer(array []int, low, high int, wg *sync.WaitGroup) {
//	defer wg.Done()
//	if low < high {
//		var conqueror int
//		conqueror = sorter.divide(array, low, high)
//		wg.Add(1)
//		go sorter.conquer(array, low, conqueror-1, wg)
//		wg.Add(1)
//		go sorter.conquer(array, conqueror+1, high, wg)
//	}
//}
//
//func (sorter SuperSorter) divide(array []int, low, high int) int {
//	conqueror := array[high]
//	i := low
//	for j := low; j < high; j++ {
//		if array[j] < conqueror {
//			array[i], array[j] = array[j], array[i]
//			i++
//		}
//	}
//	array[i], array[high] = array[high], array[i]
//	return i
//}

func (sorter SuperSorter) Sort(input []int) []int {
	array := make([]int, len(input))
	copy(array, input)

	sorter.start(array)

	return array
}

func (sorter SuperSorter) start(array []int) {
	jobs := make(chan settings, len(array))
	var wg sync.WaitGroup

	for i := 0; i < runtime.NumCPU(); i++ {
		go sorter.jobWorker(jobs, &wg)
	}

	wg.Add(1)
	jobs <- settings{
		low:   0,
		high:  len(array) - 1,
		array: array,
	}
	wg.Wait()
	close(jobs)
}

func (sorter SuperSorter) jobWorker(jobs chan settings, wg *sync.WaitGroup) {
	for job := range jobs {
		sorter.conquer(job.array, job.low, job.high, jobs, wg)
		wg.Done()
	}
}

func (sorter SuperSorter) conquer(array []int, low, high int, jobs chan settings, wg *sync.WaitGroup) {
	if low < high {
		var conqueror int
		conqueror = sorter.divide(array, low, high)
		if high-low > 6500 {
			wg.Add(1)
			jobs <- settings{
				low:   low,
				high:  conqueror - 1,
				array: array,
			}
			wg.Add(1)
			jobs <- settings{
				low:   conqueror + 1,
				high:  high,
				array: array,
			}
		} else {
			sorter.conquer(array, low, conqueror-1, jobs, wg)
			sorter.conquer(array, conqueror+1, high, nil, nil)
		}

	}
}

func (sorter SuperSorter) divide(array []int, low, high int) int {
	conqueror := array[high]
	i := low
	for j := low; j < high; j++ {
		if array[j] < conqueror {
			array[i], array[j] = array[j], array[i]
			i++
		}
	}
	array[i], array[high] = array[high], array[i]
	return i
}
