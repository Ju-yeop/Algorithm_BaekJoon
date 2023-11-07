"""
15
1 5 3 2 6 3 2 6 4 2 5 7 3 1 5
"""
from sys import stdin

n = int(stdin.readline())
ls = list(map(int, stdin.readline().strip().split()))
line = []
answer = 0

def calLine(x1, y1, x2, y2):
    if y1 == y2:
        a = 0
    else: a = (y1 - y2) / (x1 - x2)
    b = y1 - a * x1
    return [a, b]

def judge(x, y):
    r = line[0] * x + line[1]
    if y >= r: return False
    else: return True

for i in range(n):
    result = 0
    for j in range(i-1, -1, -1):
        line = calLine(i, ls[i], j, ls[j])
        flag = True
        for v in range(i-1, j, - 1):
            if judge(v, ls[v]) is False:
                flag = False
                break
        if flag is True: result += 1

    for k in range(i+1, n):
        line = calLine(i, ls[i], k, ls[k])
        flag = True
        for v in range(i+1, k):
            if judge(v, ls[v]) is False:
                flag = False
                break
        if flag is True: result += 1

    answer = max(answer, result)

print(answer)