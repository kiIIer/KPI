package cmd

import (
	"fmt"
	"sorting/sorters"

	"github.com/spf13/cobra"
)

var selectionCmd = &cobra.Command{
	Use:   "selection",
	Short: "Yoinks with selection sort the provided array",
	Long: `Yanks with selection sort on provided array.

Has O( n^2 ) in all cases!!! 
Plz don't use it)
Selects the lowest item and moves it to it's proper place`,
	Run: func(cmd *cobra.Command, args []string) {
		result, err := BaseRun(Settings{sorter: new(sorters.SelectionSorter), args: args, cmd: cmd})
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Println(result)
	},
}

func init() {
	rootCmd.AddCommand(selectionCmd)
}
