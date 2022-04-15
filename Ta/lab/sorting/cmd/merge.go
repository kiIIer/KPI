package cmd

import (
	"fmt"
	"sorting/sorters"

	"github.com/spf13/cobra"
)

var mergeCmd = &cobra.Command{
	Use:   "merge",
	Short: "Sorts provided array using merge sorting algorithm",
	Long: `Uses recursive merge sorting algorithm on provided array.

Average, worst case and best case scenarios have O( n * log(n) ) complexity.
Uses additional memory to sort.`,
	Run: func(cmd *cobra.Command, args []string) {
		result, err := BaseRun(Settings{sorter: new(sorters.MergeSorter), args: args, cmd: cmd})
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Println(result)
	},
}

func init() {
	rootCmd.AddCommand(mergeCmd)
}
