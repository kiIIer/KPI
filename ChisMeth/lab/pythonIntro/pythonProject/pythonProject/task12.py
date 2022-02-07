import matplotlib.pyplot as ppl
import numpy


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


def drawMatrix(matrix):
    transposed = numpy.transpose(matrix)

    for row in transposed:
        drawHist(row)
    ppl.show()


print("Task 12. Historgram")
drawMatrix([[1, 3, 3, 4, 5], [10, 2, 3, 2, 1], [10, 1, 1, 1, 1]])
