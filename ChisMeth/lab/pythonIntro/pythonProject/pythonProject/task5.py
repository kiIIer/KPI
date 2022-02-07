def checkNumbers(a, b, c):
    first = (a < b) & (b < c)
    print("Statement a < b < c is {}" .format(first))
    second = (a > 0) | (b > 0) | (c > 0)
    print("Statement at least 1 number is positive is {}" .format(second))

    third = False
    if second:
        if a > 0 & (b <= 0 | c <= 0):
            third = True
        else:
            if b > 0 & ( a <= 0 | c <= 0):
                third = True
            else:
                if c > 0 & ( b <= 0 | c <= 0):
                    third = True
    print("Statement only 1 number is positive is {}" .format(third))


print("Task 5. Some numbers")
checkNumbers(-4, 0, 0)
