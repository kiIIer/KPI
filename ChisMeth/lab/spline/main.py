import math
import matplotlib.pyplot as plt
import numpy as np


def calcH(dataX):
    Hes = [0]

    i = 1
    while i < len(dataX):
        Hes.append(dataX[i] - dataX[i - 1])
        i += 1
    return Hes


def calcD(dataX, dataY, Hes):
    Des = [0]

    i = 1
    while i < len(dataX) - 1:
        value = -(((dataY[i + 1] - dataY[i]) / Hes[i + 1]) - ((dataY[i] - dataY[i - 1]) / Hes[i]))
        Des.append(value)
        i += 1
    Des.append(0)
    return Des


def calcC(Hes):
    Ces = [0]

    i = 1
    while i < len(Hes) - 2:
        value = Hes[i + 1] / 6
        Ces.append(value)
        i += 1
    Ces.append(0)
    Ces.append(0)
    return Ces


def calcB(Hes):
    Bes = [0]

    i = 1
    while i < len(Hes) - 1:
        value = (Hes[i] + Hes[i + 1]) / 3
        Bes.append(value)
        i += 1
    Bes.append(0)
    return Bes


def calcA(Hes):
    Aes = [0, 0]

    i = 2
    while i < len(Hes) - 1:
        value = Hes[i] / 6
        Aes.append(value)
        i += 1
    Aes.append(0)
    return Aes


def calcBigA(Aes, Bes, Ces):
    BigAes = [0]

    i = 1
    while i < len(Aes) - 1:
        value = -Ces[i] / (Bes[i] + Aes[i] * Aes[i - 1])
        BigAes.append(value)
        i += 1
    BigAes.append(0)
    return BigAes


def calcBigB(BigAes, Aes, Bes, Des):
    BigBes = [0]

    i = 1
    while i < len(BigAes) - 1:
        value = (Des[i] - Aes[i] * BigBes[i - 1]) / (Bes[i] + Aes[i] * BigAes[i - 1])
        BigBes.append(value)
        i += 1
    BigBes.append(0)
    return BigBes


def calcQ(BigAes, BigBes):
    Qes = [0] * len(BigAes)

    i = len(BigAes) - 2
    while i > 0:
        value = Qes[i + 1] * BigAes[i] + BigBes[i]
        Qes[i] = value
        i -= 1
    return Qes


def f(x, dataX, dataY):
    Hes = calcH(dataX)
    Des = calcD(dataX, dataY, Hes)
    Ces = calcC(Hes)
    Bes = calcB(Hes)
    Aes = calcA(Hes)
    BigAes = calcBigA(Aes, Bes, Ces)
    BigBes = calcBigB(BigAes, Aes, Bes, Des)
    Qes = calcQ(BigAes, BigBes)

    results = []
    for current in x:
        index = 0

        i = 1
        while i < len(dataX) - 1:
            if current > dataX[i]:
                index += 1
                i += 1
            else:
                i += len(dataX)

        results.append((Qes[index] * (np.power((dataX[index + 1] - current), 3) / (6.0 * Hes[index + 1]))) +
                       (Qes[index + 1] * (np.power((current - dataX[index]), 3) / (6.0 * Hes[index + 1]))) +
                       ((dataY[index] / Hes[index + 1] - Qes[index] * (Hes[index + 1] / 6.0)) * (
                               dataX[index + 1] - current)) +
                       ((dataY[index + 1] / Hes[index + 1] - Qes[index + 1] * (Hes[index + 1] / 6.0)) * (
                               current - dataX[index])))
    return results


dataX = [0.2, 1.9, 3.2, 5.3, 7]
dataY = [0.2, 3.0038, 5.2439, 7.3583, 9.4077]
print(f([0], dataX, dataY))
x = np.linspace(0, 7, 200)
plt.plot(x, f(x, dataX, dataY))
plt.plot(dataX, dataY)
plt.show()
