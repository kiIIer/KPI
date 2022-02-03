import math
import matplotlib.pyplot as ppl
import numpy
import statistics


def rectangle(a, b):
    s = a * b
    p = a + b

    print("S = %d" % s)
    print("P = %d" % p)


def geometric_average(a, b):
    res = math.sqrt(a*b)

    print("Geometric average = %d" % res)


def findSides(x1, y1, x2, y2):
    a = math.fabs(x1-x2)
    b = math.fabs(y1-y2)

    print("Sides are a = {}, b = {}" .format(a, b))
    rectangle(a, b)


def checkEven(x):
    if x % 2 == 0:
        print("Number {} is even" .format(x))
    else:
        print("Number {} is odd" .format(x))


def checkNumbers(a, b, c):
    first = (a < b) & (b < c)
    print("Statement a < b < c is {}" .format(first))
    second = (a > 0) | (b > 0) | (c > 0)
    print("Statement at least 1 number is positive is {}" .format(second))

    third = False
    if second:
        if a > 0 & (b <= 0 | c <= 0):
            third = True
        else:
            if b > 0 & ( a <= 0 | c <= 0):
                third = True
            else:
                if c > 0 & ( b <= 0 | c <= 0):
                    third = True
    print("Statement only 1 number is positive is {}" .format(third))


def getTransposed(matrix):
    transposed = buildMatrix(len(matrix[0]), len(matrix))
    i = 0
    j = 0
    while i < len(matrix):
        while j < len(matrix[i]):
            transposed[j][i] = matrix[i][j]
            j += 1
        i += 1
    return transposed


def findAverage(array):
    sum = 0
    for a in array:
        sum += a
    return sum/len(array)


def findLowestAverageRow(matrix):
    row = matrix[0]

    for a in matrix:
        if findAverage(row) > findAverage(a):
            row = a
    return row


def findHighestDeviation(matrix):
    row = matrix[0]

    for a in matrix:
        if statistics.pstdev(a) > statistics.pstdev(row):
            row = a
    return row


def increaseMatrix(matrix):
    new = matrix

    i = 0
    j = 0
    while i < len(matrix):
        while j < len(matrix[i]):
            new[i][j] = matrix[i][j]*100
            j+=1
        i+=1
    return new


def drawGraph():
    matrix = numpy.random.randn(50, 50)

    matrix2 = increaseMatrix(matrix)

    matrix3 = getTransposed(matrix2)

    ox = findLowestAverageRow(matrix3)
    oy = findHighestDeviation(matrix3)

    ppl.rcParams["figure.figsize"] = [7.50, 3.50]
    ppl.rcParams["figure.autolayout"] = True

    ppl.plot(ox,oy, color="red")
    ppl.show()


def checkWhite(a, b):
    pairCheck = (a + b) % 2 != 0
    print("Statement selected tile is white is {}" .format(pairCheck))


def canGet(x1, y1, x2, y2):
    canGet = ((x1 == x2) | (y1 == y2)) | (math.fabs(x1-x2) == math.fabs(y1-y2))
    print("Statement Queen can get from first tile to second is {}" .format(canGet))


def printSeries(a, b):
    size = b - a + 1

    for i in range(size):
        print(i+a)
    print("Number of ints is {}" .format(size))


def inverter(a):
    aAsArray = []

    while True:
        if a == 0 :
            break
        print(a % 10, end = "")
        a = int(int(a)/int(10))
    print()


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


def buildMatrix(rows, columns):
    matrix = []
    for i in range(rows):
        row = []
        for j in range(columns):
            row.append(0)
        matrix.append(row)
    return matrix


def drawHist(data):
    ppl.hist(data, bins=10)
    ppl.show()


def drawMatrix(matrix):
    transposed = getTransposed(matrix)

    for row in transposed:
        drawHist(row)


def checkPrime(number):
    isNotPrime = False

    for i in range(number):
        if (i < 2):
            continue
        if (number % i) == 0:
            isNotPrime = True
            break
    print("{} is not prime({})".format(number, isNotPrime))


print("Task 1. With rectangles.")
rectangle(5, 5)

print("Task 2. With average.")
geometric_average(8, 2)

print("Task 3. Incomplete rectangle.")
findSides(2, 2, 5, 5)

print("Task 4. Even/Odd")
checkEven(6)

print("Task 5. Some numbers")
checkNumbers(-4, 0, 0)

print("Task 6. Matrix")
drawGraph()

print("Task 7. Chess1")
checkWhite(4, 1)

print("Task 8. Chess2")
canGet(1, 8, 8, 1)

print("Task 9. Series")
printSeries(5, 7)

print("Task 10. Invert")
inverter(123)

print("Task 11. Change Array")
changeArr([1, 2, 3, 4, 30])

print("Task 12. Historgram")
drawMatrix([[1, 2, 3, 4, 5], [5, 4, 3, 2, 1], [1, 1, 1, 1, 1]])

print("Task 13. Prime")
checkPrime(13)
