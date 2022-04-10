import numpy as np
import matplotlib.pyplot as plt

np.seterr(divide='ignore', invalid='ignore')


def phiOfX(x, data):
    result = 1
    i = 0
    while i < len(data):
        result = result * (x - data[i])
        i += 1
    return result


def phiTickOfX(i, data):
    result = 1
    j = 0
    while j < len(data):
        if i != j:
            result = result * (data[i] - data[j])
        j += 1
    return result


def interpolatedFLag(x, datax, datay):
    result = 0
    i = 0
    while i < len(datax):
        result = result + (datay[i] * phiOfX(x, datax)) / (phiTickOfX(i, datax) * (x - datax[i]))
        i += 1
    return result


def NewtonHelper(datax, datay, i, j):
    if j - i == 1:
        return (datay[j] - datay[i]) / (datax[j] - datax[i])
    return (NewtonHelper(datax, datay, i + 1, j) - NewtonHelper(datax, datay, i, j - 1)) / (datax[j] - datax[i])


def interpolatedFNew(x, datax, datay, n):
    result = datay[0]
    i = 1
    while i < n:
        coef = 1
        j = 0
        while j < i:
            coef = coef * (x - datax[j])
            j += 1
        result = result + NewtonHelper(datax, datay, 0, i) * coef
        i += 1
    return result


def f(x):
    return np.cos(x) / np.sin(x)
    # return np.power(x, 3)


# xd = [0, 1, 2, 3, 4, 5, 6]
# yd = [0, 1, 8, 27, 64, 125, 216]
# x = np.linspace(0, 25, 100)
x = np.linspace(np.pi / 8, np.pi / 2, 100)

# first set
# xd = [np.pi / 8, np.pi / 4, 3 * np.pi / 8, np.pi / 2]
# yd = [np.cos(np.pi / 8) / np.sin(np.pi / 8), np.cos(np.pi / 4) / np.sin(np.pi / 4),
#       np.cos(3 * np.pi / 8) / np.sin(3 * np.pi / 8), np.cos(np.pi / 2) / np.sin(np.pi / 2)]

# # second set
xd = [np.pi / 8, 5 * np.pi / 16, 3 * np.pi / 8, np.pi / 2]
yd = [np.sqrt(2) + 1, 0.668179, np.sqrt(2) - 1, 0]
#
plt.plot(x, interpolatedFLag(x, xd, yd))
plt.plot(x, interpolatedFNew(x, xd, yd, len(xd)))
plt.plot(x, f(x), 'r')
plt.show()

print(f(np.pi/3)-interpolatedFLag(np.pi/3, xd, yd))