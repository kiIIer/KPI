package cmd

import (
	"fmt"
	"sorting/sorters"

	"github.com/spf13/cobra"
)

var insertionCmd = &cobra.Command{
	Use:   "insertion",
	Short: "Does insertion sort on provided array",
	Long: `Uses insertion sorting algorithm on provided array.

Average and worst case O( n^2 ),
best case O( n ).
Takes element and inserts it to its place`,
	Run: func(cmd *cobra.Command, args []string) {
		result, err := BaseRun(Settings{sorter: new(sorters.InsertionSorter), args: args, cmd: cmd})
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Println(result)
	},
}

func init() {
	rootCmd.AddCommand(insertionCmd)
}
