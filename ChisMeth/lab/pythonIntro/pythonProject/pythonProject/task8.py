import math


def canGet(x1, y1, x2, y2):
    canGet = ((x1 == x2) | (y1 == y2)) | (math.fabs(x1-x2) == math.fabs(y1-y2))
    print("Statement Queen can get from first tile to second is {}" .format(canGet))


print("Task 8. Chess2")
canGet(1, 8, 8, 1)
