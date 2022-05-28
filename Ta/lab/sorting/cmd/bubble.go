package cmd

import (
	"fmt"
	"github.com/spf13/cobra"
	"sorting/sorters"
)

var bubbleCmd = &cobra.Command{
	Use:   "bubble",
	Short: "Sorts provided array with good old bubble sort",
	Long: `Applies basic bubble sorting algorithm on provided array.

Worst case performance O( n^2 ), 
best case performance O( n ),
on average O( n^2 ).
Compares and swaps 2 elements in double loop`,
	Run: func(cmd *cobra.Command, args []string) {
		result, err := BaseRun(Settings{sorter: new(sorters.BubbleSorter), args: args, cmd: cmd})
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Println(result)
	},
}

func init() {
	rootCmd.AddCommand(bubbleCmd)
}
