package main

import "fmt"

type dic struct {
	rome []string
	deci []int
}

func main() {

	number := 999

	fmt.Println(toRome(number))
	fmt.Println(toDeci(toRome(number)))
}

func dicProvider() dic {
	collection := new(dic)
	collection.deci = []int{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000}
	collection.rome = []string{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"}
	return *collection
}

func mapProvider() map[rune]int {
	m := make(map[rune]int)
	m['I'] = 1
	m['V'] = 5
	m['X'] = 10
	m['L'] = 50
	m['C'] = 100
	m['D'] = 500
	m['M'] = 1000

	return m
}

func toRome(number int) string {
	collection := dicProvider()
	rome := ""

	if number == 0 {
		return "N"
	}

	i := len(collection.rome) - 1

	for number > 0 {
		rest := number / collection.deci[i]
		number = number % collection.deci[i]

		for j := rest; j > 0; j-- {
			rome = rome + collection.rome[i]
		}

		i--
	}

	return rome
}

func toDeci(rome string) int {
	number := 0

	m := mapProvider()

	chars := []rune(rome)
	chars = append(chars, 'N')

	if len(chars) == 1 {
		return m[chars[0]]
	}

	for i := 0; i < len(chars)-1; i++ {
		current := m[chars[i]]
		next := m[chars[i+1]]

		if current >= next {
			number += current
		} else if next > current {
			number += next - current
			i++
		}
	}

	return number
}
