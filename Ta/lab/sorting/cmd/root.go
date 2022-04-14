package cmd

import (
	"os"

	"github.com/spf13/cobra"
)

var rootCmd = &cobra.Command{
	Use:   "sorting",
	Short: "Provides sorting algorithms to be used on provided array",
	Long:  `Group command for different sorting algorithms, we strongly advice using super sort!`,
}

func Execute() {
	err := rootCmd.Execute()
	if err != nil {
		os.Exit(1)
	}
}

func init() {
}
