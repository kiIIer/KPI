/*
Copyright © 2022 NAME HERE <EMAIL ADDRESS>

*/
package cmd

import (
	"fmt"
	"sorting/sorters"

	"github.com/spf13/cobra"
)

// heapCmd represents the heap command
var heapCmd = &cobra.Command{
	Use:   "heap",
	Short: "A brief description of your command",
	Long: `A longer description that spans multiple lines and likely contains examples
and usage of using your command. For example:

Cobra is a CLI library for Go that empowers applications.
This application is a tool to generate the needed files
to quickly create a Cobra application.`,
	Run: func(cmd *cobra.Command, args []string) {
		result, err := BaseRun(Settings{sorter: new(sorters.HeapSorter), args: args, cmd: cmd})
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Println(result)
	},
}

func init() {
	rootCmd.AddCommand(heapCmd)

	// Here you will define your flags and configuration settings.

	// Cobra supports Persistent Flags which will work for this command
	// and all subcommands, e.g.:
	// heapCmd.PersistentFlags().String("foo", "", "A help for foo")

	// Cobra supports local flags which will only run when this command
	// is called directly, e.g.:
	// heapCmd.Flags().BoolP("toggle", "t", false, "Help message for toggle")
}
