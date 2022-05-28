package cmd

import (
	"github.com/spf13/cobra"
	"sorting/sorters"
	"strconv"
)

type Settings struct {
	args   []string
	sorter sorters.Sorter
	cmd    *cobra.Command
}

func BaseRun(settings Settings) ([]int, error) {
	input := make([]int, len(settings.args))
	for k, v := range settings.args {
		var err error
		input[k], err = strconv.Atoi(v)
		if err != nil {
			return nil, err
		}
	}

	return settings.sorter.Sort(input), nil
}
