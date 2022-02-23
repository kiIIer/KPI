package main

func reverseR(input []rune, start int) string {
	if start < len(input)-1 {
		return reverseR(input, start+1) + string(input[start])
	} else {
		return string(input[start])
	}

}

func reverseI(input []rune) string {
	var result string = ""
	for k, _ := range input {
		result += string(input[len(input)-k-1])
	}
	return result
}

func comp(n, m int) int {
	if m == 0 || n == m {
		return 1
	} else {
		return comp(n-1, m) + comp(n-1, m-1)
	}
}

func main() {
	var input []rune

	input = []rune{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}

	println(reverseR(input, 0))
	println(reverseI(input))
	println(comp(200, 2))
}
