/*
Copyright © 2022 NAME HERE <EMAIL ADDRESS>

*/
package cmd

import (
	"fmt"
	"github.com/spf13/cobra"
)

// bubbleCmd represents the bubble command
var bubbleCmd = &cobra.Command{
	Use:   "bubble",
	Short: "Eto je buble gum",
	Long:  `This command uses bubble sorting algorithm on provided array`,
	Run: func(cmd *cobra.Command, args []string) {

	},
}

func init() {
	rootCmd.AddCommand(bubbleCmd)

	// Here you will define your flags and configuration settings.

	// Cobra supports Persistent Flags which will work for this command
	// and all subcommands, e.g.:
	// bubbleCmd.PersistentFlags().String("foo", "", "A help for foo")

	// Cobra supports local flags which will only run when this command
	// is called directly, e.g.:
	// bubbleCmd.Flags().BoolP("toggle", "t", false, "Help message for toggle")
}

func applySort(input []int) {
	fmt.Println("sorting...")
}
