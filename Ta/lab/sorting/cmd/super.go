/*
Copyright © 2022 NAME HERE <EMAIL ADDRESS>

*/
package cmd

import (
	"fmt"

	"sorting/sorters"


	"github.com/spf13/cobra"
)

// superCmd represents the super command
var superCmd = &cobra.Command{
	Use:   "super",
	Short: "Summons the godlike algorithm on provided array",
	Long: `The time has come
To awaken him
I call upon the ancient lord of underworld to bring forth this beast and-
Awaken
Awaken
Awaken
Awaken
Take the land, that must be taken
Awaken
Awaken
Awaken
Awaken 
Devour worlds smite forsaken
Rise up from your thousandth year of sleep
Break forth from your grave eternally
I command you to
Rise
Rise
Rise
Rise
Rise
Rise
Rise
Rise
I'm the conjurer of demonds
I'm the father of your death
I bring fourth the ancient evil
I control his every breath
I instigate your misfortune
With the birth of killing trolls
I awaken Armageddon
Feeding on a thousand souls
Awaken
Awaken
Awaken
Awaken

THE ANCIENT ONE HAS HONORED US WITH HIS PRESENCE!!!
THE CONCURRENT BEAST, THE QUICKSORT!!!!!!!!!
ALL BOW BEFORE HIM AND ACCEPT THE SPEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEED`,
	Run: func(cmd *cobra.Command, args []string) {
		result, err := BaseRun(Settings{sorter: new(sorters.SuperSorter), args: args, cmd: cmd})
		if err != nil {
			fmt.Println(err)
			return
		}
		fmt.Println(result)
	},
}

func init() {
	rootCmd.AddCommand(superCmd)

	// Here you will define your flags and configuration settings.

	// Cobra supports Persistent Flags which will work for this command
	// and all subcommands, e.g.:
	// superCmd.PersistentFlags().String("foo", "", "A help for foo")

	// Cobra supports local flags which will only run when this command
	// is called directly, e.g.:
	// superCmd.Flags().BoolP("toggle", "t", false, "Help message for toggle")
}
