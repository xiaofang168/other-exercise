import random
temp = [i + 1 for i in range(35)]
print(temp)
random.shuffle(temp)
print(temp)
i = 0
list = []
while i < 7:
    list.append(temp[i])
    i = i + 1
list.sort()
print(list)
print(list[-1])