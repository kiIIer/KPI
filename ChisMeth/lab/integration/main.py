import math


def f(datax):
    datay = []
    for x in datax:
        value = 1 / (math.pow(x, 4) + 256)
        datay.append(value)
    return datay


def rightRectIntegrate(dataY, step):
    integral = 0

    i = 1
    while i < len(dataY):
        integral += dataY[i] * step
        i += 1
    return integral


def trapIntegrate(dataY, step):
    middleYes = 0

    i = 1
    while i < len(dataY) - 1:
        middleYes += dataY[i]
        i += 1
    integral = (step / 2) * (dataY[0] + dataY[len(dataY) - 1] + 2 * middleYes)

    return integral


def theSimpsons(dataY, step):
    oddYes = 0
    evenYes = 0

    i = 1
    while i < len(dataY) - 1:
        oddYes += dataY[i]
        i += 2

    i = 2
    while i < len(dataY) - 1:
        evenYes += dataY[i]
        i += 2
    integral = (step / 3) * (dataY[0] + dataY[len(dataY) - 1] + 4 * oddYes + 2 * evenYes)

    return integral


def runge(integralH, integralHH, p):
    integral = integralHH + (integralHH - integralH) / (math.pow(2, p) - 1)

    return integral


print("h")
dataX = [0, 1, 2, 3]
dataY = f(dataX)
recth = rightRectIntegrate(dataY, 1)
traph = trapIntegrate(dataY, 1)
simph = theSimpsons(dataY, 1)
print(recth)
print(traph)
print(simph)

print("h/2")
dataX = [0, 0.5, 1, 1.5, 2, 2.5, 3]
dataY = f(dataX)
recthh = rightRectIntegrate(dataY, 0.5)
traphh = trapIntegrate(dataY, 0.5)
simphh = theSimpsons(dataY, 0.5)
print(recthh)
print(traphh)
print(simphh)

print("rung")
print(runge(recth, recthh, 1))
print(runge(traph, traphh, 2))
print(runge(simph, simphh, 4))
