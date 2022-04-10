import numpy as np
import matplotlib.pyplot as plt


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


def f(x):
    return np.cos(x) / np.sin(x)


x = np.linspace(np.pi/8, np.pi/2, 100)
xd = [np.pi / 8, np.pi / 4, 3 * np.pi / 8, np.pi / 2]
yd = [np.sqrt(2) + 1, 1, np.sqrt(2) - 1, 0]
plt.plot(x, interpolatedFLag(x, xd, yd))
plt.plot(x, f(x), 'r')
plt.show()
