package main

func reverseR(input []rune, start int, end int) string {
	if start < end {
		return string(input[end]) + reverseR(input, start+1, end-1) + string(input[start])
	} else if end == start-1 {
		return ""
	} else {
		return string(input[end])
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

	println(reverseR(input, 0, len(input)-1))
	println(reverseI(input))
	println(comp(5, 4))
}
