def yFunc(z):
    return z


def zFunc(x, y, z):
    return (3 * x ** 2 + y - z * x) / x ** 2


def RealEulerMeth(xStart, xEnd, y0, z0, h):
    Zs = [z0]
    Ys = [y0]

    i = 1
    xCurrent = xStart
    while xCurrent < xEnd:
        Ys.append((Ys[i - 1] + h * yFunc(Zs[i - 1])))
        Zs.append((Zs[i - 1] + h * zFunc(xCurrent, Ys[i - 1], Zs[i - 1])))
        i += 1
        xCurrent += h
    return Ys[len(Ys) - 1]


def UnrealEulerMeth(xStart, xEnd, y0, z0, h):
    Zs = [z0]
    Ys = [y0]

    i = 1
    xCurrent = xStart + h
    while xCurrent < xEnd + h:
        z = 1
        y = 1

        for j in range(100):
            y = Ys[i - 1] + h * yFunc(z)
            z = Zs[i - 1] + h * zFunc(xCurrent, y, z)

        Ys.append(y)
        Zs.append(z)
        i += 1
        xCurrent += h
    return Ys[len(Ys) - 1]


def EulerKoshiMeth(xStart, xEnd, y0, z0, h):
    Zs = [z0]
    Ys = [y0]

    i = 1
    xCurrent = xStart
    while xCurrent < xEnd:
        Ym = Ys[i - 1] + h * yFunc(Zs[i - 1])
        Zm = Zs[i - 1] + h * zFunc(xCurrent, Ys[i - 1], Zs[i - 1])
        y = Ys[i - 1] + h * (yFunc(Zs[i - 1]) + yFunc(Zm)) / 2
        z = Zs[i - 1] + h * ((zFunc(xCurrent, Ys[i - 1], Zs[i - 1])) + (zFunc(xCurrent + h, Ym, Zm))) / 2
        Ys.append(y)
        Zs.append(z)
        i += 1
        xCurrent += h
    return Ys[len(Ys) - 1]


def BetterEulerMeth(xStart, xEnd, y0, z0, h):
    Zs = [z0]
    Ys = [y0]

    i = 1
    xCurrent = xStart
    while xCurrent < xEnd:
        Yh = Ys[i - 1] + h / 2 * yFunc(Zs[i - 1])
        Zh = Zs[i - 1] + h / 2 * zFunc(xCurrent, Ys[i - 1], Zs[i - 1])
        y = Ys[i - 1] + h * yFunc(Zh)
        z = Zs[i - 1] + h * zFunc(xCurrent + h / 2, Yh, Zh)
        Ys.append(y)
        Zs.append(z)
        i += 1
        xCurrent += h
    return Ys[len(Ys) - 1]


def RungeKuthyMeth(xStart, xEnd, y0, z0, h):
    Zs = [z0]
    Ys = [y0]

    i = 1
    xCurrent = xStart
    while xCurrent < xEnd:
        Ky1 = h * yFunc(Zs[i - 1])
        Kz1 = h * zFunc(xCurrent, Ys[i - 1], Zs[i - 1])
        Ky2 = h * yFunc(Zs[i - 1] + Kz1 / 2)
        Kz2 = h * zFunc(xCurrent + h / 2, Ys[i - 1] + Ky1 / 2, Zs[i - 1] + Kz1 / 2)
        Ky3 = h * yFunc(Zs[i - 1] + Kz2 / 2)
        Kz3 = h * zFunc(xCurrent + h / 2, Ys[i - 1] + Ky2 / 2, Zs[i - 1] + Kz2 / 2)
        Ky4 = h * yFunc(Zs[i - 1] + Kz3)
        Kz4 = h * zFunc(xCurrent + h, Ys[i - 1] + Ky3, Zs[i - 1] + Kz3)
        deltaY = (Ky1 + 2 * Ky2 + 2 * Ky3 + Ky4) / 6
        deltaZ = (Kz1 + 2 * Kz2 + 2 * Kz3 + Kz4) / 6
        Zs.append(Zs[i - 1] + deltaZ)
        Ys.append(Ys[i - 1] + deltaY)
        i += 1
        xCurrent += h
    return Ys[len(Ys) - 1]


print(RealEulerMeth(1, 2, 3, 2, 0.1))
print(UnrealEulerMeth(1, 2, 3, 2, 0.1))
print(EulerKoshiMeth(1, 2, 3, 2, 0.1))
print(BetterEulerMeth(1, 2, 3, 2, 0.1))
print(RungeKuthyMeth(1, 2, 3, 2, 0.1))
