def changeArr(array):
    sum = 0

    for a in array:
        sum += a
    average = sum / len(array)

    i = 0
    while i < len(array):
        if array[i] > average:
            array[i] -= 18
        i+=1

    for b in array:
        print(b, end=" ")
    print()


print("Task 11. Change Array")
changeArr([1, 2, 3, 4, 30])