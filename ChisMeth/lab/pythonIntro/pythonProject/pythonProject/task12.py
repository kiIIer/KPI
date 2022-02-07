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


def drawHist(data):
    ppl.hist(data, bins=10)


def drawMatrix(matrix):
    transposed = getTransposed(matrix)

    for row in transposed:
        drawHist(row)
    ppl.show()


print("Task 12. Historgram")
drawMatrix([[1, 3, 3, 4, 5], [10, 2, 3, 2, 1], [100, 1, 1, 1, 1]])
