import math
import matplotlib.pyplot as plt
import numpy as np


def f(x):
    return np.tan(x) - 5 * np.power(x, 2) + 1


def df(x):
    return (1 / np.cos(x)) - 10 * x


# x^2-x-1=0
def f2(x):
    return 1 / (x - 1)


def halfDivRoot(start, interval, stop, which):
    n = start
    nn = start + interval
    while True:
        if f(n) * f(nn) < 0:
            if which == 1:
                break
            else:
                which -= 1
        n += interval
        nn += interval

    fn = f(n)
    fnn = f(nn)
    while True:
        if fn * fnn < 0:
            xaver = (n + nn) / 2
            faver = f(xaver)
            if faver < stop:
                return xaver
            if fn * faver > 0:
                n = xaver
                fn = faver
            else:
                nn = xaver
                fnn = faver


def hordeRoot(start, interval, stop, which):
    n = start
    nn = start + interval
    while True:
        if f(n) * f(nn) < 0:
            if which == 1:
                break
            else:
                which -= 1
        n += interval
        nn += interval

    fn = f(n)
    fnn = f(nn)

    while True:
        if fn * fnn < 0:
            xhor = n - fn * ((nn - n) / (fnn - fn))
            fhor = f(xhor)
            if fhor < stop:
                return xhor
            if fn * fhor > 0:
                n = xhor
                fn = fhor
            else:
                nn = xhor
                fnn = fhor


def newtRoot(start, stop):
    n = start
    while True:
        fn = f(n)
        if abs(fn) < stop:
            return n
        dfn = df(n)
        if dfn == 0:
            return None
        n = n - fn / dfn


def simpIter(x):
    while abs(x - f2(x)) > 1e-10:
        x = f2(x)
    return x


x = np.arange(-1, 1, 0.1)
y = f(x)

plt.xlabel("x")
plt.ylabel("f(x)")

plt.axhline(0, color='black')
plt.axvline(0, color='black')

plt.plot(x, y, "r")
plt.show()

print(halfDivRoot(-1, 0.1, 0.000001, 1))
print(hordeRoot(-1, 0.1, 0.000001, 1))
print(newtRoot(-1, 0.000001))
print(simpIter(-1))
