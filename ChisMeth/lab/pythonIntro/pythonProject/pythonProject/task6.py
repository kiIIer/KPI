import math
import statistics
import numpy
import matplotlib.pyplot as ppl


def buildMatrix(rows, columns):
    matrix = []
    for i in range(rows):
        row = []
        for j in range(columns):
            row.append(0)
        matrix.append(row)
    return matrix


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

    ppl.xlabel("Lowest average column")
    ppl.ylabel("Highest deviation column")

    ppl.plot(ox, oy, color="red")
    ppl.show()


print("Task 6. Matrix")
drawGraph()
