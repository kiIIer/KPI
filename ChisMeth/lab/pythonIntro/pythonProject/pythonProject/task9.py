def printSeries(a, b):
    size = b - a + 1

    for i in range(size):
        print(i+a)
    print("Number of ints is {}" .format(size))


print("Task 9. Series")
printSeries(5, 7)
