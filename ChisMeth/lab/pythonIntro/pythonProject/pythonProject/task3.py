import math


def rectangle(a, b):
    s = a * b
    p = (a + b)*2

    print("S = %d" % s)
    print("P = %d" % p)


def findSides(x1, y1, x2, y2):
    a = math.fabs(x1-x2)
    b = math.fabs(y1-y2)

    print("Sides are a = {}, b = {}" .format(a, b))
    rectangle(a, b)


print("Task 3. Incomplete rectangle.")
findSides(2, 2, 5, 5)
