package greeder

import (
	"sort"
)

type Greeder struct {
}

func NewGreeder() *Greeder {
	return &Greeder{}
}

type Task struct {
	Deadline int
	Cost     int
}

func NewTask(deadline, cost int) *Task {
	return &Task{
		Deadline: deadline,
		Cost:     cost,
	}
}

func (greeder *Greeder) Solve(tasks []*Task) []*Task {
	sort.Slice(tasks, func(i, j int) bool {
		coefI := tasks[i].Cost / tasks[i].Deadline
		coefJ := tasks[j].Cost / tasks[j].Deadline
		if coefI == coefJ {
			return tasks[i].Deadline < tasks[j].Deadline
		}
		return coefI > coefJ
	})

	for _, task := range tasks {
		if task != nil {
			for i, task2 := range tasks {
				if task2 != nil {

					if task == task2 {
						continue
					}
					if task.Deadline == task2.Deadline {
						tasks[i] = nil
					}
				}
			}
		}
	}
	var solution []*Task

	for _, task := range tasks {
		if task != nil {
			solution = append(solution, task)
		}
	}

	sort.Slice(solution, func(i, j int) bool {
		return solution[i].Deadline < solution[j].Deadline
	})

	return solution
}
