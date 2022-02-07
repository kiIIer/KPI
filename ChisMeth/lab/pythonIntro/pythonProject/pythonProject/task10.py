def inverter(a):
    aAsArray = []

    while True:
        if a == 0 :
            break
        print(a % 10, end = "")
        a = int(int(a)/int(10))
    print()


print("Task 10. Invert")
inverter(123)
