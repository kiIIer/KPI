package cmd

import (
	"fmt"
	"sorting/sorters"

	"github.com/spf13/cobra"
)

var quickCmd = &cobra.Command{
	Use:   "quick",
	Short: "Runs quick sort on provided array",
	Long: `Executes quick sorting algorithm on provided array.

Worst case performance O( n^2 ), 
best case performance O( n * log(n) ),
on average O ( n * log(n) ). 
Divide and conquer at it's finest'`,
	Run: func(cmd *cobra.Command, args []string) {
		result, err := BaseRun(Settings{sorter: new(sorters.QuickSorter), args: args, cmd: cmd})
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Println(result)
	},
}

func init() {
	rootCmd.AddCommand(quickCmd)
}
