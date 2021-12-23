N = int(input())
plus = []
minus = []
result = 0

for i in range(N):
    temp = int(input())
    if temp == 1:
        result += 1
    elif temp > 0:
        plus.append(temp)
    else:
        minus.append(temp)

plus.sort()
minus.sort()
minus.reverse()

while len(plus) != 0:
    if len(plus) == 1:
        result += plus.pop()
    else:
        result += plus.pop() * plus.pop()

while len(minus) != 0:
    if len(minus) == 1:
        result += minus.pop()
    else:
        result += minus.pop() * minus.pop()

print(result)