import math

from sympy import *

x = Symbol('x')
y = Symbol('y')
e = math.e

f = x ** 2 / 9 ** 2 + y ** 2 / (9 / 2) ** 2 - 1
g = 9.0 * y - e ** x - x
dfdx = f.diff(x)
dfdy = f.diff(y)
dgdx = g.diff(x)
dgdy = g.diff(y)
detJ = dfdx * dgdy - dfdy * dgdx
detAx = f * dgdy - g * dfdy
detAy = dfdx * g - f * dgdx

fl = lambdify([x, y], f)
gf = lambdify([x, y], g)
dfdxl = lambdify([x, y], dfdx)
dfdyl = lambdify([x, y], dfdy)
dgdxl = lambdify([x, y], dgdx)
dgdyl = lambdify([x, y], dgdy)
detJl = lambdify([x, y], detJ)
detAxl = lambdify([x, y], detAx)
detAyl = lambdify([x, y], detAy)

epx = 0.0001

x0 = 3
y0 = 4
xn = 0
yn = 0

while max(abs(x0 - xn), abs(y0 - yn)) > epx:
    xn = x0
    yn = y0
    x0 = xn - detAxl(xn, yn) / detJl(xn, yn)
    y0 = yn - detAyl(xn, yn) / detJl(xn, yn)

print("Mr. Isaac Newton Method")
print("x0")
print(x0)
print("y0")
print(y0)

phix = ln(9 * y - x)
phiy = ((1 - x ** 2 / 9 ** 2) * 4.5 ** 2) / y

phixl = lambdify([x, y], phix)
phiyl = lambdify([x, y], phiy)

x0 = 3
y0 = 4
xn = 0
yn = 0
i = 0
while i < 1000:
    xn = x0
    yn = y0
    x0 = phixl(xn, yn)
    y0 = phiyl(xn, yn)
    i += 1

print("Iterations")
print("x0")
print(x0)
print("y0")
print(y0)
