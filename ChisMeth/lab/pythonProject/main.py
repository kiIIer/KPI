import numpy as np
import numpy.linalg
import sympy
from sympy import *

x0 = 0.3
n = 5
x = Symbol('x')
p = exp(x)
q = x
f = x * x
h = 0.2
fl = lambdify([x], f)
y0 = 1 / (h * h) + p / h - q
y1 = -2 / (h * h) - p / h
y2 = 1 / (h * h)
y0l = lambdify([x], y0)
y1l = lambdify([x], y1)
y2l = lambdify([x], y2)
firstRow = [-5, 5, 0, 0, 0, 0]
lastRow = [0, 0, 0, 0, 0, -4]
f0 = 1
f1 = 0

full = [firstRow]
results = [f0]

for i in range(1, n):
    currentX = x0 + h * i
    row = []
    for j in range(0, i):
        row.append(0)
    row.append(y0l(currentX))
    results.append(fl(currentX))
    if i + 1 <= n:
        row.append(y1l(currentX))
        if i + 2 <= n:
            row.append(y2l(currentX))
    for j in range(i + 3, n + 1):
        row.append(0)
    full.append(row)
full.append(lastRow)
results.append(f1)

print(full)
print(results)

fulla = numpy.array(full)
resultsa = numpy.array(results)

funcV = numpy.linalg.solve(fulla, resultsa)
print(funcV)