def checkPrime(number):
    isNotPrime = False

    for i in range(number):
        if (i < 2):
            continue
        if (number % i) == 0:
            isNotPrime = True
            break
    print("{} is not prime({})".format(number, isNotPrime))


print("Task 13. Prime")
checkPrime(13)
